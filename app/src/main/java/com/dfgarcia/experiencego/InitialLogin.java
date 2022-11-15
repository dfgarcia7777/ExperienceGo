package com.dfgarcia.experiencego;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dfgarcia.experiencego.databinding.ActivityInitialLoginBinding;

public class InitialLogin extends AppCompatActivity {

    private ActivityInitialLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_login);
        //
        binding = ActivityInitialLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setListeners();
    }
    private void setListeners(){

    binding.btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(InitialLogin.this,"Login",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(InitialLogin.this,Login.class);
            startActivity(intent);
        }
    });
    }
}