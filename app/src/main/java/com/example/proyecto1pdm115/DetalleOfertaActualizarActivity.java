package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleOfertaActualizarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editGrupo;
    EditText editId_materias_activas;
    EditText editId_aula;
    EditText editCant_inscritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta_actualizar);
        helper = new ControlBD(this);
        editGrupo = (EditText) findViewById(R.id.editGrupo);
        editId_materias_activas = (EditText) findViewById(R.id.editId_materias_activas);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editCant_inscritos = (EditText) findViewById(R.id.editCant_inscritos);
    }

    public void actualizarDetalleOferta(View v) {
        DetalleOferta detalleOferta = new DetalleOferta();
        detalleOferta.setGrupo(editGrupo.getText().toString());
        detalleOferta.setId_materias_activas(editId_materias_activas.getText().toString());
        detalleOferta.setId_aula(editId_aula.getText().toString());
        detalleOferta.setCant_inscritos(Integer.valueOf(editCant_inscritos.getText().toString()));
        helper.abrir();
        String estado = helper.actualizar(detalleOferta);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editGrupo.setText("");
        editId_materias_activas.setText("");
        editId_aula.setText("");
        editCant_inscritos.setText("");
    }
}