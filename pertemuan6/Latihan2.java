package pertemuan6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Latihan2 extends JFrame implements ActionListener {
    private JTextField inputCelcius;
    private JLabel labelHasil;

    public Latihan2() {
        setTitle("Konverter Suhu");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Celcius:"));
        inputCelcius = new JTextField(10);
        add(inputCelcius);

        JButton tombolKonversi = new JButton("Konversi");
        tombolKonversi.addActionListener(this);
        add(tombolKonversi);

        add(new JLabel("Fahrenheit:"));
        labelHasil = new JLabel("");
        labelHasil.setPreferredSize(new Dimension(100, 20));
        add(labelHasil);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double celcius = Double.parseDouble(inputCelcius.getText());
            double fahrenheit = (celcius * 9 / 5) + 32;
            labelHasil.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            labelHasil.setText("Input tidak valid!");
        }
    }

    public static void main(String[] args) {
        new Latihan2();
    }
}
