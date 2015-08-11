package mx.itson.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Propietario on 24/06/2015.
 */
public class ClimaDB  extends SQLiteOpenHelper {

    public ClimaDB(Context contextoActual, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(contextoActual, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {

        // Crea la tabla de Temperatura
        baseDatos.execSQL
                (
                        "CREATE TABLE Temperatura (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "minima REAL, " +
                                "actual REAL, " +
                                "maxima REAL" +
                                ")"
                );

        // Crea la tabla de UV
        baseDatos.execSQL
                (
                        "CREATE TABLE UV (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "valor INTEGER, " +
                                "riesgo INTEGER" +
                                ")"
                );

        // Crea la tabla de EstadoTiempo
        baseDatos.execSQL
                (
                        "CREATE TABLE EstadoTiempo (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "sensacionTermica REAL, " +
                                "humedad REAL, " +
                                "probabilidadLluvia REAL, " +
                                "idTemperatura INTEGER, " +
                                "idUV INTEGER, " +
                                "FOREIGN KEY(idTemperatura) REFERENCES Temperatura(id), " +
                                "FOREIGN KEY(idUV) REFERENCES UV(id)" +
                                ")"
                );

        // Crea la tabla de Viento
        baseDatos.execSQL
                (
                        "CREATE TABLE Viento (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "valor REAL, "+
                                "minimo REAL, " +
                                "maximo REAL, " +
                                "direccionViento INTEGER" +
                                ")"
                );

        // Crea la tabla de Astro
        baseDatos.execSQL
                (
                        "CREATE TABLE Astro (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "salidaSol REAL, " +
                                "puestaSol REAL, " +
                                "tipoLuna INTEGER" +
                                ")"
                );

        // Crea la tabla Pronostico
        baseDatos.execSQL
                (
                        "CREATE TABLE Pronostico (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "ciudad TEXT, " +
                                "dia INTEGER, " +
                                "presion INTEGER, " +
                                "idEstadoTiempo INTEGER, " +
                                "idViento INTEGER,  " +
                                "idAstro INTEGER, FOREIGN KEY(idEstadoTiempo) REFERENCES EstadoTiempo(id), FOREIGN KEY(idAstro) REFERENCES Astro(id), FOREIGN KEY(idViento) REFERENCES Viento(id)" +
                                ")"
                );
    }



    @Override
    public void onUpgrade(SQLiteDatabase baseDatos, int versionAnterior, int versionNueva)  // Se ejecuta cuando se realiza un cambio en la tabla
    {

    }




}
