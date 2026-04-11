import java.awt.*;
import javax.swing.*;

public class streamer extends JFrame{

    JTextField txtDonates = new JTextField();
    JTextField txtSubs = new JTextField();
    JComboBox<String> cbPlataforma = new JComboBox<>(new String[]{"Twitch", "YouTube"});

    JLabel lblResultado = new JLabel("Valor Final: R$ 0,00");
    JLabel lblAviso = new JLabel("");

    public streamer() {
        setTitle("Calculadora do Streamer");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        painel.add(new JLabel("Donates (R$):"));
        painel.add(txtDonates);

        painel.add(new JLabel("Número de Subs:"));
        painel.add(txtSubs);

        painel.add(new JLabel("Plataforma:"));
        painel.add(cbPlataforma);

        JButton calcular = new JButton("Calcular");
        painel.add(calcular);

        painel.add(new JLabel("")); // espaço

        painel.add(lblResultado);
        painel.add(lblAviso);

        add(painel);


        calcular.addActionListener(e -> calcular());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular() {
        try {
            double donates = Double.parseDouble(txtDonates.getText());
            int subs = Integer.parseInt(txtSubs.getText());
            String plataforma = (String) cbPlataforma.getSelectedItem();

            double valorSub = 5;
            double totalSubs = subs * valorSub;
            double valorFinal = donates;

            if (plataforma.equals("Twitch")) {
                valorFinal += totalSubs * 0.5;
            } else {
                valorFinal += totalSubs * 0.7;
            }

            lblResultado.setText(String.format("Valor Final: R$ %.2f", valorFinal));

            if (valorFinal < 100) {
                lblAviso.setText("Saldo insuficiente para saque mínimo");
            } else {
                lblAviso.setText("Saque disponível!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nos dados!");
        }
    }
}
