package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class LocalConsultarActivity extends Activity {
    ControlBD helper;
    EditText editidAula;
    EditText editidRes;
    EditText editNomAula;
    EditText editCupo;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_consultar);
        helper = new ControlBD(this);
        editidAula = (EditText) findViewById(R.id.editIdAula);
        editidRes = (EditText) findViewById(R.id.editIdReservante);
        editNomAula = (EditText) findViewById(R.id.editNombreLocal);
        editCupo = (EditText) findViewById(R.id.editCupo);

    }
    public void consultarLocal(View v) {
        helper.abrir();
        Local local = helper.consultarLocal(editidAula.getText().toString());
        helper.cerrar();
        if(local == null)
            Toast.makeText(this, "Local con identificador " +
                    editidAula.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editidRes.setText(local.getIdReservante());
            editNomAula.setText(local.getNombreAula());
            editCupo.setText(Integer.toString(local.getCupo()));


        }
    }

    public void limpiarTexto(View v){
        editidAula.setText("");
        editidRes.setText("");
        editNomAula.setText("");
        editCupo.setText("");
    }
}