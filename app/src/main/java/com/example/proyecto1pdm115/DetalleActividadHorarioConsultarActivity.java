package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActividadHorarioConsultarActivity extends AppCompatActivity {


    ControlBD helper;
    EditText editId_horario;
    EditText editId_actividad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_horario_consultar);
        helper = new ControlBD(this);
        editId_horario = (EditText) findViewById(R.id.editId_horario);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);

    }
    public void consultarDetalleActividadHorario(View v) {
        helper.abrir();
        DetalleActividadHorario detalleActividadHorario = helper.consultarDetalleActividadHorario(editId_horario.getText().toString());
        helper.cerrar();
        if(detalleActividadHorario == null)
            Toast.makeText(this, "detalle Actividad Horario con ID" + editId_horario.getText().toString() + " no encontrado",
                    Toast.LENGTH_LONG).show();
        else{
            editId_actividad.setText(String.valueOf(detalleActividadHorario.getId_actividad()));
        }
    }
    public void limpiarTexto(View v) {
        editId_horario.setText("");
        editId_actividad.setText("");
    }

}