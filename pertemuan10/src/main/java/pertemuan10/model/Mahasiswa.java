package pertemuan10.model;

public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;
    private String jurusan;

    // Constructor untuk data baru (tanpa ID)
    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    // Constructor untuk data yang sudah ada (dengan ID)
    public Mahasiswa(int id, String nama, String nim, String jurusan) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}