
package Generator.creacion;

import static Generator.creacion.CreacionPrincipal.focus;
import static Generator.creacion.CreacionPrincipal.focus2;
import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class TextEditor {
    
    public static void cambiarColor(Color color) {
        if(focus == null && focus2 == null) {
            
        }   else if (focus != null && focus2 == null){
                int inicio = focus.getSelectionStart();
                int fin = focus.getSelectionEnd();
                int largo = fin - inicio;
                StyledDocument style = focus.getStyledDocument();
                AttributeSet oldSet = style.getCharacterElement(fin-1).getAttributes();
                StyleContext sc = StyleContext.getDefaultStyleContext();
                AttributeSet s = sc.addAttribute(oldSet, StyleConstants.Foreground, color);
                style.setCharacterAttributes(inicio, largo, s, true);
                
        }   else if (focus2 != null && focus == null) {
                int inicio = focus2.getSelectionStart();
                int fin = focus2.getSelectionEnd();
                int largo = fin - inicio;
                StyledDocument style = focus2.getStyledDocument();
                AttributeSet oldSet = style.getCharacterElement(fin-1).getAttributes();
                StyleContext sc = StyleContext.getDefaultStyleContext();
                AttributeSet s = sc.addAttribute(oldSet, StyleConstants.Foreground, color);
                style.setCharacterAttributes(inicio, largo, s, true);
        }
        
    }
}
