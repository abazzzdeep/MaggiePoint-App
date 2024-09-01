package com.example.maggiepoint;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacySettingsActivity extends AppCompatActivity {

    private Switch profileVisibilitySwitch;
    private Switch activityVisibilitySwitch;
    private Switch thirdPartySharingSwitch;
    private Switch advertisingPreferencesSwitch;
    private Button exportDataButton;
    private Button deleteAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_settings);

        profileVisibilitySwitch = findViewById(R.id.switch_profile_visibility);
        activityVisibilitySwitch = findViewById(R.id.switch_activity_visibility);
        thirdPartySharingSwitch = findViewById(R.id.switch_third_party_sharing);
        advertisingPreferencesSwitch = findViewById(R.id.switch_advertising_preferences);
        exportDataButton = findViewById(R.id.button_export_data);
        deleteAccountButton = findViewById(R.id.button_delete_account);

        // Set listeners for buttons
        exportDataButton.setOnClickListener(v -> {
            // Handle data export
            // Placeholder for export functionality
            System.out.println("Export Data clicked");
        });

        deleteAccountButton.setOnClickListener(v -> {
            // Handle account deletion
            // Placeholder for delete account functionality
            System.out.println("Delete Account clicked");
        });

        // Set listeners for switches if needed
        profileVisibilitySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle profile visibility change
            System.out.println("Profile Visibility: " + isChecked);
        });

        activityVisibilitySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle activity visibility change
            System.out.println("Activity Visibility: " + isChecked);
        });

        thirdPartySharingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle third-party sharing change
            System.out.println("Third-Party Sharing: " + isChecked);
        });

        advertisingPreferencesSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle advertising preferences change
            System.out.println("Advertising Preferences: " + isChecked);
        });
    }
}
