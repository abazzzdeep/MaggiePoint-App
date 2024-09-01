package com.example.maggiepoint;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TermsConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);

        // Find the TextView by ID
        TextView termsTextView = findViewById(R.id.terms_conditions_text);

        // Set the terms and conditions text
        String termsAndConditions = "Terms & Conditions\n\n" +
                "1. **Acceptance of Terms**\n" +
                "   By using this application, you agree to comply with and be bound by these terms and conditions.\n\n" +
                "2. **Changes to Terms**\n" +
                "   We may update these terms from time to time. It is your responsibility to review these terms periodically.\n\n" +
                "3. **User Responsibilities**\n" +
                "   You agree to use this application for lawful purposes and in accordance with applicable laws.\n\n" +
                "4. **Intellectual Property**\n" +
                "   All content and materials provided by this application are owned by us or our licensors.\n\n" +
                "5. **Limitation of Liability**\n" +
                "   We are not liable for any damages arising from the use of this application.\n\n" +
                "6. **Contact Information**\n" +
                "   If you have any questions about these terms, please contact us at: abhashdeeep@gmail.com.\n";

        // Set the text to the TextView
        termsTextView.setText(termsAndConditions);
    }
}
