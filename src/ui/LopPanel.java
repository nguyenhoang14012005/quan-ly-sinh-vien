
package ui;

import bus.KhoaBUS;
import bus.LopBUS;
import dto.Khoa;
import dto.Lop;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class LopPanel extends javax.swing.JPanel {

    private LopBUS lopBUS = new LopBUS();
    private KhoaBUS khoaBUS = new KhoaBUS();
    private DefaultTableModel tblModel;
    private List<Khoa> listKhoa;

    
    public LopPanel() {
        initComponents();
        initTable();        // Cấu hình bảng
        loadComboBoxKhoa(); // Load dữ liệu vào ComboBox
        loadData();         // Load dữ liệu lên bảng
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jPanelInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JTextField();
        txtCVHT = new javax.swing.JTextField();
        cboKhoa = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();

        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(51, 102, 255));
        jLabelTitle.setText("Quản Lý Lớp Học");

        jPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Lớp Học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setText("Mã Lớp :");

        jLabel2.setText("Tên Lớp :");

        jLabel3.setText("Thuộc Khoa :");

        jLabel4.setText("CVHT :");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
                jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMaLop)
                                        .addComponent(txtTenLop, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCVHT)
                                        .addComponent(cboKhoa, 0, 160, Short.MAX_VALUE))
                                .addGap(34, 34, 34))
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInputLayout.setVerticalGroup(
                jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(cboKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtCVHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem)
                                        .addComponent(btnSua)
                                        .addComponent(btnXoa)
                                        .addComponent(btnLamMoi))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Lớp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblLop.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Mã Lớp", "Tên Lớp", "Thuộc Khoa", "CVHT"
                }
        ));
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLop);

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
                jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        jPanelTableLayout.setVerticalGroup(
                jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabelTitle)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            Lop lop = getModel();
            String msg = lopBUS.addLop(lop);
            JOptionPane.showMessageDialog(this, msg);
            if (msg.contains("thành công")) {
                loadData();
                resetForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaLop.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn lớp cần sửa!");
                return;
            }
            Lop lop = getModel();
            String msg = lopBUS.updateLop(lop);
            JOptionPane.showMessageDialog(this, msg);
            if (msg.contains("thành công")) {
                loadData();
                resetForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaLop.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn lớp cần xóa!");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa lớp này?") == JOptionPane.YES_OPTION) {
            String msg = lopBUS.deleteLop(txtMaLop.getText());
            JOptionPane.showMessageDialog(this, msg);
            if (msg.contains("thành công")) {
                loadData();
                resetForm();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        resetForm();
        loadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        int row = tblLop.getSelectedRow();
        if (row >= 0) {
            setModel(row);
        }
    }//GEN-LAST:event_tblLopMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<Khoa> cboKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLop;
    private javax.swing.JTextField txtCVHT;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTenLop;
    // End of variables declaration//GEN-END:variables

    // --- CÁC HÀM LOGIC HỖ TRỢ (PRIVATE) ---

    private void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã Lớp", "Tên Lớp", "Thuộc Khoa", "CVHT"});
        tblLop.setModel(tblModel);
    }

    private void loadComboBoxKhoa() {
        try {
            listKhoa = khoaBUS.getAll();
            DefaultComboBoxModel<Khoa> cboModel = new DefaultComboBoxModel<>();
            for (Khoa k : listKhoa) {
                cboModel.addElement(k); // Hiển thị toString() của Khoa
            }
            cboKhoa.setModel(cboModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm phụ: Lấy tên Khoa từ Mã Khoa để hiển thị lên bảng
    private String getTenKhoa(String maKhoa) {
        if (listKhoa != null) {
            for (Khoa k : listKhoa) {
                if (k.getMaKhoa().equals(maKhoa)) {
                    return k.getTenKhoa();
                }
            }
        }
        return maKhoa;
    }

    private void loadData() {
        tblModel.setRowCount(0);
        try {
            for (Lop lop : lopBUS.getAll()) {
                tblModel.addRow(new Object[]{
                        lop.getMaLop(),
                        lop.getTenLop(),
                        getTenKhoa(lop.getMaKhoa()),
                        lop.getCVHT()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Lop getModel() throws Exception {
        if (txtMaLop.getText().trim().isEmpty() || txtTenLop.getText().trim().isEmpty()) {
            throw new Exception("Mã lớp và Tên lớp không được để trống!");
        }
        Lop lop = new Lop();
        lop.setMaLop(txtMaLop.getText().trim());
        lop.setTenLop(txtTenLop.getText().trim());
        lop.setCVHT(txtCVHT.getText().trim());

        Khoa selectedKhoa = (Khoa) cboKhoa.getSelectedItem();
        if (selectedKhoa == null) throw new Exception("Vui lòng chọn Khoa!");
        lop.setMaKhoa(selectedKhoa.getMaKhoa());

        return lop;
    }

    private void setModel(int rowIndex) {
        if (rowIndex < 0) return;
        txtMaLop.setText(tblLop.getValueAt(rowIndex, 0).toString());
        txtTenLop.setText(tblLop.getValueAt(rowIndex, 1).toString());

        // Logic chọn lại ComboBox dựa trên Tên Khoa hiển thị ở bảng
        String tenKhoaTable = tblLop.getValueAt(rowIndex, 2).toString();
        for (int i = 0; i < cboKhoa.getItemCount(); i++) {
            Khoa k = cboKhoa.getItemAt(i);
            if (k.getTenKhoa().equals(tenKhoaTable)) {
                cboKhoa.setSelectedIndex(i);
                break;
            }
        }

        Object cvht = tblLop.getValueAt(rowIndex, 3);
        txtCVHT.setText(cvht != null ? cvht.toString() : "");

        txtMaLop.setEditable(false);
        btnThem.setEnabled(false);
    }

    private void resetForm() {
        txtMaLop.setText("");
        txtTenLop.setText("");
        txtCVHT.setText("");
        if(cboKhoa.getItemCount() > 0) cboKhoa.setSelectedIndex(0);

        txtMaLop.setEditable(true);
        btnThem.setEnabled(true);
        tblLop.clearSelection();
    }
}