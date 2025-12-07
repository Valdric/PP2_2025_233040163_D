package pertemuan8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");        // hasil luas
    private JLabel lblKeliling = new JLabel("-");     // hasil keliling (BARU)
    private JButton btnHitung = new JButton("Hitung Luas");
    private JButton btnKeliling = new JButton("Hitung Keliling"); // BARU
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
        this.setLayout(new GridLayout(6, 2, 10, 10));
        this.setTitle("MVC Kalkulator Persegi Panjang");

        this.add(new JLabel("Panjang"));
        this.add(txtPanjang);

        this.add(new JLabel("Lebar"));
        this.add(txtLebar);

        this.add(new JLabel("Luas"));
        this.add(lblHasil);

        this.add(new JLabel("Keliling"));   // BARU
        this.add(lblKeliling);              // BARU

        this.add(btnHitung);
        this.add(btnKeliling);              // BARU

        this.add(btnReset);                 // DIPERBAIKI (tadi tidak di-add!)
    }

    public double getPanjang(){
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar(){
        return Double.parseDouble(txtLebar.getText());
    }

    public void setHasil(double hasil){
        lblHasil.setText(String.valueOf(hasil));
    }

    public void setKeliling(double k){      // BARU
        lblKeliling.setText(String.valueOf(k));
    }

    public void tampilkanPesanError (String pesan){
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungListener(ActionListener listener){
        btnHitung.addActionListener(listener);
    }

    public void addKelilingListener(ActionListener listener){  // BARU
        btnKeliling.addActionListener(listener);
    }

    public void addResetListener(ActionListener listener){
        btnReset.addActionListener(listener);
    }

    public void reset() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblKeliling.setText("-");
        txtPanjang.requestFocus();
    }
}
