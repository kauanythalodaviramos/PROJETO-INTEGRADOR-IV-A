package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame {

    private final JTextField campoNumero1;
    private final JTextField campoNumero2;
    private final Calculadora calculadora;

    public CalculadoraGUI() {
        // 1. Configurações básicas da janela
        setTitle("Calculadora Gráfica");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10)); // Layout para organizar os componentes

        calculadora = new Calculadora();

        // 2. Criação dos componentes da interface
        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();

        JButton botaoSomar = new JButton("Somar");
        JButton botaoSubtrair = new JButton("Subtrair");
        JButton botaoMultiplicar = new JButton("Multiplicar");
        JButton botaoDividir = new JButton("Dividir");

        // Painel para os campos de texto
        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        painelCampos.add(new JLabel("Número 1:"));
        painelCampos.add(campoNumero1);
        painelCampos.add(new JLabel("Número 2:"));
        painelCampos.add(campoNumero2);

        // Painel para os botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // 3. Centraliza os botões de texto horizontalmente // KAUAN AWOOO
        painelBotoes.add(botaoSomar);
        painelBotoes.add(botaoSubtrair);
        painelBotoes.add(botaoMultiplicar);
        painelBotoes.add(botaoDividir);

        // Adiciona os painéis à janela principal
        add(painelCampos);
        add(painelBotoes);

        // Configuração das ações dos botões
        botaoSomar.addActionListener(e -> executarOperacao("somar"));
        botaoSubtrair.addActionListener(e -> executarOperacao("subtrair"));
        botaoMultiplicar.addActionListener(e -> executarOperacao("multiplicar"));
        botaoDividir.addActionListener(e -> executarOperacao("dividir"));
    }

    private void executarOperacao(String operacao) {
        try {
            double num1 = Double.parseDouble(campoNumero1.getText());
            double num2 = Double.parseDouble(campoNumero2.getText());
            double resultado = 0;

            switch (operacao) {
                case "somar":
                    resultado = calculadora.somar(num1, num2);
                    break;
                case "subtrair":
                    resultado = calculadora.subtrair(num1, num2);
                    break;
                case "multiplicar":
                    resultado = calculadora.multiplicar(num1, num2);
                    break;
                case "dividir":
                    resultado = calculadora.dividir(num1, num2);
                    break;
            }
            JOptionPane.showMessageDialog(this, "Resultado: " + resultado, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Por favor, insira números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Captura a exceção de divisão por zero da classe Calculadora
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro de Operação", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Garante que a GUI seja criada na thread de despacho de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI gui = new CalculadoraGUI();
            gui.setLocationRelativeTo(null); // Centraliza a janela na tela
            gui.setVisible(true);
        });
    }
}
