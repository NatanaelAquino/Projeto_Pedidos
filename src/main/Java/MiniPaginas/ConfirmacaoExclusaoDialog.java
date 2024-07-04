package main.Java.MiniPaginas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import main.Java.Paginas.Finalizar;
import main.Java.Util.Conexao;

public class ConfirmacaoExclusaoDialog extends javax.swing.JDialog {

    private int itemId;
    private Finalizar finalizar;

    public ConfirmacaoExclusaoDialog(java.awt.Frame parent, boolean modal, int itemId, Finalizar finalizar) {
        super(parent, modal);
        initComponents();
        this.itemId = itemId;
        this.finalizar = finalizar;
        jLabelConfirmacao.setText("Deseja realmente excluir o item?");
    }

    private void initComponents() {
        jLabelConfirmacao = new javax.swing.JLabel();
        jButtonSim = new javax.swing.JButton();
        jButtonNao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 200)); // Tamanho preferido maior

        jLabelConfirmacao.setText("Confirmação");

        jButtonSim.setText("Sim");
        jButtonSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimActionPerformed(evt);
            }
        });

        jButtonNao.setText("Não");
        jButtonNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelConfirmacao, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jButtonNao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null); // Centralizar a janela
    }

    private void jButtonSimActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Realizar a exclusão do item pelo ID
        int id = itemId; // ID do item a ser excluído
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM finalizar WHERE id = ?");
            pstmt.setInt(1, id);
            int resultado = pstmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
                // Notificar a classe Finalizar para recarregar os dados da tabela
                finalizar.carregarDadosTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o item.");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir o item: " + e.getMessage());
        }
        // Fechar o diálogo após a exclusão
        this.dispose();
    }                                          

    private void jButtonNaoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Fechar o diálogo sem fazer nada
        this.dispose();
    }                                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonNao;
    private javax.swing.JButton jButtonSim;
    private javax.swing.JLabel jLabelConfirmacao;
    // End of variables declaration                   
}
