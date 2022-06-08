package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CoordinaActualizarActivity extends AppCompatActivity {


    ControlBD helper;
    EditText editId_actividad;
    EditText editId_coordinador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordina_actualizar);
        helper = new ControlBD(this);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editId_coordinador = (EditText) findViewById(R.id.editId_coordinador);

    }
        public void actualizarCoordina(View v) {
        Coordina coordina = new Coordina();
        coordina.setId_actividad(editId_actividad.getText().toString());
        coordina.setId_coordinador(editId_coordinador.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(coordina);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_actividad.setText("");
        editId_coordinador.setText("");

    }
}