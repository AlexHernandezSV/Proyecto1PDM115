package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MateriaEliminarActivity extends Activity {

    ControlBD controlhelper;
    EditText editId_materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_eliminar);
        controlhelper=new ControlBD(this);
        editId_materia=(EditText)findViewById(R.id.editId_materia);
    }

    public void eliminarMateria(View v){
        String regEliminadas;
        Materia materia=new Materia();
        materia.setId_materia(editId_materia.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(materia);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}