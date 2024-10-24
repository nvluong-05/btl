package btl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TimKiemForm extends JFrame {
    private JTextField timKiemField;
    private JTextArea ketQuaTextArea;
    private final DataManager dataManager;

    public TimKiemForm(DataManager dataManager) {
        this.dataManager = dataManager;

        setTitle("Tìm kiếm căn hộ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timKiemField = new JTextField(15);
        ketQuaTextArea = new JTextArea(10, 30);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Tìm kiếm căn hộ:"));
        panel.add(timKiemField);

        JButton timKiemButton = new JButton("Tìm kiếm");
        panel.add(timKiemButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(ketQuaTextArea), BorderLayout.CENTER);

        timKiemButton.addActionListener((ActionEvent e) -> {
            String keyword = timKiemField.getText().toLowerCase();
            ketQuaTextArea.setText("");
            List<CanHo> danhSachCanHo = dataManager.getDanhSachCanHo();
            for (CanHo canHo : danhSachCanHo) {
                if (canHo.getMaCanHo().toLowerCase().contains(keyword)) {
                    ketQuaTextArea.append("Mã căn hộ: " + canHo.getMaCanHo() + "\n");
                    ketQuaTextArea.append("Chủ hộ: " + canHo.getChuHo() + "\n");
                    ketQuaTextArea.append("Số người: " + canHo.getSoNguoi() + "\n\n");
                }
            }
        });
    }
}
