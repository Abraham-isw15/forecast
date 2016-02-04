package mx.itson.enumeradores;

/**
 * Created by Propietario on 08/08/2015.
 */
public enum Riesgo {


    BAJO(0),MODERADO(1),ALTO(2),EXTREMADAMENTEALTO(3);

    private int valor;

    Riesgo(int valor){
        this.valor=valor;
    }


    public  int getValor(){
        return this.valor;
    }

//Esto es un método.
    public static Riesgo getRiesgo(int valor){

        Riesgo r = null;

        switch (valor){
            case 0: r= BAJO;break;
            case 1: r= MODERADO;break;
            case 2: r= ALTO;break;
            case 3: r= EXTREMADAMENTEALTO;break;

        }return r;

    }




}
