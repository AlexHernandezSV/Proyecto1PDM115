package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editDetActividad;
    EditText editId_aula;
    EditText editId_actividad;
    EditText editParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_actualizar);
        helper = new ControlBD(this);
        editDetActividad = (EditText) findViewById(R.id.editDetActividad);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editParticipantes = (EditText) findViewById(R.id.editParticipantes);
    }

    public void actualizarDetalleActividad(View v) {
        DetalleActividad detalleActividad = new DetalleActividad();
        detalleActividad.setId_detalle_actividad(editDetActividad.getText().toString());
        detalleActividad.setId_aula(editId_aula.getText().toString());
        detalleActividad.setId_actividad(editId_actividad.getText().toString());
        detalleActividad.setParticipantes(Integer.valueOf(editParticipantes.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(detalleActividad);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editDetActividad.setText("");
        editId_aula.setText("");
        editId_actividad.setText("");
        editParticipantes.setText("");
    }
}