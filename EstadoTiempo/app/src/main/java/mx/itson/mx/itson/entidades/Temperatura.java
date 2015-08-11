package mx.itson.mx.itson.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.itson.database.ClimaDB;

/**
 * Created by Propietario on 08/08/2015.
 */
public class Temperatura implements Serializable {

    Context context;
    public Temperatura(){    }
    public Temperatura(Context context){this.context=context;}


    private int id;
    private double minima;
    private double actual;
    private double maxima;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMinima() {
        return minima;
    }

    public void setMinima(double minima) {
        this.minima = minima;
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    public double getMaxima() {
        return maxima;
    }

    public void setMaxima(double maxima) {
        this.maxima = maxima;
    }


    public int agregar(){
        int ultimoId = 0;
        try {
            ClimaDB bd = new ClimaDB(context,"ClimaDB",null,1);
            SQLiteDatabase baseDatos = bd.getReadableDatabase();
            baseDatos.execSQL("INSERT INTO Temperatura"+
                    "(minima,"+
                    "actual,"+
                    "maxima)"+
                    "Values"+
                    "('"+this.minima+"','"+this.actual+"','"+this.maxima+"')");
            Cursor result = baseDatos.rawQuery("SELECT * FROM Temperatura WHERE ID = (SELECT MAX(ID)  FROM Temperatura)",null);
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
    public Temperatura obtenerPorId(int id) {
        Temperatura t = new Temperatura();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();

            Cursor c =baseDatos.rawQuery("SELECT * FROM Temperatura WHERE id= '" + id + "'",null);

            if (c.moveToFirst()){
                do {
                    t.setId(c.getInt(0));
                    t.setMinima(c.getDouble(1));
                    t.setActual(c.getDouble(2));
                    t.setMaxima(c.getDouble(3));



                }while (c.moveToNext());


            }


        } catch (Exception e) {

        }

        return t;
    }
    public List<Temperatura> obtenerTodos() {
        Temperatura t = null;

        List <Temperatura> temperaturas = new ArrayList<>();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();
            String[] args = new String[] {"id"};
            Cursor c =baseDatos.rawQuery("SELECT * FROM Temperatura ",args);



            if (c.moveToFirst()){
                do {
                    t.setId(c.getInt(0));
                    t.setMinima(c.getDouble(1));
                    t.setActual(c.getDouble(2));
                    t.setMaxima(c.getDouble(3));
                    temperaturas.add(t);


                }while (c.moveToNext());


            }

        } catch (Exception e) {

        }

        return temperaturas;
    }

}
