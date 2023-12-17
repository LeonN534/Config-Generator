
package Generator.creacion;


import static Generator.creacion.CreacionPrincipal.Aviso;
import static Generator.creacion.CreacionPrincipal.focus;
import static Generator.creacion.CreacionPrincipal.focus2;
import static Generator.creacion.CreacionPrincipal.numeroTextFields;
import static Generator.creacion.CreacionPrincipal.posYBoton;
import static Generator.creacion.CreacionPrincipal.posYPanel;
import static Generator.creacion.CreacionPrincipal.scrollPane;
import static Generator.creacion.CreacionPrincipal.textfields;
import static Generator.creacion.CreacionPrincipal.arrayNombresOpc;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class CustomButton extends JButton{
    
        int y = 300;
        static AdjustmentListener scroll = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        };
        
    public CustomButton(int posY) {
        
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numeroTextFields++;
                posYPanel = posYPanel + 60;
                posYBoton = posYBoton + 60;
                final CustomTextPane panel = new CustomTextPane(posYPanel);
                MouseListener texto2 = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}

                    @Override
                    public void mousePressed(MouseEvent e) {
                        focus = null;
                        focus2 = panel;
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mouseEntered(MouseEvent e) {}
                    @Override
                    public void mouseExited(MouseEvent e) {}
                };
                KeyListener eventoTeclado2 = new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                       if(panel.getText().length() >= 27) {
                           e.consume();
                           Aviso.setVisible(true);
                       }    else {
                           Aviso.setVisible(false);
                       }
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {}

                    @Override
                    public void keyReleased(KeyEvent e) {}
                };
                setBounds(390, posYBoton, 30, 30);  
                panel.addMouseListener(texto2);
                panel.addKeyListener(eventoTeclado2);
                arrayNombresOpc.add(panel);
                textfields.add(panel);
                panel.repaint();
                panel.revalidate();
                
                if(numeroTextFields > 4) {
                    textfields.setPreferredSize(new Dimension(400, y));
                    y = y + 60;
                    scrollPane.getVerticalScrollBar().addAdjustmentListener(scroll);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(new java.awt.Color(153, 153, 153));   
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(new java.awt.Color(255, 255, 255));     
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255))); 
            }

            @Override
            public void mouseEntered(MouseEvent e) {}
                
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        
        setText("+");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setBounds(390, posY, 30, 30);
        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Cascadia Mono", 1, 20));
        setForeground(new java.awt.Color(255, 255, 255));
        setFocusPainted(false);
        setOpaque(false);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setVisible(true);
        setContentAreaFilled(false);
        addMouseListener(mouse);
        
    }                                                                      
    
}
