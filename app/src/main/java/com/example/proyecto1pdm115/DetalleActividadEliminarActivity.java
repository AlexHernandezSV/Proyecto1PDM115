package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadEliminarActivity extends AppCompatActivity {

    ControlBD controlhelper;
    EditText editDetActividad;
    EditText editId_aula;
    EditText editId_actividad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_eliminar);
        controlhelper=new ControlBD(this);
        editDetActividad=(EditText)findViewById(R.id.editDetActividad);
        editId_aula=(EditText)findViewById(R.id.editId_aula);
        editId_actividad=(EditText)findViewById(R.id.editId_actividad);
    }

    public void eliminarDetalleActividad(View v){
        String regEliminadas;
        DetalleActividad detalleActividad=new DetalleActividad();
        detalleActividad.setId_detalle_actividad(editDetActividad.getText().toString());
        detalleActividad.setId_aula(editId_aula.getText().toString());
        detalleActividad.setId_actividad(editId_actividad.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(detalleActividad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editDetActividad.setText("");
        editId_aula.setText("");
        editId_actividad.setText("");
    }
}