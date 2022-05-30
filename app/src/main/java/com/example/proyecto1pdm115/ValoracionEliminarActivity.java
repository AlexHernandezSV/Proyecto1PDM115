package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ValoracionEliminarActivity extends AppCompatActivity {

    EditText editidVal;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valoracion_eliminar);
        controlhelper=new ControlBD (this);
        editidVal=(EditText)findViewById(R.id.editidVal);
    }

    public void eliminarValoracion(View v){
        String regEliminadas;
        Valoracion valoracion=new Valoracion();
        valoracion.setId_valoracion(editidVal.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarValoracion(valoracion);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}