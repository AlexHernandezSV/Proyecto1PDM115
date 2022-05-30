package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LocalEliminarActivity extends AppCompatActivity {
    ControlBD controlhelper;
    EditText editidAula;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_eliminar);
        controlhelper=new ControlBD (this);
        editidAula = (EditText) findViewById(R.id.editIdAula);

    }

    public void eliminarLocal(View v){
        String regEliminadas;

        Local local = new Local();

        local.setIdAula(editidAula.getText().toString());

        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarLocal(local);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}