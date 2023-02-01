package com.example.qualifandro.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

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

import com.example.qualifandro.MainActivity;
import com.example.qualifandro.R;
import com.example.qualifandro.storage.UserStorage;

public class LoginFragment extends Fragment {

    private EditText etEmail, etPassword;
    private Switch sPassword;
    private Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etEmail = requireView().findViewById(R.id.login_email);
        etPassword = requireView().findViewById(R.id.login_password);

        sPassword = requireView().findViewById(R.id.login_password_switch);

        btnLogin = requireView().findViewById(R.id.login_button);

        sPassword.setOnCheckedChangeListener((compoundButton, b) -> {
            etPassword.setTransformationMethod(!b ? new PasswordTransformationMethod() : null);
        });

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                return;
            }

            if(UserStorage.user.getEmail().equals(email) && UserStorage.user.getPassword().equals(password)){
                Toast.makeText(getActivity(), "Login Success!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("user", UserStorage.user);
                startActivity(intent);
            } else{
                Toast.makeText(getActivity(), "Invalid email or password!", Toast.LENGTH_LONG).show();

            }

        });
    }
}