package data;

/**
 * La clase Rejilla representa una rejilla con una determinada anchura y altura.
 * Es la clase que contiene el String a partir del cual se crea el laberinto.
 *
 * @author Ignacio y Alejandro
 */
import comecocos.*;

public class Rejilla {

    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char uno = '1';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char dos = '2';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char tres = '3';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char cuatro = '4';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char cinco = '5';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char seis = '6';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char siete = '7';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char ocho = '8';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char A = 'A';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char B = 'B';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char D = 'D';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char E = 'E';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char I = 'I';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char P = 'P';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char a = 'a';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char b = 'b';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char d = 'd';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char e = 'e';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char f = 'f';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char g = 'g';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char h = 'h';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char i = 'i';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char m = 'm';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char n = 'n';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char punto = '.';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char nada = ' ';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char o = 'o';
    /**
     * Representa un tipo de pieza del laberinto.
     */

    public static final char w = 'w';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char x = 'x';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char y = 'y';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char z = 'z';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char r = 'r';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char s = 's';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char t = 't';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char u = 'u';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char nueve = '9';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char diez = '=';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char once = '!';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char doce = '/';
    /**
     * Representa un tipo de pieza del laberinto.
     */
    public static final char aux = '<';

    /**
     * Representa la anchura de la rejilla.
     */
    private int anchura;
    /**
     * Representa la altura de la rejilla.
     */
    private int altura;
    /**
     * Representa la matriz que contiene qué es cada elemento del laberinto.
     */
    private char[][] matriz = new char[altura][anchura];
    /**
     * Representa la rejilla desde la cual se creará la matriz de piezas, y
     * posteriormente el laberinto.
     */
    private String rejilla[] = {
        "1AAAAAAAAAAAAfeAAAAAAAAAAAA2",
        "I............di............D",
        "I.5BB6.5BBB6.di.5BBB6.5BB6.D",
        "IoD  I.D   I.di.D   I.D  IoD",
        "I.7AA8.7AAA8.78.7AAA8.7AA8.D",
        "I..........................D",
        "I.5bb6.56.5bbbbbb6.56.5bb6.D",
        "I.7aa8.di.7aa65aa8.di.7aa8.D",
        "I......di....di....di......D",
        "3BBBB6.d7bb6 di 5bb8i.5BBBB4",
        "     I.d5aa8 78 7aa6i.D     ",
        "     I.di          di.D     ",
        "     I.di 5BPPPPB6 di.D     ",
        "AAAAA8.78 D      I 78.7AAAAA",
        "      .   D      I   .      ",
        "BBBBB6.56 D      I 56.5BBBBB",
        "     I.di 7AAAAAA8 di.D     ",
        "     I.di          di.D     ",
        "     I.di 5bbbbbb6 di.D     ",
        "1AAAA8.78 7aa65aa8 78.7AAAA2",
        "I............di............D",
        "I.5bb6.5bbb6.di.5bbb6.5bb6.D",
        "I.7a6i.7aaa8.78.7aaa8.d5a8.D",
        "Io..di................di..oD",
        "gb6.di.56.5bbbbbb6.56.di.5bm",
        "ha8.78.di.7aa65aa8.di.78.7an",
        "I......di....di....di......D",
        "I.5bbbb87bb6.di.5bb87bbbb6.D",
        "I.7aaaaaaaa8.78.7aaaaaaaa8.D",
        "I..........................D",
        "3BBBBBBBBBBBBBBBBBBBBBBBBBB4"};

    /**
     * Constructor en el que se lee el String rejilla y se almacena en una
     * matriz de char.
     *
     * @param w de tipo int.
     * @param h de tipo int.
     *
     */
    public Rejilla(int w, int h) {
        altura = w;
        anchura = h;
        matriz = new char[altura][anchura];

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                matriz[i][j] = rejilla[i].charAt(j);
            }
        }
    }

    /**
     * Método que devuelve el dato miembro anchura.
     *
     * @return anchura
     */
    public int getAnchura() {
        return anchura;
    }

    /**
     * Método que devuelve el dato miembro altura.
     *
     * @return altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Método que devuelve un char con el tipo de celda del elemento solicitado.
     *
     * @param x de tipo int.
     * @param y de tipo int.
     * @return anchura
     */
    public char getTipoCelda(int x, int y) {
        return matriz[x][y];
    }

    /**
     * Método que comprueba que la celda siguiente siguiendo en la dirección que
     * va el Pacman sea diferente a un punto chico, gordo o nada. Si esta celda
     * siguiente no es de ninguno de esos tres tipos, quiere decir que el Pacman
     * se chocaría y devuelve true.
     *
     * @param fig de tipo Figura.
     * @param direccion de tipo int.
     * @return true/false
     */
    public boolean seChoca(Figura fig, int direccion) {
        if (direccion == Figura.ABAJO) {
            if ((matriz[fig.getYOrigen() + 2][fig.getXorigen() + 1] != punto)
                    && (matriz[fig.getYOrigen() + 2][fig.getXorigen() + 1] != nada)
                    && (matriz[fig.getYOrigen() + 2][fig.getXorigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura.IZQUIERDA) {
            if ((matriz[fig.getYOrigen() + 1][fig.getXorigen()] != punto)
                    && (matriz[fig.getYOrigen() + 1][fig.getXorigen()] != nada)
                    && (matriz[fig.getYOrigen() + 1][fig.getXorigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura.DERECHA) {
            if ((matriz[fig.getYOrigen() + 1][fig.getXorigen() + 2] != punto)
                    && (matriz[fig.getYOrigen() + 1][fig.getXorigen() + 2] != nada)
                    && (matriz[fig.getYOrigen() + 1][fig.getXorigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura.ARRIBA) {
            if ((matriz[fig.getYOrigen()][fig.getXorigen() + 1] != punto)
                    && (matriz[fig.getYOrigen()][fig.getXorigen() + 1] != nada)
                    && (matriz[fig.getYOrigen()][fig.getXorigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que comprueba que la celda siguiente siguiendo en la dirección que
     * va el fantasma 1 sea diferente a un punto chico, gordo o nada. Si esta
     * celda siguiente no es de ninguno de esos tres tipos, quiere decir que el
     * Pacman se chocaría y devuelve true.
     *
     * @param fan de tipo Figura_ghost1.
     * @param direccion de tipo int.
     * @return true/false
     */
    public boolean seChocaFantasma1(Figura_ghost1 fan, int direccion) {
        if (direccion == Figura_ghost1.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost1.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost1.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost1.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que comprueba que la celda siguiente siguiendo en la dirección que
     * va el fantasma 2 sea diferente a un punto chico, gordo o nada. Si esta
     * celda siguiente no es de ninguno de esos tres tipos, quiere decir que el
     * Pacman se chocaría y devuelve true.
     *
     * @param fan de tipo Figura_ghost2.
     * @param direccion de tipo int.
     * @return true/false
     */
    public boolean seChocaFantasma2(Figura_ghost2 fan, int direccion) {
        if (direccion == Figura_ghost2.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost2.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost2.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost2.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que comprueba que la celda siguiente siguiendo en la dirección que
     * va el fantasma 3 sea diferente a un punto chico, gordo o nada. Si esta
     * celda siguiente no es de ninguno de esos tres tipos, quiere decir que el
     * Pacman se chocaría y devuelve true.
     *
     * @param fan de tipo Figura_ghost3.
     * @param direccion de tipo int.
     * @return true/false
     */
    public boolean seChocaFantasma3(Figura_ghost3 fan, int direccion) {
        if (direccion == Figura_ghost3.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost3.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost3.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost3.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que comprueba que la celda siguiente siguiendo en la dirección que
     * va el fantasma 4 sea diferente a un punto chico, gordo o nada. Si esta
     * celda siguiente no es de ninguno de esos tres tipos, quiere decir que el
     * Pacman se chocaría y devuelve true.
     *
     * @param fan de tipo Figura_ghost4.
     * @param direccion de tipo int.
     * @return true/false
     */
    public boolean seChocaFantasma4(Figura_ghost4 fan, int direccion) {
        if (direccion == Figura_ghost4.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost4.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost4.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost4.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que establece el tipo de celda en las coordenadas x e y de la
     * matriz
     *
     * @param x coordenada x
     * @param y coordenada y
     * @param valor el tipo de pieza
     */
    public void assignTipoCelda(int x, int y, char valor) {
        matriz[x][y] = valor;
    }

    /**
     * Método que permite inicializar la rejilla del laberinto. Se llama a este
     * método cada vez que se quiere reiniciar el juego, pues vuelve a leer
     * todos los datos necesarios para crear la matriz de char desde el String
     * inicial.
     *
     */
    public void initRejilla() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                matriz[i][j] = rejilla[i].charAt(j);
            }
        }
    }
}
