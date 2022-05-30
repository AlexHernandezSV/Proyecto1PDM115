package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoActividadConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_tipo_actividad;
    EditText editNombre_tipo_actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actividad_consultar);
        helper = new ControlBD(this);
        editId_tipo_actividad=(EditText) findViewById(R.id.editId_tipo_actividad);
        editNombre_tipo_actividad=(EditText) findViewById(R.id.editNombre_tipo_actividad);

    }

    public void consultarTipoActividad(View v){
        helper.abrir();
        TipoActividad detalle = helper.consultarTipoActividad(editId_tipo_actividad.getText().toString());
        helper.cerrar();
        if(detalle == null)
            Toast.makeText(this, "Tipo de actividad con ID " + editId_tipo_actividad.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_tipo_actividad.setText(detalle.getNombre_tipo_actividad());

        }
    }

    public void limpiarTexto(View v){
        editId_tipo_actividad.setText("");
        editNombre_tipo_actividad.setText("");
    }
}