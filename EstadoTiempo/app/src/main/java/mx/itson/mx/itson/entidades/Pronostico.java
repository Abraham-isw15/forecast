package mx.itson.mx.itson.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.itson.database.ClimaDB;
import mx.itson.enumeradores.Dia;

/**
 * Created by Propietario on 08/08/2015.
 */
public class Pronostico implements Serializable {

    Context context;
    public Pronostico(){    }
    public Pronostico(Context context){this.context=context;}


    private int id;
    private String ciudad;
    private Dia dia;
    private EstadoTiempo estadoTiempo;
    private Viento viento;
    private int presion;
    private Astro astro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public EstadoTiempo getEstadoTiempo() {
        return estadoTiempo;
    }

    public void setEstadoTiempo(EstadoTiempo estadoTiempo) {
        this.estadoTiempo = estadoTiempo;
    }

    public Viento getViento() {
        return viento;
    }

    public void setViento(Viento viento) {
        this.viento = viento;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }


    public void agregar(){
        try {
            ClimaDB bd = new ClimaDB(context,"ClimaDB",null,1);
            SQLiteDatabase baseDatos = bd.getReadableDatabase();

            this.estadoTiempo.setContext(context);
            this.viento.setContext(context);
            this.astro.setContext(context);

            int idestadoTiempo = estadoTiempo.agregar();
            int idViento = viento.agregar();
            int idAstro = astro.agregar();


            baseDatos.execSQL("INSERT INTO Pronostico"+
                    "(ciudad,"+
                    "dia,"+
                    "idEstadoTiempo,"+
                    "idViento,"+
                    "presion,"+
                    "idAstro)"+
                    "Values"+
                    "('"+this.ciudad+"','"+this.dia.getValor()+"','"+idestadoTiempo+"','"+idViento+"','"+this.presion+"','"+idAstro+"')");
            baseDatos.close();
        }catch (Exception e){
        }}

    public Pronostico obtenerPorId(int id) {
        Pronostico p = new Pronostico();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();

            Cursor c =baseDatos.rawQuery("SELECT * FROM Pronostico WHERE id= '" + id + "'",null);

            if (c.moveToFirst()){
                do {
                    p.setId(c.getInt(0));
                    p.setCiudad(c.getString(1));
                    p.setDia(Dia.getDia(c.getInt(2)));
                    p.setPresion(c.getInt(3));
                    p.setEstadoTiempo(new EstadoTiempo(context).obtenerPorId(c.getInt(4)));
                    p.setViento(new Viento(context).obtenerPorId(c.getInt(5)));
                    p.setAstro(new Astro(context).obtenerPorId(c.getInt(6)));



                }while (c.moveToNext());


            }





        } catch (Exception e) {

        }

        return p;
    }
    public List<Pronostico> obtenerTodos() {
        Pronostico p = null;

        List <Pronostico> pronosticos = new ArrayList<>();
        try {

            ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
            SQLiteDatabase baseDatos = db.getReadableDatabase();
            Cursor c =baseDatos.rawQuery("SELECT * FROM Pronostico ",null);



            if (c.moveToFirst()){
                do {
                    p = new Pronostico();
                    p.setCiudad(c.getString(1));
                    p.setDia(Dia.getDia(c.getInt(2)));
                    p.setPresion(c.getInt(3));
                    p.setEstadoTiempo(new EstadoTiempo(context).obtenerPorId(c.getInt(4)));
                    p.setViento(new Viento(context).obtenerPorId(c.getInt(5)));
                    p.setAstro(new Astro(context).obtenerPorId(c.getInt(6)));
                    pronosticos.add(p);

                }while (c.moveToNext());


            }





        } catch (Exception e){

            e.printStackTrace();

        }

        return pronosticos;
    }
    public void setContext(Context contexto) {
        // TODO Auto-generated method stub
        this.context = contexto;


    }

}

