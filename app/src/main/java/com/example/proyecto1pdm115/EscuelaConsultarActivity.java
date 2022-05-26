package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EscuelaConsultarActivity extends AppCompatActivity {

    //ControlBDMT17005 helper;
    EditText editId_escuela;
    EditText editId_carrera;
    EditText editNombre_escuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_consultar);
        //helper = new ControlBDM(this);
        editId_escuela = (EditText) findViewById(R.id.editId_escuela);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editNombre_escuela = (EditText) findViewById(R.id.editNombre_escuela);
    }
    public void consultarCarrera(View v) {
        //helper.abrir();
        //Escuela escuela = helper.consultarEscuela(editId_escuela.getText().toString());
        //helper.cerrar();
        /*if(escuela == null)
            Toast.makeText(this, "Escuela con ID " + editId_escuela.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editId_carrera.setText(escuela.getId_carrera());
            editNombre_escuela.setText(escuela.getNombre_escuela());
        }*/
    }
    public void limpiarTexto(View v) {
        editId_escuela.setText("");
        editId_carrera.setText("");
        editNombre_escuela.setText("");
    }
}