
package Generator;

import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Reproductor extends Thread{
       

    private boolean bucle;
    private Player reproductor;

    public Reproductor(boolean bucle) {
        this.bucle = bucle;
    }    

    public void run() {
        try {
            do{
                InputStream buff;
                buff = getClass().getResourceAsStream("/Recursos/TriageAtDawn.mp3");
                reproductor = new Player(buff);
                //reproductor.play();
                try {
                    reproductor.play();
                } catch (JavaLayerException ex) {}
            }while(bucle);
        }   catch(JavaLayerException ioe) {}  
    }

    public void parar() {
            bucle = false;
            reproductor.close();
            this.interrupt();
        }  

    }
