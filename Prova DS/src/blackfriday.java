import java.awt.*;
import javax.swing.*;

public class blackfriday extends JFrame {
    
    JTextField txtValor = new JTextField();
    JTextField txtDesconto = new JTextField();

    JLabel lblOriginal = new JLabel("Valor Original: R$ 0,00");
    JLabel lblDesconto = new JLabel("Valor do Desconto: R$ 0,00");
    JLabel lblFinal = new JLabel("Valor Final: R$ 0,00");

    public blackfriday() {
        setTitle("Black Friday");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        painel.add(new JLabel("Valor da Compra:"));
        painel.add(txtValor);

        painel.add(new JLabel("Desconto:"));
        painel.add(txtDesconto);

        JButton calcular = new JButton("Calcular");
        painel.add(calcular);

        painel.add(new JLabel("")); // espaço

        painel.add(lblOriginal);
        painel.add(lblDesconto);
        painel.add(lblFinal);

        add(painel);

        calcular.addActionListener(e -> calcular());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            double desconto = 0;

            if (valor > 500) {
                desconto += valor * 0.1;
            }
            if (txtDesconto.getText().equalsIgnoreCase("AMIGAO10")) {
                desconto += 10;
            }

            double valorFinal = valor - desconto;

            lblOriginal.setText(String.format("Valor Original: R$ %.2f", valor));
            lblDesconto.setText(String.format("Desconto: R$ %.2f", desconto));
            lblFinal.setText(String.format("Valor Final: R$ %.2f", valorFinal));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nos dados!");
        }
    }
}
