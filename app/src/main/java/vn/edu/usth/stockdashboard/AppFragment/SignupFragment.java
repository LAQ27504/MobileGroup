package vn.edu.usth.stockdashboard.AppFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import vn.edu.usth.stockdashboard.R;

import vn.edu.usth.stockdashboard.DatabaseHelper;
import vn.edu.usth.stockdashboard.databinding.FragmentSignupBinding;

public class SignupFragment extends Fragment {

    private FragmentSignupBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        databaseHelper = new DatabaseHelper(getContext());

        // Sign-up button logic
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.signupUsername.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String fullname = binding.signupFullname.getText().toString();
                String confirmPassword = binding.signupConfirm.getText().toString();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(getContext(), "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmPassword)) {
                        Boolean checkUsername = databaseHelper.checkUsername(username);
                        if (!checkUsername) {
                            Boolean insert = databaseHelper.insertData(username, password, fullname);
                            if (insert) {
                                Toast.makeText(getContext(), "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                // Navigate to LoginFragment after successful signup
                                navigateToLoginFragment();
                            } else {
                                Toast.makeText(getContext(), "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }

    private void navigateToLoginFragment() {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new LoginFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
