package ui;

import bus.MonHocBUS;
import dto.MonHoc;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class MonHocPanel extends javax.swing.JPanel {

    private MonHocBUS mhBUS = new MonHocBUS();
    private DefaultTableModel model;
    private JTextField txtMaMH, txtTenMH, txtKyHoc, txtSoTinChi;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi;
    private JTable tblMonHoc;

    public MonHocPanel() {
        myInitComponents(); 
        initTable();
        loadData();
    }

    private void myInitComponents() {
        // 1. Cấu trúc tổng thể
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(240, 240, 240));

        // --- TIÊU ĐỀ XANH (Quản Lý Môn Học) ---
        JLabel lblHeader = new JLabel("Quản Lý Môn Học");
        lblHeader.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblHeader.setForeground(new Color(51, 102, 255));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 0));
        add(lblHeader, BorderLayout.NORTH);

        // --- PANEL TRUNG TÂM CHỨA INPUT VÀ TABLE ---
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
        pnlCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 2. Khu vực nhập liệu (Thông tin môn học)
        JPanel pnlInputInfo = new JPanel(new GridBagLayout());
        pnlInputInfo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Thông Tin Môn Học", TitledBorder.LEFT, TitledBorder.TOP));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 15, 8, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Cột 1
        gbc.gridx = 0; gbc.gridy = 0; pnlInputInfo.add(new JLabel("Mã Môn Học :"), gbc);
        gbc.gridx = 1; txtMaMH = new JTextField(18); pnlInputInfo.add(txtMaMH, gbc);
        gbc.gridx = 0; gbc.gridy = 1; pnlInputInfo.add(new JLabel("Tên Môn Học :"), gbc);
        gbc.gridx = 1; txtTenMH = new JTextField(18); pnlInputInfo.add(txtTenMH, gbc);

        // Cột 2
        gbc.gridx = 2; gbc.gridy = 0; pnlInputInfo.add(new JLabel("Kỳ Học :"), gbc);
        gbc.gridx = 3; txtKyHoc = new JTextField(18); pnlInputInfo.add(txtKyHoc, gbc);
        gbc.gridx = 2; gbc.gridy = 1; pnlInputInfo.add(new JLabel("Số Tín Chỉ :"), gbc);
        gbc.gridx = 3; txtSoTinChi = new JTextField(18); pnlInputInfo.add(txtSoTinChi, gbc);

        // 3. Panel Nút bấm
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        pnlButtons.add(btnThem); pnlButtons.add(btnSua); pnlButtons.add(btnXoa); pnlButtons.add(btnLamMoi);

        // Gom Input và Nút bấm vào 1 khối
        JPanel pnlTopGroup = new JPanel(new BorderLayout());
        pnlTopGroup.add(pnlInputInfo, BorderLayout.CENTER);
        pnlTopGroup.add(pnlButtons, BorderLayout.SOUTH);
        pnlCenter.add(pnlTopGroup);

        // 4. Khu vực Danh sách (Bảng dữ liệu)
        JPanel pnlTable = new JPanel(new BorderLayout());
        pnlTable.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Danh Sách Môn Học", TitledBorder.LEFT, TitledBorder.TOP));
        
        tblMonHoc = new JTable();
        tblMonHoc.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(tblMonHoc);
        pnlTable.add(scrollPane, BorderLayout.CENTER);
        
        pnlCenter.add(Box.createRigidArea(new Dimension(0, 10))); // Khoảng cách giữa 2 khu vực
        pnlCenter.add(pnlTable);

        add(pnlCenter, BorderLayout.CENTER);

        // --- GÁN SỰ KIỆN ---
        tblMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblMonHoc.getSelectedRow();
                if (row >= 0) setModel(row);
            }
        });
        btnThem.addActionListener(e -> btnThemActionPerformed());
        btnSua.addActionListener(e -> btnSuaActionPerformed());
        btnXoa.addActionListener(e -> btnXoaActionPerformed());
        btnLamMoi.addActionListener(e -> clearForm());
    }

    // --- CÁC HÀM LOGIC (Giữ nguyên hoặc chỉnh sửa nhẹ) ---
    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã Môn", "Tên Môn", "Kỳ Học", "Số Tín Chỉ"});
        tblMonHoc.setModel(model);
    }

    private void loadData() {
        model.setRowCount(0);
        List<MonHoc> list = mhBUS.getAll();
        if (list != null) {
            for (MonHoc mh : list) {
                model.addRow(new Object[]{mh.getMaMon(), mh.getTenMon(), mh.getKyHoc(), mh.getSoTinChi()});
            }
        }
    }

    private void setModel(int row) {
        txtMaMH.setText(model.getValueAt(row, 0).toString());
        txtTenMH.setText(model.getValueAt(row, 1).toString());
        txtKyHoc.setText(model.getValueAt(row, 2).toString());
        txtSoTinChi.setText(model.getValueAt(row, 3).toString());
        txtMaMH.setEditable(false);
    }

    private void clearForm() {
        txtMaMH.setText("");
        txtTenMH.setText("");
        txtKyHoc.setText("");
        txtSoTinChi.setText("");
        txtMaMH.setEditable(true);
        loadData();
    }

    private void btnThemActionPerformed() {
        try {
            MonHoc mh = new MonHoc();
            mh.setMaMon(txtMaMH.getText());
            mh.setTenMon(txtTenMH.getText());
            mh.setKyHoc(txtKyHoc.getText());
            mh.setSoTinChi(Integer.parseInt(txtSoTinChi.getText()));
            JOptionPane.showMessageDialog(this, mhBUS.addMonHoc(mh));
            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
        }
    }

    private void btnSuaActionPerformed() {
        try {
            MonHoc mh = new MonHoc();
            mh.setMaMon(txtMaMH.getText());
            mh.setTenMon(txtTenMH.getText());
            mh.setKyHoc(txtKyHoc.getText());
            mh.setSoTinChi(Integer.parseInt(txtSoTinChi.getText()));
            JOptionPane.showMessageDialog(this, mhBUS.updateMonHoc(mh));
            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi cập nhật!");
        }
    }

    private void btnXoaActionPerformed() {
        String ma = txtMaMH.getText();
        if (!ma.isEmpty()) {
            int resp = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, mhBUS.deleteMonHoc(ma));
                loadData();
                clearForm();
            }
        }
    }
    // XÓA BỎ HOÀN TOÀN CÁC ĐOẠN initComponents() CŨ VÀ CÁC BIẾN KHAI BÁO LẠI Ở ĐÂY
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
