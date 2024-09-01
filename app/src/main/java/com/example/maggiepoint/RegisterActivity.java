package com.example.maggiepoint;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText name, email, password, phone;
    private Button register;
    private FirebaseAuth auth;
    private DatabaseReference reference;
    private ProgressBar progressBar; // Use ProgressBar instead of ProgressDialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.register);
        progressBar = findViewById(R.id.progressBar); // Initialize ProgressBar

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(v -> {
            String txt_name = name.getText().toString();
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();
            String txt_phone = phone.getText().toString();

            if (TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_phone)) {
                Toast.makeText(RegisterActivity.this, "Empty credentials", Toast.LENGTH_SHORT).show();
            } else if (txt_password.length() < 6) {
                Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(txt_name, txt_email, txt_password, txt_phone);
            }
        });
    }

    private void registerUser(final String name, final String email, String password, final String phone) {
        progressBar.setVisibility(View.VISIBLE); // Show ProgressBar

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, task -> {
            progressBar.setVisibility(View.GONE); // Hide ProgressBar

            if (task.isSuccessful()) {
                String userId = auth.getCurrentUser().getUid();
                reference = FirebaseDatabase.getInstance().getReference("users").child(userId);

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("id", userId);
                hashMap.put("name", name);
                hashMap.put("email", email);
                hashMap.put("phone", phone);

                reference.setValue(hashMap).addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registering user successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Failed to save user data", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
