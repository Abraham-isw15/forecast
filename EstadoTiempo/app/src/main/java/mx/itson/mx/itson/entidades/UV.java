package mx.itson.mx.itson.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.itson.database.ClimaDB;
import mx.itson.enumeradores.Riesgo;

/**
 * Created by Propietario on 08/08/2015.
 */
public class UV  implements Serializable {

    Context context;
    public UV(){    }
    public UV(Context context){this.context=context;}

    private int id;
    private int valor;
    private Riesgo riesgo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Riesgo getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(Riesgo riesgo) {
        this.riesgo = riesgo;
    }

    public int agregar(){
        int ultimoId = 0;
        try {

            ClimaDB bd = new ClimaDB(context,"ClimaDB",null,1);
            SQLiteDatabase baseDatos = bd.getReadableDatabase();
            baseDatos.execSQL("INSERT INTO UV"+
                    "(valor,"+
                    "riesgo)"+
                    "Values"+
                    "('"+this.valor+"','"+this.riesgo.getValor()+"')");
            Cursor result = baseDatos.rawQuery("SELECT * FROM UV WHERE ID = (SELECT MAX(ID)  FROM UV)",null);
            if (result.moveToFirst()) {
                do {
                    ultimoId = result.getInt(0);
                } while(result.moveToNext());
            }
            baseDatos.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return ultimoId;}

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    public UV obtenerPorId(int id) {
        UV uv = new UV();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();
            Cursor c =baseDatos.rawQuery("SELECT * FROM UV WHERE id= '" + id + "'",null);


            if (c.moveToFirst()){
                do {
                    uv.setId(c.getInt(0));
                    uv.setValor(c.getInt(1));
                    uv.setRiesgo(Riesgo.getRiesgo(c.getInt(2)));



                }while (c.moveToNext());


            }





        } catch (Exception e) {

        }

        return uv;
    }
    public List<UV> obtenerTodos() {
        UV uv = null;

        List <UV> uvs = new ArrayList<>();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();
            String[] args = new String[] {"id"};
            Cursor c =baseDatos.rawQuery("SELECT * FROM UV ",args);



            if (c.moveToFirst()){
                do {
                    uv.setId(c.getInt(0));
                    uv.setValor(c.getInt(1));
                    uv.setRiesgo(Riesgo.getRiesgo(c.getInt(2)));


                    uvs.add(uv);


                }while (c.moveToNext());


            }





        } catch (Exception e) {

        }

        return uvs;
    }

}