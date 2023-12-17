
package Generator.creacion;

import static Generator.Main.VerificadorIdioma;
import javax.swing.JSpinner;
import javax.swing.JToolTip;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ComandosHL extends javax.swing.JPanel {
    
    public static boolean rgbVer = false;
    public static boolean mp5tracerVer = false;
    public static boolean fpsrVer = false;
    
    public ComandosHL() {
        initComponents();
        
        jScrollPane1.getVerticalScrollBar().setBackground(new java.awt.Color(120, 120, 120));
        
        if(VerificadorIdioma) {
            // Mouse
            jLabel13.setText("Sensitivity");
            jLabel9.setText("Zoom sensitivity");
            jLabel5.setText("Mouse filter");
            jLabel10.setText("Mouse raw input");
            jLabel3.setText("Mouse acceleration");
            
            // HUD
            jLabel16.setText("Weapon image");
            jLabel4.setText("Chat sounds");
            jLabel17.setText("Show timer");
            jRadioButton15.setText("Time elapsed");
            jRadioButton12.setText("Time remaining");
            jLabel14.setText("Rainbow HUD");
            jLabel19.setText("Old scoreboard");
            jLabel20.setText("Show speedometer");
            jLabel21.setText("Speedometer under crosshair");
            jLabel38.setText("Show scores");
            
            // MP5
            jLabel29.setText("Speed");
            jLabel44.setText("Length");
            jLabel33.setText("Transparency");
            jLabel32.setText("Offset");
            
            // FPS
            
            jLabel40.setText("Show FPS");
            jLabel39.setText("Max. FPS");
            jRadioButton28.setText("For 60Hz");
            jRadioButton26.setText("For 75-144Hz");
            
            // Otros
            jLabel37.setText("Others");
            jLabel46.setText("Sound");
            jLabel47.setText("<html>Connection <br>commands</html>");
            jLabel30.setText("<html>Bind <br>numeric keypad</html>");
            jRadioButton33.setText("Use default settings");
            jRadioButton34.setText("Use optimized settings");
            jRadioButton36.setText("Use default settings");
            jRadioButton35.setText("Use optimized settings");
            jRadioButton37.setText("Use default settings");
            jRadioButton38.setText("Use optimized settings");
        }
        
        // Mouse
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup2.add(jRadioButton3);
        buttonGroup2.add(jRadioButton4);
        buttonGroup3.add(jRadioButton5);
        buttonGroup3.add(jRadioButton6);

        // HUD
        buttonGroup4.add(jRadioButton7);
        buttonGroup4.add(jRadioButton8);
        buttonGroup5.add(jRadioButton9);
        buttonGroup5.add(jRadioButton10);
        buttonGroup6.add(jRadioButton11);
        buttonGroup6.add(jRadioButton12);
        buttonGroup6.add(jRadioButton15);
        buttonGroup7.add(jRadioButton13);
        buttonGroup7.add(jRadioButton14);
        buttonGroup8.add(jRadioButton16);
        buttonGroup8.add(jRadioButton17);
        buttonGroup9.add(jRadioButton18);
        buttonGroup9.add(jRadioButton19);
        buttonGroup10.add(jRadioButton20);
        buttonGroup10.add(jRadioButton21);
        buttonGroup11.add(jRadioButton22);
        buttonGroup11.add(jRadioButton23);
        
        // FPS
        buttonGroup12.add(jRadioButton27);
        buttonGroup12.add(jRadioButton30);
        buttonGroup13.add(jRadioButton31);
        buttonGroup13.add(jRadioButton32);
        buttonGroup14.add(jRadioButton26);
        buttonGroup14.add(jRadioButton28);
        buttonGroup14.add(jRadioButton29);
        
        // Otros
        buttonGroup15.add(jRadioButton33);
        buttonGroup15.add(jRadioButton34);
        buttonGroup16.add(jRadioButton35);
        buttonGroup16.add(jRadioButton36);
        buttonGroup17.add(jRadioButton37);
        buttonGroup17.add(jRadioButton38);
        buttonGroup18.add(jRadioButton39);
        buttonGroup18.add(jRadioButton40);
        
        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(jTextField2.getText().isEmpty()) {
                Alias.jTextField17.setEnabled(false);
                if(VerificadorIdioma) {
                    Alias.jTextField17.setToolTipText("Set the sensitivity in \"Settings HL\"");
                }   else {
                        Alias.jTextField17.setToolTipText("Configure la sensibilidad en \"Config. HL\"");
                    }
                }   else {
                    Alias.jTextField17.setEnabled(true);
                    Alias.jTextField17.setToolTipText(null);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(jTextField2.getText().isEmpty()) {
                Alias.jTextField17.setEnabled(false);
                if(VerificadorIdioma) {
                    Alias.jTextField17.setToolTipText("Set the sensitivity in \"Settings HL\"");
                }   else {
                        Alias.jTextField17.setToolTipText("Configure la sensibilidad en \"Config. HL\"");
                    }
                }   else {
                    Alias.jTextField17.setEnabled(true);
                    Alias.jTextField17.setToolTipText(null);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(jTextField2.getText().isEmpty()) {
                    Alias.jTextField17.setEnabled(false);
                    if(VerificadorIdioma) {
                    Alias.jTextField17.setToolTipText("Set the sensitivity in \"Settings HL\"");
                    }   else {
                        Alias.jTextField17.setToolTipText("Configure la sensibilidad en \"Config. HL\"");
                    }
                }   else {
                    Alias.jTextField17.setEnabled(true);
                    Alias.jTextField17.setToolTipText(null);
                }
            }
        });
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        buttonGroup16 = new javax.swing.ButtonGroup();
        buttonGroup17 = new javax.swing.ButtonGroup();
        buttonGroup18 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jSpinner7 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jSpinner2 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jSpinner3 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jSpinner5 = new javax.swing.JSpinner() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jLabel37 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel() {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jLabel46 = new javax.swing.JLabel();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        jRadioButton39 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(null);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 1140));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 1140));
        jPanel1.setLayout(null);

        jTextField12.setBackground(new java.awt.Color(153, 153, 153));
        jTextField12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(null);
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField12);
        jTextField12.setBounds(580, 620, 74, 30);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("FPS");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(440, 700, 60, 40);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Aceleración del mouse");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 190, 200, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mouse");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 0, 70, 40);

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sonidos de chat");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 400, 130, 30);

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Filtro del mouse");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 90, 140, 30);

        jTextField3.setBackground(new java.awt.Color(153, 153, 153));
        jTextField3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(null);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(600, 40, 74, 30);

        jTextField5.setBackground(new java.awt.Color(153, 153, 153));
        jTextField5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(110, 810, 74, 30);

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mouse pitch");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 140, 100, 30);

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mouse yaw");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 190, 100, 30);

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mouse forward");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(390, 40, 120, 30);

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sensibilidad del zoom");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 90, 180, 30);

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Entrada directa");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(390, 140, 180, 30);

        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(null);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(250, 90, 74, 30);

        jTextField2.setBackground(new java.awt.Color(153, 153, 153));
        jTextField2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(null);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(250, 40, 74, 30);

        jTextField4.setBackground(new java.awt.Color(153, 153, 153));
        jTextField4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(null);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(250, 190, 74, 30);

        jRadioButton1.setSelected(true);
        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Off");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(610, 100, 60, 20);

        jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("On");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(610, 80, 60, 20);

        jRadioButton3.setSelected(true);
        jRadioButton3.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("On");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(610, 130, 60, 20);

        jRadioButton4.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Off");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton4);
        jRadioButton4.setBounds(610, 150, 60, 20);

        jRadioButton5.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("On");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton5);
        jRadioButton5.setBounds(610, 190, 60, 20);

        jRadioButton6.setSelected(true);
        jRadioButton6.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Off");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton6);
        jRadioButton6.setBounds(610, 210, 60, 20);

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sensibilidad");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(40, 40, 100, 30);

        jRadioButton7.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setText("On");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton7);
        jRadioButton7.setBounds(190, 320, 60, 20);

        jRadioButton8.setSelected(true);
        jRadioButton8.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText("Off");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton8);
        jRadioButton8.setBounds(190, 340, 60, 20);

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("HUD arcoiris");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(40, 540, 100, 30);

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("FOV");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(360, 620, 100, 30);

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Imagen de arma");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(40, 330, 120, 30);

        jLabel17.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mostrar reloj");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(40, 470, 120, 30);

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tabla de scores vieja");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(360, 330, 170, 30);

        jLabel20.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Motrar velocímetro");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(360, 400, 170, 30);

        jLabel21.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Velocímetro bajo la mira");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(360, 480, 230, 30);

        jTextField6.setBackground(new java.awt.Color(153, 153, 153));
        jTextField6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(null);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(250, 140, 74, 30);

        jRadioButton9.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("On");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton9);
        jRadioButton9.setBounds(190, 390, 60, 20);

        jRadioButton10.setSelected(true);
        jRadioButton10.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton10.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setText("Off");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton10);
        jRadioButton10.setBounds(190, 410, 60, 20);

        jRadioButton11.setSelected(true);
        jRadioButton11.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton11.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton11.setText("Off");
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton11);
        jRadioButton11.setBounds(190, 450, 60, 20);

        jRadioButton12.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton12.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton12.setText("Tiempo restante");
        jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton12);
        jRadioButton12.setBounds(190, 470, 130, 20);

        jRadioButton13.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton13.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton13.setText("On");
        jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton13);
        jRadioButton13.setBounds(190, 530, 60, 20);

        jRadioButton14.setSelected(true);
        jRadioButton14.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton14.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton14.setText("Off");
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton14);
        jRadioButton14.setBounds(190, 550, 60, 20);

        jRadioButton15.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton15.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton15.setText("Tiempo transcurrido");
        jRadioButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton15);
        jRadioButton15.setBounds(190, 490, 140, 20);

        jRadioButton16.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton16.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton16.setText("On");
        jRadioButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton16);
        jRadioButton16.setBounds(590, 320, 60, 20);

        jRadioButton17.setSelected(true);
        jRadioButton17.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton17.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton17.setText("Off");
        jRadioButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton17);
        jRadioButton17.setBounds(590, 340, 60, 20);

        jRadioButton18.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton18.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton18.setText("On");
        jRadioButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton18);
        jRadioButton18.setBounds(590, 390, 60, 20);

        jRadioButton19.setSelected(true);
        jRadioButton19.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton19.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton19.setText("Off");
        jRadioButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton19);
        jRadioButton19.setBounds(590, 410, 60, 20);

        jRadioButton20.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton20.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton20.setText("On");
        jRadioButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton20);
        jRadioButton20.setBounds(590, 470, 60, 20);

        jRadioButton21.setSelected(true);
        jRadioButton21.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton21.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton21.setText("Off");
        jRadioButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton21ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton21);
        jRadioButton21.setBounds(590, 490, 60, 20);

        jRadioButton22.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton22.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton22.setText("On");
        jRadioButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton22ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton22);
        jRadioButton22.setBounds(550, 540, 60, 20);

        jRadioButton23.setSelected(true);
        jRadioButton23.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton23.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton23.setText("Off");
        jRadioButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton23ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton23);
        jRadioButton23.setBounds(550, 560, 60, 20);

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("HUD");
        jLabel27.setOpaque(true);
        jPanel1.add(jLabel27);
        jLabel27.setBounds(40, 270, 70, 40);

        jLabel22.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("VSync");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(440, 790, 90, 30);

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("B");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(250, 850, 48, 16);

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("R");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(130, 850, 50, 16);

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("G");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(190, 850, 48, 16);

        jSpinner4.setEnabled(false);
        jSpinner4.setEditor(new JSpinner.DefaultEditor(jSpinner4));
        if(VerificadorIdioma) {
            jSpinner4.setToolTipText("Enable scores first");
        }   else {
            jSpinner4.setToolTipText("Active los scores");
        }
        jSpinner4.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 32, 1));
        jSpinner4.setBorder(null);
        jPanel1.add(jSpinner4);
        jSpinner4.setBounds(620, 540, 50, 40);

        jLabel29.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Velocidad");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(30, 760, 80, 30);

        jLabel30.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        if(VerificadorIdioma) {
            jLabel30.setToolTipText("<html>If you binded the numeric keys, you won't <br>"
                + "be able to vote in some servers. Binding the <br> "
                + "numeric keypad is the solution.</html>");
        }   else {
            jLabel30.setToolTipText("<html>Si tienes bindeadas las teclas de números,<br>"
                + "no podrás votar en algunos servidores. <br>"
                + "Bindear el teclado numérico lo soluciona.</html>");
        }
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("<html>Bindear el <br>teclado numérico</html>");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(370, 1050, 100, 60);

        jLabel31.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Color");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(70, 880, 60, 30);

        jLabel32.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Desviación");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(200, 810, 100, 30);

        jLabel33.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Transparencia");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(200, 760, 110, 30);

        jSpinner5.setEditor(new JSpinner.DefaultEditor(jSpinner5));
        jSpinner5.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jSpinner6.setBorder(null);
        jSpinner6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner6StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner6);
        jSpinner6.setBounds(190, 870, 50, 40);

        jSpinner2.setEditor(new JSpinner.DefaultEditor(jSpinner2));
        jSpinner2.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jSpinner7.setBorder(null);
        jSpinner7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner7StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner7);
        jSpinner7.setBounds(130, 870, 50, 40);

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("R");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(160, 600, 50, 16);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("G");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(220, 600, 48, 16);

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("B");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(280, 600, 48, 16);

        jSpinner3.setEditor(new JSpinner.DefaultEditor(jSpinner3));
        jSpinner3.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jSpinner8.setBorder(null);
        jSpinner8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner8StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner8);
        jSpinner8.setBounds(250, 870, 50, 40);

        jSpinner2.setEditor(new JSpinner.DefaultEditor(jSpinner2));
        jSpinner2.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jSpinner2.setBorder(null);
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner2);
        jSpinner2.setBounds(160, 620, 50, 40);

        jSpinner3.setEditor(new JSpinner.DefaultEditor(jSpinner3));
        jSpinner3.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jSpinner3.setBorder(null);
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner3);
        jSpinner3.setBounds(280, 620, 50, 40);

        jSpinner5.setEditor(new JSpinner.DefaultEditor(jSpinner5));
        jSpinner5.getEditor().getComponent(0).setBackground(new java.awt.Color(153, 153, 153));
        jSpinner5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        jSpinner5.setBorder(null);
        jSpinner5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner5StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner5);
        jSpinner5.setBounds(220, 620, 50, 40);

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Otros");
        jLabel37.setOpaque(true);
        jPanel1.add(jLabel37);
        jLabel37.setBounds(50, 950, 70, 40);

        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 161, 96), 1, true));
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 20, 700, 230);

        jTextField7.setBackground(new java.awt.Color(153, 153, 153));
        jTextField7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(null);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(250, 190, 74, 30);

        jTextField8.setBackground(new java.awt.Color(153, 153, 153));
        jTextField8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(null);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(110, 760, 74, 30);

        jTextField9.setBackground(new java.awt.Color(153, 153, 153));
        jTextField9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(null);
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField9);
        jTextField9.setBounds(310, 760, 74, 30);

        jTextField10.setEnabled(false);
        jTextField10.setBackground(new java.awt.Color(153, 153, 153));
        jTextField10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setBorder(null);
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField10);
        jTextField10.setBounds(620, 870, 74, 30);

        jLabel38.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Mostrar scores");
        jPanel1.add(jLabel38);
        jLabel38.setBounds(360, 550, 120, 30);

        if(VerificadorIdioma) {
            jLabel39.setToolTipText("<html>If you have a  60Hz monitor, we'll set your fps to 120. ."
                + "<br> If you have a 75 or 144Hz monitor, we'll set your fps to 144."
                + "<br> It's recommended to use a close multiple of your monitor's Hz as fps number.</html>");
        }   else {
            jLabel39.setToolTipText("<html>Si tienes un monitor de 60Hz, pondremos tus fps a 120."
                + "<br> Si usas un monitor de 75 o 144 Hz, a 144 fps."
                + "<br> Lo ideal es usar un número de fps que sea un múltiplo cercano a los Hz del monitor.</html>");
        }
        jLabel39.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Máx. FPS");
        jPanel1.add(jLabel39);
        jLabel39.setBounds(440, 850, 70, 30);

        jLabel40.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Mostrar FPS");
        jPanel1.add(jLabel40);
        jLabel40.setBounds(440, 740, 90, 30);

        jLabel43.setBackground(new java.awt.Color(0, 0, 0));
        jLabel43.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("MP5 tracers");
        jLabel43.setOpaque(true);
        jPanel1.add(jLabel43);
        jLabel43.setBounds(40, 700, 100, 40);

        jRadioButton26.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton26.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton26.setText("Para 75-144Hz");
        jRadioButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton26ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton26);
        jRadioButton26.setBounds(530, 850, 120, 20);

        jRadioButton27.setSelected(true);
        jRadioButton27.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton27.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton27.setText("Off");
        jPanel1.add(jRadioButton27);
        jRadioButton27.setBounds(530, 750, 50, 20);

        jRadioButton28.setSelected(true);
        jRadioButton28.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton28.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton28.setText("Para 60Hz");
        jRadioButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton28ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton28);
        jRadioButton28.setBounds(530, 830, 110, 20);

        jRadioButton29.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton29.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton29.setText("Custom");
        jRadioButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton29ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton29);
        jRadioButton29.setBounds(530, 880, 80, 20);

        jRadioButton30.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton30.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton30.setText("On");
        jRadioButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton30ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton30);
        jRadioButton30.setBounds(530, 730, 50, 20);

        jRadioButton31.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton31.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton31.setText("On");
        jPanel1.add(jRadioButton31);
        jRadioButton31.setBounds(530, 780, 50, 20);

        jRadioButton32.setSelected(true);
        jRadioButton32.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton32.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton32.setText("Off");
        jPanel1.add(jRadioButton32);
        jRadioButton32.setBounds(530, 800, 50, 20);

        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jPanel1.add(jLabel36);
        jLabel36.setBounds(420, 720, 290, 210);

        jTextField11.setBackground(new java.awt.Color(153, 153, 153));
        jTextField11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(null);
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField11);
        jTextField11.setBounds(310, 810, 74, 30);

        jLabel42.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("HUD color");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(40, 620, 100, 30);

        jRadioButton33.setSelected(true);
        jRadioButton33.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton33.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton33.setText("Utilizar configuración default");
        jRadioButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton33ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton33);
        jRadioButton33.setBounds(130, 990, 220, 20);

        jRadioButton32.setSelected(true);
        jRadioButton34.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton34.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton34.setText("Utilizar configuración optimizada");
        jPanel1.add(jRadioButton34);
        jRadioButton34.setBounds(130, 1010, 220, 20);

        jLabel44.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Longitud");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(30, 810, 80, 30);

        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jPanel1.add(jLabel26);
        jLabel26.setBounds(10, 720, 390, 210);

        jLabel45.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Video");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(40, 1000, 80, 30);

        jRadioButton32.setSelected(true);
        jRadioButton35.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton35.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton35.setText("Utilizar configuración optimizada");
        jPanel1.add(jRadioButton35);
        jRadioButton35.setBounds(130, 1080, 220, 20);

        jRadioButton36.setSelected(true);
        jRadioButton36.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton36.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton36.setText("Utilizar configuración default");
        jRadioButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton36ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton36);
        jRadioButton36.setBounds(130, 1060, 220, 20);

        jLabel46.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Sonido");
        jPanel1.add(jLabel46);
        jLabel46.setBounds(40, 1070, 80, 30);

        jRadioButton37.setSelected(true);
        jRadioButton37.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton37.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton37.setText("Utilizar configuración default");
        jRadioButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton37ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton37);
        jRadioButton37.setBounds(480, 990, 220, 20);

        jRadioButton32.setSelected(true);
        jRadioButton38.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton38.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton38.setText("Utilizar configuración optimizada");
        jPanel1.add(jRadioButton38);
        jRadioButton38.setBounds(480, 1010, 220, 20);

        jLabel47.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("<html>Comandos de <br>conexión</html>");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(370, 990, 100, 38);

        jRadioButton39.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton39.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton39.setText("On");
        jRadioButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton39ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton39);
        jRadioButton39.setBounds(480, 1060, 60, 20);

        jRadioButton40.setSelected(true);
        jRadioButton40.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButton40.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton40.setText("Off");
        jPanel1.add(jRadioButton40);
        jRadioButton40.setBounds(480, 1080, 60, 20);

        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jPanel1.add(jLabel41);
        jLabel41.setBounds(10, 290, 700, 390);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 96)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 970, 700, 160);

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 750, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jRadioButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton13ActionPerformed
        jSpinner2.setEnabled(false);
        jSpinner5.setEnabled(false);
        jSpinner3.setEnabled(false);
        
        if(VerificadorIdioma) {
            jSpinner2.setToolTipText("Disable \"Rainbow HUD\"");
            jSpinner5.setToolTipText("Disable \"Rainbow HUD\"");
            jSpinner3.setToolTipText("Disable \"Rainbow HUD\"");
        }   else {
            jSpinner2.setToolTipText("Desactive \"HUD arcoiris\"");
            jSpinner5.setToolTipText("Desactive \"HUD arcoiris\"");
            jSpinner3.setToolTipText("Desactive \"HUD arcoiris\"");
        }
    }//GEN-LAST:event_jRadioButton13ActionPerformed

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        jSpinner2.setEnabled(true);
        jSpinner5.setEnabled(true);
        jSpinner3.setEnabled(true);
        
        jSpinner2.setToolTipText(null);
        jSpinner5.setToolTipText(null);
        jSpinner3.setToolTipText(null);
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton15ActionPerformed

    private void jRadioButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton16ActionPerformed

    private void jRadioButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton17ActionPerformed

    private void jRadioButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton18ActionPerformed
        jRadioButton20.setEnabled(true);
        jRadioButton21.setEnabled(true);
    }//GEN-LAST:event_jRadioButton18ActionPerformed

    private void jRadioButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton19ActionPerformed
        jRadioButton20.setEnabled(false);
        jRadioButton21.setEnabled(false);
    }//GEN-LAST:event_jRadioButton19ActionPerformed

    private void jRadioButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton20ActionPerformed

    private void jRadioButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton21ActionPerformed

    private void jRadioButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton22ActionPerformed
        jSpinner4.setEnabled(true);
        jSpinner4.setToolTipText(null);
    }//GEN-LAST:event_jRadioButton22ActionPerformed

    private void jRadioButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton23ActionPerformed
        jSpinner4.setEnabled(false);
        if(VerificadorIdioma) {
                jSpinner4.setToolTipText("Enable scores first");
        }   else {
                jSpinner4.setToolTipText("Active los scores");
        }
    }//GEN-LAST:event_jRadioButton23ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char validar = evt.getKeyChar();
        
        if(validar >= 32 && validar <= 43 || validar == 45 || validar == 47 || validar >= 58) {
            evt.consume();
        }

        
        String string = jTextField2.getText();


        if(string.equals("") && validar == 44) {
            jTextField2.setText("0");
        }   else if (string.equals("") && validar == 46) {
            jTextField2.setText("0");
        }
        
        boolean validacion = string.contains(",");
        boolean validacion2 = string.contains(".");
        
        if((validar == 44 || validar == 46) && (validacion || validacion2)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char validar = evt.getKeyChar();
        
        if(validar >= 32 && validar <= 43 || validar == 45 || validar == 47 || validar >= 58) {
            evt.consume();
        }

        
        String string = jTextField1.getText();


        if(string.equals("") && validar == 44) {
            jTextField1.setText("0");
        }   else if (string.equals("") && validar == 46) {
            jTextField1.setText("0");
        }
        
        boolean validacion = string.contains(",");
        boolean validacion2 = string.contains(".");
        
        if((validar == 44 || validar == 46) && (validacion || validacion2)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char validar = evt.getKeyChar();
        
        if(validar >= 32 && validar <= 43 || validar == 45 || validar == 47 || validar >= 58) {
            evt.consume();
        }

        
        String string = jTextField6.getText();


        if(string.equals("") && validar == 44) {
            jTextField6.setText("0");
        }   else if (string.equals("") && validar == 46) {
            jTextField6.setText("0");
        }
        
        boolean validacion = string.contains(",");
        boolean validacion2 = string.contains(".");
        
        if((validar == 44 || validar == 46) && (validacion || validacion2)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char validar = evt.getKeyChar();
        
        if(validar >= 32 && validar <= 43 || validar == 45 || validar == 47 || validar >= 58) {
            evt.consume();
        }

        
        String string = jTextField4.getText();


        if(string.equals("") && validar == 44) {
            jTextField4.setText("0");
        }   else if (string.equals("") && validar == 46) {
            jTextField4.setText("0");
        }
        
        boolean validacion = string.contains(",");
        boolean validacion2 = string.contains(".");
        
        if((validar == 44 || validar == 46) && (validacion || validacion2)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char validar = evt.getKeyChar();
        
        if(!(validar >= 48 && validar <= 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char validar = evt.getKeyChar();
        
        if(!(validar >= 48 && validar <= 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char validar = evt.getKeyChar();
        
        if(!(validar >= 48 && validar <= 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        char validar = evt.getKeyChar();
        
        if(!(validar >= 48 && validar <= 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        char validar = evt.getKeyChar();
        
        if(!(validar >= 48 && validar <= 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char validar = evt.getKeyChar();
        
        if(validar >= 32 && validar <= 43 || validar == 45 || validar == 47 || validar >= 58) {
            evt.consume();
        }

        
        String string = jTextField2.getText();


        if(string.equals("") && validar == 44) {
            jTextField2.setText("0");
        }   else if (string.equals("") && validar == 46) {
            jTextField2.setText("0");
        }
        
        boolean validacion = string.contains(",");
        boolean validacion2 = string.contains(".");
        
        if((validar == 44 || validar == 46) && (validacion || validacion2)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jRadioButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton29ActionPerformed
        jTextField10.setEnabled(true);
        fpsrVer = true;
    }//GEN-LAST:event_jRadioButton29ActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        char validar = evt.getKeyChar();
        
        if(!(validar >= 48 && validar <= 57)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jRadioButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton33ActionPerformed

    private void jRadioButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton36ActionPerformed

    private void jRadioButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton37ActionPerformed

    private void jRadioButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton39ActionPerformed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        rgbVer = true;
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jSpinner5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner5StateChanged
        rgbVer = true;
    }//GEN-LAST:event_jSpinner5StateChanged

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        rgbVer = true;
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jSpinner7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner7StateChanged
        mp5tracerVer = true;
    }//GEN-LAST:event_jSpinner7StateChanged

    private void jSpinner6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner6StateChanged
        mp5tracerVer = true;
    }//GEN-LAST:event_jSpinner6StateChanged

    private void jSpinner8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner8StateChanged
        mp5tracerVer = true;
    }//GEN-LAST:event_jSpinner8StateChanged

    private void jRadioButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton30ActionPerformed

    private void jRadioButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton28ActionPerformed
        fpsrVer = true;
    }//GEN-LAST:event_jRadioButton28ActionPerformed

    private void jRadioButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton26ActionPerformed
        fpsrVer = true;
    }//GEN-LAST:event_jRadioButton26ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup16;
    private javax.swing.ButtonGroup buttonGroup17;
    private javax.swing.ButtonGroup buttonGroup18;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JRadioButton jRadioButton1;
    public static javax.swing.JRadioButton jRadioButton10;
    public static javax.swing.JRadioButton jRadioButton11;
    public static javax.swing.JRadioButton jRadioButton12;
    public static javax.swing.JRadioButton jRadioButton13;
    public static javax.swing.JRadioButton jRadioButton14;
    public static javax.swing.JRadioButton jRadioButton15;
    public static javax.swing.JRadioButton jRadioButton16;
    public static javax.swing.JRadioButton jRadioButton17;
    public static javax.swing.JRadioButton jRadioButton18;
    public static javax.swing.JRadioButton jRadioButton19;
    public static javax.swing.JRadioButton jRadioButton2;
    public static javax.swing.JRadioButton jRadioButton20;
    public static javax.swing.JRadioButton jRadioButton21;
    public static javax.swing.JRadioButton jRadioButton22;
    public static javax.swing.JRadioButton jRadioButton23;
    public static javax.swing.JRadioButton jRadioButton26;
    public static javax.swing.JRadioButton jRadioButton27;
    public static javax.swing.JRadioButton jRadioButton28;
    public static javax.swing.JRadioButton jRadioButton29;
    public static javax.swing.JRadioButton jRadioButton3;
    public static javax.swing.JRadioButton jRadioButton30;
    public static javax.swing.JRadioButton jRadioButton31;
    public static javax.swing.JRadioButton jRadioButton32;
    public static javax.swing.JRadioButton jRadioButton33;
    public static javax.swing.JRadioButton jRadioButton34;
    public static javax.swing.JRadioButton jRadioButton35;
    public static javax.swing.JRadioButton jRadioButton36;
    public static javax.swing.JRadioButton jRadioButton37;
    public static javax.swing.JRadioButton jRadioButton38;
    public static javax.swing.JRadioButton jRadioButton39;
    public static javax.swing.JRadioButton jRadioButton4;
    public static javax.swing.JRadioButton jRadioButton40;
    public static javax.swing.JRadioButton jRadioButton5;
    public static javax.swing.JRadioButton jRadioButton6;
    public static javax.swing.JRadioButton jRadioButton7;
    public static javax.swing.JRadioButton jRadioButton8;
    public static javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSpinner jSpinner2;
    public static javax.swing.JSpinner jSpinner3;
    public static javax.swing.JSpinner jSpinner4;
    public static javax.swing.JSpinner jSpinner5;
    public static javax.swing.JSpinner jSpinner6;
    public static javax.swing.JSpinner jSpinner7;
    public static javax.swing.JSpinner jSpinner8;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField11;
    public static javax.swing.JTextField jTextField12;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
