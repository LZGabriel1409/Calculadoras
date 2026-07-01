import java.awt.*;
import javax.swing.*;

public class Calculadora {

    private JFrame janela;
    private JTextField visorEquacao;
    private JTextField visorAtual;

    private double primeiroNumero = 0;
    private String operador = "";
    private boolean novoNumero = true;

    public Calculadora() {

        janela = new JFrame("Calculadora");
        janela.setSize(350, 450);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setLayout(new BorderLayout());

        JPanel painelVisores = new JPanel(new GridLayout(2, 1));

        visorEquacao = new JTextField();
        visorEquacao.setEditable(false);
        visorEquacao.setHorizontalAlignment(JTextField.RIGHT);

        visorAtual = new JTextField("0");
        visorAtual.setEditable(false);
        visorAtual.setHorizontalAlignment(JTextField.RIGHT);
        visorAtual.setFont(new Font("Arial", Font.BOLD, 28));

        painelVisores.add(visorEquacao);
        painelVisores.add(visorAtual);

        janela.add(painelVisores, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] textos = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String texto : textos) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.addActionListener(e -> tratarClique(texto));
            painelBotoes.add(botao);
        }

        janela.add(painelBotoes, BorderLayout.CENTER);

        janela.setVisible(true);
    }

    private void tratarClique(String comando) {

        if (comando.equals("C")) {
            primeiroNumero = 0;
            operador = "";
            novoNumero = true;
            visorAtual.setText("0");
            visorEquacao.setText("");
            return;
        }

        if ("0123456789".contains(comando)) {

            if (novoNumero) {
                visorAtual.setText(comando);
                novoNumero = false;
            } else {
                visorAtual.setText(visorAtual.getText() + comando);
            }

            return;
        }

        if ("+-*/".contains(comando)) {

            primeiroNumero = Double.parseDouble(visorAtual.getText());
            operador = comando;

            visorEquacao.setText(visorAtual.getText() + " " + operador);
            novoNumero = true;

            return;
        }

        if (comando.equals("=")) {

            double segundoNumero = Double.parseDouble(visorAtual.getText());
            double resultado = 0;

            switch (operador) {

                case "+":
                    resultado = primeiroNumero + segundoNumero;
                    break;

                case "-":
                    resultado = primeiroNumero - segundoNumero;
                    break;

                case "*":
                    resultado = primeiroNumero * segundoNumero;
                    break;

                case "/":

                    if (segundoNumero == 0) {
                        JOptionPane.showMessageDialog(janela,
                                "Não é possível dividir por zero.");
                        return;
                    }

                    resultado = primeiroNumero / segundoNumero;
                    break;

                default:
                    return;
            }

            visorEquacao.setText(
                    primeiroNumero + " " +
                    operador + " " +
                    segundoNumero + " ="
            );

            if (resultado == (int) resultado) {
                visorAtual.setText(String.valueOf((int) resultado));
            } else {
                visorAtual.setText(String.valueOf(resultado));
            }

            primeiroNumero = resultado;
            novoNumero = true;
        }
    }
}