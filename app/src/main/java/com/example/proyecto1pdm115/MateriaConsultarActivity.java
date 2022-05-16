package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MateriaConsultarActivity extends Activity {

    //ControlBDCarnet helper;
    EditText editId_materia;
    EditText editId_escuela;
    EditText editNom_materia;
    EditText editCiclo_materia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_consultar);
        //helper = new ControlBDProyecto1PDM115(this);

        editId_materia = (EditText) findViewById(R.id.editId_materia);
        editId_escuela = (EditText) findViewById(R.id.editId_escuela);
        editNom_materia = (EditText) findViewById(R.id.editNom_materia);
        editCiclo_materia = (EditText) findViewById(R.id.editCiclo_materia);
    }

    /*public void consultarMateria(View v) {
        helper.abrir();
        Materia materia = helper.consultarMateria(editId_materia.getText().toString());
        helper.cerrar();
        if(materia == null)
            Toast.makeText(this, "Materia con ID " +
                    editId_materia.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{
            editId_materia.setText(materia.getId_materia());
            editId_escuela.setText(materia.getId_escuela());
            editNom_materia.setText(materia.getNombre_materia());
            editCiclo_materia.setText(String.valueOf(materia.getCiclo_materia()));
        }
    }*/

    public void limpiarTexto(View v){
        editId_materia.setText("");
        editId_escuela.setText("");
        editNom_materia.setText("");
        editCiclo_materia.setText("");
    }
}