package data;

/**
 * La clase Temporizador implementa la interfaz Runnable y es la encargada de
 * dar un tiempo m�ximo al juego. Al empezar una partida nueva se fija el
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
     * Representa la suspensi�n de la hebra.
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
     * Tambi�n se utiliza para crear y empezar la hebra.
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
     * M�todo que sobreescribe el m�todo run del interfaz Runnable. Esta hebra
     * es muy sencilla, �nicamente se duerme cada 1000 ms (1segundo), y
     * decrementa una variable segundos en cada iteraci�n. Si los segundos
     * llegan a valer cero se suspende la hebra, y se fija la variable derrota
     * de la clase Mueve a true (por lo que el juego acaba; se da la opci�n de
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
     * M�todo que detiene moment�neamente la ejecuci�n de la hebra, haciendo que
     * el temporizador pare de contar hacia atr�s hasta nueva orden.
     *
     */
    synchronized public void suspender() {
        suspendFlag = true;
    }

    /**
     * M�todo que reanuda el movimiento de la hebra, por lo que el temporizador
     * reanuda su cuenta hacia atr�s.
     *
     */
    public synchronized void reanudar() {
        suspendFlag = false;
        notify();
    }

    /**
     * M�todo que se encarga de fijar los segundos actuales del temporizador a
     * un valor.
     *
     * @param segundos de tipo Integer.
     *
     */
    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    /**
     * M�todo que permite fijar el tiempo m�ximo permitido en este nivel.
     * @param tiempo de tipo int.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
