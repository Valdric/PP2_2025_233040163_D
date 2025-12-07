package pertemuan8.model;

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling;   // BARU

    public void hitungLuas(){
        this.luas = this.panjang * this.lebar;
    }

    public void hitungKeliling(){           // BARU
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getLuas(){
        return this.luas;
    }

    public double getKeliling(){            // BARU
        return this.keliling;
    }
}
