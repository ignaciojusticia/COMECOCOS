package dataTeleco;

public class RejillaTeleco {

    public static final char uno = '1';
    public static final char dos = '2';
    public static final char tres = '3';
    public static final char cuatro = '4';
    public static final char cinco = '5';
    public static final char seis = '6';
    public static final char siete = '7';
    public static final char ocho = '8';
    public static final char A = 'A';
    public static final char B = 'B';
    public static final char D = 'D';
    public static final char E = 'E';
    public static final char I = 'I';
    public static final char P = 'P';
    public static final char a = 'a';
    public static final char b = 'b';
    public static final char d = 'd';
    public static final char e = 'e';
    public static final char f = 'f';
    public static final char g = 'g';
    public static final char h = 'h';
    public static final char i = 'i';
    public static final char m = 'm';
    public static final char n = 'n';
    public static final char punto = '.';
    public static final char nada = ' ';
    public static final char o = 'o';

    public static final char w = 'w';
    public static final char x = 'x';
    public static final char y = 'y';
    public static final char z = 'z';
    public static final char r = 'r';
    public static final char s = 's';
    public static final char t = 't';
    public static final char u = 'u';
    public static final char j = 'j';
    public static final char k = 'k';
    public static final char l = 'l';
    public static final char ñ = 'ñ';
    public static final char qi = 'q';
    public static final char qd = '_';
    public static final char nueve = '9';
    public static final char diez = '=';
    public static final char once = '!';
    public static final char doce = '/';

    private int anchura;
    private int altura;
    char[][] matriz = new char[altura][anchura];
    String rejilla[] = {
        "1AAAAAAAAAAAfeAAfeAAfeAAfeAAAAAAAAAAA2",
        "I...........di..di..di..di...........D",
        "I.9bbbbbbb=.di..78..78..di.56.5b6.56.D",
        "I.d       i.78..........78.78.7a8.78.D",
        "I.!aa= 9aa/..........................D",
        "I....d i.......9=.........9bb=.......D",
        "gb6..d i.9bbb=.di...9bbb=.d9a/.9bbb=.D",
        "ha8..d i.d9aa/.di...d9aa/.di...d   i.D",
        "I....d i.di....di...di....di...d   i.D",
        "I.56.d i.d!b=..di...d!b=..di...d k i.D",
        "I.di.d i.d9a/..d!b=.d9a/..d!b=.d ñ i.D",
        "I.di.!a/.dio...!aa/.dio...!aa/.d   i.D",
        "I.di.....d!bb=......d!bb=......d   i.D",
        "I.78.5b6.!aaa/.5BB6.!aaa/.5bb6.!aaa/.D",
        "I....7a8.......D  I.......7aa8.......D",
        "I.........rbb6.7AA8.          ...5bbb_",
        "I........9/ra8...... 5BPPPPB6 56.draa8",
        "8  56.5bb89/....5bb6 D      I di.di   ",
        "   di.7aaa8..jl.dra8 D      I di.78  5",
        "5bb8i...........di.. D      I di.....D",
        "qaaa8.wbbbbbbbx.di.. 7AAAAAA8 di.5b6.D",
        "I.....yaax waaz.78..          78.7a8.D",
        "I...k....d i.........................D",
        "I..j l...d i.wbbbbbbx.wxwbx.wbbbbbbx.D",
        "I...ñ....d i.d waaaxi.did i.d waaaxi.D",
        "I........d i.d i...di.didwz.d i...di.D",
        "I.wbbx...d i.d yxowzi.didi..d yxowzi.D",
        "I.d  i.o.d i.d wz.yxi.didi..d wz.yxi.D",
        "I.d  ybbbz i.d i...di.dyzi..d i...di.D",
        "I.yaaaaaaaaz.yaz...yz.yaaz..yaz...yz.D",
        "I....................................D",
        "3BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB4"
    };

    public RejillaTeleco(int w, int h) {
        altura = w;
        anchura = h;
        matriz = new char[altura][anchura];

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                matriz[i][j] = rejilla[i].charAt(j);
            }
        }
    }

    public RejillaTeleco() {
        System.out.println("filas: " + rejilla.length);
        System.out.println("col: " + rejilla[0].length());
        System.out.println(rejilla[0].charAt(0) + " " + rejilla[1].charAt(0));

        for (int i = 0; i < rejilla.length; i++) {
            for (int j = 0; j < rejilla[0].length(); j++) {
                matriz[i][j] = rejilla[i].charAt(j);
            }
        }

    }

    public int getAnchura() {
        return anchura;
    }

    public int getAltura() {
        return altura;
    }

    public char getTipoCelda(int x, int y) {
        return matriz[x][y];
    }


    public boolean seChoca(FiguraTeleco fig, int direccion) {

        if (direccion == FiguraTeleco.ABAJO) {
            if ((matriz[fig.getYOrigen() + 2][fig.getXOrigen() + 1] != punto)
                    && (matriz[fig.getYOrigen() + 2][fig.getXOrigen() + 1] != nada)
                    && (matriz[fig.getYOrigen() + 2][fig.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == FiguraTeleco.IZQUIERDA) {
            if ((matriz[fig.getYOrigen() + 1][fig.getXOrigen()] != punto)
                    && (matriz[fig.getYOrigen() + 1][fig.getXOrigen()] != nada)
                    && (matriz[fig.getYOrigen() + 1][fig.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == FiguraTeleco.DERECHA) {
            if ((matriz[fig.getYOrigen() + 1][fig.getXOrigen() + 2] != punto)
                    && (matriz[fig.getYOrigen() + 1][fig.getXOrigen() + 2] != nada)
                    && (matriz[fig.getYOrigen() + 1][fig.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == FiguraTeleco.ARRIBA) {
            if ((matriz[fig.getYOrigen()][fig.getXOrigen() + 1] != punto)
                    && (matriz[fig.getYOrigen()][fig.getXOrigen() + 1] != nada)
                    && (matriz[fig.getYOrigen()][fig.getXOrigen() + 1] != o)) {
                return true;
            }
        }

        return false;
    }

    public boolean seChocaFantasma1(Figura_ghost1T fan, int direccion) {
        if (direccion == Figura_ghost1T.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost1T.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost1T.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost1T.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    public boolean seChocaFantasma2(Figura_ghost2T fan, int direccion) {
        if (direccion == Figura_ghost2T.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost2T.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost2T.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost2T.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    public boolean seChocaFantasma3(Figura_ghost3T fan, int direccion) {
        if (direccion == Figura_ghost3T.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost3T.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost3T.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost3T.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    public boolean seChocaFantasma4(Figura_ghost4T fan, int direccion) {
        if (direccion == Figura_ghost4T.ABAJO) {
            if ((matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen() + 2][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost4T.IZQUIERDA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen()] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost4T.DERECHA) {
            if ((matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != punto)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != nada)
                    && (matriz[fan.getYOrigen() + 1][fan.getXOrigen() + 2] != o)) {
                return true;
            }
        } else if (direccion == Figura_ghost4T.ARRIBA) {
            if ((matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != punto)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != nada)
                    && (matriz[fan.getYOrigen()][fan.getXOrigen() + 1] != o)) {
                return true;
            }
        }
        return false;
    }

    public void assignTipoCelda(int x, int y, char valor) {
        matriz[x][y] = valor;
    }

    public void initRejilla() {

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                matriz[i][j] = rejilla[i].charAt(j);
            }
        }
    }

}
