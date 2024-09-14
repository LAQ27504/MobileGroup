package vn.edu.usth.stockdashboard;

import android.view.GestureDetector;
import android.view.MotionEvent;

class TapGestureListener extends GestureDetector.SimpleOnGestureListener{

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }
}
