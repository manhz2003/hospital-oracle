package controllers;

import dao.QuanLyBacSiDao;
import java.util.ArrayList;
import models.BacSiModel;

public class BacSiController {

    private final QuanLyBacSiDao bacSiDao;

    public BacSiController() {
        bacSiDao = QuanLyBacSiDao.getInstance();
    }

    public int themBacSi(BacSiModel bacSi) {
        int rowsAffected = bacSiDao.insert(bacSi);
        if (rowsAffected > 0) {
            System.out.println("Thêm bác sĩ thành công !");
        } else {
            System.out.println("Thêm bác sĩ thất bại !");
        }
        return rowsAffected;
    }

    public boolean kiemTraMaBacSiTrung(String maBacSi) {
        return bacSiDao.maBacSiTrung(maBacSi);
    }

    public ArrayList<BacSiModel> layDanhSachBacSi() {
        return bacSiDao.selectAll();
    }

    public int xoaBacSiTheoID(String id) {
        int rowsAffected = bacSiDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public void xoaTatCaBacSi() {
        bacSiDao.deleteAll();
    }

    public BacSiModel timBacSiTheoID(String id) {
        return bacSiDao.selectById(id);
    }

    public int capNhatThongTinBacSi(BacSiModel bacSi, String id) {
        int rowsAffected = bacSiDao.update(bacSi, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

}
