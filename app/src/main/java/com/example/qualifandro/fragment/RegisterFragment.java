package com.example.qualifandro.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.qualifandro.R;
import com.example.qualifandro.model.User;
import com.example.qualifandro.storage.UserStorage;
import com.google.android.material.tabs.TabLayout;

public class RegisterFragment extends Fragment {

    private EditText etFullName, etEmail, etPassword;
    private Switch sPassword;
    private RadioButton rbMale, rbFemale;
    private CheckBox cbTerms;
    private Button btnRegister;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etFullName = requireView().findViewById(R.id.register_full_name);
        etEmail = requireView().findViewById(R.id.register_email);
        etPassword = requireView().findViewById(R.id.register_password);

        sPassword = requireView().findViewById(R.id.register_password_switch);
        rbMale = requireView().findViewById(R.id.register_gender_male);
        rbFemale = requireView().findViewById(R.id.register_gender_female);

        cbTerms = requireView().findViewById(R.id.register_checkbox);
        btnRegister = requireView().findViewById(R.id.register_button);

        sPassword.setOnCheckedChangeListener((compoundButton, b) -> {
            etPassword.setTransformationMethod(!b ? new PasswordTransformationMethod() : null);
        });

        btnRegister.setOnClickListener(v -> {
            String fullName = etFullName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String gender = (rbMale.isChecked() ? "Male" : rbFemale.isChecked() ? "Female" : "");
            boolean isAgree = cbTerms.isChecked();

            Log.d("input-name", fullName);
            Log.d("input-email", email);
            Log.d("input-pass", password);
            Log.d("input-gender", gender);
            Log.d("input-agree", String.valueOf(isAgree));

            if (!isAgree) {
                Toast.makeText(getActivity(), "You have to agree with the terms", Toast.LENGTH_SHORT).show();
                return;
            }

            new AlertDialog.Builder(getActivity())
                    .setTitle("Confirmation")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("Are you sure?\n" +
                            fullName + "\n" +
                            email + "\n" +
                            password + "\n" +
                            gender)
                    .setPositiveButton("SURE", (dialogInterface, i) -> {
                        UserStorage.user = new User(fullName, email, password, gender);
                        Toast.makeText(getActivity(), "Register Success!", Toast.LENGTH_LONG).show();
                        etFullName.setText("");
                        etEmail.setText("");
                        etPassword.setText("");
                        rbMale.setChecked(false);
                        rbFemale.setChecked(false);
                        cbTerms.setChecked(false);
                    })
                    .setNegativeButton("CANCEL", null)
                    .show();
        });
    }

}