package data;

/**
 * La clase Tiempo implementa la interfaz Runnable para ejecutar una hebra
 * independientemente.
 *
 * @author Ignacio y Alejandro
 */
import comecocos.ComecocosFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tiempo implements Runnable {

    /**
     * Representa los minutos (de tipo entero)
     */
    private Integer minutos = 0;
    /**
     * Representa los segundos (de tipo entero)
     */
    private Integer segundos = 0;
    /**
     * Representa las milesimas (de tipo entero)
     */
    private Integer milesimas = 0;

    /**
     * Esta variable booleana permite suspender la hebra hasta nuevo aviso. El
     * tiempo por lo tanto se detendrá.
     */
    private boolean suspendFlag = true;

    /**
     * Constructor de la clase. Crea una hebra y la inicializa.
     */
    public Tiempo() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Metodo que cada 10 milisegundos duerme a la hebra (es necesario utilizar
     * un try-catch) y actualizar el valor de la variable milesimas (sumandole
     * 10). Cuando el valor de milesimas alcanza 1000, le sumamos 1 al campos
     * segundos y cuando se llega a 60 segundos se le suma 1 a minutos. Por
     * último, establecemos el siguiente formato de tiempo: 00:00:000 y lo
     * fijamos en la casilla del tiempo que se encuentra dentro de la clase
     * ComecocosFrame.
     *
     */
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
                Thread.sleep(10);
                milesimas += 10;

                if (milesimas == 1000) {
                    milesimas = 0;
                    segundos += 1;
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                }
                if (minutos < 10) {
                    ComecocosFrame.setMin("0" + minutos);
                } else {
                    ComecocosFrame.setMin(minutos.toString());
                }
                if (segundos < 10) {
                    ComecocosFrame.setSeg("0" + segundos);
                } else {
                    ComecocosFrame.setSeg(segundos.toString());
                }

                if (milesimas < 10) {
                    ComecocosFrame.setMil("00" + milesimas);
                } else if (milesimas < 100) {
                    ComecocosFrame.setMil("0" + milesimas);
                } else {
                    ComecocosFrame.setMil(milesimas.toString());
                }
                ComecocosFrame.tiempo.setText(ComecocosFrame.getMin() + ":" + ComecocosFrame.getSeg() + ":" + ComecocosFrame.getMil());
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo que detiene momentáneamente la ejecución de la hebra, haciendo que
     * el tiempo de juego total se quede parado.
     *
     */
    synchronized public void suspender() {
        suspendFlag = true;
    }

    /**
     * Metodo que reanuda el movimiento de la hebra, por lo que el tiempo vuelve
     * a correr.
     *
     */
    public synchronized void reanudar() {
        suspendFlag = false;
        notify();
    }

    /**
     * Metodo que se encarga de establecer a cero el tiempo (minutos, segundos y
     * milesimas).
     *
     */
    public void reinicio() {
        minutos = 0;
        segundos = 0;
        milesimas = 0;
    }
}
