package pertemuan8;

import pertemuan8.controller.PersegiPanjangController;
import pertemuan8.view.PersegiPanjangView;
import pertemuan8.model.PersegiPanjangModel;

public class Main {
    public static void main(String[] args) {

        PersegiPanjangModel model = new PersegiPanjangModel();
        PersegiPanjangView view = new PersegiPanjangView();
        PersegiPanjangController controller = new PersegiPanjangController(model, view);

        view.setVisible(true);
    }
}
