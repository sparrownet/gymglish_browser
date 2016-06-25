package com.davidi.gymglishbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText) findViewById(R.id.input_username);
        mPassword = (EditText) findViewById(R.id.input_password);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        TextView btnAbout = (TextView) findViewById(R.id.about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String about = "Designed and Implemented by Dror Davidi\n\n" +
                        "Email: drordavidi@gmail.com\n" +
                        "Phone: +972-52-3306047\n" +
                        "(c) all rights reserved, Jun 2016";
                Toast.makeText(getApplicationContext(), about, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void login() {
        if (!validateLogin()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), LinksActivity.class);
        startActivity(intent);
    }

    private boolean validateLogin() {

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        // check for valid credentials
        if ( !TextUtils.equals(username, LoginDetails.LOGIN_USERNAME) ||
                !TextUtils.equals(password, LoginDetails.LOGIN_PASSWORD )) {

            Toast.makeText(this, getString(R.string.err_msg_credentials), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
