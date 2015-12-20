package data;

/**
 * La clase Temporizador implementa la interfaz Runnable y es la encargada de
 * dar un tiempo máximo al juego. Al empezar una partida nueva se fija el
 * temporizador a 100 segundos. Si no se han comido todos los puntos del
 * laberinto y el temporizador ha expirado la partida se ha perdido.
 *
 * @author Ignacio y Alejandro
 */
import comecocos.ComecocosFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temporizador implements Runnable {

    /**
     *
     * Referencia los segundos.
     */
    private Integer segundos;
    /**
     *
     * Representa la suspensión de la hebra.
     */
    private boolean suspendFlag = true;
    /**
     *
     * Referencia el tiempo restante.
     */
    private int tiempo;
    /**
     *
     * Representa la referencia a la clase ComecocosFrame.
     */
    private ComecocosFrame frame;

    /**
     * Constructor de la clase en el que se inicializa el frame y el tiempo.
     * También se utiliza para crear y empezar la hebra.
     *
     * @param fr de tipo ComecocosFrame.
     * @param tiempo de tipo int.
     *
     */
    public Temporizador(ComecocosFrame fr, int tiempo) {
        this.frame = fr;
        this.tiempo = tiempo;
        segundos = tiempo;
        Thread hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Método que sobreescribe el método run del interfaz Runnable. Esta hebra
     * es muy sencilla, únicamente se duerme cada 1000 ms (1segundo), y
     * decrementa una variable segundos en cada iteración. Si los segundos
     * llegan a valer cero se suspende la hebra, y se fija la variable derrota
     * de la clase Mueve a true (por lo que el juego acaba; se da la opción de
     * volver a jugar).
     *
     *
     */
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
                Thread.sleep(1000);
                segundos -= 1;

                ComecocosFrame.setSegundos(segundos.toString());
                ComecocosFrame.txt_temp.setText(ComecocosFrame.getSegundos());
                if ((segundos == 0) && (Mueve.vidas == 0)) {
                    segundos = this.tiempo;
                    Mueve.derrota = true;
                    suspender();
                } else if ((segundos == 0)) {
                    segundos = this.tiempo;
                    frame.inicializaJuego(frame.getPuntos(), Integer.parseInt(frame.getTxt_vidas().getText().toString()) - 1);
                    suspender();
                    Mueve.vidas--;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que detiene momentáneamente la ejecución de la hebra, haciendo que
     * el temporizador pare de contar hacia atrás hasta nueva orden.
     *
     */
    synchronized public void suspender() {
        suspendFlag = true;
    }

    /**
     * Método que reanuda el movimiento de la hebra, por lo que el temporizador
     * reanuda su cuenta hacia atrás.
     *
     */
    public synchronized void reanudar() {
        suspendFlag = false;
        notify();
    }

    /**
     * Método que se encarga de fijar los segundos actuales del temporizador a
     * un valor.
     *
     * @param segundos de tipo Integer.
     *
     */
    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    /**
     * Método que permite fijar el tiempo máximo permitido en este nivel.
     * @param tiempo de tipo int.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
