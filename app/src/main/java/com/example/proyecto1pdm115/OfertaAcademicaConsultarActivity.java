package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class OfertaAcademicaConsultarActivity extends Activity {
  ControlBD helper;
    EditText editidMatAct;
    EditText editidCiclo;
    EditText editidMat;
    EditText editidCoor;
    EditText editnombMatAct;
    EditText editCicloMatAct;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta_academica_consultar);
        helper = new ControlBD(this);
        editidMatAct = (EditText) findViewById(R.id.editIdMateriasA);
        editidCiclo = (EditText) findViewById(R.id.editIdCiclo);
        editidMat = (EditText) findViewById(R.id.editIdMateria);
        editidCoor = (EditText) findViewById(R.id.editIdCoordinador);
        editnombMatAct = (EditText) findViewById(R.id.editNombreMateriaA);
        editCicloMatAct = (EditText) findViewById(R.id.editCicloMateriaA);

    }
    public void consultarOfertaAcademica(View v) {
        helper.abrir();
        OfertaAcademica oferta = helper.consultarOfertaAcademica(editidMatAct.getText().toString());
        helper.cerrar();
        if(oferta == null)
            Toast.makeText(this, "Materia Activa con identificador " +
                    editidMatAct.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{
            editidCiclo.setText(oferta.getIdCiclo());
            editidMat.setText(oferta.getIdMateria());
            editidCoor.setText(oferta.getIdCoordinador());
            editnombMatAct.setText(oferta.getNombreMateriasActivas());
            editCicloMatAct.setText(oferta.getCicloMateriaActiva());

        }
    }

    public void limpiarTexto(View v){
        editidMatAct.setText("");
        editidCiclo.setText("");
        editidMat.setText("");
        editidCoor.setText("");
        editnombMatAct.setText("");
        editCicloMatAct.setText("");
    }
}