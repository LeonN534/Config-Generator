
package Generator.creacion;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JToolTip;

public class CustomToolTip extends JToolTip {
    
    public CustomToolTip(JComponent component) {
        super();
        setComponent(component);
        setBackground(new java.awt.Color(158, 227, 245));
        setForeground(Color.black);
        setBorder(null);
    }
}
