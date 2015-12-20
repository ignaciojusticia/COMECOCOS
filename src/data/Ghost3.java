package data;

/**
 * La clase Ghost3 implementa una hebra que permite el movimiento del fantasma 3
 *
 * @author Ignacio y Alejandro
 */
import comecocos.ComecocosFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Ghost3 implements Runnable {

    /**
     * Representa el número de milisegundos que se dormirá la hebra en cada
     * iteración del while, es un retardo adicional.
     */
    public static int delay;
    /**
     * Representa la continuidad de la hebra. Esta variable ha de valer true
     * para que la hebra continúe su ejecución, de lo contrario el programa
     * acaba.
     */
    private boolean continuar = true;
    /**
     * Representa una variable booleana que permite suspender la hebra hasta
     * nuevo aviso.
     */
    private boolean suspendFlag = true;
    /**
     * Representa la referencia al ComecocosFrame.
     */
    private ComecocosFrame frame;
    /**
     * Representa un índice para el vector de distancias dist.
     */
    private int k = 0;
    /**
     * Vector en el que se guardan las distancias del fantasma al Pacman. Tiene
     * cuatro componentes pues puede llegar a haber cuatro distancias posibles,
     * cada una con una dirección potencial.
     */
    private double[] dist = new double[4];
    /**
     * Vector en el que se almacenan las direcciones a las que el fantasma se
     * puede mover sin chocarse.
     */
    private int[] direcciones = new int[4];
    /**
     * Representa la dirección que llevaba antes el fantasma, pues este no puede
     * ir en la dirección contraria a la misma (no puede dar la vuelta).
     */
    private int direccion_anterior;
    /**
     * Permite que el fantasma alterne entre dos imágenes, y así ayudar a
     * simular el movimiento.
     */
    private boolean cambiar_imagen = false;
    /**
     * Representa el estado cuando el fantasma 3 ha sido comido por el Pacman.
     * Por lo tanto permite que el fantasma se convierta en dos ojos que vuelven
     * a la celda inicial.
     */
    private static boolean volver3 = false;
    /**
     * Representa la condicion del fantasma de salir de la celda inicial, por lo
     * que el fantasma solo sube durante un breve periodo de tiempo.
     */
    private boolean subir = true;

    /**
     * Constructor de la clase. Se encarga de instanciar ComecocosFrame, fijar
     * el retardo de la hebra y empezar la misma.
     *
     * @param fr de tipo ComecocosFrame.
     * @param nivel de tipo int.
     *
     */
    public Ghost3(ComecocosFrame fr, int nivel) {
        frame = fr;
        delay = actualizaRetardo(nivel);
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * Metodo que se encarga de fijar el valor del dato miembro subir
     *
     * @param subir de tipo boolean.
     *
     */
    public void setSubir(boolean subir) {
        this.subir = subir;
    }

    /**
     * Metodo en el que se incluye todo el código que deseamos que ejecute el
     * fantasma. Se distinguen varios casos. Caso en que el fantasma NO es
     * comestible: Se inicializa un vector de distancias a un número grande. A
     * continuación, se comprueban las direcciones a las que el fantasma puede
     * ir (arriba, izquierda, derecha o abajo). Si el fantasma puede ir a una
     * determinada dirección porque no se choque, se pone un true en el índice
     * oportuno del vector de posibiles direcciones (posibles). Después
     * encontramos un bucle for en el que se hace el método de la burbuja para
     * ordenar las direcciones de menor a mayor. Tras este bucle for el vector
     * de distancias queda ordenado y las dos primeras posiciones son las que
     * nos interesan, pues representan las dos distancias menores al Pacman. Se
     * distinguen dos subcasos: Si sólo hay una posibilidad el fantasma tomará
     * esa dirección. Si hay más de una posible dirección a la que el fantasma
     * puede ir, se toma la que produce menor distancia al Pacman con una
     * probabilidad del 50%, y con otra probabilidad del 50% la segunda
     * distancia mejor (segunda menor).
     *
     * Caso en que el fantasma SÍ es comestible: Si el fantasma ha sido comido
     * tiene que volver en forma de ojos hasta la posición inicial en la celda
     * que los encerraba. Para ello, se comprueban las coordenadas X e Y del
     * fantasma con las iniciales (x=13,y=13). Hasta entonces, el fantasma
     * comprueba las direcciones a las que puede ir constantemente, y siempre
     * toma la menor de ellas. Por lo tanto, se calculan las distancias
     * posibles, se ordenan con el método de la burbuja y se escoge la primera
     * posición del vector dist (distancias). Si el fantasma es comestible pero
     * no ha sido comido: en este caso el fantasma se comporta de forma similar
     * al caso normal (no comestible), pero los movimientos son contrarios. Es
     * decir, en este caso, en lugar de ordenar el vector distancias de menor a
     * mayor, se ordena de mayor a menor. No obstante, si el número de posibles
     * direcciones a las que puede ir es 1 tomará esa dirección. Si hay más de
     * una posibilidad, toma la dirección que produce una distancia mayor al
     * Pacman con una probabilidad del 50%.
     *
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
                Thread.sleep(delay);
                if ((frame.getRejilla().getTipoCelda(12, 13) == frame.getRejilla().nada) && (!Figura_ghost3.isComestible()) && subir) {
                    frame.getFig_ghost3().mueve(Figura_ghost3.ARRIBA);
                } else {
                    subir = false;
                    if ((!Figura_ghost3.isComestible()) && (volver3 == false)) {
                        if (cambiar_imagen == false) {
                            cambiar_imagen = true;
                            frame.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/ghost_a2.png")).getImage());
                        } else {
                            frame.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/ghost_a1.png")).getImage());
                            cambiar_imagen = false;
                        }
                        dist[0] = 9999;
                        dist[1] = 9999;
                        dist[2] = 9999;
                        dist[3] = 9999;
                        boolean[] posibles = {false, false, false, false};
                        direccion_anterior = Figura_ghost3.direccion;
                        k = 0;
                        if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.IZQUIERDA)) && (direccion_anterior != Figura_ghost3.DERECHA)) {
                            dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen() - 1, frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen());
                            direcciones[k] = Figura_ghost3.IZQUIERDA;
                            posibles[0] = true;
                        }
                        k = 1;

                        if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.DERECHA)) && (direccion_anterior != Figura_ghost3.IZQUIERDA)) {
                            dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen() + 1, frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen());
                            direcciones[k] = Figura_ghost3.DERECHA;
                            posibles[1] = true;
                        }
                        k = 2;
                        if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.ARRIBA)) && (direccion_anterior != Figura_ghost3.ABAJO)) {
                            dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen() - 1);
                            direcciones[k] = Figura_ghost3.ARRIBA;
                            posibles[2] = true;
                        }
                        k = 3;
                        if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.ABAJO)) && (direccion_anterior != Figura_ghost3.ARRIBA)) {
                            dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen() + 1);
                            direcciones[k] = Figura_ghost3.ABAJO;
                            posibles[3] = true;

                        }
                        k = 0;
                        double auxi1;
                        int auxi2;
                        boolean auxi3;
                        for (int i = 0; i < dist.length - 1; i++) {
                            for (int j = 0; j < dist.length - i - 1; j++) {
                                if (dist[j + 1] < dist[j]) {
                                    auxi1 = dist[j + 1];
                                    dist[j + 1] = dist[j];
                                    dist[j] = auxi1;

                                    auxi2 = direcciones[j + 1];
                                    direcciones[j + 1] = direcciones[j];
                                    direcciones[j] = auxi2;

                                    auxi3 = posibles[j + 1];
                                    posibles[j + 1] = posibles[j];
                                    posibles[j] = auxi3;

                                }
                            }
                        }
                        int num_posibilidades = 0;
                        int var = -1;
                        for (int i = 0; i < posibles.length; i++) {
                            if (posibles[i] == true) {
                                num_posibilidades++;
                                var = i;
                            }
                        }
                        if (num_posibilidades == 1) {
                            Figura_ghost3.direccion = direcciones[var];
                            frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                            direccion_anterior = direcciones[var];
                        } else {
                            double prob = Math.random();
                            if ((prob <= 0.5)) {
                                Figura_ghost3.direccion = direcciones[0];
                                frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                                direccion_anterior = direcciones[0];
                            } else if (prob > 0.5) {
                                Figura_ghost3.direccion = direcciones[1];
                                frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                                direccion_anterior = direcciones[1];
                            }
                        }

                        if (frame.getPanel() != null) {
                            frame.getPanel().repaint();
                        }
                        var = -1;
                        num_posibilidades = 0;
                    } else {
                        if (volver3 == true) {
                            if ((Figura_ghost3.xorigen == 11) && (Figura_ghost3.yorigen == 13)) {
                                volver3 = false;
                                subir = false;
                                Figura_ghost3.setComestible(false);
                                frame.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/ghost_a1.png")).getImage());

                            }
                            frame.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/ojos.png")).getImage());
                            dist[0] = 9999;
                            dist[1] = 9999;
                            dist[2] = 9999;
                            dist[3] = 9999;
                            boolean[] posibles = {false, false, false, false};
                            k = 0;
                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.IZQUIERDA)) && (direccion_anterior != Figura_ghost3.DERECHA)) {
                                dist[k] = frame.distancia(11, frame.getFig_ghost3().getXOrigen() - 1, 13, frame.getFig_ghost3().getYOrigen());
                                direcciones[k] = Figura_ghost3.IZQUIERDA;
                                posibles[0] = true;
                            }
                            k = 1;

                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.DERECHA)) && (direccion_anterior != Figura_ghost3.IZQUIERDA)) {
                                dist[k] = frame.distancia(11, frame.getFig_ghost3().getXOrigen() + 1, 13, frame.getFig_ghost3().getYOrigen());
                                direcciones[k] = Figura_ghost3.DERECHA;
                                posibles[1] = true;
                            }
                            k = 2;
                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.ARRIBA)) && (direccion_anterior != Figura_ghost3.ABAJO)) {
                                dist[k] = frame.distancia(11, frame.getFig_ghost3().getXOrigen(), 13, frame.getFig_ghost3().getYOrigen() - 1);
                                direcciones[k] = Figura_ghost3.ARRIBA;
                                posibles[2] = true;
                            }
                            k = 3;
                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.ABAJO)) && (direccion_anterior != Figura_ghost3.ARRIBA)) {
                                dist[k] = frame.distancia(11, frame.getFig_ghost3().getXOrigen(), 13, frame.getFig_ghost3().getYOrigen() + 1);
                                direcciones[k] = Figura_ghost3.ABAJO;
                                posibles[3] = true;

                            }
                            k = 0;
                            double auxi1;
                            int auxi2;
                            boolean auxi3;
                            for (int i = 0; i < dist.length; i++) {
                                for (int j = 0; j < dist.length - 1; j++) {
                                    if (dist[j] > dist[j + 1]) {
                                        auxi1 = dist[j];
                                        dist[j] = dist[j + 1];
                                        dist[j + 1] = auxi1;

                                        auxi2 = direcciones[j];
                                        direcciones[j] = direcciones[j + 1];
                                        direcciones[j + 1] = auxi2;

                                        auxi3 = posibles[j];
                                        posibles[j] = posibles[j + 1];
                                        posibles[j + 1] = auxi3;

                                    }
                                }
                            }
                            Figura_ghost3.direccion = direcciones[0];
                            frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                            direccion_anterior = direcciones[0];
                            if (frame.getPanel() != null) {
                                frame.getPanel().repaint();
                            }
                        } else if (volver3 == false) {
                            if (cambiar_imagen == false) {
                                cambiar_imagen = true;
                                frame.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/comestible1.png")).getImage());
                            } else {
                                frame.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/comestible2.png")).getImage());
                                cambiar_imagen = false;
                            }
                            dist[0] = 9999;
                            dist[1] = 9999;
                            dist[2] = 9999;
                            dist[3] = 9999;
                            boolean[] posibles = {false, false, false, false};
                            direccion_anterior = Figura_ghost3.direccion;
                            //miercoles 3 junio 12:30 REDES 5 G ingeniero de telefÃ³nica
                            k = 0;
                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.IZQUIERDA)) && (direccion_anterior != Figura_ghost3.DERECHA)) {
                                dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen() - 1, frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen());
                                direcciones[k] = Figura_ghost3.IZQUIERDA;
                                posibles[0] = true;
                            }
                            k = 1;

                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.DERECHA)) && (direccion_anterior != Figura_ghost3.IZQUIERDA)) {
                                dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen() + 1, frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen());
                                direcciones[k] = Figura_ghost3.DERECHA;
                                posibles[1] = true;
                            }
                            k = 2;
                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.ARRIBA)) && (direccion_anterior != Figura_ghost3.ABAJO)) {
                                dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen() - 1);
                                direcciones[k] = Figura_ghost3.ARRIBA;
                                posibles[2] = true;
                            }
                            k = 3;
                            if ((!frame.getRejilla().seChocaFantasma3(frame.getFig_ghost3(), Figura_ghost3.ABAJO)) && (direccion_anterior != Figura_ghost3.ARRIBA)) {
                                dist[k] = frame.distancia(frame.getFigura().getXorigen(), frame.getFig_ghost3().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost3().getYOrigen() + 1);
                                direcciones[k] = Figura_ghost3.ABAJO;
                                posibles[3] = true;

                            }
                            k = 0;
                            double auxi1;
                            int auxi2;
                            boolean auxi3;
                            for (int i = 0; i < dist.length; i++) {
                                for (int j = 0; j < dist.length - 1; j++) {
                                    if (dist[j] > dist[j + 1]) {
                                        auxi1 = dist[j];
                                        dist[j] = dist[j + 1];
                                        dist[j + 1] = auxi1;

                                        auxi2 = direcciones[j];
                                        direcciones[j] = direcciones[j + 1];
                                        direcciones[j + 1] = auxi2;

                                        auxi3 = posibles[j];
                                        posibles[j] = posibles[j + 1];
                                        posibles[j + 1] = auxi3;

                                    }
                                }
                            }
                            int num_posibilidades = 0;
                            int var = -1;
                            for (int i = 0; i < posibles.length; i++) {
                                if (posibles[i] == true) {
                                    num_posibilidades++;
                                    var = i;
                                }
                            }
                            if (num_posibilidades == 1) {
                                Figura_ghost3.direccion = direcciones[var];
                                frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                                direccion_anterior = direcciones[var];
                            } else {
                                double prob = Math.random();
                                if ((prob <= 0.5)) {
                                    Figura_ghost3.direccion = direcciones[0];
                                    frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                                    direccion_anterior = direcciones[0];
                                } else if (prob > 0.5) {
                                    Figura_ghost3.direccion = direcciones[1];
                                    frame.getFig_ghost3().mueve(Figura_ghost3.direccion);
                                    direccion_anterior = direcciones[1];
                                }
                            }

                            if (frame.getPanel() != null) {
                                frame.getPanel().repaint();
                            }
                            var = -1;
                            num_posibilidades = 0;
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo MueveSerpiente interrumpido");
        }
    }

    /**
     * Metodo que se encarga detener momentáneamente la ejecución de la hebra,
     * haciendo que el fantasma se quede parado.
     *
     */
    synchronized public void suspender() {
        frame.getPanel().repaint();
        suspendFlag = true;
    }

    /**
     * Metodo que se encarga reanudar el movimiento de la hebra, haciendo que el
     * fantasma vuelva a moverse.
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
     * Metodo que se encarga terminar la ejecución de la hebra que movía el
     * fantasma.
     *
     */
    public void parar() {
        continuar = false;
    }

    /**
     * Metodo que se encarga de devolver un número entero que representa el
     * número de milisegundos que se ha de dormir la hebra en cada iteración del
     * bucle while.
     *
     * @param nivel de tipo int.
     *
     * @return int
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
     * Metodo que se encarga de fijar el valor del dato miembro volver3 a true o
     * false según el parámetro que recibe como entrada.
     *
     * @param volver3 de tipo boolean.
     *
     */
    public static void setVolver3(boolean volver3) {
        Ghost3.volver3 = volver3;
    }

}
