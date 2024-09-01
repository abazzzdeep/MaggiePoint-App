package com.example.maggiepoint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HelpSupportActivity extends AppCompatActivity {

    private static final String ADMIN_EMAIL = "abhashdeeep@gmail.com";
    private static final String ADMIN_PHONE = "+91 9065682814";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_support);

        Button contactAdminButton = findViewById(R.id.button_contact_admin);

        contactAdminButton.setOnClickListener(v -> {
            // Open email client
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + ADMIN_EMAIL));
            startActivity(Intent.createChooser(emailIntent, "Contact Admin"));

            // Uncomment below lines to also open dialer
            // Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            // dialIntent.setData(Uri.parse("tel:" + ADMIN_PHONE));
            // startActivity(dialIntent);
        });
    }
}
