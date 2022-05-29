package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoGrupoEliminarActivity extends AppCompatActivity {

    EditText editId_tipoGrupo,editTipoGrupo;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_grupo_eliminar);
        controlhelper=new ControlBD(this);
        editId_tipoGrupo=(EditText)findViewById(R.id.editId_tipoGrupo);
        editTipoGrupo=(EditText)findViewById(R.id.editTipoGrupo);
    }

    public void eliminarTipoGrupo(View v){
        String regEliminadas;
        TipoGrupo tipoGrupo=new TipoGrupo();
        tipoGrupo.setId_tipo_grupo(editId_tipoGrupo.getText().toString());
        tipoGrupo.setGrupo(editTipoGrupo.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tipoGrupo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editId_tipoGrupo.setText("");
        editTipoGrupo.setText("");
    }
}