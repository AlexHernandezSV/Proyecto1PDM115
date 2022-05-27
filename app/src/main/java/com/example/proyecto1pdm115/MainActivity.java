package com.example.proyecto1pdm115;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {


    String[] menu={"Tabla Carrera","Tabla Miembro universitario","Tabla Horarios","Tabla de Detalles de ofertas", "Tabla Materia","Tabla Detalle Actividad","Tabla Encargado","Tabla Ciclo","Tabla Coordina","Tabla Detalle Actividad Horario","Tabla Escuela","Tabla Actividad","Tabla Detalle Responsable","LLenar Base de Datos"};
    String[] activities={"CarreraMenuActivity","MiembroUniversitarioMenuActivity","HorarioMenuActivity", "DetalleOfertaMenuActivity","MateriaMenuActivity","DetalleActividadMenuActivity","EncargadoMenuActivity","CicloMenuActivity", "CoordinaMenuActiviy","DetalleActividadHorarioMenuActivity","EscuelaMenuActivity","ActividadMenuActivity","DetalleResponsableMenuActivity"};
    ControlBD BDhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlBD(this);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=13){
            String nombreValue=activities[position];
            try{
                Class<?>
                        clase=Class.forName("com.example.proyecto1pdm115."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
//CODIGO PARA LLENAR BASE DE DATOS
            BDhelper.abrir();
            String tost=BDhelper.llenarBD();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}