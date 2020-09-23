package com.kytom.loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView text_usuario, text_contraseña;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "preferencias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        text_usuario = findViewById(R.id.text_usuario);
        text_contraseña = findViewById(R.id.text_contraseña);
        cargarPreferencias();

    }

    private void cargarPreferencias(){
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String user_get = sharedPreferences.getString("USER","No Data");
        String pass_get = sharedPreferences.getString("PASSWORD","No Datas");
        text_usuario.setText(user_get);
        text_contraseña.setText(pass_get);

    }
}