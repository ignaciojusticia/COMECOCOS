package data;

/**
 * La clase Mueve implementa la hebra que hace que se mueva el Pacman
 * continuamente, mientras no se choque, dada una direcci�n.
 *
 * @author Ignacio y Alejandro
 */
import javax.swing.JPanel;
import comecocos.ComecocosFrame;
import data.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Mueve implements Runnable {

    /**
     *
     * Representa el n�mero de milisegundos que se dormir� la hebra en cada
     * iteraci�n del while, es un retardo adicional.
     */
    private int delay;
    /**
     *
     * Representa el proceso de ejecuci�n de la hebra.
     */
    private boolean continuar = true;
    /**
     * Se utilizar para suspeder la hebra hasta nuevo aviso.
     */

    private boolean suspendFlag = true;
    /**
     * Representa la referencia al ComeCocosFrame.
     */
    private ComecocosFrame frame;
    /**
     * Ayuda a escoger una imagen u otra para la figura del Pacman.
     */
    private boolean aux = true;
    /**
     * Permite escoger una imagen u otra del Pacman cada dos pasos entre una
     * celda y otra.
     */
    private int contador = 0;
    /**
     * Permite el n�mero de vidas en el instante actual.
     *
     */
    public static int vidas = 3;
    /**
     * Representa la opci�n de volver a jugar o salir cuando se produce la
     * derrota.
     */
    public static boolean derrota = false;
    /**
     * Representa el tiempo que los fantasmas est�n en estado comestible.
     */
    private static Timer timer1;

    /**
     * Representa el periodo de tiempo que la puerta est� abierta dejando a los
     * fantasmas salir.
     */
    private static Timer timer2;
    /**
     * Representa el estado de inicio o no.
     */
    private static boolean inicio = true;
    /**
     * Representa el estado de los fantasmas: comestibles o no comestibles.
     */
    private boolean comestibles = false;
    /**
     * Representa el estado de los fantasmas (comestibles o no). Se utiliza
     * junto con la variable comestibles.
     */
    private boolean comestibles2 = false;
    /**
     * Representa el n�mero de fantasmas que se han comido tras haber comido un
     * punto gordo. Pasados 8 segundos, los fantasmas que se encontraban en
     * estado comestible vuelven a su estado original.
     */
    private int comidos = 0;
    /**
     * Representa el nivel del juego.
     */
    private int niv;
    /**
     * Representa el n�mero de puntos totales que se pueden llegar a conseguir.
     * Al comer un fantasma comestible, el n�mero de puntos totales que se puede
     * conseguir aumenta.
     */
    private int puntosTotales = 2620;

    /**
     * Constructor en el que se hace la instanciaci�n de ComecocosFrame, se
     * actualiza el retardo y se inicia la hebra.
     *
     * @param fr de tipo ComecocosFrame.
     * @param nivel de tipo int.
     *
     */
    public Mueve(ComecocosFrame fr, int nivel) {
        frame = fr;
        this.niv = nivel;
        delay = actualizaRetardo(niv);
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * M�todo en el que se incluye todo el c�digo que queremos que ejecute la
     * clase Mueve. Al principio del m�todo encontramos un bucle if que
     * comprueba si estamos en el inicio del juego (o bien nos acaban de comer y
     * tanto los fantasmas como el comecocos empiezan en su posici�n inicial).
     * Si estamos en el inicio del juego, se abre la puerta de la celda durante
     * 500 ms para que les d� tiempo a salir a los fantasmas. En el resto del
     * tiempo, lo primero que se hace es comprobar que no se haya acabado el
     * juego (si se han consumido todos los puntos posibles). Si acaba el juego
     * porque se hayan alcanzado todos los puntos se aumenta el nivel de
     * dificultad y se reinicia el juego. Con la orden fant = chocaFantasmas()
     * lo que se hace es obtener un vector de booleanos. Si una posici�n del
     * vector vale true indica que se ha chocado con el fantasma
     * correspondiente. A continuaci�n se distinguen tres casos:
     *
     * Caso en que se choca con alg�n fantasma y estos no son comestibles: lo
     * que se hace es restar una vida y colocar el Pacman as� como los fantasmas
     * en sus posiciones iniciales. Si no quedan m�s vidas, la variable derrota
     * vale true y se presenta la elecci�n de volver a jugar o salir.
     *
     * Caso en que no se choca con ning�n fantasma: en esta ocasi�n el Pacman se
     * sigue moviendo, llevando a cabo una serie de comprobaciones: Si no se
     * choca ? me muevo en esa direcci�n. Si como un punto chico ? sumo 10
     * puntos y asigno esa celda a VACIA. Si como un punto grande ? sumo 50
     * puntos, asigno esa celda a VACIA y hago que los fantasmas pasen a estado
     * comestible (fantasmasComestibles()).
     *
     * Caso en que me choco con alg�n fantasma y estos son comestibles: Se
     * distingue el caso de ser el primer fantasma comido, segundo, tercero o el
     * �ltimo. Esto sirve para puntuar 200, 400, 800 o 1600 puntos en cada caso.
     *
     */
    @Override
    public void run() {
        try {

            while (continuar) {
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
                comestibles = false;
                Thread.sleep(delay / 4);
                boolean[] fant = {false, false, false, false};

                if (inicio == true) {
                    frame.getRejilla().assignTipoCelda(12, 12, Rejilla.nada);
                    frame.getRejilla().assignTipoCelda(12, 13, Rejilla.nada);
                    frame.getRejilla().assignTipoCelda(12, 14, Rejilla.nada);
                    frame.getRejilla().assignTipoCelda(12, 15, Rejilla.nada);
                    if (Figura.getDireccion() != Figura.PARADO) {
                        timer2 = new Timer(500, new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.getRejilla().assignTipoCelda(12, 12, Rejilla.P);
                                frame.getRejilla().assignTipoCelda(12, 13, Rejilla.P);
                                frame.getRejilla().assignTipoCelda(12, 14, Rejilla.P);
                                frame.getRejilla().assignTipoCelda(12, 15, Rejilla.P);
                                inicio = false;
                            }
                        });
                        timer2.setRepeats(false);
                        timer2.start();
                    }
                } else {
                    if (frame.getPuntos() == puntosTotales) {
                        continuar = false;
                        frame.inicializaJuego(0, 3);
                        niv += 1;
                        delay = actualizaRetardo(niv);
                        Ghost1.delay = delay;
                        Ghost2.delay = delay;
                        Ghost3.delay = delay;
                        Ghost4.delay = delay;
                    }

                    if (contador > 3) {
                        contador = -1;
                    }
                    contador++;
                    fant = chocaFantasmas();

                    if (((fant[0] == true) || (fant[1] == true) || (fant[2] == true) || (fant[3] == true)) && (comestibles == false)) {
                        if (comestibles2 == false) {
                            vidas--;
                            frame.mostrarVidas();
                            Figura.xorigen = 12;
                            Figura.yorigen = 22;
                            frame.suspenderFantasmas();
                            Thread.sleep(200);
                            frame.inicializaJuego(frame.getPuntos(), vidas);
                            Figura.setDireccion(Figura.PARADO);
                            if (vidas == 0) {
                                derrota = true;
                                parar();
                            }
                        }
                    } else if (((fant[0] == false) && (fant[1] == false) && (fant[2] == false) && (fant[3] == false))) {
                        if (Figura.getDireccion() == Figura.IZQUIERDA) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.IZQUIERDA)) {
                                    aux = false;
                                    frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/izq_c.png")).getImage());
                                    frame.getFigura().mueve(Figura.IZQUIERDA);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.IZQUIERDA)) {
                                    aux = true;
                                    frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/izq_a.png")).getImage());
                                    frame.getFigura().mueve(Figura.IZQUIERDA);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                        if (Figura.getDireccion() == Figura.DERECHA) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                aux = false;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.DERECHA)) {
                                    frame.getFigura().mueve(Figura.DERECHA);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                aux = true;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_a.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.DERECHA)) {
                                    frame.getFigura().mueve(Figura.DERECHA);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                        if (Figura.getDireccion() == Figura.ARRIBA) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                aux = false;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/arr_c.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.ARRIBA)) {
                                    frame.getFigura().mueve(Figura.ARRIBA);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                aux = true;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/arr_a.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.ARRIBA)) {
                                    frame.getFigura().mueve(Figura.ARRIBA);

                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                        if (Figura.getDireccion() == Figura.ABAJO) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                aux = false;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/aba_c.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.ABAJO)) {
                                    frame.getFigura().mueve(Figura.ABAJO);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                aux = true;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/aba_a.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.ABAJO)) {
                                    frame.getFigura().mueve(Figura.ABAJO);
                                    if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1) == Rejilla.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(Figura.yorigen + 1, Figura.xorigen + 1, Rejilla.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                    }
                    if (((fant[0] == true) || (fant[1] == true) || (fant[2] == true) || (fant[3] == true)) && (comestibles2 == true)) {
                        comestibles = false;
                        if (comidos == 0) {
                            frame.puntuar(100);
                            puntosTotales += 100;
                            Thread.sleep(100);
                            comidos += 1;
                        } else if (comidos == 1) {
                            frame.puntuar(200);
                            puntosTotales += 200;
                            Thread.sleep(100);
                            comidos += 1;
                        } else if (comidos == 2) {
                            frame.puntuar(400);
                            puntosTotales += 400;
                            Thread.sleep(100);
                            comidos += 1;
                        } else if (comidos == 3) {
                            frame.puntuar(800);
                            puntosTotales += 800;
                            Thread.sleep(100);
                            comidos += 1;
                        }

                        if (fant[0] == true) {
                            Ghost1.setVolver1(true);
                            fant[0] = false;
                        } else if (fant[1] == true) {
                            Ghost2.setVolver2(true);
                            fant[1] = false;
                        } else if (fant[2] == true) {
                            Ghost3.setVolver3(true);
                            fant[2] = false;
                        } else if (fant[3] == true) {
                            Ghost4.setVolver4(true);
                            fant[3] = false;
                        }
                    }
                    if ((derrota == true)) {
                        frame.inicializaJuego(0, 3);
                        continuar = true;
                        int entero = JOptionPane.showConfirmDialog(frame, "GAME OVER.\n�Desea seguir jugando?");
                        if (entero == 0) {
                            vidas = 3;
                            frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
                            frame.inicializaJuego(0, 3);
                            derrota = false;
                        } else {
                            System.exit(0);
                        }
                    }
                    if ((continuar == false) && (derrota == false)) {
                        int entero = JOptionPane.showConfirmDialog(frame, "Enhorabuena, �has ganado!\n\r�Quieres subir de nivel o salir?");
                        if (entero == 0) {
                            vidas = 3;
                            frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
                            frame.inicializaJuego(0, 3);
                            derrota = false;
                            continuar = true;
                            inicio = true;
                        } else {
                            System.exit(0);
                        }
                    }
                }

            }
        } catch (InterruptedException e) {
            System.out.println("Hilo MueveSerpiente interrumpido");
        }
    }

    /**
     * M�todo que detiene moment�neamente la ejecuci�n de la hebra, haciendo que
     * el Pacman se quede parado.
     *
     *
     */
    synchronized public void suspender() {
        frame.getPanel().repaint();
        suspendFlag = true;
    }

    /**
     * M�todo que reanuda el movimiento de la hebra, por lo que el Pacman vuelve
     * a moverse.
     *
     *
     */
    public synchronized void reanudar() {
        if (frame.getPanel() != null) {
            frame.getPanel().repaint();
        }
        suspendFlag = false;
        notify();
    }

    /**
     * M�todo que termina la ejecuci�n de la hebra.
     *
     *
     */
    public void parar() {
        continuar = false;
    }

    /**
     * M�todo que devuelve un n�mero entero que representa el n�mero de
     * milisegundos que se ha de dormir la hebra en cada iteraci�n del bucle
     * while.
     *
     * @param nivel de tipo int.
     * @return int
     *
     */
    private int actualizaRetardo(int nivel) {
        if (nivel > 10) {
            nivel = 10;
        } else if (nivel < 0) {
            nivel = 0;
        }
        return (400 - (nivel * 35));
    }

    /**
     * M�todo que ejecuta un temporizador para que los fantasmas sean
     * comestibles durante 8 segundos. Una vez transcurridos esos 8 segundos,
     * los fantasmas vuelven a su estado normal. El Timer tiene un
     * ActionListener para poder llevar a cabo esta acci�n.
     *
     * @return void
     *
     */
    private void fantasmasComestibles() {
        timer1 = new Timer(7000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Figura_ghost1.setComestible(false);
                Figura_ghost2.setComestible(false);
                Figura_ghost3.setComestible(false);
                Figura_ghost4.setComestible(false);
                comestibles = false;
                comestibles2 = false;
            }
        });
        comidos = 0;
        frame.getRejilla().assignTipoCelda(12, 12, Rejilla.nada);
        frame.getRejilla().assignTipoCelda(12, 13, Rejilla.nada);
        frame.getRejilla().assignTipoCelda(12, 14, Rejilla.nada);
        frame.getRejilla().assignTipoCelda(12, 15, Rejilla.nada);
        comestibles = false;
        comestibles2 = true;
        timer1.setRepeats(false);
        timer1.start();
        Figura_ghost1.setComestible(true);
        Figura_ghost2.setComestible(true);
        Figura_ghost3.setComestible(true);
        Figura_ghost4.setComestible(true);
    }

    /**
     * M�todo que se encarga de fijar el dato miembro derrota seg�n el par�metro
     * que recibe como entrada.
     *
     * @param derrota de tipo boolean.
     *
     */
    public void setDerrota(boolean derrota) {
        this.derrota = derrota;
    }

    /**
     * M�todo que devuelve un vector de booleanos, el cual indica los fantasmas
     * con los que se choca el Pacman. Si un fantasma se ha chocado con el
     * Pacman, el elemento de la posici�n correspondiente del vector valdr�
     * true.
     *
     * @return fan[] de tipo boolean
     *
     */
    private boolean[] chocaFantasmas() {
        boolean[] fan = {false, false, false, false};
        if ((Figura.xorigen == Figura_ghost1.getXorigen()) && (Figura.yorigen == Figura_ghost1.getYorigen())) {
            fan[0] = true;
        } else if ((Figura.xorigen == Figura_ghost2.getXorigen()) && (Figura.yorigen == Figura_ghost2.getYorigen())) {
            fan[1] = true;
        } else if ((Figura.xorigen == Figura_ghost3.xorigen) && (Figura.yorigen == Figura_ghost3.yorigen)) {
            fan[2] = true;
        } else if ((Figura.xorigen == Figura_ghost4.xorigen) && (Figura.yorigen == Figura_ghost4.yorigen)) {
            fan[3] = true;
        }
        return fan;
    }

    /**
     * M�todo que se encarga de fijar el dato miembro inicio seg�n el par�metro
     * que recibe como entrada.
     *
     * @param inicio de tipo boolean.
     *
     */
    public static void setInicio(boolean inicio) {
        Mueve.inicio = inicio;
    }

}
