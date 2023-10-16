package controllers;

import dao.QuanLyBenhNhanDao;
import java.util.ArrayList;
import models.BenhNhanModel;

public class BenhNhanController {

    private final QuanLyBenhNhanDao benhNhanDao;

    public BenhNhanController() {
        benhNhanDao = QuanLyBenhNhanDao.getInstance();
    }

    public boolean kiemTraMaBenhNhanTrung(String maBenhNhan) {
        return benhNhanDao.maBenhNhanTrung(maBenhNhan);
    }

    public int themBenhNhan(BenhNhanModel benhNhan) {
        int rowsAffected = benhNhanDao.insert(benhNhan);
        if (rowsAffected > 0) {
            System.out.println("Thêm bệnh nhân thành công !");
        } else {
            System.out.println("Thêm bệnh nhân thất bại !");
        }
        return rowsAffected;
    }

    public int capNhatThongTinBenhNhan(BenhNhanModel benhNhan, String id) {
        int rowsAffected = benhNhanDao.update(benhNhan, id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }

    public ArrayList<BenhNhanModel> layDanhSachBenhNhan() {
        return benhNhanDao.selectAll();
    }

    public ArrayList<BenhNhanModel> layDanhSachBenhNhanDuocBacSiKham(String id) {
        return benhNhanDao.selectBenhNhanDuocBacSiKham(id);
    }

    public BenhNhanModel timBenhNhanTheoID(String id) {
        return benhNhanDao.selectById(id);
    }

    public int xoaBenhNhanTheoID(String id) {
        int rowsAffected = benhNhanDao.deleteById(id);
        if (rowsAffected > 0) {
            return rowsAffected;
        } else {
            return -1;
        }
    }
}
