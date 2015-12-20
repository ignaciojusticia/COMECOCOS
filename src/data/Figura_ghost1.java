package data;

import java.util.Vector;

/**
 * La clase Figura_ghost1 es la encargada representar al fantasma 1.
 *
 * @author Ignacio y Alejandro
 */
public class Figura_ghost1 {

    /**
     * Representa la dirección izquierda del fantasma. Por defecto le asignamos
     * el valor 0.
     */
    public static final int IZQUIERDA = 0;
    /**
     * Representa la dirección derecha del fantasma. Por defecto le asignamos el
     * valor 1.
     */
    public static final int DERECHA = 1;
    /**
     * Representa la dirección abajo del fantasma. Por defecto le asignamos el
     * valor 2.
     */
    public static final int ABAJO = 2;
    /**
     * Representa la dirección arriba del fantasma. Por defecto le asignamos el
     * valor 3.
     */
    public static final int ARRIBA = 3;
    /**
     * Representa el estado parado del fantasma. Por defecto le asignamos el
     * valor 4.
     */
    public static final int PARADO = 4;

    /**
     * Representa la coordenada X de la posición del fantasma.
     */
    private static int xorigen;

    /**
     * Representa la coordenada Y de la posición del fantasma.
     */
    private static int yorigen;

    /**
     * En esta variable se guarda el valor de la dirección.
     */
    public static int direccion;

    /**
     * Define el estado del fantasma: si se puede comer o no
     */
    private static boolean comestible = false;

    /**
     * Constructor por defecto
     */
    public Figura_ghost1() {

    }

    /**
     * Método que crea una un fantasma llamando al constructor por defecto de la
     * clase. La posición inicial del primer fantasma dentro del tablero la
     * fijamos a x=11, y=13.
     *
     *
     * @return fan
     */
    public static Figura_ghost1 nuevoFantasma() {
        Figura_ghost1 fan = new Figura_ghost1();
        direccion = 3;
        fan.xorigen = 11;
        fan.yorigen = 13;

        return fan;
    }

    /**
     * Método que devuelve la posición de la coordenada X de la posición del
     * fantasma.
     *
     * @return xorigen
     */
    public static int getXorigen() {
        return xorigen;
    }

    /**
     * Método que se encarga de fijar el valor del dato miembro xorigen.
     *
     * @param xorigen de tipo int.
     *
     */
    public static void setXorigen(int xorigen) {
        Figura_ghost1.xorigen = xorigen;
    }

    /**
     * Método que devuelve la posición de la coordenada Y de la posición del
     * fantasma.
     *
     * @return yorigen
     */
    public static int getYorigen() {
        return yorigen;
    }

    /**
     * Método que se encarga de fijar el valor del dato miembro yorigen.
     *
     * @param yorigen de tipo int.
     *
     */
    public static void setYorigen(int yorigen) {
        Figura_ghost1.yorigen = yorigen;
    }

    /**
     * Método que devuelve el valor del dato miembro comestible
     *
     * @return comestible
     */
    public static boolean isComestible() {
        return comestible;
    }

    /**
     * Método que se encarga de fijar el valor del dato miembro comestible.
     *
     * @param comestible de tipo boolean.
     *
     */
    public static void setComestible(boolean comestible) {
        Figura_ghost1.comestible = comestible;
    }

    /**
     * Método que devuelve la posición de la coordenada X de la posición del
     * fantasma.
     *
     * @return xorigen
     */
    public int getXOrigen() {
        return xorigen;
    }

    /**
     * Método que devuelve la dirección del fantasma.
     *
     * @return direccion
     */
    public static int getDireccion() {
        return direccion;
    }

    /**
     * Método que devuelve la posición de la coordenada Y de la posición del
     * fantasma.
     *
     * @return yorigen
     */
    public int getYOrigen() {
        return yorigen;
    }

    /**
     * Método que recibe como entrada un dato de tipo entero (direccion). La
     * diferencia principal con el método mueve es el offset. En este caso, el
     * movimiento del fantasma no se produce paso a paso como en el caso del
     * comecocos, sino que cada fantasma salta directamente de una celda a otra
     * (en la dirección que corresponda).
     *
     * @param direccion de tipo int.
     *
     */
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
