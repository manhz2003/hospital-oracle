package controllers;

import dao.ThanhToanDao;
import models.ThanhToanModel;

public class ThanhToanController {

    private final ThanhToanDao thanhToanDao;

    public ThanhToanController() {
        thanhToanDao = ThanhToanDao.getInstance();
    }

    public int insertThanhToan(ThanhToanModel thanhToan) {
        return thanhToanDao.insert(thanhToan);
    }
    
}
