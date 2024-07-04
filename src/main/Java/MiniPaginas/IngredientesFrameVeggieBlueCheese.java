package main.Java.MiniPaginas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.Java.Util.Conexao;

public class IngredientesFrameVeggieBlueCheese extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;

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

    private JButton addButton7;
    private JButton removeButton7;
    private JLabel countLabel7;

    private JButton addButton8;
    private JButton removeButton8;
    private JLabel countLabel8;

    private JButton addButton9;
    private JButton removeButton9;
    private JLabel countLabel9;

    private int ingredientCount1 = 1;
    private int ingredientCount2 = 1;
    private int ingredientCount3 = 1;
    private int ingredientCount4 = 1;
    private int ingredientCount5 = 1;
    private int ingredientCount6 = 1;
    private int ingredientCount7 = 1;
    private int ingredientCount8 = 1;
    private int ingredientCount9 = 1;

    public IngredientesFrameVeggieBlueCheese() {
        initComponents();
        setTitle("Ingredientes - Veggie Blue Cheese Burger");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        label1 = new JLabel("- Hambúrguer vegetariano empanado à base de brócolis");
        label2 = new JLabel("- couve-flor");
        label3 = new JLabel("- queijo gorgonzola, coberto por um mix de queijos derretidos");
        label4 = new JLabel("- molho de gorgonzola");
        label5 = new JLabel("- smoked mayo");
        label6 = new JLabel("- alface");
        label7 = new JLabel("- tomate");
        label8 = new JLabel("- picles de pepino");
        label9 = new JLabel("- pão tipo brioche");

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

        addButton7 = new JButton("Adicionar");
        removeButton7 = new JButton("Remover");
        countLabel7 = new JLabel("Quantidade: " + ingredientCount7);

        addButton8 = new JButton("Adicionar");
        removeButton8 = new JButton("Remover");
        countLabel8 = new JLabel("Quantidade: " + ingredientCount8);

        addButton9 = new JButton("Adicionar");
        removeButton9 = new JButton("Remover");
        countLabel9 = new JLabel("Quantidade: " + ingredientCount9);

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

        addButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount7 < 3) {
                    ingredientCount7++;
                    countLabel7.setText("Quantidade: " + ingredientCount7);
                }
            }
        });

        removeButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount7 > 0) {
                    ingredientCount7--;
                    countLabel7.setText("Quantidade: " + ingredientCount7);
                }
            }
        });

        addButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount8 < 3) {
                    ingredientCount8++;
                    countLabel8.setText("Quantidade: " + ingredientCount8);
                }
            }
        });

        removeButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount8 > 0) {
                    ingredientCount8--;
                    countLabel8.setText("Quantidade: " + ingredientCount8);
                }
            }
        });

        addButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount9 < 3) {
                    ingredientCount9++;
                    countLabel9.setText("Quantidade: " + ingredientCount9);
                }
            }
        });

        removeButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (ingredientCount9 > 0) {
                    ingredientCount9--;
                    countLabel9.setText("Quantidade: " + ingredientCount9);
                }
            }
        });

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvarIngredientes("Veggie Blue Cheese Burger");
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
        panel.add(createIngredientPanel(label7, addButton7, removeButton7, countLabel7));
        panel.add(createIngredientPanel(label8, addButton8, removeButton8, countLabel8));
        panel.add(createIngredientPanel(label9, addButton9, removeButton9, countLabel9));

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

    private void salvarIngredientes(String burgerName) {
        StringBuilder ingredientes = new StringBuilder();

        if (ingredientCount1 > 0) {
            ingredientes.append(label1.getText()).append(", ");
        }
        if (ingredientCount2 > 0) {
            ingredientes.append(label2.getText()).append(", ");
        }
        if (ingredientCount3 > 0) {
            ingredientes.append(label3.getText()).append(", ");
        }
        if (ingredientCount4 > 0) {
            ingredientes.append(label4.getText()).append(", ");
        }
        if (ingredientCount5 > 0) {
            ingredientes.append(label5.getText()).append(", ");
        }
        if (ingredientCount6 > 0) {
            ingredientes.append(label6.getText()).append(", ");
        }
        if (ingredientCount7 > 0) {
            ingredientes.append(label7.getText()).append(", ");
        }
        if (ingredientCount8 > 0) {
            ingredientes.append(label8.getText()).append(", ");
        }
        if (ingredientCount9 > 0) {
            ingredientes.append(label9.getText()).append(", ");
        }

        // Remover a última vírgula e espaço, se existirem
        if (ingredientes.length() > 0) {
            ingredientes.setLength(ingredientes.length() - 2);
        }

        // Salvar os ingredientes no banco de dados
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.getConnection();
            String sql = "INSERT INTO finalizar (nomeUsuario, observacao) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, burgerName);
            stmt.setString(2, ingredientes.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IngredientesFrameVeggieBlueCheese().setVisible(true);
            }
        });
    }
}
