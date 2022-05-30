package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadEliminarActivity extends AppCompatActivity {

    ControlBD controlhelper;
    EditText editId_actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_eliminar);
        controlhelper = new ControlBD(this);
        editId_actividad= (EditText) findViewById(R.id.editId_actividad);
    }

    public void eliminarActividad(View v){
        String regEliminadas;
        Actividad actividad = new Actividad();
        actividad.setId_actividad(editId_actividad.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(actividad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();

    }


}