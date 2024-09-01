package com.example.maggiepoint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private TextView displayNameTextView, displayEmailTextView, displayPhoneTextView;
    private EditText nameEditText, emailEditText, phoneEditText;
    private Button saveButton, editButton;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        displayNameTextView = view.findViewById(R.id.display_name);
        displayEmailTextView = view.findViewById(R.id.display_email);
        displayPhoneTextView = view.findViewById(R.id.display_phone);
        nameEditText = view.findViewById(R.id.profile_name);
        emailEditText = view.findViewById(R.id.profile_email);
        phoneEditText = view.findViewById(R.id.profile_phone);
        saveButton = view.findViewById(R.id.save_button);
        editButton = view.findViewById(R.id.edit_button);
        progressBar = view.findViewById(R.id.progress_bar);  // Ensure this matches your XML ID

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Load user profile
        loadProfile();

        // Save button action
        saveButton.setOnClickListener(v -> saveProfile());

        // Edit button action
        editButton.setOnClickListener(v -> enableEditing());

        return view;
    }

    private void loadProfile() {
        String userId = mAuth.getCurrentUser().getUid();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);  // Show ProgressBar
        }

        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String email = dataSnapshot.child("email").getValue(String.class);
                    String phone = dataSnapshot.child("phone").getValue(String.class);

                    // Display current profile info
                    displayNameTextView.setText(name);
                    displayEmailTextView.setText(email);
                    displayPhoneTextView.setText(phone);

                    // Set values to EditTexts
                    nameEditText.setText(name);
                    emailEditText.setText(email);
                    phoneEditText.setText(phone);
                }
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);  // Hide ProgressBar
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors
                Toast.makeText(getContext(), "Failed to load profile", Toast.LENGTH_SHORT).show();
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);  // Hide ProgressBar
                }
            }
        });
    }

    private void saveProfile() {
        String userId = mAuth.getCurrentUser().getUid();
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        mDatabase.child("users").child(userId).child("name").setValue(name);
        mDatabase.child("users").child(userId).child("email").setValue(email);
        mDatabase.child("users").child(userId).child("phone").setValue(phone);

        // Update displayed profile info
        displayNameTextView.setText(name);
        displayEmailTextView.setText(email);
        displayPhoneTextView.setText(phone);

        // Disable editing
        disableEditing();
        Toast.makeText(getContext(), "Profile updated", Toast.LENGTH_SHORT).show();
    }

    private void enableEditing() {
        // Hide TextViews and show EditTexts
        displayNameTextView.setVisibility(View.GONE);
        displayEmailTextView.setVisibility(View.GONE);
        displayPhoneTextView.setVisibility(View.GONE);
        nameEditText.setVisibility(View.VISIBLE);
        emailEditText.setVisibility(View.VISIBLE);
        phoneEditText.setVisibility(View.VISIBLE);
        saveButton.setVisibility(View.VISIBLE);
        editButton.setVisibility(View.GONE);
    }

    private void disableEditing() {
        // Hide EditTexts and show TextViews
        nameEditText.setVisibility(View.GONE);
        emailEditText.setVisibility(View.GONE);
        phoneEditText.setVisibility(View.GONE);
        saveButton.setVisibility(View.GONE);
        editButton.setVisibility(View.VISIBLE);
        displayNameTextView.setVisibility(View.VISIBLE);
        displayEmailTextView.setVisibility(View.VISIBLE);
        displayPhoneTextView.setVisibility(View.VISIBLE);
    }
}
