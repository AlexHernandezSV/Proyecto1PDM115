package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EscuelaActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_escuela;
    EditText editId_carrera;
    EditText editNombre_escuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_actualizar);
        helper = new ControlBD(this);
        editId_escuela = (EditText) findViewById(R.id.editId_escuela);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editNombre_escuela = (EditText) findViewById(R.id.editNombre_escuela);
    }

    public void actualizarEscuela(View v){
        Escuela escuela=new Escuela();
        escuela.setId_escuela(editId_escuela.getText().toString());
        escuela.setId_carrera(editId_carrera.getText().toString());
        escuela.setNombre_escuela(editNombre_escuela.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(escuela);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_escuela.setText("");
        editId_carrera.setText("");
        editNombre_escuela.setText("");
    }


}