package controllers;

import dao.HoSoBenhAnDao;
import java.util.ArrayList;
import models.HoSoBenhAnModel;

public class HoSoBenhAnController {

    private final HoSoBenhAnDao hoSoDao;

    public HoSoBenhAnController() {
        hoSoDao = HoSoBenhAnDao.getInstance();
    }

    public boolean kiemTraMaHoSoTrung(String maHoSo) {
        return hoSoDao.maHoSoTrung(maHoSo);
    }

    public int themHoSo(HoSoBenhAnModel hoSo) {
        int rowsAffected = hoSoDao.insert(hoSo);
        if (rowsAffected > 0) {
            System.out.println("Thêm hồ sơ thành công !");
        } else {
            System.out.println("Thêm hồ sơ thất bại !");
        }
        return rowsAffected;
    }

    public int capNhatThongTinHoSo(HoSoBenhAnModel hoSo, String id) {
        int rowsAffected = hoSoDao.update(hoSo, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public ArrayList<HoSoBenhAnModel> layDanhSachHoSo() {
        return hoSoDao.selectAll();
    }
    
      public ArrayList<HoSoBenhAnModel> layDanhSachHoSoTheoBenhNhan(String id) {
        return hoSoDao.selectHoSoBenhAn(id);
    }

    public HoSoBenhAnModel timHoSoTheoID(String id) {
        return hoSoDao.selectById(id);
    }

    public int xoaHoSoTheoId(String id) {
        int rowsAffected = hoSoDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
}
