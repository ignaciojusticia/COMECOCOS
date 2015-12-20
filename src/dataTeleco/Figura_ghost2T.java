
package dataTeleco;

import java.util.Vector;

public class Figura_ghost2T {

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
    private static boolean comestible = false;

    public Figura_ghost2T(int entero) {
        elemento = entero;
    }

    public static Figura_ghost2T nuevoFantasma() {
        Figura_ghost2T fan = new Figura_ghost2T(0);
        direccion = 0;
        fan.xorigen = 23;
        fan.yorigen = 17;

        return fan;
    }

    public static int getXorigen() {
        return xorigen;
    }

    public static void setXorigen(int xorigen) {
        Figura_ghost2T.xorigen = xorigen;
    }

    public static int getYorigen() {
        return yorigen;
    }

    public static void setYorigen(int yorigen) {
        Figura_ghost2T.yorigen = yorigen;
    }

    public int getXOrigen() {
        return xorigen;
    }

    public static int getDireccion() {
        return direccion;
    }

    public static boolean isComestible() {
        return comestible;
    }

    public static void setComestible(boolean comestible) {
        Figura_ghost2T.comestible = comestible;
    }

    public int getYOrigen() {
        return yorigen;
    }

    public int getElement() {
        return elemento;
    }


    public void mueve(int direccion) {
        this.direccion = direccion;
        if (direccion == ABAJO) {
            yorigen++;
        } else if (direccion == IZQUIERDA) {
            xorigen--;
        } else if (direccion == DERECHA) {
            xorigen++;
        } else if (direccion == ARRIBA) {
            yorigen--;
        }
    }
}
