package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoGrupoConsultarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_tipoGrupo;
    EditText editTipoGrupo;
    EditText editNom_tipoGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_grupo_consultar);
        helper = new ControlBD(this);
        editId_tipoGrupo = (EditText) findViewById(R.id.editId_tipoGrupo);
        editTipoGrupo = (EditText) findViewById(R.id.editTipoGrupo);
        editNom_tipoGrupo = (EditText) findViewById(R.id.editNom_tipoGrupo);
    }

    public void consultarTipoGrupo(View v) {
        helper.abrir();
        TipoGrupo tipoGrupo = helper.consultarTipoGrupo(editId_tipoGrupo.getText().toString(),editTipoGrupo.getText().toString());
        helper.cerrar();
        if(tipoGrupo == null)
            Toast.makeText(this, "Tipo Grupo con ID " +
                    editId_tipoGrupo.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            //editId_materia.setText(materia.getId_materia());
            //editId_escuela.setText(materia.getId_escuela());
            editNom_tipoGrupo.setText(tipoGrupo.getNombre_tipo_grupo());
            //editCiclo_materia.setText(String.valueOf(materia.getCiclo_materia()));
        }
    }

    public void limpiarTexto(View v) {
        editId_tipoGrupo.setText("");
        editTipoGrupo.setText("");
        editNom_tipoGrupo.setText("");
    }
}