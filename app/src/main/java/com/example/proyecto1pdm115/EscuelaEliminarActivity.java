package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EscuelaEliminarActivity extends AppCompatActivity {

    ControlBD controlhelper;
    EditText editId_escuela;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_eliminar);
        controlhelper=new ControlBD (this);
        editId_escuela=(EditText)findViewById(R.id.editId_escuela);
    }

    public void eliminarEscuela(View v){
        String regEliminadas;
        Escuela escuela=new Escuela();
        escuela.setId_escuela(editId_escuela.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(escuela);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}