package vn.edu.usth.stockdashboard.AppFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import vn.edu.usth.stockdashboard.DatabaseHelper;
import vn.edu.usth.stockdashboard.MainActivity;
import vn.edu.usth.stockdashboard.databinding.FragmentLoginBinding;
import vn.edu.usth.stockdashboard.R;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        databaseHelper = new DatabaseHelper(getContext());

        binding.loginButton.setOnClickListener(view -> {
            String username = binding.loginUsername.getText().toString();
            String password = binding.loginPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "All fields are mandatory", Toast.LENGTH_SHORT).show();
            } else {
                if (databaseHelper.checkPassword(username, password)) {
                    Toast.makeText(getActivity(), "Login Successfully!", Toast.LENGTH_SHORT).show();

                    // Set the logged-in user
                    databaseHelper.setLoggedInUser(username);

                    Fragment currentFragment = getParentFragmentManager().findFragmentById(R.id.fragment_container);

//                    // Check if the current fragment is not MainAppFragment
//                    if (currentFragment == null || !(currentFragment instanceof MainAppFragment)) {
//                        // If it's not MainAppFragment, replace it with the MainAppFragment
//                        getParentFragmentManager().beginTransaction()
//                                .replace(R.id.fragment_container, MainActivity.getInstance().getMainAppFragment())
//                                .commitAllowingStateLoss();
//                    }

                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, MainActivity.getInstance().getMainAppFragment())
                            .commit();
//                    getParentFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container, new ProfileFragment())
//                            .addToBackStack(null)
//                            .commit();
                } else {
                    Toast.makeText(getActivity(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.signupRedirectText.setOnClickListener(view -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SignupFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
