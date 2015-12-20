package data;

import java.util.Vector;

/**
 * La clase Figura_ghost1 es la encargada representar al fantasma 1.
 *
 * @author Ignacio y Alejandro
 */
public class Figura_ghost1 {

    /**
     * Representa la direcci�n izquierda del fantasma. Por defecto le asignamos
     * el valor 0.
     */
    public static final int IZQUIERDA = 0;
    /**
     * Representa la direcci�n derecha del fantasma. Por defecto le asignamos el
     * valor 1.
     */
    public static final int DERECHA = 1;
    /**
     * Representa la direcci�n abajo del fantasma. Por defecto le asignamos el
     * valor 2.
     */
    public static final int ABAJO = 2;
    /**
     * Representa la direcci�n arriba del fantasma. Por defecto le asignamos el
     * valor 3.
     */
    public static final int ARRIBA = 3;
    /**
     * Representa el estado parado del fantasma. Por defecto le asignamos el
     * valor 4.
     */
    public static final int PARADO = 4;

    /**
     * Representa la coordenada X de la posici�n del fantasma.
     */
    private static int xorigen;

    /**
     * Representa la coordenada Y de la posici�n del fantasma.
     */
    private static int yorigen;

    /**
     * En esta variable se guarda el valor de la direcci�n.
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
     * M�todo que crea una un fantasma llamando al constructor por defecto de la
     * clase. La posici�n inicial del primer fantasma dentro del tablero la
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
     * M�todo que devuelve la posici�n de la coordenada X de la posici�n del
     * fantasma.
     *
     * @return xorigen
     */
    public static int getXorigen() {
        return xorigen;
    }

    /**
     * M�todo que se encarga de fijar el valor del dato miembro xorigen.
     *
     * @param xorigen de tipo int.
     *
     */
    public static void setXorigen(int xorigen) {
        Figura_ghost1.xorigen = xorigen;
    }

    /**
     * M�todo que devuelve la posici�n de la coordenada Y de la posici�n del
     * fantasma.
     *
     * @return yorigen
     */
    public static int getYorigen() {
        return yorigen;
    }

    /**
     * M�todo que se encarga de fijar el valor del dato miembro yorigen.
     *
     * @param yorigen de tipo int.
     *
     */
    public static void setYorigen(int yorigen) {
        Figura_ghost1.yorigen = yorigen;
    }

    /**
     * M�todo que devuelve el valor del dato miembro comestible
     *
     * @return comestible
     */
    public static boolean isComestible() {
        return comestible;
    }

    /**
     * M�todo que se encarga de fijar el valor del dato miembro comestible.
     *
     * @param comestible de tipo boolean.
     *
     */
    public static void setComestible(boolean comestible) {
        Figura_ghost1.comestible = comestible;
    }

    /**
     * M�todo que devuelve la posici�n de la coordenada X de la posici�n del
     * fantasma.
     *
     * @return xorigen
     */
    public int getXOrigen() {
        return xorigen;
    }

    /**
     * M�todo que devuelve la direcci�n del fantasma.
     *
     * @return direccion
     */
    public static int getDireccion() {
        return direccion;
    }

    /**
     * M�todo que devuelve la posici�n de la coordenada Y de la posici�n del
     * fantasma.
     *
     * @return yorigen
     */
    public int getYOrigen() {
        return yorigen;
    }

    /**
     * M�todo que recibe como entrada un dato de tipo entero (direccion). La
     * diferencia principal con el m�todo mueve es el offset. En este caso, el
     * movimiento del fantasma no se produce paso a paso como en el caso del
     * comecocos, sino que cada fantasma salta directamente de una celda a otra
     * (en la direcci�n que corresponda).
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
