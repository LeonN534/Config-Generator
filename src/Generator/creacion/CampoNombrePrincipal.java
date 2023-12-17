
package Generator.creacion;

import javax.swing.JTextPane;

public final class CampoNombrePrincipal extends JTextPane {
    

    
    public CampoNombrePrincipal() {

        setVisible(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(255, 179, 0));
        setFont(new java.awt.Font("Dialog", 0, 24));
        setBorder(null);
        setCaretColor(new java.awt.Color(255, 255, 255));
        setBounds(0, 0, 440, 40);
        setSelectedTextColor(new java.awt.Color(187,187,187));
        setSelectionColor(new java.awt.Color(75,110,175));
        setFocusable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        setEditable(true);
        setOpaque(true);
        setEnabled(true);

    }
    
}
