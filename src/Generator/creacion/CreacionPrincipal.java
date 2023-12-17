
package Generator.creacion;

import static Generator.Main.*;
import Generator.Reproductor;
import static Generator.VentanaPrincipal.config;
import static Generator.VentanaPrincipal.configArchivo;
import static Generator.VentanaPrincipal.creador;
import static Generator.VentanaPrincipal.escritor;
import static Generator.creacion.CustomButton.scroll;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;



public final class CreacionPrincipal extends javax.swing.JFrame {
    
    int layoutX, layoutY;
    static int numeroTextFields = 1;
    static int posYPanel = 0;
    static int posYBoton = 10;
    static int posBoton = 10;
    static CampoNombrePrincipal focus;
    static CustomTextPane focus2;
    
    private TeclasBinds imagen;
    
    public static Armas armasPane;
    public static Alias aliasPane;
    public static TeamBinds teamBindsPane;
    public static ComandosHL HLpane;
    public static ComandosAG AGpane;
    
    MensajeFinal mensajeFinal;
    
    CustomButton boton1;
    CustomTextPane campo1;
    CampoNombrePrincipal NombrePrincipal; 
    
    public static ArrayList<CustomTextPane> arrayNombresOpc = new ArrayList<CustomTextPane>();

    public CreacionPrincipal() {
        
        initComponents();
        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);     // Mostrar tooltips por más tiempo
        ToolTipManager.sharedInstance().setInitialDelay(0);                     // Mostrar tooltips inmediatamente
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/icono.png")));
        setLocationRelativeTo(null);
        setResizable(false);
        if(ContadorMusica % 2 == 0) {
            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Botones/volumen2.png")));jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Botones/volumen2.png")));
        }   else {
            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Botones/volumen1.png")));
        }
        
        boton1 = new CustomButton(posYBoton);
        campo1 = new CustomTextPane(posYPanel);
        NombrePrincipal = new CampoNombrePrincipal();
        PanelNombrePrincipal.add(NombrePrincipal); 
        
        if(VerificadorIdioma) {
            setTitle("Creating a config");
            jLabel1.setText("Creating a config");
            nombres.setText("Names");
            armas.setText("Weapons");
            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Fondo Nombres En.png")));
            jLabel11.setText("Write your main nick");
            jLabel11.setBounds(30, 20, 130, 40);
            jLabel8.setText("Change of nick quickly");
            jLabel8.setBounds(40, 150, 140, 40);
            jLabel8.setToolTipText("<html>Create a sequence of nicks that you can change quickly by pressing a button:<br>\nPressing the button for the first time will change your nick to the first one you added, <br>\nthen, by pressing it again, it will change to the next one. Once there are no more nicks left, <br>\nyou nick will be changed to the main one.\n</html>");
            jLabel9.setText("Colors in game");
            jLabel9.setBounds(550, 10, 110, 40);
            jLabel9.setToolTipText("In-game color's appereance");
            jLabel5.setText("Color your nick");
            jLabel5.setBounds(550, 260, 110, 40);
            jLabel5.setToolTipText("<html>Select a part of the text and choose one color.<br>\n You can combine as much colors as you want in just one nick.<html>");
            Aviso.setText("* the maximum number of characters is 27");
            AGcomandos.setText("AG settings");
            HLcomandos.setText("HL settings");
            jButton1.setText("Documentation");
            jButton2.setText("Bind keys");
        }   else {
            setTitle("Creando una config");
        }
        PanelNombrePrincipal.add(NombrePrincipal);
        MouseListener texto = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                focus = NombrePrincipal;
                focus2 = null;
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        KeyListener eventoTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               if(NombrePrincipal.getText().length() >= 27) {
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
        NombrePrincipal.addMouseListener(texto);
        NombrePrincipal.addKeyListener(eventoTeclado);
        
        textfields.add(campo1);
        arrayNombresOpc.add(campo1);
        MouseListener texto2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                focus = null;
                focus2 = campo1;
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
               if(campo1.getText().length() >= 27) {
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
        campo1.addMouseListener(texto2);
        campo1.addKeyListener(eventoTeclado2);
        
        textfields.add(boton1);
        
        eventosTeclado(jTextField2);
        
        //jscrollPane
        scrollPane.getVerticalScrollBar().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                scrollPane.getVerticalScrollBar().removeAdjustmentListener(scroll);
            }

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        labelNombre.setVisible(false);
        labelArmas.setVisible(true);
        labelAlias.setVisible(true);
        labelTeam.setVisible(true);
        labelComHL.setVisible(true);
        
        //Panel de nombres
        panelNombres.setVisible(true);
        
        //Panel de armas
        armasPane = new Armas();
        armasPane.setBounds(10, 80, 780, 470);
        armasPane.setVisible(false);
        creacionPrincipal.add(armasPane);
        
        //Panel de alias
        aliasPane = new Alias();
        aliasPane.setBounds(10, 80, 780, 470);
        aliasPane.setVisible(false);
        creacionPrincipal.add(aliasPane);
        
        //Panel de teamBinds
        teamBindsPane = new TeamBinds();
        teamBindsPane.setBounds(10, 80, 780, 470);
        teamBindsPane.setVisible(false);
        creacionPrincipal.add(teamBindsPane);
        
        //Panel de config HL
        HLpane = new ComandosHL();
        HLpane.setBounds(10, 80, 780, 470);
        HLpane.setVisible(false);
        creacionPrincipal.add(HLpane);
        
        //Panel de config AG
        AGpane = new ComandosAG();
        AGpane.setBounds(10, 80, 780, 470);
        AGpane.setVisible(false);
        creacionPrincipal.add(AGpane);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creacionPrincipal = new javax.swing.JPanel();
        panelNombres = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textfields = new javax.swing.JPanel();
        PanelNombrePrincipal = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        yellowColor = new javax.swing.JButton();
        whiteText = new javax.swing.JButton();
        redColor = new javax.swing.JButton();
        greenColor = new javax.swing.JButton();
        defaultColor = new javax.swing.JButton();
        blueText = new javax.swing.JButton();
        lightBlueColor = new javax.swing.JButton();
        purpleColor = new javax.swing.JButton();
        grayText = new javax.swing.JButton();
        Aviso = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        alias = new javax.swing.JButton();
        nombres = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        armas = new javax.swing.JButton();
        teamBinds = new javax.swing.JButton();
        AGcomandos = new javax.swing.JButton();
        HLcomandos = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelArmas = new javax.swing.JLabel();
        labelComAG = new javax.swing.JLabel();
        labelComHL = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelAlias = new javax.swing.JLabel();
        labelTeam = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        creacionPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        creacionPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96), 2));
        creacionPrincipal.setFocusable(false);
        creacionPrincipal.setLayout(null);

        panelNombres.setFocusable(false);
        panelNombres.setOpaque(false);
        panelNombres.setLayout(null);

        scrollPane.setBorder(null);

        textfields.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout textfieldsLayout = new javax.swing.GroupLayout(textfields);
        textfields.setLayout(textfieldsLayout);
        textfieldsLayout.setHorizontalGroup(
            textfieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        textfieldsLayout.setVerticalGroup(
            textfieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(textfields);

        panelNombres.add(scrollPane);
        scrollPane.setBounds(40, 190, 440, 230);

        PanelNombrePrincipal.setBackground(new java.awt.Color(0, 0, 0));
        PanelNombrePrincipal.setOpaque(false);
        PanelNombrePrincipal.setLayout(null);
        panelNombres.add(PanelNombrePrincipal);
        PanelNombrePrincipal.setBounds(40, 60, 440, 40);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Colores en el juego");
        jLabel9.setToolTipText("Apariencia de los colores dentro del juego.");
        jLabel9.setOpaque(true);
        panelNombres.add(jLabel9);
        jLabel9.setBounds(550, 10, 130, 40);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Añade color a tu nick");
        jLabel5.setToolTipText("<html>Selecciona una parte del texto y elije uno de los colores. <br>\nPuedes combinar varios colores en un solo nombre.</html>");
        jLabel5.setOpaque(true);
        panelNombres.add(jLabel5);
        jLabel5.setBounds(550, 260, 140, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Fondo Nombres.png"))); // NOI18N
        panelNombres.add(jLabel7);
        jLabel7.setBounds(550, 50, 190, 200);

        yellowColor.setBackground(new java.awt.Color(255, 255, 0));
        yellowColor.setBorder(null);
        yellowColor.setBorderPainted(false);
        yellowColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yellowColor.setFocusPainted(false);
        yellowColor.setFocusable(false);
        yellowColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                yellowColorMousePressed(evt);
            }
        });
        yellowColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowColorActionPerformed(evt);
            }
        });
        panelNombres.add(yellowColor);
        yellowColor.setBounds(700, 300, 40, 20);

        whiteText.setBorder(null);
        whiteText.setBorderPainted(false);
        whiteText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        whiteText.setFocusPainted(false);
        whiteText.setFocusable(false);
        whiteText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                whiteTextMousePressed(evt);
            }
        });
        whiteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteTextActionPerformed(evt);
            }
        });
        panelNombres.add(whiteText);
        whiteText.setBounds(550, 360, 40, 20);

        redColor.setBackground(new java.awt.Color(255, 0, 0));
        redColor.setBorder(null);
        redColor.setBorderPainted(false);
        redColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        redColor.setFocusPainted(false);
        redColor.setFocusable(false);
        redColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                redColorMousePressed(evt);
            }
        });
        redColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redColorActionPerformed(evt);
            }
        });
        panelNombres.add(redColor);
        redColor.setBounds(600, 300, 40, 20);

        greenColor.setBackground(new java.awt.Color(0, 255, 0));
        greenColor.setBorder(null);
        greenColor.setBorderPainted(false);
        greenColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        greenColor.setFocusPainted(false);
        greenColor.setFocusable(false);
        greenColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                greenColorMousePressed(evt);
            }
        });
        greenColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenColorActionPerformed(evt);
            }
        });
        panelNombres.add(greenColor);
        greenColor.setBounds(650, 300, 40, 20);

        defaultColor.setBackground(new java.awt.Color(255, 179, 0));
        defaultColor.setBorder(null);
        defaultColor.setBorderPainted(false);
        defaultColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        defaultColor.setFocusPainted(false);
        defaultColor.setFocusable(false);
        defaultColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                defaultColorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                defaultColorMousePressed(evt);
            }
        });
        defaultColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultColorActionPerformed(evt);
            }
        });
        panelNombres.add(defaultColor);
        defaultColor.setBounds(550, 300, 40, 20);

        blueText.setBackground(new java.awt.Color(0, 0, 255));
        blueText.setBorder(null);
        blueText.setBorderPainted(false);
        blueText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blueText.setFocusPainted(false);
        blueText.setFocusable(false);
        blueText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blueTextMousePressed(evt);
            }
        });
        blueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueTextActionPerformed(evt);
            }
        });
        panelNombres.add(blueText);
        blueText.setBounds(550, 330, 40, 20);

        lightBlueColor.setBackground(new java.awt.Color(0, 255, 255));
        lightBlueColor.setBorder(null);
        lightBlueColor.setBorderPainted(false);
        lightBlueColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lightBlueColor.setFocusPainted(false);
        lightBlueColor.setFocusable(false);
        lightBlueColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lightBlueColorMousePressed(evt);
            }
        });
        lightBlueColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightBlueColorActionPerformed(evt);
            }
        });
        panelNombres.add(lightBlueColor);
        lightBlueColor.setBounds(600, 330, 40, 20);

        purpleColor.setBackground(new java.awt.Color(255, 0, 255));
        purpleColor.setBorder(null);
        purpleColor.setBorderPainted(false);
        purpleColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purpleColor.setFocusPainted(false);
        purpleColor.setFocusable(false);
        purpleColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purpleColorMousePressed(evt);
            }
        });
        purpleColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleColorActionPerformed(evt);
            }
        });
        panelNombres.add(purpleColor);
        purpleColor.setBounds(650, 330, 40, 20);

        grayText.setBackground(new java.awt.Color(137, 137, 137));
        grayText.setBorder(null);
        grayText.setBorderPainted(false);
        grayText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grayText.setFocusPainted(false);
        grayText.setFocusable(false);
        grayText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grayTextMousePressed(evt);
            }
        });
        grayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayTextActionPerformed(evt);
            }
        });
        panelNombres.add(grayText);
        grayText.setBounds(700, 330, 40, 20);

        Aviso.setForeground(new java.awt.Color(204, 204, 204));
        Aviso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Aviso.setText("* El número máximo de caracteres es 27");
        Aviso.setVisible(false);
        panelNombres.add(Aviso);
        Aviso.setBounds(40, 130, 280, 19);

        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jLabel12.setFocusable(false);
        panelNombres.add(jLabel12);
        jLabel12.setBounds(540, 30, 210, 230);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cambia de nick rápidamente");
        jLabel8.setToolTipText("<html>Crea una secuencia de nicks que puedes cambiar rápidamente al presionar un botón:<br>\nAl presionar una vez el botón elegido te cambiarás de nombre al primer nick que añadiste, <br>\nluego, al volverlo a presionar, te cambiarás al segundo y así sucesivamente. Una vez acabados los nicks, <br>\nvolverás al nick principal.\n</html>");
        jLabel8.setOpaque(true);
        panelNombres.add(jLabel8);
        jLabel8.setBounds(30, 150, 180, 40);

        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setFocusable(false);
        panelNombres.add(jLabel10);
        jLabel10.setBounds(20, 170, 480, 270);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Escribe tu nick principal");
        jLabel11.setOpaque(true);
        panelNombres.add(jLabel11);
        jLabel11.setBounds(30, 20, 160, 40);

        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jLabel13.setFocusable(false);
        panelNombres.add(jLabel13);
        jLabel13.setBounds(20, 40, 480, 80);

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jLabel6.setFocusable(false);
        panelNombres.add(jLabel6);
        jLabel6.setBounds(540, 280, 210, 110);

        jTextField2.setBackground(new java.awt.Color(153, 153, 153));
        jTextField2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(null);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        panelNombres.add(jTextField2);
        jTextField2.setBounds(610, 410, 120, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bind");
        panelNombres.add(jLabel2);
        jLabel2.setBounds(550, 410, 50, 30);

        creacionPrincipal.add(panelNombres);
        panelNombres.setBounds(10, 80, 780, 470);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setFocusable(false);
        jPanel2.setOpaque(false);
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Creando una config");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 0, 168, 36);

        creacionPrincipal.add(jPanel2);
        jPanel2.setBounds(1, 1, 738, 30);

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setFont(new java.awt.Font("Cascadia Mono", 1, 20)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("x");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setFocusPainted(false);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton12MouseReleased(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        creacionPrincipal.add(jButton12);
        jButton12.setBounds(769, 1, 30, 30);

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.setFont(new java.awt.Font("Cascadia Mono", 1, 20)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("_");
        jButton13.setBorder(null);
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setFocusPainted(false);
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton13MouseReleased(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        creacionPrincipal.add(jButton13);
        jButton13.setBounds(740, 0, 30, 30);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Botones/volumen1.png"))); // NOI18N
        jButton3.setToolTipText("Encender/apagar música\n");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        creacionPrincipal.add(jButton3);
        jButton3.setBounds(760, 560, 30, 30);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 161, 96));
        jLabel3.setText("__________________________________________________________________________________________________________________________");
        creacionPrincipal.add(jLabel3);
        jLabel3.setBounds(10, 20, 780, 19);

        alias.setBackground(new java.awt.Color(0, 0, 0));
        alias.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        alias.setForeground(new java.awt.Color(255, 255, 255));
        alias.setText("Scripts");
        alias.setBorder(null);
        alias.setBorderPainted(false);
        alias.setContentAreaFilled(false);
        alias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alias.setFocusPainted(false);
        alias.setOpaque(true);
        alias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aliasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aliasMouseReleased(evt);
            }
        });
        alias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aliasActionPerformed(evt);
            }
        });
        creacionPrincipal.add(alias);
        alias.setBounds(270, 39, 120, 32);

        nombres.setBackground(new java.awt.Color(0, 0, 0));
        nombres.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        nombres.setForeground(new java.awt.Color(255, 255, 255));
        nombres.setText("Nombres");
        nombres.setBorder(null);
        nombres.setBorderPainted(false);
        nombres.setContentAreaFilled(false);
        nombres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nombres.setFocusPainted(false);
        nombres.setOpaque(true);
        nombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nombresMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nombresMouseReleased(evt);
            }
        });
        nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombresActionPerformed(evt);
            }
        });
        creacionPrincipal.add(nombres);
        nombres.setBounds(10, 39, 120, 32);

        crear.setBackground(new java.awt.Color(0, 0, 0));
        crear.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        crear.setForeground(new java.awt.Color(255, 102, 0));
        crear.setText("Crear");
        crear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 2));
        crear.setContentAreaFilled(false);
        crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crear.setFocusPainted(false);
        crear.setOpaque(true);
        crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                crearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                crearMouseReleased(evt);
            }
        });
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        creacionPrincipal.add(crear);
        crear.setBounds(647, 560, 100, 30);

        armas.setBackground(new java.awt.Color(0, 0, 0));
        armas.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        armas.setForeground(new java.awt.Color(255, 255, 255));
        armas.setText("Armas");
        armas.setBorder(null);
        armas.setBorderPainted(false);
        armas.setContentAreaFilled(false);
        armas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        armas.setFocusPainted(false);
        armas.setOpaque(true);
        armas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                armasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                armasMouseReleased(evt);
            }
        });
        armas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armasActionPerformed(evt);
            }
        });
        creacionPrincipal.add(armas);
        armas.setBounds(140, 39, 120, 32);

        teamBinds.setBackground(new java.awt.Color(0, 0, 0));
        teamBinds.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        teamBinds.setForeground(new java.awt.Color(255, 255, 255));
        teamBinds.setText("Team Binds");
        teamBinds.setBorder(null);
        teamBinds.setBorderPainted(false);
        teamBinds.setContentAreaFilled(false);
        teamBinds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teamBinds.setFocusPainted(false);
        teamBinds.setOpaque(true);
        teamBinds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                teamBindsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                teamBindsMouseReleased(evt);
            }
        });
        teamBinds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamBindsActionPerformed(evt);
            }
        });
        creacionPrincipal.add(teamBinds);
        teamBinds.setBounds(400, 39, 120, 32);

        AGcomandos.setBackground(new java.awt.Color(0, 0, 0));
        AGcomandos.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        AGcomandos.setForeground(new java.awt.Color(255, 255, 255));
        AGcomandos.setText("Config. AG");
        AGcomandos.setBorder(null);
        AGcomandos.setBorderPainted(false);
        AGcomandos.setContentAreaFilled(false);
        AGcomandos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AGcomandos.setFocusPainted(false);
        AGcomandos.setOpaque(true);
        AGcomandos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AGcomandosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AGcomandosMouseReleased(evt);
            }
        });
        AGcomandos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGcomandosActionPerformed(evt);
            }
        });
        creacionPrincipal.add(AGcomandos);
        AGcomandos.setBounds(660, 39, 120, 32);

        HLcomandos.setBackground(new java.awt.Color(0, 0, 0));
        HLcomandos.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        HLcomandos.setForeground(new java.awt.Color(255, 255, 255));
        HLcomandos.setText("Config. HL");
        HLcomandos.setBorder(null);
        HLcomandos.setBorderPainted(false);
        HLcomandos.setContentAreaFilled(false);
        HLcomandos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HLcomandos.setFocusPainted(false);
        HLcomandos.setOpaque(true);
        HLcomandos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HLcomandosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HLcomandosMouseReleased(evt);
            }
        });
        HLcomandos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HLcomandosActionPerformed(evt);
            }
        });
        creacionPrincipal.add(HLcomandos);
        HLcomandos.setBounds(530, 39, 120, 32);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 31)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 161, 96));
        jLabel14.setText("|");
        creacionPrincipal.add(jLabel14);
        jLabel14.setBounds(130, 30, 10, 40);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 31)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 161, 96));
        jLabel15.setText("|");
        creacionPrincipal.add(jLabel15);
        jLabel15.setBounds(260, 30, 10, 40);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 31)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 161, 96));
        jLabel16.setText("|");
        creacionPrincipal.add(jLabel16);
        jLabel16.setBounds(650, 30, 10, 40);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 31)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 161, 96));
        jLabel4.setText("|");
        creacionPrincipal.add(jLabel4);
        jLabel4.setBounds(390, 30, 10, 40);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 31)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 161, 96));
        jLabel18.setText("|");
        creacionPrincipal.add(jLabel18);
        jLabel18.setBounds(520, 30, 10, 40);

        labelArmas.setBackground(new java.awt.Color(0, 0, 0));
        labelArmas.setForeground(new java.awt.Color(255, 161, 96));
        labelArmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/barra.png"))); // NOI18N
        labelArmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelArmasMousePressed(evt);
            }
        });
        creacionPrincipal.add(labelArmas);
        labelArmas.setBounds(131, 60, 135, 16);

        labelComAG.setBackground(new java.awt.Color(0, 0, 0));
        labelComAG.setForeground(new java.awt.Color(255, 161, 96));
        labelComAG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/barra.png"))); // NOI18N
        labelComAG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelComAGMousePressed(evt);
            }
        });
        creacionPrincipal.add(labelComAG);
        labelComAG.setBounds(652, 60, 135, 16);

        labelComHL.setBackground(new java.awt.Color(0, 0, 0));
        labelComHL.setForeground(new java.awt.Color(255, 161, 96));
        labelComHL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/barra.png"))); // NOI18N
        labelComHL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelComHLMousePressed(evt);
            }
        });
        creacionPrincipal.add(labelComHL);
        labelComHL.setBounds(524, 60, 130, 16);

        labelNombre.setBackground(new java.awt.Color(0, 0, 0));
        labelNombre.setForeground(new java.awt.Color(255, 161, 96));
        labelNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/barra.png"))); // NOI18N
        labelNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelNombreMousePressed(evt);
            }
        });
        creacionPrincipal.add(labelNombre);
        labelNombre.setBounds(10, 60, 125, 16);

        labelAlias.setBackground(new java.awt.Color(0, 0, 0));
        labelAlias.setForeground(new java.awt.Color(255, 161, 96));
        labelAlias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/barra.png"))); // NOI18N
        labelAlias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelAliasMousePressed(evt);
            }
        });
        creacionPrincipal.add(labelAlias);
        labelAlias.setBounds(264, 60, 131, 16);

        labelTeam.setBackground(new java.awt.Color(0, 0, 0));
        labelTeam.setForeground(new java.awt.Color(255, 161, 96));
        labelTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/barra.png"))); // NOI18N
        labelTeam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelTeamMousePressed(evt);
            }
        });
        creacionPrincipal.add(labelTeam);
        labelTeam.setBounds(395, 60, 130, 16);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Documentación");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        creacionPrincipal.add(jButton1);
        jButton1.setBounds(130, 560, 110, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Teclas de binds");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        creacionPrincipal.add(jButton2);
        jButton2.setBounds(10, 560, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(creacionPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(creacionPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Botón de la música   (Sin usar)
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // Botón de música
        ContadorMusica++;
        if(ContadorMusica % 2 == 0) {
            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Botones/volumen2.png")));
            musica.parar();
        }   else {
            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Botones/volumen1.png")));
            musica = new Reproductor(true);
            musica.start();
        }
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // Botóm minimizar
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // Botón cerrar
        this.dispose();
        try {
            config.close();
            escritor.close();
        } catch (IOException ex) {}
        configArchivo.delete();
        System.exit(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        layoutX = evt.getX();                                                           //Barra de desplazamiento
        layoutY = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(evt.getXOnScreen() - layoutX, evt.getYOnScreen() - layoutY);   //Barra de desplazamiento
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MousePressed
        jButton12.setForeground(new java.awt.Color(153, 153, 153));     //Botón salir 
    }//GEN-LAST:event_jButton12MousePressed

    private void jButton12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseReleased
        jButton12.setForeground(new java.awt.Color(255, 255, 255));     //Botón salir
    }//GEN-LAST:event_jButton12MouseReleased

    private void jButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MousePressed
        jButton13.setForeground(new java.awt.Color(153, 153, 153));    //Botón minimizar
    }//GEN-LAST:event_jButton13MousePressed

    private void jButton13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseReleased
        jButton13.setForeground(new java.awt.Color(255, 255, 255));     //Botón minimizar
    }//GEN-LAST:event_jButton13MouseReleased

    private void nombresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombresMousePressed
        nombres.setBackground(new java.awt.Color(255, 161, 96));       //Botón de "nombres"
        nombres.setForeground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_nombresMousePressed

    private void nombresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombresMouseReleased
        nombres.setBackground(new java.awt.Color(0, 0, 0));             //Botón de "nombres"
        nombres.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setVisible(false);
        labelArmas.setVisible(true);
        labelAlias.setVisible(true);
        labelTeam.setVisible(true);
        labelComHL.setVisible(true);
        labelComAG.setVisible(true);
        
        panelNombres.setVisible(true);
        armasPane.setVisible(false);
        aliasPane.setVisible(false);
        teamBindsPane.setVisible(false);
        HLpane.setVisible(false);
        AGpane.setVisible(false);
    }//GEN-LAST:event_nombresMouseReleased

    private void nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombresActionPerformed

    }//GEN-LAST:event_nombresActionPerformed

    private void whiteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteTextActionPerformed
        
    }//GEN-LAST:event_whiteTextActionPerformed

    private void redColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redColorActionPerformed
        
    }//GEN-LAST:event_redColorActionPerformed

    private void defaultColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultColorActionPerformed

    }//GEN-LAST:event_defaultColorActionPerformed

    private void greenColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenColorActionPerformed
        
    }//GEN-LAST:event_greenColorActionPerformed

    private void yellowColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowColorActionPerformed
        
    }//GEN-LAST:event_yellowColorActionPerformed

    private void blueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueTextActionPerformed
        
    }//GEN-LAST:event_blueTextActionPerformed

    private void lightBlueColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightBlueColorActionPerformed
        
    }//GEN-LAST:event_lightBlueColorActionPerformed

    private void purpleColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleColorActionPerformed
        
    }//GEN-LAST:event_purpleColorActionPerformed

    private void grayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayTextActionPerformed
        
    }//GEN-LAST:event_grayTextActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        
    }//GEN-LAST:event_crearActionPerformed

    private void crearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMousePressed
        crear.setBackground(new java.awt.Color(50,50,50));
        crear.setForeground(new java.awt.Color(255,161,96));
        crear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,161,96), 2));
    }//GEN-LAST:event_crearMousePressed

    private void crearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMouseReleased
        crear.setBackground(new java.awt.Color(0, 0, 0));
        crear.setForeground(new java.awt.Color(255, 102, 0));
        crear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 2));
        
        
    }//GEN-LAST:event_crearMouseReleased

    private void aliasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aliasMousePressed
        alias.setBackground(new java.awt.Color(255, 161, 96));       //Botón de "binds"
        alias.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_aliasMousePressed

    private void aliasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aliasMouseReleased
        alias.setBackground(new java.awt.Color(0, 0, 0));             //Botón de "binds"
        alias.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setVisible(true);
        labelArmas.setVisible(true);
        labelAlias.setVisible(false);
        labelTeam.setVisible(true);
        labelComHL.setVisible(true);
        labelComAG.setVisible(true);
        
        panelNombres.setVisible(false);
        armasPane.setVisible(false);
        aliasPane.setVisible(true);
        teamBindsPane.setVisible(false);
        HLpane.setVisible(false);
        AGpane.setVisible(false);
    }//GEN-LAST:event_aliasMouseReleased

    private void aliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aliasActionPerformed
        
    }//GEN-LAST:event_aliasActionPerformed

    private void labelNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNombreMousePressed
        
    }//GEN-LAST:event_labelNombreMousePressed

    private void armasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armasMousePressed
        armas.setBackground(new java.awt.Color(255, 161, 96));       //Botón de "binds"
        armas.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_armasMousePressed

    private void armasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armasMouseReleased
        armas.setBackground(new java.awt.Color(0, 0, 0));             //Botón de "binds"
        armas.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setVisible(true);
        labelArmas.setVisible(false);
        labelAlias.setVisible(true);
        labelTeam.setVisible(true);
        labelComHL.setVisible(true);
        labelComAG.setVisible(true);
        
        panelNombres.setVisible(false);
        armasPane.setVisible(true);
        aliasPane.setVisible(false);
        teamBindsPane.setVisible(false);
        HLpane.setVisible(false);
        AGpane.setVisible(false);
    }//GEN-LAST:event_armasMouseReleased

    private void armasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_armasActionPerformed

    private void teamBindsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamBindsMousePressed
        teamBinds.setBackground(new java.awt.Color(255, 161, 96));       //Botón de "binds"
        teamBinds.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_teamBindsMousePressed

    private void teamBindsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamBindsMouseReleased
        teamBinds.setBackground(new java.awt.Color(0, 0, 0));             //Botón de "binds"
        teamBinds.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setVisible(true);
        labelArmas.setVisible(true);
        labelAlias.setVisible(true);
        labelTeam.setVisible(false);
        labelComHL.setVisible(true);
        labelComAG.setVisible(true);
        
        panelNombres.setVisible(false);
        armasPane.setVisible(false);
        aliasPane.setVisible(false);
        teamBindsPane.setVisible(true);
        HLpane.setVisible(false);
        AGpane.setVisible(false);
    }//GEN-LAST:event_teamBindsMouseReleased

    private void teamBindsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamBindsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamBindsActionPerformed

    private void AGcomandosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AGcomandosMousePressed
        AGcomandos.setBackground(new java.awt.Color(255, 161, 96));       //Botón de "binds"
        AGcomandos.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_AGcomandosMousePressed

    private void AGcomandosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AGcomandosMouseReleased
        AGcomandos.setBackground(new java.awt.Color(0, 0, 0));             //Botón de "binds"
        AGcomandos.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setVisible(true);
        labelArmas.setVisible(true);
        labelAlias.setVisible(true);
        labelTeam.setVisible(true);
        labelComHL.setVisible(true);
        labelComAG.setVisible(false);
        
        panelNombres.setVisible(false);
        armasPane.setVisible(false);
        aliasPane.setVisible(false);
        teamBindsPane.setVisible(false);
        HLpane.setVisible(false);
        AGpane.setVisible(true);
    }//GEN-LAST:event_AGcomandosMouseReleased

    private void AGcomandosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGcomandosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AGcomandosActionPerformed

    private void labelArmasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelArmasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelArmasMousePressed

    private void labelComHLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelComHLMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelComHLMousePressed

    private void labelAliasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAliasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelAliasMousePressed

    private void labelTeamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTeamMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelTeamMousePressed

    private void HLcomandosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HLcomandosMousePressed
        HLcomandos.setBackground(new java.awt.Color(255, 161, 96));       //Botón de "binds"
        HLcomandos.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_HLcomandosMousePressed

    private void HLcomandosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HLcomandosMouseReleased
        HLcomandos.setBackground(new java.awt.Color(0, 0, 0));             //Botón de "binds"
        HLcomandos.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setVisible(true);
        labelArmas.setVisible(true);
        labelAlias.setVisible(true);
        labelTeam.setVisible(true);
        labelComHL.setVisible(false);
        labelComAG.setVisible(true);
        
        panelNombres.setVisible(false);
        armasPane.setVisible(false);
        aliasPane.setVisible(false);
        teamBindsPane.setVisible(false);
        HLpane.setVisible(true);
        AGpane.setVisible(false);
    }//GEN-LAST:event_HLcomandosMouseReleased

    private void HLcomandosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HLcomandosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HLcomandosActionPerformed

    private void labelComAGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelComAGMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelComAGMousePressed

    private void defaultColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_defaultColorMouseClicked
        
    }//GEN-LAST:event_defaultColorMouseClicked

    private void defaultColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_defaultColorMousePressed
        TextEditor.cambiarColor(new java.awt.Color(255, 179, 0));
    }//GEN-LAST:event_defaultColorMousePressed

    private void redColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redColorMousePressed
        TextEditor.cambiarColor(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_redColorMousePressed

    private void greenColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenColorMousePressed
        TextEditor.cambiarColor(new java.awt.Color(0,255,0));
    }//GEN-LAST:event_greenColorMousePressed

    private void yellowColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yellowColorMousePressed
        TextEditor.cambiarColor(new java.awt.Color(255,255,0));
    }//GEN-LAST:event_yellowColorMousePressed

    private void blueTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blueTextMousePressed
        TextEditor.cambiarColor(new java.awt.Color(0,0,255));
    }//GEN-LAST:event_blueTextMousePressed

    private void lightBlueColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lightBlueColorMousePressed
        TextEditor.cambiarColor(new java.awt.Color(0,255,255));
    }//GEN-LAST:event_lightBlueColorMousePressed

    private void purpleColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purpleColorMousePressed
        TextEditor.cambiarColor(new java.awt.Color(255,0,255));
    }//GEN-LAST:event_purpleColorMousePressed

    private void grayTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grayTextMousePressed
        TextEditor.cambiarColor(new java.awt.Color(137,137,137));
    }//GEN-LAST:event_grayTextMousePressed

    private void whiteTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteTextMousePressed
        TextEditor.cambiarColor(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_whiteTextMousePressed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked

    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased

        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        File documentacion;
        
        if(VerificadorIdioma) {
            try {
                try (FileWriter comandos = new FileWriter("Documentation.txt")) {
                    comandos.write("//INFO. ABOUT SOME HALF LIFE COMMANDS\n" +
                            "//***********************************\n\n"
                            + "+alt1\n"
                            + "+attack // fire\n"
                            + "+attack2 // secondary fire - *see special\n"
                            + "+back // move backwards\n"
                            + "+break\n"
                            + "+camdistance // moves chase cam perspective away from player - *works only if thirdperson is activated\n"
                            + "+camin // moves chase cam forward - *works only if thirdperson is activated\n"
                            + "+cammousemove // moves chase with mouse - *works only if thirdperson is activated\n"
                            + "+camout // moves chase cam backward - *works only if thirdperson is activated\n"
                            + "+campitchdown // decreases chase cam pitch to look down - *works only if thirdperson is activated\n"
                            + "+campitchup // increases chase cam pitch to look up - *works only if thirdperson is activated\n"
                            + "+camyawleft // tilts chase cam left - *works only if thirdperson is activated\n"
                            + "+camyawright // tilts chase cam right - *works only if thirdperson is activated\n"
                            + "+commandmenu\n"
                            + "+duck // crouches\n"
                            + "+forward // moves forward\n"
                            + "+graph\n"
                            + "+jlook // enables joystick to look around\n"
                            + "+jump // jumps\n"
                            + "+klook // enables the keyboard to look around\n"
                            + "+left // strafes left\n"
                            + "+lookdown // looks down\n"
                            + "+lookup // looks up\n"
                            + "+mlook // enables mouse to look around\n"
                            + "+movedown // moves player down - *climbing down a ladder, swimming down\n"
                            + "+moveleft // strafes left\n"
                            + "+moveright // strafes right\n"
                            + "+moveup // moves player up - *climbing up a ladder, swimming up\n"
                            + "+reload // reloads current weapon\n"
                            + "+right // strafes right\n"
                            + "+score\n"
                            + "+showscores // shows player scores and pings\n"
                            + "+speed // forces player to walk if 'always run' is enabled, and forces player to run if 'always run' is disabled\n"
                            + "+strafe // strafe modifier - while this is held down, use direction keys to strafe in different directions\n"
                            + "+use // uses an item- such as a button, machine gun, etc.\n" +
                            "+voicerecord\n"
                            + "-alt1\n" +
                            "-attack\n" +
                            "-attack2\n" +
                            "-back\n" +
                            "-break\n" +
                            "-camdistance\n" +
                            "-camin\n" +
                            "-cammousemove\n" +
                            "-camout\n" +
                            "-campitchdown\n" +
                            "-campitchup\n" +
                            "-camyawleft\n" +
                            "-camyawright\n" +
                            "-commandmenu\n" +
                            "-duck\n" +
                            "-forward\n" +
                            "-graph\n" +
                            "-jlook\n" +
                            "-jump\n" +
                            "-klook\n" +
                            "-left\n" +
                            "-lookdown\n" +
                            "-lookup\n" +
                            "-mlook\n" +
                            "-movedown\n" +
                            "-moveleft\n" +
                            "-moveright\n" +
                            "-moveup\n" +
                            "-reload\n" +
                            "-right\n" +
                            "-score\n" +
                            "-showscores\n" +
                            "-speed\n" +
                            "-strafe\n" +
                            "-use\n" +
                            "-voicerecord\n" +
                            "addip // adds an ip address to the filterban list - * use 0 minutes to make the addition permanent\n" +
                            "alias // binds commands together in an alias to perform mutiple tasks at the hit of one button\n" +
                            "ambient_fade \"100\" // sets the distance at which ambient sounds fade away\n" +
                            "ambient_level \"0.300\" // sets the sound level for ambient sounds\n" +
                            "appenddemo // records a demo and appends it to the demo file in existence at Half-Life/Valve/demo.dem\n" +
                            "ati_npatch \"1\"\n" +
                            "ati_subdiv \"2\"\n" +
                            "autosave // enables autosave feature\n" +
                            "banid // bans AND kicks a player from a server using their uniqueid - get this unique id from the \"users\" command - 0 minutes is a permanent ban - **Version 4.0.1.3+ only\n" +
                            "bannedcfgfile \"0\"\n" +
                            "bgmbuffer \"4096\" // sets the CD audio buffer size\n" +
                            "bgmvolume \"1\" // toggles CD audio on/off- * 1 is 'on', 0 is 'off'\n" +
                            "bind // combines a <key> with a command or alias\n" +
                            "bitmapfonts \"1\"\n" +
                            "bottomcolor \"6\" // sets the bottom color of the player model\n" +
                            "brightness \"1\" // enables glare reduction - *the higher the value, the brighter it gets\n" +
                            "cam_command \"0\" // toggles chase cam commands on/off - * 1 is 'on', 0 is 'off'\n" +
                            "cam_contain \"0\" // toggles chase cam auto-contain in current room on/off - * 1 is 'on', 0 is 'off'\n" +
                            "cam_idealdist \"64\" // sets the preferred distance from the player model to the chase cam - *works only if thirdperson is activated\n" +
                            "cam_idealpitch \"0\" // sets the preferred pitch for the chase cam - *works only if thirdperson is activated\n" +
                            "cam_idealyaw \"90\" // sets the preferred yaw for the chase cam - *works only if thirdperson is activated\n" +
                            "cam_snapto \"0\" // sets the preferred snap interval for the chase cam - *works only if thirdperson is activated\n" +
                            "cancelselect // cancels selection\n" +
                            "career\n" +
                            "cd // controls CD audio - * i.e., 'cd stop' stops the cd play, 'cd loop X' plays track X using tracks 1-16\n" +
                            "centerview // centers the players view\n" +
                            "changelevel // changes the map and maintains client connections\n" +
                            "changelevel2 // continues the current game on a new map\n" +
                            "chase_active \"0\"\n" +
                            "chase_back \"100\" // sets the preferred chase cam distance from the player when backing up\n" +
                            "chase_right \"0\" // sets the preferred offset to the side for the chase cam\n" +
                            "chase_up \"16\" // sets the preferred offset up for the chase cam\n" +
                            "clear // clears the console screen\n" +
                            "clientport \"27005\" // sets the port that the client will use to connect to a server\n" +
                            "clockwindow \"0.500\"\n" +
                            "cl_allowdownload \"1\" // toggles download of maps, models and decals when joining a server - * 1 is 'on', 0 is 'off'\n" +
                            "cl_allowupload \"1\" // toggles upload of maps, models and decals when joining a server - * 1 is 'on', 0 is 'off'\n" +
                            "cl_anglespeedkey \"0.670\" // sets the speed that the direction keys change the view angle\n" +
                            "cl_backspeed \"400\" // sets the backup speed of a player - number can only go as fast as a particular server allows\n" +
                            "cl_bob \"0.010\" // sets the amount that the view bobs while the player is running\n" +
                            "cl_bobcycle \"0.800\" // sets how frequently the view of a player bobs while running\n" +
                            "cl_bobup \"0.500\" // sets the amount that the view of a player bobs while running\n" +
                            "cl_chasedist \"112\"\n" +
                            "cl_clockreset \"0.100\"\n" +
                            "cl_cmdbackup \"2\"\n" +
                            "cl_cmdrate \"30\"\n" +
                            "cl_dlmax \"128\"\n" +
                            "cl_download_ingame \"1\" // toggles downloads of models and decals during a game - * 1 is 'on', 0 is 'off'\n" +
                            "cl_fixtimerate \"7.500\"\n" +
                            "cl_forwardspeed \"400\" // sets the forward speed of a player - *can only go as fast as the server allows\n" +
                            "cl_gaitestimation \"1\" // enables estimated player stepping motion\n" +
                            "cl_gg \"0\" // toggles game gauge mode - * 1 is 'on', 0 is 'off'\n" +
                            "cl_himodels \"0\" // toggles higer quality player models - * 1 is 'on', 0 is 'off'\n" +
                            "cl_idealpitchscale \"0.800\"\n" +
                            "cl_lc \"1\"\n" +
                            "cl_logocolor \"0\"\n" +
                            "cl_logofile \"0\"\n" +
                            "cl_lw \"1\"\n" +
                            "cl_messages // shows server messages\n" +
                            "cl_movespeedkey \"0.300\" // sets movement speed for keyboard use\n" +
                            "cl_needinstanced \"0\"\n" +
                            "cl_nosmooth \"0\"\n" +
                            "cl_pitchdown \"89\" // sets the maximum angle to look down - *default is 89\n" +
                            "cl_pitchspeed \"225\" // sets the speed at which the pitch changes\n" +
                            "cl_pitchup \"89\" // sets the maximum angle to look up - *default is 89\n" +
                            "cl_pmanstats \"0\"\n" +
                            "cl_rate\n" +
                            "cl_resend \"6\" // sets the resend count\n" +
                            "cl_showerror \"0\"\n" +
                            "cl_showevents \"0\"\n" +
                            "cl_showfps \"0\"\n" +
                            "cl_showmessages \"0\"\n" +
                            "cl_shownet \"0\" // toggles the display of network packet numbers - * 1 is 'on', 0 is 'off'\n" +
                            "cl_sidespeed \"400\" // sets the strafing speed of a player\n" +
                            "cl_slist \"10\" // sets the number of servers in the serverlist\n" +
                            "cl_smoothtime \"0.100\"\n" +
                            "cl_solid_players \"1\" // toggles solid player models - * 1 is 'on', 0 is 'off'\n" +
                            "cl_timeout \"60\" // sets the inactivity time brfore a client times out\n" +
                            "cl_updaterate \"20\"\n" +
                            "cl_upspeed \"320\" // sets the speed of a player when he climbs up\n" +
                            "cl_vsmoothing \"0.050\"\n" +
                            "cl_waterdist \"4\" // sets the underwater distance\n" +
                            "cl_weaponlistfix \"0\"\n" +
                            "cl_yawspeed \"210\" // sets the turning speed - * only will go as fast as a server allows\n" +
                            "cmd // can use this in conjunction with a command\n" +
                            "cmdlist // lists all of the console commands - * if you type 'cmdlist a', it will only list those commands that begin with the letter a, and so on - also, 'cmdlist log logfile writes the list to C:logfile\n" +
                            "commentator\n" +
                            "com_filewarning \"0\"\n" +
                            "condebug\n" +
                            "condump\n" +
                            "connect // connects to a server with the used ip address\n" +
                            "console \"1\"\n" +
                            "contimes // shows n overlay lines - * n = 4 to 64\n" +
                            "con_color \"255\"\n" +
                            "con_fastmode \"1\"\n" +
                            "con_notifytime \"4\" // sets client notification time\n" +
                            "coop \"0\" // toggles cooperatice play mode - * 1 is 'on', 0 is 'off'\n" +
                            "crosshair \"1\" // toggles the crosshair on/off - * 1 is 'on', 0 is 'off'\n" +
                            "cvarlist // lists all the console variables in the console - * 'cvar log filename' will write this list to the file C:filename\n" +
                            "c_maxdistance \"200\" // sets the maximum distance of the chase cam\n" +
                            "c_maxpitch \"90\" // sets the maximum pitch of the chase cam\n" +
                            "c_maxyaw \"135\" // sets the maximum yaw of the chase cam\n" +
                            "c_mindistance \"30\"\n" +
                            "c_minpitch \"0\" // sets the minimum pitch of the chase cam\n" +
                            "c_minyaw \"-135\" // sets the minimum yaw of the chase cam\n" +
                            "deathmatch \"0\" // toggles deathmatch mode - * 1 is 'on', 0 is 'off'\n" +
                            "default_fov \"90\" // sets the default field of view in degrees - * smaller number is a smaller angle of view, while a larger number is a larger field of view\n" +
                            "delta_clear\n" +
                            "delta_stats\n" +
                            "demos // runs a loop of demos set with startdemos\n" +
                            "dem_forcehltv\n" +
                            "dem_jump\n" +
                            "dem_pause\n" +
                            "dem_save\n" +
                            "dem_speed\n" +
                            "dem_start\n" +
                            "developer \"0\" // toggles on/off special developer debug console messages - * 1 is 'on', 0 is 'off'\n" +
                            "dev_overview \"0\"\n" +
                            "direct \"0.900\"\n" +
                            "disconnect // disconnects a player from a server\n" +
                            "dlfile\n" +
                            "dropclient // disconnects a client from a server\n" +
                            "d_spriteskip \"0\"\n" +
                            "echo // echos text to the console - * useful for letting a player know that a script or .cfg file was loaded successfully\n" +
                            "edgefriction \"2\" // sets the amount of friction between players and objects\n" +
                            "endmovie // ends a currently ongoing movie\n" +
                            "entities // lists currently loaded entities\n" +
                            "envmap // creates the 6 .bmp images for sky boxes from the player's current position\n" +
                            "escape // acts as <ESCAPE> key by hiding the console and cancelling selections\n" +
                            "exec // executes a script of .cfg file\n" +
                            "exit // closes a game or dedicated server program to windows without confirmation\n" +
                            "ex_interp \"0.100\"\n" +
                            "fakelag \"0\" // simulates lag - * the higher the number, the more simulated lag\n" +
                            "fakeloss \"0\" // simulates packet loss - * the higher the value, the more simulated packet loss\n" +
                            "firstperson // enables first person viewing of the game\n" +
                            "flush // flushes the memory and reloads the map\n" +
                            "fly\n" +
                            "ForceCloseComman\n" +
                            "force_centerview // forces the player's view to look straight ahead\n" +
                            "fps_max \"72\"\n" +
                            "fps_modem \"0\" // sets the maximum framerate in an internet game\n" +
                            "fs_lazy_precache \"0\"\n" +
                            "fs_perf_warnings \"0\"\n" +
                            "fs_precache_timings \"0\"\n" +
                            "fs_startup_timings \"0\"\n" +
                            "fullinfo // displays user information\n" +
                            "fullserverinfo // displays server information\n" +
                            "fullupdate\n" +
                            "gamedir\n" +
                            "gamma \"2.500\" // sets the gamma level\n" +
                            "gg // runs the game gauge benchmark using <demoname> - * 'cl_gg' must be set to 1\n" +
                            "gl_affinemodels \"0\"\n" +
                            "gl_alphamin \"0.250\" // sets the minimum alpha blending level\n" +
                            "gl_clear \"0\" // toggles visual quality - * cracks between textures show when set to 1\n" +
                            "gl_cull \"1\" // toggles rendering of visible objects only - * 1 is 'on', 0 is 'off', and 0 will lower fps\n" +
                            "gl_d3dflip \"0\" // toggles reversed rendering order for D3D\n" +
                            "gl_dither \"1\" // toggles dithering - * 1 is 'on', 0 is 'off'\n" +
                            "gl_dump // lists the data for the video card: vendor, renderer, version, and extensions used\n" +
                            "gl_flipmatrix \"0\" // toggles special crosshair fix when using the 3DNow! 3Dfx MiniGL - * 1 is 'on', 0 is 'off'\n" +
                            "gl_fog \"1\"\n" +
                            "gl_keeptjunctions \"1\" // toggles showing of cracks between textures - * 1 is 'on', 0 is 'off', with 1 being the better quality and slower fps\n" +
                            "gl_lightholes \"1\" // toggles light holes - * 1 is 'on', 0 is 'off'\n" +
                            "gl_max_size \"256\" // sets the maximum texture size\n" +
                            "gl_monolights \"0\" // toggles a uniform light source with no shadows - * 1 is 'on', 0 is 'off', and works in OpenGL only\n" +
                            "gl_nobind \"0\" // toggles the replacement of textures with alphanumeric characters - * 1 is 'on', 0 is 'off'\n" +
                            "gl_nocolors \"0\"\n" +
                            "gl_overbright \"0\" // toggles maximum brightness mode - * 1 is 'on', 0 is 'off'\n" +
                            "gl_palette_tex \"1\" // toggles paletted textures - * 1 is 'on', 0 is 'off'\n" +
                            "gl_picmip \"0\" // sets the rendering quality - * higher the number is faster but lower quality\n" +
                            "gl_playermip \"0\" // sets the player rendering quality - * higher the number is faster but lower quality\n" +
                            "gl_polyoffset \"4\" // sets the polygon offset - try out different values for texture flickering problems\n" +
                            "gl_reporttjunctions \"0\" // toggles writing T-junction reporting to the console\n" +
                            "gl_round_down \"3\" // sets the texture rounding down value - * higher the number faster but lower quality\n" +
                            "gl_spriteblend \"1\" // toggles blending sprite graphics - * 1 is 'on', 0 is 'off'\n" +
                            "gl_texels // reports the number of texels uploaded to the video card\n" +
                            "gl_texturemode // sets the rendering mode in order from the lowest quality but fastest to highest quality which is slower - * [type] options are: gl_nearest_mipmap_nearest, gl_linear_mipmap_nearest (these two deal with bilinear filtering) and gl_nearest_mipmap_linear, gl_linear_mipmap_linear (which deals with trilinear filtering)\n" +
                            "gl_wateramp \"0.300\"\n" +
                            "gl_wireframe \"0\"\n" +
                            "gl_zmax \"4096\" // sets the maximum size for the Z-Buffer\n" +
                            "gl_ztrick \"0\" // toggles the speeding up of 3Dfx rendering - * 1 is 'on', 0 is 'off'\n" +
                            "god // god mode makes player invincible - * 'sv_cheats' must be set to 1\n" +
                            "graphheight \"64\" // sets the height of the r_netgraph display\n" +
                            "heartbeat // sends a heartbeat signal to the master server to \"remind\" the master server that your server is still online and available\n" +
                            "hideconsole // hides the console\n" +
                            "hisound \"1\" // toggles high-quality sound - * 1=22kHz, 0=11kHz\n" +
                            "HostMap \"0\"\n" +
                            "hostname \"0\" // sets the server hostname\n" +
                            "hostport \"0\" // sets connection port for the server\n" +
                            "host_framerate \"0\" // sets the speed that the host/server interacts with the game\n" +
                            "host_killtime \"0\" // sets a time delay before killing the server\n" +
                            "host_limitlocal \"0\"\n" +
                            "host_profile \"0\"\n" +
                            "host_speeds \"0\"\n" +
                            "hpkextract // extracts files from hpk file - * opts = <hpkname> [all | single index]\n" +
                            "hpklist // lists the files in <hpkfilename>\n" +
                            "hpkremove // removes files from <hpkfilename>\n" +
                            "hpkval // displays the checksum value for <hpkfilename>\n" +
                            "hpk_maxsize \"4\"\n" +
                            "httpstop\n" +
                            "hud_capturemouse \"1\"\n" +
                            "hud_centerid \"0\" // toggles player ID display - * 1 is 'on', 0 is 'off'\n" +
                            "hud_classautokill \"1\"\n" +
                            "hud_deathnotice_time \"6\" // sets how long death messages remain onscreen\n" +
                            "hud_draw \"1\"\n" +
                            "hud_drawhistory_time \"5\" // sets how long HUD item icons remain onscreen\n" +
                            "hud_fastswitch \"0\" // toggles fast weapon switching - * 1 is 'on', 0 is 'off'\n" +
                            "hud_saytext \"1\"\n" +
                            "hud_saytext_time \"5\" // sets how long chat messages remain onscreen\n" +
                            "hud_takesshots \"0\"\n" +
                            "impulse // sprays logo decal\n" +
                            "interp // enables frame interpolation\n" +
                            "invnext // selects next item in inventory\n" +
                            "invprev // selects previous item in inventory\n" +
                            "ip \"0\" // sets ip address\n" +
                            "ipx_clientport \"0\" // sets the client port for an IPX game\n" +
                            "ipx_hostport \"0\"\n" +
                            "ip_clientport \"0\" // sets the client port for a TCP/IP game\n" +
                            "ip_hostport \"0\" // sets the server port for a TCP/IP game\n" +
                            "joyadvanced \"0\" // These do joystick things - who the hell uses joysticks for FPSes anyway?!? :)\n" +
                            "joyadvancedupdat\n" +
                            "joyadvaxisr \"0\"\n" +
                            "joyadvaxisu \"0\"\n" +
                            "joyadvaxisv \"0\"\n" +
                            "joyadvaxisx \"0\"\n" +
                            "joyadvaxisy \"0\"\n" +
                            "joyadvaxisz \"0\"\n" +
                            "joyforwardsensitivity \"-1\"\n" +
                            "joyforwardthreshold \"0.150\"\n" +
                            "joyname \"0\"\n" +
                            "joypitchsensitivity \"1\"\n" +
                            "joypitchthreshold \"0.150\"\n" +
                            "joysidesensitivity \"-1\"\n" +
                            "joysidethreshold \"0.150\"\n" +
                            "joystick \"0\"\n" +
                            "joywwhack1 \"0\"\n" +
                            "joywwhack2 \"0\"\n" +
                            "joyyawsensitivity \"-1\"\n" +
                            "joyyawthreshold \"0.150\"\n" +
                            "kick // kicks a player from a server using their userid - get the userid from using the \"users\" command - **Version 4.0.1.3+ only\n" +
                            "kill // player suicides to respawn again\n" +
                            "lambert \"1.500\"\n" +
                            "lightgamma \"2.500\" // sets the lighting gamma value\n" +
                            "list // lists local servers found after using the 'slist' commands\n" +
                            "listdemo // lists information about <demoname>\n" +
                            "listen\n" +
                            "listid // lists the uniqueid's in the banlist\n" +
                            "listip // lists the ip addresses in the filterban list\n" +
                            "load // loads a saved game\n" +
                            "loadas8bit \"0\" // toggles the forcing of 8-bit (lower quality) sounds - * 1 is 'on', 0 is 'off'\n" +
                            "localinfo // shows local settings\n" +
                            "log // toggles logging\n" +
                            "logaddress // sets the address for logfile when logging to a remote machine\n" +
                            "logaddress_add\n" +
                            "logaddress_del\n" +
                            "logsdir \"0\"\n" +
                            "lookspring \"0\" // toggles automatic view centering when 'mlook' is deactivated - * 1 is 'on', 0 is 'off'\n" +
                            "lookstrafe \"0\" // toggles mouse strafing when 'mlook' is active - * 1 is 'on', 0 is 'off'\n" +
                            "lservercfgfile \"0\" // sets the listen server config file - default is listenserver.cfg\n" +
                            "map // changes the map running on server and disconnects currently connected players\n" +
                            "mapchangecfgfile \"0\"\n" +
                            "mapcyclefile \"0\" // specifies the name of the list of maps to cycle through on a server - * default is 'mapcycle.txt'\n" +
                            "maps // lists maps containing <substring>\n" +
                            "maxplayers // sets maximum number of clients allowed on a server\n" +
                            "max_queries_sec \"3\"\n" +
                            "max_queries_sec_global \"30\"\n" +
                            "max_queries_window \"60\"\n" +
                            "mcache // lists modem cache contents\n" +
                            "messagemode // displays <text> to all other players on a server\n" +
                            "messagemode2 // displays <text> to only other players on same team\n" +
                            "model \"0\" // changes current player model to <modelname>\n" +
                            "motd // displays the Message Of The Day from the server's motd.txt file\n" +
                            "motdfile \"0\"\n" +
                            "motd_write\n" +
                            "mp3\n" +
                            "MP3FadeTime \"2\"\n" +
                            "MP3Volume \"0.800\"\n" +
                            "mp_consistency \"1\"\n" +
                            "mp_decals \"300\" // sets the maximum number of decals to be displayed at a time\n" +
                            "mp_footsteps \"1\" // toggles footstep sounds - * 1 is 'on', 0 is 'off'\n" +
                            "mp_logecho \"1\" // toggles logging of echo commands - * 1 is 'on', 0 is 'off'\n" +
                            "mp_logfile \"1\" // toggles logging during multiplayer games - * 1 is 'on', 0 is 'off'\n" +
                            "multicastport \"27025\"\n" +
                            "m_filter \"0\" // toggles mouse filtering (smoothing) - * 1 is 'on', 0 is 'off'\n" +
                            "m_forward \"1\" // sets the mouse forward speed sensitivity multiplier\n" +
                            "m_pitch \"0.022\" // sets the mouse pitch (up and down motion) speed sensitivity multiplier - * negative numbers result in an inverted mouselook\n" +
                            "m_side \"0.800\" // sets the mouse strafing speed sensitivity multiplier\n" +
                            "m_yaw \"0.022\" // sets the yaw speed sensitivity multiplier\n" +
                            "name \"0\" // used to change a player's name\n" +
                            "net_address \"0\"\n" +
                            "net_chokeloop \"0\"\n" +
                            "net_drawslider \"0\"\n" +
                            "net_graph \"0\"\n" +
                            "net_graphpos \"1\"\n" +
                            "net_graphwidth \"150\"\n" +
                            "net_log \"0\"\n" +
                            "net_scale \"5\"\n" +
                            "net_showdrop \"0\"\n" +
                            "net_showpackets \"0\"\n" +
                            "new // begins a new singleplayer game\n" +
                            "noclip // if turned on, players can walk through walls - * 1 is 'on', 0 is 'off', and 'sv_cheats' must be set to 1\n" +
                            "nosound \"0\" // toggles sound - * 1 is 'on', 0 is 'off'\n" +
                            "notarget // makes players ignore you - * 'sv_cheats' must be set to 1\n" +
                            "password \"0\" // sets private server password\n" +
                            "pausable \"1\" // toggles whether or not clients can pause a server game - * 1 is 'on', 0 is 'off'\n" +
                            "pause // pauses a game\n" +
                            "ping // displays pings of all clients\n" +
                            "pingservers // displays pings of servers in the serverlist\n" +
                            "play // plays a .wav designated by <filename>\n" +
                            "playdemo // plays <filename>.dem at normal speed\n" +
                            "playvol // sets demo playback volume\n" +
                            "pointfile // loads maps<filename>.pts\n" +
                            "port \"27015\" // sets the defualt server connection port\n" +
                            "ppdemostart\n" +
                            "quit // exits to windows without confirmation\n" +
                            "rate \"30000\" // sets client data rate - * 1000 - 5000 for modems, and 10000+ for LAN\n" +
                            "rcon // remote console command of a server - * <password> must be given first by rcon client before any commands will be accepted by the server\n" +
                            "rcon_address \"0\" // sets the rcon ip address\n" +
                            "rcon_password \"0\" // sets the rcon password\n" +
                            "rcon_port \"0\" // sets the rcon console port\n" +
                            "reconnect // reconnects to the current server\n" +
                            "record // begins to record a demo and saves it to Half-LifeValve<filename>.dem\n" +
                            "reload // reloads current map\n" +
                            "removedemo // removes a segment <sgmt> from <demo>\n" +
                            "removeid // removes uniqueid from being banned on a server - **Version 3.0.1.3 / 4.0.1.3+ only\n" +
                            "removeip // removes ip address from the filterban list\n" +
                            "resetrcon\n" +
                            "restart // restarts the current map and cleans the slate\n" +
                            "retry // tries four more times to connect to a server that has already failed four connect attempts\n" +
                            "room_delay \"0\" // 3D sound setting\n" +
                            "room_dlylp \"2\" // 3D sound setting\n" +
                            "room_feedback \"0\" // 3D sound setting\n" +
                            "room_left \"0\" // 3D sound setting\n" +
                            "room_lp \"0\" // 3D sound setting\n" +
                            "room_mod \"0\" // 3D sound setting\n" +
                            "room_off \"0\" // 3D sound setting\n" +
                            "room_refl \"0\" // 3D sound setting\n" +
                            "room_rvblp \"1\" // 3D sound setting\n" +
                            "room_size \"0\" // 3D sound setting\n" +
                            "room_type \"0\" // 3D sound setting\n" +
                            "r_bmodelhighfrac \"5\"\n" +
                            "r_bmodelinterp \"1\"\n" +
                            "r_cachestudio \"1\"\n" +
                            "r_cullsequencebox \"1\"\n" +
                            "r_decals \"4096\" // sets the maximum number of decals\n" +
                            "r_detailtextures \"0\"\n" +
                            "r_detailtexturessupported \"1\"\n" +
                            "r_drawentities \"1\" // toggles drawing player models and sprites - * 1 is 'on', 0 is 'off'\n" +
                            "r_drawviewmodel \"1\" // toggles drawing player weapon model - * 1 is 'on', 0 is 'off'\n" +
                            "r_dynamic \"1\" // toggles dynamic lighting - * 1 is 'on', 0 is 'off'\n" +
                            "r_fullbright \"0\" // toggles maximum brightness in local games only - * 1 is 'on', 0 is 'off'\n" +
                            "r_glowshellfreq \"2.200\"\n" +
                            "r_lightmap \"0\" // software rendering mode only - * displays one of four (0,1,2,3) possible lightmaps to view range of switched lights\n" +
                            "r_mirroralpha \"1\" // toggles reflective textures - * 1 is 'on', 0 is 'off'\n" +
                            "r_mmx \"0\" // toggles MMX xalculations for MMX cpu's - * 1 is 'on', 0 is 'off'\n" +
                            "r_norefresh \"0\" // toggles clearing HUD and console before redrawing - * 1 is 'on', 0 is 'off'\n" +
                            "r_novis \"0\" // toggles drawing underwater polygons - * 1 is 'on', 0 is 'off', 'r_wateralpha' must be set to 1\n" +
                            "r_speeds \"0\" // toggles average fps, draw speed and polygon info - * 1 is 'on', 0 is 'off', very useful when making maps\n" +
                            "r_traceglow \"0\" // toggles inclusion of monsters in glow sprite occlusion checking - * 1 is 'on', 0 is 'off'\n" +
                            "r_wadtextures \"0\"\n" +
                            "r_wateralpha \"1\" // toggles alpha blending underwater - * 1 is 'on', 0 is 'off', 'r_novis' must be set to 1\n" +
                            "save // save current game in single player only\n" +
                            "say // chat with all other players on a server\n" +
                            "say_team // relay a message to only your teammates\n" +
                            "screenshot // captures the screen and saves it in the Half-Life/Valve directory\n" +
                            "scr_centertime \"2\" // sets how long server messages remain on the screen\n" +
                            "scr_connectmsg \"0\" // displays \"msg\" in screen's lower left\n" +
                            "scr_connectmsg1 \"0\" // displays \"msg\" 1 in screen's lower left\n" +
                            "scr_connectmsg2 \"0\" // displays \"msg\" 2 in screen's lower left\n" +
                            "scr_conspeed \"600\" // sets the console scroll speed\n" +
                            "scr_ofsx \"0\" // sets the screen message offset\n" +
                            "scr_ofsy \"0\" // sets the screen message offset\n" +
                            "scr_ofsz \"0\" // sets the screen message offset\n" +
                            "scr_printspeed \"8\" // sets the screen message print speed\n" +
                            "sendents\n" +
                            "sendres\n" +
                            "sensitivity \"3\" // sets the sensitivity of the mouse\n" +
                            "servercfgfile \"0\" // sets the sercer config file - * default is server.cfg\n" +
                            "serverinfo // displays the server infromation\n" +
                            "setdemoinfo // adds information to a demo, such as a text title, play 'tracknum', fade <in/out> or <fast/slow>\n" +
                            "setinfo // sets the tfc clan battle id\n" +
                            "setmaster // sets the master server - * use either an ip addy or a hostname\n" +
                            "setpause\n" +
                            "showinfo // toggles display of all packets - * 1 is 'on', 0 is 'off'\n" +
                            "showpause \"1\" // toggles pause of graphic display - * 1 is 'on', 0 is 'off'\n" +
                            "shutdownserver\n" +
                            "sizedown // decreases screen size and increases fps\n" +
                            "sizeup // increases screen size and decreases fps\n" +
                            "skill \"1\" // sets the skill level in singleplayer and coop mode\n" +
                            "skin \"0\" // sets the model skin\n" +
                            "slist // searches for local servers - * use 'list' to display this list\n" +
                            "slot1 // select weapon group 1 (or menu item 1) see 'use'\n" +
                            "slot10 // select weapon group 10 (or menu item 10) see 'use'\n" +
                            "slot2 // select weapon group 2 (or menu item 2) see 'use'\n" +
                            "slot3 // select weapon group 3 (or menu item 3) see 'use'\n" +
                            "slot4 // select weapon group 4 (or menu item 4) see 'use'\n" +
                            "slot5 // select weapon group 5 (or menu item 5) see 'use'\n" +
                            "slot6 // select weapon group 6 (or menu item 6) see 'use'\n" +
                            "slot7 // select weapon group 7 (or menu item 7) see 'use'\n" +
                            "slot8 // select weapon group 8 (or menu item 8) see 'use'\n" +
                            "slot9 // select weapon group 9 (or menu item 9) see 'use'\n" +
                            "snapshot // takes a screenshot\n" +
                            "snapto\n" +
                            "snd_noextraupdate \"0\" // toggles extra sound system updates - * 1 is 'on' and only use if having problems, 0 is 'off'\n" +
                            "snd_show \"0\" // toggles the display of which sounds are being played - * 1 is 'on', 0 is 'off'\n" +
                            "soundfade // sets the soundfade parameters - *<param> = <%><hold>[<out><in>]\n" +
                            "soundinfo // displays the number of stereo channels, samples, samplebits, speed DMA, and sound channels\n" +
                            "soundlist // displays a list of all loaded sounds\n" +
                            "spawn // spawns a player back into the game\n" +
                            "speak // to say something over the intercom - * try: hello, #000000, mesa, you, go alert\n" +
                            "special // displays the special menu for each class\n" +
                            "spec_autodirector \"1\"\n" +
                            "spec_decal\n" +
                            "spec_drawcone \"1\"\n" +
                            "spec_drawnames \"1\"\n" +
                            "spec_drawstatus \"1\"\n" +
                            "spec_help\n" +
                            "spec_menu\n" +
                            "spec_mode\n" +
                            "spec_pip \"1\"\n" +
                            "spec_pos\n" +
                            "spk\n" +
                            "startdemos // begins playing demos in a loop\n" +
                            "startmovie // plays a movie\n" +
                            "stat\n" +
                            "stats\n" +
                            "status // lists each client and the following info for each client: user#, frags, name, framerate, latency, ping, packet drop %\n" +
                            "stop // stops the recording of a demo\n" +
                            "stopdemo // stop the playing of a demo\n" +
                            "stopsound // stops playing the current sound\n" +
                            "stuffcmds // used to initialize client console commands from server and restarts server and then does some funky thing to the server display\n" +
                            "suitvolume \"0.250\" // sets the volume of the HEV suit\n" +
                            "sv_accelerate \"10\" // sets the player acceleration for a server\n" +
                            "sv_aim \"1\" // toggles auto-aim for clients - * 1 is 'on', 0 is 'off'\n" +
                            "sv_airaccelerate \"10\" // sets the movement speed while player is in the air\n" +
                            "sv_airmove \"1\" // toggles clients ability to move in the air\n" +
                            "sv_allowdownload \"1\" // toggles the ability of clients to download maps and decals - * 1 is 'on', 0 is 'off'\n" +
                            "sv_allowupload \"1\" // toggles the ability of clients to upload models and decals - * 1 is 'on', 0 is 'off'\n" +
                            "sv_bounce \"1\" // toggles bounce pads - * 1 is 'on', 0 is 'off'\n" +
                            "sv_cheats \"0\" // toggles cheats - * 1 is 'on', 0 is 'off'\n" +
                            "sv_clienttrace \"1\" // sets the client bounding box for collisions\n" +
                            "sv_clipmode \"0\" // toggles client clipping mode - * 1 is 'on', 0 is 'off'\n" +
                            "sv_contact \"0\"\n" +
                            "sv_downloadurl \"0\"\n" +
                            "sv_enableoldqueries \"0\"\n" +
                            "sv_failuretime \"0.500\"\n" +
                            "sv_filetransfercompression \"1\"\n" +
                            "sv_filterban \"1\"\n" +
                            "sv_friction \"4\" // sets friction\n" +
                            "sv_gravity \"800\" // sets level of in-game gravity\n" +
                            "sv_instancedbaseline \"1\"\n" +
                            "sv_lan \"1\" // toggles LAN server mode - * 1 is 'on', 0 is 'off'\n" +
                            "sv_lan_rate \"20000\"\n" +
                            "sv_logbans \"0\"\n" +
                            "sv_logblocks \"0\"\n" +
                            "sv_logrelay \"0\"\n" +
                            "sv_log_onefile \"0\"\n" +
                            "sv_log_singleplayer \"0\"\n" +
                            "sv_maxrate \"0\" // sets the maximum data rate allowed on a server - good for HPB only servers - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "sv_maxspeed \"320\" // sets the maximum player speed for all clients\n" +
                            "sv_maxunlag \"0.500\"\n" +
                            "sv_maxupdaterate \"30\"\n" +
                            "sv_maxvelocity \"2000\" // sets the maximum velocity\n" +
                            "sv_minrate \"0\" // sets the minimum data rate allowed on a server - good for LPB only servers - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "sv_minupdaterate \"10\"\n" +
                            "sv_newunit \"0\"\n" +
                            "sv_outofdatetime \"1800\"\n" +
                            "sv_password \"0\" // sets a password for clients to enter a server\n" +
                            "sv_proxies \"1\"\n" +
                            "sv_rcon_banpenalty \"0\"\n" +
                            "sv_rcon_maxfailures \"10\"\n" +
                            "sv_rcon_minfailures \"5\"\n" +
                            "sv_rcon_minfailuretime \"30\"\n" +
                            "sv_region \"-1\"\n" +
                            "sv_send_logos \"1\"\n" +
                            "sv_send_resources \"1\"\n" +
                            "sv_skycolor_b \"0\"\n" +
                            "sv_skycolor_g \"0\"\n" +
                            "sv_skycolor_r \"0\"\n" +
                            "sv_skyname \"0\" // sets the sky texture\n" +
                            "sv_skyvec_x \"0\"\n" +
                            "sv_skyvec_y \"0\"\n" +
                            "sv_skyvec_z \"0\"\n" +
                            "sv_spectatormaxspeed \"500\" // sets the maximum movement speed of spectators - spectator mode does not currently work\n" +
                            "sv_stats \"1\"\n" +
                            "sv_stepsize \"18\" // sets monster and player auto step-up size - * larger values allows auto-climbing of steeper slopes\n" +
                            "sv_stopspeed \"100\" // speed at which the player stops when running forward, back, left or right\n" +
                            "sv_timeout \"60\" // sets the timeout inactivity limit\n" +
                            "sv_unlag \"1\"\n" +
                            "sv_unlagpush \"0\"\n" +
                            "sv_unlagsamples \"1\"\n" +
                            "sv_uploadmax \"0.500\"\n" +
                            "sv_version \"112.100\"\n" +
                            "sv_visiblemaxplayers \"-1\"\n" +
                            "sv_voicecodec \"0\"\n" +
                            "sv_voiceenable \"1\"\n" +
                            "sv_voicequality \"3\"\n" +
                            "sv_wateraccelerate \"10\" // sets the in-water acceleration of clients\n" +
                            "sv_wateramp \"0\"\n" +
                            "sv_waterfriction \"1\" // sets friction underwater\n" +
                            "sv_zmax \"4096\" // sets the maximum zbuffer size\n" +
                            "swapdemo // swaps two segments' positions inside a demo\n" +
                            "sys_ticrate \"100\"\n" +
                            "s_2dvolume \"0.880\" // maximum volume at which 2D sounds are played - * range from 0 to 1.0\n" +
                            "s_a3d \"0\" // toggles A3D support - * 1 is 'on', 0 is 'off'\n" +
                            "s_automax_distance \"30\" // sets the distance for maximum sound volume\n" +
                            "s_automin_distance \"2\" // sets the distance for minimum sound volume\n" +
                            "s_blipdir \"0\"\n" +
                            "s_bloat \"2\" // bloat factor for polygons in A3D 2.0 only\n" +
                            "s_buffersize \"65536\" // sets the buffer size\n" +
                            "s_disable_a3d // toggles disabling a3D - * 1 is 'on', 0 is 'off'\n" +
                            "s_distance \"60\" // adjust the ratio of game units to meters, affecting velocity, positioning and distance - * higher the number, the closer everything gets in audio terms - range from 0 to infinity\n" +
                            "s_doppler \"0\" // adjusts the doppler - * 1 is 'on', 0 is 'off', range from 0 to 10, and is very sensitive\n" +
                            "s_eax \"0\" // toggles EAX support - * 1 is 'on', 0 is 'off'\n" +
                            "s_enable_a3d // enables A3D support\n" +
                            "s_geometry \"1\" // toggles geometry rendering in A3D 2.0 only - * 1 is 'on', 0 is 'off'\n" +
                            "s_leafnum \"0\"\n" +
                            "s_materials \"0\"\n" +
                            "s_max_distance \"1000\" // maximum distance from the listener before rolloff is no longer applied - * valid range from 's_min_distance' to infinity\n" +
                            "s_min_distance \"8\" // minimum distance a source will be from the listener before rolloff is applied - * range from 0 to 's_max_distance'\n" +
                            "s_numpolys \"200\" // maximum polygons to be rendered in A3D 2.0 only - setting this to 0 is the same as turning off 's_geometry' - * range from 0 to infinity\n" +
                            "s_occfactor \"0.250\" // transmission value of material - the smaller the number, the less sound passes through material - * range from 0 to 1.0\n" +
                            "s_occlude \"1\" // toggles sound passing throug material (occlusions) in A3D 2.0 only - * 1 is 'on', 0 is 'off'\n" +
                            "s_occ_epsilon \"1\"\n" +
                            "s_polykeep \"1000000000\"\n" +
                            "s_polysize \"10000000\"\n" +
                            "s_refdelay \"4\" // delays between a source and its closest reflection in A3D 2.0 only - higher the delay, the more time it takes between when the source and its first reflection is played - * range from 0 to 100\n" +
                            "s_refgain \"0.400\" // adjusts the gain on each reflection in A3D 2.0 only, where the effects of distance are increased: high frequencies are filtered and volume lowered - * range from 0 to 10\n" +
                            "s_reflect \"1\"\n" +
                            "s_reverb \"1\"\n" +
                            "s_rolloff \"1\"\n" +
                            "s_show \"0\"\n" +
                            "s_showtossed \"0\"\n" +
                            "s_usepvs \"1\"\n" +
                            "s_verbwet \"0.250\" // controls the wet/dry mix of reverb for A3D only - higher the number, the more wet the sounds - * range from 0 to 1.0\n" +
                            "team \"0\" // toggles team mode - * 1 is 'on', 0 is 'off'\n" +
                            "tell // speks a message\n" +
                            "texgamma \"2\" // possibly sets the gamma of the text?\n" +
                            "tfc_newmodels \"1\"\n" +
                            "thirdperson // enables third-person view\n" +
                            "timedemo // plays <demoname>.dem at max fps and reports average fps\n" +
                            "timerefresh // player spins in plave and reports average fps for the spinning view\n" +
                            "togglebrowser\n" +
                            "toggleconsole // toggles the console screen - * usually bound to '~'\n" +
                            "togglescores\n" +
                            "topcolor \"30\" // sets the model top color\n" +
                            "traceralpha \"0.500\" // sets tracer bullet alpha component\n" +
                            "tracerblue \"0.400\" // sets tracer bullet blue component\n" +
                            "tracergreen \"0.800\" // sets tracer bullet green component\n" +
                            "tracerlength \"0.800\" // sets the tracer bullet length\n" +
                            "traceroffset \"30\" // sets the tracer bullet offset\n" +
                            "tracerred \"0.800\" // sets the tracer bullet red component\n" +
                            "tracerspeed \"6000\" // sets the tracer bullet speed\n" +
                            "unbind // removes binding to key <key>\n" +
                            "unbindall // removes all key bindings\n" +
                            "unpause\n" +
                            "upload // uploads files to a server\n" +
                            "user // lists model color, name, rate, and model for specified user\n" +
                            "users // lists all players with their corresponding userid's (#'s generated by server) and uniqueid's (id # unique per cd key and assigned by WON) - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "version // gives build version and date it was installed\n" +
                            "vgui_emulatemouse \"0\"\n" +
                            "vgui_runscript\n" +
                            "vid_d3d \"0\" // toggles Direct3D support - * 1 is 'on', 0 is 'off'\n" +
                            "viewdemo\n" +
                            "viewframe // enables wire-frame display - * OpenGL only\n" +
                            "viewmodel // enables model display\n" +
                            "viewnext // selects next model\n" +
                            "viewprev // selects previous model\n" +
                            "viewsize \"120\" // sets view size\n" +
                            "violence_ablood \"0\" // toggles blood - * 1 is 'on', 0 is 'off'\n" +
                            "violence_agibs \"0\" // toggles gibs - * 1 is 'on', 0 is 'off'\n" +
                            "violence_hblood \"0\"\n" +
                            "violence_hgibs \"0\" // toggles gibs - * 1 is 'on', 0 is 'off'\n" +
                            "voice_avggain \"0.500\"\n" +
                            "voice_clientdebug \"0\"\n" +
                            "voice_dsound \"1\"\n" +
                            "voice_eax \"0\"\n" +
                            "voice_enable \"1\"\n" +
                            "voice_fadeouttime \"0.100\"\n" +
                            "voice_forcemicrecord \"1\"\n" +
                            "voice_inputfromfile \"0\"\n" +
                            "voice_loopback \"0\"\n" +
                            "voice_maxgain \"5\"\n" +
                            "voice_modenable \"1\"\n" +
                            "voice_overdrive \"2\"\n" +
                            "voice_overdrivefadetime \"0.400\"\n" +
                            "voice_profile \"0\"\n" +
                            "voice_recordtofile \"0\"\n" +
                            "voice_scale \"1\"\n" +
                            "voice_showbanned\n" +
                            "voice_showchannels \"0\"\n" +
                            "voice_showincoming \"0\"\n" +
                            "volume \"0.800\" // sets game volume\n" +
                            "v_centermove \"0.150\"\n" +
                            "v_centerspeed \"500\"\n" +
                            "v_dark \"0\"\n" +
                            "wait // pauses for 1 tick during running an alias or script\n" +
                            "waterroom_type \"14\"\n" +
                            "waveplaylen\n" +
                            "writecfg\n" +
                            "writeid // writes unique id's to banned.cfg - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "writeip // writes ip addresses to listip.cfg\n" +
                            "zoom_sensitivity_ratio \"1.200\" // sets mouse sensitivity while using weapon zoom\n" +
                            "_careeraudio\n" +
                            "_restart\n" +
                            "_setgamedir\n" +
                            "_setrenderer\n" +
                            "_setvideomode\n" +
                            "_snd_mixahead \"0.100\"\n\n\n"
                            + "//Decentjump\n" +
                            "If you find it difficult to bunnyhop, or your timing on jumps is off, this basic script will help correct your jumps.\n" +
                            "To use, replace your +jump key with +decentjump.\n" +
                            "\n" +
                            "//Bunnyhop\n" +
                            "Sometimes referred to as auto-bhop, this script makes bunnyhopping very simple. When you hold down +bunnyhop you will keep jumping until you release the key. (note: this only works on older builds, check out the tutorial on setting up an older build here).\n" +
                            "To use, replace your +jump key with +bunnyhop\n" +
                            "\n" +
                            "//Double-duck (box jump / climbing)\n" +
                            "Ever wonder how some players can climb boxes at an impressive speed? It is likely they are using a doubleduck script. It works by ducking, then quickly releasing duck and then ducking again resulting in a small elevation from the ground.\n" +
                            "To use this script, assign a key to +doubleduck.\n" +
                            "\n" +
                            "//Long Jump\n" +
                            "Many players use a long jump script, it simplifies ducking and jumping into one key. There is however 4 different player animations, 3 of which only occur with the use of a script. For this reason we recommend you use the default animation, but we will include the other scripts.\n" +
                            "To use, assign a key to +longjump (note: you will need to press a movement key whilst pressing your longjump key for these to work).\n" +
                            "\n" +
                            "//Silent Long Jump\n" +
                            "This script is essentially a long jump script with a shorter jump but with the upside that no surface sounds are triggered when it is executed. You will need to copy & paste the 'wait' script listed in 'Shortcut Scripts' into your .cfg before you can use this.\n" +
                            "To use, bind a key to +silent_lj (note: needs to be performed from a stand still after tapping backwards).\n" +
                            "\n" +
                            "//Walking/Sneaking\n" +
                            "This is a very useful script in HLDM:AG because it allows you to walk without triggering sound.\n" +
                            "To use, bind a key to +walk (you can replace your +speed key with +walk).\n" +
                            "\n" +
                            "//Quick Bow\n" +
                            "Possibly the most controversial script is the bow script. It works by zooming, taking a shot, then switching weapon back to crossbow, almost instantaneously.\n" +
                            "To use this script, assign a key to +quickbow.\n" +
                            "\n" +
                            "//Impulse Gauss\n" +
                            "This can be used whilst moving or from a stationary position. You must press press and hold your +gauss_jump key, jump, then face the direction you want to go and release the key. You will then be boosted in the direction you face (note: change the fps_max 125 value at the end of line 2 to the fps_max value you use).\n" +
                            "To use this, bind a key to +gauss_jump.\n" +
                            "\n" +
                            "//Low Sens\n" +
                            "If you wish to lower your mouse sensivity when fighting at long range, for example, to help increase your accuracy - that is the purpose of this script. You will need to replace the sensitivity value in line 2 with your ingame sensivity, and the sensivity in line 2 to your desired low sensivity value.\n" +
                            "To use, assign a key to +lowsens and hold this key for low sensitivity - once released you will return to normal sensivity\n" +
                            "\n" +
                            "//Waits\n" +
                            "If you wish to add greater time intervals between commands within a script, this script gives you a range to choose from. For example if you need a gap of 6 frames, you simply add wait2 and wait4 together within a script, like so: +attack;wait2;wait4;+reload. Note: some scripts require this waits script to work, so its advisable to keep this script in your .cfg. \n" +
                            "\n" +
                            "//Recharging\n" +
                            "This is a useful script to let your team mates know you are at a health/armor charger.\n" +
                            "You can replace your +use key with +use2 or assign a new key to +use2.\n" +
                            "\n" +
                            "//Drop Weapon\n" +
                            "If you need to catch the attention of a team mate so you can give him a weapon, this script will send a message to your team and also play a beep sound to team mates closeby. If you want to drop a specific weapon (eg. shotgun), you can replace drop with drop weapon_shotgun.\n" +
                            "To use, bind a key to drop_team.\n" +
                            "\n" +
                            "//Realnames\n" +
                            "A little known script which makes use of the loadauthid and unloadauthid commands which are exclusive to HLDM:AG. By pressing your +realnames key you will see the real names of players displayed in the scoreboard. For this to work you will need to have a realnames.txt inside your common\\Half-Life\\ag folder. Click here to download realnames.txt.\n" +
                            "To use, assign a key to +realnames.\n" +
                            "\n" +
                            "//Demo Recorder\n" +
                            "This script utilizes \"agrecord\", allowing each individual demo to be automatically timestamped in your ag folder. It also automatically takes a screenshot of the scoreboard when you stop the demo.\n" +
                            "To use, assign a key to demo_record and a key to demo_stop.\n" +
                            "\n" +
                            "//Name Change Toggle\n" +
                            "This script can simplify things if you use a few different ingame nicknames. It lets you assign one key to toggle between different nicknames. This is setup to switch between 3 nicknames, you can add as many as you wish by copy & pasting more lines (remember to replace nick3 with nick4 etc).\n" +
                            "To use, assign a key to names and replace the <nickname>'s with your own nicknames.\n\n"
                            + "//Quick-Use script\n"
                            + "A simple script that executes an one-frame +use that doesn't slow down your speed, perfect for pressing buttons as you Bunnyhop right beside them.\n"
                            + "Use bind <key> quse");
                            comandos.close();
                            documentacion = new File("Documentation.txt");
                            Desktop.getDesktop().open(documentacion);
                }
            } catch (IOException ex) {}
            
        }   else {
                try {
                    FileWriter comandos = new FileWriter("Documentación.txt");
                    comandos.write("//Información sobre algunos comandos de Half Life\n" +
                            "//***********************************************\n" +
                            "\n" +
                            "+alt1\n" +
                            "+attack // Dispara\n" +
                            "+attack2 // Disparo secundario - *Mire \"special\"\n" +
                            "+back // Te mueve hacia atrás\n" +
                            "+break\n" +
                            "+camdistance // Mueve la cámara de seguimiento lejos del jugador - *Solo funciona en tercera persona\n" +
                            "+camin // Mueve la cámara de seguimiento hacia adelante - *Solo funciona en tercera persona\n" +
                            "+cammousemove // Mueve la cámara de seguimiento con el mouse - *Solo funciona en tercera persona\n" +
                            "+camout // Mueve la cámara de seguimiento hacia atrás - *Solo funciona en tercera persona\n" +
                            "+campitchdown // Disminuye el ángulo de la cámara para mirar hacia abajo - *Solo funciona en tercera persona\n" +
                            "+campitchup // Disminuye el ángulo de la cámara para mirar hacia arriba - *Solo funciona en tercera persona\n" +
                            "+camyawleft // Inclina la cámara de seguimiento hacia la izquierda - *Solo funciona en tercera persona\n" +
                            "+camyawright // Inclina la cámara de seguimiento hacia la derecha - *Solo funciona en tercera persona\n" +
                            "+commandmenu\n" +
                            "+duck // Agacharse\n" +
                            "+forward // Te mueves hacia adelante\n" +
                            "+graph\n" +
                            "+jlook // Permite mirar alrededor con el joystick\n" +
                            "+jump // Salta\n" +
                            "+klook // Permite mirar alrededor con el teclado\n" +
                            "+left // Te mueves a la izquierda\n" +
                            "+lookdown // Mirar abajo\n" +
                            "+lookup // Mirar arriba\n" +
                            "+mlook // Permite mirar alrededor con el mouse\n" +
                            "+movedown // Mueve al jugador hacia abajo - *Bajar una escalera, nada hacia abajo\n" +
                            "+moveleft // Te mueves a la izquierda\n" +
                            "+moveright // Te mueves a la derecha\n" +
                            "+moveup // Mueve al jugador hacia arriba - *Subir una escalera, nada hacia arriba\n" +
                            "+reload // Recarga el arma actual\n" +
                            "+right // Te mueves a la derecha\n" +
                            "+score\n" +
                            "+showscores // Muestra la tabla de puntuación\n" +
                            "+speed // Fuerza al jugardor a caminar si 'correr siempre' está activado, y lo fuerza a correr si 'correr siempre' está desactivado\n" +
                            "+strafe // modificador de \"strafe\". Mientras está presionado, utiliza las teclas de dirección para realizar strafes en diferentes direcciones\n" +
                            "+use // Usa un objeto, como botones, cañones, etc.\n" +
                            "+voicerecord\n" +
                            "-alt1\n" +
                            "-attack\n" +
                            "-attack2\n" +
                            "-back\n" +
                            "-break\n" +
                            "-camdistance\n" +
                            "-camin\n" +
                            "-cammousemove\n" +
                            "-camout\n" +
                            "-campitchdown\n" +
                            "-campitchup\n" +
                            "-camyawleft\n" +
                            "-camyawright\n" +
                            "-commandmenu\n" +
                            "-duck\n" +
                            "-forward\n" +
                            "-graph\n" +
                            "-jlook\n" +
                            "-jump\n" +
                            "-klook\n" +
                            "-left\n" +
                            "-lookdown\n" +
                            "-lookup\n" +
                            "-mlook\n" +
                            "-movedown\n" +
                            "-moveleft\n" +
                            "-moveright\n" +
                            "-moveup\n" +
                            "-reload\n" +
                            "-right\n" +
                            "-score\n" +
                            "-showscores\n" +
                            "-speed\n" +
                            "-strafe\n" +
                            "-use\n" +
                            "-voicerecord\n" +
                            "addip // Añade la ip a la lista de filtros de ban - * Usa 0 minutos para añadirla permanentemente\n" +
                            "alias // Junta varios comandos en una función (alias), para ejecutarlos todos al llamar al alias\n" +
                            "ambient_fade \"100\" // Establece la distancia a la cual el sonido ambiental se disipa\n" +
                            "ambient_level \"0.300\" // Establece el volumen ambiental\n" +
                            "appenddemo // Grama una demo y la concatena al arhivo existente en Half-Life/Valve/demo.dem\n" +
                            "ati_npatch \"1\"\n" +
                            "ati_subdiv \"2\"\n" +
                            "autosave // Activa el guardado automático\n" +
                            "banid // Banea y kickea jugadores de servidores usando su ID única - Obtén está ID única del comando \"users\" - 0 minutos es un ban permanente- **Solo Version 4.0.1.3+ \n" +
                            "bannedcfgfile \"0\"\n" +
                            "bgmbuffer \"4096\" // Establece el tamaño del buffer de audio del CD\n" +
                            "bgmvolume \"1\" // Activa y desactiva el audio del CD- * 1 es 'activado', 0 es 'desactivado'\n" +
                            "bind // Establece una tecla para realizar una acción al presionarla\n" +
                            "bitmapfonts \"1\"\n" +
                            "bottomcolor \"6\" // Establece el color inferior del modelo de jugador\n" +
                            "brightness \"1\" // Activa la reducción de destellos - *Mientras más alto el valor, más brillante \n" +
                            "cam_command \"0\" // Activa y desactiva los comandos de la cámara de seguimiento - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cam_contain \"0\" // Activa y desactiva el \"auto contain\" de la cámara de seguimiento - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cam_idealdist \"64\" // Establece la distancia preferida entre el modelo del jugador y la cámara de seguimiento - *Solo funciona en tercera persona\n" +
                            "cam_idealpitch \"0\" // Establece el ángulo horizontal preferido de la cámra de seguimiento- *Solo funciona en tercera persona\n" +
                            "cam_idealyaw \"90\" // Establece el ángulo vertical preferido de la cámra de seguimiento - *Solo funciona en tercera persona\n" +
                            "cam_snapto \"0\" // Establece el intervalo preferido de la cámra de seguimiento - *Solo funciona en tercera persona\n" +
                            "cancelselect // Cancela la selección\n" +
                            "career\n" +
                            "cd // Conrola el audio del CD - * por ejemplo , 'cd stop' detiene el sonido del CD, 'cd loop X' reproduce X veces una pista\n" +
                            "centerview // Centra la visión del jugador\n" +
                            "changelevel // Cambia el mapa y mantiene la conección con los clientes\n" +
                            "changelevel2 // Continúa el juego actual en un nuevo mapa\n" +
                            "chase_active \"0\"\n" +
                            "chase_back \"100\" // Establce la distancia preferida entre el jugador y la cámra de perseguimiento al retroceder\n" +
                            "chase_right \"0\" // Establece la desviación horizontal preferida de la cámara de seguimiento\n" +
                            "chase_up \"16\" // Establece la desviación vertical preferida de la cámara de seguimiento\n" +
                            "clear // clears the console screen\n" +
                            "clientport \"27005\" // Establece el puerto que el cliente utilizará para conectarse al servidor\n" +
                            "clockwindow \"0.500\"\n" +
                            "cl_allowdownload \"1\" // Activa y desactiva la descarga de mapas, grafitis y modelos al conectarse a un servidor - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_allowupload \"1\" // Activa y desactiva la subida de mapas, grafitis y modelos al conectarse a un servidor - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_anglespeedkey \"0.670\" // Establece la velocidad a la que las teclas de dirección cambian la visión\n" +
                            "cl_backspeed \"400\" // Establece la velocidad de retroceso del jugador - Solo es puede ir a la velocidad que el servidor lo permite\n" +
                            "cl_bob \"0.010\" // Establece la cantidad a la que la que la vista rebota cuando el jugador corre\n" +
                            "cl_bobcycle \"0.800\" //Establece la frecuencia a la que la vista rebota cuando el jugador corre\n" +
                            "cl_bobup \"0.500\" // Establece la frecuencia a la que las vista del jugador rebota cuando el jugador corre\n" +
                            "cl_chasedist \"112\"\n" +
                            "cl_clockreset \"0.100\"\n" +
                            "cl_cmdbackup \"2\"\n" +
                            "cl_cmdrate \"30\"\n" +
                            "cl_dlmax \"128\"\n" +
                            "cl_download_ingame \"1\" // Activva y desactiva la descarga de modelos y grafitis durante el juego - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_fixtimerate \"7.500\"\n" +
                            "cl_forwardspeed \"400\" // Establece la velocidad hacia adelante del jugador - Solo es puede ir a la velocidad que el servidor lo permite\n" +
                            "cl_gaitestimation \"1\" // Permite estimar el movimiento de pasos del jugador  \n" +
                            "cl_gg \"0\" // Activa y desactiva el modo indicador del juego - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_himodels \"0\" // Activa y desactiva los modelos de jugador de alta calidad - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_idealpitchscale \"0.800\"\n" +
                            "cl_lc \"1\"\n" +
                            "cl_logocolor \"0\"\n" +
                            "cl_logofile \"0\"\n" +
                            "cl_lw \"1\"\n" +
                            "cl_messages // Muestra los mensajes del servidor\n" +
                            "cl_movespeedkey \"0.300\" // Establece la velocidad de movimiento al usar el teclado\n" +
                            "cl_needinstanced \"0\"\n" +
                            "cl_nosmooth \"0\"\n" +
                            "cl_pitchdown \"89\" // Establece el máximo ángulo para mirar abajo - *89 es lo default \n" +
                            "cl_pitchspeed \"225\" // sets the speed at which the pitch changes\n" +
                            "cl_pitchup \"89\" //  Establece el máximo ángulo para mirar arriba - *89 es lo default \n" +
                            "cl_pmanstats \"0\"\n" +
                            "cl_rate\n" +
                            "cl_resend \"6\" // Establece el recuento de reenvíos \n" +
                            "cl_showerror \"0\"\n" +
                            "cl_showevents \"0\"\n" +
                            "cl_showfps \"0\"\n" +
                            "cl_showmessages \"0\"\n" +
                            "cl_shownet \"0\" // Activa y desactiva el mostrar el número de packetes de red - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_sidespeed \"400\" // Establece la velocidad de strafe del jugador\n" +
                            "cl_slist \"10\" //Establece el número de servidores en la lista de srevidores\n" +
                            "cl_smoothtime \"0.100\"\n" +
                            "cl_solid_players \"1\" // Activa y desactiva los modelossólidos de jugadores - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cl_timeout \"60\" // Establece el tiempo de inactividad antes de que el cliente se desconecte\n" +
                            "cl_updaterate \"20\"\n" +
                            "cl_upspeed \"320\" // Establece la velocidad a la que el jugador sube escaleras\n" +
                            "cl_vsmoothing \"0.050\"\n" +
                            "cl_waterdist \"4\" // Establece la distancia bajo el agua\n" +
                            "cl_weaponlistfix \"0\"\n" +
                            "cl_yawspeed \"210\" // Establece la velocidad de giro - * Solo es puede ir a la velocidad que el servidor lo permite\n" +
                            "cmd // can use this in conjunction with a command\n" +
                            "cmdlist // Lista de todos los comandos de consola - * Si escribes 'cmdlist a', solo mostrará los comandos que comiencen con la letra a, y así- también, 'cmdlist log logfile escribe la lista en C:logfile\n" +
                            "commentator\n" +
                            "com_filewarning \"0\"\n" +
                            "condebug\n" +
                            "condump\n" +
                            "connect // Conecta al servidor alojado en la ip indicada\n" +
                            "console \"1\"\n" +
                            "contimes // muestra n líneas de overlay - * n = de 4 a 64\n" +
                            "con_color \"255\"\n" +
                            "con_fastmode \"1\"\n" +
                            "con_notifytime \"4\" // Establece el tiempo de notificicación del cliente\n" +
                            "coop \"0\" // Activa y desactiva el juego cooperativo - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "crosshair \"1\" //Activa y desactiva la mira del arma - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "cvarlist // Muestra una lista de todos las variables de consola en la consola - * 'cvar log filename' escribe la lista en file C:filename\n" +
                            "c_maxdistance \"200\" // Establece la distancia máxima de la cámara de seguimiento\n" +
                            "c_maxpitch \"90\" // Establece la distancia horizontal máxima de la cámara de seguimiento\n" +
                            "c_maxyaw \"135\" // Establece la distancia vertical máxima de la cámara de seguimiento\n" +
                            "c_mindistance \"30\"\n" +
                            "c_minpitch \"0\" // Establece la distancia horizontal mínima de la cámara de seguimiento\n" +
                            "c_minyaw \"-135\" // Establece la distancia vertical mínima de la cámara de seguimiento\n" +
                            "deathmatch \"0\" // Activa y desactiva el modo \"deathmatch\" - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "default_fov \"90\" // Establece el campo de visión predeterminado en grados - * miestras más pequeño el número, más pequeño el campo de visión, mientras más grande el número, más amplio el campo de visión\n" +
                            "delta_clear\n" +
                            "delta_stats\n" +
                            "demos // Ejecuta un bucle de demos inicializados con stardemos\n" +
                            "dem_forcehltv\n" +
                            "dem_jump\n" +
                            "dem_pause\n" +
                            "dem_save\n" +
                            "dem_speed\n" +
                            "dem_start\n" +
                            "developer \"0\" // Activa y desactiva los comandos de desarrollador en la consola - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "dev_overview \"0\"\n" +
                            "direct \"0.900\"\n" +
                            "disconnect // Desconecta a un jugador del servidor\n" +
                            "dlfile\n" +
                            "dropclient // Desconecta a un cliente del servidor\n" +
                            "d_spriteskip \"0\"\n" +
                            "echo // Texto echo en la consola - * Útil par hacer saber a un jugador que se ejecuté exitosamente un script\n" +
                            "edgefriction \"2\" // Establece la cantidad de fricción entre un jugador y los objetos\n" +
                            "endmovie // Finaliza la actual película \n" +
                            "entities // Lista de las entidades cargadas\n" +
                            "envmap // Crea las 6 .bmp imágenes del cielo desde la posición actual del jugador	\n" +
                            "escape // Actúa como una tecla  <ESCAPE> para esconder la consola y cancelar las selecciones\n" +
                            "exec // Ejecuta un sccript o un archivo .cfg\n" +
                            "exit // Cierra un juego o un servidor dedicado sin pedir confirmación\n" +
                            "ex_interp \"0.100\"\n" +
                            "fakelag \"0\" // Simula lag - * Más grande el número, más lag\n" +
                            "fakeloss \"0\" // Simula paquetes perdidos - * Más grande el número, más paquetes perdidos\n" +
                            "firstperson // Activa la vista en primera persona\n" +
                            "flush // Refresca la memoria y recarga el mapa\n" +
                            "fly\n" +
                            "ForceCloseComman\n" +
                            "force_centerview // Fuerza al jugadora a mirar defrente\n" +
                            "fps_max \"72\"\n" +
                            "fps_modem \"0\" // Establece el número máximo de fps en una artida online\n" +
                            "fs_lazy_precache \"0\"\n" +
                            "fs_perf_warnings \"0\"\n" +
                            "fs_precache_timings \"0\"\n" +
                            "fs_startup_timings \"0\"\n" +
                            "fullinfo // Muestra la informasión del usuario\n" +
                            "fullserverinfo // Muestra la información del servidor\n" +
                            "fullupdate\n" +
                            "gamedir\n" +
                            "gamma \"2.500\" // Establece la cantidad de gamma\n" +
                            "gg // Inicia el indicador de juego usando <demoname> - * 'cl_gg'debe estar activado \n" +
                            "gl_affinemodels \"0\"\n" +
                            "gl_alphamin \"0.250\" // Establece el nivel de alpha mínimo\n" +
                            "gl_clear \"0\" // ACtiva y desactiva la calidad visual - * Cuando etá activado, se muestras grietas entre las texturas\n" +
                            "gl_cull \"1\" // Activa y desactiva la renderización de solo los objetos visibles - * 1 es 'activado', 0 es 'desactivado'', y 0 bajará los fps\n" +
                            "gl_d3dflip \"0\" // Activa y desactiva el orden de renderización para D3D\n" +
                            "gl_dither \"1\" // Alterna la interpolación - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "gl_dump // Crea una lista de la información de la tarjeta gr´fica: vendedor, renderizador, versión y extensiones usadas\n" +
                            "gl_flipmatrix \"0\" // Alterna la reparación de miras especiales al usar 3DNow! 3Dfx MiniGL - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "gl_fog \"1\"\n" +
                            "gl_keeptjunctions \"1\" // Alterna la grietas entre teturas - * 1 es 'activado', 0 es 'desactivado', 1 es mejor calidad pero menos fps\n" +
                            "gl_lightholes \"1\" // Alterna los hoyos de luz - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "gl_max_size \"256\" // Establece el tamaño máximo de las texturas\n" +
                            "gl_monolights \"0\" // Activa y desactiva una luz uniforme sin sombras - * 1 es 'activado', 0 es 'desactivado', solo funciona con OpenGL\n" +
                            "gl_nobind \"0\" // Alterna el reemplzar las texturas por cracteres alfanuméricos - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "gl_nocolors \"0\"\n" +
                            "gl_overbright \"0\" // Alterna el modod de brillo máximo - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "gl_palette_tex \"1\" // Alterna la paleta de texturas - * 1 is 'on', 0 is 'off'\n" +
                            "gl_picmip \"0\" // Establece la calidad de renderizado - * Mientras más alto el número es más rápido, pero menor calidad\n" +
                            "gl_playermip \"0\" // Establece la calidad de renderizado - * Mientras más alto el número es más rápido, pero menor calidad\n" +
                            "gl_polyoffset \"4\" // Establece la calidad de renderizado del jugador - Prueba istintos valorse para solucionar problemas\n" +
                            "gl_reporttjunctions \"0\" // alterna la escritura de informes de unión en T en la consola \n" +
                            "gl_round_down \"3\" // Establece el valor de redondeo hacia abajo de las texturas - * Mientras más alto el número es más rápido, pero menor calidad\n" +
                            "gl_spriteblend \"1\" // Alterna la mezcla de gráficos en los sprites - * 1 es 'activado', 0 es 'desactivado'\n" +
                            "gl_texels // Informa sobre el número de \"texels\" cargados en la tarjeta gráfica\n" +
                            "gl_texturemode // Establece el modo de renderizado. Mientras más rápido pero menor calidad, y más calidad pero menor velocidad - * [type]las opciones son: gl_nearest_mipmap_nearest, gl_linear_mipmap_nearest (these two deal with bilinear filtering) and gl_nearest_mipmap_linear, gl_linear_mipmap_linear (lo cua arregla el filtrado trilineal)\n" +
                            "gl_wateramp \"0.300\"\n" +
                            "gl_wireframe \"0\"\n" +
                            "gl_zmax \"4096\" // Establece el tamaño máximo del Z-Buffer\n" +
                            "gl_ztrick \"0\" // Acelera el renderizado de 3Dfx  - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "god // Hace invencible al jugador - * 'sv_cheats' debe estar en 1\n" +
                            "graphheight \"64\" // Etablece la altura del r_netgraph \n" +
                            "heartbeat // Envía una señal al servidor para informar que el servidor sigue activo\n" +
                            "hideconsole // Esconde la consola\n" +
                            "hisound \"1\" // Alterna la calidad de sonido - * 1=22kHz, 0=11kHz\n" +
                            "HostMap \"0\"\n" +
                            "hostname \"0\" // Establece el nombre de host del servidor\n" +
                            "hostport \"0\" // Establece el puerto de conexión del servidor\n" +
                            "host_framerate \"0\" // EStablece la velocidad a la que el host/servidor interactúa con el juego\n" +
                            "host_killtime \"0\" // Establece el tiempo de demora antes de apagar el servidor\n" +
                            "host_limitlocal \"0\"\n" +
                            "host_profile \"0\"\n" +
                            "host_speeds \"0\"\n" +
                            "hpkextract // extrae archivos del archivo hpk - * opts = <hpkname> [all | single index]\n" +
                            "hpklist // Lista de archivos en <hpkfilename>\n" +
                            "hpkremove // Borra los archivos de <hpkfilename>\n" +
                            "hpkval // Muestra la suma de control de <hpkfilename>\n" +
                            "hpk_maxsize \"4\"\n" +
                            "httpstop\n" +
                            "hud_capturemouse \"1\"\n" +
                            "hud_centerid \"0\" // Alterna el mostrar la ID del jugador - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "hud_classautokill \"1\"\n" +
                            "hud_deathnotice_time \"6\" // Establecepor cuánto tiempo los mensajes de muerte permanecen en la pantalla\n" +
                            "hud_draw \"1\"\n" +
                            "hud_drawhistory_time \"5\" // EStablece por cuánto tiempo los items del HUD permanecen en la pantalla\n" +
                            "hud_fastswitch \"0\" // Activa o desactiva el cambio rápido de armas - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "hud_saytext \"1\"\n" +
                            "hud_saytext_time \"5\" // Establece por cuánto tiempo los mensajes del chat permanecen en la pantalla\n" +
                            "hud_takesshots \"0\"\n" +
                            "impulse // calcomanía con el logotipo de aerosoles \n" +
                            "interp // ACtiva la interpolación de cuadros\n" +
                            "invnext // Selecciona el siguiente item en el inventario\n" +
                            "invprev // Selecciona el anterior item en el inventario\n" +
                            "ip \"0\" // Establece la dirección ip\n" +
                            "ipx_clientport \"0\" // Establece el puerto del cliente para un juego IPX\n" +
                            "ipx_hostport \"0\"\n" +
                            "ip_clientport \"0\" // Establece el puerto del cliente para un juego TCP/IP\n" +
                            "ip_hostport \"0\" // Establece el puerto del servidor para un juego TCP/IP\n" +
                            "joyadvanced \"0\" // Hace cosas con el joystick - ¿¡¿Pero quién usa joystick ara juegos fps?!? :)\n" +
                            "joyadvancedupdat\n" +
                            "joyadvaxisr \"0\"\n" +
                            "joyadvaxisu \"0\"\n" +
                            "joyadvaxisv \"0\"\n" +
                            "joyadvaxisx \"0\"\n" +
                            "joyadvaxisy \"0\"\n" +
                            "joyadvaxisz \"0\"\n" +
                            "joyforwardsensitivity \"-1\"\n" +
                            "joyforwardthreshold \"0.150\"\n" +
                            "joyname \"0\"\n" +
                            "joypitchsensitivity \"1\"\n" +
                            "joypitchthreshold \"0.150\"\n" +
                            "joysidesensitivity \"-1\"\n" +
                            "joysidethreshold \"0.150\"\n" +
                            "joystick \"0\"\n" +
                            "joywwhack1 \"0\"\n" +
                            "joywwhack2 \"0\"\n" +
                            "joyyawsensitivity \"-1\"\n" +
                            "joyyawthreshold \"0.150\"\n" +
                            "kick // Kickea a un jugador del servidor usando su id única - obetñen la ID del comando \"user\" - **Solo Version 4.0.1.3+ \n" +
                            "kill // Te suicidas\n" +
                            "lambert \"1.500\"\n" +
                            "lightgamma \"2.500\" // Establece el gamma para los rayos de luz\n" +
                            "list // Crea una lista de los servidores locales luego de usar el comando \"slist\"\n" +
                            "listdemo // Crea una lista de la información acerca de <demoname>\n" +
                            "listen\n" +
                            "listid // Crea una lista de las IDs de los jugadores en la lista de Ban \n" +
                            "listip // Crea una lista de las ip en la lista de filtros de ban\n" +
                            "load // Carga un juego guardado\n" +
                            "loadas8bit \"0\" // Alterna el forzar los sonidos de 8 bits (baja calidad) - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "localinfo // Muestra las configuraciones locales\n" +
                            "log // Alterna el inicio de sesión\n" +
                            "logaddress // Establece la dirección para un logfile al entrar a una máquina distinta\n" +
                            "logaddress_add\n" +
                            "logaddress_del\n" +
                            "logsdir \"0\"\n" +
                            "lookspring \"0\" // Alterna el centrado de visión automática cuando 'mlook' está desactivado- * 1  es 'activado', 0 es 'desactivado'\n" +
                            "lookstrafe \"0\" // Alterna el strafing con el mouse cuando 'mlook' está activado - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "lservercfgfile \"0\" // Establece el archivo cfg del oyende de servidor - lo default es listenserver.cfg\n" +
                            "map // Cambia el mapa actual del servidor y desconecta a los jugadores\n" +
                            "mapchangecfgfile \"0\"\n" +
                            "mapcyclefile \"0\" // Especifíca el nombre de la lista de mapas en un servidor - * lo default es 'mapcycle.txt'\n" +
                            "maps // Crea una lista de mapas que contienen <substring>\n" +
                            "maxplayers // Establece el número máximo de clientes en un servidor\n" +
                            "max_queries_sec \"3\"\n" +
                            "max_queries_sec_global \"30\"\n" +
                            "max_queries_window \"60\"\n" +
                            "mcache // Crea una lista del contenido caché\n" +
                            "messagemode // Muestra <text> a todos los jugadores en el servidor\n" +
                            "messagemode2 // uUestra <text> a todos los jugadores en el mismo equipo en el servidor\n" +
                            "model \"0\" // cambia el model del jugador a <modelname>\n" +
                            "motd // Muestra el mensaje del día del servidor encontrado en motd.txt \n" +
                            "motdfile \"0\"\n" +
                            "motd_write\n" +
                            "mp3\n" +
                            "MP3FadeTime \"2\"\n" +
                            "MP3Volume \"0.800\"\n" +
                            "mp_consistency \"1\"\n" +
                            "mp_decals \"300\" // Establece el número máximo de calcos mostrados a la vez\n" +
                            "mp_footsteps \"1\" // Activa y desactiva los sonidos de pasos - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "mp_logecho \"1\" // Alterna el uso de los comandos echo - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "mp_logfile \"1\" // Alterna el regisro durante juegos multijugador - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "multicastport \"27025\"\n" +
                            "m_filter \"0\" // Activa y desactiva el filtro del ratón (suavizado) - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "m_forward \"1\" // Establece el multiplicador de sensiblidad al mover el mouse hacia adelante\n" +
                            "m_pitch \"0.022\" // Establece el multiplicador de sensibilidad al mover el mouse verticalmente - * Número negativos resultan en una mirada invertida\n" +
                            "m_side \"0.800\" // Establece el multiplicador de sensibilidad al hacer un strafe\n" +
                            "m_yaw \"0.022\" // Establece el multiplicador de sensiblidad al mover el mouse horizontalmente\n" +
                            "name \"0\" // Cambia el nombre del jugador\n" +
                            "net_address \"0\"\n" +
                            "net_chokeloop \"0\"\n" +
                            "net_drawslider \"0\"\n" +
                            "net_graph \"0\"\n" +
                            "net_graphpos \"1\"\n" +
                            "net_graphwidth \"150\"\n" +
                            "net_log \"0\"\n" +
                            "net_scale \"5\"\n" +
                            "net_showdrop \"0\"\n" +
                            "net_showpackets \"0\"\n" +
                            "new // Coemienza un nuevo jeugo de un solo jugador\n" +
                            "noclip // Si está activado, los jugadores pueden atravesar objetos - *1  es 'activado', 0 es 'desactivado',y 'sv_cheats' debe estar en 1\n" +
                            "nosound \"0\" // alterna el sonido - * 1  es 'activado', 0 es 'desactivado\n" +
                            "notarget // Hace que los jugadores te ignoren - * 'sv_cheats' debe estar en 1\n" +
                            "password \"0\" // Establece la contraseña de un servidor privado\n" +
                            "pausable \"1\" // Alterna el pausar el juego pr los clientes - 1  es 'activado', 0 es 'desactivado'\n" +
                            "pause // Pausa el juego\n" +
                            "ping // Muestra el ping de todos los clientes\n" +
                            "pingservers // Muestra el ping de los servidores en la lista de servidores\n" +
                            "play // Reproduce un archivo .wav de nombre <filename>\n" +
                            "playdemo // reproduce <filename>.dem a la velocidad normal\n" +
                            "playvol // Establece el volumen de la reproducción del demo\n" +
                            "pointfile // Carga los <filename>.pts del mapa\n" +
                            "port \"27015\" // Establece el puerto de conección default del servidor\n" +
                            "ppdemostart\n" +
                            "quit // Sale a windows sin confirmación\n" +
                            "rate \"30000\" // Establece el envío de datos del cliente - * \n" +
                            "rcon // Control remoto de la consola de un servidor - * <password> debe ser dada primero antes de que el servidor acepte algún comando\n" +
                            "rcon_password \"0\" // Establece la contrasea rcon\n" +
                            "rcon_port \"0\" // Establece el puerto rcon en la consola\n" +
                            "reconnect // Reconecta con el servidor actual\n" +
                            "record // Graba una demo y lo guarda en Half-Life/Valve/<filename>.dem\n" +
                            "reload // Recarga el mapa actual\n" +
                            "removedemo // Remueve un segmento <sgmt> de <demo>\n" +
                            "removeid // Borra una id única de ser baneada en un servidor - **Solo Version 3.0.1.3 / 4.0.1.3+ \n" +
                            "removeip // Remueve la direcci´ñon ip de la lista de filtros de ban\n" +
                            "resetrcon\n" +
                            "restart // Reinicia el mapa actual y borra la pizarra\n" +
                            "retry // Trata de conectar or más veces a un servidor que falló en la primera conexión\n" +
                            "room_delay \"0\" // Configuración de sonidos 3D\n" +
                            "room_dlylp \"2\" // 3Configuración de sonidos 3D\n" +
                            "room_feedback \"0\" // Configuración de sonidos 3D\n" +
                            "room_left \"0\" // Configuración de sonidos 3D\n" +
                            "room_lp \"0\" // Configuración de sonidos 3D\n" +
                            "room_mod \"0\" // Configuración de sonidos 3D\n" +
                            "room_off \"0\" // Configuración de sonidos 3D\n" +
                            "room_refl \"0\" // Configuración de sonidos 3D\n" +
                            "room_rvblp \"1\" // Configuración de sonidos 3D\n" +
                            "room_size \"0\" // Configuración de sonidos 3D\n" +
                            "room_type \"0\" // Configuración de sonidos 3D\n" +
                            "r_bmodelhighfrac \"5\"\n" +
                            "r_bmodelinterp \"1\"\n" +
                            "r_cachestudio \"1\"\n" +
                            "r_cullsequencebox \"1\"\n" +
                            "r_decals \"4096\" // Establece el número máximo de calcos\n" +
                            "r_detailtextures \"0\"\n" +
                            "r_detailtexturessupported \"1\"\n" +
                            "r_drawentities \"1\" // Alterna el dibujar a los jugadores y sprites - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_drawviewmodel \"1\" // Alterna el mostrar las armas- * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_dynamic \"1\" // Alterna las luces dinámicas - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_fullbright \"0\" // Alterna el brillo máximo solo en juegos locales - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_glowshellfreq \"2.200\"\n" +
                            "r_lightmap \"0\" // Solo en renderizador software - * Muestra 1 de 4 (0,1,2,3) posibles mapas de luz para ver el rango de luces activadas\n" +
                            "r_mirroralpha \"1\" //Alterna las texturas reflectivas - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_mmx \"0\" // Alterna los cálculos MMx para MMX cpu's - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_norefresh \"0\" // Alterna la limpieza de HUD y consola antes de redibujar - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_novis \"0\" // Alterna el mostrar los polígonos bajo el agua - * 1  es 'activado', 0 es 'desactivado', 'r_wateralpha' debe estar en 1\n" +
                            "r_speeds \"0\" // Alterna los fps promedio,velocidad de dibujado e información de los polígonos - * 1  es 'activado', 0 es 'desactivado', útil al crear mapas\n" +
                            "r_traceglow \"0\" // Alterna la inclusión de monstruos en la verificación de sprites brillantes - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "r_wadtextures \"0\"\n" +
                            "r_wateralpha \"1\" // Alterna la mezcla de transparenciasa bajo el agua - * 1  es 'activado', 0 es 'desactivado'', 'r_novis' debe estar activado\n" +
                            "save // Guarda el juego actual\n" +
                            "say // Chatea con todos los jugadores en un servidor\n" +
                            "say_team // Muestra un mensaje a solo los miembros de equipo\n" +
                            "screenshot // Captura la pantalla y la guarda en el directorio Half-Life/Valve \n" +
                            "scr_centertime \"2\" // Establece por cuánto tiempo los mensajes del servidor permancen en pantalla\n" +
                            "scr_connectmsg \"0\" // Muestra los mensajes en la esquina superior izquierda\n" +
                            "scr_connectmsg1 \"0\" // Muestra los mensajes 1 en la esquina superior izquierda\n" +
                            "scr_connectmsg2 \"0\" // Muestra los mensajes 2 en la esquina superior izquierda\n" +
                            "scr_conspeed \"600\" // Establece la velocidad de deslizamiento de la consola\n" +
                            "scr_ofsx \"0\" // Establece la desviación de los mensajes en pantalla\n" +
                            "scr_ofsy \"0\" // Establece la desviación de los mensajes en pantalla\n" +
                            "scr_ofsz \"0\" // Establece la desviación de los mensajes en pantalla\n" +
                            "scr_printspeed \"8\" // Establece la velocidad de impresión de los mensajes en pantalla\n" +
                            "sendents\n" +
                            "sendres\n" +
                            "sensitivity \"3\" // Establece la sensibilidad del mouse\n" +
                            "servercfgfile \"0\" // Establece el archivo de configuración del servidor * lo default es server.cfg\n" +
                            "serverinfo // Muestra la información del servidor\n" +
                            "setdemoinfo // Añade nformación a la demo, como el título\n" +
                            "setinfo // Establece la ID del clan de TFC\n" +
                            "setmaster // Establece el servidor maestro - * Usa una ip o un nombre de host\n" +
                            "setpause\n" +
                            "showinfo // Alterna el muestreo de todos los paquetes - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "showpause \"1\" // toggles pause of graphic display - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "shutdownserver\n" +
                            "sizedown // Reduce el tamaño de la pantalla e incrementa los fps\n" +
                            "sizeup // Incremeneta el tamaño de la pantalla y reduce los fps\n" +
                            "skill \"1\" // Establece la dificultad en un juego individual o cooperativo\n" +
                            "skin \"0\" // Establece el skin del modelo\n" +
                            "slist // Busca servidores locales - * Usa \"list\" para mostrar la lista\n" +
                            "slot1 // Grupo de armas 1\n" +
                            "slot10 // Grupo de armas 10\n" +
                            "slot2 // Grupo de armas 2\n" +
                            "slot3 // Grupo de armas 3\n" +
                            "slot4 // Grupo de armas 4\n" +
                            "slot5 // Grupo de armas 5\n" +
                            "slot6 // Grupo de armas 6\n" +
                            "slot7 // Grupo de armas 7\n" +
                            "slot8 // Grupo de armas 8\n" +
                            "slot9 // Grupo de armas 9\n" +
                            "snapshot // Toma una captura de pantalla\n" +
                            "snapto\n" +
                            "snd_noextraupdate \"0\" // Alterna las actualizaciones de sonidos extras - * 1  es 'activado'y solo se usa si tiene problemas, 0 es 'desactivado'\n" +
                            "snd_show \"0\" // Alterna el muestreo de qué sonidos estás siendo reproducidos - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "soundfade // Establece los parámetros de desvanecimiento de sonido - *<param> = <%><hold>[<out><in>]\n" +
                            "soundinfo // Muestra el número de canales estéreo, muestras, samplebits, velocidad DMA, y canales de sonido\n" +
                            "soundlist // Muestra una lista de todos los sonidos cargados\n" +
                            "spawn // Spawnea a un jugador en la partida\n" +
                            "speak // Dice algo en el intercomunicador - * Prueba : hello, #000000, mesa, you, go alert\n" +
                            "special // Muestra el menú especial para cada clase\n" +
                            "spec_autodirector \"1\"\n" +
                            "spec_decal\n" +
                            "spec_drawcone \"1\"\n" +
                            "spec_drawnames \"1\"\n" +
                            "spec_drawstatus \"1\"\n" +
                            "spec_help\n" +
                            "spec_menu\n" +
                            "spec_mode\n" +
                            "spec_pip \"1\"\n" +
                            "spec_pos\n" +
                            "spk\n" +
                            "startdemos // Comienza la reproducción en bucle de demos\n" +
                            "startmovie // Reproduce un película\n" +
                            "stat\n" +
                            "stats\n" +
                            "status // Crea una lista del cliente y la siguiente información de ellos: usuario#, frags, nombre, framerate, latencia, ping, paquetes perdidos %\n" +
                            "stop // Pausa la grabación de una demo\n" +
                            "stopdemo // Pausa la reproducción de una demo\n" +
                            "stopsound // Detiene la reproducción de sonido\n" +
                            "stuffcmds // Usado para inicialiar los comandos del servidor y lo reinicia\n" +
                            "suitvolume \"0.250\" // Establece el volumen para el traje HEV\n" +
                            "sv_accelerate \"10\" // Establece la aceleración del jugador en un servidor\n" +
                            "sv_aim \"1\" // Alterna el autoapuntado para los clientes - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_airaccelerate \"10\" // Establece la velocidad del jugador en el aire\n" +
                            "sv_airmove \"1\" // Alterna la habilidad de los clientes para mmoverse en el aire\n" +
                            "sv_allowdownload \"1\" // Alterna la habilidad de los clientes para descargar modelos y grafitis- * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_allowupload \"1\" // Alterna la habilidad de los clientes para subir modelos y grafitis - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_bounce \"1\" // Alterna las plataformas de rebote - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_cheats \"0\" // Alterna el uso de cheats - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_clienttrace \"1\" // Establece el delimitador de colisiones de los clientes\n" +
                            "sv_clipmode \"0\" // Alterna el estado de \"cliping\" de los clientes - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_contact \"0\"\n" +
                            "sv_downloadurl \"0\"\n" +
                            "sv_enableoldqueries \"0\"\n" +
                            "sv_failuretime \"0.500\"\n" +
                            "sv_filetransfercompression \"1\"\n" +
                            "sv_filterban \"1\"\n" +
                            "sv_friction \"4\" // Establece la fricción\n" +
                            "sv_gravity \"800\" // Establece la cantidad de gravedad\n" +
                            "sv_instancedbaseline \"1\"\n" +
                            "sv_lan \"1\" // Alterna el modo LAN - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "sv_lan_rate \"20000\"\n" +
                            "sv_logbans \"0\"\n" +
                            "sv_logblocks \"0\"\n" +
                            "sv_logrelay \"0\"\n" +
                            "sv_log_onefile \"0\"\n" +
                            "sv_log_singleplayer \"0\"\n" +
                            "sv_maxrate \"0\" // Establece el máximo valor de subidad de datos de un servidor - Bueno para servidores HPB - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "sv_maxspeed \"320\" // Establece la máxima velocidad para los clientes\n" +
                            "sv_maxunlag \"0.500\"\n" +
                            "sv_maxupdaterate \"30\"\n" +
                            "sv_maxvelocity \"2000\" // Establece la máxima velocidad\n" +
                            "sv_minrate \"0\" // Establece la cantidad mínima dedatos subidos de un servidor - Bueno para servisores LPB - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "sv_minupdaterate \"10\"\n" +
                            "sv_newunit \"0\"\n" +
                            "sv_outofdatetime \"1800\"\n" +
                            "sv_password \"0\" // Establece una contraseña para el servidor\n" +
                            "sv_proxies \"1\"\n" +
                            "sv_rcon_banpenalty \"0\"\n" +
                            "sv_rcon_maxfailures \"10\"\n" +
                            "sv_rcon_minfailures \"5\"\n" +
                            "sv_rcon_minfailuretime \"30\"\n" +
                            "sv_region \"-1\"\n" +
                            "sv_send_logos \"1\"\n" +
                            "sv_send_resources \"1\"\n" +
                            "sv_skycolor_b \"0\"\n" +
                            "sv_skycolor_g \"0\"\n" +
                            "sv_skycolor_r \"0\"\n" +
                            "sv_skyname \"0\" // Establece la textura del cielo\n" +
                            "sv_skyvec_x \"0\"\n" +
                            "sv_skyvec_y \"0\"\n" +
                            "sv_skyvec_z \"0\"\n" +
                            "sv_spectatormaxspeed \"500\" // Establece la velocidad máxima de los espectadores \n" +
                            "sv_stats \"1\"\n" +
                            "sv_stepsize \"18\" // establece el tamaño de aumento automático del monstruo y el jugador  - * Los valores más grandes permiten la escalada automática de pendientes más pronunciadas. \n" +
                            "sv_stopspeed \"100\" // Velocidad a la que los jugadores se detienen al correr\n" +
                            "sv_timeout \"60\" // EStalece el tiempo límite de inactividad\n" +
                            "sv_unlag \"1\"\n" +
                            "sv_unlagpush \"0\"\n" +
                            "sv_unlagsamples \"1\"\n" +
                            "sv_uploadmax \"0.500\"\n" +
                            "sv_version \"112.100\"\n" +
                            "sv_visiblemaxplayers \"-1\"\n" +
                            "sv_voicecodec \"0\"\n" +
                            "sv_voiceenable \"1\"\n" +
                            "sv_voicequality \"3\"\n" +
                            "sv_wateraccelerate \"10\" // Establece la acelaración de los clientes en el agua\n" +
                            "sv_wateramp \"0\"\n" +
                            "sv_waterfriction \"1\" // Establece la fricción bajo el agua\n" +
                            "sv_zmax \"4096\" // EStablece el tamaño máximo del zbuffer\n" +
                            "swapdemo // Intercambi dos segmento' posiciónes en una demo\n" +
                            "sys_ticrate \"100\"\n" +
                            "s_2dvolume \"0.880\" // Volumen máximo de los sonidos 2D - * Rango de 0 a 1.0\n" +
                            "s_a3d \"0\" // Alterna el soporte de A3D - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "s_automax_distance \"30\" // Establece la distancia para el volumen de sonido máximo\n" +
                            "s_automin_distance \"2\" // Establece la distancia para el volumen de sonido mínimo\n" +
                            "s_blipdir \"0\"\n" +
                            "s_bloat \"2\" // factor de hinchamiento para polígonos , solo en A3D 2.0 \n" +
                            "s_buffersize \"65536\" // Establece el tamaño del buffer\n" +
                            "s_disable_a3d // Alterna el deshabilitar A3D - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "s_distance \"60\" // Ajusta el proporción de juego a mteros, afectando la velocidad, posicionamiento y distancia - * cuanto mayor es el número, más se acerca todo en términos de audio  - rango de 0 a infinito\n" +
                            "s_doppler \"0\" // Ajusta el doppler - * 1  es 'activado', 0 es 'desactivado', rango de 0 a 10, es muy sensible\n" +
                            "s_eax \"0\" // Alterna el soporte de EAX - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "s_enable_a3d // Activa el soporte de A3D\n" +
                            "s_geometry \"1\" // Alterna el renderizado geométrico en A3D 2.0 only - * 1 i1  es 'activado', 0 es 'desactivado'\n" +
                            "s_leafnum \"0\"\n" +
                            "s_materials \"0\"\n" +
                            "s_max_distance \"1000\" // Distancia máxima del oyente antes de que no se aplique el rolloff - * rango de 's_min_distance' a infinito\n" +
                            "s_min_distance \"8\" // Distancia mínima del oyente antes de que se aplique el rolloff - * rango de 0 a 's_max_distance'\n" +
                            "s_numpolys \"200\" // Número máximo de polígonos renderizados en A3D 2.0 - poner en 0 esto es como apagar 's_geometry' - * rango de 0 a infinito\n" +
                            "s_occfactor \"0.250\" // Transmisión del valor del material - Más pequeño el número, menos sonidos pasan por un material - * rango de 0 a 1.0\n" +
                            "s_occlude \"1\" // Alterna el sonido a través de los materiales (oclusión) solo en A3D 2.0 - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "s_occ_epsilon \"1\"\n" +
                            "s_polykeep \"1000000000\"\n" +
                            "s_polysize \"10000000\"\n" +
                            "s_refdelay \"4\" // Retraso entre una fuente y su reflejo solo para A3D 2.0  - Más alto el retraso, más tiempo toma la reporducción entre la emisión y el reflejo - * rango de 0 a 100\n" +
                            "s_refgain \"0.400\" // Ajusta la ganancia con cada reflejo solo para A3D 2.0, donde los efectos de distancia se incrementan: Las altas frecencias son filtradas y el volumen, reducido - * rango de 0 a 10\n" +
                            "s_reflect \"1\"\n" +
                            "s_reverb \"1\"\n" +
                            "s_rolloff \"1\"\n" +
                            "s_show \"0\"\n" +
                            "s_showtossed \"0\"\n" +
                            "s_usepvs \"1\"\n" +
                            "s_verbwet \"0.250\" // Controla la reverberación para A3D - Más alto el número, sonidos más húmedos - * rango de 0 a 1.0\n" +
                            "team \"0\" // Alterna el modo de equipos - * 1  es 'activado', 0 es 'desactivado\n" +
                            "tell // Dice un mensjae\n" +
                            "texgamma \"2\" // Posiblemente establezca la gamma de los textos\n" +
                            "tfc_newmodels \"1\"\n" +
                            "thirdperson // Activa la vista en tercera persona\n" +
                            "timedemo // Reporoduce <demoname>.dem a los máximos fps y reporta el promedio\n" +
                            "timerefresh // El jugador gira en el mismo lugar y se reporta el promedio de fps al girar\n" +
                            "togglebrowser\n" +
                            "toggleconsole // Alterna la consola - * Usualmente bindeado a '~'\n" +
                            "togglescores\n" +
                            "topcolor \"30\" // Establece el color superior del modelo\n" +
                            "traceralpha \"0.500\" // Establece el componente de transparencia del rastro de la bala\n" +
                            "tracerblue \"0.400\" // Establece el componente azul del rastro de la bala\n" +
                            "tracergreen \"0.800\" // Establece el componente verde del rastro de la bala\n" +
                            "tracerlength \"0.800\" // Establece el largo del rastro de la bala\n" +
                            "traceroffset \"30\" // Establece la desviación del rastro de la bala\n" +
                            "tracerred \"0.800\" // Establece el componente rojo del rastro de la bala\n" +
                            "tracerspeed \"6000\" // Establece la velocidad del rastro de la bala\n" +
                            "unbind // Remueve un bind de la tecla <key>\n" +
                            "unbindall // Remueve todos los binds\n" +
                            "unpause\n" +
                            "upload // Sube archivos a un servidor\n" +
                            "user // Crea una lista del modelos, color, nombre y rate or usuario\n" +
                            "users // Crea una lista de los jugadores con su ID correspondiente (#'s generado por el servidor) r Id únicas (id # único por clave de CD asignado por WON) - **Solo Version 3.0.1.3/4.0.1.3+ \n" +
                            "version // Muestra la versión y la fecha de instalación\n" +
                            "vgui_emulatemouse \"0\"\n" +
                            "vgui_runscript\n" +
                            "vid_d3d \"0\" // Alterna el soporte de Direct 3D - * Activa los de cuerpos al morir - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "viewdemo\n" +
                            "viewframe // Activa el mostrar la escritura en los cuadros - * OpenGL only\n" +
                            "viewmodel // Activa la vista de los modelos\n" +
                            "viewnext // Selecciona el modelo siguiente\n" +
                            "viewprev // Selecciona el modelo previo\n" +
                            "viewsize \"120\" // sets view size\n" +
                            "violence_ablood \"0\" // Activa la sangre - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "violence_agibs \"0\" // Activa los de cuerpos al morir - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "violence_hblood \"0\"\n" +
                            "violence_hgibs \"0\" // Activa los de cuerpos al morir - * 1  es 'activado', 0 es 'desactivado'\n" +
                            "voice_avggain \"0.500\"\n" +
                            "voice_clientdebug \"0\"\n" +
                            "voice_dsound \"1\"\n" +
                            "voice_eax \"0\"\n" +
                            "voice_enable \"1\"\n" +
                            "voice_fadeouttime \"0.100\"\n" +
                            "voice_forcemicrecord \"1\"\n" +
                            "voice_inputfromfile \"0\"\n" +
                            "voice_loopback \"0\"\n" +
                            "voice_maxgain \"5\"\n" +
                            "voice_modenable \"1\"\n" +
                            "voice_overdrive \"2\"\n" +
                            "voice_overdrivefadetime \"0.400\"\n" +
                            "voice_profile \"0\"\n" +
                            "voice_recordtofile \"0\"\n" +
                            "voice_scale \"1\"\n" +
                            "voice_showbanned\n" +
                            "voice_showchannels \"0\"\n" +
                            "voice_showincoming \"0\"\n" +
                            "volume \"0.800\" // Establece el volumen del juego\n" +
                            "v_centermove \"0.150\"\n" +
                            "v_centerspeed \"500\"\n" +
                            "v_dark \"0\"\n" +
                            "wait // Detiene las acciones por 1 tick \n" +
                            "waterroom_type \"14\"\n" +
                            "waveplaylen\n" +
                            "writecfg\n" +
                            "writeid // Escribe IDs únicas a banned.cfg - **Version 3.0.1.3/4.0.1.3+ only\n" +
                            "writeip // Escribe direcciones IP a listip.cfg\n" +
                            "zoom_sensitivity_ratio \"1.200\" // Establece la sensibilidad del mouse al usar el zoom de un arma\n" +
                            "_careeraudio\n" +
                            "_restart\n" +
                            "_setgamedir\n" +
                            "_setrenderer\n" +
                            "_setvideomode\n" +
                            "_snd_mixahead \"0.100\"\n" +
                            "\n" +
                            "\n" +
                            "//Decentjump\n" +
                            "Si encuentras difícil hacer bunny hop, o tu coordinación de saltos está mal, Este script b´sico te ayudará a corregir tus saltos.\n" +
                            "Para usar, reemplaza la tecla +jump con +decentjump.\n" +
                            "\n" +
                            "//Bunnyhop\n" +
                            "A veces llamado auto-bhop, este script hace el bunear muy simple. Cuando presionas la tecla +bunnyhop te quedarás saltando hasta que sueltes la tecla. \n" +
                            "Para usar, reemplaza la tecla +jump con +bunnyhop.\n" +
                            "\n" +
                            "//Double-duck (box jump / climbing)\n" +
                            "¿Alguna vez te preguntaste cómo hay jugadores que suben cajas a gran velocidad? Es como si estuvieran usando el scrit del climbing. Funciona agachándose, luego rápidamente dejándose de agachar y luego agachándose otra vez, en conjunto resulta en una pequeña elevación sobre el suelo.\n" +
                            "Para usar, asigna unatecla a +box.\n" +
                            "\n" +
                            "//Long Jump\n" +
                            "Muchos jugadores usan un script de long jump, simplifica agacharse y saltar en una sola tecla. Sin embargo, hay 4 diferentes animaciones, 3 de las cuales solo ocurrirán con el uso de un script. Por esta razón recomiendo usar la animación por defecto.\n" +
                            "Para usar, asigna una tecla a +longjump (nota: Tienes que presionar una tecla de movimiento al hacer el script para que funcione).\n" +
                            "\n" +
                            "//Silent Long Jump\n" +
                            "Este script es esencialmente un long jump pero con un salto más corto y sin producir ningún sonido. Tendrás que copiar y pegar el script 'wait' en tu .cfg para usar esto.\n" +
                            "Para usar, asigna una tecla a +silent_lj (nota: debe realizarse desde un punto muerto después de tocar hacia atrás ).\n" +
                            "\n" +
                            "//Walking/Sneaking\n" +
                            "ES un script muy últil en HLDM:AG porque te permite caminar sin hacer ruido.\n" +
                            "Para usar, asigna una tecla a +walk (puedes reemplazar la tecla de +speed a +walk).\n" +
                            "\n" +
                            "//Quick Bow / flecha rápida\n" +
                            "Posiblemente el script más controversial es el script de la ballesta. Funciona haciendo zoom, disparando, y por último cambiar de arma rápidamente a la crossbow, casi instantáneamente.\n" +
                            "Para usar, asigna una tecla a +quickbow.\n" +
                            "\n" +
                            "//Impulse Gauss\n" +
                            "Puede ser usado al moverse o al estar quieto. Debes mantener presionad la tecla de +gauss_jump, saltar, Mirar en la drección que quieres ir soltar la tecla. Luego serás impulsado a la dirección que miraste.\n" +
                            "Para usar, asigna una tecla a +gauss_jump.\n" +
                            "\n" +
                            "//Low Sens\n" +
                            "Si deseas bajar tu sensibilidad al apuntar a larga distancia, por ejemplo, para mejorar tu puntería - ese es el propósito de este script. Neccesitarás configurar tu sensibilidad poor defecto y la nueva sensibilidad.\n" +
                            "Para usar, asigna una tecla a +lowsens y mantenla presionada para ejecutarlo - una vez soltada, regresarás a tu sensibilidad normal.\n" +
                            "\n" +
                            "//Waits\n" +
                            "Si deseas agregar tiempos de espera más grandes entre comandos o al ejecutar un script, este te da una variedad de dónde escoger. Por ejemplo, si necesitas para por 6 frames, simplemente añades wait 2 y wait 4 juntos en un script, así: +attack;wait2;wait4;+reload. Nota: algunos scripts requieren de este script para funcionar, por lo que es reconmendable que lo agregues a tu .cfg. \n" +
                            "\n" +
                            "//Recharging\n" +
                            "Este script es útil para hacer saber a tus compañeros de equipo que estás en un cargador de vida/HEV.\n" +
                            "PUedes eemplazar la tecla +use coh +use2 o asisgnar una nueva tecla a +use2.\n" +
                            "\n" +
                            "//Drop Weapon\n" +
                            "Si necesitas captar la atención de un compañero de equipo puedes dropearle un arma, este script les dará un arma, dejará un mensaje y hará un sonido. Si quieres dropear un arma específica (por ejemplo, shotgun), puedes reemplazar drop con drop weapon_shotgun.\n" +
                            "Para usar, asigna una tecla a drop_team.\n" +
                            "\n" +
                            "//Realnames\n" +
                            "Un poco conocido script que hace uso de los comandos loadauthid y unloadauthid que son exclusivos de HLDM:AG. Al presionar la tecla de +realnames verás los nombres reales de los jugadores mostrados en el socreboard. Para que esto funcione debes tener el archivo realnames.txt dentro de common\\Half-Life\\ag folder. \n" +
                            "Para usar, asigna una tecla a +realnames.\n" +
                            "\n" +
                            "//Demo Recorder\n" +
                            "Este script utiliza \"agrecord\", perimitiendo grabar individualmente cada demo dentro de tu carpeta ag. También toma automáticamente una captura de pantalla al terminar la demo.\n" +
                            "Para usar, asigna una tecla a demo_record.\n" +
                            "\n" +
                            "//Name Change Toggle\n" +
                            "Este script simplifica las cosas si utilizas varios nicknames en el juego. Te permite asignar una tecla para alternar entre diferentes nicknames. \n" +
                            "Para usar, asigna una tecla a y reemplaza <nickname> con tus propios nicknames.\n\n"
                            + "//Quick Use\n"
                            + "Un simple script que ejcuta \"+use\" por un frame sin reducir tu velocidad. Ideal para presionar botones cuando estás buneando.\n"
                            + "Use bind <tecla> quse");
                        comandos.close();
                        documentacion = new File("Documentación.txt");
                        Desktop.getDesktop().open(documentacion);
                        
                } catch (IOException ex) {}
        }
        
        
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        
        imagen = new TeclasBinds();
        
        
    }//GEN-LAST:event_jButton2MouseReleased

    private String verificadorColor1(CustomTextPane campoTexto) {
        String CadenaFinal = campoTexto.getText();
        StyledDocument doc = campoTexto.getStyledDocument();    
        
        int simbolosAñadidos = 0;
        
        Color color;
        boolean Pintado = false;
        String colors[] = {"^0", "^1", "^2", "^3", "^4", "^5", "^6", "^7", "^8"};

        for(int i = 0; i < campoTexto.getText().length(); i++) {
            
            Element element = doc.getCharacterElement(i);
            color = doc.getForeground(element.getAttributes());
            
            if(!color.equals(new java.awt.Color(255, 179, 0))) {   
                Pintado = true;
                break;  
            }
        }
        
        if(Pintado) {
            
            if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 179, 0))) {
                
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 0, 0))) {
                CadenaFinal = colors[1] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(0, 255, 0))) {
                CadenaFinal = colors[2] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 255, 0))) {
                CadenaFinal = colors[3] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(0, 0, 255))) {
                CadenaFinal = colors[4] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(0, 255, 255))) {
                CadenaFinal = colors[5] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 0, 255))) {
                CadenaFinal = colors[6] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(137, 137, 137))) {
                CadenaFinal = colors[7] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 255, 255))) {
                CadenaFinal = colors[8] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }
            
            for(int i = 0; i < (campoTexto.getText().length() - 1); i++) {
                Element element = doc.getCharacterElement(i);
                color = doc.getForeground(element.getAttributes());
                if(!color.equals(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()))) {
                    if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 179, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[0] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 0, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[1] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(0, 255, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[2] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 255, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[3] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(0, 0, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[4] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(0, 255, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[5] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 0, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[6] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(137, 137, 137))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[7] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 255, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[8] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   
                }
            }
            
            if(!doc.getForeground(doc.getCharacterElement(campoTexto.getText().length() -1 ).getAttributes()).equals(new java.awt.Color(255, 179, 0))) {
                CadenaFinal = CadenaFinal + "^0";
            }
            
            
        }   else {
            CadenaFinal = campoTexto.getText();
        }
        
        
        
        return CadenaFinal;
    }
    
    private String verificadorColor2(CampoNombrePrincipal campoTexto) {
        
        String CadenaFinal = campoTexto.getText();
        StyledDocument doc = campoTexto.getStyledDocument();    
        
        int simbolosAñadidos = 0;
        
        Color color;
        boolean Pintado = false;
        String colors[] = {"^0", "^1", "^2", "^3", "^4", "^5", "^6", "^7", "^8"};

        for(int i = 0; i < campoTexto.getText().length(); i++) {
            
            Element element = doc.getCharacterElement(i);
            color = doc.getForeground(element.getAttributes());
            
            if(!color.equals(new java.awt.Color(255, 179, 0))) {   
                Pintado = true;
                break;  
            }
        }
        
        if(Pintado) {
            
            if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 179, 0))) {
                
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 0, 0))) {
                CadenaFinal = colors[1] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(0, 255, 0))) {
                CadenaFinal = colors[2] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 255, 0))) {
                CadenaFinal = colors[3] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(0, 0, 255))) {
                CadenaFinal = colors[4] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(0, 255, 255))) {
                CadenaFinal = colors[5] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 0, 255))) {
                CadenaFinal = colors[6] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(137, 137, 137))) {
                CadenaFinal = colors[7] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }   else if(doc.getForeground(doc.getCharacterElement(0).getAttributes()).equals(new java.awt.Color(255, 255, 255))) {
                CadenaFinal = colors[8] + CadenaFinal.substring(0);
                simbolosAñadidos += 2;
            }
            
            for(int i = 0; i < (campoTexto.getText().length() - 1); i++) {
                Element element = doc.getCharacterElement(i);
                color = doc.getForeground(element.getAttributes());
                if(!color.equals(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()))) {
                    if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 179, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[0] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 0, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[1] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(0, 255, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[2] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 255, 0))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[3] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(0, 0, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[4] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(0, 255, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[5] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 0, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[6] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(137, 137, 137))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[7] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   else if(doc.getForeground(doc.getCharacterElement(i+1).getAttributes()).equals(new java.awt.Color(255, 255, 255))) {
                        CadenaFinal = CadenaFinal.substring(0, i+1+simbolosAñadidos) + colors[8] + CadenaFinal.substring(i+1+simbolosAñadidos);
                        simbolosAñadidos += 2;
                    }   
                }
            }
            
            if(!doc.getForeground(doc.getCharacterElement(campoTexto.getText().length() -1 ).getAttributes()).equals(new java.awt.Color(255, 179, 0))) {
                CadenaFinal = CadenaFinal + "^0";
            }
            
            
        }   else {
            CadenaFinal = campoTexto.getText();
        }
        
        
        
        return CadenaFinal;
    }
    
    private void crearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMouseClicked
        try {
            // Recolección de datos
            
            config.write("//\n" +
            "//\n" +
            "//\t\t\t**************************************************\n" +
            "//\t\t\t**						**\n" +
            "//\t\t\t**		C O N F I G			**\n" +
            "//\t\t\t**		  G E N E R A T O R		**\n" +
            "//\t\t\t**		     				**\n" +
            "//\t\t\t**		    By LeonN			**\n" +
            "//\t\t\t**						**\n" +
            "//\t\t\t**						**\n" +
            "//\t\t\t**************************************************\n" +
            "//\n" +
            "//");
            
            
            // Nombres
            if(NombrePrincipal.getText().isBlank() && numeroTextFields == 1 && campo1.getText().isEmpty()) {}
                else {
                    config.write("\n\n//\n" +
                    "//\n" +
                    "//\t\tN A M E S\n" +
                    "//\t\t*********\n" +
                    "//\n" +
                    "//\n" +
                    "//\n\n");

                    if(!NombrePrincipal.getText().isBlank()) {
                        config.write("name\t\"" + verificadorColor2(NombrePrincipal)+ "\"\n\n");
                        
                    }
                    
                    if(!campo1.getText().isBlank()) {
                        
                        config.write("alias\t\"names\"\t\t\"nick1\"\n");
                        for(int contador = 0; contador < arrayNombresOpc.size(); contador++) {
                            config.write("alias\t\"nick" + (contador+1) + "\"\t\t\"alias names nick" + (contador+2) + "; name " + verificadorColor1(arrayNombresOpc.get(contador)) + "\"\n");
                        }
                        config.write("alias\t\"nick" + (arrayNombresOpc.size()+1) + "\"\t\t\"alias names nick1; name " + verificadorColor2(NombrePrincipal) + "\"");
                        config.write("\n\nbind\t\"" + jTextField2.getText() + "\"\t\t\"names\"");
                    }
                    
                }

            
            //Armas
            
            if(Armas.jTextField1.getText().isBlank() && Armas.jTextField2.getText().isBlank() && Armas.jTextField3.getText().isBlank() &&
                    Armas.jTextField4.getText().isBlank() && Armas.jTextField5.getText().isBlank() && Armas.jTextField6.getText().isBlank() &&
                    Armas.jTextField7.getText().isBlank() && Armas.jTextField8.getText().isBlank() && Armas.jTextField9.getText().isBlank() &&
                    Armas.jTextField10.getText().isBlank() && Armas.jTextField11.getText().isBlank() && Armas.jTextField12.getText().isBlank() &&
                    Armas.jTextField13.getText().isBlank() && Armas.jTextField14.getText().isBlank()) {}
                else {
                config.write("\n\n"
                        + "//\n" +
                        "//\n" +
                        "//\t\tW E A P O N S\n" +
                        "//\t\t*************\n" +
                        "//\n" +
                        "//\n" +
                        "//\n\n");
                if(Armas.jTextField2.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField2.getText() + "\"\t\t\"weapon_crowbar\"\n");
                    }
                if(Armas.jTextField3.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField3.getText() + "\"\t\t\"weapon_9mmhandgun\"\n");
                    }
                if(Armas.jTextField4.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField4.getText() + "\"\t\t\"weapon_357\"\n");
                    }
                if(Armas.jTextField5.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField5.getText() + "\"\t\t\"weapon_9mmAR\"\n");
                    }
                if(Armas.jTextField6.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField6.getText() + "\"\t\t\"weapon_shotgun\"\n");
                    }
                if(Armas.jTextField7.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField7.getText() + "\"\t\t\"weapon_crossbow\"\n");
                    }
                if(Armas.jTextField8.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField8.getText() + "\"\t\t\"weapon_rpg\"\n");
                    }
                if(Armas.jTextField9.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField9.getText() + "\"\t\t\"weapon_gauss\"\n");
                    }
                if(Armas.jTextField10.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField10.getText() + "\"\t\t\"weapon_egon\"\n");
                    }
                if(Armas.jTextField11.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField11.getText() + "\"\t\t\"weapon_hornetgun\"\n");
                    }
                if(Armas.jTextField12.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField12.getText() + "\"\t\t\"weapon_handgrenade\"\n");
                    }
                if(Armas.jTextField13.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField13.getText() + "\"\t\t\"weapon_satchel\"\n");
                    }
                if(Armas.jTextField14.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField14.getText() + "\"\t\t\"weapon_tripmine\"\n");
                    }
                if(Armas.jTextField1.getText().isBlank()) {}
                    else {
                        config.write("bind\t\"" + Armas.jTextField1.getText() + "\"\t\t\"weapon_snarks\"\n");
                    }
            }
            
            //Slots
            if(Armas.jTextField15.getText().isBlank() && Armas.jTextField16.getText().isBlank() && Armas.jTextField17.getText().isBlank() &&
                    Armas.jTextField18.getText().isBlank() && Armas.jTextField19.getText().isBlank() && Armas.jTextField20.getText().isBlank() &&
                    Armas.jTextField21.getText().isBlank() && Armas.jTextField22.getText().isBlank() && Armas.jTextField23.getText().isBlank() &&
                    Armas.jTextField23.getText().isBlank()) {}
                else {
                    config.write("\n\n" +
                            "//\n" +
                            "//\n" +
                            "//\t\tS L O T S\n" +
                            "//\t\t*********\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n");
                    if(Armas.jTextField16.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField16.getText() + "\"\t\t\"slot1\"\n");
                        }
                    if(Armas.jTextField17.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField17.getText() + "\"\t\t\"slot2\"\n");
                        }
                    if(Armas.jTextField18.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField18.getText() + "\"\t\t\"slot3\"\n");
                        }
                    if(Armas.jTextField19.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField19.getText() + "\"\t\t\"slot4\"\n");
                        }
                    if(Armas.jTextField20.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField20.getText() + "\"\t\t\"slot5\"\n");
                        }
                    if(Armas.jTextField21.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField21.getText() + "\"\t\t\"slot6\"\n");
                        }
                    if(Armas.jTextField22.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField22.getText() + "\"\t\t\"slot7\"\n");
                        }
                    if(Armas.jTextField23.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField23.getText() + "\"\t\t\"slot8\"\n");
                        }
                    if(Armas.jTextField24.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField24.getText() + "\"\t\t\"slot9\"\n");
                        }
                    if(Armas.jTextField15.getText().isBlank()) {}
                        else {
                            config.write("bind\t\"" + Armas.jTextField15.getText() + "\"\t\t\"slot10\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton39.isSelected()) {
                        config.write("bind\t\"KP_END\"\t\t\"slot1\"\n" +
                        "bind\t\"KP_DOWNARROW\"\t\t\"slot2\"\n" +
                        "bind\t\"KP_PGDN\"\t\t\"slot3\"\n" +
                        "bind\t\"KP_LEFTARROW\"\t\t\"slot4\"\n" +
                        "bind\t\"KP_5\"\t\t\t\"slot5\"\n" +
                        "bind\t\"KP_RIGHTARROW\"\t\t\"slot6\"\n" +
                        "bind\t\"KP_HOME\"\t\t\"slot7\"\n" +
                        "bind\t\"KP_UPARROW\"\t\t\"slot8\"\n" +
                        "bind\t\"KP_PGUP\"\t\t\"slot9\"\n" +
                        "bind\t\"KP_INS\"\t\t\"slot10\"\n");
                    }
                }
            
            //Scripts
            if(Alias.jTextField7.getText().isBlank() && Alias.jTextField5.getText().isBlank() && Alias.jTextField14.getText().isBlank() &&
                Alias.jTextField8.getText().isBlank() && Alias.jTextField9.getText().isBlank() && Alias.jTextField10.getText().isBlank() &&
                Alias.jTextField11.getText().isBlank() && Alias.jCheckBox1.isSelected() == false && Alias.jTextField13.getText().isBlank() &&
                Alias.jTextField15.getText().isBlank() && Alias.jTextField16.getText().isBlank() && Alias.jTextField21.getText().isBlank() &&
                Alias.jTextField22.getText().isBlank() && Alias.jTextField17.getText().isBlank() && Alias.jTextField19.getText().isBlank()) {}
                else {
                
                    config.write("\n\n"
                            + "//\n" +
                            "//\n" +
                            "//\t\tS C R I P T S\n" +
                            "//\t\t*************\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n");
                    
                    config.write("//\tWaits\n" +
                            "//\t*****\n\n"
                            + "alias\t\"wait2\"\t\t\"wait;wait\"\n" +
                            "alias\t\"wait4\"\t\t\"wait2;wait2\"\n" +
                            "alias\t\"wait8\"\t\t\"wait4;wait4\"\n" +
                            "alias\t\"wait16\"\t\"wait8;wait8\"\n" +
                            "alias\t\"wait32\"\t\"wait16;wait16\"\n" +
                            "alias\t\"wait64\"\t\"wait32;wait32\"\n" +
                            "alias\t\"wait128\"\t\"wait64;wait64\"\n\n"); 
                    
                    if(!Alias.jTextField7.isEnabled()) {}
                        else if (Alias.jRadioButton2.isSelected() && !Alias.jTextField7.getText().isBlank()) {
                            config.write("\n//\tBunnyHop\n"
                                    + "//\t********\n\n"
                                    + "cl_autojump\t\"1\"\n"
                                    + "bind\t\"" + Alias.jTextField7.getText() + "\"\t\t\"+jump\"");
                        }   else if (Alias.jRadioButton3.isSelected() && !Alias.jTextField7.getText().isBlank()) {
                            config.write("\n//\tBunnyHop\n"
                                    + "//\t********\n\n"
                                    + "alias\t\"+bunnyhop\"\t\t\"alias _special @bunnyhop;@bunnyhop\"\n" +
                                    "alias\t\"-bunnyhop\"\t\t\"alias _special\"\n" +
                                    "alias\t\"@bunnyhop\"\t\t\"special;wait;+jump;wait;-jump\"\n"
                                    + "bind\t\"" + Alias.jTextField7.getText() + "\"\t\t\"+bunnyhop\"\n\n");
                        }
                    
                    if(Alias.jTextField5.getText().isBlank()) {}
                        else {
                            config.write("\n//\tDecent Jump\n" +
                            "//\t***********\n\n"
                            + "alias\t\"+decentjump\"\t\t\"+jump;wait;-jump;wait;+jump;wait;-jump;wait;+jump;wait;-jump;wait;+jump;wait;-jump\"\n" +
                            "alias\t\"-decentjump\"\t\t\"-jump\"\n"
                            + "bind\t\"" + Alias.jTextField5.getText() + "\"\t\t\"+decentjump\"\n\n");
                        } 
                    
                    if(Alias.jTextField14.getText().isBlank()) {}
                        else {
                            if(VerificadorIdioma) {
                                config.write("\n//\tQuick Bow\n"
                                        + "//\t*********\n\n");
                            }   else {
                                config.write("\n//\tFlecha rápida\n"
                                        + "//\t*************\n\n");
                            }
                            config.write("alias\t\"att\"\t\t\"+attack2; +attack\"\n" +
                                "alias\t\"wait2\"\t\"wait; wait\"\n" +
                                "alias\t\"noatt\"\t\"-attack; -attack2\"\n" +
                                "alias\t\"lastt\"\t\"lastinv; lastinv\"\n" +
                                "alias\t\"CF2\"\t\"att; wait; +reload; wait2; -reload; noatt; lastt\"\n" +
                                "bind\t\"" + Alias.jTextField14.getText() + "\"\t\t\"CF2\"\n\n");                     
                        }
                    
                    if(Alias.jTextField8.getText().isBlank()) {}
                        else {
                            config.write("\n//\tClimbing\n"
                                    + "//\t********\n\n"
                                    + "alias\t\"+box\"\t\t\"+duck;wait;-duck;wait;+duck\"\n" +
                                    "alias\t\"-box\"\t\t\"-duck\"\n" +
                                    "bind\t\"" + Alias.jTextField8.getText() + "\"\t\t\"+box\"\n\n");               
                        }
                    
                    if(Alias.jTextField9.getText().isBlank()) {} 
                        else {
                            config.write("\n//\tDucktap\n"
                                    + "//\t*******\n\n"
                                    + "bind\t\"" + Alias.jTextField8.getText() + "\"\t\t\"+ducktap\"\n\n");
                        }
                    
                    if(Alias.jTextField10.getText().isBlank()) {}
                        else {
                            config.write("\n//\tDuckroll\n"
                                    + "//\t********\n\n"
                                    + "alias\t\"+duckroll\"\t\t\"alias _special duckroll;duckroll\"\n" +
                                    "alias\t\"-duckroll\"\t\t\"alias _special\"\n" +
                                    "alias\t\"duckroll\"\t\t\"+duck;wait;-duck;wait;special\"\n"
                                    + "bind\t\"" + Alias.jTextField10.getText() + "\"\t\t\"+duckroll\"\n\n");
                        }
                    
                    if(Alias.jTextField11.getText().isBlank()) {}
                        else {
                            config.write("\n//\tImpulse Gauss\n"
                                    + "//\t*************\n\n"
                                    + "alias\t\"+gauss_jump\"\t\t\"weapon_gauss;wait;+attack2\"\n" +
                                    "alias\t\"-gauss_jump\"\t\t\"cl_pitchup 270;cl_pitchspeed 21500;wait;+lookup;wait;-lookup;-attack2;wait;+lookdown;wait;-lookdown;cl_pitchup 89.999\"\n" +
                                    "bind\t\"" + Alias.jTextField11.getText() + "\"\t\t\"+gauss_jump\"\n\n");
                        }
                    // Arreglado por el momento
                    if(!Alias.jCheckBox1.isSelected()) {}
                        else {
                            if("e".equals(TeamBinds.jTextField5.getText()) || "E".equals(TeamBinds.jTextField5.getText())) {
                                config.write("\n//\tQuick Use\n"
                                        + "//\t*********\n"
                                        + "alias\t\"quse\"\t\t\"-use;say_team ^8Recharging at ^7[^5%l^7]^0 ^7[^5%h^7|^5%a^7]^0;wait;+use;wait;-use\"\n"
                                        + "bind\t\"e\"\t\t\"quse\"\n\n"); 
                            }   else {
                                 config.write("\n//\tQuick Use\n"
                                        + "//\t*********\n"
                                        + "alias\t\"quse\"\t\t\"-use;wait;+use;wait;-use\"\n"
                                        + "bind\t\"e\"\t\t\"quse\"\n\n");
                            }
                        }
                    
                    if(Alias.jTextField13.getText().isBlank()) {}
                        else {
                            config.write("\n//\tLong Jump\n"
                                    + "//\t*********\n\n"
                                    + "alias\t\"+longjump\"\t\t\"+duck;wait;+jump\"\n" +
                                    "alias\t\"-longjump\"\t\t\"-jump;-duck\"\n"
                                    + "bind\t\"" + Alias.jTextField13.getText() + "\"\t\t\"+longjump\"\n\n");
                        }
                    
                    if(Alias.jTextField15.getText().isBlank()) {}
                        else {
                            config.write("\n//\tSilent Long Jump\n"
                                    + "//\t****************\n\n"
                                    + "alias\t\"+silent_lj\"\t\t\"+forward;wait;+duck;wait;+jump;wait4;-forward\"\n" +
                                    "alias\t\"-silent_lj\"\t\t\"-jump;-duck;wait;+back;wait8;wait2;-back\"\n" +
                                    "bind\t\"" + Alias.jTextField15.getText() + "\"\t\t\"+silent_lj\"\n\n");
                        }
                    
                    if(Alias.jTextField16.getText().isBlank()) {}
                        else {
                            config.write("\n//\tSneaking\n"
                                    + "\n//\t********\n\n"
                                    + "alias\t\"+walk\"\t\t\"+speed;cl_forwardspeed 400;cl_sidespeed 400;cl_backspeed 400\"\n" +
                                    "alias\t\"-walk\"\t\t\"-speed;cl_forwardspeed 500;cl_sidespeed 500;cl_backspeed 500\"\n" +
                                    "alias\t\"gaitchange\"\t\t\"gait_walk\"\n" +
                                    "alias\t\"gait_walk\"\t\t\"alias gaitchange gait_run;wait;+walk\"\n" +
                                    "alias\t\"gait_run\"\t\t\"alias gaitchange gait_walk;wait;-Walk\"\n" +
                                    "\n" +
                                    "bind\t\"" + Alias.jTextField16.getText() + "\"\t\t\"+walk\"\n\n");
                        }
                    
                    if(Alias.jTextField21.getText().isBlank()) {}
                        else {
                            config.write("\n//\tRealnames\n"
                                    + "//\t*********\n\n"
                                    + "alias\t\"+realnames\"\t\t\"loadauthid;+showscores\"\n" +
                                        "alias\t\"-realnames\"\t\t\"unloadauthid;-showscores\"\n" +
                                        "bind\t\"" + Alias.jTextField21.getText() + "\"\t\t\"+realnames\"\n\n");
                        }
                    
                    if(Alias.jTextField22.getText().isBlank()) {}
                        else {
                            config.write("\n//\tDemo Recorder\n"
                                    + "//\t*************\n\n"
                                    + "alias\t\"rec\"\t\"demo_record\"\n" +
                                    "alias\t\"demo_record\"\t\t\"agrecord AGdemo; alias rec demo_stop\"\n" +
                                    "alias\t\"demo_stop\"\t\t\"stop;+showscores;wait;snapshot;wait;-showscores; alias rec demo_record\"\n" +
                                    "bind\t\"" + Alias.jTextField22.getText() + "\"\t\t\"rec\"\n\n");
                        }
                    
                    if(Alias.jTextField17.getText().isBlank() || Alias.jTextField19.getText().isBlank() || ComandosHL.jTextField2.getText().isBlank()) {}
                        else {
                            config.write("\n//\tLow Sensitivity\n"
                                    + "//\t***************\n\n"
                                    + "alias\t\"+lowsens\"\t\t\"sensitivity " + Alias.jTextField17.getText() + "\"\n" +
                                    "alias\t\"-lowsens\"\t\t\"sensitivity " + ComandosHL.jTextField2.getText() + "\""
                                    + "bind\t\"" + Alias.jTextField19.getText() + "\"\t\t\"+lowsens\"\n\n");
                        }
                }
            
            if(TeamBinds.jTextField1.getText().isBlank() && TeamBinds.jTextField2.getText().isBlank() && TeamBinds.jTextField3.getText().isBlank() && TeamBinds.jTextField4.getText().isBlank() &&
                TeamBinds.jTextField5.getText().isBlank() && TeamBinds.jTextField6.getText().isBlank() && TeamBinds.jTextField7.getText().isBlank() && TeamBinds.jTextField8.getText().isBlank() &&
                TeamBinds.jTextField9.getText().isBlank() && TeamBinds.jTextField10.getText().isBlank() && TeamBinds.jTextField11.getText().isBlank() && TeamBinds.jTextField12.getText().isBlank() &&
                TeamBinds.jTextField13.getText().isBlank() && TeamBinds.jTextField14.getText().isBlank()) {}
            else {
                config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tT E A M   B I N D S\n" +
                            "//\t\t*******************\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n");
                
                if(TeamBinds.jTextField2.getText().isBlank()) {}
                    else {
                        config.write("\n//\tDrop\n"
                                + "//\t****\n\n"
                                + "alias\t\"dropsound\"\t\t\"say_close ^5-- ^2Dropped %w ^5-- ^2%L^5 --; drop; play_close fvox/beep.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField2.getText() + "\"\t\t\"dropsound\"\n\n");
                    }
                
                if(TeamBinds.jTextField3.getText().isBlank()) {}
                    else {
                        config.write("\n//\tLocation\n"
                                + "//\t********\n\n"
                                + "alias\t\"loc\"\t\t\"say_team At ^2%L ^1(^5%H^1/^5%A^1)^0\"\n"
                                + "bind\t\"" + TeamBinds.jTextField3.getText() + "\"\t\t\"loc\"\n\n");
                    }
                
                if(TeamBinds.jTextField4.getText().isBlank()) {}
                    else {
                        config.write("\n//\tAttack\n"
                                + "//\t******\n\n"
                                + "alias\t\"at5\"\t\t\"say_team Attacking in ^15 ^0seconds; play_team hgrunt/go!.wav;customtimer 5\"\n"
                                + "bind\t\"" + TeamBinds.jTextField4.getText() + "\"\t\t\"at5\"\n\n");
                    }
                
                // Recharging arreglado el momento
                if(TeamBinds.jTextField5.getText().isBlank()) {}
                    else {
                        if(("e".equals(TeamBinds.jTextField5.getText()) || "E".equals(TeamBinds.jTextField5.getText())) && Alias.jCheckBox1.isSelected()) {
                            config.write("\n//\tRecharging\n"
                                    + "//\t**********\n\n"
                                    + "alias\t\"+use2\"\t\t\"+use;say_team ^8Recharging at ^7[^5%l^7]^0 ^7[^5%h^7|^5%a^7]^0\"\n" +
                                    "alias\t\"-use2\"\t\t\"-use\"\n" +
                                    "bind\t\"e\"\t\t\"+use2\"\n\n");
                        }   else {
                                config.write("\n//\tRecharging\n"
                                    + "//\t**********\n\n"
                                    + "alias\t\"+use2\"\t\t\"+use;say_team ^8Recharging at ^7[^5%l^7]^0 ^7[^5%h^7|^5%a^7]^0\"\n" +
                                    "alias\t\"-use2\"\t\t\"-use\"\n" +
                                    "bind\t\"" + TeamBinds.jTextField5.getText() + "\"\t\t\"+use2\"\n\n");
                            }
                    }
                
                if(TeamBinds.jTextField6.getText().isBlank()) {}
                    else {
                        config.write("\n//\tDont Shoot\n"
                                + "//\t**********\n\n"
                                + "alias\t\"donts\"\t\t\"say_close ^4(--^8Dont shot me^4--)^0; play_close scientist/c1a3_sci_team.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField6.getText() + "\"\t\t\"donts\"\n\n");
                    }
                
                if(TeamBinds.jTextField7.getText().isBlank()) {}
                    else {
                        config.write("\n//\tNeed Weapon\n"
                                + "//\t***********\n\n"
                                + "alias\t\"needw\"\t\t\"say_team ^3-- ^8Need a weapoN ^3-- ^3[^1%l^3] --; play_team scientist/gottogetout.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField7.getText() + "\"\t\t\"needw\"\n\n");
                    }
                
                if(TeamBinds.jTextField13.getText().isBlank()) {}
                    else {
                        config.write("\n//\tIn Position\n"
                                + "//\t***********\n\n"
                                + "alias\t\"inpos\"\t\t\"say_team ^3(^5RADIO^3) ^2I'm in position ^6[^8%L^6] ^2and need a weapon;play_team radio/ct_inpos.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField13.getText() + "\"\t\t\"inpos\"\n\n");
                    }
                
                if(TeamBinds.jTextField8.getText().isBlank()) {}
                    else {
                        config.write("\n//\tNeed Backup\n"
                                + "//\t***********\n\n"
                                + "alias\t\"backup\"\t\t\"say_team ^3(^5RADIO^3) ^2Need backup ^6[^8%L^6]; play_team hgrunt/backup!.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField8.getText() + "\"\t\t\"backup\"\n\n");
                    }
                
                if(TeamBinds.jTextField9.getText().isBlank()) {}
                    else {
                        config.write("\n//\tAffirmative\n"
                                + "//\t***********\n\n"
                                + "alias\t\"affirm\"\t\t\"say ^3(^5RADIO^3) ^2Affirmative; yes; play radio/ct_affirm.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField9.getText() + "\"\t\t\"affirm\"\n\n");
                    }
                
                if(TeamBinds.jTextField14.getText().isBlank()) {}
                    else {
                        config.write("\n//\tNegative\n"
                                + "//\t********\n\n"
                                + "alias\t\"negative\"\t\t\"say ^3(^5RADIO^3) ^2Negative; no; play radio/negative.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField14.getText() + "\"\t\t\"negative\"\n\n");
                    }
                
                if(TeamBinds.jTextField10.getText().isBlank()) {}
                    else {
                        config.write("\n//\tGo go go!\n"
                                + "//\t*********\n\n"
                                + "alias\t\"go\"\t\t\"say_close ^3(^5RADIO^3) ^2Go go go^6!!!; play_close radio/com_go.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField10.getText() + "\"\t\t\"go\"\n\n");
                    }
                
                if(TeamBinds.jTextField1.getText().isBlank()) {}
                    else {
                        config.write("\n//\tSector Clear\n"
                                + "//\t************\n\n"
                                + "alias\t\t\"sclear\"\t\t\"say_team ^3(^5RADIO^3) ^2Sector Clear ^6[^8%L^6]; play_team hgrunt/clear!.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField1.getText() + "\"\t\t\"sclear\"\n\n");
                    }
                
                if(TeamBinds.jTextField11.getText().isBlank()) {}
                    else {
                        config.write("\n//\tRegroup Team\n"
                                + "//\t************\n\n"
                                + "alias\t\t\"regroup\"\t\t\"say_team ^3(^5RADIO^3) ^2Regroup Team ^6[^8%L^6]; play_team radio/regroup.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField11.getText() + "\"\t\t\"regroup\"\n\n");
                    }
                
                if(TeamBinds.jTextField12.getText().isBlank()) {}
                    else {
                        config.write("\n//\tCover me\n"
                                + "//\t********\n\n"
                                + "alias\t\t\"coverme\"\t\t\"say_close ^3(^5RADIO^3) ^2Cover Me^6!!!; play_close hgrunt/cover!.wav\"\n"
                                + "bind\t\"" + TeamBinds.jTextField12.getText() + "\"\t\t\"coverme\"\n\n");
                    }
            }
            // Cuidado con esto
            if(ComandosHL.jTextField1.getText().isBlank() && ComandosHL.jTextField2.getText().isBlank() && ComandosHL.jTextField3.getText().isBlank() && ComandosHL.jTextField4.getText().isBlank() &&
                ComandosHL.jTextField6.getText().isBlank() && ComandosHL.jTextField12.getText().isBlank() && ComandosHL.jTextField8.getText().isBlank() && ComandosHL.jTextField9.getText().isBlank() && 
                    ComandosHL.jTextField5.getText().isBlank() && ComandosHL.jTextField11.getText().isBlank() && ComandosHL.jRadioButton1.isSelected() && ComandosHL.jRadioButton3.isSelected() && 
                    ComandosHL.jRadioButton6.isSelected() && ComandosHL.jRadioButton8.isSelected() && ComandosHL.jRadioButton10.isSelected() && ComandosHL.jRadioButton11.isSelected() &&
                    ComandosHL.jRadioButton14.isSelected() && ComandosHL.jRadioButton17.isSelected() && ComandosHL.jRadioButton19.isSelected() && ComandosHL.jRadioButton23.isSelected() &&
                    ComandosHL.jRadioButton27.isSelected() && ComandosHL.jRadioButton32.isSelected() && ComandosHL.jRadioButton28.isSelected() && ComandosHL.jRadioButton33.isSelected() &&
                    ComandosHL.jRadioButton36.isSelected() && ComandosHL.jRadioButton37.isSelected() && ComandosHL.jRadioButton40.isSelected()) {}
            else {
                if(ComandosHL.jTextField1.getText().isBlank() && ComandosHL.jTextField2.getText().isBlank() && ComandosHL.jTextField3.getText().isBlank() && ComandosHL.jTextField4.getText().isBlank() &&
                ComandosHL.jTextField6.getText().isBlank() && ComandosHL.jRadioButton1.isSelected() && ComandosHL.jRadioButton3.isSelected() && 
                    ComandosHL.jRadioButton6.isSelected()) {}
                else {
                    config.write("\n\n//\n" +
                        "//\n" +
                        "//\t\tM O U S E\n" +
                        "//\t\t*********\n" +
                        "//\n" +
                        "//\n" +
                        "//\n\n");
                if(ComandosHL.jTextField2.getText().isBlank()) {}
                    else {
                        config.write("sensitivity\t\t\"" + ComandosHL.jTextField2.getText() + "\"\n");
                    }
                
                if(ComandosHL.jTextField1.getText().isBlank()) {}
                    else {
                        config.write("zoom_sensitivity_ratio\t\"" + ComandosHL.jTextField1.getText() + "\"\n");
                    }
                
                if(ComandosHL.jTextField6.getText().isBlank()) {}
                    else {
                        config.write("m_pitch\t\t\t\"" + ComandosHL.jTextField6.getText() + "\"\n");
                    }
                
                if(ComandosHL.jTextField4.getText().isBlank()) {}
                    else {
                        config.write("m_yaw\t\t\t\"" + ComandosHL.jTextField4.getText() + "\"\n");
                    }
                
                if(ComandosHL.jTextField3.getText().isBlank()) {}
                    else {
                        config.write("m_forward\t\t\"" + ComandosHL.jTextField3.getText() + "\"\n");
                    }
                
                if(ComandosHL.jRadioButton1.isSelected()) {}
                    else {
                        config.write("m_filter\t\t\"1\"\n");
                    }
                
                if(ComandosHL.jRadioButton4.isSelected()) {}
                    else {
                        config.write("m_rawinput\t\t\"1\"\n");
                    }
                
                if(ComandosHL.jRadioButton6.isSelected()) {}
                    else {
                        config.write("m_customaccel\t\t\"1\"\n");
                    }
                } 
            }
            
            if(ComandosHL.jRadioButton8.isSelected() && ComandosHL.jRadioButton10.isSelected() && ComandosHL.jRadioButton11.isSelected() &&
                ComandosHL.jRadioButton14.isSelected() && ComandosHL.jRadioButton17.isSelected() && ComandosHL.jRadioButton19.isSelected() &&
                ComandosHL.jRadioButton23.isSelected() && ComandosHL.jTextField12.getText().isBlank()) {}
                else {
                    config.write("\n\n//\n" +
                        "//\n" +
                        "//\t\tH U D\n" +
                        "//\t\t*****\n" +
                        "//\n" +
                        "//\n" +
                        "//\n\n");
                    
                    if(ComandosHL.jRadioButton8.isSelected()) {}
                        else {
                            config.write("hud_weapon\t\t\t\"1\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton10.isSelected()) {}
                        else {
                            config.write("hud_saytext_sound\t\t\"1\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton11.isSelected()) {
                        config.write("hud_timer\t\t\t\"0\"\n");
                    }   else if (ComandosHL.jRadioButton12.isSelected()){
                            config.write("hud_timer\t\t\t\"1\"\n");
                    }   else if (ComandosHL.jRadioButton15.isSelected()){
                            config.write("hud_timer\t\t\t\"2\"\n");
                    }
                    
                    if(ComandosHL.jRadioButton14.isSelected()) {}
                        else {
                            config.write("hud_rainbow\t\t\t\"1\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton17.isSelected()) {}
                        else {
                            config.write("cl_old_scoreboard\t\t\"1\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton19.isSelected()) {}
                        else {
                            config.write("hud_speedometer\t\t\t\"1\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton21.isSelected()) {}
                        else {
                            config.write("hud_speedometer_below_cross\t\"1\"\n");
                        }
                    
                    if(ComandosHL.jRadioButton23.isSelected()) {}
                        else {
                            config.write("cl_scores\t\t\t\"" + ComandosHL.jSpinner4.getValue() + "\"\n");
                        }
                    
                    if(ComandosHL.jTextField12.getText().isBlank()) {}
                        else {
                            config.write("default_fov\t\t\t\"" + ComandosHL.jTextField12.getText() + "\"\n");
                        }
                    
                    if(!ComandosHL.rgbVer) {}
                    else {
                        config.write("hud_color\t\t\t\"" + ComandosHL.jSpinner2.getValue() + " " + ComandosHL.jSpinner5.getValue() + " " + ComandosHL.jSpinner3.getValue() + "\"\n");
                    }
                }
            
            if(ComandosHL.mp5tracerVer == false && ComandosHL.jTextField5.getText().isBlank() && ComandosHL.jTextField8.getText().isBlank() && ComandosHL.jTextField9.getText().isBlank() &&
                ComandosHL.jTextField11.getText().isBlank()) {}
                else {

                    config.write("\n\n//\n" +
                        "//\n" +
                        "//\t\tM P 5    T R A C E R S\n" +
                        "//\t\t**********************\n" +
                        "//\n" +
                        "//\n" +
                        "//\n\n");
                    
                    if(ComandosHL.jTextField8.getText().isBlank()) {}
                        else {
                            config.write("tracerspeed\t\t\"" + ComandosHL.jTextField8.getText() + "\"\n");
                        }
                    
                    if(ComandosHL.jTextField5.getText().isBlank()) {}
                        else {
                            config.write("tracerlength\t\t\"" + ComandosHL.jTextField5.getText() + "\"\n");
                        }
                    
                    if(ComandosHL.jTextField9.getText().isBlank()) {}
                        else {
                            config.write("traceralpha\t\t\"" + ComandosHL.jTextField9.getText() + "\"\n");
                        }
                    
                    if(ComandosHL.jTextField11.getText().isBlank()) {}
                        else {
                            config.write("traceroffset\t\t\"" + ComandosHL.jTextField11.getText() + "\"\n");
                        }
                    
                    if(ComandosHL.mp5tracerVer) {
                        config.write("tracerred\t\t\"" + ComandosHL.jSpinner7.getValue() + "\"\n");
                        config.write("tracergreen\t\t\"" + ComandosHL.jSpinner6.getValue() + "\"\n");
                        config.write("tracerblue\t\t\"" + ComandosHL.jSpinner8.getValue() + "\"\n");
                    }
                }    
            
            if(ComandosHL.jRadioButton27.isSelected() && ComandosHL.jRadioButton32.isSelected() && ComandosHL.fpsrVer) {}
            else {
                config.write("\n\n//\n" +
                        "//\n" +
                        "//\t\tF P S\n" +
                        "//\t\t*****\n" +
                        "//\n" +
                        "//\n" +
                        "//\n\n"
                        + "fps_override\t\t\"1\"\n");
                
                if(ComandosHL.jRadioButton27.isSelected()) {}
                    else {
                        config.write("cl_showfps\t\t\"1\"\n");
                    }
                
                if(ComandosHL.jRadioButton32.isSelected()) {}
                    else {
                        config.write("gl_vsync\t\t\"1\"\n");
                    }
                
                if(ComandosHL.jRadioButton28.isSelected()) {
                    config.write("fps_max\t\t\t\"120\"\n");
                }   else if(ComandosHL.jRadioButton26.isSelected()) {
                    config.write("fps_max\t\t\t\"144\"\n");
                }   else if(ComandosHL.jRadioButton29.isSelected() && !ComandosHL.jTextField10.getText().isBlank())  {
                    config.write("fps_max\t\t\t\"" + ComandosHL.jTextField10.getText() + "\"\n");
                }
            }
            
            if(ComandosHL.jRadioButton34.isSelected()) {
                
                config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tV I D E O\n" +
                            "//\t\t*********\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n");
                config.write("r_bmodelhighfrac\t\"5.0\"\n" +
                            "r_detailtextures\t\"0\"\n" +
                            "r_mmx\t\t\t    \"1\"\n" +
                            "r_dynamic\t\t\"1\"\n" +
                            "r_lightmap\t\t\"-1\"\n" +
                            "r_mirroralpha\t\t\"1\"\n" +
                            "gl_wateramp\t\t\"1\"\n" +
                            "gl_ztrick\t\t\"0\"\n" +
                            "gl_smoothmodels\t\t\"1\"\n" +
                            "gl_clear\t\t\"1\"\n" +
                            "gl_picmip\t\t\"0\"\n" +
                            "gl_playermip\t\t\"0\"\n" +
                            "gl_cull\t\t\t\"1\"\n" +
                            "gl_keeptjunctions\t\"1\"\n" +
                            "gl_lightholes\t\t\"1\"\n" +
                            "gl_dither\t\t\"0\"\n" +
                            "gl_flipmatrix\t\t\"0\"\n" +
                            "gl_fog\t\t\t\"0\"\n" +
                            "gl_monolights\t\t\"0\"\n" +
                            "gl_overbright\t\t\"1\"\n" +
                            "gl_polyoffset\t\t\"0.1\"\n" +
                            "gl_max_size\t\t\"512\"\n" +
                            "gl_texturmode\t\t\"GL_LINEAR_MIPMAP_LINEAR\"\n" +
                            "brightness\t\t\"30\"\n" +
                            "gamma\t\t\t\"30\"\n" +
                            "violence_hblood\t\t\"1\"\n" +
                            "violence_hgibs\t\t\"1\"\n" +
                            "violence_ablood\t\t\"1\"\n" +
                            "violence_agibs\t\t\"1\"\n" +
                            "lightgamma\t\t\"1.9\"\n" +
                            "lambert\t\t\t\"1.5\"\n" +
                            "net_graph\t\t\"0\"\n" +
                            "net_graphpos\t\t\"1\"\n" +
                            "net_scale\t\t\"5\"\n" +
                            "viewsize\t\t\"110\"\n" +
                            "texgamma\t\t\"1.1\"\n" +
                            "fastsprites\t\t\"0\"\n" +
                            "vid_wait\t\t\"0\"\n" +
                            "s_doppler\t\t\"1\"\n" +
                            "d_spriteskip\t\t\"0\"\n");
            }
            
            if(ComandosHL.jRadioButton35.isSelected()) {
                
                config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tS O U N D\n" +
                            "//\t\t*********\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n");
                config.write("s_geometry\t\t\"0\"\n" +
                            "s_numpolys\t\t\"0\"\n" +
                            "s_occlude\t\t\"0.00\"\n" +
                            "bgmvolume\t\t\"0\"\n" +
                            "hisound\t\t\t\"1\"\n" +
                            "suitvolume\t\t\"0\"\n" +
                            "s_rolloff\t\t\"10\"\n" +
                            "s_doppler\t\t\"0.0\"\n" +
                            "s_distance\t\t\"10\"\n" +
                            "s_automin_distance\t\"2.0\"\n" +
                            "s_automax_distance\t\"30.0\"\n" +
                            "s_min_distance\t\t\"8.0\"\n" +
                            "s_max_distance\t\t\"1000.0\"\n" +
                            "s_leafnum\t\t\"0\"\n" +
                            "s_refgain\t\t\"0.4\"\n" +
                            "s_refdelay\t\t\"4\"\n" +
                            "s_polykeep\t\t\"1000000000\"\n" +
                            "s_polysize\t\t\"10000000\"\n" +
                            "s_numpolys\t\t\"0\"\n" +
                            "s_bloat\t\t\t\"2.0\"\n" +
                            "s_verbwet\t\t\"0.25\"\n" +
                            "s_a3d\t\t\t\"0\"\n" +
                            "s_eax\t\t\t\"0.000000\"\n" +
                            "_snd_mixahead\t\t\"0.1\"\n" +
                            "ambient_level\t\t\"0.2\"\n" +
                            "s_2dvolume\t\t\"0.66\" \n" +
                            "volume\t\t\t\"0.9\"\n" +
                            "voice_loopback\t\t\"0\" \n" +
                            "voice_maxgain\t\t\"5\" \n" +
                            "voice_avggain\t\t\"0.5\" \n" +
                            "voice_scale\t\t\"1\" \n" +
                            "voice_fadeouttime\t\"0.1\"\n" +
                            "voice_profile\t\t\"0\" \n" +
                            "voice_showchannels\t\"0\" \n" +
                            "voice_showincoming\t\"0\" \n" +
                            "voice_enable\t\t\"1\" \n" +
                            "voice_eax\t\t\"1\" \n" +
                            "voice_dsound\t\t\"1\" \n" +
                            "voice_overdrive\t\t\"2\"\n" +
                            "voice_overdrivefadetime\t\"0.4\"\n" +
                            "voice_recordtofile\t\"0\"\n" +
                            "voice_inputfromfile\t\"0\"\n");
            }
            
            if(ComandosHL.jRadioButton38.isSelected()) {
                config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tC O N N E C T I O N\n" +
                            "//\t\t*******************\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n");
                config.write("rate\t\t\t\"99999\"\n" +
                            "cl_rate\t\t\t\"9999\"\n" +
                            "cl_allowdownload\t\"1\"\n" +
                            "cl_allowupload\t\t\"1\"\n" +
                            "cl_cmdbackup\t\t\"16\"\n" +
                            "cl_cmdrate\t\t\"80\"\n" +
                            "cl_dlmax\t\t\"800\"\n" +
                            "cl_download_ingame\t\"1\"\n" +
                            "cl_himodels\t\t\"0\"\n" +
                            "cl_idealpitchscale\t\"0.8\"\n" +
                            "cl_lc\t\t\t\"1\"\n" +
                            "cl_lw\t\t\t\"1\"\n" +
                            "cl_timeout\t\t\"305\"\n" +
                            "cl_updaterate\t\t\"80\"\n" +
                            "cl_vsmoothing\t\t\"0.05\"\n");
            }
            
            if(ComandosAG.jRadioButton11.isSelected()) {
                config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tM A P S\n" +
                            "//\t\t*******\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n"
                        + "alias\t\"cross\"\t\t\"agmap crossfire; say ^8Vote ^1[^2Crossfire^1]^0\"\n" +
                            "alias\t\"stkx\"\t\t\"agmap stalkx; say ^8Vote ^1[^2Stalkx^1]^0\"\n" +
                            "alias\t\"dust\"\t\t\"agmap dm_dust2; say ^8Vote ^1[^2Dust 2^1]^0\"\n" +
                            "alias\t\"bootx\"\t\t\"agmap bootbox; say ^8Vote ^1[^2Bootbox^1]^0\"\n" +
                            "alias\t\"stlky\"\t\t\"agmap stalkyard; say ^8Vote ^1[^2Stalkyard^1]^0\"\n" +
                            "alias\t\"vgc\"\t\t\"agmap vengeance; say ^8Vote ^1[^2Vengeance^1]^0\"\n" +
                            "alias\t\"lv\"\t\t\"agmap lost_village; say ^8Vote ^1[^2Lost_Village ^1]^0\"\n" +
                            "alias\t\"lv2\"\t\t\"agmap lost_village2; say ^8Vote ^1[^2Lost_Village 2^1]^0\"\n" +
                            "alias\t\"btc\"\t\t\"agmap bootcamp; say ^8Vote ^1[^2Bootcamp^1]^0\"\n" +
                            "alias\t\"cold\"\t\t\"agmap cold_faces; say ^8Vote ^1[^2Cold_faces^1]^0\"\n" +
                            "alias\t\"echo\"\t\t\"agmap echo; say ^8Vote ^1[^2Echo^1]^0\"\n" +
                            "alias\t\"end\"\t\t\"agmap endcamp; say ^8Vote ^1[^2Endcamp^1]^0\"\n" +
                            "alias\t\"iso\"\t\t\"agmap isotonic; say ^8Vote ^1[^2Isotonic^1]^0\"\n\n");
            }
            
            if(ComandosAG.jRadioButton13.isSelected()) {
                config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tM O D E L S\n" +
                            "//\t\t***********\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n"
                        + "alias\t\"bar\"\t\t\"model barney\"\n" +
                            "alias\t\"gin\"\t\t\"model gina\"\n" +
                            "alias\t\"gma\"\t\t\"model gman\"\n" +
                            "alias\t\"gor\"\t\t\"model gordon\"\n" +
                            "alias\t\"hel\"\t\t\"model helmet\"\n" +
                            "alias\t\"hgr\"\t\t\"model hgrunt\"\n" +
                            "alias\t\"rec\"\t\t\"model recon\"\n" +
                            "alias\t\"rob\"\t\t\"model robo\"\n" +
                            "alias\t\"sci\"\t\t\"model scientist\"\n" +
                            "alias\t\"zom\"\t\t\"model zombie\"\n" +
                            "alias\t\"blu\"\t\t\"model blue\"\n" +
                            "alias\t\"red\"\t\t\"model red\"\n\n");
            }
            
            if(ComandosAG.jRadioButton17.isSelected() && !ComandosAG.jTextField2.getText().isBlank()) {
                        config.write("\n\n//\n" +
                            "//\n" +
                            "//\t\tS M I L E S\n" +
                            "//\t\t***********\n" +
                            "//\n" +
                            "//\n" +
                            "//\n\n"
                            + "alias\t\"smile\"\t\t\t\"smile1\" \n" +
                            "alias\t\"smile1\"\t\t\"say ^8:^5); alias smile smile2\" \n" +
                            "alias\t\"smile2\"\t\t\"say ^8:^3-^1); alias smile smile3\" \n" +
                            "alias\t\"smile3\"\t\t\"say ^8:^1-^2-^3-^4-^5-^6-^7-^5-); alias smile smile4\" \n" +
                            "alias\t\"smile4\"\t\t\"say ^8:^5-^4>; alias smile smile5\" \n" +
                            "alias\t\"smile5\"\t\t\"say ^8:^3--^4]; alias smile smile6\" \n" +
                            "alias\t\"smile6\"\t\t\"say ^7(^3-^8:; alias smile smile7\" \n" +
                            "alias\t\"smile7\"\t\t\"say ^6|^8:^5-^6); alias smile smile8\" \n" +
                            "alias\t\"smile8\"\t\t\"say ^8:^6-^2-^6-^2); alias smile smile9\" \n" +
                            "alias\t\"smile9\"\t\t\"say ^8:^5-^1|); alias smile smile10\" \n" +
                            "alias\t\"smile10\"\t\t\"say ^3[^8:^4-^6); alias smile smile11\" \n" +
                            "alias\t\"smile11\"\t\t\"say ^1}^8:^2-^4]; alias smile smile12\" \n" +
                            "alias\t\"smile12\"\t\t\"say ^4(^8:^5<; alias smile smile13\" \n" +
                            "alias\t\"smile13\"\t\t\"say ^4<|^8:^6-^7); alias smile smile1\"\n\n"
                            + "bind\t\"" + ComandosAG.jTextField2.getText() + "\"\t\t\t\"smile\"");    
            }
            
            if(ComandosAG.jRadioButton1.isSelected() && ComandosAG.jRadioButton3.isSelected() && ComandosAG.jRadioButton10.isSelected() &&
                    ComandosAG.jRadioButton7.isSelected() && ComandosAG.jRadioButton16.isSelected()) {}
            else {
                if(VerificadorIdioma) {
                    config.write("\n\n//\n" +
                    "//\n" +
                    "//\t\tO T H E R    C O M M A N D S\n" +
                    "//\t\t****************************\n" +
                    "//\n" +
                    "//\n" +
                    "//\n\n");
                }   else {
                    config.write("\n\n//\n" +
                        "//\n" +
                        "//\t\tO T R O S    C O M A N D O S\n" +
                        "//\t\t****************************\n" +
                        "//\n" +
                        "//\n" +
                        "//\n\n");
                }
                
                if(ComandosAG.jRadioButton2.isSelected()) {
                    config.write("\nr_wadtextures\t\t\"1\"\n");
                }
                
                if(ComandosAG.jRadioButton4.isSelected()) {
                    config.write("\ncl_autowepswitch\t\"0\"\n");
                }
                
                if(ComandosAG.jRadioButton9.isSelected()) {
                    config.write("\ncl_hidecorpses\t\t\"1\"\n");
                }
                
                if(ComandosAG.jRadioButton8.isSelected()) {
                    config.write("\nr_drawviewmodels\t\"0\"\n");
                }
                
                if(ComandosAG.jRadioButton15.isSelected()) {
                    config.write("\nr_decals\t\"0\"\n");
                    config.write("\nmp_decals\t\"0\"\n");
                }
            }
            
            mensajeFinal = new MensajeFinal(creador, true);
            
            
            
            
        } catch (IOException ex) {}
    }//GEN-LAST:event_crearMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void eventosTeclado(final JTextField caja) {
        KeyListener eventoTeclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               if(caja.getText().length() >= 1) {
                   e.consume();
               }    
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    caja.setText("");
                }
                
                if(e.getKeyChar() == 32) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        caja.addKeyListener(eventoTeclado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGcomandos;
    public static javax.swing.JLabel Aviso;
    private javax.swing.JButton HLcomandos;
    public static javax.swing.JPanel PanelNombrePrincipal;
    private javax.swing.JButton alias;
    private javax.swing.JButton armas;
    private javax.swing.JButton blueText;
    public static javax.swing.JPanel creacionPrincipal;
    private javax.swing.JButton crear;
    private javax.swing.JButton defaultColor;
    private javax.swing.JButton grayText;
    private javax.swing.JButton greenColor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelAlias;
    private javax.swing.JLabel labelArmas;
    private javax.swing.JLabel labelComAG;
    private javax.swing.JLabel labelComHL;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTeam;
    private javax.swing.JButton lightBlueColor;
    private javax.swing.JButton nombres;
    public static javax.swing.JPanel panelNombres;
    private javax.swing.JButton purpleColor;
    private javax.swing.JButton redColor;
    public static javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton teamBinds;
    public static javax.swing.JPanel textfields;
    private javax.swing.JButton whiteText;
    private javax.swing.JButton yellowColor;
    // End of variables declaration//GEN-END:variables
}
