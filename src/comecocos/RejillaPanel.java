package comecocos;

/**
 * La clase RejillaPanel es la encargada de dibujar los elementos del juego: el
 * Pacman, los 4 fantasmas y la rejilla (tablero)
 *
 * @author Ignacio y Alejandro
 */
import data.Figura;
import data.Figura_ghost1;
import data.Figura_ghost2;
import data.Figura_ghost3;
import data.Figura_ghost4;
import data.Rejilla;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class RejillaPanel extends javax.swing.JPanel {

    /**
     * Representa la imagen inicial del Pacman (hacia la derecha).
     */
    private Image im = new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage();
    /**
     * Representa la imagen inicial del fantasma 1.
     */
    private Image im1 = new ImageIcon(this.getClass().getResource("./images/ghost_r2.png")).getImage();
    /**
     * Representa la imagen inicial del fantasma 2.
     */
    private Image im2 = new ImageIcon(this.getClass().getResource("./images/ghost_g2.png")).getImage();
    /**
     * Representa la imagen inicial del fantasma 3.
     */
    private Image im3 = new ImageIcon(this.getClass().getResource("./images/ghost_a2.png")).getImage();
    /**
     * Representa la imagen inicial del fantasma 4.
     */
    private Image im4 = new ImageIcon(this.getClass().getResource("./images/ghost_v2.png")).getImage();
    /**
     * Representa la referencia al ComecocosFrame donde se incluye este panel,
     * RejillaPanel.
     */
    private ComecocosFrame frame;
    /**
     * Define el tamaño de la celda, 16 en nuestro caso.
     */
    private int celda = 16;
    /**
     * Define el tamaño de media celda.
     */
    private int media = 8;
    /**
     * Representa la coordenada en el eje de abscisas (X) del Pacman.
     */
    private int direccion;
    /**
     * Representa la coordenada en el eje de abscisas (X) del Pacman.
     */
    private int xoffset = 12 * 16;
    /**
     * Representa la coordenada en el eje de ordenadas (Y) del Pacman.
     */
    private int yoffset = 22 * 16;
    /**
     * Representa la coordenada en el eje de abscisas (X) del fantasma 1.
     */
    private int xoffset1 = 12 * 16;
    /**
     * Representa la coordenada en el eje de ordenadas (Y) del fantasma 1.
     */
    private int yoffset1 = 23 * 16;
    /**
     * Representa la coordenada en el eje de abscisas (X) del fantasma 2.
     */
    private int xoffset2 = 13 * 16;
    /**
     * Representa la coordenada en el eje de ordenadas (Y) del fantasma 2.
     */
    private int yoffset2 = 23 * 16;
    /**
     * Representa la coordenada en el eje de abscisas (X) del fantasma 3.
     *
     */
    private int xoffset3 = 14 * 16;
    /**
     * Representa la coordenada en el eje de ordenadas (Y) del fantasma 3.
     */
    private int yoffset3 = 23 * 16;
    /**
     * Representa la coordenada en el eje de abscisas (X) del fantasma 4.
     */
    private int xoffset4 = 13 * 16;
    /**
     * Representa la coordenada en el eje de ordenadas (Y) del fantasma 4.
     */
    private int yoffset4 = 22 * 16;

    /**
     * Representa el constructor por defecto.
     */
    public RejillaPanel() {
        initComponents();
    }

    /**
     * Representa la instanciación de la clase ComecocosFrame: otro JFrame donde
     * se incluye esta clase RejillaPanel.
     *
     * @param fr de tipo ComecocosFrame.
     */
    public RejillaPanel(ComecocosFrame fr) {
        this();
        frame = fr;
    }

    /**
     * Devuelve el dato miembro im
     *
     * @return im
     */
    public Image getIm() {
        return im;
    }

    /**
     * Método utilizado para fijar el dato miembro im.
     *
     * @param im de tipo Image.
     *
     */
    public void setIm(Image im) {
        this.im = im;
    }

    /**
     * Método utilizado para fijar el dato miembro im1.
     *
     * @param im1 de tipo Image.
     *
     */
    public void setIm1(Image im1) {
        this.im1 = im1;
    }

    /**
     * Método utilizado para fijar el dato miembro im2.
     *
     * @param im2 de tipo Image.
     *
     */
    public void setIm2(Image im2) {
        this.im2 = im2;
    }

    /**
     * Método utilizado para fijar el dato miembro im3.
     *
     * @param im3 de tipo Image.
     *
     */
    public void setIm3(Image im3) {
        this.im3 = im3;
    }

    /**
     * Método utilizado para fijar el dato miembro im4.
     *
     * @param im4 de tipo Image.
     *
     */
    public void setIm4(Image im4) {
        this.im4 = im4;
    }

    /**
     * Método utilizado para dibujar la figura del comecocos. Primeramente se
     * comprueba si el Pacman va a salirse por la puerta de la izquierda o de la
     * derecha del mapa. Si se sale por la izquierda hace que aparezca por la
     * derecha fijando una nueva posición (X e Y) oportuna y viceversa. Hemos
     * implementado la mejora de que el Pacman se mueva dando cuatro pasos por
     * cada celda en lugar de uno solo. Por lo tanto, en este método comprobamos
     * la dirección del Pacman, de manera que las variables xoffset e yoffset se
     * incrementen o decremente consecuentemente (dependiendo de la dirección y
     * sentido en que se esté moviendo el Pacman). Por último, se llama al
     * método drawImage del objeto Graphics, pasándole como parámetros la imagen
     * del comecocos, las componentes X e Y, así como la instanciación de
     * ComecocosFrame (frame).
     *
     * @param fig de tipo Figura.
     * @param g de tipo java.awt.Graphics.
     *
     */
    public void dibujaFigura(Figura fig, java.awt.Graphics g) {
        if (fig != null) {
            if (fig.getXorigen() == -1 && fig.getYOrigen() == 13) {
                Figura.xorigen = 25;
                Figura.yorigen = 13;
            } else if (fig.getXorigen() == 26 && fig.getYOrigen() == 13) {
                Figura.xorigen = 0;
                Figura.yorigen = 13;
            }

            if (fig.getDireccion() == Figura.IZQUIERDA) {
                xoffset = fig.getXorigen() * celda - (frame.getFigura().getOffset()) * (celda / 4);
                yoffset = fig.getYOrigen() * celda;
            } else if (fig.getDireccion() == Figura.DERECHA) {
                xoffset = fig.getXorigen() * celda + (frame.getFigura().getOffset()) * (celda / 4);
                yoffset = fig.getYOrigen() * celda;
            } else if (fig.getDireccion() == Figura.ARRIBA) {
                xoffset = fig.getXorigen() * celda;
                yoffset = fig.getYOrigen() * celda - (frame.getFigura().getOffset()) * (celda / 4);
            } else if (fig.getDireccion() == Figura.ABAJO) {
                xoffset = fig.getXorigen() * celda;
                yoffset = fig.getYOrigen() * celda + (frame.getFigura().getOffset()) * (celda / 4);
            }

            g.drawImage(im, xoffset + 16, yoffset + 16, frame);
        }

    }

    /**
     * Método utilizado para dibujar el fantasma 1. Para los fantasmas pues no
     * hemos tenido en cuenta el movimiento de 4 pasos entre una celda y otra.
     * En estos métodos se comprueba la posición (X e Y) del fantasma en
     * cuestión para ver si sale por la puerta de la izquierda o de la derecha
     * en algún momento. Por último, se calcula la posición en el eje de
     * abscisas (X) y en el de ordenadas (Y) para poder dibujar cada imagen. De
     * forma similar se dibujan los demás fantasmas
     *
     * @param fan de tipo Figura_ghost1.
     * @param g de tipo java.awt.Graphics.
     *
     */
    public void dibujaFantasma1(Figura_ghost1 fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXorigen() == -1 && fan.getYOrigen() == 13) {
                Figura_ghost1.setXorigen(25);
                Figura_ghost1.setYorigen(13);
            } else if (fan.getXorigen() == 26 && fan.getYOrigen() == 13) {
                Figura_ghost1.setXorigen(0);
                Figura_ghost1.setYorigen(13);
            }
            xoffset1 = fan.getXorigen() * celda;
            yoffset1 = fan.getYOrigen() * celda;
            g.drawImage(im1, xoffset1 + 16, yoffset1 + 16, frame);
        }
    }

    /**
     * Método utilizado para dibujar el fantasma 2.
     *
     * @param fan de tipo Figura_ghost2.
     * @param g de tipo java.awt.Graphics.
     *
     */
    public void dibujaFantasma2(Figura_ghost2 fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 13) {
                Figura_ghost2.setXorigen(25);
                Figura_ghost2.setYorigen(13);
            } else if (fan.getXOrigen() == 26 && fan.getYOrigen() == 13) {
                Figura_ghost2.setXorigen(0);
                Figura_ghost2.setYorigen(13);
            }
            xoffset2 = fan.getXOrigen() * celda;
            yoffset2 = fan.getYOrigen() * celda;
            g.drawImage(im2, xoffset2 + 16, yoffset2 + 16, frame);
        }
    }

    /**
     * Método utilizado para dibujar el fantasma 3.
     *
     * @param fan de tipo Figura_ghost3.
     * @param g de tipo java.awt.Graphics.
     *
     */
    public void dibujaFantasma3(Figura_ghost3 fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 13) {
                Figura_ghost3.xorigen = 25;
                Figura_ghost3.yorigen = 13;
            } else if (fan.getXOrigen() == 26 && fan.getYOrigen() == 13) {
                Figura_ghost3.xorigen = 0;
                Figura_ghost3.yorigen = 13;
            }
            xoffset3 = fan.getXOrigen() * celda;
            yoffset3 = fan.getYOrigen() * celda;
            g.drawImage(im3, xoffset3 + 16, yoffset3 + 16, frame);
        }
    }

    /**
     * Método utilizado para dibujar el fantasma 4.
     *
     * @param fan de tipo Figura_ghost4.
     * @param g de tipo java.awt.Graphics.
     *
     */
    public void dibujaFantasma4(Figura_ghost4 fan, java.awt.Graphics g) {
        if (fan != null) {
            if (fan.getXOrigen() == -1 && fan.getYOrigen() == 13) {
                Figura_ghost4.xorigen = 25;
                Figura_ghost4.yorigen = 13;
            } else if (fan.getXOrigen() == 26 && fan.getYOrigen() == 13) {
                Figura_ghost4.xorigen = 0;
                Figura_ghost4.yorigen = 13;
            }
            xoffset4 = fan.getXOrigen() * celda;
            yoffset4 = fan.getYOrigen() * celda;
            g.drawImage(im4, xoffset4 + 16, yoffset4 + 16, frame);
        }
    }

    /**
     * Método utilizado para de dibujar el laberinto con el componente gráfico.
     * Se recorren todos los elementos de la matriz de la clase Rejilla con dos
     * bucles for. Como esta matriz contiene el tipo de celda que hay que
     * dibujar, con este método se pintan todas las celdas del laberinto
     * (dependiendo del tipo que sean). La clase Graphics contiene los métodos
     * necesarios que nos permiten dibujar todos nuestros tipos de piezas.
     * Mediante setColor elegimos el color con que queremos que se pinte algún
     * elemento. Mediante los métodos drawLine y fillArc de la clase Graphics
     * podemos dibujar líneas y círculos respectivamente. En el caso de drawLine
     * especificamos las componentes X e Y de los puntos inicial y final de la
     * recta. En el caso de fillArc se especifican las componentes X e Y del
     * centro del círculo, la anchura o grosor de la línea, así como los ángulos
     * inicial y final.
     *
     * @param g de tipo java.awt.Graphics.
     *
     */
    public void dibujaRejilla(java.awt.Graphics g) {
        int i, j;
        Rejilla rejilla = frame.getRejilla();

        for (i = 0; i < 31; i++) {
            for (j = 0; j < 28; j++) {
                if (rejilla.getTipoCelda(i, j) == Rejilla.A) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.B) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.D) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.I) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.P) {
                    g.setColor(Color.WHITE);
                    g.drawLine(j * celda, i * celda + 13, j * celda + 16, i * celda + 13);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.a) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.b) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.d) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.e) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.f) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.g) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.h) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.i) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.m) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.n) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.uno) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.dos) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda + 16, i * celda);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.tres) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda, j * celda, i * celda + 16);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.cuatro) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                    g.drawLine(j * celda, i * celda + 16, j * celda + 16, i * celda + 16);
                    g.drawLine(j * celda + 16, i * celda, j * celda + 16, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.cinco) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda + 16, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.seis) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda + 16);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.siete) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda + 8, i * celda, j * celda + 16, i * celda + 8);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.ocho) {
                    g.setColor(Color.BLUE);
                    g.drawLine(j * celda, i * celda + 8, j * celda + 8, i * celda);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.o) {
                    g.setColor(Color.YELLOW);
                    g.fillArc(j * celda + 8, i * celda + 8, 7, 7, 0, 360);
                } else if (rejilla.getTipoCelda(i, j) == Rejilla.punto) {
                    g.setColor(Color.WHITE);
                    g.fillArc(j * celda + 8, i * celda + 8, 3, 3, 0, 360);
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

    /**
     * Método que permite la interacción con el usuario. En este método se
     * detecta la pulsación de las teclas (arriba ?, abajo ?, izquierda ?,
     * derecha ?), que permiten mover el Pacman en estas direcciones. Lo que se
     * hace para detectar si se pulsa una tecla u otra es obtener el código de
     * evento (evt.getKeyCode()) que se ha producido, y cambiar la direccion de
     * la clase Figura.
     *
     * @param evt de tipo java.awt.event.KeyEvent
     *
     * @return void
     */
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.IZQUIERDA)) {
                Figura.setDireccion(Figura.IZQUIERDA);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.DERECHA)) {
                Figura.setDireccion(Figura.DERECHA);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.ARRIBA)) {
                Figura.setDireccion(Figura.ARRIBA);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!frame.getRejilla().seChoca(frame.getFigura(), Figura.ABAJO)) {
                Figura.setDireccion(Figura.ABAJO);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * Método que se ejecuta al producirse este evento es requestFocus(), que
     * detecta cuando el ratón pincha sobre el panel de juego para que los
     * controles funcionen.
     *
     * @param evt de tipo java.awt.event.MouseEvent
     *
     * @return void
     */
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        requestFocus();
    }//GEN-LAST:event_formMouseEntered

    /**
     * Método en el que se dibujan todos los elementos. Para ello, se llama a
     * los métodos que dibujan cada componente (dibujaRejilla, dibujaFantasma1,
     * dibujaFantasma2, dibujaFantasma3 y dibujaFantasma4). En cuanto al fondo
     * del mapa, siempre se pinta de color negro con el método fillRect.
     *
     * @param g de tipo java.awt.Graphics
     *
     */
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
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
