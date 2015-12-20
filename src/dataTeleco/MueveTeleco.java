package dataTeleco;

import javax.swing.JPanel;
import ComecocosTeleco.ComecocosFrameTeleco;
import dataTeleco.FiguraTeleco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MueveTeleco implements Runnable {

    private int delay;
    private boolean continuar = true;
    private boolean suspendFlag = true;
    private ComecocosFrameTeleco frame;
    private boolean aux = true;
    private int contador = 0;
    public static int vidas = 3;
    private boolean derrota = false;
    public static Timer timer1, timer2;
    public static boolean inicio = true;
    boolean a = true;
    boolean comestibles = false;
    boolean comestibles2 = false;
    private int comidos = 1;
    private int niv;
    private int puntosTotales = 4940;


    public MueveTeleco(ComecocosFrameTeleco fr, int nivel) {
        frame = fr;
        this.niv = nivel;
        delay = actualizaRetardo(niv);
        Thread t = new Thread(this);
        t.start();
    }

  
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
                    frame.getRejilla().assignTipoCelda(16, 23, RejillaTeleco.nada);
                    frame.getRejilla().assignTipoCelda(16, 24, RejillaTeleco.nada);
                    frame.getRejilla().assignTipoCelda(16, 25, RejillaTeleco.nada);
                    frame.getRejilla().assignTipoCelda(16, 26, RejillaTeleco.nada);
                    if (FiguraTeleco.direccion != FiguraTeleco.PARADO) {
                        timer2 = new Timer(700, new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.getRejilla().assignTipoCelda(16, 23, RejillaTeleco.P);
                                frame.getRejilla().assignTipoCelda(16, 24, RejillaTeleco.P);
                                frame.getRejilla().assignTipoCelda(16, 25, RejillaTeleco.P);
                                frame.getRejilla().assignTipoCelda(16, 26, RejillaTeleco.P);
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
                            FiguraTeleco.xorigen = 11;
                            FiguraTeleco.yorigen = 21;
                            frame.suspenderFantasmas();
                            Thread.sleep(400);
                            frame.inicializaJuego(frame.getPuntos(), vidas);
                            FiguraTeleco.direccion = FiguraTeleco.PARADO;
                            if (vidas == 0) {
                                derrota = true;
                                parar();
                            }
                        }
                    } else if (((fant[0] == false) && (fant[1] == false) && (fant[2] == false) && (fant[3] == false))) {
                        if (FiguraTeleco.direccion == FiguraTeleco.IZQUIERDA) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.IZQUIERDA)) {
                                    aux = false;
                                    frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/izq_c.png")).getImage());
                                    frame.getFigura().mueve(FiguraTeleco.IZQUIERDA);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.IZQUIERDA)) {
                                    aux = true;
                                    frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/izq_a.png")).getImage());
                                    frame.getFigura().mueve(FiguraTeleco.IZQUIERDA);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                        if (FiguraTeleco.direccion == FiguraTeleco.DERECHA) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                aux = false;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.DERECHA)) {
                                    frame.getFigura().mueve(FiguraTeleco.DERECHA);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                aux = true;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_a.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.DERECHA)) {
                                    frame.getFigura().mueve(FiguraTeleco.DERECHA);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                        if (FiguraTeleco.direccion == FiguraTeleco.ARRIBA) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                aux = false;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/arr_c.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.ARRIBA)) {
                                    frame.getFigura().mueve(FiguraTeleco.ARRIBA);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                aux = true;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/arr_a.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.ARRIBA)) {
                                    frame.getFigura().mueve(FiguraTeleco.ARRIBA);

                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            }
                        }
                        if (FiguraTeleco.direccion == FiguraTeleco.ABAJO) {
                            if ((aux == true) && ((contador == 0) || (contador == 2))) {
                                aux = false;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/aba_c.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.ABAJO)) {
                                    frame.getFigura().mueve(FiguraTeleco.ABAJO);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

                                    if (frame.getPanel() != null) {
                                        frame.getPanel().repaint();
                                    }
                                }
                            } else if ((aux == false) && ((contador == 1) || (contador == 3))) {
                                aux = true;
                                frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/aba_a.png")).getImage());
                                if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.ABAJO)) {
                                    frame.getFigura().mueve(FiguraTeleco.ABAJO);
                                    if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.punto) {
                                        frame.puntuar(10);
                                    } else if (frame.getRejilla().getTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1) == RejillaTeleco.o) {
                                        frame.puntuar(50);
                                        fantasmasComestibles();
                                        comestibles2 = true;
                                    }
                                    frame.getRejilla().assignTipoCelda(FiguraTeleco.yorigen + 1, FiguraTeleco.xorigen + 1, RejillaTeleco.nada);

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

                    }
                }
                if ((derrota == true) && (continuar == false)) {
                    continuar = true;
                    int entero = JOptionPane.showConfirmDialog(frame, "GAME OVER.\n¿Desea seguir jugando?");
                    if (entero == 0) {
                        continuar = true;
                        frame.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
                        frame.inicializaJuego(0, 3);
                        derrota = false;
                    } else {
                        System.exit(0);
                    }
                }
                if ((continuar == false) && (derrota == false)) {
                    JOptionPane.showMessageDialog(frame, "Enhorabuena, ¡has ganado!");
                    System.exit(0);
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

    private void fantasmasComestibles() {
        timer1 = new Timer(7000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Figura_ghost1T.setComestible(false);
                Figura_ghost2T.setComestible(false);
                Figura_ghost3T.setComestible(false);
                Figura_ghost4T.setComestible(false);
                comestibles = false;
                comestibles2 = false;
                comidos = 1;
            }
        });
        comidos = 1;
        frame.getRejilla().assignTipoCelda(16, 23, RejillaTeleco.nada);
        frame.getRejilla().assignTipoCelda(16, 24, RejillaTeleco.nada);
        frame.getRejilla().assignTipoCelda(16, 25, RejillaTeleco.nada);
        frame.getRejilla().assignTipoCelda(16, 26, RejillaTeleco.nada);
        comestibles = false;
        comestibles2 = true;
        timer1.setRepeats(false);
        timer1.start();
        Figura_ghost1T.setComestible(true);
        Figura_ghost2T.setComestible(true);
        Figura_ghost3T.setComestible(true);
        Figura_ghost4T.setComestible(true);
    }

    private boolean[] chocaFantasmas() {
        boolean[] fan = {false, false, false, false};
        if ((FiguraTeleco.xorigen == Figura_ghost1T.xorigen) && (FiguraTeleco.yorigen == Figura_ghost1T.yorigen)) {
            fan[0] = true;
        } else if ((FiguraTeleco.xorigen == Figura_ghost2T.xorigen) && (FiguraTeleco.yorigen == Figura_ghost2T.yorigen)) {
            fan[1] = true;
        } else if ((FiguraTeleco.xorigen == Figura_ghost3T.xorigen) && (FiguraTeleco.yorigen == Figura_ghost3T.yorigen)) {
            fan[2] = true;
        } else if ((FiguraTeleco.xorigen == Figura_ghost4T.xorigen) && (FiguraTeleco.yorigen == Figura_ghost4T.yorigen)) {
            fan[3] = true;
        }
        return fan;
    }
}
