
package dataTeleco;

import ComecocosTeleco.ComecocosFrameTeleco;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tiempo implements Runnable {

    public boolean crono = true;
    Integer minutos = 0, segundos = 0, milesimas = 0;

    public Tiempo() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
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
                    ComecocosFrameTeleco.setMin("0" + minutos); 
                } else {
                    ComecocosFrameTeleco.setMin(minutos.toString()); 
                }
                if (segundos < 10) {
                    ComecocosFrameTeleco.setSeg("0" + segundos);
                } else {
                    ComecocosFrameTeleco.setSeg(segundos.toString());
                }

                if (milesimas < 10) {
                    ComecocosFrameTeleco.setMil("00" + milesimas); 
                } else if (milesimas < 100) {
                    ComecocosFrameTeleco.setMil("0" + milesimas);
                } else {
                    ComecocosFrameTeleco.setMil(milesimas.toString());
                }

                ComecocosFrameTeleco.tiempo.setText(ComecocosFrameTeleco.getMin() + ":" + ComecocosFrameTeleco.getSeg() + ":" + ComecocosFrameTeleco.getMil());
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void parar() {
        crono = false;
    }

    public void reanudar() {
        crono = true;
    }

    public void reinicio() {
        minutos = 0;
        segundos = 0;
        milesimas = 0;

    }
}
