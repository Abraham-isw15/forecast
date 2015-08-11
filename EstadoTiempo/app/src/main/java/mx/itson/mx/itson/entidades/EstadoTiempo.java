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

public class EstadoTiempo implements Serializable {

    private Context context;
    public EstadoTiempo(){    }
    public EstadoTiempo(Context context){this.setContext(context);}

    private int id;
    private Temperatura temperatura;
    private double sensacionTermica;
    private double humedad;
    private double probabilidadLluvia;
    private UV uv;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public double getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(double sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public double getProbabilidadLluvia() {
        return probabilidadLluvia;
    }

    public void setProbabilidadLluvia(double provavilidadLluvia) {
        this.probabilidadLluvia = provavilidadLluvia;
    }

    public UV getUv() {
        return uv;
    }

    public void setUv(UV uv) {
        this.uv = uv;
    }

    Context getContext() {
        return context;
    }
    void setContext(Context context) {
        this.context = context;
    }
    public int agregar(){
        int ultimoId= 0;
        try {
            ClimaDB bd = new ClimaDB(getContext(),"ClimaDB",null,1);
            SQLiteDatabase baseDatos = bd.getReadableDatabase();


            this.uv.setContext(context);
            this.temperatura.setContext(context);

            int iduv = uv.agregar();
            int idtemperatura = temperatura.agregar();




            baseDatos.execSQL("INSERT INTO EstadoTiempo"+
                    "(idTemperatura,"+
                    "sensacionTermica,"+
                    "humedad,"+
                    "probabilidadLluvia,"+
                    "idUv)"+
                    "Values"+
                    "('"+idtemperatura+"','"+this.sensacionTermica+"','"+this.humedad+"','"+iduv+"','"+this.probabilidadLluvia+"')");
            Cursor result = baseDatos.rawQuery("SELECT * FROM EstadoTiempo WHERE ID = (SELECT MAX(ID)  FROM EstadoTiempo)",null);
            if (result.moveToFirst()) {
                do {
                    ultimoId = result.getInt(0);
                } while(result.moveToNext());
            }
            baseDatos.close();

        }catch (Exception e){
        }
        return ultimoId;}
    public EstadoTiempo obtenerPorId(int id){
        EstadoTiempo eT = new EstadoTiempo();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();
            Cursor c =baseDatos.rawQuery("SELECT * FROM EstadoTiempo WHERE id= '" + id + "'",null);

            if (c.moveToFirst()){
                do {
                    eT.setId(c.getInt(0));
                    eT.setSensacionTermica(c.getDouble(1));
                    eT.setHumedad((c.getDouble(2)));
                    eT.setProbabilidadLluvia((c.getDouble(3)));
                    eT.setTemperatura(new Temperatura(context).obtenerPorId(c.getInt(4)));
                    eT.setUv(new UV(context).obtenerPorId(c.getInt(5)));


                }while (c.moveToNext());

            }





        } catch (Exception e) {

        }

        return eT;
    }
    public List<EstadoTiempo> obtenerTodos() {
        EstadoTiempo eT = null;

        List <EstadoTiempo> estadosTiempo = new ArrayList<>();
        try {

            ClimaDB db = new ClimaDB(getContext(), "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();
            String[] args = new String[] {"id"};
            Cursor c =baseDatos.rawQuery("SELECT * FROM EstadoTiempo ",args);



            if (c.moveToFirst()){
                do {
                    eT.setId(c.getInt(0));
                    eT.setSensacionTermica(c.getDouble(1));
                    eT.setHumedad((c.getDouble(2)));
                    eT.setProbabilidadLluvia((c.getDouble(3)));
                    eT.setTemperatura(new Temperatura(context).obtenerPorId(c.getInt(4)));
                    eT.setUv(new UV(context).obtenerPorId(c.getInt(5)));
                    estadosTiempo.add(eT);


                }while (c.moveToNext());


            }





        } catch (Exception e) {

        }

        return estadosTiempo;
    }
}


