package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaInsertarActivity extends Activity {

    ControlBD helper;
    EditText editId_materia;
    EditText editId_escuela;
    EditText editNom_materia;
    EditText editCiclo_materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_insertar);
        helper = new ControlBD(this);
        editId_materia = (EditText) findViewById(R.id.editId_materia);
        editId_escuela = (EditText) findViewById(R.id.editId_escuela);
        editNom_materia = (EditText) findViewById(R.id.editNom_materia);
        editCiclo_materia = (EditText) findViewById(R.id.editCiclo_materia);

    }

    public void insertarMateria(View v) {
        String id_materia=editId_materia.getText().toString();
        int id_escuela= Integer.parseInt(editId_escuela.getText().toString());
        String nom_materia=editNom_materia.getText().toString();
        int ciclo_materia= Integer.parseInt(editCiclo_materia.getText().toString());
        String regInsertados;

        Materia materia=new Materia();
        materia.setId_materia(id_materia);
        materia.setId_escuela(id_escuela);
        materia.setNombre_materia(nom_materia);
        materia.setCiclo_materia(ciclo_materia);
        helper.abrir();
        regInsertados=helper.insertar(materia);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_materia.setText("");
        editId_escuela.setText("");
        editNom_materia.setText("");
        editCiclo_materia.setText("");
    }

}