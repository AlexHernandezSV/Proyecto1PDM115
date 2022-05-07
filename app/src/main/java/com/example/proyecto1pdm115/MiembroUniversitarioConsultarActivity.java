package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MiembroUniversitarioConsultarActivity extends AppCompatActivity {
    //ControlBDMT17005 helper;
    EditText editId_coordinador;
    EditText editNombre_coordinador;
    EditText editTipo_miembro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miembro_universitario_consultar);
        //helper = new ControlBDMT17005(this);
        editId_coordinador = (EditText) findViewById(R.id.editId_coordinador);
        editNombre_coordinador = (EditText) findViewById(R.id.editNombre_coordinador);
        editTipo_miembro = (EditText) findViewById(R.id.editTipo_miembro);
    }

    public void consultarMiembroUniversitario(View v) {
        //helper.abrir();
        //MiembroUniversitario miembroUniversitario = helper.consultarMiembroUniversitario(Integer.valueOf(editId_coordinador.getText().toString()));
        //helper.cerrar();
        /*if(miembroUniversitario == null)
            Toast.makeText(this, "Miembro con ID " +
                    editId_coordinador.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_coordinador.setText(miembroUniversitario.getNombre_coordinador());
            editTipo_miembro.setText(miembroUniversitario.getTipo_miembro());
        }*/
    }

    public void limpiarTexto(View v) {
        editId_coordinador.setText("");
        editNombre_coordinador.setText("");
        editTipo_miembro.setText("");
    }
}