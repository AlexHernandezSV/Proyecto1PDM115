package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraInsertarActivity extends AppCompatActivity {
    //ControlBDMT17005 helper;
    EditText editId_carrera;
    EditText editNombre_carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_insertar);
        //helper = new ControlBDMT17005(this);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editNombre_carrera = (EditText) findViewById(R.id.editNombre_carrera);
    }
    public void insertarCarrera(View v) {
        String id_carrera=editId_carrera.getText().toString();
        String nombre_carrera=editNombre_carrera.getText().toString();
        String regInsertados;
        Carrera carrera=new Carrera();
        carrera.setId_carrera(id_carrera);
        carrera.setNombre_carrera(nombre_carrera);
        //helper.abrir();
        //regInsertados=helper.insertar(alumno);
        //helper.cerrar();
        //Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_carrera.setText("");
        editNombre_carrera.setText("");
    }
}