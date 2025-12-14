package pertemuan9 ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        setTitle("Aplikasi File IO");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        fileChooser = new JFileChooser();

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelButton = new JPanel();

        JButton btnSimpan = new JButton("Simpan");
        JButton btnBuka = new JButton("Buka");
        JButton btnAppend = new JButton("Append");
        JButton btnSimpanConfig = new JButton("Simpan Config");
        JButton btnMuatConfig = new JButton("Muat Config");

        panelButton.add(btnSimpan);
        panelButton.add(btnBuka);
        panelButton.add(btnAppend);
        panelButton.add(btnSimpanConfig);
        panelButton.add(btnMuatConfig);

        add(panelButton, BorderLayout.SOUTH);


        btnSimpan.addActionListener(e -> simpanFile(false));
        btnAppend.addActionListener(e -> simpanFile(true));
        btnBuka.addActionListener(e -> bukaFile());
        btnSimpanConfig.addActionListener(e -> simpanConfig());
        btnMuatConfig.addActionListener(e -> muatConfig());


        bacaFileOtomatis();

        setVisible(true);
    }


    private void simpanFile(boolean append) {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file");
            }
        }
    }


    private void bukaFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan atau error");
            }
        }
    }


    private void bacaFileOtomatis() {
        File file = new File("last_notes.txt");

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ignored) {
            }
        }
    }


    private void simpanConfig() {
        UserConfig config = new UserConfig("Valdric", textArea.getFont().getSize());

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("userconfig.dat"))) {
            oos.writeObject(config);
            JOptionPane.showMessageDialog(this, "Config berhasil disimpan");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan config");
        }
    }


    private void muatConfig() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("userconfig.dat"))) {

            UserConfig config = (UserConfig) ois.readObject();
            textArea.setFont(new Font("Arial", Font.PLAIN, config.getFontSize()));

            JOptionPane.showMessageDialog(this,
                    "Config dimuat\nUsername: " + config.getUsername());
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Config tidak ditemukan");
        }
    }


    public static void main(String[] args) {
        new AplikasiFileIO();
    }
}
