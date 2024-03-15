package com.example.programaabejasuno;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity  {

  EditText  nomusa_;
  EditText pwd_;

  Button btnEntrar;
  Button btnRegresar;

  BasedeDatos bdus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         nomusa_=(EditText) findViewById(R.id.txtnomus);
         pwd_=(EditText) findViewById(R.id.txtclave);
         btnEntrar=(Button) findViewById(R.id.btnEntrar);
         btnRegresar=(Button) findViewById(R.id.btnRegresar);
         bdus= new BasedeDatos(this);

         btnRegresar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(Login.this,MainActivity.class));
                 finish();
             }
         });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean LoginId  = bdus.checharNomUsuarioInicioS(nomusa_.getText().toString(),pwd_.getText().toString());
                if(LoginId){
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                } else
                    Toast.makeText(Login.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
            }
        });


    }










}