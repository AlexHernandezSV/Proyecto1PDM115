package com.example.proyecto1pdm115;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LocalActualizarActivity extends Activity {
   ControlBD helper;
    EditText editidAula;
    EditText editidRes;
    EditText editNomAula;
    EditText editCupo;;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_local_actualizar);
        helper = new ControlBD(this);
        editidAula = (EditText) findViewById(R.id.editIdAula);
        editidRes = (EditText) findViewById(R.id.editIdReservante);
        editNomAula = (EditText) findViewById(R.id.editNombreLocal);
        editCupo = (EditText) findViewById(R.id.editCupo);

    }
    public void actualizarLocal(View v) {

        Local local  = new Local();
        local.setIdAula(editidAula.getText().toString());
        local.setIdReservante(editidRes.getText().toString());
        local.setNombreAula(editNomAula.getText().toString());
        local.setCupo(Integer.parseInt(editCupo.getText().toString()));


        helper.abrir();
        String estado = helper.actualizarLocal(local);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editidAula.setText("");
        editidRes.setText("");
        editNomAula.setText("");
        editCupo.setText("");
    }
}