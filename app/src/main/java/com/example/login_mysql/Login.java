package com.example.login_mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Spanned;
import android.content.Intent;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText emailtext,passwordtext;
    Button LoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initCreateAccountTextView();

        emailtext = findViewById(R.id.Email);
        passwordtext = findViewById(R.id.Password);
        LoginButton = findViewById(R.id.Login);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailtext.getText().toString();
                String password = passwordtext.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    new AuthenticationTask().execute(email, password);
                } else {
                    Toast.makeText(Login.this, "Isi semua kolom!", Toast.LENGTH_SHORT).show();
                }
                if (email.equals("admin@gmail.com") && password.equals("admin123")) {
                    // Admin login successful
                    Snackbar.make(LoginButton, "Selamat Datang Admin ", Snackbar.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Admin.class);
                    // Data username diambil menuju ke activity2
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(Html.fromHtml("<font color='#FF000000'>I don't have account yet. </font><font color='#0c0099'>create one</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
    private class AuthenticationTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {


            } catch (Exception e) {
                return "exception";
            }
            return null;
        }
    }

}
