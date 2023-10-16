package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.BacSiModel;

public class QuanLyBacSiDao implements DaoInterface<BacSiModel> {

    private static QuanLyBacSiDao instance;

    public QuanLyBacSiDao() {

    }

    // Phương thức để lấy ra instance của QuanLyTaiKhoanDao
    public static synchronized QuanLyBacSiDao getInstance() {
        if (instance == null) {
            instance = new QuanLyBacSiDao();
        }
        return instance;
    }

//    kiểm tra mã bác sĩ bị trùng
    public boolean maBacSiTrung(String maBacSi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();

            // Kiểm tra xem mã bác sĩ đã tồn tại chưa
            String checkExistQuery = "SELECT * FROM bacsi WHERE maBacSi=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maBacSi);
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

    @Override
    public int insert(BacSiModel bacSi) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để chèn dữ liệu
            String sql = "INSERT INTO bacsi (maBacSi, hoVaTen, soDienThoai, email, diaChi, GioiTinh, chuyenKhoa, kinhNghiemLamViec, hocVan, hinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng BacSiModel
            preparedStatement.setString(1, bacSi.getMaBacSi());
            preparedStatement.setString(2, bacSi.getHoVaTen());
            preparedStatement.setString(3, bacSi.getSoDienThoai());
            preparedStatement.setString(4, bacSi.getEmai());
            preparedStatement.setString(5, bacSi.getDiaChi());
            preparedStatement.setString(6, bacSi.getGioiTinh());
            preparedStatement.setString(7, bacSi.getChuyenKhoa());
            preparedStatement.setString(8, bacSi.getKinhNgiemLamViec());
            preparedStatement.setString(9, bacSi.getHocVan());
            preparedStatement.setString(10, bacSi.getHinhAnh());

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
    public int update(BacSiModel bacSi, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để cập nhật dữ liệu
            String sql = "UPDATE bacsi SET maBacSi = ?, hoVaTen = ?, soDienThoai = ?, email = ?, diaChi = ?, GioiTinh = ?, chuyenKhoa = ?, kinhNghiemLamViec = ?, hocVan = ?, hinhAnh = ? WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Đặt các tham số cho câu truy vấn SQL từ đối tượng T
            preparedStatement.setString(1, bacSi.getMaBacSi());
            preparedStatement.setString(2, bacSi.getHoVaTen());
            preparedStatement.setString(3, bacSi.getSoDienThoai());
            preparedStatement.setString(4, bacSi.getEmai());
            preparedStatement.setString(5, bacSi.getDiaChi());
            preparedStatement.setString(6, bacSi.getGioiTinh());
            preparedStatement.setString(7, bacSi.getChuyenKhoa());
            preparedStatement.setString(8, bacSi.getKinhNgiemLamViec());
            preparedStatement.setString(9, bacSi.getHocVan());
            preparedStatement.setString(10, bacSi.getHinhAnh());

            // Đặt tham số cho WHERE clause (maBacSi)
            preparedStatement.setString(11, id);

            // Thực hiện cập nhật dữ liệu và lấy số dòng bị ảnh hưởng
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
    public int deleteById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();
            connection.setAutoCommit(false); // Tắt chế độ tự động commit

            // Bước 1: Xóa tất cả các lịch khám liên quan đến bác sĩ cần xóa
            String deleteLichKhamSql = "DELETE FROM lichKham WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(deleteLichKhamSql);
            preparedStatement.setString(1, id);
            rowsAffected = preparedStatement.executeUpdate();

            // Bước 2: Xóa bác sĩ từ bảng bacsi
            String deleteBacSiSql = "DELETE FROM bacsi WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(deleteBacSiSql);
            preparedStatement.setString(1, id);
            rowsAffected += preparedStatement.executeUpdate();

            // Commit thay đổi nếu không có lỗi
            connection.commit();
        } catch (SQLException e) {
            // Rollback nếu có lỗi
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Mở lại chế độ tự động commit và đóng kết nối và tài nguyên
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    @Override
    public void deleteAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để xóa tất cả dữ liệu
            String sql = "DELETE FROM bacsi";
            preparedStatement = connection.prepareStatement(sql);

            // Thực hiện xóa dữ liệu
            preparedStatement.executeUpdate();
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
    }

    @Override
    public ArrayList<BacSiModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<BacSiModel> list = new ArrayList<>();

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM bacsi";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BacSiModel bacSi = new BacSiModel();
                bacSi.setMaBacSi(resultSet.getString("maBacSi"));
                bacSi.setHoVaTen(resultSet.getString("hoVaTen"));
                bacSi.setSoDienThoai(resultSet.getString("soDienThoai"));
                bacSi.setEmai(resultSet.getString("email"));
                bacSi.setDiaChi(resultSet.getString("diaChi"));
                bacSi.setGioiTinh(resultSet.getString("gioiTinh"));
                bacSi.setChuyenKhoa(resultSet.getString("chuyenKhoa"));
                bacSi.setKinhNgiemLamViec(resultSet.getString("kinhNghiemLamViec"));
                bacSi.setHocVan(resultSet.getString("hocVan"));
                bacSi.setHinhAnh(resultSet.getString("hinhAnh"));

                list.add(bacSi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return list;
    }

    @Override
    public BacSiModel selectById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BacSiModel bacSi = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM bacsi WHERE maBacSi = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bacSi = new BacSiModel(
                        resultSet.getString("maBacSi"),
                        resultSet.getString("hoVaTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("email"),
                        resultSet.getString("gioiTinh"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("chuyenKhoa"),
                        resultSet.getString("kinhNghiemLamViec"),
                        resultSet.getString("hocVan"),
                        resultSet.getString("hinhAnh")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return bacSi;
    }

}
