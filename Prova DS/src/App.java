import javax.swing.*;

public class App {
    static abstract class Frete {
        double distancia;
        double peso;

        Frete(double d, double p) {
            distancia = d;
            peso = p;
        }

        double base() {
            double valor = 10 + (distancia * 0.5);
            if (peso > 20){ valor += 30;}
            return valor;
        }
        
        abstract double calcular();
    }

    static class Normal extends Frete {
        Normal(double d, double p) {super(d,p);}
        double calcular() {return base();}
    }

    static class Expresso extends Frete {
        Expresso(double d, double p) {super(d, p);}
        double calcular() {return base() * 1.2;}
    }

    public static void main(String[] args) {
        try {
            double distancia = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância(km):"));
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso(kg): "));
            
            String[] opcoes = {"Normal", "Expresso"};
            String tipo = (String) JOptionPane.showInputDialog(null, "Escolha o tipo de envio", "Tipo", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            
            Frete frete = tipo.equals("Expresso")
            ? new Expresso(distancia, peso)
            : new Normal(distancia, peso);
            
            double valor = frete.calcular();
            
            if (peso > 20) {
                JOptionPane.showMessageDialog(null, "Devido ao peso ser maior que 20kg, adicionamos uma taxa de R$30,00 ao valor final.");
            }
            JOptionPane.showMessageDialog(null, "Valor do Frete: R$ " + String.format("%.2f", valor));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: valores inválidos!");
        }
    }
}


