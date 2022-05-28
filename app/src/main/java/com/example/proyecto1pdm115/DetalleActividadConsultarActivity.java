package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleActividadConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editDetActividad;
    EditText editId_aula;
    EditText editId_actividad;
    EditText editParticipantes;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad_consultar);
        helper = new ControlBD(this);
        editDetActividad = (EditText) findViewById(R.id.editDetActividad);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editId_actividad = (EditText) findViewById(R.id.editId_actividad);
        editParticipantes = (EditText) findViewById(R.id.editParticipantes);
    }
    public void consultarDetalleActividad(View v) {
        helper.abrir();
        DetalleActividad detalleActividad = helper.consultarDetalleActividad(editDetActividad.getText().toString(),
                editId_aula.getText().toString(), editId_actividad.getText().toString());
        helper.cerrar();
        if(detalleActividad == null)
            Toast.makeText(this, "Detalle no registrado", Toast.LENGTH_LONG).show();
        else{
            editParticipantes.setText(String.valueOf(detalleActividad.getParticipantes()));
        }
    }


    public void limpiarTexto(View v) {
        editDetActividad.setText("");
        editId_aula.setText("");
        editId_actividad.setText("");
        editParticipantes.setText("");
    }
}