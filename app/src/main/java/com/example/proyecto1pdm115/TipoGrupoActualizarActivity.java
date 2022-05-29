package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoGrupoActualizarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editId_tipoGrupo;
    EditText editTipoGrupo;
    EditText editNom_tipoGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_grupo_actualizar);
        helper = new ControlBD(this);
        editId_tipoGrupo = (EditText) findViewById(R.id.editId_tipoGrupo);
        editTipoGrupo = (EditText) findViewById(R.id.editTipoGrupo);
        editNom_tipoGrupo = (EditText) findViewById(R.id.editNom_tipoGrupo);

    }

    public void actualizarTipoGrupo(View v) {
        TipoGrupo tipoGrupo = new TipoGrupo();
        tipoGrupo.setId_tipo_grupo(editId_tipoGrupo.getText().toString());
        tipoGrupo.setGrupo(editTipoGrupo.getText().toString());
        tipoGrupo.setNombre_tipo_grupo(editNom_tipoGrupo.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(tipoGrupo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_tipoGrupo.setText("");
        editTipoGrupo.setText("");
        editNom_tipoGrupo.setText("");
    }
}