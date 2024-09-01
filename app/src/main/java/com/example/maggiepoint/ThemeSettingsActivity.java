package com.example.maggiepoint;

import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeSettingsActivity extends AppCompatActivity {

    private Switch themeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_settings);

        themeSwitch = findViewById(R.id.switch_theme);

        // Set a listener to handle switch toggle
        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Handle toggle action here (e.g., save preference or change UI element)
            // For now, just print a message or perform a dummy action
            if (isChecked) {
                // Code to execute when switch is turned on (e.g., log or update UI)
                System.out.println("Dark Theme Enabled");
            } else {
                // Code to execute when switch is turned off (e.g., log or update UI)
                System.out.println("Dark Theme Disabled");
            }
        });

        // Apply insets for edge-to-edge support if needed

    }
}
