package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class TipoActividadInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_tipo_actividad;
    EditText editNombre_tipo_actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actividad_insertar);
        helper = new ControlBD(this);
        editId_tipo_actividad=(EditText) findViewById(R.id.editId_tipo_actividad);
        editNombre_tipo_actividad=(EditText) findViewById(R.id.editNombre_tipo_actividad);
    }

    public void insertarTipoActividad(){
        TipoActividad tipo = new TipoActividad();
        tipo.setId_tipo_actividad(editId_tipo_actividad.getText().toString());
        tipo.setNombre_tipo_actividad(editNombre_tipo_actividad.getText().toString());
        helper.abrir();
        //String estado =helper.insertar(tipo);
        helper.cerrar();
        //Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(){
        editId_tipo_actividad.setText("");
        editNombre_tipo_actividad.setText("");
    }
}