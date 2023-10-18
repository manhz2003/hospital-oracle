/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.BacSiController;
import controllers.BenhNhanController;
import controllers.HoSoBenhAnController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.BacSiModel;
import models.BenhNhanModel;
import models.HoSoBenhAnModel;

/**
 *
 * @author manht
 */
public class QuanLyBenhNhan extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public QuanLyBenhNhan() {
        initComponents();
        setTitle("Quản lý bệnh nhân");
        setIconImageJframe();
        setMenu();
        getContentPane().setBackground(Color.WHITE);
        jPanel10.setPreferredSize(new Dimension(130, 138));

    }

    //    set icon cho jframe form
    private void setIconImageJframe() {
        URL hospitalIcon = DangKy.class.getResource("icons/Hospital-red-icon.png");
        Image img;
        img = Toolkit.getDefaultToolkit().createImage(hospitalIcon);
        this.setIconImage(img);
    }

//    menu
    private JFrame frame;

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuTrangChu = new JMenu("Trang chủ");
        JMenu jMenuDangKy = new JMenu("Đăng ký");
        JMenu jMenuDangNhap = new JMenu("Đăng nhập");
        JMenu jMenuQuanLy = new JMenu("Quản lý");
        JMenu jMenuDatLich = new JMenu("Đặt lịch");
        JMenu jMenuThoat = new JMenu("Thoát");

//      Tạo các JMenuItem và thêm chúng vào JMenu
        JMenuItem itemBenhNhan = new JMenuItem("Quản lý bệnh nhân");
        JMenuItem itemBacSi = new JMenuItem("Quản lý bác sĩ");
        jMenuQuanLy.add(itemBacSi);
        jMenuQuanLy.add(itemBenhNhan);

//        xét màu đậm cho menu
        Font boldFont = new Font("Arial", Font.BOLD, 12);
        itemBenhNhan.setFont(boldFont);
        menuBar.add(jMenuTrangChu);
        menuBar.add(jMenuDangKy);
        menuBar.add(jMenuDangNhap);
        menuBar.add(jMenuQuanLy);
        menuBar.add(jMenuDatLich);
        menuBar.add(jMenuThoat);
        int with = 14;
        int height = 14;

//      icon trang chủ
        String imgTrangChu = "views/icons/Home-icon.png";
        ClassLoader clTrangChu = getClass().getClassLoader();
        java.net.URL imageURLTrangChu = clTrangChu.getResource(imgTrangChu);
        ImageIcon iconTrangChu = new ImageIcon(imageURLTrangChu);
        jMenuTrangChu.setIcon(iconTrangChu);
        jMenuTrangChu.setIcon(new ImageIcon(iconTrangChu.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//      icon đăng ký
        String imgDangKy = "views/icons/regiter-icon.png";
        ClassLoader clDangKy = getClass().getClassLoader();
        java.net.URL imageURLDangKy = clDangKy.getResource(imgDangKy);
        ImageIcon iconDangKy = new ImageIcon(imageURLDangKy);
        jMenuDangKy.setIcon(iconDangKy);
        jMenuDangKy.setIcon(new ImageIcon(iconDangKy.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//      icon đăng nhập
        String imgDangNhap = "views/icons/login-icon.png";
        ClassLoader clDangNhap = getClass().getClassLoader();
        java.net.URL imageURLDangNhap = clDangNhap.getResource(imgDangNhap);
        ImageIcon iconDangNhap = new ImageIcon(imageURLDangNhap);
        jMenuDangNhap.setIcon(iconDangNhap);
        jMenuDangNhap.setIcon(new ImageIcon(iconDangNhap.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//      icon quản lý
        String imgQuanLy = "views/icons/Logos-Device-Manager-icon.png";
        ClassLoader clQuanLy = getClass().getClassLoader();
        java.net.URL imageURLQuanLy = clQuanLy.getResource(imgQuanLy);
        ImageIcon iconQuanLy = new ImageIcon(imageURLQuanLy);
        jMenuQuanLy.setIcon(iconQuanLy);
        jMenuQuanLy.setIcon(new ImageIcon(iconQuanLy.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//        icon quản lý bệnh nhân
        String imgQuanLyBenhNhan = "views/icons/patient-icon.png";
        ClassLoader clQuanLyBenhNhan = getClass().getClassLoader();
        java.net.URL imageURLQuanLyBenhNhan = clQuanLyBenhNhan.getResource(imgQuanLyBenhNhan);
        ImageIcon iconQuanLyBenhNhan = new ImageIcon(imageURLQuanLyBenhNhan);
        itemBenhNhan.setIcon(iconQuanLyBenhNhan);
        itemBenhNhan.setIcon(new ImageIcon(iconQuanLyBenhNhan.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//        icon quản lý bác sĩ
        String imgQuanLyBacSi = "views/icons/People-Doctor-Male-icon.png";
        ClassLoader clQuanLyBacSi = getClass().getClassLoader();
        java.net.URL imageURLQuanLyBacSi = clQuanLyBacSi.getResource(imgQuanLyBacSi);
        ImageIcon iconQuanLyBacSi = new ImageIcon(imageURLQuanLyBacSi);
        itemBacSi.setIcon(iconQuanLyBenhNhan);
        itemBacSi.setIcon(new ImageIcon(iconQuanLyBacSi.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//      icon đặt lịch
        String imgDatLich = "views/icons/Apps-preferences-system-time-icon.png";
        ClassLoader clDatLich = getClass().getClassLoader();
        java.net.URL imageURLDatLich = clDatLich.getResource(imgDatLich);
        ImageIcon iconDatLich = new ImageIcon(imageURLDatLich);
        jMenuDatLich.setIcon(iconDatLich);
        jMenuDatLich.setIcon(new ImageIcon(iconDatLich.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//       icon thoát
        String imgThoat = "views/icons/Exit-icon.png";
        ClassLoader clThoat = getClass().getClassLoader();
        java.net.URL imageURLThoat = clThoat.getResource(imgThoat);
        ImageIcon iconThoat = new ImageIcon(imageURLThoat);
        jMenuThoat.setIcon(iconThoat);
        jMenuThoat.setIcon(new ImageIcon(iconThoat.getImage().getScaledInstance(with, height, Image.SCALE_DEFAULT)));

//        Chuyển form quản lý bệnh nhân sang quản lý bác sĩ
        itemBacSi.addActionListener((var e) -> {
//                đóng form hiện tại
            dispose();
//                Tạo form mới
            QuanLyBacSi bacSi = new QuanLyBacSi();
//                Hiển thị form mới
            bacSi.setVisible(true);
        });

//        chuyển form quản lý bệnh nhân sang đặt lịch
        jMenuDatLich.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                QuanLyDatLich datLich = new QuanLyDatLich();
//                Hiển thị form mới
                datLich.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

//        chuyển form quản lý bệnh nhân khẩu sang đăng ký
        jMenuDangKy.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                DangKy dangKy = new DangKy();
//                Hiển thị form mới
                dangKy.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

//        chuyển form quản lý bệnh nhân sang form trang chủ
        jMenuTrangChu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                TrangChu trangChu = new TrangChu();
//                Hiển thị form mới
                trangChu.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

//        chuyển form bệnh nhân sang form đăng nhập
        jMenuDangNhap.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                DangNhap dangNhap = new DangNhap();

//                Hiển thị form mới
                dangNhap.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

//        thoát chương trình
        jMenuThoat.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn thoát chương trình không?", "Thoát chương trình", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        setJMenuBar(menuBar);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        txtMaBenhNhan = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        radNu = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnTaiAnh = new javax.swing.JButton();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaBenhNhan2 = new javax.swing.JLabel();
        txtTrieuChung = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMabenhNhan1 = new javax.swing.JTextField();
        txtMaBacSi = new javax.swing.JTextField();
        txtTienSuBenhAn = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaHoSo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtChuanDoan = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnTimTheoId = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnXem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa9 = new javax.swing.JButton();
        btnTimHoSoBenhNhan = new javax.swing.JButton();
        radBenhNhan = new javax.swing.JRadioButton();
        radBenhAn = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        txtKetLuanKham = new javax.swing.JTextField();
        btnTimTheoId2 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablebenhNhan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup2.add(radNu);
        radNu.setForeground(new java.awt.Color(0, 102, 102));
        radNu.setText("Nữ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Số điện thoại");

        buttonGroup2.add(radNam);
        radNam.setForeground(new java.awt.Color(0, 102, 102));
        radNam.setText("Nam");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Email");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Giới tính");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Thông tin bệnh nhân");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Họ và tên");

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/image-bacsi/3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 122, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAnh))
        );

        btnTaiAnh.setBackground(new java.awt.Color(0, 102, 102));
        btnTaiAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaiAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiAnh.setText("Tải ảnh");
        btnTaiAnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaiAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiAnhjButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Mã bệnh nhân");

        txtMaBenhNhan2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaBenhNhan2.setForeground(new java.awt.Color(0, 102, 102));
        txtMaBenhNhan2.setText("Mã bệnh nhân");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Thông tin hồ sơ bệnh án");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Tiền sử bệnh án");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Mã hồ sơ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Triệu chứng");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Mã bác sĩ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Danh sách thông tin bệnh nhân và bệnh án");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Chuẩn đoán");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Kết luận khám");

        btnTimTheoId.setBackground(new java.awt.Color(0, 102, 102));
        btnTimTheoId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimTheoId.setForeground(new java.awt.Color(255, 255, 255));
        btnTimTheoId.setText("<html>Tìm kiếm những bệnh nhân mà bác sĩ điều trị</html>");
        btnTimTheoId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimTheoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTheoIdActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 102, 102));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemjButton3ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Chức năng điều khiển");

        btnXem.setBackground(new java.awt.Color(0, 102, 102));
        btnXem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXem.setForeground(new java.awt.Color(255, 255, 255));
        btnXem.setText("Xem");
        btnXem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemjButton3ActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuajButton3ActionPerformed(evt);
            }
        });

        btnXoa9.setBackground(new java.awt.Color(0, 102, 102));
        btnXoa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa9.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa9.setText("Xóa");
        btnXoa9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa9jButton3ActionPerformed(evt);
            }
        });

        btnTimHoSoBenhNhan.setBackground(new java.awt.Color(0, 102, 102));
        btnTimHoSoBenhNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimHoSoBenhNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnTimHoSoBenhNhan.setText("<html>Tìm kiếm bệnh án của bệnh nhân</html>");
        btnTimHoSoBenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimHoSoBenhNhan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTimHoSoBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimHoSoBenhNhanActionPerformed(evt);
            }
        });

        buttonGroup1.add(radBenhNhan);
        radBenhNhan.setForeground(new java.awt.Color(0, 102, 102));
        radBenhNhan.setText("bệnh nhân");

        buttonGroup1.add(radBenhAn);
        radBenhAn.setForeground(new java.awt.Color(0, 102, 102));
        radBenhAn.setText("Bệnh án");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Tìm kiếm");

        btnTimTheoId2.setBackground(new java.awt.Color(0, 102, 102));
        btnTimTheoId2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimTheoId2.setForeground(new java.awt.Color(255, 255, 255));
        btnTimTheoId2.setText("Tìm id");
        btnTimTheoId2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimTheoId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTheoId2ActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 102, 102));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetjButton3ActionPerformed(evt);
            }
        });

        jTablebenhNhan.setForeground(new java.awt.Color(0, 102, 102));
        jTablebenhNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablebenhNhan.setAutoResizeMode(0);
        jTablebenhNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTablebenhNhan.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane3.setViewportView(jTablebenhNhan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTienSuBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaHoSo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMaBenhNhan2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMabenhNhan1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTrieuChung, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtChuanDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel18))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(radNam)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(radNu))
                                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtMaBenhNhan)
                                                    .addComponent(txtHoVaTen)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtSoDienThoai))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnTaiAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radBenhNhan))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radBenhAn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtKetLuanKham, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnTimHoSoBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimTheoId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimTheoId2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(radNam)
                            .addComponent(radNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaiAnh))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaBenhNhan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMabenhNhan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radBenhNhan)
                    .addComponent(radBenhAn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTrieuChung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem)
                        .addComponent(btnXem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa9))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTienSuBenhAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChuanDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimHoSoBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtKetLuanKham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnTimTheoId2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnTimTheoId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 private String selectedImagePath;
    private void btnTaiAnhjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiAnhjButton3ActionPerformed
        // Tạo một đối tượng JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Đặt bộ lọc để chỉ cho phép chọn các tệp hình ảnh
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hình ảnh", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        // Hiển thị hộp thoại chọn tệp
        int result = fileChooser.showOpenDialog(this);

        // Kiểm tra xem người dùng đã chọn tệp hay chưa
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn đến tệp hình ảnh được chọn
            File selectedFile = fileChooser.getSelectedFile();
            selectedImagePath = selectedFile.getAbsolutePath();

            // Hiển thị hình ảnh trên JLabel
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);
            lblAnh.setIcon(imageIcon);

        }
    }//GEN-LAST:event_btnTaiAnhjButton3ActionPerformed

    private void btnTimTheoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTheoIdActionPerformed
        String idTimKiem = txtTimKiem.getText().trim();
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID bác sĩ để tìm các bệnh nhân được điều trị.");
        }
        ArrayList<BenhNhanModel> danhSachBenhNhan;
        BacSiController bacSiController = new BacSiController();
        if (bacSiController.kiemTraMaBacSiTrung(idTimKiem) || "".equals(idTimKiem)) {
            BenhNhanController benhNhanController = new BenhNhanController();
            danhSachBenhNhan = benhNhanController.layDanhSachBenhNhanDuocBacSiKham(idTimKiem);

            // Tạo DefaultTableModel với các cột bạn muốn hiển thị
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã bệnh nhân");
            model.addColumn("Họ và Tên");
            model.addColumn("Số Điện Thoại");
            model.addColumn("Email");
            model.addColumn("Địa Chỉ");
            model.addColumn("Giới Tính");
            model.addColumn("Hình Ảnh");

            // Thêm dữ liệu từ danh sách bác sĩ vào model
            for (BenhNhanModel benhNhan : danhSachBenhNhan) {
                model.addRow(new Object[]{
                    benhNhan.getMaBenhNhan(),
                    benhNhan.getHoVaTen(),
                    benhNhan.getSoDienThoai(),
                    benhNhan.getEmai(),
                    benhNhan.getDiaChi(),
                    benhNhan.getGioiTinh(),
                    benhNhan.getHinhAnh()
                });
            }

            // Gắn model vào JTable
            jTablebenhNhan.setModel(model);
            jTablebenhNhan.setAutoscrolls(true);
            loadBenhNhan();
        } else {
            JOptionPane.showMessageDialog(null, "Bác sĩ bạn tìm không tồn tại.");
        }
    }//GEN-LAST:event_btnTimTheoIdActionPerformed

    private boolean isBenhNhanSelected = true;

    public void loadBenhNhan() {
        isBenhNhanSelected = true;
        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTablebenhNhan.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() && isBenhNhanSelected) {
                // Thực hiện chỉ khi bệnh nhân được chọn
                int selectedRow = jTablebenhNhan.getSelectedRow();
                if (selectedRow >= 0 && jTablebenhNhan.isRowSelected(selectedRow)) {
                    txtMaBenhNhan.setText(jTablebenhNhan.getValueAt(selectedRow, 0).toString());
                    txtHoVaTen.setText(jTablebenhNhan.getValueAt(selectedRow, 1).toString());
                    txtSoDienThoai.setText(jTablebenhNhan.getValueAt(selectedRow, 2).toString());
                    txtEmail.setText(jTablebenhNhan.getValueAt(selectedRow, 3).toString());
                    txtDiaChi.setText(jTablebenhNhan.getValueAt(selectedRow, 4).toString());
                    String gioiTinh = (String) jTablebenhNhan.getValueAt(selectedRow, 5);
                    if (gioiTinh != null) {
                        switch (gioiTinh) {
                            case "Nam" -> {
                                if (!radNam.isSelected()) {
                                    radNam.setSelected(true);
                                    radNu.setSelected(false);
                                }
                            }
                            case "Nữ" -> {
                                if (!radNu.isSelected()) {
                                    radNam.setSelected(false);
                                    radNu.setSelected(true);
                                }
                            }
                            default -> {
                                radNam.setSelected(false);
                                radNu.setSelected(false);
                            }
                        }
                    }
                    String hinhAnh = (String) jTablebenhNhan.getValueAt(selectedRow, 6);
                    if (hinhAnh != null) {
                        ImageIcon imageIcon = new ImageIcon(hinhAnh);
                        lblAnh.setIcon(imageIcon);
                    }
                    txtTimKiem.setText(txtMaBenhNhan.getText());
                    txtTienSuBenhAn.setText("");
                    txtTrieuChung.setText("");
                    txtChuanDoan.setText("");
                    txtKetLuanKham.setText("");
                    txtMaBacSi.setText("");
                    txtMabenhNhan1.setText("");
                    txtMaHoSo.setText("");
                }
            }
        });
    }

    public void loadHoSo() {
        isBenhNhanSelected = false;
        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTablebenhNhan.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting() && !isBenhNhanSelected) {
                // Thực hiện chỉ khi hồ sơ được chọn
                int selectedRow = jTablebenhNhan.getSelectedRow();
                if (selectedRow >= 0 && jTablebenhNhan.isRowSelected(selectedRow)) {
                    txtMaHoSo.setText(jTablebenhNhan.getValueAt(selectedRow, 0).toString());
                    txtMaBacSi.setText(jTablebenhNhan.getValueAt(selectedRow, 1).toString());
                    txtMabenhNhan1.setText(jTablebenhNhan.getValueAt(selectedRow, 2).toString());
                    txtTrieuChung.setText(jTablebenhNhan.getValueAt(selectedRow, 3).toString());
                    txtTienSuBenhAn.setText(jTablebenhNhan.getValueAt(selectedRow, 4).toString());
                    txtChuanDoan.setText(jTablebenhNhan.getValueAt(selectedRow, 5).toString());
                    txtKetLuanKham.setText(jTablebenhNhan.getValueAt(selectedRow, 6).toString());
                    txtTimKiem.setText(txtMaHoSo.getText());
                    txtHoVaTen.setText("");
                    txtSoDienThoai.setText("");
                    txtDiaChi.setText("");
                    txtMaBenhNhan.setText("");
                    buttonGroup2.clearSelection();
                    lblAnh.setIcon(null);
                    txtEmail.setText("");
                }
            }
        });
    }

    public void reset() {
        txtMaBenhNhan.setText("");
        txtMabenhNhan1.setText("");
        txtMaHoSo.setText("");
        txtHoVaTen.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtMaBacSi.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        txtTrieuChung.setText("");
        txtChuanDoan.setText("");
        txtKetLuanKham.setText("");
        txtTienSuBenhAn.setText("");
        // xóa icon ảnh
        lblAnh.setIcon(null);
        txtTimKiem.setText("");
    }

    public void themBenhNhan() {
        String hoTen = txtHoVaTen.getText();
        String maBenhNhan = txtMaBenhNhan.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String email = txtEmail.getText();
        String gioiTinh;
        String diaChi = txtDiaChi.getText();
        String hinhAnh;
        String tenDangNhap = DangNhap.xacNhanDangNhap;

        if (hoTen.isEmpty() || maBenhNhan.isEmpty() || soDienThoai.isEmpty() || email.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!");
        } else {
            ButtonModel selectedButton = buttonGroup2.getSelection();

            if (selectedButton == null) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
            } else {
                if (selectedButton == radNam.getModel()) {
                    gioiTinh = "Nam";
                } else if (selectedButton == radNu.getModel()) {
                    gioiTinh = "Nữ";
                } else {
                    gioiTinh = "Không xác định";
                }
                hinhAnh = selectedImagePath;

                BenhNhanController benhNhanController = new BenhNhanController();
                boolean maTonTai = benhNhanController.kiemTraMaBenhNhanTrung(maBenhNhan);

                if (maTonTai) {
                    JOptionPane.showMessageDialog(null, "Mã bệnh nhân tồn tại.");
                } else {
                    BenhNhanModel benhNhan = new BenhNhanModel(maBenhNhan, tenDangNhap, hoTen, soDienThoai, email, gioiTinh, diaChi, hinhAnh);
                    int rowsAffected = benhNhanController.themBenhNhan(benhNhan);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại!");
                    }
                }

            }

        }
    }

    public void themHoSo() {
        String maHoSo = txtMaHoSo.getText();
        String maBenhNhan = txtMabenhNhan1.getText();
        String maBacSi = txtMaBacSi.getText();
        String trieuChung = txtTrieuChung.getText();
        String tienSuBenhAn = txtTienSuBenhAn.getText();
        String chuanDoan = txtChuanDoan.getText();
        String ketLuan = txtKetLuanKham.getText();

        if (maHoSo.isEmpty() || maBenhNhan.isEmpty() || maBacSi.isEmpty() || trieuChung.isEmpty() || tienSuBenhAn.isEmpty() || chuanDoan.isEmpty() || ketLuan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!");
        } else {
            HoSoBenhAnController hoSoBenhAnController = new HoSoBenhAnController();
            boolean maTonTai = hoSoBenhAnController.kiemTraMaHoSoTrung(maHoSo);

            if (maTonTai) {
                JOptionPane.showMessageDialog(null, "Mã hồ sơ tồn tại.");
            } else {
                HoSoBenhAnModel hoSo = new HoSoBenhAnModel(maHoSo, maBacSi, maBenhNhan, trieuChung, tienSuBenhAn, chuanDoan, ketLuan);
                int rowsAffected = hoSoBenhAnController.themHoSo(hoSo);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã bác sĩ hoặc mã bệnh nhân không tồn tại !");
                }
            }
        }
    }

    private void hienThiDanhSachBenhNhan() {
        BenhNhanController benhNhanController = new BenhNhanController();
        ArrayList<BenhNhanModel> danhSachBenhNhan = benhNhanController.layDanhSachBenhNhan();

        // Tạo DefaultTableModel với các cột bạn muốn hiển thị
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã bệnh nhân");
        model.addColumn("Họ và Tên");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Địa Chỉ");
        model.addColumn("Giới Tính");
        model.addColumn("Hình Ảnh");

        // Thêm dữ liệu từ danh sách bác sĩ vào model
        for (BenhNhanModel benhNhan : danhSachBenhNhan) {
            model.addRow(new Object[]{
                benhNhan.getMaBenhNhan(),
                benhNhan.getHoVaTen(),
                benhNhan.getSoDienThoai(),
                benhNhan.getEmai(),
                benhNhan.getDiaChi(),
                benhNhan.getGioiTinh(),
                benhNhan.getHinhAnh()
            });
        }

        // Gắn model vào JTable
        jTablebenhNhan.setModel(model);
        jTablebenhNhan.setAutoscrolls(true);

    }

    private void hienThiDanhSachHoSo() {
        HoSoBenhAnController HoSoBenhAnController = new HoSoBenhAnController();
        ArrayList<HoSoBenhAnModel> danhSachHoSo = HoSoBenhAnController.layDanhSachHoSo();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã hồ sơ");
        model.addColumn("Mã bác sĩ");
        model.addColumn("Mã bệnh nhân");
        model.addColumn("Triệu chứng");
        model.addColumn("Tiền sử bệnh án");
        model.addColumn("Chuẩn đoán");
        model.addColumn("Kết luận");

        for (HoSoBenhAnModel hoSo : danhSachHoSo) {
            model.addRow(new Object[]{
                hoSo.getMaHoSo(),
                hoSo.getMaBacSi(),
                hoSo.getMaBenhNhan(),
                hoSo.getTrieuChung(),
                hoSo.getTienSuBenhAn(),
                hoSo.getChuanDoan(),
                hoSo.getKetLuan()
            });
        }

        // Gắn model vào JTable
        jTablebenhNhan.setModel(model);
        jTablebenhNhan.setAutoscrolls(true);

    }


    private void btnThemjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemjButton3ActionPerformed
        ButtonModel selectedButton = buttonGroup1.getSelection();
        if (selectedButton == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !");
        } else {
            if (selectedButton == radBenhNhan.getModel()) {
                themBenhNhan();
                hienThiDanhSachBenhNhan();

            } else if (selectedButton == radBenhAn.getModel()) {
                themHoSo();
                hienThiDanhSachHoSo();
            }
        }
    }//GEN-LAST:event_btnThemjButton3ActionPerformed

    private void btnXemjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemjButton3ActionPerformed
        ButtonModel selectedButton = buttonGroup1.getSelection();
        if (selectedButton == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !");
        } else {
            if (selectedButton == radBenhNhan.getModel()) {
                hienThiDanhSachBenhNhan();
                loadBenhNhan();

            }

            if (selectedButton == radBenhAn.getModel()) {
                loadHoSo();
                hienThiDanhSachHoSo();
            }
        }
    }//GEN-LAST:event_btnXemjButton3ActionPerformed

    public void suaBenhNhan() {
        // Lấy ID từ JTextField txtTimKiem
        String idCapNhat = txtTimKiem.getText().trim();

        // Kiểm tra xem ID có được nhập hay không
        if (idCapNhat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần cập nhật.");
        } else {
            // Đọc thông tin mới từ các trường nhập liệu
            String hoVaTen = txtHoVaTen.getText();
            String maBenhNhan = txtMaBenhNhan.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String diaChi = txtDiaChi.getText();
            String email = txtEmail.getText();
            String gioiTinh;
            String hinhAnh;
            String tenDangNhap = DangNhap.xacNhanDangNhap;

            ButtonModel selectedButton = buttonGroup2.getSelection();
            if (selectedButton == null) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính!");
                return;
            } else {
                if (selectedButton == radNam.getModel()) {
                    gioiTinh = "Nam";
                } else if (selectedButton == radNu.getModel()) {
                    gioiTinh = "Nữ";
                } else {
                    gioiTinh = "Không xác định";
                }
            }
            System.out.println(gioiTinh);
            hinhAnh = selectedImagePath;
            // Tạo một đối tượng BacSiModel mới từ thông tin đã nhập
            BenhNhanModel benhNhanModel = new BenhNhanModel(maBenhNhan, tenDangNhap, hoVaTen, soDienThoai, email, gioiTinh, diaChi, hinhAnh);

            // Gọi phương thức cập nhật thông tin từ controller
            BenhNhanController benhNhanController = new BenhNhanController();
            int rowsAffected = benhNhanController.capNhatThongTinBenhNhan(benhNhanModel, idCapNhat);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin bệnh nhân thành công.");
                hienThiDanhSachBenhNhan();
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idCapNhat);
            }
        }
    }

    public void suaHoSo() {
        // Lấy ID từ JTextField txtTimKiem
        String idCapNhat = txtTimKiem.getText().trim();

        // Kiểm tra xem ID có được nhập hay không
        if (idCapNhat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID hồ sơ cần cập nhật.");
        } else {
            // Đọc thông tin mới từ các trường nhập liệu
            String maHoSo = txtMaHoSo.getText();
            String maBacSi = txtMaBacSi.getText();
            String maBenhNhan = txtMabenhNhan1.getText();
            String trieuChung = txtTrieuChung.getText();
            String tienSuBenhAn = txtTienSuBenhAn.getText();
            String chuanDoan = txtChuanDoan.getText();
            String ketLuan = txtKetLuanKham.getText();

            HoSoBenhAnModel hoSoBenhAnModel = new HoSoBenhAnModel(maHoSo, maBacSi, maBenhNhan, trieuChung, tienSuBenhAn, chuanDoan, ketLuan);

            HoSoBenhAnController hoSoBenhAnController = new HoSoBenhAnController();
            int rowsAffected = hoSoBenhAnController.capNhatThongTinHoSo(hoSoBenhAnModel, idCapNhat);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin hồ sơ thành công.");
                hienThiDanhSachHoSo();
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ có ID: " + idCapNhat);
            }
        }
    }

    private void btnSuajButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuajButton3ActionPerformed
        ButtonModel selectedButton = buttonGroup1.getSelection();
        if (selectedButton == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !");
        } else {
            if (selectedButton == radBenhNhan.getModel()) {
                suaBenhNhan();
            }

            if (selectedButton == radBenhAn.getModel()) {
                suaHoSo();
            }
        }
    }//GEN-LAST:event_btnSuajButton3ActionPerformed

    private void btnXoa9jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa9jButton3ActionPerformed
        ButtonModel selectedButton = buttonGroup1.getSelection();
        if (selectedButton == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !");
        } else {
            if (selectedButton == radBenhNhan.getModel()) {
                String idXoa = txtTimKiem.getText().trim();
                if (idXoa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập ID bệnh nhân cần xóa.");
                } else {
                    BenhNhanController benhNhanController = new BenhNhanController();
                    int rowsAffected = benhNhanController.xoaBenhNhanTheoID(idXoa);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thành công.");
                        hienThiDanhSachBenhNhan();

                    } else if (rowsAffected == -1) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idXoa);
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thất bại.");
                    }
                }

            }

            if (selectedButton == radBenhAn.getModel()) {
                String idXoa = txtTimKiem.getText().trim();
                if (idXoa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần xóa.");
                } else {
                    HoSoBenhAnController hoSoBenhAnController = new HoSoBenhAnController();
                    int rowsAffected = hoSoBenhAnController.xoaHoSoTheoId(idXoa);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Xóa hồ sơ thành công.");
                        hienThiDanhSachHoSo();

                    } else if (rowsAffected == -1) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ có ID: " + idXoa);
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa hồ sơ thất bại.");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnXoa9jButton3ActionPerformed

    private void btnResetjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetjButton3ActionPerformed
        reset();
    }//GEN-LAST:event_btnResetjButton3ActionPerformed

    public void timBenhNhanTheoId(String idTimKiem) {
        BenhNhanController benhNhanController = new BenhNhanController();
        BenhNhanModel benhNhanTimKiem = benhNhanController.timBenhNhanTheoID(idTimKiem);

        if (benhNhanTimKiem != null) {
            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã bệnh nhân");
            customModel.addColumn("Họ và Tên");
            customModel.addColumn("Số Điện Thoại");
            customModel.addColumn("Email");
            customModel.addColumn("Địa Chỉ");
            customModel.addColumn("Giới Tính");
            customModel.addColumn("Hình ảnh");

            customModel.addRow(new Object[]{
                benhNhanTimKiem.getMaBenhNhan(),
                benhNhanTimKiem.getHoVaTen(),
                benhNhanTimKiem.getSoDienThoai(),
                benhNhanTimKiem.getEmai(),
                benhNhanTimKiem.getDiaChi(),
                benhNhanTimKiem.getGioiTinh(),
                benhNhanTimKiem.getHinhAnh()}
            );

            jTablebenhNhan.setModel(customModel);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân có ID: " + idTimKiem);
        }
    }

    public void timHoSoTheoId(String idTimKiem) {
        HoSoBenhAnController hoSoBenhAnController = new HoSoBenhAnController();
        HoSoBenhAnModel hoSoTimKiem = hoSoBenhAnController.timHoSoTheoID(idTimKiem);

        if (hoSoTimKiem != null) {
            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã hồ sơ");
            customModel.addColumn("Mã bác sĩ");
            customModel.addColumn("Mã bệnh nhân");
            customModel.addColumn("Triệu chứng");
            customModel.addColumn("Tiền sử bệnh án");
            customModel.addColumn("Chuẩn đoán");
            customModel.addColumn("Kết luận");

            customModel.addRow(new Object[]{
                hoSoTimKiem.getMaHoSo(),
                hoSoTimKiem.getMaBacSi(),
                hoSoTimKiem.getMaBenhNhan(),
                hoSoTimKiem.getTrieuChung(),
                hoSoTimKiem.getTienSuBenhAn(),
                hoSoTimKiem.getChuanDoan(),
                hoSoTimKiem.getKetLuan()}
            );

            jTablebenhNhan.setModel(customModel);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hồ sơ có ID: " + idTimKiem);
        }
    }

    private void btnTimTheoId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTheoId2ActionPerformed
        String idTimKiem = txtTimKiem.getText().trim();
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần tìm kiếm.");
        }

        ButtonModel selectedButton = buttonGroup1.getSelection();
        if (selectedButton == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân hoặc bệnh án !");
        } else {
            if (selectedButton == radBenhNhan.getModel()) {
                timBenhNhanTheoId(idTimKiem);
                loadBenhNhan();
            } else if (selectedButton == radBenhAn.getModel()) {
                timHoSoTheoId(idTimKiem);
                loadHoSo();
            }
        }

    }//GEN-LAST:event_btnTimTheoId2ActionPerformed

    private void btnTimHoSoBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimHoSoBenhNhanActionPerformed
        String idTimKiem = txtTimKiem.getText().trim();
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID bệnh nhân cần tìm kiếm.");
        }
        ArrayList<HoSoBenhAnModel> danhSachHoSo;
        BenhNhanController benhNhanController = new BenhNhanController();

        if (benhNhanController.kiemTraMaBenhNhanTrung(idTimKiem) || "".equals(idTimKiem)) {
            HoSoBenhAnController benhAnController = new HoSoBenhAnController();
            danhSachHoSo = benhAnController.layDanhSachHoSoTheoBenhNhan(idTimKiem);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã hồ sơ");
            model.addColumn("Mã bác sĩ");
            model.addColumn("Mã bệnh nhân");
            model.addColumn("Triệu chứng");
            model.addColumn("Tiền sử bệnh án");
            model.addColumn("Chuẩn đoán");
            model.addColumn("Kết luận");

            for (HoSoBenhAnModel hoSo : danhSachHoSo) {
                model.addRow(new Object[]{
                    hoSo.getMaHoSo(),
                    hoSo.getMaBacSi(),
                    hoSo.getMaBenhNhan(),
                    hoSo.getTrieuChung(),
                    hoSo.getTienSuBenhAn(),
                    hoSo.getChuanDoan(),
                    hoSo.getKetLuan()
                });
            }

            // Gắn model vào JTable
            jTablebenhNhan.setModel(model);
            jTablebenhNhan.setAutoscrolls(true);
            loadHoSo();
        } else {
            JOptionPane.showMessageDialog(null, "Bệnh nhân không tồn tại vui lòng tìm lại.");
        }


    }//GEN-LAST:event_btnTimHoSoBenhNhanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QuanLyBenhNhan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaiAnh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimHoSoBenhNhan;
    private javax.swing.JButton btnTimTheoId;
    private javax.swing.JButton btnTimTheoId2;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablebenhNhan;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton radBenhAn;
    private javax.swing.JRadioButton radBenhNhan;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtChuanDoan;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtKetLuanKham;
    private javax.swing.JTextField txtMaBacSi;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JLabel txtMaBenhNhan2;
    private javax.swing.JTextField txtMaHoSo;
    private javax.swing.JTextField txtMabenhNhan1;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTienSuBenhAn;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrieuChung;
    // End of variables declaration//GEN-END:variables
}
