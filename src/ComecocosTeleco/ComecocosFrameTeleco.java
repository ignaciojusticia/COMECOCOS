
package ComecocosTeleco;

import dataTeleco.FiguraTeleco;
import dataTeleco.Figura_ghost1T;
import dataTeleco.Figura_ghost2T;
import dataTeleco.Figura_ghost3T;
import dataTeleco.Figura_ghost4T;
import dataTeleco.Ghost1T;
import dataTeleco.Ghost2T;
import dataTeleco.Ghost3T;
import dataTeleco.Ghost4T;
import dataTeleco.MueveTeleco;
import dataTeleco.RejillaTeleco;
import dataTeleco.Tiempo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class ComecocosFrameTeleco extends javax.swing.JFrame {

    private RejillaTeleco rejilla;
    private FiguraTeleco figura;
    private MueveTeleco mueve;
    private Ghost1T ghost1;
    private Ghost2T ghost2;
    private Ghost3T ghost3;
    private Ghost4T ghost4;
    private Figura_ghost1T fig_ghost1;
    private Figura_ghost2T fig_ghost2;
    private Figura_ghost3T fig_ghost3;
    private Figura_ghost4T fig_ghost4;
    private int puntos = 0;
    private boolean aux = false;
    private boolean inicio_fantasmas = false;
    private static Timer timer;
    private static String min = "", seg = "", mil = "";
    private Tiempo t;


    public ComecocosFrameTeleco() {
        initComponents();
        rejilla = new RejillaTeleco(32, 38);
        setLocationRelativeTo(null);
        setResizable(false);
        this.getPanel().setSize(864, 650);
        setTitle("Comecocos Teleco");
        mueve = new MueveTeleco(this, 6);
        ghost1 = new Ghost1T(this, 6);
        ghost2 = new Ghost2T(this, 6);
        ghost3 = new Ghost3T(this, 6);
        ghost4 = new Ghost4T(this, 6);
        nuevaFigura();
        txt_puntos.setEditable(false);
        txt_puntos.setText("0");
        txt_vidas.setText("3");
        mueve.reanudar();
        nuevoFantasma(1);
        nuevoFantasma(2);
        nuevoFantasma(3);
        nuevoFantasma(4);
        rejilla.initRejilla();
        nuevaFigura();
        tiempo.setText("00:00:000");
        t = new Tiempo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_puntos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_vidas = new javax.swing.JTextField();
        label_parado = new javax.swing.JLabel();
        rejillaPanelTeleco2 = new RejillaPanelTeleco(this);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tiempo = new javax.swing.JTextField();
        fantasmacomido = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Juego = new javax.swing.JMenu();
        NuevoJuego = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(864, 650));
        setPreferredSize(new java.awt.Dimension(1050, 632));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Vidas:");

        label_parado.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        label_parado.setForeground(new java.awt.Color(255, 0, 0));

        rejillaPanelTeleco2.setMaximumSize(new java.awt.Dimension(609, 513));
        rejillaPanelTeleco2.setMinimumSize(new java.awt.Dimension(609, 513));
        rejillaPanelTeleco2.setName(""); // NOI18N
        rejillaPanelTeleco2.setPreferredSize(new java.awt.Dimension(609, 513));
        rejillaPanelTeleco2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rejillaPanelTeleco2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout rejillaPanelTeleco2Layout = new javax.swing.GroupLayout(rejillaPanelTeleco2);
        rejillaPanelTeleco2.setLayout(rejillaPanelTeleco2Layout);
        rejillaPanelTeleco2Layout.setHorizontalGroup(
            rejillaPanelTeleco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        rejillaPanelTeleco2Layout.setVerticalGroup(
            rejillaPanelTeleco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Puntuación:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Tiempo:");

        fantasmacomido.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        fantasmacomido.setForeground(new java.awt.Color(255, 0, 0));

        Juego.setMnemonic('J');
        Juego.setText("Juego");
        Juego.setToolTipText("Juego");

        NuevoJuego.setMnemonic('N');
        NuevoJuego.setText("Nuevo juego");
        NuevoJuego.setToolTipText("Nuevo juego");
        NuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoJuegoActionPerformed(evt);
            }
        });
        Juego.add(NuevoJuego);

        Salir.setMnemonic('S');
        Salir.setText("Salir");
        Salir.setToolTipText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Juego.add(Salir);

        jMenuBar1.add(Juego);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1054, 1054, 1054)
                .addComponent(label_parado, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(rejillaPanelTeleco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_vidas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(txt_puntos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(fantasmacomido, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label_parado, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_puntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_vidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(fantasmacomido, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rejillaPanelTeleco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea salir del juego?", "", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void NuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoJuegoActionPerformed
        this.getPanel().setIm1(new ImageIcon(this.getClass().getResource("./images/ghost_r1.png")).getImage());
        this.getPanel().setIm2(new ImageIcon(this.getClass().getResource("./images/ghost_g1.png")).getImage());
        this.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/ghost_a1.png")).getImage());
        this.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/ghost_v1.png")).getImage());
        tiempo.setText("00:00:000");
        t.reinicio();
        MueveTeleco.vidas = 3;
        try {
            sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComecocosFrameTeleco.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicializaJuego(0, 3);
        this.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
    }//GEN-LAST:event_NuevoJuegoActionPerformed

    private void rejillaPanelTeleco2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rejillaPanelTeleco2KeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_SPACE) && (aux == false)) {
            mueve.suspender();
            suspenderFantasmas();
            label_parado.setText("Pulse ESPACIO para continuar");
            aux = true;
        } else if ((evt.getKeyCode() == KeyEvent.VK_SPACE) && (aux == true)) {
            mueve.reanudar();
            reanudarFantasmas();
            label_parado.setText("");
            aux = false;
        }

        if (inicio_fantasmas == false) {
            if ((evt.getKeyCode() == KeyEvent.VK_LEFT) || (evt.getKeyCode() == KeyEvent.VK_RIGHT)
                    || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                inicio_fantasmas = true;
                mueve.reanudar();
                reanudarFantasmas();

            }
        }
    }//GEN-LAST:event_rejillaPanelTeleco2KeyPressed

    public void inicializaJuego(int puntos, int vidas) {
        inicio_fantasmas = false;
        rejilla.assignTipoCelda(12, 12, RejillaTeleco.nada);
        rejilla.assignTipoCelda(12, 13, RejillaTeleco.nada);
        rejilla.assignTipoCelda(12, 14, RejillaTeleco.nada);
        rejilla.assignTipoCelda(12, 15, RejillaTeleco.nada);
        this.puntos = puntos;
        mueve.suspender();
        if (this.puntos == 0) {
            rejilla = new RejillaTeleco(32, 38);
            rejilla.initRejilla();
        }
        ghost1.setSubir(true);
        ghost2.setSubir(true);
        ghost3.setSubir(true);
        ghost4.setSubir(true);
        mueve.suspender();

        suspenderFantasmas();
        txt_puntos.setText("" + puntos);
        txt_vidas.setText("" + vidas);

        FiguraTeleco.xorigen = 11;
        FiguraTeleco.yorigen = 21;
        this.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
        Figura_ghost1T.setComestible(false);
        Figura_ghost2T.setComestible(false);
        Figura_ghost3T.setComestible(false);
        Figura_ghost4T.setComestible(false);

        Figura_ghost1T.xorigen = 22;
        Figura_ghost1T.yorigen = 17;
        Figura_ghost2T.xorigen = 23;
        Figura_ghost2T.yorigen = 17;
        Figura_ghost3T.xorigen = 24;
        Figura_ghost3T.yorigen = 17;
        Figura_ghost4T.xorigen = 25;
        Figura_ghost4T.yorigen = 17;
        MueveTeleco.inicio = true;

        FiguraTeleco.direccion = FiguraTeleco.PARADO;

    }

    public void mostrarVidas() {
        String vidas_string = "" + MueveTeleco.vidas;
        txt_vidas.setText(vidas_string);
    }

    public void nuevaFigura() {
        figura = FiguraTeleco.nuevaFigura();
    }

    public void nuevoFantasma(int ent) {
        if (ent == 1) {
            fig_ghost1 = Figura_ghost1T.nuevoFantasma();
        }
        if (ent == 2) {
            fig_ghost2 = Figura_ghost2T.nuevoFantasma();
        }
        if (ent == 3) {
            fig_ghost3 = Figura_ghost3T.nuevoFantasma();
        }
        if (ent == 4) {
            fig_ghost4 = Figura_ghost4T.nuevoFantasma();
        }
    }

    public synchronized void puntuar(int p) {
        if (p > 100) {
            fantasmacomido.setText("+" + p);
        }
        puntos = puntos + p;
        String str = "" + puntos;
        txt_puntos.setText(str);
        Timer temp = new Timer(8000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fantasmacomido.setText("");
            }
        });
        temp.start();
        temp.setRepeats(false);
    }

    public double distancia(int x1, int x2, int y1, int y2) {
        double dist = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));

        return dist;
    }

    public void suspenderFantasmas() {
        ghost1.suspender();
        ghost2.suspender();
        ghost3.suspender();
        ghost4.suspender();
    }

    public void reanudarFantasmas() {
        ghost1.reanudar();
        ghost2.reanudar();
        ghost3.reanudar();
        ghost4.reanudar();
    }

    public Figura_ghost3T getFig_ghost3() {
        return fig_ghost3;
    }

    public Figura_ghost4T getFig_ghost4() {
        return fig_ghost4;
    }

    public RejillaPanelTeleco getPanel() {
        return rejillaPanelTeleco2;
    }

    public int getPuntos() {
        return puntos;
    }

    public RejillaTeleco getRejilla() {
        return rejilla;
    }

    public FiguraTeleco getFigura() {
        return figura;
    }

    public Figura_ghost1T getFig_ghost1() {
        return fig_ghost1;
    }

    public Figura_ghost2T getFig_ghost2() {
        return fig_ghost2;
    }

    public static String getMin() {
        return min;
    }

    public static String getSeg() {
        return seg;
    }

    public static String getMil() {
        return mil;
    }

    public static void setMin(String min) {
        ComecocosFrameTeleco.min = min;
    }

    public static void setSeg(String seg) {
        ComecocosFrameTeleco.seg = seg;
    }

    public static void setMil(String mil) {
        ComecocosFrameTeleco.mil = mil;
    }

    public void setPuntos(int punt) {
        this.puntos = punt;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Juego;
    private javax.swing.JMenuItem NuevoJuego;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JLabel fantasmacomido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel label_parado;
    private ComecocosTeleco.RejillaPanelTeleco rejillaPanelTeleco2;
    public static javax.swing.JTextField tiempo;
    private javax.swing.JTextField txt_puntos;
    private javax.swing.JTextField txt_vidas;
    // End of variables declaration//GEN-END:variables

}
