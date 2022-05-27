package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

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

    public void eliminarTipoActividad(){
        String regInsertados;
        TipoActividad tipo =new TipoActividad();
        tipo.setId_tipo_actividad(editId_tipo_actividad.getText().toString());
        //controlhelper.abrir();
        //regEliminadas=controlhelper.eliminar(detalle);
        //controlhelper.cerrar();
        //Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}