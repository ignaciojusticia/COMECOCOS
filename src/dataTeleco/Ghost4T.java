
package dataTeleco;

import ComecocosTeleco.ComecocosFrameTeleco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class Ghost4T implements Runnable {

    private int delay;
    private boolean continuar = true;
    private boolean suspendFlag = true;
    private ComecocosFrameTeleco frame;
    private boolean aux = true;
    public int offset = 0;
    public int dir = 4;
    int k = 0;
    double[] dist = new double[4];
    int[] direcciones = new int[4];
    int direccion_anterior;
    boolean cambiar_imagen = false;
    public static boolean subir = true;
    public static boolean volver4 = false;

    public Ghost4T(ComecocosFrameTeleco fr, int nivel) {
        frame = fr;
        delay = actualizaRetardo(nivel);
        Thread t = new Thread(this);
        t.start();
    }

    public void setSubir(boolean subir) {
        this.subir = subir;
    }

    public void run() {
        try {
            while (continuar) {
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
                Thread.sleep(delay);
                if ((frame.getRejilla().getTipoCelda(16, 23) == frame.getRejilla().nada) && (!Figura_ghost4T.isComestible()) && subir) {
                    frame.getFig_ghost4().mueve(Figura_ghost4T.ARRIBA);
                } else {
                    subir = false;
                    if ((!Figura_ghost4T.isComestible()) && (volver4 == false)) {
                        if (cambiar_imagen == false) {
                            cambiar_imagen = true;
                            frame.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/ghost_v2.png")).getImage());
                        } else {
                            frame.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/ghost_v1.png")).getImage());
                            cambiar_imagen = false;
                        }

                        dist[0] = 9999;
                        dist[1] = 9999;
                        dist[2] = 9999;
                        dist[3] = 9999;
                        boolean[] posibles = {false, false, false, false};
                        direccion_anterior = Figura_ghost4T.direccion;
                        k = 0;
                        if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.IZQUIERDA)) && (direccion_anterior != Figura_ghost4T.DERECHA)) {
                            dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen() - 1, frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen());
                            direcciones[k] = Figura_ghost4T.IZQUIERDA;
                            posibles[0] = true;
                        }
                        k = 1;
                        if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.DERECHA)) && (direccion_anterior != Figura_ghost4T.IZQUIERDA)) {
                            dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen() + 1, frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen());
                            direcciones[k] = Figura_ghost4T.DERECHA;
                            posibles[1] = true;
                        }
                        k = 2;
                        if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.ARRIBA)) && (direccion_anterior != Figura_ghost4T.ABAJO)) {
                            dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen() - 1);
                            direcciones[k] = Figura_ghost4T.ARRIBA;
                            posibles[2] = true;
                        }
                        k = 3;
                        if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.ABAJO)) && (direccion_anterior != Figura_ghost4T.ARRIBA)) {
                            dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen() + 1);
                            direcciones[k] = Figura_ghost4T.ABAJO;
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
                            Figura_ghost4T.direccion = direcciones[var];
                            frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
                            direccion_anterior = direcciones[var];
                        } else {
                            double prob = Math.random();
                            if ((prob <= 0.5)) {
                                Figura_ghost4T.direccion = direcciones[0];
                                frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
                                direccion_anterior = direcciones[0];
                            } else if (prob > 0.5) {
                                Figura_ghost4T.direccion = direcciones[1];
                                frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
                                direccion_anterior = direcciones[1];
                            }
                        }
                        if (frame.getPanel() != null) {
                            frame.getPanel().repaint();
                        }
                        var = -1;
                        num_posibilidades = 0;

                    } else {
                        if (volver4 == true) {
                            if ((Figura_ghost4T.xorigen == 24) && (Figura_ghost4T.yorigen == 17)) {
                                volver4 = false;
                                subir = false;
                                Figura_ghost4T.setComestible(false);
                                frame.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/ghost_v1.png")).getImage());
                            }
                            frame.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/ojos.png")).getImage());
                            dist[0] = 9999;
                            dist[1] = 9999;
                            dist[2] = 9999;
                            dist[3] = 9999;
                            boolean[] posibles = {false, false, false, false};
                            k = 0;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.IZQUIERDA)) && (direccion_anterior != Figura_ghost4T.DERECHA)) {
                                dist[k] = frame.distancia(24, frame.getFig_ghost4().getXOrigen() - 1, 17, frame.getFig_ghost4().getYOrigen());
                                direcciones[k] = Figura_ghost4T.IZQUIERDA;
                                posibles[0] = true;
                            }
                            k = 1;

                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.DERECHA)) && (direccion_anterior != Figura_ghost4T.IZQUIERDA)) {
                                dist[k] = frame.distancia(24, frame.getFig_ghost4().getXOrigen() + 1, 17, frame.getFig_ghost4().getYOrigen());
                                direcciones[k] = Figura_ghost4T.DERECHA;
                                posibles[1] = true;
                            }
                            k = 2;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.ARRIBA)) && (direccion_anterior != Figura_ghost4T.ABAJO)) {
                                dist[k] = frame.distancia(24, frame.getFig_ghost4().getXOrigen(), 17, frame.getFig_ghost4().getYOrigen() - 1);
                                direcciones[k] = Figura_ghost4T.ARRIBA;
                                posibles[2] = true;
                            }
                            k = 3;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.ABAJO)) && (direccion_anterior != Figura_ghost4T.ARRIBA)) {
                                dist[k] = frame.distancia(24, frame.getFig_ghost4().getXOrigen(), 17, frame.getFig_ghost4().getYOrigen() + 1);
                                direcciones[k] = Figura_ghost4T.ABAJO;
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
                            Figura_ghost4T.direccion = direcciones[0];
                            frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
                            direccion_anterior = direcciones[0];
                            if (frame.getPanel() != null) {
                                frame.getPanel().repaint();
                            }
                        } else if (volver4 == false) {
                            if (cambiar_imagen == false) {
                                cambiar_imagen = true;
                                frame.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/comestible1.png")).getImage());
                            } else {
                                frame.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/comestible2.png")).getImage());
                                cambiar_imagen = false;
                            }
                            dist[0] = 9999;
                            dist[1] = 9999;
                            dist[2] = 9999;
                            dist[3] = 9999;
                            boolean[] posibles = {false, false, false, false};
                            direccion_anterior = Figura_ghost4T.direccion;
                            k = 0;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.IZQUIERDA)) && (direccion_anterior != Figura_ghost4T.DERECHA)) {
                                dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen() - 1, frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen());
                                direcciones[k] = Figura_ghost4T.IZQUIERDA;
                                posibles[0] = true;
                            }
                            k = 1;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.DERECHA)) && (direccion_anterior != Figura_ghost4T.IZQUIERDA)) {
                                dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen() + 1, frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen());
                                direcciones[k] = Figura_ghost4T.DERECHA;
                                posibles[1] = true;
                            }
                            k = 2;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.ARRIBA)) && (direccion_anterior != Figura_ghost4T.ABAJO)) {
                                dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen() - 1);
                                direcciones[k] = Figura_ghost4T.ARRIBA;
                                posibles[2] = true;
                            }
                            k = 3;
                            if ((!frame.getRejilla().seChocaFantasma4(frame.getFig_ghost4(), Figura_ghost4T.ABAJO)) && (direccion_anterior != Figura_ghost4T.ARRIBA)) {
                                dist[k] = frame.distancia(frame.getFigura().getXOrigen(), frame.getFig_ghost4().getXOrigen(), frame.getFigura().getYOrigen(), frame.getFig_ghost4().getYOrigen() + 1);
                                direcciones[k] = Figura_ghost4T.ABAJO;
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
                                Figura_ghost4T.direccion = direcciones[var];
                                frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
                                direccion_anterior = direcciones[var];
                            } else {
                                double prob = Math.random();
                                if ((prob <= 0.5)) {
                                    Figura_ghost4T.direccion = direcciones[0];
                                    frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
                                    direccion_anterior = direcciones[0];
                                } else if (prob > 0.5) {
                                    Figura_ghost4T.direccion = direcciones[1];
                                    frame.getFig_ghost4().mueve(Figura_ghost4T.direccion);
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

    synchronized public void suspender() {
        frame.getPanel().repaint();
        suspendFlag = true;
    }


    public synchronized void reanudar() {
        if (frame.getPanel() != null) {
            frame.getPanel().repaint();
        }
        suspendFlag = false;
        notify();
    }

 
    public void parar() {
        continuar = false;
    }


    synchronized public boolean getParado() {
        return suspendFlag;
    }

    private int actualizaRetardo(int nivel) {
        if (nivel > 10) {
            nivel = 10;
        } else if (nivel < 0) {
            nivel = 0;
        }
        return (400 - (nivel * 35));
    }
}
