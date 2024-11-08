package vn.edu.usth.stockdashboard.AppFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import vn.edu.usth.stockdashboard.DatabaseHelper;
import vn.edu.usth.stockdashboard.MainActivity;
import vn.edu.usth.stockdashboard.R;

public class ProfileFragment extends Fragment {
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(getActivity());

        // Retrieve the currently logged-in username
        String username = databaseHelper.getLoggedInUser();
        Log.d("ProfileFragment", "Logged-in username: " + username);

        // Retrieve full name from the database
        String fullname = databaseHelper.getFullName(username);
        Log.d("ProfileFragment", "Retrieved full name: " + fullname);

        // Set the retrieved data to the TextViews
        TextView profileNameTextView = view.findViewById(R.id.profile_name);
        TextView profileUsernameTextView = view.findViewById(R.id.profile_username);

        // Update TextViews with user data, handling potential null values
        if (profileNameTextView != null) {
            profileNameTextView.setText(fullname != null ? fullname : "Unknown");
        } else {
            Log.e("ProfileFragment", "profileNameTextView is null");
        }

        if (profileUsernameTextView != null) {
            profileUsernameTextView.setText(username != null ? username : "Unknown User");
        } else {
            Log.e("ProfileFragment", "profileUsernameTextView is null");
        }

        // Set up button listeners
        setupButtonListeners(view);

        return view;
    }

    private void setupButtonListeners(View view) {
        LinearLayout helpButton = view.findViewById(R.id.help_button);
        LinearLayout conditionsButton = view.findViewById(R.id.term_and_conditions_button);
        LinearLayout logoutButton = view.findViewById(R.id.logout_button);

        if (helpButton != null) {
            helpButton.setOnClickListener(v -> {
                Log.i("ProfileFragment", "Help button clicked");
                switchFragment(new HelpAndResourcesFragment());
            });
        } else {
            Log.e("ProfileFragment", "helpButton is null");
        }

        if (conditionsButton != null) {
            conditionsButton.setOnClickListener(v -> {
                Log.i("ProfileFragment", "Terms and Conditions button clicked");
                switchFragment(new TermsAndConditionsFragment());
            });
        } else {
            Log.e("ProfileFragment", "conditionsButton is null");
        }

        if (logoutButton != null) {
            logoutButton.setOnClickListener(v -> {
                // Log out the user
                databaseHelper.logout();
                Log.d("ProfileFragment", "User logged out successfully.");

                // Navigate back to LoginFragment
                FragmentManager fragmentManager = getParentFragmentManager();
                if (fragmentManager != null) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Log.e("ProfileFragment", "FragmentManager is null");
                }
            });
        } else {
            Log.e("ProfileFragment", "logoutButton is null");
        }
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null); // Optionally add to back stack
            fragmentTransaction.commit();
        } else {
            Log.e("ProfileFragment", "FragmentManager is null");
        }
    }
}
