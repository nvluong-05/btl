package btl.main;

import btl.DataManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Dữ liệu tài khoản mẫu
    private String correctUsername = "admin";
    private String correctPassword = "12345";

    public LoginForm() {
        setTitle("Đăng nhập");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị form ở giữa màn hình

        // Tạo giao diện đăng nhập
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Tên người dùng:"));
        usernameField = new JTextField(15);
        panel.add(usernameField);

        panel.add(new JLabel("Mật khẩu:"));
        passwordField = new JPasswordField(15);
        panel.add(passwordField);

        JButton loginButton = new JButton("Đăng nhập");
        panel.add(loginButton);

        add(panel);

        // Xử lý sự kiện khi nhấn nút "Đăng nhập"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (kiemTraDangNhap(username, password)) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    moGiaoDienChinh(); // Mở giao diện chính
                } else {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Phương thức kiểm tra thông tin đăng nhập
    private boolean kiemTraDangNhap(String username, String password) {
        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    // Mở giao diện chính sau khi đăng nhập thành công
    private void moGiaoDienChinh() {
        // Đóng form đăng nhập
        this.dispose();

        // Mở form MainForm
        DataManager dataManager = new DataManager();
        MainForm mainForm = new MainForm(dataManager);
        mainForm.setVisible(true);
    }

    public static void main(String[] args) {
        // Mở giao diện đăng nhập
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}
