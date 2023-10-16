/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.DatLichKhamController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import models.BacSiModel;
import models.DatLichKhamModel;

/**
 *
 * @author manht
 */
public class QuanLyDatLich extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public QuanLyDatLich() {
        initComponents();
        timBacSiTheoChuyenKhoa();
        setTitle("Đặt lịch");
        lblTaiKhoan.setText(DangNhap.xacNhanDangNhap);
        setIconImageJframe();
        getContentPane().setBackground(Color.WHITE);
        setMenu();

//        đặt mặc định của cbbChuyenKhoa là null.
        cbbChuyenKhoa.setSelectedIndex(-1);
//        tự động load data lên jlist
        refreshListView(DangNhap.xacNhanDangNhap);
        // load tên cột tự động
        // Tạo DefaultTableModel với các cột bạn muốn hiển thị
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Bác Sĩ");
        model.addColumn("Họ và Tên");
        model.addColumn("Số Điện Thoại");
        model.addColumn("Email");
        model.addColumn("Địa Chỉ");
        model.addColumn("Giới Tính");
        model.addColumn("Chuyên Khoa");
        model.addColumn("Kinh Nghiệm Làm Việc");
        model.addColumn("Học Vấn");
        model.addColumn("Hình Ảnh");
        jTableBacSi.setModel(model);
        jList.setModel(listModel);
        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTableBacSi.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {

            int selectedRow = jTableBacSi.getSelectedRow();
            if (selectedRow >= 0 && jTableBacSi.isRowSelected(selectedRow)) {

                String hinhAnh = (String) jTableBacSi.getValueAt(selectedRow, 9);
                if (hinhAnh != null) {
                    ImageIcon imageIcon = new ImageIcon(hinhAnh);
                    lblAnh.setIcon(imageIcon);
                }

            }
        }
        );
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
        jMenuDatLich.setFont(boldFont);
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

//        chuyển form đặt lịch sang đăng ký
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

//        chuyển form đặt lịch sang form trang chủ
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

//        phân quyền riêng admin truy cập tới bác sĩ
        itemBacSi.addActionListener((ActionEvent e) -> {
            if (!"admin".equals(DangNhap.xacNhanDangNhap)) {
                JOptionPane.showMessageDialog(null, "Chỉ admin mới được truy cập mục này !");
            }
        });

        if (DangNhap.xacNhanDangNhap != null) {
            if (DangNhap.xacNhanDangNhap.equals("admin")) {
//                chuyển form đặt lịch sang form quản lý bác sĩ
                itemBacSi.addActionListener((ActionEvent e) -> {
//                đóng form hiện tại
                    dispose();
//                Tạo form mới
                    QuanLyBacSi bacSi = new QuanLyBacSi();
//                Hiển thị form mới
                    bacSi.setVisible(true);
                });
            }
        }

//                phân quyền riêng admin truy cập tới bệnh nhân
        itemBenhNhan.addActionListener((ActionEvent e) -> {
            if (!"admin".equals(DangNhap.xacNhanDangNhap)) {
                JOptionPane.showMessageDialog(null, "Chỉ admin mới được truy cập mục này !");
            }
        });

        if (DangNhap.xacNhanDangNhap != null) {
            if (DangNhap.xacNhanDangNhap.equals("admin")) {
//                chuyển form đặt lịch sang form quản lý bác sĩ
                itemBenhNhan.addActionListener((ActionEvent e) -> {
//                đóng form hiện tại
                    dispose();
//                Tạo form mới
                    QuanLyBenhNhan benhNhan = new QuanLyBenhNhan();
//                Hiển thị form mới
                    benhNhan.setVisible(true);
                });
            }
        }

        //        chuyển form đặt lịch sang form đăng nhập
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

    private void timBacSiTheoChuyenKhoa() {
        DatLichKhamController datLichKhamController = new DatLichKhamController();
        cbbChuyenKhoa.addActionListener((ActionEvent e) -> {
            int selectedIndex = cbbChuyenKhoa.getSelectedIndex();
            if (selectedIndex >= 0) {
                String selectedChuyenKhoa = (String) cbbChuyenKhoa.getItemAt(selectedIndex);
                System.out.println("Đã chọn chuyên khoa: " + selectedChuyenKhoa);
                ArrayList<BacSiModel> danhSachBacSi = datLichKhamController.layDanhSachBacSiTheoChuyenKhoa(selectedChuyenKhoa);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Mã Bác Sĩ");
                model.addColumn("Họ và Tên");
                model.addColumn("Số Điện Thoại");
                model.addColumn("Email");
                model.addColumn("Địa Chỉ");
                model.addColumn("Giới Tính");
                model.addColumn("Chuyên Khoa");
                model.addColumn("Kinh Nghiệm Làm Việc");
                model.addColumn("Học Vấn");
                model.addColumn("Hình Ảnh");

                for (BacSiModel bacSi : danhSachBacSi) {
                    model.addRow(new Object[]{
                        bacSi.getMaBacSi(),
                        bacSi.getHoVaTen(),
                        bacSi.getSoDienThoai(),
                        bacSi.getEmai(),
                        bacSi.getDiaChi(),
                        bacSi.getGioiTinh(),
                        bacSi.getChuyenKhoa(),
                        bacSi.getKinhNgiemLamViec(),
                        bacSi.getHocVan(),
                        bacSi.getHinhAnh()
                    });
                }

                jTableBacSi.setModel(model);

            } else {
                System.out.println("Chưa chọn chuyên khoa");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCaKham2 = new javax.swing.JLabel();
        lblCaKham5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCaKham7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbNgay = new javax.swing.JComboBox<>();
        lblCaKham3 = new javax.swing.JLabel();
        lblCaKham1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCaKham6 = new javax.swing.JLabel();
        lblCaKham11 = new javax.swing.JLabel();
        lblCaKham9 = new javax.swing.JLabel();
        lblCaKham10 = new javax.swing.JLabel();
        lblCaKham15 = new javax.swing.JLabel();
        lblCaKham14 = new javax.swing.JLabel();
        lblCaKham8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        btnHuyLich = new javax.swing.JButton();
        cbbChuyenKhoa = new javax.swing.JComboBox<>();
        lblAnh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCaKham4 = new javax.swing.JLabel();
        lblCaKham13 = new javax.swing.JLabel();
        lblCaKham12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblPhongKham = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        btnDatLich = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBacSi = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCaKham2.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham2.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham2.setText("08:30 - 09:00");
        lblCaKham2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham2.setOpaque(true);
        lblCaKham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham2MouseClicked(evt);
            }
        });

        lblCaKham5.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham5.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham5.setText("10:00 - 10:30");
        lblCaKham5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham5.setOpaque(true);
        lblCaKham5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham5MouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Chọn ngày");

        lblCaKham7.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham7.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham7.setText("11:00 - 11:30");
        lblCaKham7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham7.setOpaque(true);
        lblCaKham7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham7MouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icons/Calendar-icon.png"))); // NOI18N

        cbbNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7" }));

        lblCaKham3.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham3.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham3.setText("09:00 - 09:30");
        lblCaKham3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham3.setOpaque(true);
        lblCaKham3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham3MouseClicked(evt);
            }
        });

        lblCaKham1.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham1.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham1.setText("08:00 - 08:30");
        lblCaKham1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham1.setOpaque(true);
        lblCaKham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Đặt lịch khám");

        lblCaKham6.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham6.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham6.setText("10:30 - 11:00");
        lblCaKham6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham6.setOpaque(true);
        lblCaKham6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham6MouseClicked(evt);
            }
        });

        lblCaKham11.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham11.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham11.setText("14:30 - 15:00");
        lblCaKham11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham11.setOpaque(true);
        lblCaKham11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham11MouseClicked(evt);
            }
        });

        lblCaKham9.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham9.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham9.setText("13:30 - 14:00");
        lblCaKham9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham9.setOpaque(true);
        lblCaKham9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham9MouseClicked(evt);
            }
        });

        lblCaKham10.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham10.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham10.setText("14:00 - 14:30");
        lblCaKham10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham10.setOpaque(true);
        lblCaKham10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham10MouseClicked(evt);
            }
        });

        lblCaKham15.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham15.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham15.setText("16:00 - 16:30");
        lblCaKham15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham15.setOpaque(true);
        lblCaKham15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham15MouseClicked(evt);
            }
        });

        lblCaKham14.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham14.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham14.setText("15:30 - 16:00");
        lblCaKham14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham14.setOpaque(true);
        lblCaKham14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham14MouseClicked(evt);
            }
        });

        lblCaKham8.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham8.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham8.setText("15:00 - 15:30");
        lblCaKham8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham8.setOpaque(true);
        lblCaKham8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham8MouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jList);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Lịch sử đặt lịch khám / hủy lịch");

        btnHuyLich.setBackground(new java.awt.Color(0, 102, 102));
        btnHuyLich.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuyLich.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyLich.setText("Hủy lịch");
        btnHuyLich.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuyLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyLichActionPerformed(evt);
            }
        });

        cbbChuyenKhoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa da liễu", "Khoa thần kinh", "Khoa Tâm lý", "Khoa xương khớp", "Khoa tai - mũi - họng", "Khoa mắt", "Khoa xét nghiệm" }));

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/image-bacsi/3.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Chọn chuyên khoa");

        lblCaKham4.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham4.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham4.setText("16:30 - 17:00");
        lblCaKham4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham4.setOpaque(true);
        lblCaKham4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham4MouseClicked(evt);
            }
        });

        lblCaKham13.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham13.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham13.setText("17:00 - 17:30");
        lblCaKham13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham13.setOpaque(true);
        lblCaKham13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham13MouseClicked(evt);
            }
        });

        lblCaKham12.setBackground(new java.awt.Color(0, 102, 102));
        lblCaKham12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCaKham12.setForeground(new java.awt.Color(255, 255, 255));
        lblCaKham12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaKham12.setText("17:30 - 18:00");
        lblCaKham12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCaKham12.setOpaque(true);
        lblCaKham12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaKham12MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Xem thông tin bác sĩ điều trị theo chuyên khoa");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Chọn và đặt lịch ");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("ĐỊA CHỈ KHÁM");

        lblPhongKham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhongKham.setForeground(new java.awt.Color(0, 102, 102));
        lblPhongKham.setText("Phòng khám đa khoa bệnh viện EAUT");

        lblDiaChi.setForeground(new java.awt.Color(0, 102, 102));
        lblDiaChi.setText("78 Giải Phóng, Phương Mai, Đống Đa, Hà Nội.");

        lblGia.setBackground(new java.awt.Color(255, 255, 255));
        lblGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGia.setForeground(new java.awt.Color(0, 102, 102));
        lblGia.setText("Giá:");
        lblGia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblGia.setOpaque(true);

        btnDatLich.setBackground(new java.awt.Color(0, 102, 102));
        btnDatLich.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatLich.setForeground(new java.awt.Color(255, 255, 255));
        btnDatLich.setText("Đặt lịch");
        btnDatLich.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichActionPerformed(evt);
            }
        });

        jTableBacSi.setForeground(new java.awt.Color(0, 102, 102));
        jTableBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableBacSi.setAutoResizeMode(0);
        jTableBacSi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableBacSi.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane3.setViewportView(jTableBacSi);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Xin chào:");

        lblTaiKhoan.setForeground(new java.awt.Color(0, 102, 102));
        lblTaiKhoan.setText("manhz2003");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCaKham9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCaKham5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCaKham13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCaKham15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCaKham1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCaKham2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCaKham3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel25)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblTaiKhoan)))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblCaKham4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(btnDatLich)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHuyLich))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPhongKham)
                                            .addComponent(lblDiaChi)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnh)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHuyLich)
                                    .addComponent(btnDatLich)
                                    .addComponent(jLabel25)
                                    .addComponent(lblTaiKhoan)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCaKham1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCaKham5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCaKham9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCaKham14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCaKham13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhongKham, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDiaChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAnh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //    tạo 1 hàm random ra mã đặt lịch
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 5;
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            code.append(randomChar);
        }
        return code.toString().toUpperCase();
    }

//    random mã bác sĩ theo chuyên khoa
    public static String getRandomMaBacSi(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (model.getRowCount() > 0) {
            int randomRowIndex = new Random().nextInt(model.getRowCount());
            Object maBacSi = model.getValueAt(randomRowIndex, 0);

            if (maBacSi != null) {
                return maBacSi.toString();
            }
        }
        return null;
    }

//    cập nhật lại jlist
    private void refreshListView(String tenDangNhap) {
        DatLichKhamController datLichKhamController = new DatLichKhamController();
        ArrayList<DatLichKhamModel> danhSachDatLich = datLichKhamController.layDanhSachDatLich2(tenDangNhap);
        listModel.clear();
        for (DatLichKhamModel datLichKham : danhSachDatLich) {
            String thongTinDatLich = "Mã đặt lịch: " + datLichKham.getMaDatLich()
                    + ", trạng thái: " + datLichKham.getTrangThaiThanhToan()
                    + ", " + datLichKham.getThoiGioiKham()
                    + ", " + datLichKham.getChuyenKhoa()
                    + ", mã bác sĩ: " + datLichKham.getMaBacSi();
            listModel.addElement(thongTinDatLich);
        }
    }

//    đặt lịch và lưu trữ
    DefaultListModel<String> listModel = new DefaultListModel<>();
    Map<String, Set<String>> selectedDates = new HashMap<>();
    String maDatLich;

    public void datLich(String selectedLabel, String selectedDate, String selectChuyenKhoa) {
        String thoiGianKham = "Ca khám: [" + selectedDate + ", " + selectedLabel + "]";
        String chuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        DatLichKhamController datLichController = new DatLichKhamController();

        // Lấy ra ca khám đã chọn
        Set<String> selectedCaKham = selectedDates.get(thoiGianKham);
        if (selectedCaKham == null) {
            selectedCaKham = new HashSet<>();
        }

        selectedCaKham.add(selectedLabel);
        selectedDates.put(selectedDate, selectedCaKham);

        // Tạo nội dung hiển thị trên jList
        float giaDichVu = 300000.0f;
        lblGia.setText("Giá: " + giaDichVu + "đ");
        lblPhongKham.setText("Phòng khám đa khoa bệnh viện EAUT");
        lblDiaChi.setText("78 Giải Phóng, Phương Mai, Đống Đa, Hà Nội.");

        maDatLich = generateRandomCode();
        String diaChi = lblPhongKham.getText() + lblDiaChi.getText();
        String maBacSi = getRandomMaBacSi(jTableBacSi);
        String tenDangNhap = DangNhap.xacNhanDangNhap;
        boolean trungLich = datLichController.kiemTraTrungLich(thoiGianKham);
        boolean trungKhoa = datLichController.kiemTraChuyenKhoa(chuyenKhoa);
        if (chuyenKhoa == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chuyên khoa trước khi đặt lịch !");
        } else {
            if (trungLich && trungKhoa) {
                JOptionPane.showMessageDialog(this, "Bạn không được chọn trùng chuyên khoa hoặc ngày\ntrong cùng 1 ca !", "Lỗi chọn trùng ca", JOptionPane.ERROR_MESSAGE);
            } else {
                String trangThaiThanhToan = "Chưa thanh toán";
                DatLichKhamModel datLich = new DatLichKhamModel(maDatLich, giaDichVu, thoiGianKham, diaChi, tenDangNhap, trangThaiThanhToan, maBacSi, selectChuyenKhoa);
                int result = datLichController.insertDatLich(datLich);
                // Kiểm tra kết quả lưu vào CSDL
                if (result > 0) {
                    refreshListView(tenDangNhap);
                    JOptionPane.showMessageDialog(this, "Đặt lịch thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Đặt lịch thất bại!");
                }
            }

        }
    }


    private void btnHuyLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLichActionPerformed
        // Lấy chỉ số dòng được chọn trong JList
        int selectedIndex = jList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một lịch khám để xóa.");
        }
        if (selectedIndex != -1) {
            // Lấy dòng được chọn từ JList
            Object selectedObject = jList.getModel().getElementAt(selectedIndex);
            String selectedText = selectedObject.toString();
            int startIndex = selectedText.indexOf("Mã đặt lịch: ");
            if (startIndex != -1) {
                startIndex += "Mã đặt lịch: ".length();
                int commaIndex = selectedText.indexOf(",", startIndex);
                if (commaIndex != -1) {
                    String maHuyLich = selectedText.substring(startIndex, commaIndex);
                    listModel.remove(selectedIndex);
                    System.out.println("chọn được đặt lịch: " + maHuyLich);

                    // Sử dụng maDatLich để xóa dữ liệu tương ứng trong CSDL
                    int result = xoaLichKhamTrongCSDL(maHuyLich);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Xóa lịch khám thành công!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa lịch khám thất bại!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnHuyLichActionPerformed

    private int xoaLichKhamTrongCSDL(String maDatLich) {
        // Sử dụng maDatLich để thực hiện xóa dữ liệu trong CSDL
        DatLichKhamController datLichController = new DatLichKhamController();
        return datLichController.xoaLichKhamTheoId(maDatLich);
    }

//    đăng ký lịch đưa ra số lượng đăng ký, danh sách mã đặt lịch
    static int soLuongLichDat;
    static List<String> maDatLichList = new ArrayList<>();
    private void btnDatLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichActionPerformed
        Object[] selectedItems = jList.getSelectedValues();
        int itemCount = selectedItems.length;

        if (itemCount == 0) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn ít nhất một lịch trước khi thanh toán.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lặp qua danh sách các lịch đã chọn và kiểm tra nếu có lịch đã thanh toán
        for (Object selectedItem : selectedItems) {
            String selectedData = selectedItem.toString();
            String maDatLichItem = extractMaDatLich(selectedData);

            // Kiểm tra nếu chuỗi "Đã thanh toán" xuất hiện trong selectedItem
            if (selectedData.contains("Đã thanh toán")) {
                // Hiển thị mã đặt lịch trong thông báo
                JOptionPane.showMessageDialog(this, "Mã đặt lịch: " + maDatLichItem +"đã thanh toán\nvui lòng chọn lịch khác để tiếp tục thanh toán !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return; // Dừng vòng lặp nếu tìm thấy lịch đã thanh toán
            }

            maDatLichList.add(maDatLichItem);
        }

        soLuongLichDat = itemCount;
        dispose();
        ThanhToan thanhToan = new ThanhToan();
        thanhToan.setVisible(true);
    }

//    tìm mã đặt lịch
    private String extractMaDatLich(String data) {
        int startIndex = data.indexOf("Mã đặt lịch:") + "Mã đặt lịch:".length();
        int endIndex = data.indexOf(",", startIndex);
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            String maLich = data.substring(startIndex, endIndex).trim();
            return maLich;
        }
        return "";

    }//GEN-LAST:event_btnDatLichActionPerformed

    private void lblCaKham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham1MouseClicked
        String selectedLabel = lblCaKham1.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham1MouseClicked

    private void lblCaKham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham2MouseClicked
        String selectedLabel = lblCaKham2.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham2MouseClicked

    private void lblCaKham3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham3MouseClicked
        String selectedLabel = lblCaKham3.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham3MouseClicked

    private void lblCaKham4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham4MouseClicked
        String selectedLabel = lblCaKham4.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham4MouseClicked

    private void lblCaKham5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham5MouseClicked
        String selectedLabel = lblCaKham5.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham5MouseClicked

    private void lblCaKham6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham6MouseClicked
        String selectedLabel = lblCaKham6.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham6MouseClicked

    private void lblCaKham7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham7MouseClicked
        String selectedLabel = lblCaKham7.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham7MouseClicked

    private void lblCaKham8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham8MouseClicked
        String selectedLabel = lblCaKham8.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham8MouseClicked

    private void lblCaKham9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham9MouseClicked
        String selectedLabel = lblCaKham9.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham9MouseClicked

    private void lblCaKham10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham10MouseClicked
        String selectedLabel = lblCaKham10.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham10MouseClicked

    private void lblCaKham11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham11MouseClicked
        String selectedLabel = lblCaKham11.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham11MouseClicked

    private void lblCaKham12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham12MouseClicked
        String selectedLabel = lblCaKham12.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham12MouseClicked

    private void lblCaKham13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham13MouseClicked
        String selectedLabel = lblCaKham13.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham13MouseClicked

    private void lblCaKham14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham14MouseClicked
        String selectedLabel = lblCaKham14.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham14MouseClicked

    private void lblCaKham15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaKham15MouseClicked
        String selectedLabel = lblCaKham15.getText();
        String selectedDate = (String) cbbNgay.getSelectedItem();
        String selectChuyenKhoa = (String) cbbChuyenKhoa.getSelectedItem();
        datLich(selectedLabel, selectedDate, selectChuyenKhoa);
    }//GEN-LAST:event_lblCaKham15MouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDatLich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDatLich().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLich;
    private javax.swing.JButton btnHuyLich;
    private javax.swing.JComboBox<String> cbbChuyenKhoa;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableBacSi;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCaKham1;
    private javax.swing.JLabel lblCaKham10;
    private javax.swing.JLabel lblCaKham11;
    private javax.swing.JLabel lblCaKham12;
    private javax.swing.JLabel lblCaKham13;
    private javax.swing.JLabel lblCaKham14;
    private javax.swing.JLabel lblCaKham15;
    private javax.swing.JLabel lblCaKham2;
    private javax.swing.JLabel lblCaKham3;
    private javax.swing.JLabel lblCaKham4;
    private javax.swing.JLabel lblCaKham5;
    private javax.swing.JLabel lblCaKham6;
    private javax.swing.JLabel lblCaKham7;
    private javax.swing.JLabel lblCaKham8;
    private javax.swing.JLabel lblCaKham9;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblPhongKham;
    private javax.swing.JLabel lblTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
