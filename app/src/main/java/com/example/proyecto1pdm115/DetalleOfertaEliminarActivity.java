package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleOfertaEliminarActivity extends AppCompatActivity {
    EditText editGrupo,editId_materias_activas,editId_aula;
    ControlBD controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta_eliminar);
        controlhelper=new ControlBD(this);
        editGrupo = (EditText) findViewById(R.id.editGrupo);
        editId_materias_activas = (EditText) findViewById(R.id.editId_materias_activas);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        //editCant_inscritos = (EditText) findViewById(R.id.editCant_inscritos);
    }

    public void eliminarDetalleOferta(View v){
        String regEliminadas;
        DetalleOferta detalleOferta=new DetalleOferta();
        detalleOferta.setGrupo(editGrupo.getText().toString());
        detalleOferta.setId_materias_activas(editId_materias_activas.getText().toString());
        detalleOferta.setId_aula(editId_aula.getText().toString());
        //detalleOferta.setCant_inscritos(Integer.valueOf(editCant_inscritos.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(detalleOferta);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editGrupo.setText("");
        editId_materias_activas.setText("");
        editId_aula.setText("");
    }
}