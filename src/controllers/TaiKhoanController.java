package controllers;

import dao.QuanLyTaiKhoanDao;
import models.QuanLyTaiKhoanModel;

public class TaiKhoanController {

    private final QuanLyTaiKhoanDao dangKyDao;

    public TaiKhoanController() {
        dangKyDao = QuanLyTaiKhoanDao.getInstance();
    }

    public int dangKyTaiKhoan(QuanLyTaiKhoanModel dangKy) {
        // Gọi phương thức insert của QuanLyTaiKhoanDao để thêm dữ liệu vào cơ sở dữ liệu
        int rowsAffected = dangKyDao.insert(dangKy);

        if (rowsAffected > 0) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Đăng ký thất bại!");
        }
        return rowsAffected;
    }

    public boolean kiemTraTenDangNhapTrung(String tenDangNhap) {
        return dangKyDao.tenDangNhapDaTonTai(tenDangNhap);
    }

    public boolean kiemTraEmailTrung(String email) {
        QuanLyTaiKhoanDao dangKyDao = new QuanLyTaiKhoanDao();
        return dangKyDao.kiemTraEmailTrung(email);
    }

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        QuanLyTaiKhoanDao dangKyDao = new QuanLyTaiKhoanDao();
        return dangKyDao.kiemTraDangNhap(tenDangNhap, matKhau);
    }

    public boolean doiMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi) {
        QuanLyTaiKhoanDao doiMatKhauDao = new QuanLyTaiKhoanDao();
        return doiMatKhauDao.doiMatKhau(tenDangNhap, matKhauCu, matKhauMoi);
    }

    public String layMatKhauMoi(String tenDangNhap, String email) {
        QuanLyTaiKhoanDao layMatKhauMoiDao = new QuanLyTaiKhoanDao();
        return layMatKhauMoiDao.layMatKhauMoi(tenDangNhap, email);
    }

   
}
