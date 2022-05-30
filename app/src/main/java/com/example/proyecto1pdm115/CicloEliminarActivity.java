package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CicloEliminarActivity extends AppCompatActivity {
    EditText editId_ciclo;
    ControlBD controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_eliminar);
        controlhelper=new ControlBD (this);
        editId_ciclo=(EditText)findViewById(R.id.editId_ciclo);
    }

    public void eliminarHorario(View v){
        String regEliminadas;
        Ciclo ciclo=new Ciclo();
        ciclo.setId_ciclo(editId_ciclo.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(ciclo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}