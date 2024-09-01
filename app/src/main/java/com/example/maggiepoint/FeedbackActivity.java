package com.example.maggiepoint;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private EditText feedbackEditText;
    private Button submitFeedbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Initialize the views
        feedbackEditText = findViewById(R.id.editTextFeedback);
        submitFeedbackButton = findViewById(R.id.buttonSubmitFeedback);

        // Set up the submit button click listener
        submitFeedbackButton.setOnClickListener(v -> {
            String feedback = feedbackEditText.getText().toString();

            if (!feedback.isEmpty()) {
                // Normally, you would send the feedback to your server or process it here
                Toast.makeText(FeedbackActivity.this, "Feedback submitted: " + feedback, Toast.LENGTH_LONG).show();
                feedbackEditText.setText(""); // Clear the input field
            } else {
                Toast.makeText(FeedbackActivity.this, "Please enter feedback before submitting.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
