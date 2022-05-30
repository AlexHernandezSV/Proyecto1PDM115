package com.example.proyecto1pdm115;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CicloActualizarActivity extends AppCompatActivity {


    ControlBD helper;
    EditText editId_ciclo;
    EditText editCiclo;
    EditText editFecha_inicio;
    EditText editFecha_fin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_actualizar);
        helper = new ControlBD(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editFecha_inicio = (EditText) findViewById(R.id.editFecha_incio);
        editFecha_fin = (EditText) findViewById(R.id.editFecha_fin);
    }
    public void actualizarCiclo(View v) {
        Ciclo ciclo = new Ciclo();
        ciclo.setId_ciclo(editId_ciclo.getText().toString());
        ciclo.setCiclo(editCiclo.getText().toString());
        ciclo.setFecha_inicio(editFecha_inicio.getText().toString());
        ciclo.setFecha_fin(editFecha_fin.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(ciclo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_ciclo.setText("");
        editCiclo.setText("");
        editFecha_inicio.setText("");
        editFecha_fin.setText("");
    }

}