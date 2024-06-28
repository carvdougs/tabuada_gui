package br.senai.sp.jandira.tabuada.view;

import br.senai.sp.jandira.tabuada.domain.CalculoTabuada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaTabuada {
    CalculoTabuada calculoTabuada = new CalculoTabuada();


    private CustomPanel painelTitulo = new CustomPanel("../images/fotopágina.jpg");
    private JPanel painelBranco = new JPanel();
    private JLabel lblTitulo = new JLabel("T A B U A D A");

    private JPanel painelOpcoes = new JPanel();

    private JPanel painelDelimitacao1 = new JPanel();
    private JPanel painelDelimitacao2 = new JPanel();
    private JPanel painelDelimitacao3 = new JPanel();
    private JPanel painelDelimitacao4 = new JPanel();

    private JLabel lblMultiplicando = new JLabel("Multiplicando:");
    private JTextField txtMultiplicando = new JTextField();

    private JLabel lblMinMultiplicador = new JLabel("Mínimo multiplicador:");
    private JTextField txtMinMultiplicador = new JTextField();

    private JLabel lblMaxMultiplicador = new JLabel("Máximo multiplicador:");
    private JTextField txtMaxMultiplicador = new JTextField();

    private JTextArea txtAreaTabuada = new JTextArea();

    private JButton botaoCalc = new JButton("Calcular");
    private JButton botaoReset = new JButton("Resetar");

    private String imagePath = "../images/";
    private Icon iconBotaoCalc = new ImageIcon(getClass().getResource(imagePath + "calc2.png"));
    private Icon iconBotaoReset = new ImageIcon(getClass().getResource(imagePath + "restart24.png"));
    ImageIcon iconTela = new ImageIcon(getClass().getResource(imagePath + "iconApp.png"));

    public TelaTabuada() {
        criarTela();
    }

    public void criarTela() {
        JFrame tela = new JFrame();

        tela.setTitle("Calculadora Tabuada");
        tela.setSize(550, 650);
        tela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tela.setLayout(null);

        painelTitulo.setBounds(0, 0, 534, 120);
        painelTitulo.setBackground(new Color(167, 252, 229));
        painelTitulo.setLayout(null);

        lblTitulo.setBounds(1, 0, 150, 50);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);

        painelBranco.setBounds(190, 30, 150, 50);
        painelBranco.setForeground(Color.WHITE);
        painelBranco.setLayout(null);
        painelBranco.add(lblTitulo);

        painelOpcoes.setBounds(0, 430, 534, 220);
        painelOpcoes.setBackground(new Color(167, 252, 229));
        painelOpcoes.setLayout(null);

        painelDelimitacao1.setBounds(0, 117, 534, 5);
        painelDelimitacao1.setBackground(Color.BLACK);
        painelDelimitacao1.setLayout(null);

        painelDelimitacao2.setBounds(0, 428, 534, 2);
        painelDelimitacao2.setBackground(Color.BLACK);
        painelDelimitacao2.setLayout(null);

        painelDelimitacao3.setBounds(0, 117, 3, 313);
        painelDelimitacao3.setBackground(Color.BLACK);
        painelDelimitacao3.setLayout(null);

        painelDelimitacao4.setBounds(531, 117, 5, 313);
        painelDelimitacao4.setBackground(Color.BLACK);
        painelDelimitacao4.setLayout(null);

        lblMultiplicando.setBounds(40, 450, 200, 30);
        txtMultiplicando.setBounds(165, 450, 100, 30);
        lblMultiplicando.setFont(new Font("Arial", Font.BOLD, 15));

        lblMinMultiplicador.setBounds(10, 500, 200, 30);
        txtMinMultiplicador.setBounds(165, 500, 100, 30);
        lblMinMultiplicador.setFont(new Font("Arial", Font.BOLD, 15));

        lblMaxMultiplicador.setBounds(10, 550, 200, 30);
        txtMaxMultiplicador.setBounds(165, 550, 100, 30);
        lblMaxMultiplicador.setFont(new Font("Arial", Font.BOLD, 15));

        txtAreaTabuada.setBounds(3, 123, 528, 305);
        txtAreaTabuada.setEditable(false);
        txtAreaTabuada.setFont(new Font("Arial", Font.PLAIN, 14));

        botaoCalc.setBounds(300, 475, 150, 30);
        botaoCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTabuada();
            }
        });
        botaoCalc.setIcon(iconBotaoCalc);

        botaoReset.setBounds(300, 525, 150, 30);
        botaoReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparTela();
            }
        });
        botaoReset.setIcon(iconBotaoReset);

        tela.setIconImage(iconTela.getImage());
        tela.getContentPane().add(painelBranco);
        tela.getContentPane().add(painelTitulo);
        tela.getContentPane().add(painelDelimitacao1);
        tela.getContentPane().add(painelDelimitacao2);
        tela.getContentPane().add(painelDelimitacao3);
        tela.getContentPane().add(painelDelimitacao4);
        tela.getContentPane().add(lblMultiplicando);
        tela.getContentPane().add(txtMultiplicando);
        tela.getContentPane().add(lblMinMultiplicador);
        tela.getContentPane().add(txtMinMultiplicador);
        tela.getContentPane().add(lblMaxMultiplicador);
        tela.getContentPane().add(txtMaxMultiplicador);
        tela.getContentPane().add(botaoCalc);
        tela.getContentPane().add(botaoReset);
        tela.getContentPane().add(painelOpcoes);
        tela.getContentPane().add(txtAreaTabuada);

        tela.setVisible(true);
    }

    private void limparTela() {
        txtMultiplicando.setText("");
        txtMaxMultiplicador.setText("");
        txtAreaTabuada.setText("");
        txtMinMultiplicador.setText("");
        txtMultiplicando.requestFocus();
    }

    private void calcularTabuada() {
        try {
            int multiplicando = Integer.parseInt(txtMultiplicando.getText());
            int minMultiplicador = Integer.parseInt(txtMinMultiplicador.getText());
            int maxMultiplicador = Integer.parseInt(txtMaxMultiplicador.getText());
            int contador = 0;

            calculoTabuada.setMultiplicando(multiplicando);
            calculoTabuada.setMinimoMultiplicador(minMultiplicador);
            calculoTabuada.setMaximoMultiplicador(maxMultiplicador);

            List<String> linhasTabuada = calculoTabuada.calcularTabuada();
            txtAreaTabuada.setText("");

            for (String linha : linhasTabuada) {
                if (contador <= 15) {
                    txtAreaTabuada.append(linha + "\n");
                    contador++;
                }else if (contador <= 36) {
                    txtAreaTabuada.append(linha + "\t");
                    txtAreaTabuada.append(linha + "\n");
                } else if (contador <= 45) {
                    txtAreaTabuada.append(linha + "\t");
                    txtAreaTabuada.append(linha + "\t");
                    txtAreaTabuada.append(linha + "\n");
                }

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Insira um valor válido!",
                    "Erro de entrada",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}