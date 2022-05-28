package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editDetActividad;
    EditText editId_aula;
    EditText editId_actividad;
    EditText editParticipantes;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_insertar);
        helper = new ControlBD(this);
        editDetActividad = (EditText) findViewById(R.id.editDetActividad);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editParticipantes = (EditText) findViewById(R.id.editParticipantes);
    }
    public void insertarDetalleActividad(View v) {
        String regInsertados;
        String id_detalle_actividad=editDetActividad.getText().toString();
        String id_aula=editId_aula.getText().toString();
        String id_actividad=editId_actividad.getText().toString();
        Integer participantes=Integer.valueOf(editParticipantes.getText().toString());
        DetalleActividad detalleActividad= new DetalleActividad();
        detalleActividad.setId_detalle_actividad(id_detalle_actividad);
        detalleActividad.setId_aula(id_aula);
        detalleActividad.setId_actividad(id_actividad);
        detalleActividad.setParticipantes(participantes);
        helper.abrir();
        regInsertados=helper.insertar(detalleActividad);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editDetActividad.setText("");
        editId_aula.setText("");
        editId_actividad.setText("");
        editParticipantes.setText("");
    }
}