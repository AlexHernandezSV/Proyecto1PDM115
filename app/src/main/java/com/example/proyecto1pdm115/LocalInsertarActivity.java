package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LocalInsertarActivity extends Activity {
    ControlBD helper;
    EditText editidAula;
    EditText editidRes;
    EditText editNomAula;
    EditText editCupo;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_local_insertar);
        helper = new ControlBD(this);
        editidAula = (EditText) findViewById(R.id.editIdAula);
        editidRes = (EditText) findViewById(R.id.editIdReservante);
        editNomAula = (EditText) findViewById(R.id.editNombreLocal);
        editCupo = (EditText) findViewById(R.id.editCupo);

    }

    public void insertarLocal(View v) {
        String idAula = editidAula.getText().toString();
        String idRes = editidRes.getText().toString();
        String nomAula = editNomAula.getText().toString();
        int cupo = Integer.parseInt(editCupo.getText().toString());


        String regInsertados;
        Local local = new Local ();
        local.setIdAula(idAula);
        local.setIdReservante(idRes);
        local.setNombreAula(nomAula);
        local.setCupo(cupo);
        helper.abrir();
        regInsertados=helper.insertarLocal(local);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editidAula.setText("");
        editidRes.setText("");
        editNomAula.setText("");
        editCupo.setText("");


    }
}