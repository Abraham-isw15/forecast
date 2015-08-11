package mx.itson.mx.itson.entidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.itson.database.ClimaDB;
import mx.itson.enumeradores.DireccionViento;

/**
 * Created by Propietario on 08/08/2015.
 */
    public class Viento  implements Serializable {

        Context context;
        public Context getContext() {
            return context;
        }
        public void setContext(Context context) {
            this.context = context;
        }
        public Viento(){    }
        public Viento(Context context){this.context=context;}

        private int id;
        private double valor;
        private double minimo;
        private double maximo;
        private DireccionViento direccionViento;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public double getMinimo() {
            return minimo;
        }

        public void setMinimo(double minimo) {
            this.minimo = minimo;
        }

        public double getMaximo() {
            return maximo;
        }

        public void setMaximo(double maximo) {
            this.maximo = maximo;
        }

        public DireccionViento getDireccionViento() {
            return direccionViento;
        }

        public void setDireccionViento(DireccionViento direccionViento) {
            this.direccionViento = direccionViento;
        }
        public int agregar(){
            int ultimoId = 0;
            try {
                ClimaDB bd = new ClimaDB(context,"ClimaDB",null,1);
                SQLiteDatabase baseDatos = bd.getReadableDatabase();
                baseDatos.execSQL("INSERT INTO Viento"+
                        "(valor,"+
                        "minimo,"+
                        "maximo,"+
                        "direccionViento)"+
                        "Values"+
                        "('"+this.valor+"','"+this.minimo+"','"+this.maximo+"','"+this.direccionViento.getValor()+"')");
                Cursor result = baseDatos.rawQuery("SELECT * FROM Viento WHERE ID = (SELECT MAX(ID)  FROM Viento)",null);
                if (result.moveToFirst()) {
                    do {
                        ultimoId = result.getInt(0);
                    } while(result.moveToNext());
                }
                baseDatos.close();
            }catch (Exception e){
            }
            return ultimoId;}

        public Viento obtenerPorId(int id) {
            Viento v = new Viento();
            try {

                ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
                SQLiteDatabase baseDatos = db.getReadableDatabase();

                Cursor c =baseDatos.rawQuery("SELECT * FROM Viento WHERE id= '" + id + "'",null);

                if (c.moveToFirst()){
                    do {
                        v.setId(c.getInt(0));
                        v.setValor(c.getDouble(1));
                        v.setMinimo(c.getDouble(2));
                        v.setMaximo(c.getDouble(3));
                        v.setDireccionViento(DireccionViento.getDireccionViento(4));



                    }while (c.moveToNext());


                }





            } catch (Exception e) {

            }

            return v;
        }
        public List<Viento> obtenerTodos() {
            Viento v = new Viento();

            List <Viento> vientos = new ArrayList<>();
            try {

                ClimaDB db = new ClimaDB(context, "ClimaDB", null, 1);
                SQLiteDatabase baseDatos = db.getReadableDatabase();

                Cursor c =baseDatos.rawQuery("SELECT * FROM Viento ",null);



                if (c.moveToFirst()){
                    do {
                        v.setId(c.getInt(0));
                        v.setValor(c.getDouble(1));
                        v.setMinimo(c.getDouble(2));
                        v.setMaximo(c.getDouble(3));
                        v.setDireccionViento(DireccionViento.getDireccionViento(4));

                        vientos.add(v);


                    }while (c.moveToNext());


                }





            } catch (Exception e) {

            }

            return vientos ;
        }




    }





