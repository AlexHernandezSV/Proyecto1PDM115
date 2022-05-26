package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraEliminarActivity extends AppCompatActivity {
    ControlBD controlhelper;
    EditText editId_carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_eliminar);
        controlhelper=new ControlBD (this);
        editId_carrera=(EditText)findViewById(R.id.editId_carrera);
    }
    public void eliminarCarrera(View v){
        String regEliminadas;
        Carrera carrera=new Carrera();
        carrera.setId_carrera(editId_carrera.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(carrera);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}