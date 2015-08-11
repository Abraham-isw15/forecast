package mx.itson.enumeradores;

/**
 * Created by Propietario on 26/06/2015.
 */
public enum DireccionViento {
    NORTE(0),NORESTE(1),ESTE(2),SURESTE(3),SUR(4),SUROESTE(5),OESTE(6),NOROESTE(7);
    private int valor;
    DireccionViento(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return this.valor;
    }
    public static DireccionViento getDireccionViento(int valor){
        DireccionViento dv =null;
        switch (valor){
            case 0: dv= NORTE;break;
            case 1: dv= NORESTE;break;
            case 2: dv= ESTE;break;
            case 3: dv= SURESTE;break;
            case 4: dv= SUR;break;
            case 5: dv= SUROESTE; break;
            case 6: dv= OESTE;break;
            case 7: dv= NOROESTE;break;


        }
        return dv;
    }}