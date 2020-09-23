package com.kytom.loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText usuario, contraseña;
    Button boton;

    //Para mostrar
    TextView view_usuario, view_contraseña;

    //User preferences
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usuario = findViewById(R.id.Usuario);
        contraseña = findViewById(R.id.Contraseña);
        boton = findViewById(R.id.Boton);

        //Mostrar

        //Preferences
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        //
        String name = sharedPreferences.getString("USER", null);

        if(name != null){
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

                String user2 = usuario.getText().toString();
                String pass2 = contraseña.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("USER", user2);
                editor.putString("PASSWORD", pass2);
                //text_usuario.setText(user2);
                //text_contrasena.setText(pass2);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }
        });
    }

}