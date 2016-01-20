package com.example.sarthak.move;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {

    //public CallbackManager callbackmanager;
    CallbackManager callbackManager;
    //String[] foods={"hjlj","kjl"};
    LoginButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        loginButton=(LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getBaseContext(), "yo", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getBaseContext(),"cancel",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_SHORT).show();

            }
        });


    }




    public void schedule(View v)
    {
        Intent i=new Intent(MainActivity.this,events.class);
        startActivity(i);
        overridePendingTransition(0, 0);
    }

    public void category_search(View v)
    {
        Intent i=new Intent(MainActivity.this,categories_search_activity.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }
}
