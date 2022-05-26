package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MiembroUniversitarioEliminarActivity extends AppCompatActivity {
    EditText editId_coordinador;
    //ControlBDMT17005 controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miembro_universitario_eliminar);
        //controlhelper=new ControlBDMT17005 (this);
        editId_coordinador=(EditText)findViewById(R.id.editId_coordinador);
    }

    public void eliminarMiembroUniversitario(View v){
        //String regEliminadas;
        MiembroUniversitario miembroUniversitario=new MiembroUniversitario();
        miembroUniversitario.setId_coordinador(editId_coordinador.getText().toString());
        //controlhelper.abrir();
        //regEliminadas=controlhelper.eliminar(miembroUniversitario);
        //controlhelper.cerrar();
        //Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}