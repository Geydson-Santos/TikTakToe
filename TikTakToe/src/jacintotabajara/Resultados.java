/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jacintotabajara;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.util.Random;
import java.awt.event.MouseEvent;

/**
 *
 * @author ALUNO
 */
public class Resultados extends javax.swing.JFrame {

    /**
     * Creates new form Resultados
     */
    
    public static int matrizResultado[][] = new int[2][5];
    int matrizA[][] = new int[2][5];
    int matrizB[][] = new int[2][5];
    int matrizC[][] = new int[5][2];
    boolean clickmatrizC;
    int matrizD[][] = new int[2][5];
    int matrizE[][] = new int[2][5];
    int matrizF[][] = new int[2][2];
    String variavelB1, variavelO1, variavelH1;
    boolean clickvariavel;
    String valorBase = "";
    int soma = 0;
    boolean Matrizes[] = new boolean[10]; // Para mudar o cursor
    
    public Resultados() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/favicon.png")));
        initComponents();
        this.setLocationRelativeTo(null);
        
        /*
        Random random = new Random();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                matrizResultado[i][j] = random.nextInt(10) + 1;
            }
        }*/
        
        calculoMatrizes();
        tpVisibilidade(false);
        varVisibilidade(false);
        setarMatrizResultado();
        
        setarMatriz(matrizResultado);
        
        Matrizes[0] = true;
        jPanelMatrizResultado.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
        jPanelMatrizResultado.setBackground(new Color(200,51,51));
    }
    
   public void setarMatrizResultado(){
        jLabelJogador1.setText(TelaPrincipal.jogador1);
        jLabelJogador2.setText(TelaPrincipal.jogador2);
        jLabel00.setText(""+matrizResultado[0][0]);
        jLabel01.setText(""+matrizResultado[0][1]);
        jLabel02.setText(""+matrizResultado[0][2]);
        jLabel03.setText(""+matrizResultado[0][3]);
        jLabel04.setText(""+matrizResultado[0][4]);
        jLabel10.setText(""+matrizResultado[1][0]);
        jLabel11.setText(""+matrizResultado[1][1]);
        jLabel12.setText(""+matrizResultado[1][2]);
        jLabel13.setText(""+matrizResultado[1][3]);
        jLabel14.setText(""+matrizResultado[1][4]);
        
        jLabelMatrizTransposta00.setText(""+matrizC[0][0]);
        jLabelMatrizTransposta01.setText(""+matrizC[1][0]);
        jLabelMatrizTransposta02.setText(""+matrizC[2][0]);
        jLabelMatrizTransposta03.setText(""+matrizC[3][0]);
        jLabelMatrizTransposta04.setText(""+matrizC[4][0]);
        jLabelMatrizTransposta10.setText(""+matrizC[0][1]);
        jLabelMatrizTransposta11.setText(""+matrizC[1][1]);
        jLabelMatrizTransposta12.setText(""+matrizC[2][1]);
        jLabelMatrizTransposta13.setText(""+matrizC[3][1]);
        jLabelMatrizTransposta14.setText(""+matrizC[4][1]);
   }
    
    public void calculoMatrizes(){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                matrizA[i][j] = matrizResultado[i][j];
                matrizB[i][j] = matrizResultado[i][4-j];
                matrizC[j][i] = matrizA[i][j];
                matrizD[i][j] = matrizA[i][j] + matrizB[i][j];
                matrizE[i][j] = matrizA[i][j] - matrizB[i][j];
                for(int k = 0; k < 2; k++){
                    matrizF[k][i] = matrizResultado[k][0] * matrizC[0][i] + matrizResultado[k][1] * matrizC[1][i] + matrizResultado[k][2] * matrizC[2][i] + matrizResultado[k][3] * matrizC[3][i] + matrizResultado[k][4] * matrizC[4][i];
                }
                                
                soma += matrizResultado[i][j];
            }
        }
        
        variavelB1 = inverter(soma, 2, valorBase);
        variavelO1 = inverter(soma, 8, valorBase);
        variavelH1 = inverter(soma, 16, valorBase);
        
    }
    
    public String inverter(int n, int divisor, String texto){
        while(n > 0){
            if(n%divisor >= 10){
                if(n%divisor == 10){
                    texto+= "A";
                }
                if(n%divisor == 11){
                    texto+= "B";
                }
                if(n%divisor == 12){
                    texto+= "C";
                }
                if(n%divisor == 13){
                    texto+= "D";
                }
                if(n%divisor == 14){
                    texto+= "E";
                }
                if(n%divisor == 15){
                    texto+= "F";
                }
            }else{
                texto += n%divisor;
            }
            n = n/divisor;
        }
        
        StringBuilder strb = new StringBuilder(texto);
        texto = strb.reverse().toString();
        return texto;
    }
    
    public void setarMatriz(int matriz[][]){
        jLabelMatriz00.setText(""+matriz[0][0]);
        jLabelMatriz01.setText(""+matriz[0][1]);
        jLabelMatriz02.setText(""+matriz[0][2]);
        jLabelMatriz03.setText(""+matriz[0][3]);
        jLabelMatriz04.setText(""+matriz[0][4]);
        jLabelMatriz10.setText(""+matriz[1][0]);
        jLabelMatriz11.setText(""+matriz[1][1]);
        jLabelMatriz12.setText(""+matriz[1][2]);
        jLabelMatriz13.setText(""+matriz[1][3]);
        jLabelMatriz14.setText(""+matriz[1][4]);
    }
    
    public void setarCursor(){
        jPanelMatrizResultado.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelMatrizA.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelMatrizB.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        //jPanelMatrizC.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelMatrizD.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelMatrizE.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelMatrizF.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelVariavelB1.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelVariavelO1.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
        jPanelVariavelH1.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }
    
    public void tpVisibilidade(boolean visivel){
        jLabelMatrizTransposta.setVisible(visivel);
        jPanel13.setVisible(visivel);
        jPanel15.setVisible(visivel);
        jPanel16.setVisible(visivel);
        jPanel17.setVisible(visivel);
        jPanel18.setVisible(visivel);
        jPanel19.setVisible(visivel);
        jLabelMatrizTransposta00.setVisible(visivel);
        jLabelMatrizTransposta01.setVisible(visivel);
        jLabelMatrizTransposta02.setVisible(visivel);
        jLabelMatrizTransposta03.setVisible(visivel);
        jLabelMatrizTransposta04.setVisible(visivel);
        jLabelMatrizTransposta10.setVisible(visivel);
        jLabelMatrizTransposta11.setVisible(visivel);
        jLabelMatrizTransposta12.setVisible(visivel);
        jLabelMatrizTransposta13.setVisible(visivel);
        jLabelMatrizTransposta14.setVisible(visivel);
    }
    
    public void varVisibilidade(boolean visivel){
        clickvariavel = visivel;
        jLabelNomeVariavel.setVisible(visivel);
        jLabelNumeroVariavel.setVisible(visivel);
    }
    
    public void setBackground(){
        jPanelMatrizResultado.setBackground(new Color(51,51,255));
        jPanelMatrizA.setBackground(new Color(51,51,255));
        jPanelMatrizB.setBackground(new Color(51,51,255));
        jPanelMatrizD.setBackground(new Color(51,51,255));
        jPanelMatrizE.setBackground(new Color(51,51,255));
        jPanelMatrizF.setBackground(new Color(51,51,255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelJogador1 = new javax.swing.JLabel();
        jLabel00 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel04 = new javax.swing.JLabel();
        jLabelJogador2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabelMatriz00 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelMatriz01 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabelMatriz02 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabelMatriz03 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabelMatriz04 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabelMatriz10 = new javax.swing.JLabel();
        jLabelMatriz11 = new javax.swing.JLabel();
        jLabelMatriz12 = new javax.swing.JLabel();
        jLabelMatriz13 = new javax.swing.JLabel();
        jLabelMatriz14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabelMatriz = new javax.swing.JLabel();
        jPanelMatrizResultado = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanelMatrizA = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanelMatrizB = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanelMatrizC = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanelMatrizD = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanelMatrizE = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanelMatrizF = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanelVariavelB1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanelVariavelO1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanelVariavelH1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabelMatrizTransposta = new javax.swing.JLabel();
        jLabelMatrizTransposta00 = new javax.swing.JLabel();
        jLabelMatrizTransposta10 = new javax.swing.JLabel();
        jLabelMatrizTransposta01 = new javax.swing.JLabel();
        jLabelMatrizTransposta11 = new javax.swing.JLabel();
        jLabelMatrizTransposta02 = new javax.swing.JLabel();
        jLabelMatrizTransposta12 = new javax.swing.JLabel();
        jLabelMatrizTransposta03 = new javax.swing.JLabel();
        jLabelMatrizTransposta13 = new javax.swing.JLabel();
        jLabelMatrizTransposta04 = new javax.swing.JLabel();
        jLabelMatrizTransposta14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabelNomeVariavel = new javax.swing.JLabel();
        jLabelNumeroVariavel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIK TAK TOE - RESULTADOS");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(812, 372));

        jLabelTitle.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Resultados");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jogador");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel4.setText("Rodada 1");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel5.setText("Rodada 2");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel6.setText("Rodada 3");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel7.setText("Rodada 4");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel8.setText("Rodada 5");

        jLabelJogador1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelJogador1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJogador1.setText("Jogador 1");

        jLabel00.setBackground(new java.awt.Color(255, 255, 255));
        jLabel00.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setText("0");

        jLabel01.setBackground(new java.awt.Color(255, 255, 255));
        jLabel01.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setText("0");

        jLabel02.setBackground(new java.awt.Color(255, 255, 255));
        jLabel02.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setText("0");

        jLabel03.setBackground(new java.awt.Color(255, 255, 255));
        jLabel03.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel03.setText("0");

        jLabel04.setBackground(new java.awt.Color(255, 255, 255));
        jLabel04.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel04.setText("0");

        jLabelJogador2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelJogador2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJogador2.setText("Jogador 2");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("0");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("0");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("0");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("0");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(2, 75));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(2, 75));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(2, 75));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(2, 75));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(2, 75));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jLabelMatriz00.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz00.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz00.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz00.setText("0");

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(2, 50));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabelMatriz01.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz01.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz01.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz01.setText("0");

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setPreferredSize(new java.awt.Dimension(2, 50));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabelMatriz02.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz02.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz02.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz02.setText("0");

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(2, 50));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabelMatriz03.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz03.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz03.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz03.setText("0");

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setPreferredSize(new java.awt.Dimension(2, 50));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabelMatriz04.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz04.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz04.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz04.setText("0");

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setPreferredSize(new java.awt.Dimension(2, 50));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabelMatriz10.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz10.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz10.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz10.setText("0");

        jLabelMatriz11.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz11.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz11.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz11.setText("0");

        jLabelMatriz12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz12.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz12.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz12.setText("0");

        jLabelMatriz13.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz13.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz13.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz13.setText("0");

        jLabelMatriz14.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatriz14.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatriz14.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz14.setText("0");

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(2, 50));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabelMatriz.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabelMatriz.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatriz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatriz.setText("Matriz Resultado");

        jPanelMatrizResultado.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizResultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizResultado.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizResultadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizResultadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizResultadoMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Matriz Resultado");
        jLabel16.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizResultadoLayout = new javax.swing.GroupLayout(jPanelMatrizResultado);
        jPanelMatrizResultado.setLayout(jPanelMatrizResultadoLayout);
        jPanelMatrizResultadoLayout.setHorizontalGroup(
            jPanelMatrizResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanelMatrizResultadoLayout.setVerticalGroup(
            jPanelMatrizResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizResultadoLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMatrizA.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizA.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizAMouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Matriz A");
        jLabel17.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizALayout = new javax.swing.GroupLayout(jPanelMatrizA);
        jPanelMatrizA.setLayout(jPanelMatrizALayout);
        jPanelMatrizALayout.setHorizontalGroup(
            jPanelMatrizALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanelMatrizALayout.setVerticalGroup(
            jPanelMatrizALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizALayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMatrizB.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizB.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizBMouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Matriz B");
        jLabel18.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizBLayout = new javax.swing.GroupLayout(jPanelMatrizB);
        jPanelMatrizB.setLayout(jPanelMatrizBLayout);
        jPanelMatrizBLayout.setHorizontalGroup(
            jPanelMatrizBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanelMatrizBLayout.setVerticalGroup(
            jPanelMatrizBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizBLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMatrizC.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizC.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizCMouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Matriz C");
        jLabel19.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizCLayout = new javax.swing.GroupLayout(jPanelMatrizC);
        jPanelMatrizC.setLayout(jPanelMatrizCLayout);
        jPanelMatrizCLayout.setHorizontalGroup(
            jPanelMatrizCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanelMatrizCLayout.setVerticalGroup(
            jPanelMatrizCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizCLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMatrizD.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizD.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizDMouseExited(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Matriz D");
        jLabel20.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizDLayout = new javax.swing.GroupLayout(jPanelMatrizD);
        jPanelMatrizD.setLayout(jPanelMatrizDLayout);
        jPanelMatrizDLayout.setHorizontalGroup(
            jPanelMatrizDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanelMatrizDLayout.setVerticalGroup(
            jPanelMatrizDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizDLayout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMatrizE.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizE.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizEMouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Matriz E");
        jLabel21.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizELayout = new javax.swing.GroupLayout(jPanelMatrizE);
        jPanelMatrizE.setLayout(jPanelMatrizELayout);
        jPanelMatrizELayout.setHorizontalGroup(
            jPanelMatrizELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        jPanelMatrizELayout.setVerticalGroup(
            jPanelMatrizELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizELayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelMatrizF.setBackground(new java.awt.Color(51, 51, 255));
        jPanelMatrizF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMatrizF.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelMatrizF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMatrizFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMatrizFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMatrizFMouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Matriz F");
        jLabel22.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelMatrizFLayout = new javax.swing.GroupLayout(jPanelMatrizF);
        jPanelMatrizF.setLayout(jPanelMatrizFLayout);
        jPanelMatrizFLayout.setHorizontalGroup(
            jPanelMatrizFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jPanelMatrizFLayout.setVerticalGroup(
            jPanelMatrizFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatrizFLayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelVariavelB1.setBackground(new java.awt.Color(51, 51, 255));
        jPanelVariavelB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVariavelB1.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelVariavelB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelVariavelB1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelVariavelB1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelVariavelB1MouseExited(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("B1");
        jLabel23.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelVariavelB1Layout = new javax.swing.GroupLayout(jPanelVariavelB1);
        jPanelVariavelB1.setLayout(jPanelVariavelB1Layout);
        jPanelVariavelB1Layout.setHorizontalGroup(
            jPanelVariavelB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanelVariavelB1Layout.setVerticalGroup(
            jPanelVariavelB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVariavelB1Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelVariavelO1.setBackground(new java.awt.Color(51, 51, 255));
        jPanelVariavelO1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVariavelO1.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelVariavelO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelVariavelO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelVariavelO1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelVariavelO1MouseExited(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("O1");
        jLabel24.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelVariavelO1Layout = new javax.swing.GroupLayout(jPanelVariavelO1);
        jPanelVariavelO1.setLayout(jPanelVariavelO1Layout);
        jPanelVariavelO1Layout.setHorizontalGroup(
            jPanelVariavelO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanelVariavelO1Layout.setVerticalGroup(
            jPanelVariavelO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVariavelO1Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelVariavelH1.setBackground(new java.awt.Color(51, 51, 255));
        jPanelVariavelH1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVariavelH1.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanelVariavelH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelVariavelH1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelVariavelH1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelVariavelH1MouseExited(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("H1");
        jLabel25.setPreferredSize(new java.awt.Dimension(125, 25));

        javax.swing.GroupLayout jPanelVariavelH1Layout = new javax.swing.GroupLayout(jPanelVariavelH1);
        jPanelVariavelH1.setLayout(jPanelVariavelH1Layout);
        jPanelVariavelH1Layout.setHorizontalGroup(
            jPanelVariavelH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanelVariavelH1Layout.setVerticalGroup(
            jPanelVariavelH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVariavelH1Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelMatrizTransposta.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabelMatrizTransposta.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta.setText("Matriz Transposta");

        jLabelMatrizTransposta00.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta00.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta00.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta00.setText("0");

        jLabelMatrizTransposta10.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta10.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta10.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta10.setText("0");

        jLabelMatrizTransposta01.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta01.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta01.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta01.setText("0");

        jLabelMatrizTransposta11.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta11.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta11.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta11.setText("0");

        jLabelMatrizTransposta02.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta02.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta02.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta02.setText("0");

        jLabelMatrizTransposta12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta12.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta12.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta12.setText("0");

        jLabelMatrizTransposta03.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta03.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta03.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta03.setText("0");

        jLabelMatrizTransposta13.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta13.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta13.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta13.setText("0");

        jLabelMatrizTransposta04.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta04.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta04.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta04.setText("0");

        jLabelMatrizTransposta14.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMatrizTransposta14.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelMatrizTransposta14.setForeground(new java.awt.Color(244, 67, 54));
        jLabelMatrizTransposta14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMatrizTransposta14.setText("0");

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));
        jPanel17.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(0, 0, 0));
        jPanel19.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabelNomeVariavel.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabelNomeVariavel.setForeground(new java.awt.Color(244, 67, 54));
        jLabelNomeVariavel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeVariavel.setText("Variável B1");

        jLabelNumeroVariavel.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumeroVariavel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelNumeroVariavel.setForeground(new java.awt.Color(244, 67, 54));
        jLabelNumeroVariavel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumeroVariavel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabelMatriz))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel00, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelMatriz00, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMatriz10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMatriz11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMatriz01, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelMatriz02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMatriz12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelMatriz03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMatriz13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelMatriz04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMatriz14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanelMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelMatrizC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelMatrizE, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelVariavelB1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelVariavelO1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanelVariavelH1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanelMatrizResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelMatrizD, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelMatrizF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMatrizTransposta00, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMatrizTransposta01, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMatrizTransposta10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMatrizTransposta11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMatrizTransposta03, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMatrizTransposta02, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelMatrizTransposta12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelMatrizTransposta04, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabelMatrizTransposta14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelMatrizTransposta, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMatrizTransposta13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(17, 17, 17)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelNumeroVariavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNomeVariavel))
                        .addGap(40, 40, 40))))
            .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTitle)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel5))
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel00)
                                                .addComponent(jLabel01)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(25, 25, 25)
                                            .addComponent(jLabelJogador1)))
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelJogador2)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel02)
                                    .addComponent(jLabel03)
                                    .addComponent(jLabel04))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14)))))
                        .addGap(35, 35, 35)
                        .addComponent(jLabelMatriz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelMatriz00)
                                    .addComponent(jLabelMatriz01))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelMatriz10)
                                    .addComponent(jLabelMatriz11)))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMatriz02)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMatriz03)
                                        .addComponent(jLabelMatriz04)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelMatriz12)
                                            .addComponent(jLabelMatriz14)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelMatriz13)
                                        .addGap(1, 1, 1))))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelMatrizResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanelMatrizD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanelMatrizB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanelMatrizF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPanelMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanelMatrizC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanelVariavelH1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanelVariavelO1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanelMatrizE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelVariavelB1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMatrizTransposta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMatrizTransposta00)
                            .addComponent(jLabelMatrizTransposta10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMatrizTransposta01)
                            .addComponent(jLabelMatrizTransposta11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMatrizTransposta12)
                            .addComponent(jLabelMatrizTransposta02, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMatrizTransposta03)
                            .addComponent(jLabelMatrizTransposta13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMatrizTransposta04)
                            .addComponent(jLabelMatrizTransposta14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNomeVariavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumeroVariavel)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelVariavelH1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelH1MouseExited
        // TODO add your handling code here:
        if(!Matrizes[9]){
            jPanelVariavelH1.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelVariavelH1MouseExited

    private void jPanelVariavelH1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelH1MouseEntered
        // TODO add your handling code here:
        if(!Matrizes[9]){
            jPanelVariavelH1.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelVariavelH1MouseEntered

    private void jPanelVariavelH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelH1MouseClicked
        // TODO add your handling code here:
        if(!Matrizes[9]){ // Se o botão ainda não foi clicado
            if(!clickvariavel){
                varVisibilidade(true);
            }else{
                jPanelVariavelB1.setBackground(new Color(51,51,255));
                Matrizes[7] = false;
                jPanelVariavelO1.setBackground(new Color(51,51,255));
                Matrizes[8] = false;
            }
            
            /*
            for(int i = 0; i < 10; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
                setarCursor();
            }*/
            Matrizes[9] = true; // Essa agora é verdadeira
            //jPanelVariavelH1.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jLabelNomeVariavel.setText("Variável H1");
            jLabelNumeroVariavel.setText(""+variavelH1);
            jPanelVariavelH1.setBackground(new Color(200,51,51));
        }else{
            varVisibilidade(false);
            Matrizes[9] = false;
            jPanelVariavelH1.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelVariavelH1MouseClicked

    private void jPanelVariavelO1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelO1MouseExited
        // TODO add your handling code here:
        if(!Matrizes[8]){
            jPanelVariavelO1.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelVariavelO1MouseExited

    private void jPanelVariavelO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelO1MouseEntered
        // TODO add your handling code here:
        if(!Matrizes[8]){
            jPanelVariavelO1.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelVariavelO1MouseEntered

    private void jPanelVariavelO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelO1MouseClicked
        // TODO add your handling code here:
        if(!Matrizes[8]){ // Se o botão ainda não foi clicado
            if(!clickvariavel){
                varVisibilidade(true);
            }else{
                jPanelVariavelB1.setBackground(new Color(51,51,255));
                Matrizes[7] = false;
                jPanelVariavelH1.setBackground(new Color(51,51,255));
                Matrizes[9] = false;
            }
            
            /*
            for(int i = 0; i < 10; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
                setarCursor();
            }*/
            Matrizes[8] = true; // Essa agora é verdadeira
            //jPanelVariavelO1.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jLabelNomeVariavel.setText("Variável O1");
            jLabelNumeroVariavel.setText(""+variavelO1);
            jPanelVariavelO1.setBackground(new Color(200,51,51));
        }else{
            varVisibilidade(false);
            Matrizes[8] = false;
            jPanelVariavelO1.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelVariavelO1MouseClicked

    private void jPanelVariavelB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelB1MouseExited
        // TODO add your handling code here:
        if(!Matrizes[7]){
            jPanelVariavelB1.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelVariavelB1MouseExited

    private void jPanelVariavelB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelB1MouseEntered
        // TODO add your handling code here:
        if(!Matrizes[7]){
            jPanelVariavelB1.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelVariavelB1MouseEntered

    private void jPanelVariavelB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVariavelB1MouseClicked
        // TODO add your handling code here:
        if(!Matrizes[7]){ // Se o botão ainda não foi clicado
            if(!clickvariavel){
                varVisibilidade(true);
            }else{
                jPanelVariavelO1.setBackground(new Color(51,51,255));
                Matrizes[8] = false;
                jPanelVariavelH1.setBackground(new Color(51,51,255));
                Matrizes[9] = false;
            }
            
            /*
            for(int i = 0; i < 10; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
                setarCursor();
            }*/
            
            Matrizes[7] = true; // Essa agora é verdadeira
            //jPanelVariavelB1.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jLabelNomeVariavel.setText("Variável B1");
            jLabelNumeroVariavel.setText(""+variavelB1);
            jPanelVariavelB1.setBackground(new Color(200,51,51));
        }else{
            varVisibilidade(false);
            Matrizes[7] = false;
            jPanelVariavelB1.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelVariavelB1MouseClicked

    private void jPanelMatrizFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizFMouseExited
        // TODO add your handling code here:
        if(!Matrizes[6]){
            jPanelMatrizF.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizFMouseExited

    private void jPanelMatrizFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizFMouseEntered
        // TODO add your handling code here:
        if(!Matrizes[6]){
            jPanelMatrizF.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizFMouseEntered

    private void jPanelMatrizFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizFMouseClicked
        // TODO add your handling code here:
        if(!Matrizes[6]){ // Se o botão ainda não foi clicado
            for(int i = 0; i < 7; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
            }
            setarCursor();
            Matrizes[6] = true; // Essa agora é verdadeira
            jPanelMatrizF.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            
            //setarMatriz(matrizF);
            jLabelMatriz00.setText(""+matrizF[0][0]);
            jLabelMatriz01.setText(""+matrizF[0][1]);
            jLabelMatriz02.setText("");
            jLabelMatriz03.setText("");
            jLabelMatriz04.setText("");
            jLabelMatriz10.setText(""+matrizF[1][0]);
            jLabelMatriz11.setText(""+matrizF[1][1]);
            jLabelMatriz12.setText("");
            jLabelMatriz13.setText("");
            jLabelMatriz14.setText("");
            
            jLabelMatriz.setText("Matriz F");
            setBackground();
            jPanelMatrizF.setBackground(new Color(200,51,51));
        }
    }//GEN-LAST:event_jPanelMatrizFMouseClicked

    private void jPanelMatrizEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizEMouseExited
        // TODO add your handling code here:
        if(!Matrizes[5]){
            jPanelMatrizE.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizEMouseExited

    private void jPanelMatrizEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizEMouseEntered
        // TODO add your handling code here:
        if(!Matrizes[5]){
            jPanelMatrizE.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizEMouseEntered

    private void jPanelMatrizEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizEMouseClicked
        // TODO add your handling code here:
        if(!Matrizes[5]){ // Se o botão ainda não foi clicado
            for(int i = 0; i < 7; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
            }
            setarCursor();
            Matrizes[5] = true; // Essa agora é verdadeira
            jPanelMatrizE.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            setarMatriz(matrizE);
            jLabelMatriz.setText("Matriz E");
            setBackground();
            jPanelMatrizE.setBackground(new Color(200,51,51));
        }
    }//GEN-LAST:event_jPanelMatrizEMouseClicked

    private void jPanelMatrizDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizDMouseExited
        // TODO add your handling code here:
        if(!Matrizes[4]){
            jPanelMatrizD.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizDMouseExited

    private void jPanelMatrizDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizDMouseEntered
        // TODO add your handling code here:
        if(!Matrizes[4]){
            jPanelMatrizD.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizDMouseEntered

    private void jPanelMatrizDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizDMouseClicked
        // TODO add your handling code here:
        if(!Matrizes[4]){ // Se o botão ainda não foi clicado
            for(int i = 0; i < 7; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
            }
            setarCursor();
            Matrizes[4] = true; // Essa agora é verdadeira
            jPanelMatrizD.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            setarMatriz(matrizD);
            jLabelMatriz.setText("Matriz D");
            setBackground();
            jPanelMatrizD.setBackground(new Color(200,51,51));
        }
    }//GEN-LAST:event_jPanelMatrizDMouseClicked

    private void jPanelMatrizCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizCMouseExited
        // TODO add your handling code here:
        if(!clickmatrizC){
            jPanelMatrizC.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizCMouseExited

    private void jPanelMatrizCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizCMouseEntered
        // TODO add your handling code here:
        if(!clickmatrizC){
            jPanelMatrizC.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizCMouseEntered

    private void jPanelMatrizCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizCMouseClicked
        // TODO add your handling code here:
        if(!clickmatrizC){ // Se o botão ainda não foi clicado
            tpVisibilidade(true);
            clickmatrizC = true;
            jPanelMatrizC.setBackground(new Color(200,51,51));
            /*for(int i = 0; i < 10; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
                setarCursor();
            }*/
            Matrizes[3] = true; // Essa agora é verdadeira
            //jPanelMatrizC.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            
        }else{
            tpVisibilidade(false);
            clickmatrizC = false;
            jPanelMatrizC.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizCMouseClicked

    private void jPanelMatrizBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizBMouseExited
        // TODO add your handling code here:
        if(!Matrizes[2]){
            jPanelMatrizB.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizBMouseExited

    private void jPanelMatrizBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizBMouseEntered
        // TODO add your handling code here:
        if(!Matrizes[2]){
            jPanelMatrizB.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizBMouseEntered

    private void jPanelMatrizBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizBMouseClicked
        // TODO add your handling code here:
        if(!Matrizes[2]){ // Se o botão ainda não foi clicado
            for(int i = 0; i < 7; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
            }
            setarCursor();
            Matrizes[2] = true; // Essa agora é verdadeira
            jPanelMatrizB.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            setarMatriz(matrizB);
            jLabelMatriz.setText("Matriz B");
            setBackground();
            jPanelMatrizB.setBackground(new Color(200,51,51));
        }
    }//GEN-LAST:event_jPanelMatrizBMouseClicked

    private void jPanelMatrizAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizAMouseExited
        // TODO add your handling code here:
        if(!Matrizes[1]){
            jPanelMatrizA.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizAMouseExited

    private void jPanelMatrizAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizAMouseEntered
        // TODO add your handling code here:
        if(!Matrizes[1]){
            jPanelMatrizA.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizAMouseEntered

    private void jPanelMatrizAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizAMouseClicked
        // TODO add your handling code here:
        if(!Matrizes[1]){
            for(int i = 0; i < 7; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
            }
            setarCursor();
            Matrizes[1] = true;
            jPanelMatrizA.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            setarMatriz(matrizA);
            jLabelMatriz.setText("Matriz A");
            setBackground();
            jPanelMatrizA.setBackground(new Color(200,51,51));
        }
    }//GEN-LAST:event_jPanelMatrizAMouseClicked

    private void jPanelMatrizResultadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizResultadoMouseExited
        // TODO add your handling code here:
        if(!Matrizes[0]){
            jPanelMatrizResultado.setBackground(new Color(51,51,255));
        }
    }//GEN-LAST:event_jPanelMatrizResultadoMouseExited

    private void jPanelMatrizResultadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizResultadoMouseEntered
        // TODO add your handling code here:
        if(!Matrizes[0]){
            jPanelMatrizResultado.setBackground(new Color(51,51,200));
        }
    }//GEN-LAST:event_jPanelMatrizResultadoMouseEntered

    private void jPanelMatrizResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMatrizResultadoMouseClicked
        // TODO add your handling code here:
        if(!Matrizes[0]){
            for(int i = 0; i < 10; i++){ // Todas as outras matrizes serão desativadas.
                Matrizes[i] = false;
            }
            setarCursor();
            Matrizes[0] = true;
            jPanelMatrizResultado.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            setarMatriz(matrizResultado);
            jLabelMatriz.setText("Matriz Resultado");
            setBackground();
            jPanelMatrizResultado.setBackground(new Color(200,51,51));
        }

    }//GEN-LAST:event_jPanelMatrizResultadoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel04;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelJogador1;
    private javax.swing.JLabel jLabelJogador2;
    private javax.swing.JLabel jLabelMatriz;
    private javax.swing.JLabel jLabelMatriz00;
    private javax.swing.JLabel jLabelMatriz01;
    private javax.swing.JLabel jLabelMatriz02;
    private javax.swing.JLabel jLabelMatriz03;
    private javax.swing.JLabel jLabelMatriz04;
    private javax.swing.JLabel jLabelMatriz10;
    private javax.swing.JLabel jLabelMatriz11;
    private javax.swing.JLabel jLabelMatriz12;
    private javax.swing.JLabel jLabelMatriz13;
    private javax.swing.JLabel jLabelMatriz14;
    private javax.swing.JLabel jLabelMatrizTransposta;
    private javax.swing.JLabel jLabelMatrizTransposta00;
    private javax.swing.JLabel jLabelMatrizTransposta01;
    private javax.swing.JLabel jLabelMatrizTransposta02;
    private javax.swing.JLabel jLabelMatrizTransposta03;
    private javax.swing.JLabel jLabelMatrizTransposta04;
    private javax.swing.JLabel jLabelMatrizTransposta10;
    private javax.swing.JLabel jLabelMatrizTransposta11;
    private javax.swing.JLabel jLabelMatrizTransposta12;
    private javax.swing.JLabel jLabelMatrizTransposta13;
    private javax.swing.JLabel jLabelMatrizTransposta14;
    private javax.swing.JLabel jLabelNomeVariavel;
    private javax.swing.JLabel jLabelNumeroVariavel;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelMatrizA;
    private javax.swing.JPanel jPanelMatrizB;
    private javax.swing.JPanel jPanelMatrizC;
    private javax.swing.JPanel jPanelMatrizD;
    private javax.swing.JPanel jPanelMatrizE;
    private javax.swing.JPanel jPanelMatrizF;
    private javax.swing.JPanel jPanelMatrizResultado;
    private javax.swing.JPanel jPanelVariavelB1;
    private javax.swing.JPanel jPanelVariavelH1;
    private javax.swing.JPanel jPanelVariavelO1;
    // End of variables declaration//GEN-END:variables
}
