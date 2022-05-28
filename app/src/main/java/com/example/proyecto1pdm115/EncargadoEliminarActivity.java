package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoEliminarActivity extends Activity {

    EditText editId_reservante,editId_usuario;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_eliminar);
        controlhelper=new ControlBD(this);
        editId_reservante=(EditText)findViewById(R.id.editId_reservante);
        editId_usuario=(EditText)findViewById(R.id.editId_usuario);
    }

    public void eliminarEncargado(View v){
        String regEliminadas;
        Encargado encargado=new Encargado();
        encargado.setId_reservante(editId_reservante.getText().toString());
        encargado.setId_usuario(editId_usuario.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(encargado);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editId_reservante.setText("");
        editId_usuario.setText("");
    }

}