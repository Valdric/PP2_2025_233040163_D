package pertemuan7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManajemenNilaiSiswaApp extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // PANEL INPUT
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Nama
        panel.add(new JLabel("Nama Siswa: "));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Mata kuliah
        panel.add(new JLabel("Mata Kuliah: "));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
                "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Nilai
        panel.add(new JLabel("Nilai: "));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");

        // Tombol Reset
        JButton btnReset = new JButton("Reset");

        panel.add(btnSimpan);
        panel.add(btnReset);

        // Event Simpan
        btnSimpan.addActionListener(e -> prosesSimpan());

        // Event Reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        });

        return panel;
    }

    // PANEL TABEL
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Tambahkan kolom checkbox paling kiri
        String[] kolom = {"Pilih", "Nama Siswa", "Mata Kuliah", "Nilai", "Grade"};

        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Kolom pertama = checkbox
                if (columnIndex == 0) return Boolean.class;
                return String.class;
            }
        };

        tableData = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Tombol hapus
        JButton btnHapus = new JButton("Hapus Data");
        panel.add(btnHapus, BorderLayout.SOUTH);

        // Logika hapus berdasarkan checkbox
        btnHapus.addActionListener(e -> {
            boolean adaYangDihapus = false;

            // Loop dari bawah agar index tidak bergeser
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                Boolean cek = (Boolean) tableModel.getValueAt(i, 0);
                if (cek != null && cek) {
                    tableModel.removeRow(i);
                    adaYangDihapus = true;
                }
            }

            if (adaYangDihapus) {
                JOptionPane.showMessageDialog(this, "Data terpilih berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(this, "Centang data yang ingin dihapus!");
            }
        });

        return panel;
    }

    // PROSES SIMPAN
    private void prosesSimpan() {
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // Validasi nama minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama minimal harus terdiri dari 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi nilai
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this,
                        "Nilai harus antara 0 - 100!",
                        "Error Validasi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hitung grade pakai SWITCH
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }

        Object[] dataBaris = {false, nama, matkul, nilai + "", grade};
        tableModel.addRow(dataBaris);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        // Pindah ke Tab Tabel
        tabbedPane.setSelectedIndex(1);
    }

    // CONSTRUCTOR UTAMA
    public ManajemenNilaiSiswaApp() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        JPanel panelInput = createInputPanel();
        JPanel panelTable = createTablePanel();

        tabbedPane.addTab("Input Data", panelInput);
        tabbedPane.addTab("Daftar Nilai", panelTable);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManajemenNilaiSiswaApp().setVisible(true));
    }
}
