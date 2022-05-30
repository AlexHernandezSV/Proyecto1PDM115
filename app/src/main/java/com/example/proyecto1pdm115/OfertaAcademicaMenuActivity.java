package com.example.proyecto1pdm115;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OfertaAcademicaMenuActivity extends ListActivity {

    //titulos en pantalla
    String[] menu={"Insertar Oferta Academica","Eliminar Oferta Academica","Consultar Oferta Academica",
            "Actualizar Oferta Academica"};
    //modificar los activities
    String[] activities={"OfertaAcademicaInsertarActivity","OfertaAcademicaEliminarActivity","OfertaAcademicaConsultarActivity",
            "OfertaAcademicaActualizarActivity"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(255, 255, 255));
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);

        String nombreValue=activities[position];

        l.getChildAt(position).setBackgroundColor(Color.rgb(255, 255, 255));
        //cambiar la ruta
        try{
            Class<?> clase=Class.forName("com.example.proyecto1pdm115."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}