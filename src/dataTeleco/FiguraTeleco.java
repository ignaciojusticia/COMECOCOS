
package dataTeleco;

import java.util.Vector;

public class FiguraTeleco {

    public static final int IZQUIERDA = 0;
    public static final int DERECHA = 1;
    public static final int ABAJO = 2;
    public static final int ARRIBA = 3;
    public static final int PARADO = 4;

    private int elemento = 0;
    public static int xorigen;
    public static int yorigen;
    public int x = 0;
    public int y = 0;
    public static int direccion;
    public int offset = 0;

    public FiguraTeleco(int entero) {
        elemento = entero;
    }


    public static FiguraTeleco nuevaFigura() {
        FiguraTeleco fig = new FiguraTeleco(0);
        direccion = PARADO;
        fig.xorigen = 11;
        fig.yorigen = 21;

        return fig;
    }


    public int getXOrigen() {
        return xorigen;
    }


    public int getYOrigen() {
        return yorigen;
    }

    public int getElement() {
        return elemento;
    }

    public void mueve(int direccion) {
        this.direccion = direccion;
        offset++;
        if (offset == 3) {
            if (direccion == ABAJO) {
                yorigen++;
            } else if (direccion == IZQUIERDA) {
                xorigen--;
            } else if (direccion == DERECHA) {
                xorigen++;
            } else if (direccion == ARRIBA) {
                yorigen--;
            }
            offset = 0;
        }
    }
}