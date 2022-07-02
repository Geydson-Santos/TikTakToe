/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jacintotabajara;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALUNO
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    boolean ganhou = false;
    public static String jogador1 = " ", jogador2 = " ";
    int jogador = 1, ponto1 = 0, ponto2 = 0, cont = 0, rodada = 1;
    int botao[][] = new int[3][3];
    
    public TelaPrincipal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/favicon.png")));
        initComponents();
        this.setLocationRelativeTo(null);
        
        jPanelResultados.setVisible(false);
        
        ImageIcon iconJogador1 = new ImageIcon(getClass().getResource("/Imagens/Jogador 1.png"));
        ImageIcon iconJogador2 = new ImageIcon(getClass().getResource("/Imagens/Jogador 2.png"));
        
        jogador1 = (String) (JOptionPane.showInputDialog(null, "Nome do Jogador 1:", "# TIK TAK TOE", JOptionPane.QUESTION_MESSAGE, iconJogador1, null, ""));
        
        
        try{ // Se a pessoa clicar em cancelar no JOptionPane, o código a seguir dá erro
            if(jogador1.equals("")){
                jogador1 = "Jogador 1";
            }
        }catch(NullPointerException npe){ // Quando ele dá o erro "NullPointerException", ele fecha o programa
            System.exit(0);
        }
        
        jogador2 = (String) (JOptionPane.showInputDialog(null, "Nome do Jogador 2:", "# TIK TAK TOE", JOptionPane.QUESTION_MESSAGE, iconJogador2, null, ""));
        
        try{ // Se a pessoa clicar em cancelar no JOptionPane, o código a seguir dá erro
            if(jogador2.equals("")){
                jogador2 = "Jogador 2";
            }
        }catch(NullPointerException npe){ // Quando ele dá o erro "NullPointerException", ele fecha o programa
            System.exit(0);
        }
        
        jogador1 = jogador1.length() <= 16 ? jogador1 : jogador1.substring(0, 16); // No máximo 16 caracteres
        jogador2 = jogador2.length() <= 16 ? jogador2 : jogador2.substring(0, 16); // No máximo 16 caracteres
        
        jLabelJogador.setText(jogador1);
        jLabelJogador.setForeground(Color.RED);
    }
    
    public void Executar(java.awt.event.MouseEvent evt){
        cont++; // Qtd de vezes que alguém clicou em um botão
        
        // Início do Teste do vencedor
        if(cont >= 5){
            for(int i = 1; i <= 2; i++){ // Testando jogador 1 e jogador 2
                for(int j = 0; j < botao.length; j++){ // Testando para todas as linhas e colunas
                    if(botao [j][0] == i && botao [j][1] == i && botao [j][2] == i){ // Para as linhas
                        ganhou = true;
                    }else{
                        if(botao [0][j] == i && botao [1][j] == i && botao [2][j] == i){ // Para as colunas
                            ganhou = true;
                        }
                    }
                }
                if(botao [0][0] == i && botao [1][1] == i && botao [2][2] == i){ // Para a Diagonal Principal
                    ganhou = true;
                }

                if(botao [0][2] == i && botao [1][1] == i && botao [2][0] == i){ // Para a Diagonal Secundária
                    ganhou = true;
                }
            }
        }
        
        
        // Fim do Teste do vencedor
        
        if(cont == 9 || ganhou){ // Rodada terminada. Encerrar o jogo e começar um novo
                if(ganhou){ // Alguém ganhou
                    if(jogador == 1){ // Jogador 1 ganhou
                        ponto1 += 5;
                        JOptionPane.showMessageDialog(null, jogador1 + " ganhou!");
                    }else{ // Jogador 2 ganhou
                        ponto2 += 5;
                        JOptionPane.showMessageDialog(null, jogador2 + " ganhou!");
                    }
                }else{
                    if(cont == 9){ // Empatou
                        ponto1 += 2;
                        ponto2 += 2;
                        JOptionPane.showMessageDialog(null,"Deu velha!");
                    }
                }
                if(rodada < 6){
                    Resultados.matrizResultado[0][rodada-1] = ponto1;
                    Resultados.matrizResultado[1][rodada-1] = ponto2;
                }
                
                rodada++; // Se passou uma rodada
                
                jLabelRodada.setText("Rodada "+ rodada); // Colocando uma nova rodada
                
                cont = 0;
                ganhou = false;
                
                //Limpando os painéis e recomeçando o jogo
                jLabel00.setText("");
                jLabel00.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[0][0] = 0;
                jLabel01.setText("");
                jLabel01.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[0][1] = 0;
                jLabel02.setText("");
                jLabel02.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[0][2] = 0;
                jLabel10.setText("");
                jLabel10.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[1][0] = 0;
                jLabel11.setText("");
                jLabel11.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[1][1] = 0;
                jLabel12.setText("");
                jLabel12.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[1][2] = 0;
                jLabel20.setText("");
                jLabel20.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[2][0] = 0;
                jLabel21.setText("");
                jLabel21.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[2][1] = 0;
                jLabel22.setText("");
                jLabel22.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                botao[2][2] = 0;
        }
        
        if(rodada == 6){
            jPanelResultados.setVisible(true);
        }
        
        // Troca de jogador e de cores entre azul e vermelho
        if(jogador == 1){
            jogador = 2; // Mudando para vez do jogador 2
            jLabelJogador.setText(jogador2); // Alterando o texto para o nome do Jogador 2
            jLabelJogador.setForeground(Color.BLUE); // Cor Azul
        }else{ // Troca de jogador e de cores entre azul e vermelho
            jogador = 1;
            jLabelJogador.setText(jogador1);
            jLabelJogador.setForeground(Color.RED); // Cor Vermelha
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

        jPanelFundo = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelRodada = new javax.swing.JLabel();
        jPanelJogoDaVelha = new javax.swing.JPanel();
        jPanel00 = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jPanel01 = new javax.swing.JPanel();
        jLabel01 = new javax.swing.JLabel();
        jPanel02 = new javax.swing.JPanel();
        jLabel02 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabelJogador = new javax.swing.JLabel();
        jLabelVez = new javax.swing.JLabel();
        jPanelResultados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIK TAK TOE");
        setLocationByPlatform(true);
        setResizable(false);

        jPanelFundo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFundo.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabelTitle.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("# TIK TAK TOE");

        jLabelRodada.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabelRodada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRodada.setText("Rodada 1");

        jPanelJogoDaVelha.setBackground(new java.awt.Color(0, 0, 0));

        jPanel00.setBackground(new java.awt.Color(255, 255, 255));
        jPanel00.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel00.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel00MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel00MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel00MouseExited(evt);
            }
        });

        jLabel00.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel00Layout = new javax.swing.GroupLayout(jPanel00);
        jPanel00.setLayout(jPanel00Layout);
        jPanel00Layout.setHorizontalGroup(
            jPanel00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel00, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel00Layout.setVerticalGroup(
            jPanel00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel00, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel01.setBackground(new java.awt.Color(255, 255, 255));
        jPanel01.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel01.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel01MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel01MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel01MouseExited(evt);
            }
        });

        jLabel01.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel01Layout = new javax.swing.GroupLayout(jPanel01);
        jPanel01.setLayout(jPanel01Layout);
        jPanel01Layout.setHorizontalGroup(
            jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel01, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel01Layout.setVerticalGroup(
            jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel01, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel02.setBackground(new java.awt.Color(255, 255, 255));
        jPanel02.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel02.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel02MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel02MouseExited(evt);
            }
        });

        jLabel02.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel02Layout = new javax.swing.GroupLayout(jPanel02);
        jPanel02.setLayout(jPanel02Layout);
        jPanel02Layout.setHorizontalGroup(
            jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel02, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel02Layout.setVerticalGroup(
            jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel02, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel20.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel21.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel22.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel22MouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jPanel12.setPreferredSize(new java.awt.Dimension(90, 60));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelJogoDaVelhaLayout = new javax.swing.GroupLayout(jPanelJogoDaVelha);
        jPanelJogoDaVelha.setLayout(jPanelJogoDaVelhaLayout);
        jPanelJogoDaVelhaLayout.setHorizontalGroup(
            jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogoDaVelhaLayout.createSequentialGroup()
                .addComponent(jPanel00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelJogoDaVelhaLayout.createSequentialGroup()
                .addGroup(jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJogoDaVelhaLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelJogoDaVelhaLayout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelJogoDaVelhaLayout.setVerticalGroup(
            jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogoDaVelhaLayout.createSequentialGroup()
                .addGroup(jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelJogoDaVelhaLayout.createSequentialGroup()
                        .addGroup(jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJogoDaVelhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabelJogador.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabelJogador.setForeground(new java.awt.Color(255, 51, 51));
        jLabelJogador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJogador.setText("Jogador 1");

        jLabelVez.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabelVez.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVez.setText("Vez de");

        jPanelResultados.setBackground(new java.awt.Color(51, 51, 255));
        jPanelResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelResultados.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanelResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelResultadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelResultadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelResultadosMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Resultados");

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVez, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addComponent(jLabelRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJogador, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                            .addGroup(jPanelFundoLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jPanelJogoDaVelha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addComponent(jLabelTitle)
                .addGap(21, 21, 21)
                .addComponent(jLabelRodada)
                .addGap(18, 18, 18)
                .addComponent(jLabelVez)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJogador)
                .addGap(27, 27, 27)
                .addComponent(jPanelJogoDaVelha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel00MouseClicked
        // TODO add your handling code here:
        if(botao[0][0] == 0){ // Se o botão não foi pressionado anteriormente nessa rodada
            if(jogador == 1){ // Se o jogador atual é o Jogador 1
                botao[0][0] = 1;
                jLabel00.setText("X");
                jLabel00.setForeground(Color.RED); // Vermelho
            }else{ // O jogador atual é o Jogador 2
                botao[0][0] = 2;
                jLabel00.setText("O");
                jLabel00.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel00.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel00.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel00MouseClicked

    private void jPanel01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel01MouseClicked
        // TODO add your handling code here:
        if(botao[0][1] == 0){
            if(jogador == 1){
                botao[0][1] = 1;
                jLabel01.setText("X");
                jLabel01.setForeground(Color.RED); // Vermelho
            }else{
                botao[0][1] = 2;
                jLabel01.setText("O");
                jLabel01.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel01.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel01.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel01MouseClicked

    private void jPanel02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel02MouseClicked
        // TODO add your handling code here:
        if(botao[0][2] == 0){
            if(jogador == 1){
                botao[0][2] = 1;
                jLabel02.setText("X");
                jLabel02.setForeground(Color.RED); // Vermelho
            }else{
                botao[0][2] = 2;
                jLabel02.setText("O");
                jLabel02.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel02.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel02.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel02MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        if(botao[1][0] == 0){
            if(jogador == 1){
                botao[1][0] = 1;
                jLabel10.setText("X");
                jLabel10.setForeground(Color.RED); // Vermelho
            }else{
                botao[1][0] = 2;
                jLabel10.setText("O");
                jLabel10.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel10.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel10.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        if(botao[1][1] == 0){
            if(jogador == 1){
                botao[1][1] = 1;
                jLabel11.setText("X");
                jLabel11.setForeground(Color.RED); // Vermelho
            }else{
                botao[1][1] = 2;
                jLabel11.setText("O");
                jLabel11.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel11.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel11.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        if(botao[1][2] == 0){
            if(jogador == 1){
                botao[1][2] = 1;
                jLabel12.setText("X");
                jLabel12.setForeground(Color.RED); // Vermelho
            }else{
                botao[1][2] = 2;
                jLabel12.setText("O");
                jLabel12.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel12.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel12.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
        if(botao[2][0] == 0){
            if(jogador == 1){
                botao[2][0] = 1;
                jLabel20.setText("X");
                jLabel20.setForeground(Color.RED); // Vermelho
            }else{
                botao[2][0] = 2;
                jLabel20.setText("O");
                jLabel20.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel20.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel20.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        // TODO add your handling code here:
        if(botao[2][1] == 0){
            if(jogador == 1){
                botao[2][1] = 1;
                jLabel21.setText("X");
                jLabel21.setForeground(Color.RED); // Vermelho
            }else{
                botao[2][1] = 2;
                jLabel21.setText("O");
                jLabel21.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel21.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel21.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        // TODO add your handling code here:
        if(botao[2][2] == 0){
            if(jogador == 1){
                botao[2][2] = 1;
                jLabel22.setText("X");
                jLabel22.setForeground(Color.RED); // Vermelho
            }else{
                botao[2][2] = 2;
                jLabel22.setText("O");
                jLabel22.setForeground(Color.BLUE); // Azul
            }
            Executar(evt);
            jLabel22.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
            jPanel22.setBackground(Color.white);
        }
    }//GEN-LAST:event_jPanel22MouseClicked

    private void jPanelResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelResultadosMouseClicked
        // TODO add your handling code here:
        dispose();
        Resultados resultado = new Resultados();
        resultado.setVisible(true);
        jPanelResultados.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
    }//GEN-LAST:event_jPanelResultadosMouseClicked

    private void jPanelResultadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelResultadosMouseEntered
        // TODO add your handling code here:
        jPanelResultados.setBackground(new Color(51,51,200));
    }//GEN-LAST:event_jPanelResultadosMouseEntered

    private void jPanelResultadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelResultadosMouseExited
        // TODO add your handling code here:
        jPanelResultados.setBackground(new Color(51,51,255));
    }//GEN-LAST:event_jPanelResultadosMouseExited

    private void jPanel00MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel00MouseEntered
        // TODO add your handling code here:
        if(botao[0][0] == 0){
            jPanel00.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel00MouseEntered

    private void jPanel00MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel00MouseExited
        // TODO add your handling code here:
        jPanel00.setBackground(Color.white);
    }//GEN-LAST:event_jPanel00MouseExited

    private void jPanel01MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel01MouseEntered
        // TODO add your handling code here:
        if(botao[0][1] == 0){
            jPanel01.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel01MouseEntered

    private void jPanel01MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel01MouseExited
        // TODO add your handling code here:
        jPanel01.setBackground(Color.white);
    }//GEN-LAST:event_jPanel01MouseExited

    private void jPanel02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel02MouseEntered
        // TODO add your handling code here:
        if(botao[0][2] == 0){
            jPanel02.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel02MouseEntered

    private void jPanel02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel02MouseExited
        // TODO add your handling code here:
        jPanel02.setBackground(Color.white);
    }//GEN-LAST:event_jPanel02MouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        // TODO add your handling code here:
        if(botao[1][0] == 0){
            jPanel10.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        // TODO add your handling code here:
        jPanel10.setBackground(Color.white);
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
        if(botao[1][1] == 0){
            jPanel11.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        // TODO add your handling code here:
        jPanel11.setBackground(Color.white);
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        if(botao[1][2] == 0){
            jPanel12.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        jPanel12.setBackground(Color.white);
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        // TODO add your handling code here:
        if(botao[2][0] == 0){
            jPanel20.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
        // TODO add your handling code here:
        jPanel20.setBackground(Color.white);
    }//GEN-LAST:event_jPanel20MouseExited

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        // TODO add your handling code here:
        if(botao[2][1] == 0){
            jPanel21.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
        // TODO add your handling code here:
        jPanel21.setBackground(Color.white);
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseEntered
        // TODO add your handling code here:
        if(botao[2][2] == 0){
            jPanel22.setBackground(Color.decode("#eeeeee"));
        }
    }//GEN-LAST:event_jPanel22MouseEntered

    private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
        // TODO add your handling code here:
        jPanel22.setBackground(Color.white);
    }//GEN-LAST:event_jPanel22MouseExited

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabelJogador;
    private javax.swing.JLabel jLabelRodada;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelVez;
    private javax.swing.JPanel jPanel00;
    private javax.swing.JPanel jPanel01;
    private javax.swing.JPanel jPanel02;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JPanel jPanelJogoDaVelha;
    private javax.swing.JPanel jPanelResultados;
    // End of variables declaration//GEN-END:variables
}
