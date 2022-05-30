package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OfertaAcademicaInsertarActivity extends Activity {
    ControlBD helper;
    EditText editidMatAct;
    EditText editidCiclo;
    EditText editidMat;
    EditText editidCoor;
    EditText editnombMatAct;
    EditText editCicloMatAct;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oferta_academica_insertar);
        helper = new ControlBD(this);
        editidMatAct = (EditText) findViewById(R.id.editIdMateriasA);
        editidCiclo = (EditText) findViewById(R.id.editIdCiclo);
        editidMat = (EditText) findViewById(R.id.editIdMateria);
        editidCoor = (EditText) findViewById(R.id.editIdCoordinador);
        editnombMatAct = (EditText) findViewById(R.id.editNombreMateriaA);
        editCicloMatAct = (EditText) findViewById(R.id.editCicloMateriaA);
    }

    public void insertarOfertaAcademica(View v) {
        String idMatActs = editidMatAct.getText().toString();
        String idCiclo = editidCiclo.getText().toString();
        String idMat = editidMat.getText().toString();
        String idCoor = editidCoor.getText().toString();
        String nombMatAct = editnombMatAct.getText().toString();
        String cicloMatAcr = editCicloMatAct.getText().toString();

        String regInsertados;
        OfertaAcademica oferta = new OfertaAcademica();
        oferta.setIdMateriasActivas(idMatActs);
        oferta.setIdCiclo(idCiclo);
        oferta.setIdMateria(idMat);
        oferta.setIdCoordinador(idCoor);
        oferta.setNombreMateriasActivas(nombMatAct);
        oferta.setCicloMateriaActiva(cicloMatAcr);
        helper.abrir();
        regInsertados=helper.insertarOfertaAcademica(oferta);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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