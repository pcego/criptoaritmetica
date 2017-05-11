/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pcego.ia.genetico.gui;

import br.com.pcego.ia.genetico.core.Calculos;
import br.com.pcego.ia.genetico.core.Individuo;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paulo e Kennedi
 */
// Interface Gráfica do AG
public class TelaPrincipal extends javax.swing.JFrame {

    private int fa; // variável para função de avaliação
    private double fa_roleta; // variável para função roleta
    private ArrayList<Individuo> lista, listaSel, listaCruzamentos; // listas para manipulação dos indivíduos
    private Calculos calculos; // objeto classe onde estão os métodos principais
    private int parada;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelNome1 = new javax.swing.JLabel();
        jLabelNome2 = new javax.swing.JLabel();
        jLabelPalavra3 = new javax.swing.JLabel();
        jTPalavra1 = new javax.swing.JTextField();
        jTPalavra2 = new javax.swing.JTextField();
        jTPalavra3 = new javax.swing.JTextField();
        jLPopulacao = new javax.swing.JLabel();
        jLGeracoes = new javax.swing.JLabel();
        jLTxCrossover = new javax.swing.JLabel();
        jTPopulação = new javax.swing.JTextField();
        jBExecuatr = new javax.swing.JButton();
        jLSoma = new javax.swing.JLabel();
        jLIgualdade = new javax.swing.JLabel();
        jTGeracao = new javax.swing.JTextField();
        jTTxCrossover = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTTabela = new javax.swing.JTable();
        jLSimboloPercente = new javax.swing.JLabel();
        jRRoleta = new javax.swing.JRadioButton();
        jRTruncad = new javax.swing.JRadioButton();
        jRTorneio = new javax.swing.JRadioButton();
        jCDuplo = new javax.swing.JCheckBox();
        jCTriplo = new javax.swing.JCheckBox();
        LIndividuos = new java.awt.Label();
        jLTipoSelecao = new javax.swing.JLabel();
        jCTipoTorneio = new javax.swing.JComboBox();
        jLTipoTorneio = new javax.swing.JLabel();
        jLMutacao = new javax.swing.JLabel();
        jTMutacao = new javax.swing.JTextField();
        jLPorcentagem = new javax.swing.JLabel();
        jLMetodoCruzemento = new javax.swing.JLabel();
        jRPmx = new javax.swing.JRadioButton();
        jRCiclico = new javax.swing.JRadioButton();
        jLReinsercao = new javax.swing.JLabel();
        jRElite = new javax.swing.JRadioButton();
        jRPura = new javax.swing.JRadioButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algoritimo Genético", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), java.awt.Color.blue)); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel1FocusLost(evt);
            }
        });

        jLabelNome1.setText("Palavra 1");

        jLabelNome2.setText("Palavra 2");

        jLabelPalavra3.setText("Palavra 3");

        jTPalavra1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTPalavra1FocusGained(evt);
            }
        });

        jLPopulacao.setText("População");

        jLGeracoes.setText("Num Gerações");

        jLTxCrossover.setText("Tx Crossover");

        jBExecuatr.setText("Executar");
        jBExecuatr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExecuatrActionPerformed(evt);
            }
        });

        jLSoma.setText("+");

        jLIgualdade.setText("=");

        jTGeracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTGeracaoActionPerformed(evt);
            }
        });

        jTTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTTabela);

        jLSimboloPercente.setText("%");

        buttonGroup1.add(jRRoleta);
        jRRoleta.setText("Roleta");
        jRRoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRRoletaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRTruncad);
        jRTruncad.setText("Truncamento");
        jRTruncad.setToolTipText("");

        buttonGroup1.add(jRTorneio);
        jRTorneio.setText("Toneio");
        jRTorneio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRTorneioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRTorneioFocusLost(evt);
            }
        });

        buttonGroup2.add(jCDuplo);
        jCDuplo.setText("2");
        jCDuplo.setToolTipText("");

        buttonGroup2.add(jCTriplo);
        jCTriplo.setText("3");
        jCTriplo.setToolTipText("");

        LIndividuos.setText("Melhores Individuos Por Geração");

        jLTipoSelecao.setText("Método Seleção");

        jCTipoTorneio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simples", "Estocástico" }));

        jLTipoTorneio.setText("Tipo De Torneio");

        jLMutacao.setText("Tx Mutação");

        jLPorcentagem.setText("%");

        jLMetodoCruzemento.setText("Método de Cruzamento");

        buttonGroup3.add(jRPmx);
        jRPmx.setText("PMX");

        buttonGroup3.add(jRCiclico);
        jRCiclico.setText("Cíclico");

        jLReinsercao.setText("Método Reinserção");

        buttonGroup4.add(jRElite);
        jRElite.setText("Roleta (Elite)");

        buttonGroup4.add(jRPura);
        jRPura.setText("Pura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRRoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRTruncad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelNome1)
                                            .addComponent(jLPopulacao)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTPalavra1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLSoma))
                                            .addComponent(jTPopulação, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTGeracao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                    .addComponent(jTPalavra2, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLIgualdade))
                                            .addComponent(jLGeracoes)
                                            .addComponent(jLabelNome2)))
                                    .addComponent(jLTipoSelecao))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRTorneio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLTipoTorneio)
                                    .addComponent(jCTipoTorneio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCTriplo)
                                    .addComponent(jCDuplo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTTxCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLSimboloPercente))
                            .addComponent(jTPalavra3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTxCrossover)
                            .addComponent(jLabelPalavra3)))
                    .addComponent(jLMutacao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPorcentagem))
                    .addComponent(jLMetodoCruzemento)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRPmx)
                        .addGap(43, 43, 43)
                        .addComponent(jRCiclico))
                    .addComponent(jLReinsercao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRElite)
                        .addGap(18, 18, 18)
                        .addComponent(jRPura))
                    .addComponent(jBExecuatr, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LIndividuos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabelNome1))
                        .addComponent(jLabelNome2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabelPalavra3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LIndividuos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTPalavra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTPalavra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLSoma)
                                .addComponent(jLIgualdade))
                            .addComponent(jTPalavra1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPopulacao)
                            .addComponent(jLGeracoes)
                            .addComponent(jLTxCrossover))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTPopulação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTGeracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTTxCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLSimboloPercente))
                        .addGap(18, 18, 18)
                        .addComponent(jLMutacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLPorcentagem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLTipoSelecao)
                                    .addComponent(jLTipoTorneio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCTipoTorneio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRTorneio)
                                    .addComponent(jRTruncad)
                                    .addComponent(jRRoleta)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jCDuplo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCTriplo)))
                        .addGap(7, 41, Short.MAX_VALUE)
                        .addComponent(jLMetodoCruzemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRPmx)
                            .addComponent(jRCiclico)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addComponent(jLReinsercao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRElite)
                    .addComponent(jRPura))
                .addGap(44, 44, 44)
                .addComponent(jBExecuatr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExecuatrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExecuatrActionPerformed

        int populacao = Integer.valueOf(jTPopulação.getText());
        int geracoes = Integer.valueOf(jTGeracao.getText());
        int cross = Integer.valueOf(jTTxCrossover.getText());
        int flag = 0;


        DefaultTableModel dtm = new DefaultTableModel();
        String[] titulos = {"Geração", "Melhor Individuo", "FA", "Média F.A"};
        dtm.setColumnIdentifiers(titulos);

        lista = new ArrayList<>();
        listaSel = new ArrayList<>();
        listaCruzamentos = new ArrayList<>();


        // loop para controle de gerações        
        for (int w = 0; w < Integer.parseInt(jTGeracao.getText()); w++) {

            // inicializando objeto calculos
            calculos = new Calculos();

            // zerando listas
            lista.clear();
            listaSel.clear();
            listaCruzamentos.clear();
            calculos.setSoma(0);


            parada = 0; // variável para controlar parada quando encontrar FA = 0

            // loop para gerar população inicial
            for (int i = 0; i < populacao; i++) {
                // adicionando população a lista principal
                lista.add(calculos.geraPopulacao(jTPalavra1.getText(), jTPalavra2.getText(), jTPalavra3.getText()));

            }

            // if para verificar método de seleção por roleta
            if (jRRoleta.isSelected()) {
                // carregando lista de individuos selecionados por roleta
                listaSel = calculos.geraSelecao(calculos.getSoma(), cross, lista);

                // if para verificar método seleção por truncamento  
            } else if (jRTruncad.isSelected()) {
                // carregando lista com individuos selecionados por truncamento
                listaSel = calculos.geraSelecaoTruncad(cross, lista);

                // seleção por torneio
            } else if (jRTorneio.isSelected()) {
                int torneio = 0; // controle torneio (2 ou 3)
                int tipo = 0; // controle do tipo de torneio (simples ou estocático)

                tipo = jCTipoTorneio.getSelectedIndex();

                if (jCDuplo.isSelected()) {
                    torneio = 2;
                }
                if (jCTriplo.isSelected()) {
                    torneio = 3;
                }

                if (tipo == 0) {
                    listaSel = calculos.geraSelecaoTorneioSimples(cross, lista, torneio);

                }
                if (tipo == 1) {
                    listaSel = calculos.geraSelecaoTorneioEst(calculos.getSoma(), cross, lista, torneio);
                }

            }

            // if para controlar cruzamento PMX
            if (jRPmx.isSelected()) {
                // limpando lista de cruzamentos
                listaCruzamentos.clear();
                listaCruzamentos = calculos.geraCruzamentoPmx(listaSel); // carregando lista individuos cruzados por PMX
            }

            // if para controlar cruzamento Cíclico
            if (jRCiclico.isSelected()) {
                listaCruzamentos.clear();
                listaCruzamentos = calculos.geraCruzamentoCiclico(listaSel);
            }

            // Iteração sob a lista de individuos cruzados por PMX ou Cíclico
            Iterator<Individuo> x = listaCruzamentos.listIterator();
            while (x.hasNext()) {
                int fa;
                Individuo indCruzamento = x.next();
                // recalculando FA dos indivíduos após cruzamento
                fa = calculos.calculaFa(jTPalavra1.getText(), jTPalavra2.getText(), jTPalavra3.getText(), indCruzamento.getIndividuo());

                indCruzamento.setFa(fa);
                indCruzamento.setFa_roleta(calculos.calculaFaRoleta(indCruzamento.getFa()));

                // adicionando individuos após seleção e cruzamento na lista principal
                lista.add(indCruzamento);
            }

            // controle tipo método de reinserção por Roleta com elite
            if (jRElite.isSelected()) {
                // carregando população final a lista principal (a cada geração)
                lista = calculos.reinsercaoRoletaElite(lista);
            }
            // controle método de reinserção pura (por melhor FA)
            if (jRPura.isSelected()) {
                // idem anterior
                lista = calculos.reinsercaoPura(lista, Integer.valueOf(jTPopulação.getText()));
            }
            

            Iterator<Individuo> i = lista.listIterator();
            Individuo ind = calculos.calculaMenorFa(lista);

            // verificando indivíduo solução a cada geração (FA = 0)
            if (ind.getFa() == 0) {
                parada = 1;
            }

            dtm.addRow(new Object[]{w + 1, ind.converteVetor(), ind.getFa(), calculos.mediaFaPop(lista), 1});

            jTTabela.setModel(dtm);

            // condição de para do AG
            if (parada == 1) {
                break;
            }
        }

    }//GEN-LAST:event_jBExecuatrActionPerformed

    private void jTGeracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTGeracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTGeracaoActionPerformed

    private void jRRoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRRoletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRRoletaActionPerformed

    private void jRTorneioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRTorneioFocusLost
    }//GEN-LAST:event_jRTorneioFocusLost

    private void jRTorneioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRTorneioFocusGained
    }//GEN-LAST:event_jRTorneioFocusGained

    private void jPanel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusLost
    }//GEN-LAST:event_jPanel1FocusLost

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    }//GEN-LAST:event_formFocusGained

    private void jTPalavra1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPalavra1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPalavra1FocusGained

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
    private java.awt.Label LIndividuos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jBExecuatr;
    private javax.swing.JCheckBox jCDuplo;
    private javax.swing.JComboBox jCTipoTorneio;
    private javax.swing.JCheckBox jCTriplo;
    private javax.swing.JLabel jLGeracoes;
    private javax.swing.JLabel jLIgualdade;
    private javax.swing.JLabel jLMetodoCruzemento;
    private javax.swing.JLabel jLMutacao;
    private javax.swing.JLabel jLPopulacao;
    private javax.swing.JLabel jLPorcentagem;
    private javax.swing.JLabel jLReinsercao;
    private javax.swing.JLabel jLSimboloPercente;
    private javax.swing.JLabel jLSoma;
    private javax.swing.JLabel jLTipoSelecao;
    private javax.swing.JLabel jLTipoTorneio;
    private javax.swing.JLabel jLTxCrossover;
    private javax.swing.JLabel jLabelNome1;
    private javax.swing.JLabel jLabelNome2;
    private javax.swing.JLabel jLabelPalavra3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRCiclico;
    private javax.swing.JRadioButton jRElite;
    private javax.swing.JRadioButton jRPmx;
    private javax.swing.JRadioButton jRPura;
    private javax.swing.JRadioButton jRRoleta;
    private javax.swing.JRadioButton jRTorneio;
    private javax.swing.JRadioButton jRTruncad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTGeracao;
    private javax.swing.JTextField jTMutacao;
    private javax.swing.JTextField jTPalavra1;
    private javax.swing.JTextField jTPalavra2;
    private javax.swing.JTextField jTPalavra3;
    private javax.swing.JTextField jTPopulação;
    private javax.swing.JTable jTTabela;
    private javax.swing.JTextField jTTxCrossover;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}