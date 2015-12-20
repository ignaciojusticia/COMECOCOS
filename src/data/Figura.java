package data;

/**
 * La clase Figura es la encargada representar al Pacman.
 *
 * @author Ignacio y Alejandro
 */
import java.util.Vector;

public class Figura {

    /**
     * Representa la dirección izquierda del Pacman. Por defecto le asignamos el
     * valor 0.
     */
    public static final int IZQUIERDA = 0;
    /**
     * Representa la dirección derecha del Pacman. Por defecto le asignamos el
     * valor 1.
     */
    public static final int DERECHA = 1;
    /**
     * Representa la dirección abajo del Pacman. Por defecto le asignamos el
     * valor 2.
     */
    public static final int ABAJO = 2;
    /**
     * Representa la dirección arriba del Pacman. Por defecto le asignamos el
     * valor 3.
     */
    public static final int ARRIBA = 3;
    /**
     * Representa el estado parado del Pacman. Por defecto le asignamos el valor
     * 4.
     */
    public static final int PARADO = 4;
    /**
     * Representa la coordenada X de la posición del Pacman.
     */
    public static int xorigen;
    /**
     * Representa la coordenada Y de la posición del Pacman.
     */
    public static int yorigen;
    /**
     * En esta variable se guarda el valor de la dirección.
     */
    private static int direccion;
    /**
     * Representa la variación de posición dentro de cada celda para que el
     * movimiento del comecocos sea continuo
     */
    private int offset = 0;

    /**
     * Constructor por defecto de la clase
     */
    public Figura() {

    }

    /**
     * Método utilizado para crear una figura (un Pacman), llamando al
     * constructor por defecto de la clase. Se establece la dirección como
     * PARADO. La posición inicial del comecocos dentro del tablero la fijamos a
     * x=12, y=22. El método finalmente devuelve el objeto de tipo Figura, el
     * Pacman.
     *
     * @return fig
     */
    public static Figura nuevaFigura() {
        Figura fig = new Figura();
        direccion = PARADO;
        fig.xorigen = 12;
        fig.yorigen = 22;

        return fig;
    }

    /**
     * Método encargado de controlar la direccion del Pacman. El movimiento de
     * una celda a otra se produce cuando el offset alcanza el valor 3 (como se
     * empieza en cero, se realiza cuatro veces). El movimiento de una celda a
     * otra se puede producir para las cuatro direcciones (arriba, abajo,
     * izquierda y derecha).
     *
     * @param direccion de tipo int.
     *
     */
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

    /**
     * Método que devuelve la posición de la coordenada X de la posición del
     * Pacman.
     *
     * @return xorigen
     */
    public int getXorigen() {
        return xorigen;
    }

    /**
     * Método que devuelve la posición de la coordenada Y de la posición del
     * Pacman.
     *
     * @return yorigen
     */
    public int getYOrigen() {
        return yorigen;
    }

    /**
     * Método que devuelve la dirección actual del Pacman.
     *
     * @return direccion
     */
    public static int getDireccion() {
        return direccion;
    }

    /**
     * Método que devuelve la variable offset que utilizamos para hacer el
     * movimiento del Pacman más realista.
     *
     * @return offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Método encargado de establecer la dirección del Pacman entre las
     * posibilidades (parado, izquierda, derecha, arriba, abajo).
     *
     * @param direccion de tipo int.
     *
     */
    public static void setDireccion(int direccion) {
        Figura.direccion = direccion;
    }

    /**
     * Método encargado de fijar el valor del dato miembro offset.
     *
     * @param offset de tipo int.
     *
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
