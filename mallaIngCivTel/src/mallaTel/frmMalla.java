/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mallaTel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Nicolas olivos
 */
public final class frmMalla extends javax.swing.JFrame {

    /**
     * Creates new form frmMalla
     */
    public frmMalla() {
        initComponents();
        setTitle("Malla Curricular");
        btnVer.setToolTipText("Ver Toda la MALLA");
        setBounds(0, 0, 1275, 800);
        btnVer.setBounds(btnVer.getBounds().x, btnVer.getBounds().y, 77, 28);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        for(int i=0;i<etiquetas.length;i++){
            etiquetas[i]=new JLabel[ramos[i].length];
        }
        for(int i=0;i<requisitos.length;i++){
            for(int j=0;j<requisitos[i].length;j++){
                if(!requisitos[i][j].equals("0")){
                    if(requisitos[i][j].length()==1){
                        for(int x=0;x<requisitos[Integer.parseInt(requisitos[i][j])-1].length;x++){
                            abre[Integer.parseInt(requisitos[i][j])-1][x]+=""+((i+1)%2==0?(i+1)/2:(i+2)/2)+""+(i%2==0?1:2)+""+(j+1)+",";
                        }
                    }
                    if(requisitos[i][j].length()>3){
                        String[]numeros=requisitos[i][j].split(",");
                        for(int x=0;x<numeros.length;x++){
                            String[] nume = numeros[x].split("");
                            int num[]={Integer.parseInt(nume[1]),Integer.parseInt(nume[2]),Integer.parseInt(nume[3])};
                            abre[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)]+=""+((i+1)%2==0?(i+1)/2:(i+2)/2)+""+(i%2==0?1:2)+""+(j+1)+",";
                        }
                    }
                    if(requisitos[i][j].length()==3){
                        String[] nume = requisitos[i][j].split("");
                        int num[]={Integer.parseInt(nume[1]),Integer.parseInt(nume[2]),Integer.parseInt(nume[3])};
                        abre[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)]+=""+((i+1)%2==0?(i+1)/2:(i+2)/2)+""+(i%2==0?1:2)+""+(j+1)+",";
                    }
                }
            }
        }
        for(int i=0;i<this.getContentPane().getComponentCount();i++){
            if(this.getContentPane().getComponent(i).toString().startsWith("javax.swing.JLabel")){
                final JLabel paso =(JLabel)getContentPane().getComponent(i);
                if(!paso.getText().equals("")){
                    String[] nume = paso.getText().split("");
                    int num[]=new int[nume.length-1];
                    for(int j=0;j<num.length;j++){
                        num[j]=Integer.parseInt(nume[j+1]);
                    }
                    switch(num.length){
                        case 3:
                            paso.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    switch(e.getClickCount()){
                                        case 1:
                                            for(int i=0;i<etiquetas.length;i++){
                                                for(int j=0;j<etiquetas[i].length;j++){
                                                    etiquetas[i][j].setVisible(false);
                                                }
                                            }
                                            paso.setVisible(true);
                                            for(int i=0;i<etiquetas.length;i++){
                                                for(int j=0;j<etiquetas[i].length;j++){
                                                    if(paso.equals(etiquetas[i][j])){
                                                        mostrarAbre(abre[i][j]);
                                                        mostrarRequisitos(requisitos[i][j]);
                                                        setTitle(ramos[i][j]);
                                                    }
                                                }
                                            }
                                            for(int i=0;i<etiquetas.length;i++){
                                                for(int j=0;j<etiquetas[i].length;j++){
                                                    etiquetas[i][j].setVisible(false);
                                                }
                                            }
                                            paso.setVisible(true);
                                            for(int i=0;i<etiquetas.length;i++){
                                                for(int j=0;j<etiquetas[i].length;j++){
                                                    if(paso.equals(etiquetas[i][j])){
                                                        mostrarAbre(abre[i][j]);
                                                        mostrarRequisitos(requisitos[i][j]);
                                                        setTitle(ramos[i][j]);
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println(paso.getToolTipText());
                                            break;
                                    }
                                    
                                }
                            });
                            etiquetas[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)]=paso;
                            etiquetas[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)].
                                    setToolTipText(ramos[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)]);                        
                            break;
                        case 2:
                            paso.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    for(int i=0;i<etiquetas.length;i++){
                                        for(int j=0;j<etiquetas[i].length;j++){
                                            etiquetas[i][j].setVisible(false);
                                        }
                                    }
                                    for(int i=0;i<semestre.length;i++){
                                        if(paso.equals(semestre[i])){
                                            for(int x=0;x<etiquetas[i].length;x++){
                                                etiquetas[i][x].setVisible(true);
                                            }
                                            paso.setToolTipText((i+1)+"° semestre.");
                                            setTitle((i+1)+"° semestre.");
                                            break;
                                        }
                                    }                                }
                            });
                            semestre[(((num[0]*2)-(num[1]%2))-1)]=paso;
                            break;
                        case 1:
                            paso.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    for(int i=0;i<etiquetas.length;i++){
                                        for(int j=0;j<etiquetas[i].length;j++){
                                            etiquetas[i][j].setVisible(false);
                                        }
                                    }
                                    for(int i=0;i<año.length;i++){
                                        if(paso.equals(año[i])){
                                            for(int x=0;x<etiquetas[(i*2)].length;x++){
                                                etiquetas[(i*2)][x].setVisible(true);
                                            }
                                            for(int x=0;x<etiquetas[(i*2)+1].length;x++){
                                                etiquetas[(i*2)+1][x].setVisible(true);
                                            }
                                            paso.setToolTipText((i+1)+"° año.");
                                            setTitle((i+1)+"° año.");
                                            break;
                                        }
                                    }
                                }
                            });
                            año[num[0]-1]=paso;
                            break;
                    }
                    paso.setText("");
                }
            }
        }
        for(int i=0;i<abre.length;i++){
            for(int j=0;j<abre[i].length;j++){
                if(abre[i][j].equals("")){
                    abre[i][j]="0";
                }
                else{
                    abre[i][j]=abre[i][j].substring(0, abre[i][j].length()-1);
                }
            }
        }
    }
    String[][] ramos = {
        {"Matemática 1","Introducción a la Física","Iniciación a la Programación","Introducción a la Ingeniería Telemática","Educación Física I","Humanístico I"},
        {"Matemática 2","Física General I","Seminario de Programación","Educación Física 2","Expresión Oral y Escrita","Humanístico II"},
        {"Matemática 3","Física General 2","Estructura de Datos y Algoritmos","Redes de Computadores","Deportes","Inglés nivel 1"},
        {"Probabilidades y Procesos Aleatorios","Electrónica Digital","Laboratorio de Electrónica Digital","Bases de Datos","Química y Sociedad","Inglés nivel 2"},
        {"Física General 3","Fundam. Transmisión de Señales","Diseño y program. orientada a objetos","Análisis y Diseño de Software","Laboratorio de Redes de Computadores","Inglés nivel 3"},
        {"Matemática 4","Sistemas de Telecomunicaciones","Laboratorio de Comunicaciones","Ingeniería de Software","Teoría de Sistemas Operativos","Inglés nivel 4"},
        {"Análisis Numérico","Sistemas Digitales","Laboratorio de Sistemas Digitales","Pensamiento de Diseño en Ing.","DisponibilIdad y Redim. de sist. TIC","Inglés nivel 5"},
        {"Física General 4","Teoría de Comunicaciones Digitales","Criptografía y Seguridad de la Información","Administración de Servicios y Redes de Computadore","Diseño de Aplicaciones Web y Móviles","Inglés nivel 6"},
        {"Redes de Acceso y Comunicaciones Ópticas","Minería de Datos","Gestión de Investigación de Operaciones","Simulación de Redes","Seguridad en Redes de Computadores","Redes Inalámbricas"},
        {"Redes de Sensores","Planificación y Dimensionamiento de Redes de Computadores","Procesamiento Digital de Imágenes","Redes Ópticas WDM","Economía I-A","Complementario 1"},
        {"Memoria Multidisciplinaria: Transversal 1","Complementario 2","Complementario 3","Memoria Multidisciplinaria: Innovación","Proyecto de Titulación para ICT"},
        {"Memoria Multidisciplinaria: Transversal 2","Legislación Empresarial","Memoria Multidisciplinaria: Emprendimiento","Memoria de Titulación ICT","Electivo"}
    };
    JLabel[] semestre=new JLabel[ramos.length];
    JLabel[] año=new JLabel[ramos.length/2];
    JLabel[][] etiquetas = new JLabel[ramos.length][0];
    String[][] requisitos = {
        {"0","0","0","0","0","0"},
        {"111","112,111","113","115","0","0"},
        {"121","122,121","123","113","124","0"},
        {"121","121,212","222","213","0","216"},
        {"122,121","212,211","113","0","214","226"},
        {"211","312","312,211","314","123","316"},
        {"321","222","222","0","214,221","326"},
        {"212,311","221,322","221,222,123","0","224,313","416"},
        {"312,322,221","213,221,214,211","0","213,221,214","424,423","214,221"},
        {"315,516","221","221,313","214,221","211","0"},
        {"0","0","0","0","0"},
        {"0","0","0","615","0"}
    },abre= {
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","","",""},
        {"","","","",""},
        {"","","","",""}
    };
    
    
    public void mostrarAbre(String ramo){
        if(!ramo.equals("0")){
            if(ramo.length()==1){
                for(int i=0;i<etiquetas[Integer.parseInt(ramo)-1].length;i++){
                    etiquetas[Integer.parseInt(ramo)-1][i].setVisible(true);
                }
            }
            if(ramo.length()>3){
                String[]numeros=ramo.split(",");
                for(int i=0;i<numeros.length;i++){
                    String[] nume = numeros[i].split("");
                    int num[]={Integer.parseInt(nume[1]),Integer.parseInt(nume[2]),Integer.parseInt(nume[3])};
                    etiquetas[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)].setVisible(true);
                }
            }
            if(ramo.length()==3){
                String[] nume = ramo.split("");
                int num[]={Integer.parseInt(nume[1]),Integer.parseInt(nume[2]),Integer.parseInt(nume[3])};
                etiquetas[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)].setVisible(true);
            }
        }
    }
    
    public void mostrarRequisitos(String ramo){
        if(!ramo.equals("0")){
            if(ramo.length()==1){
                for(int i=0;i<etiquetas[Integer.parseInt(ramo)-1].length;i++){
                    etiquetas[Integer.parseInt(ramo)-1][i].setVisible(true);
                }
            }
            if(ramo.length()>3){
                String[]numeros=ramo.split(",");
                for(int i=0;i<numeros.length;i++){
                    String[] nume = numeros[i].split("");
                    int num[]={Integer.parseInt(nume[1]),Integer.parseInt(nume[2]),Integer.parseInt(nume[3])};
                    etiquetas[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)].setVisible(true);
                }
            }
            if(ramo.length()==3){
                String[] nume = ramo.split("");
                int num[]={Integer.parseInt(nume[1]),Integer.parseInt(nume[2]),Integer.parseInt(nume[3])};
                etiquetas[(((num[0]*2)-(num[1]%2))-1)][(num[2]-1)].setVisible(true);
            }
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/1.png"))); // NOI18N
        jLabel1.setText("1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 200, 24);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/2.png"))); // NOI18N
        jLabel2.setText("2");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 10, 199, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/3.png"))); // NOI18N
        jLabel3.setText("3");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 10, 199, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/4.png"))); // NOI18N
        jLabel4.setText("4");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(640, 10, 199, 22);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/5.png"))); // NOI18N
        jLabel5.setText("5");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(850, 10, 199, 22);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/11.png"))); // NOI18N
        jLabel6.setText("11");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 40, 100, 22);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/21.png"))); // NOI18N
        jLabel7.setText("21");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(220, 40, 100, 22);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/31.png"))); // NOI18N
        jLabel8.setText("31");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(430, 40, 100, 22);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/41.png"))); // NOI18N
        jLabel9.setText("41");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(640, 40, 100, 22);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/51.png"))); // NOI18N
        jLabel10.setText("51");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(850, 40, 100, 22);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/12.png"))); // NOI18N
        jLabel11.setText("12");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(110, 40, 100, 22);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/22.png"))); // NOI18N
        jLabel12.setText("22");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(320, 40, 100, 22);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/32.png"))); // NOI18N
        jLabel13.setText("32");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(530, 40, 100, 22);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/42.png"))); // NOI18N
        jLabel14.setText("42");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(740, 40, 100, 22);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/52.png"))); // NOI18N
        jLabel15.setText("52");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(950, 40, 100, 22);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/111.png"))); // NOI18N
        jLabel16.setText("111");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 70, 80, 99);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/211.png"))); // NOI18N
        jLabel17.setText("211");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(230, 70, 80, 99);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/311.png"))); // NOI18N
        jLabel18.setText("311");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel18);
        jLabel18.setBounds(440, 70, 80, 99);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/411.png"))); // NOI18N
        jLabel19.setText("411");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(650, 70, 84, 99);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/121.png"))); // NOI18N
        jLabel21.setText("121");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel21);
        jLabel21.setBounds(120, 70, 80, 99);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/221.png"))); // NOI18N
        jLabel22.setText("221");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(330, 70, 84, 99);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/321.png"))); // NOI18N
        jLabel23.setText("321");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(540, 70, 84, 99);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/421.png"))); // NOI18N
        jLabel24.setText("421");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel24);
        jLabel24.setBounds(750, 70, 80, 99);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/112.png"))); // NOI18N
        jLabel26.setText("112");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel26);
        jLabel26.setBounds(20, 170, 80, 106);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/212.png"))); // NOI18N
        jLabel27.setText("212");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(230, 170, 80, 106);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/312.png"))); // NOI18N
        jLabel28.setText("312");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel28);
        jLabel28.setBounds(440, 170, 80, 106);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/412.png"))); // NOI18N
        jLabel29.setText("412");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(650, 170, 80, 106);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/122.png"))); // NOI18N
        jLabel31.setText("122");
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel31);
        jLabel31.setBounds(120, 170, 80, 106);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/222.png"))); // NOI18N
        jLabel32.setText("222");
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel32);
        jLabel32.setBounds(330, 170, 80, 106);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/322.png"))); // NOI18N
        jLabel33.setText("322");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel33);
        jLabel33.setBounds(540, 170, 80, 106);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/422.png"))); // NOI18N
        jLabel34.setText("422");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel34);
        jLabel34.setBounds(750, 170, 80, 106);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/113.png"))); // NOI18N
        jLabel35.setText("113");
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel35);
        jLabel35.setBounds(20, 280, 84, 106);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/213.png"))); // NOI18N
        jLabel36.setText("213");
        jLabel36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel36);
        jLabel36.setBounds(230, 280, 80, 106);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/123.png"))); // NOI18N
        jLabel37.setText("123");
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel37);
        jLabel37.setBounds(120, 280, 84, 106);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/313.png"))); // NOI18N
        jLabel38.setText("313");
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel38);
        jLabel38.setBounds(440, 280, 80, 106);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/413.png"))); // NOI18N
        jLabel39.setText("413");
        jLabel39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel39);
        jLabel39.setBounds(650, 280, 80, 106);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/223.png"))); // NOI18N
        jLabel41.setText("223");
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel41);
        jLabel41.setBounds(330, 280, 80, 106);

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/323.png"))); // NOI18N
        jLabel42.setText("323");
        jLabel42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel42);
        jLabel42.setBounds(540, 280, 80, 106);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/423.png"))); // NOI18N
        jLabel43.setText("423");
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel43);
        jLabel43.setBounds(750, 280, 80, 106);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/114.png"))); // NOI18N
        jLabel44.setText("114");
        jLabel44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel44);
        jLabel44.setBounds(20, 390, 80, 108);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/214.png"))); // NOI18N
        jLabel45.setText("214");
        jLabel45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel45);
        jLabel45.setBounds(230, 390, 84, 108);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/314.png"))); // NOI18N
        jLabel46.setText("314");
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel46);
        jLabel46.setBounds(440, 390, 80, 108);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/414.png"))); // NOI18N
        jLabel47.setText("414");
        jLabel47.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel47);
        jLabel47.setBounds(650, 390, 84, 108);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/124.png"))); // NOI18N
        jLabel49.setText("124");
        jLabel49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel49);
        jLabel49.setBounds(120, 390, 80, 106);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/224.png"))); // NOI18N
        jLabel50.setText("224");
        jLabel50.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel50);
        jLabel50.setBounds(330, 390, 80, 108);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/324.png"))); // NOI18N
        jLabel51.setText("324");
        jLabel51.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel51);
        jLabel51.setBounds(540, 390, 80, 108);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/424.png"))); // NOI18N
        jLabel52.setText("424");
        jLabel52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel52);
        jLabel52.setBounds(750, 390, 84, 108);

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/115.png"))); // NOI18N
        jLabel53.setText("115");
        jLabel53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel53);
        jLabel53.setBounds(20, 500, 80, 106);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/215.png"))); // NOI18N
        jLabel54.setText("215");
        jLabel54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel54);
        jLabel54.setBounds(230, 500, 80, 106);

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/315.png"))); // NOI18N
        jLabel55.setText("315");
        jLabel55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel55);
        jLabel55.setBounds(440, 500, 84, 106);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/415.png"))); // NOI18N
        jLabel56.setText("415");
        jLabel56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel56);
        jLabel56.setBounds(650, 500, 84, 106);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/125.png"))); // NOI18N
        jLabel58.setText("125");
        jLabel58.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel58);
        jLabel58.setBounds(120, 500, 80, 106);

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/225.png"))); // NOI18N
        jLabel59.setText("225");
        jLabel59.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel59);
        jLabel59.setBounds(330, 500, 80, 106);

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/325.png"))); // NOI18N
        jLabel60.setText("325");
        jLabel60.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel60);
        jLabel60.setBounds(540, 500, 80, 106);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/425.png"))); // NOI18N
        jLabel61.setText("425");
        jLabel61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel61);
        jLabel61.setBounds(750, 500, 80, 106);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/116.png"))); // NOI18N
        jLabel62.setText("116");
        jLabel62.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel62);
        jLabel62.setBounds(20, 610, 80, 100);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/216.png"))); // NOI18N
        jLabel63.setText("216");
        jLabel63.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel63);
        jLabel63.setBounds(230, 610, 80, 100);

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/316.png"))); // NOI18N
        jLabel64.setText("316");
        jLabel64.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel64);
        jLabel64.setBounds(440, 610, 80, 100);

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/416.png"))); // NOI18N
        jLabel65.setText("416");
        jLabel65.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel65);
        jLabel65.setBounds(650, 610, 80, 100);

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/126.png"))); // NOI18N
        jLabel67.setText("126");
        jLabel67.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel67);
        jLabel67.setBounds(120, 610, 80, 100);

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/226.png"))); // NOI18N
        jLabel68.setText("226");
        jLabel68.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel68);
        jLabel68.setBounds(330, 610, 80, 100);

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/326.png"))); // NOI18N
        jLabel69.setText("326");
        jLabel69.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel69);
        jLabel69.setBounds(540, 610, 80, 100);

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/426.png"))); // NOI18N
        jLabel70.setText("426");
        jLabel70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel70);
        jLabel70.setBounds(750, 610, 80, 100);

        btnVer.setText("Ver Todo");
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        getContentPane().add(btnVer);
        btnVer.setBounds(180, 730, 75, 23);

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/511.png"))); // NOI18N
        jLabel71.setText("511");
        jLabel71.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel71);
        jLabel71.setBounds(860, 70, 80, 99);

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/521.png"))); // NOI18N
        jLabel72.setText("521");
        jLabel72.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel72);
        jLabel72.setBounds(960, 70, 80, 108);

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/512.png"))); // NOI18N
        jLabel73.setText("512");
        jLabel73.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel73);
        jLabel73.setBounds(860, 170, 80, 106);

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/522.png"))); // NOI18N
        jLabel74.setText("522");
        jLabel74.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel74);
        jLabel74.setBounds(960, 180, 80, 106);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/513.png"))); // NOI18N
        jLabel75.setText("513");
        jLabel75.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel75);
        jLabel75.setBounds(860, 280, 80, 106);

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/523.png"))); // NOI18N
        jLabel76.setText("523");
        jLabel76.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel76);
        jLabel76.setBounds(960, 290, 80, 106);

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/514.png"))); // NOI18N
        jLabel77.setText("514");
        jLabel77.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel77);
        jLabel77.setBounds(860, 390, 80, 108);

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/524.png"))); // NOI18N
        jLabel90.setText("524");
        jLabel90.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel90);
        jLabel90.setBounds(960, 400, 80, 99);

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/515.png"))); // NOI18N
        jLabel96.setText("515");
        jLabel96.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel96);
        jLabel96.setBounds(860, 500, 84, 106);

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/525.png"))); // NOI18N
        jLabel98.setText("525");
        jLabel98.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel98);
        jLabel98.setBounds(960, 500, 80, 106);

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/516.png"))); // NOI18N
        jLabel99.setText("516");
        jLabel99.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel99);
        jLabel99.setBounds(860, 610, 84, 100);

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/526.png"))); // NOI18N
        jLabel100.setText("526");
        jLabel100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel100);
        jLabel100.setBounds(960, 610, 80, 100);

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/6.png"))); // NOI18N
        jLabel101.setText("6");
        jLabel101.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel101);
        jLabel101.setBounds(1060, 10, 199, 22);

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/61.png"))); // NOI18N
        jLabel102.setText("61");
        jLabel102.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel102);
        jLabel102.setBounds(1060, 40, 100, 22);

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/62.png"))); // NOI18N
        jLabel103.setText("62");
        jLabel103.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel103);
        jLabel103.setBounds(1160, 40, 100, 22);

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/611.png"))); // NOI18N
        jLabel104.setText("611");
        jLabel104.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel104);
        jLabel104.setBounds(1070, 180, 80, 106);

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/621.png"))); // NOI18N
        jLabel105.setText("621");
        jLabel105.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel105);
        jLabel105.setBounds(1170, 180, 80, 106);

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/612.png"))); // NOI18N
        jLabel106.setText("612");
        jLabel106.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel106);
        jLabel106.setBounds(1070, 290, 80, 106);

        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/622.png"))); // NOI18N
        jLabel107.setText("622");
        jLabel107.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel107);
        jLabel107.setBounds(1170, 290, 80, 106);

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/613.png"))); // NOI18N
        jLabel108.setText("613");
        jLabel108.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel108);
        jLabel108.setBounds(1070, 400, 80, 108);

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/623.png"))); // NOI18N
        jLabel109.setText("623");
        jLabel109.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel109);
        jLabel109.setBounds(1170, 400, 80, 108);

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/614.png"))); // NOI18N
        jLabel110.setText("614");
        jLabel110.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel110);
        jLabel110.setBounds(1070, 510, 80, 106);

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/624.png"))); // NOI18N
        jLabel111.setText("624");
        jLabel111.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel111);
        jLabel111.setBounds(1170, 510, 80, 106);

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/615.png"))); // NOI18N
        jLabel112.setText("615");
        jLabel112.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel112);
        jLabel112.setBounds(1070, 620, 80, 106);

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/625.png"))); // NOI18N
        jLabel113.setText("625");
        jLabel113.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel113);
        jLabel113.setBounds(1170, 620, 80, 106);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<etiquetas.length;i++){
            for(int j=0;j<etiquetas[i].length;j++){
                etiquetas[i][j].setVisible(true);
            }
        }
        setTitle("Malla Curricular");
    }//GEN-LAST:event_btnVerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new frmMalla().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    // End of variables declaration//GEN-END:variables
}
