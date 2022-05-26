package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MiembroUniversitarioInsertarActivity extends AppCompatActivity {
    ControlBD helper;
    EditText editId_coordinador;
    EditText editNombre_coordinador;
    EditText editTipo_miembro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miembro_universitario_insertar);
        helper = new ControlBD(this);
        editId_coordinador = (EditText) findViewById(R.id.editId_coordinador);
        editNombre_coordinador = (EditText) findViewById(R.id.editNombre_coordinador);
        editTipo_miembro = (EditText) findViewById(R.id.editTipo_miembro);
    }

    public void insertarMiembroUniversitario(View v) {
        String id_coordinador=editId_coordinador.getText().toString();
        String nombre_coordinador=editNombre_coordinador.getText().toString();
        String tipo_miembro=editTipo_miembro.getText().toString();
        String regInsertados;
        MiembroUniversitario miembroUniversitario=new MiembroUniversitario();
        miembroUniversitario.setId_coordinador(id_coordinador);
        miembroUniversitario.setNombre_coordinador(nombre_coordinador);
        miembroUniversitario.setTipo_miembro(tipo_miembro);
        helper.abrir();
        regInsertados=helper.insertar(miembroUniversitario);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_coordinador.setText("");
        editNombre_coordinador.setText("");
        editTipo_miembro.setText("");
    }
}