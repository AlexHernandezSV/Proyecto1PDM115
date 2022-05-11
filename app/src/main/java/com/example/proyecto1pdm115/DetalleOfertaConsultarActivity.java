package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalleOfertaConsultarActivity extends AppCompatActivity {
    //ControlBDMT17005 helper;
    EditText editGrupo;
    EditText editId_materias_activas;
    EditText editId_aula;
    EditText editCant_inscritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta_consultar);
        //helper = new ControlBDMT17005(this);
        editGrupo = (EditText) findViewById(R.id.editGrupo);
        editId_materias_activas = (EditText) findViewById(R.id.editId_materias_activas);
        editId_aula = (EditText) findViewById(R.id.editId_aula);
        editCant_inscritos = (EditText) findViewById(R.id.editCant_inscritos);
    }

    public void consultarDetalleOferta(View v) {
        //helper.abrir();
        //DetalleOferta detalleOferta = helper.consultarDetalleOferta(editGrupo.getText().toString(), editId_materias_activas.getText().toString(), editId_aula.getText().toString(), editCant_inscritos.getText().toString());
        //helper.cerrar();
        /*if(detalleOferta == null)
            Toast.makeText(this, "Nota no registrada",
                    Toast.LENGTH_LONG).show();
        else{
            edit.setText(String.valueOf(nota.getNotafinal()));
        }*/
    }

    public void limpiarTexto(View v) {
        editGrupo.setText("");
        editId_materias_activas.setText("");
        editId_aula.setText("");
        editCant_inscritos.setText("");
    }
}