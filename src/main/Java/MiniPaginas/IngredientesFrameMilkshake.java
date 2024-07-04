package main.Java.MiniPaginas;

import javax.swing.*;
import main.Java.Util.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientesFrameMilkshake extends JFrame {

    private JLabel label1;
    private JLabel label2;

    private JButton addButton1;
    private JButton removeButton1;
    private JLabel countLabel1;

    private JButton addButton2;
    private JButton removeButton2;
    private JLabel countLabel2;

    private int ingredientCount1 = 1;
    private int ingredientCount2 = 1;

    public IngredientesFrameMilkshake() {
        initComponents();
        setTitle("Ingredientes - Super Milkshake");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        label1 = new JLabel("- leite");
        label2 = new JLabel("- chocolate");

        addButton1 = new JButton("Adicionar");
        removeButton1 = new JButton("Remover");
        countLabel1 = new JLabel("Quantidade: " + ingredientCount1);

        addButton2 = new JButton("Adicionar");
        removeButton2 = new JButton("Remover");
        countLabel2 = new JLabel("Quantidade: " + ingredientCount2);

        addButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount1 < 3) {
                    ingredientCount1++;
                    countLabel1.setText("Quantidade: " + ingredientCount1);
                }
            }
        });

        removeButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount1 > 0) {
                    ingredientCount1--;
                    countLabel1.setText("Quantidade: " + ingredientCount1);
                }
            }
        });

        addButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount2 < 3) {
                    ingredientCount2++;
                    countLabel2.setText("Quantidade: " + ingredientCount2);
                }
            }
        });

        removeButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount2 > 0) {
                    ingredientCount2--;
                    countLabel2.setText("Quantidade: " + ingredientCount2);
                }
            }
        });

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvarIngredientes("Super Milkshake");
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createIngredientPanel(label1, addButton1, removeButton1, countLabel1));
        panel.add(createIngredientPanel(label2, addButton2, removeButton2, countLabel2));

        panel.add(saveButton);

        getContentPane().add(panel);
    }

    private JPanel createIngredientPanel(JLabel label, JButton addButton, JButton removeButton, JLabel countLabel) {
        JPanel ingredientPanel = new JPanel();
        ingredientPanel.add(label);
        ingredientPanel.add(addButton);
        ingredientPanel.add(removeButton);
        ingredientPanel.add(countLabel);
        return ingredientPanel;
    }

    private void salvarIngredientes(String nomeUsuario) {
        List<String> ingredientList = new ArrayList<>();

        if (ingredientCount1 > 0) {
            ingredientList.add("leite: " + ingredientCount1);
        }
        if (ingredientCount2 > 0) {
            ingredientList.add("chocolate: " + ingredientCount2);
        }

        StringBuilder sb = new StringBuilder();
        for (String ingredient : ingredientList) {
            sb.append(ingredient).append("\n");
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexao.getConnection();
            String sql = "INSERT INTO finalizar (nomeUsuario, observacao) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, sb.toString());

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ingredientes salvos com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IngredientesFrameMilkshake().setVisible(true);
            }
        });
    }
}
