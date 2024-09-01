package com.example.maggiepoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {

    private Button logoutButton;
    private TextView changePasswordText, updateProfileText, notificationSettingsText,
            appThemeText, privacySettingsText, helpSupportText, termsConditionsText,
            feedbackText, aboutText;
    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Initialize UI components
        logoutButton = view.findViewById(R.id.logoutButton);
        changePasswordText = view.findViewById(R.id.changePasswordText);
        updateProfileText = view.findViewById(R.id.updateProfileText);
        notificationSettingsText = view.findViewById(R.id.notificationSettingsText);
        appThemeText = view.findViewById(R.id.appThemeText);
        privacySettingsText = view.findViewById(R.id.privacySettingsText);
        helpSupportText = view.findViewById(R.id.helpSupportText);
        termsConditionsText = view.findViewById(R.id.termsConditionsText);
        feedbackText = view.findViewById(R.id.feedbackText);
        aboutText = view.findViewById(R.id.aboutText);

        // Set click listeners
        logoutButton.setOnClickListener(v -> logout());
        changePasswordText.setOnClickListener(v -> openChangePasswordActivity());
        updateProfileText.setOnClickListener(v -> openUpdateProfileFragment());
        notificationSettingsText.setOnClickListener(v -> openNotificationSettingsActivity());
        appThemeText.setOnClickListener(v -> openAppThemeActivity());
        privacySettingsText.setOnClickListener(v -> openPrivacySettingsActivity());
        helpSupportText.setOnClickListener(v -> openHelpSupportActivity());
        termsConditionsText.setOnClickListener(v -> openTermsConditionsActivity());
        feedbackText.setOnClickListener(v -> openFeedbackActivity());
        aboutText.setOnClickListener(v -> openAboutActivity());

        return view;
    }

    private void logout() {
        // Sign out from Firebase
        auth.signOut();

        // Update the login state in SharedPreferences
        saveLoginState(false);

        // Navigate to LoginActivity
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        getActivity().finish();
    }

    private void saveLoginState(boolean isLoggedIn) {
        SharedPreferences preferences = getActivity().getSharedPreferences("user_prefs", getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }

    private void openChangePasswordActivity() {
        Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
        startActivity(intent);
    }

    private void openUpdateProfileFragment() {
        Fragment profileFragment = new ProfileFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, profileFragment);
        fragmentTransaction.addToBackStack(null); // Optional: add the transaction to the back stack
        fragmentTransaction.commit();
    }

    private void openNotificationSettingsActivity() {
        Intent intent = new Intent(getActivity(), NotificationSettingsActivity.class);
        startActivity(intent);
    }

    private void openAppThemeActivity() {
        Intent intent = new Intent(getActivity(), ThemeSettingsActivity.class);
        startActivity(intent);
    }

    private void openPrivacySettingsActivity() {
        Intent intent = new Intent(getActivity(), PrivacySettingsActivity.class);
        startActivity(intent);
    }

    private void openHelpSupportActivity() {
        Intent intent = new Intent(getActivity(), HelpSupportActivity.class);
        startActivity(intent);
    }

    private void openTermsConditionsActivity() {
        Intent intent = new Intent(getActivity(), TermsConditionsActivity.class);
        startActivity(intent);
    }

    private void openFeedbackActivity() {
        Intent intent = new Intent(getActivity(), FeedbackActivity.class);
        startActivity(intent);
    }

    private void openAboutActivity() {
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }
}
