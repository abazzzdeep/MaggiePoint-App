package com.example.maggiepoint;

import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationSettingsActivity extends AppCompatActivity {

    private Switch emailNotificationsSwitch;
    private Switch smsNotificationsSwitch;
    private Switch pushNotificationsSwitch;
    private Switch inAppNotificationsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        // Initialize switches
        emailNotificationsSwitch = findViewById(R.id.switch_email_notifications);
        smsNotificationsSwitch = findViewById(R.id.switch_sms_notifications);
        pushNotificationsSwitch = findViewById(R.id.switch_push_notifications);
        inAppNotificationsSwitch = findViewById(R.id.switch_in_app_notifications);

        // Set listeners to react to toggle changes
        emailNotificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Dummy toggle action
        });

        smsNotificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Dummy toggle action
        });

        pushNotificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Dummy toggle action
        });

        inAppNotificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Dummy toggle action
        });
    }
}
