package mx.itson.mx.itson.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.itson.database.ClimaDB;
import mx.itson.enumeradores.TipoLuna;

/**
 * Created by Propietario on 08/08/2015.
 */

public class Astro implements Serializable {
    Context context;

    public Astro() {
    }

    public Astro(Context context) {
        this.context = context;
    }

    private int id;
    private double salidaSol;
    private double puestaSol;
    private TipoLuna tipoLuna;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalidaSol() {
        return salidaSol;
    }

    public void setSalidaSol(double salidaSol) {
        this.salidaSol = salidaSol;
    }

    public double getPuestaSol() {
        return puestaSol;
    }

    public void setPuestaSol(double puestaSol) {
        this.puestaSol = puestaSol;
    }

    public TipoLuna getTipoLuna() {
        return tipoLuna;
    }

    public void setTipoLuna(TipoLuna tipoLuna) {
        this.tipoLuna = tipoLuna;
    }

    public int agregar(){
        int ultimoId= 0;
        try{
            ClimaDB bd= new ClimaDB(context,"ClimaDB",null,1);
            SQLiteDatabase baseDatos=bd.getReadableDatabase();
            baseDatos.execSQL("INSERT INTO Astro ("+
                    "salidaSol, "+
                    "puestaSol, "+
                    "tipoLuna)"+
                    "VALUES"+
                    "('"+this.salidaSol+"','"+this.puestaSol+"','"+this.tipoLuna.getValor()+"')");

            Cursor result = baseDatos.rawQuery("SELECT * FROM Astro WHERE ID = (SELECT MAX(ID)  FROM Astro)",null);
            if (result.moveToFirst()) {
                do {
                    ultimoId = result.getInt(0);
                } while(result.moveToNext());
            }
            baseDatos.close();
        }catch (Exception e){
            e.printStackTrace();

        }
        return ultimoId;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Astro obtenerPorId(int id) {
        Astro a = new Astro();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();

            Cursor c =baseDatos.rawQuery("SELECT * FROM Astro WHERE id= '" + id + "'",null);

            if (c.moveToFirst()){
                do {
                    a.setId(c.getInt(0));
                    a.setSalidaSol(c.getDouble(1));
                    a.setPuestaSol(c.getDouble(2));
                    a.setTipoLuna(TipoLuna.getTipoLuna(c.getInt(3)));


                }while (c.moveToNext());


            }





        } catch (Exception e) {

        }

        return a;
    }
    public List<Astro> obtenerTodos() {
        Astro a = null;

        List <Astro> astros = new ArrayList<>();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();

            Cursor c =baseDatos.rawQuery("SELECT * FROM Astro ",null);



            if (c.moveToFirst()){
                do {
                    a = new Astro();
                    a.setId(c.getInt(0));
                    a.setSalidaSol(c.getDouble(1));
                    a.setPuestaSol(c.getDouble(2));
                    a.setTipoLuna(TipoLuna.getTipoLuna(c.getInt(3)));
                    astros.add(a);


                }while (c.moveToNext());


            }





        } catch (Exception e) {
            e.printStackTrace();

        }

        return astros;
    }







}

