package com.example.proyecto1pdm115;

import android.os.Bundle;
import android.app.Activity;
import android.service.controls.Control;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ValoracionActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editidVal;
    EditText editVal;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_valoracion_actualizar);
        helper = new ControlBD(this);
        editidVal = (EditText) findViewById(R.id.editidVal);
        editVal = (EditText) findViewById(R.id.editVal);

    }
    public void actualizarValoracion(View v) {

        Valoracion valoracion = new Valoracion();
        valoracion.setId_valoracion(editidVal.getText().toString());
        valoracion.setValoracion(editVal.getText().toString());

        helper.abrir();
        String estado = helper.actualizarValoracion(valoracion);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editidVal.setText("");
        editVal.setText("");
    }
}