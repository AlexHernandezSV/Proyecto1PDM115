package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargadoConsultarActivity extends Activity {

    //ControlBDCarnet helper;
    EditText editId_reservante;
    EditText editId_usuario;
    EditText editNom_reservante;
    EditText editTipo_reservante;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_consultar);
        //helper = new ControlBDCarnet(this);
        editId_reservante = (EditText) findViewById(R.id.editId_reservante);
        editId_usuario = (EditText) findViewById(R.id.editId_usuario);
        editNom_reservante = (EditText) findViewById(R.id.editNom_reservante);
        editTipo_reservante = (EditText) findViewById(R.id.editTipo_reservante);
    }

    public void consultarEncargado(View v) {
        /*helper.abrir();
        Encargado encargado = helper.consultarEncargado(editId_reservante.getText().toString());
        helper.cerrar();
        if(encargado == null)
            Toast.makeText(this, "Reservante con ID " +
                    editId_reservante.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editId_usuario.setText(encargado.getId_usuario());
            editNom_reservante.setText(encargado.getNombre_reservante());
            editTipo_reservante.setText(encargado.getTipo_reservante());
        }*/
    }

    public void limpiarTexto(View v){
        editId_reservante.setText("");
        editId_usuario.setText("");
        editNom_reservante.setText("");
        editTipo_reservante.setText("");
    }


}