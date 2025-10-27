package pertemuan5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat frame utama
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                // Komponen utama
                JLabel label = new JLabel("Label ada di Atas (NORTH)", JLabel.CENTER);
                JButton buttonSouth = new JButton("Tombol ada di Bawah (SOUTH)");
                JButton buttonWest = new JButton("WEST");
                JButton buttonEast = new JButton("EAST");
                JButton buttonCenter = new JButton("CENTER");

                // Aksi untuk tombol SOUTH
                buttonSouth.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });

                // Aksi untuk tombol WEST
                buttonWest.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });

                // Aksi untuk tombol EAST
                buttonEast.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });

                // Aksi untuk tombol CENTER
                buttonCenter.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });

                // Tambahkan semua komponen ke frame
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonSouth, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);

                // Tampilkan frame
                frame.setVisible(true);
            }
        });
    }
}
