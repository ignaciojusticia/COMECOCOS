
package ComecocosTeleco;

import dataTeleco.FiguraTeleco;
import dataTeleco.Figura_ghost1T;
import dataTeleco.Figura_ghost2T;
import dataTeleco.Figura_ghost3T;
import dataTeleco.Figura_ghost4T;
import dataTeleco.RejillaTeleco;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class RejillaPanelTeleco extends javax.swing.JPanel {

    private Image im = new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage();
    private Image im1 = new ImageIcon(this.getClass().getResource("./images/ghost_r2.png")).getImage();
    private Image im2 = new ImageIcon(this.getClass().getResource("./images/ghost_g2.png")).getImage();
    private Image im3 = new ImageIcon(this.getClass().getResource("./images/ghost_a2.png")).getImage();
    private Image im4 = new ImageIcon(this.getClass().getResource("./images/ghost_v2.png")).getImage();

    private RejillaTeleco rejilla;
    private ComecocosFrameTeleco frame;
    private int celda = 16;

    int media = 8;
    int x;
    int y;
    int direccion;
    int xoffset = 11 * 16;
    int yoffset = 21 * 16;
    int xoffset1 = 12 * 16;
    int yoffset1 = 23 * 16;
    int xoffset2 = 13 * 16;
    int yoffset2 = 23 * 16;
    int xoffset3 = 14 * 16;
    int yoffset3 = 23 * 16;
    int xoffset4 = 13 * 16;
    int yoffset4 = 22 * 16;

    public RejillaPanelTeleco() {
        initComponents();
    }

    public RejillaPanelTeleco(ComecocosFrameTeleco fr) {
        this();
        frame = fr;
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }

    public void setIm1(Image im1) {
        this.im1 = im1;
    }

    public void setIm2(Image im2) {
        this.im2 = im2;
    }

    public void setIm3(Image im3) {
        this.im3 = im3;
    }

    public void setIm4(Image im4) {
        this.im4 = im4;
    }

    public void dibujaFantasma1(Figura_ghost1T fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 17) {
                Figura_ghost1T.xorigen = 35;
                Figura_ghost1T.yorigen = 16;
            } else if (fan.getXOrigen() == 36 && fan.getYOrigen() == 16) {
                Figura_ghost1T.xorigen = 1;
                Figura_ghost1T.yorigen = 17;
            }
            xoffset1 = fan.getXOrigen() * celda;
            yoffset1 = fan.getYOrigen() * celda;
            g.drawImage(im1, xoffset1 + 16, yoffset1 + 16, frame);
        }
    }

    public void dibujaFantasma2(Figura_ghost2T fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 17) {
                Figura_ghost2T.xorigen = 35;
                Figura_ghost2T.yorigen = 16;
            } else if (fan.getXOrigen() == 36 && fan.getYOrigen() == 16) {
                Figura_ghost2T.xorigen = 1;
                Figura_ghost2T.yorigen = 17;
            }
            xoffset2 = fan.getXOrigen() * celda;
            yoffset2 = fan.getYOrigen() * celda;
            g.drawImage(im2, xoffset2 + 16, yoffset2 + 16, frame);
        }
    }

    public void dibujaFantasma3(Figura_ghost3T fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 17) {
                Figura_ghost3T.xorigen = 35;
                Figura_ghost3T.yorigen = 16;
            } else if (fan.getXOrigen() == 36 && fan.getYOrigen() == 16) {
                Figura_ghost3T.xorigen = 1;
                Figura_ghost3T.yorigen = 17;
            }
            xoffset3 = fan.getXOrigen() * celda;
            yoffset3 = fan.getYOrigen() * celda;
            g.drawImage(im3, xoffset3 + 16, yoffset3 + 16, frame);
        }
    }

    public void dibujaFantasma4(Figura_ghost4T fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 17) {
                Figura_ghost4T.xorigen = 35;
                Figura_ghost4T.yorigen = 16;
            } else if (fan.getXOrigen() == 36 && fan.getYOrigen() == 16) {
                Figura_ghost4T.xorigen = 1;
                Figura_ghost4T.yorigen = 17;
            }
            xoffset4 = fan.getXOrigen() * celda;
            yoffset4 = fan.getYOrigen() * celda;
            g.drawImage(im4, xoffset4 + 16, yoffset4 + 16, frame);
        }
    }

    public void dibujaFigura(FiguraTeleco fig, java.awt.Graphics g) {
        if (fig != null) {
            if (fig.getXOrigen() == -1 && fig.getYOrigen() == 17) {
                FiguraTeleco.xorigen = 35;
                FiguraTeleco.yorigen = 16;
            } else if (fig.getXOrigen() == 36 && fig.getYOrigen() == 16) {
                FiguraTeleco.xorigen = 1;
                FiguraTeleco.yorigen = 17;
            }

            if (fig.direccion == FiguraTeleco.IZQUIERDA) {
                xoffset = fig.getXOrigen() * celda - (frame.getFigura().offset) * (celda / 4);
                yoffset = fig.getYOrigen() * celda;
            } else if (fig.direccion == FiguraTeleco.DERECHA) {
                xoffset = fig.getXOrigen() * celda + (frame.getFigura().offset) * (celda / 4);
                yoffset = fig.getYOrigen() * celda;
            } else if (fig.direccion == FiguraTeleco.ARRIBA) {
                xoffset = fig.getXOrigen() * celda;
                yoffset = fig.getYOrigen() * celda - (frame.getFigura().offset) * (celda / 4);
            } else if (fig.direccion == FiguraTeleco.ABAJO) {
                xoffset = fig.getXOrigen() * celda;
                yoffset = fig.getYOrigen() * celda + (frame.getFigura().offset) * (celda / 4);
            }

            g.drawImage(im, xoffset + 16, yoffset + 16, frame);
        }

    }

    public void dibujaRejilla(java.awt.Graphics g) {
        int i, j;
        RejillaTeleco rejilla = frame.getRejilla();

        for (i = 0; i < 32; i++) {
            for (j = 0; j < 38; j++) {
                if (rejilla.getTipoCelda(i, j) == RejillaTeleco.A) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.B) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.D) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.I) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.P) {
                    g.setColor(Color.WHITE);
                    g.drawLine(j * celda, i * celda + 13, j * celda + 16, i * celda + 13);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.a) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.b) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.d) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.e) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.f) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.g) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.h) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.i) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.m) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.n) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.uno) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.dos) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.tres) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.cuatro) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.cinco) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.seis) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.siete) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.ocho) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.o) {
                    g.setColor(Color.WHITE);
                    g.fillArc(j * celda + 8, i * celda + 8, 6, 6, 0, 360);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.punto) {
                    g.setColor(Color.WHITE);
                    g.fillArc(j * celda + 8, i * celda + 8, 3, 3, 0, 360);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.nueve) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 8, i * celda + 8);
                    g.drawLine(j * celda + 8, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.diez) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 8);
                    g.drawLine(j * celda + 8, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.once) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 8);
                    g.drawLine(j * celda + 8, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.doce) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 8);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.j) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.k) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 8, i * celda);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.l) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda + 8);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.ñ) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 8, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.w) {
                    g.setColor(Color.BLUE);
                    g.drawArc(j * celda + 8, i * celda + 8, 16, 16, 90, 90);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.x) {
                    g.setColor(Color.BLUE);
                    g.drawArc(j * celda - 8, i * celda + 8, 16, 16, 0, 90);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.y) {
                    g.setColor(Color.BLUE);
                    g.drawArc(j * celda + 8, i * celda - 8, 16, 16, 180, 90);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.z) {
                    g.setColor(Color.BLUE);
                    g.drawArc(j * celda - 8, i * celda - 8, 16, 16, 270, 90);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.qi) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                    g.drawLine(j * celda, i * celda + 16, j * celda, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.qd) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                    g.drawLine(j * celda + 16, i * celda + 8, j * celda + 16, i * celda);
                } else if (rejilla.getTipoCelda(i, j) == RejillaTeleco.r) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(449, 497));
        setMinimumSize(new java.awt.Dimension(449, 497));
        setPreferredSize(new java.awt.Dimension(449, 497));
        setRequestFocusEnabled(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.IZQUIERDA)) {
                FiguraTeleco.direccion = FiguraTeleco.IZQUIERDA;
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.DERECHA)) {
                FiguraTeleco.direccion = FiguraTeleco.DERECHA;
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.ARRIBA)) {
                FiguraTeleco.direccion = FiguraTeleco.ARRIBA;
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), FiguraTeleco.ABAJO)) {
                FiguraTeleco.direccion = FiguraTeleco.ABAJO;
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        requestFocus();
    }//GEN-LAST:event_formMouseEntered

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g); 
        celda = 16;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        dibujaRejilla(g);

        dibujaFigura(frame.getFigura(), g);
        dibujaFantasma1(frame.getFig_ghost1(), g);
        dibujaFantasma2(frame.getFig_ghost2(), g);
        dibujaFantasma3(frame.getFig_ghost3(), g);
        dibujaFantasma4(frame.getFig_ghost4(), g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
