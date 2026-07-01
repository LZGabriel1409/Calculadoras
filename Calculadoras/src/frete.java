import java.awt.*;
import javax.swing.*;

public class frete extends JFrame {

    JTextField txtDistancia = new JTextField();
    JTextField txtPeso = new JTextField();
    JComboBox<String> cbTipo = new JComboBox<>(new String[]{"Normal", "Expresso"});
    JLabel resultado = new JLabel("Valor do frete: R$ 0,00");

    public frete() {
        setTitle("Simulador de Frete");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Distância (km):"));
        add(txtDistancia);

        add(new JLabel("Peso (kg):"));
        add(txtPeso);

        add(new JLabel("Tipo de Frete:"));
        add(cbTipo);

        JButton calcular = new JButton("Calcular");
        add(calcular);
        add(resultado);

        calcular.addActionListener(e -> calcular());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcular() {
        try {
            double d = Double.parseDouble(txtDistancia.getText());
            double p = Double.parseDouble(txtPeso.getText());
            String tipo = (String) cbTipo.getSelectedItem();

            double valor = 10 + (d * 0.5);

            if (p > 20) {
                valor += 30;
            }
            if (tipo.equals("Expresso")) {
                valor *= 1.2;
            }

            resultado.setText(String.format("Valor: R$ %.2f", valor));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nos dados!");
        }
    }
}
