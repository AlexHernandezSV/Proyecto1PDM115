package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MiembroUniversitarioActualizarActivity extends AppCompatActivity {
    //ControlBDMT17005 helper;
    EditText editId_coordinador;
    EditText editNombre_coordinador;
    EditText editTipo_miembro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miembro_universitario_actualizar);
        //helper = new ControlBDMT17005(this);
        editId_coordinador = (EditText) findViewById(R.id.editId_coordinador);
        editNombre_coordinador = (EditText) findViewById(R.id.editNombre_coordinador);
        editTipo_miembro = (EditText) findViewById(R.id.editTipo_miembro);
    }

    public void actualizarMiembroUniversitario(View v) {
        MiembroUniversitario miembroUniversitario=new MiembroUniversitario();
        miembroUniversitario.setId_coordinador(editId_coordinador.getText().toString());
        miembroUniversitario.setNombre_coordinador(editNombre_coordinador.getText().toString());
        miembroUniversitario.setTipo_miembro(editTipo_miembro.getText().toString());
        //helper.abrir();
        //String estado = helper.actualizar(alumno);
        //helper.cerrar();
        //Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_coordinador.setText("");
        editNombre_coordinador.setText("");
        editTipo_miembro.setText("");
    }
}