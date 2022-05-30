package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class DetalleActividadHorarioEliminarActivity extends AppCompatActivity {

    EditText editId_horario,editId_actividad;
    ControlBD controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_horario_eliminar);
        controlhelper=new ControlBD(this);
        editId_horario=(EditText)findViewById(R.id.editId_horario);
        editId_actividad=(EditText)findViewById(R.id.editId_actividad);
    }

    public void eliminarDetalleActividadHorario(View v){
        String regEliminadas;
        DetalleActividadHorario detalleActividadHorario=new DetalleActividadHorario();
        detalleActividadHorario.setId_horario(editId_horario.getText().toString());
        detalleActividadHorario.setId_actividad(editId_actividad.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(detalleActividadHorario);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editId_horario.setText("");
        editId_actividad.setText("");

    }

}