package btl.main;

import btl.CanHo;
import btl.DataManager;
import btl.PhiDichVu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private final DataManager dataManager;

    // Các thành phần trong form
    private JTextField maCanHoField, chuHoField, soNguoiField;
    private JTextField loaiDichVuField, giaField;
    private JTextArea ketQuaTimKiemTextArea;

    public MainForm(DataManager dataManager) {
        this.dataManager = dataManager;

        setTitle("Quản lý căn hộ và dịch vụ");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo TabbedPane để chứa các tab
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tạo các tab và thêm vào TabbedPane
        tabbedPane.addTab("Nhập Căn Hộ", taoTabNhapCanHo());
        tabbedPane.addTab("Nhập Dịch Vụ", taoTabNhapDichVu());
        tabbedPane.addTab("Tìm Kiếm", taoTabTimKiem());

        // Thêm TabbedPane vào JFrame
        add(tabbedPane);
    }

    // Tab 1: Nhập Căn Hộ
    private JPanel taoTabNhapCanHo() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        maCanHoField = new JTextField(15);
        chuHoField = new JTextField(15);
        soNguoiField = new JTextField(15);

        panel.add(new JLabel("Mã căn hộ:"));
        panel.add(maCanHoField);
        panel.add(new JLabel("Chủ hộ:"));
        panel.add(chuHoField);
        panel.add(new JLabel("Số người:"));
        panel.add(soNguoiField);

        JButton addButton = new JButton("Thêm Căn Hộ");
        panel.add(addButton);

        addButton.addActionListener((ActionEvent e) -> {
            String maCanHo = maCanHoField.getText();
            String chuHo = chuHoField.getText();
            int soNguoi = Integer.parseInt(soNguoiField.getText());
            
            CanHo canHo = new CanHo(maCanHo, chuHo, soNguoi);
            dataManager.themCanHo(canHo);
            JOptionPane.showMessageDialog(null, "Đã thêm căn hộ!");
            // Xóa các trường sau khi nhập
            maCanHoField.setText("");
            chuHoField.setText("");
            soNguoiField.setText("");
        });

        return panel;
    }

    // Tab 2: Nhập Dịch Vụ
    private JPanel taoTabNhapDichVu() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        loaiDichVuField = new JTextField(15);
        giaField = new JTextField(15);

        panel.add(new JLabel("Loại dịch vụ:"));
        panel.add(loaiDichVuField);
        panel.add(new JLabel("Giá:"));
        panel.add(giaField);

        JButton addButton = new JButton("Thêm Dịch Vụ");
        panel.add(addButton);

        addButton.addActionListener((ActionEvent e) -> {
            String loaiDichVu = loaiDichVuField.getText();
            double gia = Double.parseDouble(giaField.getText());
            
            PhiDichVu dichVu = new PhiDichVu(loaiDichVu, gia);
            dataManager.themDichVu(dichVu);
            JOptionPane.showMessageDialog(null, "Đã thêm dịch vụ!");
            // Xóa các trường sau khi nhập
            loaiDichVuField.setText("");
            giaField.setText("");
        });

        return panel;
    }

    // Tab 3: Tìm Kiếm Căn Hộ và Dịch Vụ
    private JPanel taoTabTimKiem() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextField timKiemField = new JTextField(20);
        ketQuaTimKiemTextArea = new JTextArea(10, 30);
        ketQuaTimKiemTextArea.setEditable(false);

        panel.add(new JLabel("Tìm kiếm (căn hộ hoặc dịch vụ):"), BorderLayout.NORTH);
        panel.add(timKiemField, BorderLayout.CENTER);

        JButton timKiemButton = new JButton("Tìm Kiếm");
        panel.add(timKiemButton, BorderLayout.EAST);
        panel.add(new JScrollPane(ketQuaTimKiemTextArea), BorderLayout.SOUTH);

        // Thêm sự kiện cho nút tìm kiếm
        timKiemButton.addActionListener((ActionEvent e) -> {
            String keyword = timKiemField.getText().toLowerCase();
            ketQuaTimKiemTextArea.setText("");
            
            // Tìm kiếm căn hộ
            List<CanHo> danhSachCanHo = dataManager.getDanhSachCanHo();
            for (CanHo canHo : danhSachCanHo) {
                if (canHo.getMaCanHo().toLowerCase().contains(keyword)) {
                    ketQuaTimKiemTextArea.append("Mã căn hộ: " + canHo.getMaCanHo() + "\n");
                    ketQuaTimKiemTextArea.append("Chủ hộ: " + canHo.getChuHo() + "\n");
                    ketQuaTimKiemTextArea.append("Số người: " + canHo.getSoNguoi() + "\n\n");
                }
            }
            
            // Tìm kiếm dịch vụ
            List<PhiDichVu> danhSachDichVu = dataManager.getDanhSachDichVu();
            for (PhiDichVu dichVu : danhSachDichVu) {
                if (dichVu.getLoaiDichVu().toLowerCase().contains(keyword)) {
                    ketQuaTimKiemTextArea.append("Loại dịch vụ: " + dichVu.getLoaiDichVu() + "\n");
                    ketQuaTimKiemTextArea.append("Giá: " + dichVu.getGia() + " VND\n\n");
                }
            }
            
            if (ketQuaTimKiemTextArea.getText().isEmpty()) {
                ketQuaTimKiemTextArea.append("Không tìm thấy kết quả nào.");
            }
        });
        return panel;
    }
}
