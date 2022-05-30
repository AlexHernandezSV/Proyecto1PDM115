package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadHorarioActualizarActivity extends Activity {

    ControlBD helper;
    EditText editId_horario;
    EditText editId_actividad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_horario_actualizar);
        helper = new ControlBD(this);
        editId_horario = (EditText) findViewById(R.id.editId_horario);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);

    }
    public void actualizarDetalleActividadHorario(View v) {
        DetalleActividadHorario detalleActividadHorario = new DetalleActividadHorario();
        detalleActividadHorario.setId_horario(editId_horario.getText().toString());
        detalleActividadHorario.setId_actividad(editId_actividad.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(detalleActividadHorario);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_horario.setText("");
        editId_actividad.setText("");

    }

}