package comecocos;

/**
 * La clase ComecocosFrame es la encargada de inicializar el juego creando e
 * iniciando todos componentes.
 *
 * @author Ignacio y Alejandro
 */
import data.Figura;
import data.Figura_ghost1;
import data.Figura_ghost2;
import data.Figura_ghost3;
import data.Figura_ghost4;
import data.Ghost1;
import data.Ghost2;
import data.Ghost3;
import data.Ghost4;
import data.Mueve;
import data.Rejilla;
import data.Temporizador;
import data.Tiempo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ComecocosFrame extends javax.swing.JFrame {

    /**
     * Representa la rejilla del laberinto.
     */
    private Rejilla rejilla;
    /**
     * Representa el Pacman.
     */
    private Figura figura;
    /**
     * Este objeto es la hebra que permite el movimiento del Pacman.
     */
    private Mueve mueve;
    /**
     * Permite el movimiento del fantasma 1.
     */
    private Ghost1 ghost1;
    /**
     * Permite el movimiento del fantasma 2.
     */
    private Ghost2 ghost2;
    /**
     * Permite el movimiento del fantasma 3.
     */
    private Ghost3 ghost3;
    /**
     * Permite el movimiento del fantasma 4.
     */
    private Ghost4 ghost4;
    /**
     * Representa al fantasma 1.
     */
    private Figura_ghost1 fig_ghost1;
    /**
     * Representa al fantasma 2.
     */
    private Figura_ghost2 fig_ghost2;
    /**
     * Representa al fantasma 3.
     */
    private Figura_ghost3 fig_ghost3;
    /**
     * Representa al fantasma 4.
     */
    private Figura_ghost4 fig_ghost4;
    /**
     * Se utiliza para llevar la cuenta de la puntuación actual.
     */
    private int puntos = 0;
    /**
     * Se utiliza para parar y reanudar el juego mediante la barra espaciadora.
     */
    private boolean aux = false;
    /**
     * Se emplea para mantener a los fantasmas parados hasta que el Pacman
     * comience a moverse.
     */
    private boolean inicio_fantasmas = false;
    /**
     * Permite mostrar la cuenta de los minutos.
     */
    private static String min = "";
    /**
     * Permite mostrar la cuenta de los minutos.
     */
    private static String seg = "";
    /**
     * Permite mostrar la cuenta de los minutos.
     */
    private static String mil = "";
    /**
     * Representa los segundos restantes del temporizador.
     */
    private static String segundos = "";
    /**
     * Representa la hebra para contabilizar el tiempo de juego.
     */
    private Tiempo t;
    /**
     * Establece la dificultad del juego (en cuanto a velocidad de los fantasmas
     * y Pacman se refiere).
     */
    private int nivel = 6;
    /**
     * Representa un temporizador (tiempo restante de un nivel).
     */
    private Temporizador tempo;

    /**
     * Constructor de ComecocosFrame
     *
     * Es el encargado de inicializar el jFrame. Se creaa la rejilla con
     * dimensiones 31x28. Se inicializan los fantasmas (sus figuras y sus
     * hebras) así como el Pacman. Se establece también el tiempo inicial, la
     * puntuación inicial y las vidas.
     */
    public ComecocosFrame() {
        initComponents();
        rejilla = new Rejilla(31, 28);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Comecocos");
        mueve = new Mueve(this, nivel);
        ghost1 = new Ghost1(this, nivel - 1);
        ghost2 = new Ghost2(this, nivel - 1);
        ghost3 = new Ghost3(this, nivel - 1);
        ghost4 = new Ghost4(this, nivel - 1);
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
        txt_temp.setText("" + 100);
        t = new Tiempo();
        tempo = new Temporizador(this, 2);
        tempo.setSegundos(100);
        tempo.setTiempo(100);
        txt_vidas.setEditable(false);
        txt_temp.setEditable(false);
        tiempo.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rejillaPanel1 = new RejillaPanel(this);
        jLabel1 = new javax.swing.JLabel();
        txt_puntos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_vidas = new javax.swing.JTextField();
        label_parado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tiempo = new javax.swing.JTextField();
        fantasmacomido = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_temp = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Juego = new javax.swing.JMenu();
        NuevoJuego = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rejillaPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rejillaPanel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout rejillaPanel1Layout = new javax.swing.GroupLayout(rejillaPanel1);
        rejillaPanel1.setLayout(rejillaPanel1Layout);
        rejillaPanel1Layout.setHorizontalGroup(
            rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        rejillaPanel1Layout.setVerticalGroup(
            rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Puntuacion:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Vidas:");

        label_parado.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        label_parado.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Tiempo:");

        fantasmacomido.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        fantasmacomido.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Tiempo restante:");

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
                .addGap(26, 26, 26)
                .addComponent(rejillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_vidas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(fantasmacomido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(59, 59, 59))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_temp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(label_parado, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label_parado, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(rejillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_puntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_vidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fantasmacomido, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que nos permite confirmar si queremos salir del juego elegimos la
     * opción de salir.
     *
     * @param evt de tipo java.awt.event.ActionEvent.
     * @return void
     */
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea salir del juego?", "", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_SalirActionPerformed
    /**
     * Método que nos permite confirmar iniciar una nueva partida cuando
     * pinchamos en Nuevo Juego . Inicializa el juego fijando las imágenes de
     * los fantasmas y poniendo a cero el tiempo, y las vidas a 3.
     *
     * @param evt de tipo java.awt.event.ActionEvent.
     * @return void
     */
    private void NuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoJuegoActionPerformed
        this.getPanel().setIm1(new ImageIcon(this.getClass().getResource("./images/ghost_r1.png")).getImage());
        this.getPanel().setIm2(new ImageIcon(this.getClass().getResource("./images/ghost_g1.png")).getImage());
        this.getPanel().setIm3(new ImageIcon(this.getClass().getResource("./images/ghost_a1.png")).getImage());
        this.getPanel().setIm4(new ImageIcon(this.getClass().getResource("./images/ghost_v1.png")).getImage());
        tiempo.setText("00:00:000");
        t.reinicio();
        Mueve.vidas = 3;
        try {
            sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(ComecocosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicializaJuego(0, 3);
    }//GEN-LAST:event_NuevoJuegoActionPerformed

    /**
     * Método que nos permite pausar el juego pulsando en la barra espaciadora.
     * Se suspende la actividad de los fantasmas, del comecocos y del tiempo. Si
     * pulsamos otra vez la tecla, reanuda la partida
     *
     * @param evt de tipo java.awt.event.KeyEvent.
     * @return void
     */
    private void rejillaPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rejillaPanel1KeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_SPACE) && (aux == false)) {
            mueve.suspender();
            suspenderFantasmas();
            label_parado.setText("Pulse ESPACIO para continuar");
            t.suspender();
            tempo.suspender();
            aux = true;
        } else if ((evt.getKeyCode() == KeyEvent.VK_SPACE) && (aux == true)) {
            mueve.reanudar();
            reanudarFantasmas();
            label_parado.setText("");
            aux = false;
            t.reanudar();
            tempo.reanudar();
        }

        if (inicio_fantasmas == false) {
            if ((evt.getKeyCode() == KeyEvent.VK_LEFT) || (evt.getKeyCode() == KeyEvent.VK_RIGHT)
                    || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                inicio_fantasmas = true;
                mueve.reanudar();
                reanudarFantasmas();
                t.reanudar();
                tempo.reanudar();

            }
        }
    }//GEN-LAST:event_rejillaPanel1KeyPressed

    /**
     * Método que se encarga de inicializar el juego. Abre la puerta donde se
     * encuentran los fantasmas para que estos puedan salir de la celda.
     * Suspende la hebra del Pacman y le fija la dirección a PARADO. Prepara a
     * la hebra de cada fantasma para que lo siguiente que haga sea subir
     * (ghostX.setSubir(true)). Con esto se consigue que al abrir la puerta, los
     * fantasmas salgan hacia arriba. Por último, este método coloca al
     * comecocos y a cada fantasma en su posición inicial correspondiente. Los
     * argumentos que recibe se utilizan para fijar el valor de los datos
     * miembro puntos y vidas.
     *
     * @param puntos de tipo int.
     * @param vidas de tipo int.
     */
    public void inicializaJuego(int puntos, int vidas) {
        inicio_fantasmas = false;
        rejilla.assignTipoCelda(12, 12, Rejilla.nada);
        rejilla.assignTipoCelda(12, 13, Rejilla.nada);
        rejilla.assignTipoCelda(12, 14, Rejilla.nada);
        rejilla.assignTipoCelda(12, 15, Rejilla.nada);
        this.puntos = puntos;
        mueve.suspender();
        if (this.puntos == 0) {
            rejilla = new Rejilla(31, 28);
            rejilla.initRejilla();
        }
        tempo.suspender();
        suspenderFantasmas();
        ghost1.setSubir(true);
        ghost2.setSubir(true);
        ghost3.setSubir(true);
        ghost4.setSubir(true);
        txt_puntos.setText("" + puntos);
        txt_vidas.setText("" + vidas);
        Figura.xorigen = 12;
        Figura.yorigen = 22;
        this.getPanel().setIm(new ImageIcon(this.getClass().getResource("./images/der_c.png")).getImage());
        Figura_ghost1.setComestible(false);
        Figura_ghost2.setComestible(false);
        Figura_ghost3.setComestible(false);
        Figura_ghost4.setComestible(false);

        Figura_ghost1.setXorigen(11);
        Figura_ghost1.setYorigen(13);
        Figura_ghost2.setXorigen(12);
        Figura_ghost2.setYorigen(13);
        Figura_ghost3.xorigen = 13;
        Figura_ghost3.yorigen = 13;
        Figura_ghost4.xorigen = 14;
        Figura_ghost4.yorigen = 13;
        Mueve.setInicio(true);
        t.suspender();

        tempo.setSegundos(100);
        tempo.setTiempo(100);
        Figura.setDireccion(Figura.PARADO);
        t.reinicio();
        tiempo.setText("00:00:000");
    }

    /**
     * Método que guarda en una variable String las vidas actuales, y las fija
     * en el campo de texto txt_vidas.
     *
     */
    public void mostrarVidas() {
        String vidas_string = "" + Mueve.vidas;
        txt_vidas.setText(vidas_string);

    }

    /**
     * Método que devuelve el contenido del campo txt_vidas
     *
     * @return el valor del campo txt_vidas
     */
    public JTextField getTxt_vidas() {
        return txt_vidas;
    }

    /**
     * Método que suma a la puntuación actual los puntos correspondientes. Si
     * hay que mostrar 10 puntos o 50 se hace sin más que pasar el número de
     * puntos a una variable String. Si hay que mostrar 200, 400, 800 o 1600
     * puntos (porque se haya comido a 1, 2, 3 o 4 fantasmas después de comer un
     * punto gordo) se muestra en una etiqueta jLabel esa puntuación durante un
     * periodo de tiempo de 8 segundos. Esto se consigue asociando un
     * ActionListener al temporizadore de 8 segundos. Una vez transcurridos los
     * 8 segundos, la acción que se lleva a cabo es no mostrar nada por la
     * etiqueta en cuestión.
     *
     * @param p de tipo int.
     */
    public void puntuar(int p) {
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
        temp.setRepeats(false);
        temp.start();

    }

    /**
     * Método que recibe un número entero que se usará para crear el fantasma
     * correspondiente según el número. Por ejemplo, si se recibe un 1, el
     * método crea el fantasma número 1 y lo asocia al dato miembro fig_ghost1.
     * De igual forma ocurre para los otros tres fantasmas.
     *
     * @param ent de tipo int.
     */
    public void nuevoFantasma(int ent) {
        if (ent == 1) {
            fig_ghost1 = Figura_ghost1.nuevoFantasma();
        }
        if (ent == 2) {
            fig_ghost2 = Figura_ghost2.nuevoFantasma();
        }
        if (ent == 3) {
            fig_ghost3 = Figura_ghost3.nuevoFantasma();
        }
        if (ent == 4) {
            fig_ghost4 = Figura_ghost4.nuevoFantasma();
        }
    }

    /**
     * Método que recibe como parámetros cuatro componentes de tipo entero.
     * Básicamente consiste en calcular la distancia euclídea entre dos puntos,
     * que devuelve como salida.
     *
     * @param x1 de tipo int.
     * @param x2 de tipo int.
     * @param y1 de tipo int.
     * @param y2 de tipo int.
     * @return dist
     */
    public double distancia(int x1, int x2, int y1, int y2) {
        double dist = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));

        return dist;
    }

    /**
     * Método que se encarga de suspender las hebras de los cuatro fantasmas.
     *
     */
    public void suspenderFantasmas() {
        ghost1.suspender();
        ghost2.suspender();
        ghost3.suspender();
        ghost4.suspender();
    }

    /**
     * Método que se encarga de reanudar las hebras de los cuatro fantasmas.
     * Para ello, se llama al método reanudar de la clase GhostX, donde X indica
     * el número de fantasma (1,2,3 o 4).
     *
     */
    public void reanudarFantasmas() {
        ghost1.reanudar();
        ghost2.reanudar();
        ghost3.reanudar();
        ghost4.reanudar();
    }

    /**
     * Método que se encarga de crear un nuevo Pacman y de asociarlo al dato
     * miembro figura de esta clase.
     *
     */
    public void nuevaFigura() {
        figura = Figura.nuevaFigura();
    }

    /**
     * Método que devuelve el dato miembro rejilla.
     *
     * @return rejilla
     */
    public Rejilla getRejilla() {
        return rejilla;
    }

    /**
     * Método que devuelve el dato miembro figura.
     *
     * @return figura
     */
    public Figura getFigura() {
        return figura;
    }

    /**
     * Método que devuelve el dato miembro puntos.
     *
     * @return puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Método que devuelve la figura del primer fantasma.
     *
     * @return fig_ghost1
     */
    public Figura_ghost1 getFig_ghost1() {
        return fig_ghost1;
    }

    /**
     * Método que devuelve la figura del segundo fantasma.
     *
     * @return fig_ghost2
     */
    public Figura_ghost2 getFig_ghost2() {
        return fig_ghost2;
    }

    /**
     * Método que devuelve la figura del tercer fantasma.
     *
     * @return fig_ghost3
     */
    public Figura_ghost3 getFig_ghost3() {
        return fig_ghost3;
    }

    /**
     * Método que devuelve la figura del cuarto fantasma.
     *
     * @return fig_ghost4
     */
    public Figura_ghost4 getFig_ghost4() {
        return fig_ghost4;
    }

    /**
     * Método que devuelve el dato miembro rejillaPanel1
     *
     * @return rejillaPanel1
     */
    public RejillaPanel getPanel() {
        return rejillaPanel1;
    }

    /**
     * Método que devuelve los minutos.
     *
     * @return min
     */
    public static String getMin() {
        return min;
    }

    /**
     * Método que devuelve los segundos.
     *
     * @return seg
     */
    public static String getSeg() {
        return seg;
    }

    /**
     * Método que devuelve los milisegundos.
     *
     * @return mil
     */
    public static String getMil() {
        return mil;
    }

    /**
     * Método utilizado para fijar el dato miembro relativo a los milisegundos.
     *
     * @param mil de tipo String.
     *
     */
    public static void setMil(String mil) {
        ComecocosFrame.mil = mil;
    }

    /**
     * Método que devuelve el dato miembro segundos.
     * @return segundos
     */
    public static String getSegundos() {
        return segundos;
    }

    /**
     * Método que fija el campo segundos (lo toma del parámetro que se recibe
     * como argumento).
     *
     * @param segundos de tipo String.
     *
     */
    public static void setSegundos(String segundos) {
        ComecocosFrame.segundos = segundos;
    }

    /**
     * Método utilizado para fijar el dato miembro relativo a los segundos.
     *
     * @param seg de tipo String.
     *
     */
    public static void setSeg(String seg) {
        ComecocosFrame.seg = seg;
    }

    /**
     * Método utilizado para fijar el dato miembro relativo a los minutos.
     *
     * @param min de tipo String.
     *
     */
    public static void setMin(String min) {
        ComecocosFrame.min = min;
    }

    /**
     * Método utilizado para fijar el dato miembro relativo a los puntos.
     *
     * @param punt de tipo int.
     *
     */
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel label_parado;
    private comecocos.RejillaPanel rejillaPanel1;
    public static javax.swing.JTextField tiempo;
    private javax.swing.JTextField txt_puntos;
    public static javax.swing.JTextField txt_temp;
    private javax.swing.JTextField txt_vidas;
    // End of variables declaration//GEN-END:variables

}
