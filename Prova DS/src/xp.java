import java.awt.*;
import javax.swing.*;

public class xp extends JFrame{

    JTextField txtNivel = new JTextField();
    JTextField txtXP = new JTextField();
    JComboBox<String> cbDificuldade = new JComboBox<>(new String[]{"Fácil", "Médio", "Difícil"});

    JLabel lblResultado = new JLabel("XP Total: 0");
    JLabel lblNivel = new JLabel("");

    public xp() {
        setTitle("Calculadora de XP");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        painel.add(new JLabel("Nível Atual:"));
        painel.add(txtNivel);

        painel.add(new JLabel("XP Atual:"));
        painel.add(txtXP);

        painel.add(new JLabel("Dificuldade:"));
        painel.add(cbDificuldade);

        JButton calcular = new JButton("Calcular");
        painel.add(calcular);

        painel.add(new JLabel("")); // espaço

        painel.add(lblResultado);
        painel.add(lblNivel);

        add(painel);

        calcular.addActionListener(e -> calcular());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular() {
        try {
            int nivel = Integer.parseInt(txtNivel.getText());
            double xpAtual = Double.parseDouble(txtXP.getText());
            String dificuldade = (String) cbDificuldade.getSelectedItem();

            double xpGanho = 100;

            if (dificuldade.equals("Médio")) {
                xpGanho *= 1.5;
            } else if (dificuldade.equals("Difícil")) {
                xpGanho *= 2;
            }

            double xpTotal = xpAtual + xpGanho;

            lblResultado.setText(String.format("XP Total: %.0f", xpTotal));

            if (xpTotal > 1000) {
                lblNivel.setText("PARABÉNS! Você subiu para o nível " + (nivel + 1));
            } else {
                lblNivel.setText("Nível atual: " + nivel);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nos dados!");
        }
    }
}
