package mx.itson.enumeradores;

/**
 * Created by Propietario on 26/06/2015.
 */
public enum Dia {
    LUNES(0),MARTES(1),MIERCOLES(2),JUEVES(3),VIERNES(4),SABADO(5),DOMINGO(6);

    private int valor;
    Dia(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return this.valor;
    }
    public static Dia getDia(int valor){

        Dia d =null;
        switch (valor){
            case 0: d= LUNES;break;
            case 1: d= MARTES;break;
            case 2: d= MIERCOLES;break;
            case 3: d= JUEVES;break;
            case 4: d= VIERNES;break;
            case 5: d= SABADO; break;
            case 6: d= DOMINGO;break;

        }
        return d;
    }


}