package btl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanHoForm extends JFrame {
    private JTextField maCanHoField;
    private JTextField chuHoField;
    private JTextField soNguoiField;
    private final DataManager dataManager;

    public CanHoForm(DataManager dataManager) {
        this.dataManager = dataManager;

        setTitle("Quản lý căn hộ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        maCanHoField = new JTextField(15);
        chuHoField = new JTextField(15);
        soNguoiField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Mã căn hộ:"));
        panel.add(maCanHoField);
        panel.add(new JLabel("Chủ hộ:"));
        panel.add(chuHoField);
        panel.add(new JLabel("Số người:"));
        panel.add(soNguoiField);

        JButton addButton = new JButton("Thêm căn hộ");
        panel.add(addButton);

        add(panel);

        addButton.addActionListener((ActionEvent e) -> {
            String maCanHo = maCanHoField.getText();
            String chuHo = chuHoField.getText();
            int soNguoi = Integer.parseInt(soNguoiField.getText());
            
            CanHo canHo = new CanHo(maCanHo, chuHo, soNguoi);
            dataManager.themCanHo(canHo);
            JOptionPane.showMessageDialog(null, "Đã thêm căn hộ!");
        });
    }
}
