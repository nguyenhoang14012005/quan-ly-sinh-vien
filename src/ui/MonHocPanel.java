package ui;

import bus.MonHocBUS;
import dto.MonHoc;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MonHocPanel extends javax.swing.JPanel {

    private MonHocBUS mhBUS = new MonHocBUS();
    private DefaultTableModel model;
    private JTextField txtMaMH, txtTenMH, txtKyHoc, txtSoTinChi;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi;
    private JTable tblMonHoc;

    public MonHocPanel() {
        // Thay vì gọi initComponents(), ta gọi hàm do mình tự viết
        myInitComponents(); 
        initTable();
        loadData();
    }

    private void myInitComponents() {
        setLayout(new BorderLayout());

        // 1. Panel nhập liệu
        JPanel pnlInput = new JPanel(new GridLayout(5, 2, 5, 5));
        pnlInput.add(new JLabel(" Mã Môn Học:")); txtMaMH = new JTextField(); pnlInput.add(txtMaMH);
        pnlInput.add(new JLabel(" Tên Môn Học:")); txtTenMH = new JTextField(); pnlInput.add(txtTenMH);
        pnlInput.add(new JLabel(" Kỳ Học:")); txtKyHoc = new JTextField(); pnlInput.add(txtKyHoc);
        pnlInput.add(new JLabel(" Số Tín Chỉ:")); txtSoTinChi = new JTextField(); pnlInput.add(txtSoTinChi);

        // 2. Panel nút bấm
        JPanel pnlButtons = new JPanel();
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        pnlButtons.add(btnThem); pnlButtons.add(btnSua); pnlButtons.add(btnXoa); pnlButtons.add(btnLamMoi);
        pnlInput.add(new JLabel(" Thao tác:")); pnlInput.add(pnlButtons);

        // 3. Bảng dữ liệu
        tblMonHoc = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblMonHoc);

        add(pnlInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Gán sự kiện
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
            JOptionPane.showMessageDialog(this, mhBUS.deleteMonHoc(ma));
            loadData();
            clearForm();
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
