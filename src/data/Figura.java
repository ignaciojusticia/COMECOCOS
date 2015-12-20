package data;

/**
 * La clase Figura es la encargada representar al Pacman.
 *
 * @author Ignacio y Alejandro
 */
import java.util.Vector;

public class Figura {

    /**
     * Representa la direcci�n izquierda del Pacman. Por defecto le asignamos el
     * valor 0.
     */
    public static final int IZQUIERDA = 0;
    /**
     * Representa la direcci�n derecha del Pacman. Por defecto le asignamos el
     * valor 1.
     */
    public static final int DERECHA = 1;
    /**
     * Representa la direcci�n abajo del Pacman. Por defecto le asignamos el
     * valor 2.
     */
    public static final int ABAJO = 2;
    /**
     * Representa la direcci�n arriba del Pacman. Por defecto le asignamos el
     * valor 3.
     */
    public static final int ARRIBA = 3;
    /**
     * Representa el estado parado del Pacman. Por defecto le asignamos el valor
     * 4.
     */
    public static final int PARADO = 4;
    /**
     * Representa la coordenada X de la posici�n del Pacman.
     */
    public static int xorigen;
    /**
     * Representa la coordenada Y de la posici�n del Pacman.
     */
    public static int yorigen;
    /**
     * En esta variable se guarda el valor de la direcci�n.
     */
    private static int direccion;
    /**
     * Representa la variaci�n de posici�n dentro de cada celda para que el
     * movimiento del comecocos sea continuo
     */
    private int offset = 0;

    /**
     * Constructor por defecto de la clase
     */
    public Figura() {

    }

    /**
     * M�todo utilizado para crear una figura (un Pacman), llamando al
     * constructor por defecto de la clase. Se establece la direcci�n como
     * PARADO. La posici�n inicial del comecocos dentro del tablero la fijamos a
     * x=12, y=22. El m�todo finalmente devuelve el objeto de tipo Figura, el
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
     * M�todo encargado de controlar la direccion del Pacman. El movimiento de
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
     * M�todo que devuelve la posici�n de la coordenada X de la posici�n del
     * Pacman.
     *
     * @return xorigen
     */
    public int getXorigen() {
        return xorigen;
    }

    /**
     * M�todo que devuelve la posici�n de la coordenada Y de la posici�n del
     * Pacman.
     *
     * @return yorigen
     */
    public int getYOrigen() {
        return yorigen;
    }

    /**
     * M�todo que devuelve la direcci�n actual del Pacman.
     *
     * @return direccion
     */
    public static int getDireccion() {
        return direccion;
    }

    /**
     * M�todo que devuelve la variable offset que utilizamos para hacer el
     * movimiento del Pacman m�s realista.
     *
     * @return offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * M�todo encargado de establecer la direcci�n del Pacman entre las
     * posibilidades (parado, izquierda, derecha, arriba, abajo).
     *
     * @param direccion de tipo int.
     *
     */
    public static void setDireccion(int direccion) {
        Figura.direccion = direccion;
    }

    /**
     * M�todo encargado de fijar el valor del dato miembro offset.
     *
     * @param offset de tipo int.
     *
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
