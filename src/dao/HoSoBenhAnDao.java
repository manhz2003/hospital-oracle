package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.BenhNhanModel;
import models.HoSoBenhAnModel;

public class HoSoBenhAnDao implements DaoInterface<HoSoBenhAnModel> {

    private static HoSoBenhAnDao instance;

    public HoSoBenhAnDao() {

    }

    public static synchronized HoSoBenhAnDao getInstance() {
        if (instance == null) {
            instance = new HoSoBenhAnDao();
        }
        return instance;
    }

    //    kiểm tra mã bệnh nhân bị trùng
    public boolean maHoSoTrung(String maHoSo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectDB.getConnection();
            String checkExistQuery = "SELECT * FROM hosobenhan WHERE maHoSo=?";
            preparedStatement = connection.prepareStatement(checkExistQuery);
            preparedStatement.setString(1, maHoSo);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    }

    @Override
    public int insert(HoSoBenhAnModel t) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            String sql = "INSERT INTO hoSoBenhAn (maHoSo, tienSuBenhAn, trieuChung, chuanDoan, ketLuan, maBenhNhan, maBacSi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMaHoSo());
            preparedStatement.setString(2, t.getTienSuBenhAn());
            preparedStatement.setString(3, t.getTrieuChung());
            preparedStatement.setString(4, t.getChuanDoan());
            preparedStatement.setString(5, t.getKetLuan());
            preparedStatement.setString(6, t.getMaBenhNhan());
            preparedStatement.setString(7, t.getMaBacSi());
            rowsAffected = preparedStatement.executeUpdate();
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
        }
        return rowsAffected;
    }

    @Override
    public int update(HoSoBenhAnModel t, String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE hosobenhan SET maHoSo = ?, tienSuBenhAn = ?, trieuChung = ?, chuanDoan = ?, ketLuan = ?, maBenhNhan = ?, maBacSi = ? WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMaHoSo());
            preparedStatement.setString(2, t.getTienSuBenhAn());
            preparedStatement.setString(3, t.getTrieuChung());
            preparedStatement.setString(4, t.getChuanDoan());
            preparedStatement.setString(5, t.getKetLuan());
            preparedStatement.setString(6, t.getMaBenhNhan());
            preparedStatement.setString(7, t.getMaBacSi());
            preparedStatement.setString(8, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Xem xét xử lý lỗi chi tiết hơn ở đây
        } finally {
            // Đóng kết nối và tài nguyên
            ConnectDB.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xem xét xử lý lỗi chi tiết hơn ở đây
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
            connection = ConnectDB.getConnection();
            String sql = "DELETE FROM hosobenhan WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoSoBenhAnModel> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<HoSoBenhAnModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhan";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                HoSoBenhAnModel HoSoBenhAnModel = new HoSoBenhAnModel();
                HoSoBenhAnModel.setMaHoSo(resultSet.getString("maHoSo"));
                HoSoBenhAnModel.setMaBacSi(resultSet.getString("maBacSi"));
                HoSoBenhAnModel.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                HoSoBenhAnModel.setTrieuChung(resultSet.getString("trieuChung"));
                HoSoBenhAnModel.setTienSuBenhAn(resultSet.getString("tienSuBenhAn"));
                HoSoBenhAnModel.setChuanDoan(resultSet.getString("chuanDoan"));
                HoSoBenhAnModel.setKetLuan(resultSet.getString("ketLuan"));
                list.add(HoSoBenhAnModel);
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

    public ArrayList<HoSoBenhAnModel> selectHoSoBenhAn(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<HoSoBenhAnModel> list = new ArrayList<>();
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhan where maBenhNhan = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                HoSoBenhAnModel HoSoBenhAnModel = new HoSoBenhAnModel();
                HoSoBenhAnModel.setMaHoSo(resultSet.getString("maHoSo"));
                HoSoBenhAnModel.setMaBacSi(resultSet.getString("maBacSi"));
                HoSoBenhAnModel.setMaBenhNhan(resultSet.getString("maBenhNhan"));
                HoSoBenhAnModel.setTrieuChung(resultSet.getString("trieuChung"));
                HoSoBenhAnModel.setTienSuBenhAn(resultSet.getString("tienSuBenhAn"));
                HoSoBenhAnModel.setChuanDoan(resultSet.getString("chuanDoan"));
                HoSoBenhAnModel.setKetLuan(resultSet.getString("ketLuan"));
                list.add(HoSoBenhAnModel);
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
    public HoSoBenhAnModel selectById(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HoSoBenhAnModel hoSo = null;

        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM hosobenhan WHERE maHoSo = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                hoSo = new HoSoBenhAnModel(
                        resultSet.getString("maHoSo"),
                        resultSet.getString("maBacSi"),
                        resultSet.getString("maBenhNhan"),
                        resultSet.getString("trieuChung"),
                        resultSet.getString("tienSuBenhAn"),
                        resultSet.getString("chuanDoan"),
                        resultSet.getString("ketLuan")
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

        return hoSo;
    }

}
