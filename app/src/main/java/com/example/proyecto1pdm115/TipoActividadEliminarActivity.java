package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoActividadEliminarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_tipo_actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actividad_eliminar);
        helper = new ControlBD(this);
        editId_tipo_actividad=(EditText) findViewById(R.id.editId_tipo_actividad);
    }

    public void eliminarTipoActividad(View v){
        String regEliminadas;
        TipoActividad tipo =new TipoActividad();
        tipo.setId_tipo_actividad(editId_tipo_actividad.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminar(tipo);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}