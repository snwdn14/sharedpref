package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText Username;
    EditText Password;
    EditText Confirm_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Username = findViewById(R.id.Create_user);
        Password = findViewById(R.id.Create_pass);
        Confirm_pass = findViewById(R.id.Create_pass2);

    }

    public void Signup(View view) {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String newUser = Username.getText().toString();
        String newPassword = Password.getText().toString();
        String newConfirmPass = Confirm_pass.getText().toString();

        if (TextUtils.isEmpty(newUser) || TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(newConfirmPass)) {
            Toast.makeText(this, "Some Fields is Empty.", Toast.LENGTH_LONG).show();
        }
        else {
            if (!newConfirmPass.equals(newPassword)) {
                Toast.makeText(this, "Password not matched.", Toast.LENGTH_LONG).show();
            }
            else {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newUser + newPassword + "data", newUser);
                editor.commit();
                Intent intent = new Intent(Signup.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}