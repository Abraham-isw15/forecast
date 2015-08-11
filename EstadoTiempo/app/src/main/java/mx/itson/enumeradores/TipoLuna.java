package mx.itson.enumeradores;

/**
 * Created by Propietario on 08/08/2015.
 */

public enum TipoLuna {


    CUARTOMENGUANTE(0), CUARTOCRECIENTE(1), LLENA(2) ,NUEVA(3);

    private int valor;
    TipoLuna(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return this.valor;
    }

    public static TipoLuna getTipoLuna(int valor){
        TipoLuna tL =null;
        switch (valor){
            case 0: tL= CUARTOMENGUANTE;break;
            case 1: tL=CUARTOCRECIENTE;break;
            case 2: tL=LLENA;break;
            case 3: tL=NUEVA;break;
        }

        return tL;
    }



}
