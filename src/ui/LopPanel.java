package ui;

import bus.KhoaBUS;
import bus.LopBUS;
import dto.Khoa;
import dto.Lop;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import helper.AutoUpdateHelper;

public class LopPanel extends javax.swing.JPanel {

    private LopBUS lopBUS = new LopBUS();
    private KhoaBUS khoaBUS = new KhoaBUS();
    private DefaultTableModel tblModel;
    private List<Khoa> listKhoa;

    public LopPanel() {
        initComponents();
        initTable();
        loadComboBoxKhoa();
        loadData();

        if(AutoUpdateHelper.class != null) {
            try {
                AutoUpdateHelper.addAutoRefresh(this, ()-> loadComboBoxKhoa());
            } catch(Exception e) {}
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
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
                                .addGap(30, 30, 30)
                                // Cột 1: Label Mã & Tên
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                // Cột 2: TextField Mã & Tên
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                // Cột 3: Label Khoa & CVHT
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                // Cột 4: ComboBox & TextField CVHT
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCVHT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        // Hàng nút bấm
                        .addGroup(GroupLayout.Alignment.CENTER, jPanelInputLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelInputLayout.setVerticalGroup(
                jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
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
                                .addGap(30, 30, 30)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem)
                                        .addComponent(btnSua)
                                        .addComponent(btnXoa)
                                        .addComponent(btnLamMoi))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Lớp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblLop.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
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
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
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
    }// </editor-fold>

    // Logic & event

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {
        resetForm();
        loadData();
    }

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblLop.getSelectedRow();
        if (row >= 0) {
            setModel(row);
        }
    }

    // Helper

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
                cboModel.addElement(k);
            }
            cboKhoa.setModel(cboModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    }

    private void resetForm() {
        txtMaLop.setText("");
        txtTenLop.setText("");
        txtCVHT.setText("");
        if(cboKhoa.getItemCount() > 0) cboKhoa.setSelectedIndex(0);

        txtMaLop.setEditable(true);
        tblLop.clearSelection();
    }

    // Variables declaration - do not modify
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
    // End of variables declaration
}