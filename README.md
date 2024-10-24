# Quản Lý Thu Phí Dịch Vụ Căn Hộ

## Giới Thiệu

Dự án "Quản Lý Thu Phí Dịch Vụ Căn Hộ" là một ứng dụng Java sử dụng giao diện Swing nhằm hỗ trợ quản lý thông tin căn hộ và các dịch vụ liên quan. Ứng dụng cho phép người dùng dễ dàng đăng nhập, thêm mới thông tin căn hộ và dịch vụ, cũng như tìm kiếm thông tin cần thiết.

### Mục Tiêu

Ứng dụng này được phát triển với mục tiêu:
- Cung cấp một giao diện thân thiện và dễ sử dụng cho việc quản lý căn hộ.
- Giúp người dùng nhanh chóng truy cập và quản lý thông tin căn hộ và dịch vụ.
- Tăng cường tính bảo mật thông qua chức năng đăng nhập.

## Tính Năng

- **Đăng Nhập**: 
  - Người dùng cần đăng nhập với tài khoản hợp lệ để truy cập vào các chức năng của ứng dụng.
  
- **Quản Lý Căn Hộ**: 
  - Nhập và lưu trữ thông tin căn hộ bao gồm:
    - Mã căn hộ
    - Tên chủ hộ
    - Số người sống trong căn hộ

- **Quản Lý Dịch Vụ**: 
  - Nhập và lưu trữ thông tin dịch vụ bao gồm:
    - Loại dịch vụ (Quản lý, thang máy, điện, nước, gas, điều hòa, vệ sinh, bảo dưỡng, trông xe, v.v.)
    - Giá dịch vụ

- **Tìm Kiếm**: 
  - Tìm kiếm thông tin căn hộ và dịch vụ theo từ khóa, hiển thị kết quả tìm kiếm một cách rõ ràng.

## Công Nghệ Sử Dụng

- **Java**: Ngôn ngữ lập trình chính cho ứng dụng.
- **Java Swing**: Thư viện GUI được sử dụng để xây dựng giao diện người dùng.
- **Maven**: Công cụ quản lý dự án và thư viện, nếu cần thiết.

## Cài Đặt

### Bước 1: Cài Đặt JDK

- Tải và cài đặt Java Development Kit (JDK) từ trang chính thức của Oracle: [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

### Bước 2: Clone Repository

- Sử dụng Git để clone repository về máy tính của bạn:
   ```bash
   git clone <repository-url>
### Bước 3: Mở Dự Án

- Mở IDE mà bạn ưa thích (IntelliJ IDEA, Eclipse, NetBeans, v.v.) và nhập dự án đã clone.

### Bước 4: Chạy Ứng Dụng
- Chạy file LoginForm.java để khởi động ứng dụng.
  
- javac LoginForm.java
- java LoginForm

### Hướng Dẫn Sử Dụng
- Đăng Nhập:

- Khi ứng dụng khởi động, một cửa sổ đăng nhập sẽ xuất hiện. Nhập thông tin tài khoản:
- Tên người dùng: admin
- Mật khẩu: 12345
- Nhấn nút "Đăng nhập". Nếu thông tin đúng, bạn sẽ được chuyển đến giao diện chính.
- Nhập Căn Hộ:

 Chọn tab "Nhập Căn Hộ" trên giao diện chính.
Nhập các thông tin cần thiết:
Mã căn hộ
Chủ hộ
Số người
Nhấn nút "Thêm Căn Hộ" để lưu thông tin. Một thông báo sẽ hiển thị nếu việc thêm thành công.
- Nhập Dịch Vụ:

Chọn tab "Nhập Dịch Vụ".
Nhập các thông tin dịch vụ:
Loại dịch vụ
Giá
Nhấn nút "Thêm Dịch Vụ" để lưu thông tin. Thông báo sẽ hiển thị nếu thành công.
- Tìm Kiếm:

Chọn tab "Tìm Kiếm".
Nhập từ khóa vào ô tìm kiếm.
Nhấn nút "Tìm Kiếm". Kết quả tìm kiếm sẽ được hiển thị trong ô kết quả. Nếu không có kết quả nào, ứng dụng sẽ thông báo rằng không tìm thấy kết quả.

