package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadHorarioInsertarActivity extends Activity {


    ControlBD helper;
    EditText editId_horario;
    EditText editId_actividad;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_horario_insertar);
        helper = new ControlBD(this);
        editId_horario = (EditText) findViewById(R.id.editId_horario);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);

    }
    public void insertarDetalleActividadHorario(View v) {
        String regInsertados;
        String id_horario=editId_horario.getText().toString();
        String id_actividad=editId_actividad.getText().toString();
        DetalleActividadHorario detalleActividadHorario= new DetalleActividadHorario();
        detalleActividadHorario.setId_horario(id_horario);
        detalleActividadHorario.setId_actividad(id_actividad);
        helper.abrir();
        regInsertados=helper.insertar(detalleActividadHorario);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_horario.setText("");
        editId_actividad.setText("");
    }

}