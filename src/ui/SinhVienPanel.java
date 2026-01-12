
package ui;
import bus.SinhVienBUS;
import bus.LopBUS;
import dto.Lop;
import dto.SinhVien;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import helper.AutoUpdateHelper;

public class SinhVienPanel extends javax.swing.JPanel {
    private SinhVienBUS svBUS = new SinhVienBUS();
    private LopBUS lopBUS = new LopBUS();
    private DefaultTableModel model;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public SinhVienPanel() {
        initComponents();
        initTable();
        loadDataComboBox();
        loadData();
        AutoUpdateHelper.addAutoRefresh(this, ()-> loadDataComboBox());
    }
    //Cấu hình cột cho bảng
    private void initTable(){
        model = new DefaultTableModel();
        String[] columns = {"Mã SV","Họ SV","Tên SV","Lớp","Giới Tính","Ngày sinh","SDT","Email","Địa chỉ"};
        model.setColumnIdentifiers(columns);
        tblSinhVien.setModel(model);
    }
    //Tải dữ liệu từ BUS lên bảng
    private void loadData(){
        try{
            List<SinhVien> list = svBUS.getAll();
            fillTable(list);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }
    public void loadDataComboBox(){
        try{
            List<Lop> listLop = lopBUS.getAll();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for(Lop lop : listLop){
                model.addElement(lop);
            }
            cboMaLop.setModel(model);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Hàm tìm tên lớp dựa vào mã lớp
    private String getTenLopByMa(String maLop){
        if(maLop==null|| cboMaLop.getItemCount() ==0) return "";
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaLop.getModel();
            for(int i = 0; i< model.getSize();i++){
                Lop lop = (Lop) model.getElementAt(i);
                if (lop.getMaLop().equalsIgnoreCase(maLop)){
                    return lop.getTenLop();
                }
            }
            return maLop;
        }
    //Đổ danh sách vào bảng
    private void fillTable(List<SinhVien> list){
        model.setRowCount(0); //Xóa dữ liệu cũ
        for(SinhVien sv: list){
            model.addRow(new Object[]{
                sv.getMaSV(),
                sv.getHoSV(),
                sv.getTenSV(),
                getTenLopByMa(sv.getMaLop()),
                sv.getGioiTinh() ? "Nam": "Nữ",
                sv.getNgaySinh() != null ? dateFormat.format(sv.getNgaySinh()):"",
                sv.getDienThoai(),
                sv.getEmail(),
                sv.getDiaChi()
            });
        }
    }
    private SinhVien getModel() throws Exception{
        SinhVien sv = new SinhVien();
        sv.setMaSV(txtMaSV.getText().trim());
        sv.setHoSV(txtHoSV.getText().trim());
        sv.setTenSV(txtTenSV.getText().trim());
        if(cboMaLop.getSelectedItem()!= null){
            Lop selectedLop = (Lop) cboMaLop.getSelectedItem();
            sv.setMaLop(selectedLop.getMaLop());
        }
        sv.setGioiTinh(rdoNam.isSelected());
        sv.setDiaChi(txtDiaChi.getText().trim());
        sv.setDienThoai(txtSDT.getText().trim());
        sv.setEmail(txtEmail.getText().trim());


        // Xử lý ngày sinh
        String sDate = txtNgaySinh.getText().trim();
        if (!sDate.isEmpty()) {
            try {
                dateFormat.setLenient(false); // Bắt buộc nhập đúng ngày thực tế
                sv.setNgaySinh(dateFormat.parse(sDate));
            } catch (Exception e) {
                throw new Exception("Ngày sinh sai định dạng! (Ví dụ: dd/MM/yyyy)");
            }
        }
        return sv;
    }
    
    // Hiển thị dữ liệu từ dòng chọn lên Form
    private void setModel(int rowIndex) {
        if (rowIndex < 0) return;
        
        String maSV = tblSinhVien.getValueAt(rowIndex, 0).toString();
        SinhVien sv = svBUS.getById(maSV); // Lấy chi tiết từ DB
        
        if (sv != null) {
            txtMaSV.setText(sv.getMaSV());
            txtHoSV.setText(sv.getHoSV());
            txtTenSV.setText(sv.getTenSV());
            //comboBOx
            String maLopSV = sv.getMaLop();
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaLop.getModel();
            for (int i = 0; i<model.getSize(); i++){
                Lop lop = (Lop) model.getElementAt(i);
                if(lop.getMaLop().equalsIgnoreCase(maLopSV)){
                    cboMaLop.setSelectedIndex(i);
                    break;
                }
            }
            if (sv.getGioiTinh()) rdoNam.setSelected(true);
            else rdoNu.setSelected(true);
            
            txtNgaySinh.setText(sv.getNgaySinh() != null ? dateFormat.format(sv.getNgaySinh()) : "");
            txtSDT.setText(sv.getDienThoai());
            txtEmail.setText(sv.getEmail());
            txtDiaChi.setText(sv.getDiaChi());
            txtMaSV.setEditable(false); // Khóa mã SV khi xem/sửa
        }
    }
    // Làm mới form
    private void clearForm() {
        txtMaSV.setText("");
        txtMaSV.setEditable(true);
        txtHoSV.setText("");
        txtTenSV.setText("");
        if(cboMaLop.getItemCount()>0){
            cboMaLop.setSelectedItem(0);
        }
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        rdoNam.setSelected(true);
        tblSinhVien.clearSelection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnXuatExcel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        txtHoSV = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtNgaySinh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        cboMaLop = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(593, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Quản Lý Sinh Viên");

        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(btnXuatExcel)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnXuatExcel))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 200));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnLamMoi)
                .addGap(103, 103, 103))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã SV");

        jLabel3.setText("Tên SV");

        jLabel4.setText("Họ SV");

        jLabel5.setText("Lớp");

        jLabel6.setText("Giới Tính");

        jLabel7.setText("Ngày Sinh");

        jLabel8.setText("SDT");

        jLabel9.setText("Email");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtNgaySinh.setToolTipText("Nhập định dạng dd/MM/yyyy\n");

        jLabel10.setText("Địa chỉ");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ SV", "Tên SV", "Lớp", "Giới tính", "Ngày sinh", "SDT", "Email", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        cboMaLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoSV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSDT))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiaChi)
                                            .addComponent(txtEmail)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(rdoNam)
                                            .addGap(33, 33, 33)
                                            .addComponent(rdoNu))
                                        .addComponent(cboMaLop, 0, 176, Short.MAX_VALUE)))
                                .addGap(110, 110, 110)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cboMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       try {
            // Lấy dữ liệu
            SinhVien sv = getModel();
            
            // Gọi BUS: Hàm này trả về String thông báo
            String result = svBUS.addSinhVien(sv);
            
            // Hiển thị thông báo từ BUS
            JOptionPane.showMessageDialog(this, result);
            
            // Nếu thành công thì tải lại bảng
            if (result.contains("thành công")) {
                loadData();
                clearForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaSV.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần sửa!");
                return;
            }
            SinhVien sv = getModel();
            
            // Gọi BUS cập nhật
            String result = svBUS.updateSinhVien(sv);
            JOptionPane.showMessageDialog(this, result);
            
            if (result.contains("thành công")) {
                loadData();
                clearForm();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String maSV = txtMaSV.getText();
            if (maSV.isEmpty()) {
                 JOptionPane.showMessageDialog(this, "Chưa nhập Mã SV!");
                 return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa SV " + maSV + "?");
            if (confirm == JOptionPane.YES_OPTION) {
                // Gọi BUS xóa
                String result = svBUS.deleteSinhVien(maSV);
                JOptionPane.showMessageDialog(this, result);
                
                if (result.contains("thành công")) {
                    loadData();
                    clearForm();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clearForm();
        loadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        int row = tblSinhVien.getSelectedRow();
        if (row >= 0) {
            setModel(row);
        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // Lấy tên lớp để làm tên file cho đẹp (nếu đang chọn lớp)
    String tenFile = "DS_SinhVien";
    String tieuDe = "DANH SÁCH SINH VIÊN";

    // Nếu có chọn lớp trong combobox thì thêm tên lớp vào
    if (cboMaLop.getSelectedItem() != null) {
        dto.Lop lop = (dto.Lop) cboMaLop.getSelectedItem();
        tenFile += "_" + lop.getMaLop();
        tieuDe += " - LỚP: " + lop.getTenLop().toUpperCase();
    }

    // GỌI 1 DÒNG LÀ XONG:
    helper.ExcelHelper.export(tblSinhVien, tenFile, tieuDe);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void cboMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaLopActionPerformed
       try {
        // Lấy đối tượng lớp đang chọn
        if (cboMaLop.getSelectedItem() != null) {
            Lop selectedLop = (Lop) cboMaLop.getSelectedItem();
            String maLop = selectedLop.getMaLop();
            
            // Gọi BUS lấy danh sách theo lớp
            List<SinhVien> list = svBUS.getSinhVienByLop(maLop);
            
            // Đổ lại vào bảng
            fillTable(list);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }//GEN-LAST:event_cboMaLopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboMaLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoSV;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
