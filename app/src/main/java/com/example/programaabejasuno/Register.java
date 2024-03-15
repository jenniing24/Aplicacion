package com.example.programaabejasuno;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Switch;
import android.database.sqlite.SQLiteDatabase;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Register extends AppCompatActivity  {

    EditText nomus_, clv;

    Button btnRegistrar;
    Button btnCancelar;

    BasedeDatos dbus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nomus_=(EditText) findViewById(R.id.txtnomus);
        clv=(EditText) findViewById(R.id.txtclave);
        btnRegistrar=(Button) findViewById(R.id.btnRegistrarmeN);
        btnCancelar =(Button) findViewById(R.id.btnAtras);
        dbus = new BasedeDatos(this);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,MainActivity.class));
               finish();
            }
        });



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pwd;
                user = nomus_.getText().toString();
                pwd = clv.getText().toString();
                if (user.equals("") || pwd.equals("")) {
                    Toast.makeText(Register.this, "Rellenar todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    if (pwd.equals(pwd)){
                        if(dbus.checarUsuario(user)){
                            Toast.makeText(Register.this, "El usuario ya existe", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean registeredSucess = dbus.insertData(user, pwd);
                        if (registeredSucess)
                            Toast.makeText(Register.this, "Te has registrado correctamente", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register.this, "Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Register.this, "Te has registrado correctamente", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });


    }





}