package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ThanhToanModel;

public class ThanhToanDao implements DaoInterface<ThanhToanModel> {

    private static ThanhToanDao instance;

    public ThanhToanDao() {

    }

    // Phương thức để lấy ra instance của QuanLyTaiKhoanDao
    public static synchronized ThanhToanDao getInstance() {
        if (instance == null) {
            instance = new ThanhToanDao();
        }
        return instance;
    }

    @Override
    public int insert(ThanhToanModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            // Lấy kết nối tới cơ sở dữ liệu
            connection = ConnectDB.getConnection();

            // Chuẩn bị câu truy vấn SQL để chèn dữ liệu
            String sql = "INSERT INTO thanhtoan (maThanhToan, soTaiKhoan, tenTaiKhoan, tenNganHang, thoiGianThanhToan, tenDangNhap) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMaThanhToan());
            preparedStatement.setString(2, t.getSoTaiKhoan());
            preparedStatement.setString(3,  t.getTenTaiKhoan());
            preparedStatement.setString(4,  t.getTenNganhang());
            preparedStatement.setString(5, t.getThoiGianThanhToan());
            preparedStatement.setString(6, t.getTenDangNhap());
            
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
    public int update(ThanhToanModel t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThanhToanModel> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ThanhToanModel selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
