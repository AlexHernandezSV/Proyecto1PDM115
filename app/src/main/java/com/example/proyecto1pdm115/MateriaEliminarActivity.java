package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MateriaEliminarActivity extends AppCompatActivity {

    EditText editId_materia,editId_escuela;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_eliminar);
        controlhelper=new ControlBD(this);
        editId_materia=(EditText)findViewById(R.id.editId_materia);
        editId_escuela=(EditText)findViewById(R.id.editId_escuela);
    }

    public void eliminarMateria(View v){
        String regEliminadas;
        Materia materia=new Materia();
        materia.setId_materia(editId_materia.getText().toString());
        materia.setId_escuela(editId_escuela.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(materia);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editId_materia.setText("");
        editId_escuela.setText("");
    }

}