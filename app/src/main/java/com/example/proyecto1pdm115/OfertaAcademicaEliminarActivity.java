package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class OfertaAcademicaEliminarActivity extends Activity {
    ControlBD controlhelper;
    EditText editidMatAct;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta_academica_eliminar);
        controlhelper=new ControlBD (this);
        editidMatAct = (EditText) findViewById(R.id.editIdMateriasA);

    }

    public void eliminarOfertaAcademica(View v){
        String regEliminadas;

        OfertaAcademica oferta = new OfertaAcademica();

        oferta.setIdMateriasActivas(editidMatAct.getText().toString());

        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarOfertaAcademica(oferta);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}