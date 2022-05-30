package com.example.proyecto1pdm115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CicloInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_ciclo;
    EditText editCiclo;
    EditText editIFecha_inicio;
    EditText editIFecha_fin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_insertar);
        helper = new ControlBD(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editIFecha_inicio = (EditText) findViewById(R.id.editFecha_incio);
        editIFecha_fin = (EditText) findViewById(R.id.editFecha_fin);
    }


    public void insertarCiclo(View v) {
        String Id_ciclo = editId_ciclo.getText().toString();
        String ciclo = editCiclo.getText().toString();
        String Fecha_inicio = editIFecha_inicio.getText().toString();
        String Fecha_fin = editIFecha_fin.getText().toString();
        String regInsertados;
        Ciclo cic = new Ciclo();
        cic.setId_ciclo(Id_ciclo);
        cic.setCiclo(ciclo);
        cic.setFecha_inicio(Fecha_inicio);
        cic.setFecha_fin(Fecha_fin);
        helper.abrir();


        regInsertados = helper.insertar(cic);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_ciclo.setText("");
        editCiclo.setText("");
        editIFecha_inicio.setText("");
        editIFecha_fin.setText("");
    }



}