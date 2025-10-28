import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {
    JTextField pantalla;
    String operador = "";
    double num1 = 0, num2 = 0;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5));

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(this);
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]")) {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.matches("[+\\-*/]")) {
            operador = comando;
            num1 = Double.parseDouble(pantalla.getText());
            pantalla.setText("");
        } else if (comando.equals("=")) {
            num2 = Double.parseDouble(pantalla.getText());
            double resultado = 0;
            switch (operador) {
                case "+" -> resultado = num1 + num2;
                case "-" -> resultado = num1 - num2;
                case "*" -> resultado = num1 * num2;
                case "/" -> resultado = num2 != 0 ? num1 / num2 : 0;
            }
            pantalla.setText(String.valueOf(resultado));
        } else if (comando.equals("C")) {
            pantalla.setText("");
            operador = "";
            num1 = num2 = 0;
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
