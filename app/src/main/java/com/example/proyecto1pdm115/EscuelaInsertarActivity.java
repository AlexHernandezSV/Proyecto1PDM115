package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EscuelaInsertarActivity extends AppCompatActivity {

    //ControlBDMT17005 helper;
    EditText editId_escuela;
    EditText editId_carrera;
    EditText editNombre_escuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_insertar);
        //helper = new ControlBDMT17005(this);
        editId_escuela = (EditText) findViewById(R.id.editId_escuela);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editNombre_escuela = (EditText) findViewById(R.id.editNombre_escuela);
    }
    public void insertarCarrera(View v) {
        String id_escuela=editId_escuela.getText().toString();
        String id_carrera=editId_carrera.getText().toString();
        String nombre_carrera=editNombre_escuela.getText().toString();
        String regInsertados;
        Escuela escuela=new Escuela();
        escuela.setId_escuela(id_escuela);
        escuela.setId_carrera(id_carrera);
        escuela.setNombre_escuela(nombre_carrera);
        //helper.abrir();
        //regInsertados=helper.insertar(alumno);
        //helper.cerrar();
        //Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_escuela.setText("");
        editId_carrera.setText("");
        editNombre_escuela.setText("");
    }
}