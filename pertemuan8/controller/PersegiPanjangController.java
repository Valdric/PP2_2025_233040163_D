package pertemuan8.controller;

import pertemuan8.model.PersegiPanjangModel;
import pertemuan8.view.PersegiPanjangView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model ,PersegiPanjangView view){
        this.model = model;
        this.view = view;

        this.view.addHitungListener(new HitungListener());
        this.view.addKelilingListener(new KelilingListener()); // BARU
        this.view.addResetListener(new ResetListener());
    }

    class ResetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.reset();
        }
    }

    class HitungListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungLuas();

                double hasil = model.getLuas();
                view.setHasil(hasil);

            } catch (NumberFormatException ex){
                view.tampilkanPesanError("Masukan angka yang valid");
            }
        }
    }

    class KelilingListener implements ActionListener {      // BARU
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungKeliling();

                double k = model.getKeliling();
                view.setKeliling(k);

            } catch (NumberFormatException ex){
                view.tampilkanPesanError("Masukan angka yang valid");
            }
        }
    }
}
