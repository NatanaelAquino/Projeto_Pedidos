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

public class IngredientesFrameTruffled extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;

    private JButton addButton1;
    private JButton removeButton1;
    private JLabel countLabel1;

    private JButton addButton2;
    private JButton removeButton2;
    private JLabel countLabel2;

    private JButton addButton3;
    private JButton removeButton3;
    private JLabel countLabel3;

    private JButton addButton4;
    private JButton removeButton4;
    private JLabel countLabel4;

    private JButton addButton5;
    private JButton removeButton5;
    private JLabel countLabel5;

    private JButton addButton6;
    private JButton removeButton6;
    private JLabel countLabel6;

    private int ingredientCount1 = 1;
    private int ingredientCount2 = 1;
    private int ingredientCount3 = 1;
    private int ingredientCount4 = 1;
    private int ingredientCount5 = 1;
    private int ingredientCount6 = 1;

    public IngredientesFrameTruffled() {
        initComponents();
        setTitle("Ingredientes - Truffled Burger");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        label1 = new JLabel("- hambúrguer de 200g");
        label2 = new JLabel("- pão tipo brioche");
        label3 = new JLabel("- queijo cheddar");
        label4 = new JLabel("- bacon");
        label5 = new JLabel("- Bloom Petals");
        label6 = new JLabel("- Maionese trufada com azeite aromatizado com trufas");

        addButton1 = new JButton("Adicionar");
        removeButton1 = new JButton("Remover");
        countLabel1 = new JLabel("Quantidade: " + ingredientCount1);

        addButton2 = new JButton("Adicionar");
        removeButton2 = new JButton("Remover");
        countLabel2 = new JLabel("Quantidade: " + ingredientCount2);

        addButton3 = new JButton("Adicionar");
        removeButton3 = new JButton("Remover");
        countLabel3 = new JLabel("Quantidade: " + ingredientCount3);

        addButton4 = new JButton("Adicionar");
        removeButton4 = new JButton("Remover");
        countLabel4 = new JLabel("Quantidade: " + ingredientCount4);

        addButton5 = new JButton("Adicionar");
        removeButton5 = new JButton("Remover");
        countLabel5 = new JLabel("Quantidade: " + ingredientCount5);

        addButton6 = new JButton("Adicionar");
        removeButton6 = new JButton("Remover");
        countLabel6 = new JLabel("Quantidade: " + ingredientCount6);

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

        addButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount3 < 3) {
                    ingredientCount3++;
                    countLabel3.setText("Quantidade: " + ingredientCount3);
                }
            }
        });

        removeButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount3 > 0) {
                    ingredientCount3--;
                    countLabel3.setText("Quantidade: " + ingredientCount3);
                }
            }
        });

        addButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount4 < 3) {
                    ingredientCount4++;
                    countLabel4.setText("Quantidade: " + ingredientCount4);
                }
            }
        });

        removeButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount4 > 0) {
                    ingredientCount4--;
                    countLabel4.setText("Quantidade: " + ingredientCount4);
                }
            }
        });

        addButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount5 < 3) {
                    ingredientCount5++;
                    countLabel5.setText("Quantidade: " + ingredientCount5);
                }
            }
        });

        removeButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount5 > 0) {
                    ingredientCount5--;
                    countLabel5.setText("Quantidade: " + ingredientCount5);
                }
            }
        });

        addButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount6 < 3) {
                    ingredientCount6++;
                    countLabel6.setText("Quantidade: " + ingredientCount6);
                }
            }
        });

        removeButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount6 > 0) {
                    ingredientCount6--;
                    countLabel6.setText("Quantidade: " + ingredientCount6);
                }
            }
        });

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvarIngredientes("Truffled Burger");
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createIngredientPanel(label1, addButton1, removeButton1, countLabel1));
        panel.add(createIngredientPanel(label2, addButton2, removeButton2, countLabel2));
        panel.add(createIngredientPanel(label3, addButton3, removeButton3, countLabel3));
        panel.add(createIngredientPanel(label4, addButton4, removeButton4, countLabel4));
        panel.add(createIngredientPanel(label5, addButton5, removeButton5, countLabel5));
        panel.add(createIngredientPanel(label6, addButton6, removeButton6, countLabel6));

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
            ingredientList.add("hambúrguer de 200g: " + ingredientCount1);
        }
        if (ingredientCount2 > 0) {
            ingredientList.add("pão tipo brioche: " + ingredientCount2);
        }
        if (ingredientCount3 > 0) {
            ingredientList.add("queijo cheddar: " + ingredientCount3);
        }
        if (ingredientCount4 > 0) {
            ingredientList.add("bacon: " + ingredientCount4);
        }
        if (ingredientCount5 > 0) {
            ingredientList.add("Bloom Petals: " + ingredientCount5);
        }
        if (ingredientCount6 > 0) {
            ingredientList.add("Maionese trufada com azeite aromatizado com trufas: " + ingredientCount6);
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
                new IngredientesFrameTruffled().setVisible(true);
            }
        });
    }
}
