package btl;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<CanHo> danhSachCanHo;
    private List<PhiDichVu> danhSachDichVu;

    public DataManager() {
        danhSachCanHo = new ArrayList<>();
        danhSachDichVu = new ArrayList<>();
    }

    public List<CanHo> getDanhSachCanHo() {
        return danhSachCanHo;
    }

    public void themCanHo(CanHo canHo) {
        danhSachCanHo.add(canHo);
    }

    public List<PhiDichVu> getDanhSachDichVu() {
        return danhSachDichVu;
    }

    public void themDichVu(PhiDichVu dichVu) {
        danhSachDichVu.add(dichVu);
    }
}
