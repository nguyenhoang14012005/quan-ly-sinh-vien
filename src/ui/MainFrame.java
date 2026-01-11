
package ui;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    private dto.TaiKhoan tk;
    private CardLayout layout;
    public MainFrame() {
        initComponents();
        logo.setupIcon(this);
        initLayout();
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
    }
    public MainFrame(dto.TaiKhoan tk){
        initComponents();
        logo.setupIcon(this);
        this.tk = tk;
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        initLayout();
    }
    private void initLayout(){
        this.setLocationRelativeTo(null);
        layout = (CardLayout) pnlContent.getLayout();
        pnlContent.add(new javax.swing.JPanel(),"cardRong");
        pnlContent.add(new KhoaPanel(),"cardKhoa");
        pnlContent.add(new SinhVienPanel(),"cardSinhVien");
        pnlContent.add(new DiemPanel(),"cardDiem");
        pnlContent.add(new LopPanel(),"cardLop");
        pnlContent.add(new MonHocPanel(),"cardMonHoc");
        
        java.awt.CardLayout layout = (java.awt.CardLayout) pnlContent.getLayout();
        layout.show(pnlContent,"cardRong");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSinhVien = new javax.swing.JButton();
        btnDiem = new javax.swing.JButton();
        btnKhoa = new javax.swing.JButton();
        btnLop = new javax.swing.JButton();
        btnMonHoc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 188, 221));

        btnSinhVien.setText("Sinh viên");
        btnSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinhVienActionPerformed(evt);
            }
        });

        btnDiem.setText("Điểm");
        btnDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemActionPerformed(evt);
            }
        });

        btnKhoa.setText("Khoa");
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });

        btnLop.setText("Lớp");
        btnLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLopActionPerformed(evt);
            }
        });

        btnMonHoc.setText("Môn học");
        btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(btnDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnKhoa)
                .addGap(18, 18, 18)
                .addComponent(btnSinhVien)
                .addGap(18, 18, 18)
                .addComponent(btnDiem)
                .addGap(18, 18, 18)
                .addComponent(btnLop)
                .addGap(18, 18, 18)
                .addComponent(btnMonHoc)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Quản lý sinh viên");

        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDangXuat)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat)))
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pnlContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinhVienActionPerformed
        
        layout.show(pnlContent,"cardSinhVien");
        pnlContent.revalidate();
        pnlContent.repaint();
    }//GEN-LAST:event_btnSinhVienActionPerformed

    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed
        layout.show(pnlContent,"cardKhoa");
        pnlContent.revalidate();
        pnlContent.repaint();
    }//GEN-LAST:event_btnKhoaActionPerformed

    private void btnDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemActionPerformed
        layout.show(pnlContent,"cardDiem");
        pnlContent.revalidate();
        pnlContent.repaint();
    }//GEN-LAST:event_btnDiemActionPerformed

    private void btnLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLopActionPerformed
        layout.show(pnlContent,"cardLop");
        pnlContent.revalidate();
        pnlContent.repaint();
    }//GEN-LAST:event_btnLopActionPerformed

    private void btnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonHocActionPerformed
        layout.show(pnlContent,"cardMonHoc");
        pnlContent.revalidate();
        pnlContent.repaint();
    }//GEN-LAST:event_btnMonHocActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        int choice = javax.swing.JOptionPane.showConfirmDialog(this,
                "Bạn muốn đăng xuất khỏi hệ thống?","Đăng xuất",
                javax.swing.JOptionPane.YES_NO_OPTION);
        if(choice == javax.swing.JOptionPane.YES_NO_OPTION){
            this.dispose();
            ui.LoginFrame login = new LoginFrame();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int choice = javax.swing.JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn thoát?","Xác nhận thoát",
                javax.swing.JOptionPane.YES_NO_OPTION);
        if(choice == javax.swing.JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDiem;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnLop;
    private javax.swing.JButton btnMonHoc;
    private javax.swing.JButton btnSinhVien;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}
