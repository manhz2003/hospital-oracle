package dao;

import java.util.ArrayList;
import models.QuanLyTaiKhoanModel;
import java.sql.*;

public class QuanLyTaiKhoanDao implements DaoInterface<QuanLyTaiKhoanModel> {

    // Đối tượng singleton
    private static QuanLyTaiKhoanDao instance;

    // Private constructor để đảm bảo không thể tạo ra đối tượng mới từ bên ngoài
    public QuanLyTaiKhoanDao() {
    }

    // Phương thức để lấy ra instance của QuanLyTaiKhoanDao
    public static synchronized QuanLyTaiKhoanDao getInstance() {
        if (instance == null) {
            instance = new QuanLyTaiKhoanDao();
        }
        return instance;
    }

//    kiểm tra tài khoản bị trùng
    public boolean tenDangNhapDaTonTai(String tenDangNhap) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM TaiKhoan WHERE tenDangNhap=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, tenDangNhap);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    kiểm tra email trùng
    public boolean kiemTraEmailTrung(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem email đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM TaiKhoan WHERE email=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Trả về true nếu email đã tồn tại, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    đăng nhập
    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập và mật khẩu có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT * FROM TaiKhoan WHERE tenDangNhap=? AND matKhau=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, matKhau);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Trả về true nếu đăng nhập thành công, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    đổi mật khẩu
    public boolean doiMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập và mật khẩu cũ có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT * FROM TaiKhoan WHERE tenDangNhap=? AND matKhau=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, matKhauCu);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Tên đăng nhập và mật khẩu cũ đúng, cập nhật mật khẩu mới
                String updatePasswordQuery = "UPDATE TaiKhoan SET matKhau=? WHERE tenDangNhap=?";
                preparedStatement = connection.prepareStatement(updatePasswordQuery);
                preparedStatement.setString(1, matKhauMoi);
                preparedStatement.setString(2, tenDangNhap);
                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0; // Trả về true nếu cập nhật thành công, ngược lại trả về false
            } else {
                return false; // Tên đăng nhập hoặc mật khẩu cũ không khớp
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    quên mật khẩu
    public String layMatKhauMoi(String tenDangNhap, String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem tên đăng nhập và email có khớp với tài khoản đã đăng ký hay không
            String checkLoginQuery = "SELECT matKhau FROM TaiKhoan WHERE tenDangNhap=? AND email=?";
            preparedStatement = connection.prepareStatement(checkLoginQuery);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Tên đăng nhập và email đúng, trả về mật khẩu mới
                return resultSet.getString("matKhau");
            } else {
                return null; // Tên đăng nhập hoặc email không khớp
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Lỗi xảy ra
        } finally {
            // Đóng tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int insert(QuanLyTaiKhoanModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để chèn dữ liệu
            String sql = "INSERT INTO TaiKhoan (hoVaTen, tenDangNhap, matKhau, email, GioiTinh) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng DangKy
            preparedStatement.setString(1, t.getHoVaTen());
            preparedStatement.setString(2, t.getTenDangNhap());
            preparedStatement.setString(3, t.getMatKhau());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getGioiTinh());

            // Thực hiện chèn dữ liệu và lấy số dòng bị ảnh hưởng
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }

    @Override
    public int update(QuanLyTaiKhoanModel t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<QuanLyTaiKhoanModel> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public QuanLyTaiKhoanModel selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
