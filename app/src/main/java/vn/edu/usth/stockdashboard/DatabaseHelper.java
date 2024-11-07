package vn.edu.usth.stockdashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "SignLog.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT, fullname TEXT, loggedIn INTEGER DEFAULT 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        onCreate(MyDB);
    }

    // Method to insert new user data
    public Boolean insertData(String username, String password, String fullname) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("username", username);
        contentValues.put("password", password);
        return MyDatabase.insert("users", null, contentValues) != -1;
    }

    // Method to check if a username exists
    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    // Method to check if username and password are correct
    public Boolean checkPassword(String username, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    // Method to get the full name of a user
    public String getFullName(String username) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT fullname FROM users WHERE username = ?", new String[]{username});
        String fullName = cursor.moveToFirst() ? cursor.getString(0) : null;
        cursor.close();
        return fullName;
    }

    // Method to set a user as logged in
    public void setLoggedInUser(String username) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();

        // Reset all users' loggedIn status to 0 first to ensure only one user is logged in at a time
        ContentValues resetValues = new ContentValues();
        resetValues.put("loggedIn", 0);
        MyDatabase.update("users", resetValues, null, null);

        // Set loggedIn to 1 for the current user
        ContentValues contentValues = new ContentValues();
        contentValues.put("loggedIn", 1);
        MyDatabase.update("users", contentValues, "username = ?", new String[]{username});
    }

    // Method to get the currently logged-in user
    public String getLoggedInUser() {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT username FROM users WHERE loggedIn = 1 LIMIT 1", null);
        String username = cursor.moveToFirst() ? cursor.getString(0) : null;
        cursor.close();
        return username;
    }

    // Method to log out all users by resetting the loggedIn status
    public void logout() {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("loggedIn", 0);
        MyDatabase.update("users", contentValues, null, null);
    }
}
