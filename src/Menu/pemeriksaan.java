/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Connect.Connect;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;  // <-- ini yang kurang
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






/**
 *
 * @author user
 */
public class pemeriksaan extends javax.swing.JFrame {
Connection conn;
    /**
     * Creates new form pemeriksaan
     */
    public pemeriksaan() {
        initComponents();
        conn = Connect.getConnection();
        loadNamaBalita();  // panggil saat form dibuat supaya combo box terisi
        loadNamaIbu();
        loadDataBalita();  // muat data awal saat form dibuka
        loadDataIbu();
        autonumberPemeriksaanIbu();
        autonumberPemeriksaanBalita();
    }
    private String generateIDBalita() {
    String idBaru = "PB001";
    try {
        String sql = "SELECT id FROM pemeriksaan_balita ORDER BY id DESC LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String lastId = rs.getString("id").substring(2); // ambil angka setelah "PB"
            int nextId = Integer.parseInt(lastId) + 1;
            idBaru = String.format("PB%03d", nextId);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal membuat ID Balita: " + e.getMessage());
    }
    return idBaru;
}
    private void simpanPemeriksaanBalita() {
    try {
        String id = generateIDBalita();
        String sql = "INSERT INTO pemeriksaan_balita (id, tanggal, nama_balita, berat_badan, tinggi_badan, suhu_tubuh, keluhan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, id);
        ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(tgl1.getDate()));
        ps.setString(3, nmabalita.getSelectedItem().toString());
        ps.setString(4, berat1.getText());
        ps.setString(5, tinggi1.getText());
        ps.setString(6, suhu1.getText());
        ps.setString(7, keluhan1.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data pemeriksaan balita berhasil disimpan!");
        loadDataBalita(); // refresh tabel
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal simpan balita: " + e.getMessage());
    }
}

private String generateIDIbu() {
    String idBaru = "PI001";
    try {
        String sql = "SELECT id FROM pemeriksaan_ibu ORDER BY id DESC LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String lastId = rs.getString("id").substring(2); // ambil angka setelah "PI"
            int nextId = Integer.parseInt(lastId) + 1;
            idBaru = String.format("PI%03d", nextId);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal membuat ID Ibu: " + e.getMessage());
    }
    return idBaru;
}

private void simpanPemeriksaanIbu() {
    try {
        String id = generateIDIbu();
        String sql = "INSERT INTO pemeriksaan_ibu (id, tanggal, nama_ibu, berat_badan, tekanan_darah, suhu_tubuh, keluhan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, id);
        ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(tgl2.getDate()));
        ps.setString(3, nama2.getSelectedItem().toString());
        ps.setString(4, berat2.getText());
        ps.setString(5, darah2.getText());
        ps.setString(6, suhu2.getText());
        ps.setString(7, keluhan2.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data pemeriksaan ibu berhasil disimpan!");
        loadDataIbu(); // refresh tabel
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal simpan ibu: " + e.getMessage());
    }
}
private void autonumberPemeriksaanBalita() {
    try {
        String sql = "SELECT MAX(id) AS max_id FROM pemeriksaan_balita";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        int nextId = 1; // default jika tabel kosong

        if (rs.next() && rs.getInt("max_id") != 0) {
            nextId = rs.getInt("max_id") + 1;
        }

        String kode = String.format("PB%03d", nextId);
        System.out.println("ID Balita: " + kode);

        // txtIdBalita.setText(kode); // kalau kamu pakai JTextField

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal membuat ID pemeriksaan balita: " + e.getMessage());
    }
}


private void autonumberPemeriksaanIbu() {
    try {
        String sql = "SELECT MAX(id) AS max_id FROM pemeriksaan_ibu";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        int nextId = 1;

        if (rs.next() && rs.getInt("max_id") != 0) {
            nextId = rs.getInt("max_id") + 1;
        }

        String kode = String.format("PI%03d", nextId);
        System.out.println("ID Ibu: " + kode);

        // txtIdIbu.setText(kode); // kalau kamu pakai field tampil

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal membuat ID pemeriksaan ibu: " + e.getMessage());
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tgl1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nmabalita = new javax.swing.JComboBox<>();
        berat1 = new javax.swing.JTextField();
        tinggi1 = new javax.swing.JTextField();
        suhu1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        keluhan1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        tgl2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nama2 = new javax.swing.JComboBox<>();
        berat2 = new javax.swing.JTextField();
        darah2 = new javax.swing.JTextField();
        suhu2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        keluhan2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnedit = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        Keluar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Tanggal");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Nama Balita");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Pemeriksaan Balita");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Berat Badan");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Tinggi Badan ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Suhu Tubuh ");

        berat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                berat1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("Keluhan");

        keluhan1.setColumns(20);
        keluhan1.setRows(5);
        jScrollPane5.setViewportView(keluhan1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nmabalita, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(berat1)
                            .addComponent(tinggi1)
                            .addComponent(suhu1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nmabalita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(berat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tinggi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(suhu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 430, 340));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Tanggal");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Nama Ibu");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Pemeriksaan ibu hamil");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Berat Badan");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Tekanan Darah");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Suhu Tubuh ");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Keluhan");

        keluhan2.setColumns(20);
        keluhan2.setRows(5);
        jScrollPane4.setViewportView(keluhan2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(berat2)
                            .addComponent(darah2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nama2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tgl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(40, 40, 40))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(suhu2)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(berat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(darah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(suhu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 410, 340));

        jPanel3.setOpaque(false);

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconEdit_1.png"))); // NOI18N
        btnedit.setText("Edit ");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconSave.png"))); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconFile_1.png"))); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconDelete_1.png"))); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(720, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbatal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        tabel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tanggal", "Nama Ibu", "Berat Badan", "Tekanan Darah ", "Suhu Tubuh", "Keluhan"
            }
        ));
        tabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 590, 140));

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tanggal", "Nama Balita", "Berat Badan", "Tinggi Badan", "Suhu Tubuh", "Keluhan"
            }
        ));
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 530, 140));

        Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit_2.png"))); // NOI18N
        Keluar.setText("Keluar");
        Keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarMouseClicked(evt);
            }
        });
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });
        getContentPane().add(Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 11, 100, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("Tabel Pemeriksaan Ibu Hamil");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("Tabel Pemeriksaan Balita");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 250, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg2.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 1230, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
       Connection conn = null;
    PreparedStatement pst = null;

    try {
        conn = Connect.getConnection();

        // ============================
        // === Cek dulu tabel balita ===
        // ============================
        int rowBalita = tabel1.getSelectedRow();
        if (rowBalita != -1) {
            // Ambil data dari form balita
            String id = tabel1.getValueAt(rowBalita, 0).toString();

            String tanggal;
            if (tgl1.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                tanggal = sdf.format(tgl1.getDate());
            } else {
                JOptionPane.showMessageDialog(null, "Tanggal balita belum dipilih!");
                return;
            }

            String namaBalita = nmabalita.getSelectedItem().toString();
            String beratBalita = berat1.getText();
            String tinggiBalita = tinggi1.getText();
            String suhuBalita = suhu1.getText();
            String keluhanBalita = keluhan1.getText();

            String sql = "UPDATE pemeriksaan_balita SET tanggal=?, nama_balita=?, berat_badan=?, tinggi_badan=?, suhu_tubuh=?, keluhan=? WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, tanggal);
            pst.setString(2, namaBalita);
            pst.setString(3, beratBalita);
            pst.setString(4, tinggiBalita);
            pst.setString(5, suhuBalita);
            pst.setString(6, keluhanBalita);
            pst.setString(7, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data balita berhasil diedit!");
            loadDataBalita(); // <<< ini yang menampilkan ulang data baru
            return; // keluar agar tidak lanjut ke tabel ibu

        }

        // ================================
        // === Cek tabel ibu jika balita tidak dipilih ===
        // ================================
        int rowIbu = tabel2.getSelectedRow();
        if (rowIbu != -1) {
            // Ambil data dari form ibu hamil
            String id = tabel2.getValueAt(rowIbu, 0).toString();

            String tanggalIbu;
            if (tgl2.getDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                tanggalIbu = sdf.format(tgl2.getDate());
            } else {
                JOptionPane.showMessageDialog(null, "Tanggal ibu hamil belum dipilih!");
                return;
            }

            String namaIbu = nama2.getSelectedItem().toString();
            String beratIbu = berat2.getText();
            String tekananIbu = darah2.getText();
            String suhuIbu = suhu2.getText();
            String keluhanIbu = keluhan2.getText();

            String sql = "UPDATE pemeriksaan_ibu SET tanggal=?, nama_ibu=?, berat_badan=?, tekanan_darah=?, suhu_tubuh=?, keluhan=? WHERE id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, tanggalIbu);
            pst.setString(2, namaIbu);
            pst.setString(3, beratIbu);
            pst.setString(4, tekananIbu);
            pst.setString(5, suhuIbu);
            pst.setString(6, keluhanIbu);
            pst.setString(7, id);

           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data ibu hamil berhasil diedit!");
            loadDataIbu();  // ✅ ini sekarang dijalankan
            return;
 
        }

        // ===========================
        // === Jika tidak ada baris dipilih ===
        // ===========================
        JOptionPane.showMessageDialog(null, "Pilih data balita atau ibu hamil yang ingin diedit terlebih dahulu!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal mengedit data: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {}
    }
    
    }//GEN-LAST:event_btneditActionPerformed
private void loadDataBalita() {
    DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
    model.setRowCount(0);  // kosongkan tabel

    try (Connection conn = Connect.getConnection();
         PreparedStatement pst = conn.prepareStatement("SELECT * FROM pemeriksaan_balita");
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getDate("tanggal"),
                rs.getString("nama_balita"),
                rs.getString("berat_badan"),
                rs.getString("tinggi_badan"),
                rs.getString("suhu_tubuh"),
                rs.getString("keluhan")
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal load data balita: " + e.getMessage());
    }
}

private void loadDataIbu() {
    DefaultTableModel model = (DefaultTableModel) tabel2.getModel();
    model.setRowCount(0);

    try (Connection conn = Connect.getConnection();
         PreparedStatement pst = conn.prepareStatement("SELECT * FROM pemeriksaan_ibu");
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getDate("tanggal"),
                rs.getString("nama_ibu"),
                rs.getString("berat_badan"),
                rs.getString("tekanan_darah"),
                rs.getString("suhu_tubuh"),
                rs.getString("keluhan")
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal load data ibu: " + e.getMessage());
    }
}

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // === Reset Form Balita ===
    tgl1.setDate(null);
    nmabalita.setSelectedIndex(0); // asumsikan index 0 adalah default
    berat1.setText("");
    tinggi1.setText("");
    suhu1.setText("");
    keluhan1.setText("");

    // === Reset Form Ibu Hamil ===
    tgl2.setDate(null);
    nama2.setSelectedIndex(0); // asumsikan index 0 adalah default
    berat2.setText("");
    darah2.setText("");
    suhu2.setText("");
    keluhan2.setText("");

    // === Kosongkan seleksi tabel jika ada ===
    tabel1.clearSelection();
    tabel2.clearSelection();
    autonumberPemeriksaanBalita();
    autonumberPemeriksaanIbu();

    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
       Connection conn = null;
    PreparedStatement pst = null;

    try {
        conn = Connect.getConnection();

        // ==========================
        // === Hapus dari tabel balita ===
        // ==========================
        int rowBalita = tabel1.getSelectedRow();
        if (rowBalita != -1) {
            String id = tabel1.getValueAt(rowBalita, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data balita ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM pemeriksaan_balita WHERE id=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data balita berhasil dihapus!");
                loadDataBalita();  // refresh tabel
                return;
            }
        }

        // ==========================
        // === Hapus dari tabel ibu ===
        // ==========================
        int rowIbu = tabel2.getSelectedRow();
        if (rowIbu != -1) {
            String id = tabel2.getValueAt(rowIbu, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ibu hamil ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM pemeriksaan_ibu WHERE id=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data ibu hamil berhasil dihapus!");
                loadDataIbu();
                    autonumberPemeriksaanBalita();
                    autonumberPemeriksaanIbu();
                return;
            }
        }

        // Jika tidak ada baris dipilih
        JOptionPane.showMessageDialog(null, "Pilih data balita atau ibu hamil yang ingin dihapus!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {}
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked

    }//GEN-LAST:event_KeluarMouseClicked

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        this.setVisible(false);
        new FormUtama().setVisible(true);
    }//GEN-LAST:event_KeluarActionPerformed

    private void berat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_berat1ActionPerformed

    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        int row = tabel1.getSelectedRow();
if (row != -1) {
    String tanggal = tabel1.getValueAt(row, 1).toString();
    String nama = tabel1.getValueAt(row, 2).toString();
    String berat = tabel1.getValueAt(row, 3).toString();
    String tinggi = tabel1.getValueAt(row, 4).toString();
    String suhu = tabel1.getValueAt(row, 5).toString();
    String keluhan = tabel1.getValueAt(row, 6).toString();

    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(tanggal);
        tgl1.setDate(date);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    nmabalita.setSelectedItem(nama);
    berat1.setText(berat);
    tinggi1.setText(tinggi);
    suhu1.setText(suhu);
    keluhan1.setText(keluhan);
}

    }//GEN-LAST:event_tabel1MouseClicked

    private void tabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseClicked
        int row = tabel2.getSelectedRow();
if (row != -1) {
    String tanggal = tabel2.getValueAt(row, 1).toString();
    String nama = tabel2.getValueAt(row, 2).toString();
    String berat = tabel2.getValueAt(row, 3).toString();
    String tekanan = tabel2.getValueAt(row, 4).toString();
    String suhu = tabel2.getValueAt(row, 5).toString();
    String keluhan = tabel2.getValueAt(row, 6).toString();

    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(tanggal);
        tgl2.setDate(date);
    } catch (Exception e) {
        e.printStackTrace();
    }

    nama2.setSelectedItem(nama);
    berat2.setText(berat);
    darah2.setText(tekanan);
    suhu2.setText(suhu);
    keluhan2.setText(keluhan);
}

    }//GEN-LAST:event_tabel2MouseClicked

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Connect.getConnection();

            if (tgl1.getDate() != null) {
                Date date1 = tgl1.getDate();
                if (date1 == null) {
                    JOptionPane.showMessageDialog(this, "Tanggal balita belum dipilih!");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tanggalBalita = sdf.format(date1);

                String namaBalita = nmabalita.getSelectedItem().toString();
                String beratBalita = berat1.getText();
                String tinggiBalita = tinggi1.getText();
                String suhuBalita = suhu1.getText();
                String keluhanBalita = keluhan1.getText();

                String sql = "INSERT INTO pemeriksaan_balita (tanggal, nama_balita, berat_badan, tinggi_badan, suhu_tubuh, keluhan) VALUES (?, ?, ?, ?, ?, ?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, tanggalBalita);
                pst.setString(2, namaBalita);
                pst.setString(3, beratBalita);
                pst.setString(4, tinggiBalita);
                pst.setString(5, suhuBalita);
                pst.setString(6, keluhanBalita);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data balita berhasil disimpan!");
                loadDataBalita();

            } else if (tgl2.getDate() != null) {  // Input ibu hamil
                Date date2 = tgl2.getDate();
                if (date2 == null) {
                    JOptionPane.showMessageDialog(this, "Tanggal ibu hamil belum dipilih!");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tanggalIbu = sdf.format(date2);

                String namaIbu = nama2.getSelectedItem().toString();
                String beratIbu = berat2.getText();
                String darahIbu = darah2.getText();
                String suhuIbu = suhu2.getText();
                String keluhanIbu = keluhan2.getText();

                String sql = "INSERT INTO pemeriksaan_ibu (tanggal, nama_ibu, berat_badan, tekanan_darah, suhu_tubuh, keluhan) VALUES (?, ?, ?, ?, ?, ?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, tanggalIbu);
                pst.setString(2, namaIbu);
                pst.setString(3, beratIbu);
                pst.setString(4, darahIbu);
                pst.setString(5, suhuIbu);
                pst.setString(6, keluhanIbu);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data ibu hamil berhasil disimpan!");
                loadDataIbu();
                    autonumberPemeriksaanBalita();
                     autonumberPemeriksaanIbu();
            }
            else {
                // kalau tidak ada tanggal balita maupun ibu yang diisi
                JOptionPane.showMessageDialog(this, "Harap isi data balita atau ibu terlebih dahulu!");
                return;  // keluar dari method supaya tidak lanjut ke simpanan
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
            }
        }
        }
        private void loadNamaBalita() {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            try {
                conn = Connect.getConnection();
                String sql = "SELECT nama_balita FROM tb_balita";  // Dari FormBalita.java
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                nmabalita.removeAllItems();
                while (rs.next()) {
                    nmabalita.addItem(rs.getString("nama_balita"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal load nama balita: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pst != null) pst.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {}
            }
        }

        private void loadNamaIbu() {
            Connection conn = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            try {
                conn = Connect.getConnection();
                String sql = "SELECT nama_ibu FROM tb_ibu";  // Dari Ibu.java
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                nama2.removeAllItems();
                while (rs.next()) {
                    nama2.addItem(rs.getString("nama_ibu"));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal load nama ibu: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pst != null) pst.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {}
            }

    }//GEN-LAST:event_btnsimpanActionPerformed

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
            java.util.logging.Logger.getLogger(pemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pemeriksaan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Keluar;
    private javax.swing.JTextField berat1;
    private javax.swing.JTextField berat2;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JTextField darah2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea keluhan1;
    private javax.swing.JTextArea keluhan2;
    private javax.swing.JComboBox<String> nama2;
    private javax.swing.JComboBox<String> nmabalita;
    private javax.swing.JTextField suhu1;
    private javax.swing.JTextField suhu2;
    private javax.swing.JTable tabel1;
    private javax.swing.JTable tabel2;
    private com.toedter.calendar.JDateChooser tgl1;
    private com.toedter.calendar.JDateChooser tgl2;
    private javax.swing.JTextField tinggi1;
    // End of variables declaration//GEN-END:variables
}
