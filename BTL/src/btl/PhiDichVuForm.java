package btl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PhiDichVuForm extends JFrame {
    private JTextField loaiDichVuField;
    private JTextField giaField;
    private final JTextArea danhSachDichVuTextArea;
    private final DataManager dataManager;

    public PhiDichVuForm(DataManager dataManager) {
        this.dataManager = dataManager;

        setTitle("Quản lý phí dịch vụ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loaiDichVuField = new JTextField(15);
        giaField = new JTextField(15);
        danhSachDichVuTextArea = new JTextArea(10, 30);
        danhSachDichVuTextArea.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Loại dịch vụ:"));
        panel.add(loaiDichVuField);
        panel.add(new JLabel("Giá:"));
        panel.add(giaField);

        JButton addButton = new JButton("Thêm dịch vụ");
        panel.add(addButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(danhSachDichVuTextArea), BorderLayout.CENTER);

        // Hiển thị dịch vụ hiện có
        capNhatDanhSachDichVu();

        // Thêm sự kiện cho nút "Thêm dịch vụ"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loaiDichVu = loaiDichVuField.getText();
                double gia = Double.parseDouble(giaField.getText());

                PhiDichVu dichVu = new PhiDichVu(loaiDichVu, gia);
                dataManager.themDichVu(dichVu);
                JOptionPane.showMessageDialog(null, "Đã thêm dịch vụ!");

                // Cập nhật lại danh sách sau khi thêm dịch vụ mới
                capNhatDanhSachDichVu();
            }
        });
    }

    // Phương thức để cập nhật danh sách dịch vụ
    private void capNhatDanhSachDichVu() {
        danhSachDichVuTextArea.setText(""); // Xóa nội dung cũ
        List<PhiDichVu> danhSachDichVu = dataManager.getDanhSachDichVu();
        for (PhiDichVu dichVu : danhSachDichVu) {
            danhSachDichVuTextArea.append("Loại dịch vụ: " + dichVu.getLoaiDichVu() + "\n");
            danhSachDichVuTextArea.append("Giá: " + dichVu.getGia() + " VND\n\n");
        }
    }
}
