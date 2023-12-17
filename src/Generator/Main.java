
package Generator;

public class Main {
    
    public static boolean VerificadorIdioma = false;            //Verifica el idioma en el que se está tarbajando
    static int ContadorIdioma = 1;                              //Hace posible alternar entre idiomas
    static public VentanaPrincipal ventana1;                    //Crea una instacia de la ventana inicial
    public static int ContadorMusica = 1;                       //Hace posible prender y apagar la música - impar ON / par OFF
    public static Reproductor musica;
    
    public static void main(String[] args) {
        
        ventana1 = new VentanaPrincipal();
        ventana1.setTitle("Config Generator by LeonN");
    }
 
}
