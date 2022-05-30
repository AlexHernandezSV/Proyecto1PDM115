package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ValoracionInsertarActivity extends Activity {
    ControlBD helper;
    EditText editidVal;
    EditText editVal;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_valoracion_insertar);
        helper = new ControlBD(this);
        editidVal = (EditText) findViewById(R.id.editidVal);
        editVal = (EditText) findViewById(R.id.editval);
    }
    public void insertarValoracion(View v) {
        String idValoracion = editidVal.getText().toString();
        String valoracion=editVal.getText().toString();

        String regInsertados;
        Valoracion valoracion1=new Valoracion();
        valoracion1.setId_valoracion(idValoracion);
        valoracion1.setValoracion(valoracion);
        helper.abrir();
        regInsertados=helper.insertarValoracion(valoracion1);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editidVal.setText("");
        editVal.setText("");

    }
}