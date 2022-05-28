package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleOfertaInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editGrupo;
    EditText editId_materias_activas;
    EditText editId_aula;
    EditText editCant_inscritos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta_insertar);
        helper = new ControlBD(this);
        editGrupo = (EditText) findViewById(R.id.editGrupo);
        editId_materias_activas = (EditText) findViewById(R.id.editId_materias_activas);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editCant_inscritos = (EditText) findViewById(R.id.editCant_inscritos);
    }

    public void insertarDetalleOferta(View v) {
        String regInsertados;
        String grupo=editGrupo.getText().toString();
        String id_materias_activas=editId_materias_activas.getText().toString();
        String id_aula=editId_aula.getText().toString();
        Integer cant_inscritos=Integer.valueOf(editCant_inscritos.getText().toString());
        DetalleOferta detalleOferta= new DetalleOferta();
        detalleOferta.setGrupo(grupo);
        detalleOferta.setId_materias_activas(id_materias_activas);
        detalleOferta.setId_aula(id_aula);
        detalleOferta.setCant_inscritos(cant_inscritos);
        helper.abrir();
        regInsertados=helper.insertar(detalleOferta);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editGrupo.setText("");
        editId_materias_activas.setText("");
        editId_aula.setText("");
        editCant_inscritos.setText("");
    }
}