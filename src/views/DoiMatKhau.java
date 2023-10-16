/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.TaiKhoanController;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author manht
 */
public class DoiMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form DoiMatKhau
     */
    public DoiMatKhau() {
        initComponents();
        setTitle("Đổi mật khẩu");
        setIconImageJframe();
        setMenu();
        getContentPane().setBackground(Color.WHITE);
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
//        Font boldFont = new Font("Arial", Font.BOLD, 12);
//        itemBenhNhan.setFont(boldFont);
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

//        phân quyền riêng admin truy cập tới bác sĩ
        itemBacSi.addActionListener((ActionEvent e) -> {
            if (!"admin".equals(DangNhap.xacNhanDangNhap)) {
                JOptionPane.showMessageDialog(null, "Chỉ Admin mới được truy cập mục này !");
            }
        });

        if (DangNhap.xacNhanDangNhap != null) {
            if (DangNhap.xacNhanDangNhap.equals("Admin")) {
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
                JOptionPane.showMessageDialog(null, "Chỉ Admin mới được truy cập mục này !");
            }
        });

        if (DangNhap.xacNhanDangNhap != null) {
            if (DangNhap.xacNhanDangNhap.equals("Admin")) {
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

        // phân quyền riêng user truy cập tới đặt lịch
        TaiKhoanController tk = new TaiKhoanController();
        boolean taiKhoanDaDangNhap = tk.kiemTraTenDangNhapTrung(DangNhap.xacNhanDangNhap);
        jMenuDatLich.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                if (!taiKhoanDaDangNhap) {
                    JOptionPane.showMessageDialog(null, "Bạn cần đăng nhập trước !");
                } else {
                    dispose();
                    QuanLyDatLich datLich = new QuanLyDatLich();
                    datLich.setVisible(true);
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

//        chuyển form đổi mật khẩu sang đăng ký
        jMenuDangKy.addMenuListener(
                new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e
            ) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                DangKy dangKy = new DangKy();

//                Hiển thị form mới
                dangKy.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e
            ) {
            }

            @Override
            public void menuCanceled(MenuEvent e
            ) {
            }
        });

//        chuyển form đổi mật khẩu sang form trang chủ
        jMenuTrangChu.addMenuListener(
                new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e
            ) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                TrangChu trangChu = new TrangChu();
//                Hiển thị form mới
                trangChu.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e
            ) {
            }

            @Override
            public void menuCanceled(MenuEvent e
            ) {
            }
        });

        //        chuyển form đổi mật khẩu sang form trang chủ
        jMenuDangNhap.addMenuListener(
                new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e
            ) {
//                đóng form hiện tại
                dispose();
//                Tạo form mới
                DangNhap dangNhap = new DangNhap();
//                Hiển thị form mới
                dangNhap.setVisible(true);
            }

            @Override
            public void menuDeselected(MenuEvent e
            ) {
            }

            @Override
            public void menuCanceled(MenuEvent e
            ) {
            }
        });

//        thoát chương trình
        jMenuThoat.addMenuListener(
                new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e
            ) {
                int result = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn thoát chương trình không?", "Thoát chương trình", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            @Override
            public void menuDeselected(MenuEvent e
            ) {
            }

            @Override
            public void menuCanceled(MenuEvent e
            ) {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        btnDoiMatKhau = new javax.swing.JButton();
        iconName = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        txtMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Mật khẩu cũ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Thay đổi mật khẩu");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Mật khẩu mới");

        btnDoiMatKhau.setBackground(new java.awt.Color(0, 102, 102));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setText("Thay đổi");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        iconName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/icons/forget-icon.png"))); // NOI18N

        btnDangNhap.setBackground(new java.awt.Color(0, 102, 102));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Tên đăng nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatKhauMoi))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatKhau))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(iconName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(218, 218, 218))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhauCu = new String(txtMatKhau.getPassword());
        String matKhauMoi = new String(txtMatKhauMoi.getPassword());

        // Kiểm tra xem tên đăng nhập và mật khẩu cũ có khớp với tài khoản đã đăng ký hay không
        TaiKhoanController doiMatKhauController = new TaiKhoanController();
        boolean doiMatKhauThanhCong = doiMatKhauController.doiMatKhau(tenDangNhap, matKhauCu, matKhauMoi);

        if (doiMatKhauThanhCong) {
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
            dispose();
            DangNhap dangNhap = new DangNhap();
            dangNhap.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại! Vui lòng kiểm tra lại tên đăng nhập và mật khẩu cũ.");
        }
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dispose();
        DangNhap dangNhap = new DangNhap();
        dangNhap.setVisible(true);
    }//GEN-LAST:event_btnDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhau.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DoiMatKhau().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JLabel iconName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
