package com.example.proyecto1pdm115;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OfertaAcademicaActualizarActivity extends Activity {
    ControlBD helper;
    EditText editidMatAct;
    EditText editidCiclo;
    EditText editidMat;
    EditText editidCoor;
    EditText editnombMatAct;
    EditText editCicloMatAct;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oferta_academica_actualizar);
        helper = new ControlBD(this);
        editidMatAct = (EditText) findViewById(R.id.editIdMateriasA);
        editidCiclo = (EditText) findViewById(R.id.editIdCiclo);
        editidMat = (EditText) findViewById(R.id.editIdMateria);
        editidCoor = (EditText) findViewById(R.id.editIdCoordinador);
        editnombMatAct = (EditText) findViewById(R.id.editNombreMateriaA);
        editCicloMatAct = (EditText) findViewById(R.id.editCicloMateriaA);

    }
    public void actualizarOfertaAcademica(View v) {

        OfertaAcademica oferta = new OfertaAcademica();
        oferta.setIdMateriasActivas(editidMatAct.getText().toString());
        oferta.setIdCiclo(editidCiclo.getText().toString());
        oferta.setIdMateria(editidMat.getText().toString());
        oferta.setIdCoordinador(editidCoor.getText().toString());
        oferta.setNombreMateriasActivas(editnombMatAct.getText().toString());
        oferta.setCicloMateriaActiva(editCicloMatAct.getText().toString());

        helper.abrir();
        String estado = helper.actualizarOfertaAcademica(oferta);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editidMatAct.setText("");
        editidCiclo.setText("");
        editidMat.setText("");
        editidCoor.setText("");
        editnombMatAct.setText("");
        editCicloMatAct.setText("");
    }
}