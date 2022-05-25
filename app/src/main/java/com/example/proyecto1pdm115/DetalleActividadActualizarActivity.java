package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadActualizarActivity extends Activity {

    //ControlBDMT17005 helper;
    EditText editDetActividad;
    EditText editId_aula;
    EditText editId_actividad;
    EditText editParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_actualizar);
        //helper = new ControlBDMT17005(this);
        editDetActividad = (EditText) findViewById(R.id.editDetActividad);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editParticipantes = (EditText) findViewById(R.id.editParticipantes);
    }

    public void actualizarDetalleActividad(View v) {
        DetalleActividad detalleActividad = new DetalleActividad();
        detalleActividad.setId_detalle_actividad(Integer.valueOf(editDetActividad.getText().toString()));
        detalleActividad.setId_aula(Integer.valueOf(editId_aula.getText().toString()));
        detalleActividad.setId_actividad(Integer.valueOf(editId_actividad.getText().toString()));
        detalleActividad.setParticipantes(Integer.valueOf(editParticipantes.getText().toString()));
        //helper.abrir();
        //String estado = helper.actualizar(detalleActividad);
        //helper.cerrar();
        //Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editDetActividad.setText("");
        editId_aula.setText("");
        editId_actividad.setText("");
        editParticipantes.setText("");
    }
}