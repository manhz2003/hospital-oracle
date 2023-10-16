/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.BacSiController;
import models.BacSiModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manht
 */
public class QuanLyBacSi extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public QuanLyBacSi() {
        initComponents();
        setTitle("Quản lý bác sĩ");
        setIconImageJframe();
        setMenu();
        jPanel10.setBorder(new LineBorder(Color.WHITE, 1));
        jPanel10.setPreferredSize(new Dimension(130, 138));
        getContentPane().setBackground(Color.WHITE);

//        load tên cột tự động
//        Tạo DefaultTableModel với các cột bạn muốn hiển thị
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

        // Thiết lập sự kiện cho JTable khi dòng được chọn
        jTableBacSi.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTableBacSi.getSelectedRow();
                if (selectedRow >= 0 && jTableBacSi.isRowSelected(selectedRow)) {
                    // Lấy dữ liệu từ dòng được chọn và đặt vào các thành phần điều khiển tương ứng
                    Object value = jTableBacSi.getValueAt(selectedRow, 0);
                    if (value != null) {
                        txtTimKiem.setText(value.toString());
                    }
                    txtTimKiem.setText(jTableBacSi.getValueAt(selectedRow, 0).toString());
                    txtMaBacSi.setText(jTableBacSi.getValueAt(selectedRow, 0).toString());
                    txtHoVaTen.setText(jTableBacSi.getValueAt(selectedRow, 1).toString());
                    txtSoDienThoai.setText(jTableBacSi.getValueAt(selectedRow, 2).toString());
                    txtEmail.setText(jTableBacSi.getValueAt(selectedRow, 3).toString());
                    txtDiaChi.setText(jTableBacSi.getValueAt(selectedRow, 4).toString());
                    String gioiTinh = (String) jTableBacSi.getValueAt(selectedRow, 5);
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

                    String chuyenKhoa = (String) jTableBacSi.getValueAt(selectedRow, 6);
                    if (chuyenKhoa != null) {
                        cbbChuyenKhoa.setSelectedItem(chuyenKhoa);
                    }

                    txtKinhNghiem.setText((String) jTableBacSi.getValueAt(selectedRow, 7));
                    txtHocVan.setText((String) jTableBacSi.getValueAt(selectedRow, 8));

                    String hinhAnh = (String) jTableBacSi.getValueAt(selectedRow, 9);
                    if (hinhAnh != null) {
                        ImageIcon imageIcon = new ImageIcon(hinhAnh);
                        lblAnh.setIcon(imageIcon);
                    }
                }
            }
        });

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
        itemBacSi.setFont(boldFont);
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

//        chuyển form bác sĩ sang form quản lý bệnh nhân
        itemBenhNhan.addActionListener((ActionEvent e) -> {
//                đóng form hiện tại
            dispose();
//                Tạo form mới
            QuanLyBenhNhan benhNhan = new QuanLyBenhNhan();
//                Hiển thị form mới
            benhNhan.setVisible(true);
        });

//        chuyển form bác sĩ sang đặt lịch
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

//        chuyển form quản lý bác sĩ khẩu sang đăng ký
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

//        chuyển form quản lý bác sĩ sang form trang chủ
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

//        chuyển form bác sĩ sang form đăng nhập
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

    private void hienThiDanhSachBacSi() {
        // Gọi controller để lấy danh sách bác sĩ
        BacSiController bacSiController = new BacSiController();
        ArrayList<BacSiModel> danhSachBacSi = bacSiController.layDanhSachBacSi();

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

        // Thêm dữ liệu từ danh sách bác sĩ vào model
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

        // Gắn model vào JTable
        jTableBacSi.setModel(model);
        jTableBacSi.setAutoscrolls(true);

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
        jPanel10 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaBacSi = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        radNu = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHocVan = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBacSi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnTimTheoId = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKinhNghiem = new javax.swing.JTextArea();
        cbbChuyenKhoa = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btnTaiAnh = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Học vấn");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Mã bác sĩ");

        buttonGroup1.add(radNu);
        radNu.setForeground(new java.awt.Color(0, 102, 102));
        radNu.setText("Nữ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Số điện thoại");

        buttonGroup1.add(radNam);
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
        jLabel5.setText("Thông tin bác sĩ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Kinh nghiệm làm việc:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Họ và tên");

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

        btnSua.setBackground(new java.awt.Color(0, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuajButton2ActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 102));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoajButton4ActionPerformed(evt);
            }
        });

        btnXoaTatCa.setBackground(new java.awt.Color(0, 102, 102));
        btnXoaTatCa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaTatCa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTatCa.setText("Xem");
        btnXoaTatCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCajButton1ActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Danh sách bác sĩ");

        btnTimTheoId.setBackground(new java.awt.Color(0, 102, 102));
        btnTimTheoId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimTheoId.setForeground(new java.awt.Color(255, 255, 255));
        btnTimTheoId.setText("Tìm kiếm theo mã");
        btnTimTheoId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimTheoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTheoIdActionPerformed(evt);
            }
        });

        txtKinhNghiem.setColumns(20);
        txtKinhNghiem.setRows(5);
        jScrollPane2.setViewportView(txtKinhNghiem);

        cbbChuyenKhoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa da liễu", "Khoa thần kinh", "Khoa Tâm lý", "Khoa xương khớp", "Khoa tai - mũi - họng", "Khoa mắt", "Khoa xét nghiệm" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Chuyên khoa");

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

        btnReset.setBackground(new java.awt.Color(0, 102, 102));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetjButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(txtSoDienThoai))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaBacSi, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                            .addComponent(txtHoVaTen))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(radNam)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radNu))
                                            .addComponent(txtHocVan, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                            .addComponent(txtDiaChi)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTaiAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(txtTimKiem)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnTimTheoId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHocVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaiAnh)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cbbChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimTheoId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaTatCajButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCajButton1ActionPerformed
        // Gọi controller để lấy danh sách bác sĩ
        BacSiController bacSiController = new BacSiController();
        ArrayList<BacSiModel> danhSachBacSi = bacSiController.layDanhSachBacSi();

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
        model.addColumn("Ảnh");

        // Thêm dữ liệu từ danh sách bác sĩ vào model
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

//         Gắn model vào JTable.
        jTableBacSi.setModel(model);

//        tự động chỉnh độ rộng cột với thanh cuộn ngang.
        jTableBacSi.setAutoscrolls(true);
    }//GEN-LAST:event_btnXoaTatCajButton1ActionPerformed

    private void btnXoajButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoajButton4ActionPerformed
        String idXoa = txtTimKiem.getText().trim();
        if (idXoa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần xóa.");
        } else {
            BacSiController bacSiController = new BacSiController();
            int rowsAffected = bacSiController.xoaBacSiTheoID(idXoa);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Xóa bác sĩ thành công.");
                hienThiDanhSachBacSi();
            } else if (rowsAffected == -1) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idXoa);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa bác sĩ thất bại.");
            }
        }
    }//GEN-LAST:event_btnXoajButton4ActionPerformed

    private void btnSuajButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuajButton2ActionPerformed
        // Lấy ID từ JTextField txtTimKiem
        String idCapNhat = txtTimKiem.getText().trim();

        // Kiểm tra xem ID có được nhập hay không
        if (idCapNhat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần cập nhật.");
        } else {
            // Đọc thông tin mới từ các trường nhập liệu
            String maBacSi = txtMaBacSi.getText();
            String hoVaTen = txtHoVaTen.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String diaChi = txtDiaChi.getText();
            String kinhNghiem = txtKinhNghiem.getText();
            String email = txtEmail.getText();
            String hocVan = txtHocVan.getText();
            String gioiTinh = "";
            String chuyenKhoa = "";
            String hinhAnh = "";

            ButtonModel selectedButton = buttonGroup1.getSelection();
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

            Object selectedChuyenKhoa = cbbChuyenKhoa.getSelectedItem();
            if (selectedChuyenKhoa != null) {
                chuyenKhoa = selectedChuyenKhoa.toString();
            }
            hinhAnh = selectedImagePath;
            // Tạo một đối tượng BacSiModel mới từ thông tin đã nhập
            BacSiModel bacSiMoi = new BacSiModel(maBacSi, hoVaTen, soDienThoai, email, gioiTinh, diaChi, chuyenKhoa, kinhNghiem, hocVan, hinhAnh);

            // Gọi phương thức cập nhật thông tin từ controller
            BacSiController bacSiController = new BacSiController();
            int rowsAffected = bacSiController.capNhatThongTinBacSi(bacSiMoi, idCapNhat);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin bác sĩ thành công.");
                hienThiDanhSachBacSi();
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idCapNhat);
            }
        }
    }//GEN-LAST:event_btnSuajButton2ActionPerformed

//    thêm dữ liệu
    private void btnThemjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemjButton3ActionPerformed
        String maBacSi = txtMaBacSi.getText();
        String hoVaTen = txtHoVaTen.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        String kinhNghiem = txtKinhNghiem.getText();
        String email = txtEmail.getText();
        String hocVan = txtHocVan.getText();
        String gioiTinh = "";
        String chuyenKhoa = "";
        String hinhAnh = "";

        if (maBacSi.isEmpty() || hoVaTen.isEmpty() || soDienThoai.isEmpty() || diaChi.isEmpty() || kinhNghiem.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!");
        } else {
            ButtonModel selectedButton = buttonGroup1.getSelection();
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
                // Kiểm tra chuyên khoa
                Object selectedChuyenKhoa = cbbChuyenKhoa.getSelectedItem();
                if (selectedChuyenKhoa == null || selectedChuyenKhoa.toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn chuyên khoa!");
                } else {
                    chuyenKhoa = selectedChuyenKhoa.toString();
                    // Kiểm tra xem mã bác sĩ đã tồn tại
                    BacSiController bacSiController = new BacSiController();
                    boolean maTonTai = bacSiController.kiemTraMaBacSiTrung(maBacSi);

                    if (maTonTai) {
                        JOptionPane.showMessageDialog(null, "Mã bác sĩ đã tồn tại!");
                    } else {
                        BacSiModel bacSiModel = new BacSiModel(maBacSi, hoVaTen, soDienThoai, email, gioiTinh, diaChi, chuyenKhoa, kinhNghiem, hocVan, hinhAnh);
                        // Gọi controller để thực hiện đăng ký
                        int rowsAffected = bacSiController.themBacSi(bacSiModel);

                        // Kiểm tra kết quả và hiển thị thông báo
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!");
                            hienThiDanhSachBacSi();
                            reset();
                        } else {
                            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại!");
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btnThemjButton3ActionPerformed


    private void btnTimTheoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTheoIdActionPerformed
        // Lấy ID từ JTextField txtTimKiem
        String idTimKiem = txtTimKiem.getText().trim();

        // Kiểm tra xem ID có được nhập hay không
        if (idTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ID cần tìm kiếm.");
            return;
        }

        // Gọi phương thức tìm kiếm bác sĩ theo ID từ controller
        BacSiController bacSiController = new BacSiController();
        BacSiModel bacSiTimKiem = bacSiController.timBacSiTheoID(idTimKiem);

        // Kiểm tra xem có bác sĩ nào được tìm thấy không
        if (bacSiTimKiem != null) {
            // Tạo một custom DefaultTableModel để hiển thị kết quả tìm kiếm
            DefaultTableModel customModel = new DefaultTableModel();
            customModel.addColumn("Mã Bác Sĩ");
            customModel.addColumn("Họ và Tên");
            customModel.addColumn("Số Điện Thoại");
            customModel.addColumn("Email");
            customModel.addColumn("Địa Chỉ");
            customModel.addColumn("Giới Tính");
            customModel.addColumn("Chuyên Khoa");
            customModel.addColumn("Kinh Nghiệm Làm Việc");
            customModel.addColumn("Học Vấn");
            customModel.addColumn("Hình ảnh");

            // Thêm thông tin của bác sĩ được tìm thấy vào customModel
            customModel.addRow(new Object[]{
                bacSiTimKiem.getMaBacSi(),
                bacSiTimKiem.getHoVaTen(),
                bacSiTimKiem.getSoDienThoai(),
                bacSiTimKiem.getEmai(),
                bacSiTimKiem.getDiaChi(),
                bacSiTimKiem.getGioiTinh(),
                bacSiTimKiem.getChuyenKhoa(),
                bacSiTimKiem.getKinhNgiemLamViec(),
                bacSiTimKiem.getHocVan(),
                bacSiTimKiem.getHinhAnh()
            }
            );

            // Gán customModel vào jTableBacSi để hiển thị kết quả
            jTableBacSi.setModel(customModel);
        } else {
            // Hiển thị thông báo nếu không tìm thấy bác sĩ
            JOptionPane.showMessageDialog(null, "Không tìm thấy bác sĩ có ID: " + idTimKiem);
        }
    }//GEN-LAST:event_btnTimTheoIdActionPerformed

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

    private void btnResetjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetjButton3ActionPerformed
        reset();
    }//GEN-LAST:event_btnResetjButton3ActionPerformed

    public void reset() {
        txtMaBacSi.setText("");
        txtHoVaTen.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        buttonGroup1.clearSelection();
        txtDiaChi.setText("");
        cbbChuyenKhoa.setSelectedIndex(0);
        txtHocVan.setText("");
        txtKinhNghiem.setText("");
        txtTimKiem.setText("");
        // xóa icon ảnh
        lblAnh.setIcon(null);
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBacSi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QuanLyBacSi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaiAnh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimTheoId;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChuyenKhoa;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableBacSi;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtHocVan;
    private javax.swing.JTextArea txtKinhNghiem;
    private javax.swing.JTextField txtMaBacSi;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
