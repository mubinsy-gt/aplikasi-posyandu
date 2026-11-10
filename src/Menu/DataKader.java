package Menu;

import java.sql.*;
import Connect.Connect;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class DataKader extends javax.swing.JFrame {
    private DefaultTableModel data;
    Connection conn;
    private Object nama;

    public DataKader() {
        initComponents();
        conn = Connect.getConnection();
        tabel();
        reset();
        kosong();
        autonumberKader();
    }
private void autonumberKader() {
    try {
        String sql = "SELECT kode_kader FROM tb_kader ORDER BY kode_kader DESC LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String lastKode = rs.getString("kode_kader"); // Contoh: KD005
            String nomor = lastKode.substring(2);         // Ambil "005"
            int angka = Integer.parseInt(nomor) + 1;       // Tambah 1 jadi 6
            String kodeBaru = String.format("KD%03d", angka); // Jadi "KD006"
            kdkader.setText(kodeBaru); // Set ke textfield
        } else {
            kdkader.setText("KD001");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal generate kode kader otomatis: " + e.getMessage());
    }
}


private void kosong() {
    nmkader.setText("");
    notelp.setText("");
    kdkader.setText("");
    tgl.setDate(null);
    kelamin.setSelectedIndex(0);
    jabatan.setSelectedIndex(0);
    alamat.setText(""); // ✅ ini bagian yang kurang

    btnSimpan.setEnabled(true);
    btnUbah.setEnabled(false);
    btnHapus.setEnabled(false);
}

    private void tabel() {
        Object[] kolom = {"Kode Kader", "Nama Kader", "Tanggal", "Jenis Kelamin", "Telepon", "Alamat", "Jabatan"};
        data = new DefaultTableModel(null, kolom);
        try {
            String sql = "SELECT * FROM tb_kader ORDER BY kode_kader ASC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] row = {
                    rs.getString("kode_kader"),
                    rs.getString("nama_kader"),
                    rs.getString("tanggal_bergabung"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("no_telepon"),
                    rs.getString("alamat"),
                    rs.getString("jabatan")
                };
                data.addRow(row);
            }
            tabel.setModel(data);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_refresh = new javax.swing.JButton();
        Keluar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label6 = new java.awt.Label();
        nmkader = new java.awt.TextField();
        label3 = new java.awt.Label();
        kelamin = new javax.swing.JComboBox<>();
        notelp = new java.awt.TextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label8 = new java.awt.Label();
        kdkader = new java.awt.TextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jabatan = new javax.swing.JComboBox<>();
        tgl = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        label7 = new java.awt.Label();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Penimbangan");
        setBackground(new java.awt.Color(153, 255, 255));
        setMinimumSize(new java.awt.Dimension(975, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconView_1.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, 30));

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
        getContentPane().add(Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, 30));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        jPanel1.setToolTipText("");
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setBackground(new java.awt.Color(204, 204, 255));
        label1.setText("Kode Kader");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        label2.setBackground(new java.awt.Color(204, 204, 255));
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label2.setText("No. Telepon");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, -1));

        label6.setBackground(new java.awt.Color(204, 204, 255));
        label6.setText("Jabatan");
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, -1));
        jPanel1.add(nmkader, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 148, -1));

        label3.setBackground(new java.awt.Color(204, 204, 255));
        label3.setText("Alamat");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 80, -1));

        kelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        jPanel1.add(kelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 120, -1));
        jPanel1.add(notelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 148, -1));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconSave.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 100, -1));

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconEdit_1.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 100, -1));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconFile_1.png"))); // NOI18N
        btnReset.setText("Batal");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 100, -1));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconDelete_1.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 100, -1));

        label4.setBackground(new java.awt.Color(204, 204, 255));
        label4.setText("Nama Kader");
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        label5.setBackground(new java.awt.Color(204, 204, 255));
        label5.setText("Tanggal Bergabung");
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        label8.setBackground(new java.awt.Color(204, 204, 255));
        label8.setText("Jenis Kelamin");
        jPanel1.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        jPanel1.add(kdkader, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 148, -1));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane3.setViewportView(alamat);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 150, 80));

        jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ketua", "Wakil Ketua", "Sekretaris", "Bendahara", "Anggota", "Posbindu", "BKB", "BKR", "BKL" }));
        jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatanActionPerformed(evt);
            }
        });
        jPanel1.add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 100, -1));
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 330, 430));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        jPanel2.setOpaque(false);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "KODE KADER", "NAMA KADER", "TANGGAL", "JENIS KELAMIN", "TELEPON", "ALAMAT", "JABATAN"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        label7.setBackground(new java.awt.Color(204, 204, 255));
        label7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label7.setText("TABEL DATA KADER");

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cari)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 640, 430));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMinimumSize(new java.awt.Dimension(975, 350));
        jLabel1.setPreferredSize(new java.awt.Dimension(975, 350));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
 int bar = tabel.getSelectedRow();
        if (bar >= 0) {
            kdkader.setText(tabel.getValueAt(bar, 0).toString());
            nmkader.setText(tabel.getValueAt(bar, 1).toString());
            
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                tgl.setDate(format.parse(tabel.getValueAt(bar, 2).toString()));
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error parsing date: " + e.getMessage());
            }
            
            kelamin.setSelectedItem(tabel.getValueAt(bar, 3).toString());
            notelp.setText(tabel.getValueAt(bar, 4).toString());
            alamat.setText(tabel.getValueAt(bar, 5).toString());
            jabatan.setSelectedItem(tabel.getValueAt(bar, 6).toString());
            
             btnSimpan.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked

    }//GEN-LAST:event_KeluarMouseClicked

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        this.dispose();
         new FormUtama().setVisible(true);
    }//GEN-LAST:event_KeluarActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        tabel();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
  try {
          String sql = "INSERT INTO tb_kader (kode_kader, nama_kader, tanggal_bergabung, jenis_kelamin, no_telepon, alamat, jabatan) VALUES (?, ?, ?, ?, ?, ?, ?)";
PreparedStatement pst = conn.prepareStatement(sql);
pst.setString(1, kdkader.getText());
pst.setString(2, nmkader.getText());
pst.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(tgl.getDate()));
pst.setString(4, kelamin.getSelectedItem().toString());
pst.setString(5, notelp.getText());
pst.setString(6, alamat.getText());
pst.setString(7, jabatan.getSelectedItem().toString());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        tabel();           // Refresh isi tabel
        kosong();          // Kosongkan inputan
        autonumberKader(); // Dapatkan kode_kader baru setelah simpan
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan: " + e.getMessage());
        }
    
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
 try {
        String sql = "UPDATE tb_kader SET nama_kader=?, tanggal_bergabung=?, jenis_kelamin=?, no_telepon=?, alamat=?, jabatan=? WHERE kode_kader=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nmkader.getText());
        pst.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(tgl.getDate()));
        pst.setString(3, kelamin.getSelectedItem().toString());
        pst.setString(4, notelp.getText());
        pst.setString(5, alamat.getText());
        pst.setString(6, jabatan.getSelectedItem().toString());
        pst.setString(7, kdkader.getText());
        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        tabel();   // refresh tabel
        kosong();  // kosongkan form
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal mengubah: " + e.getMessage());
        }
   
    
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
kosong();
    
   
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM tb_kader WHERE kode_kader=?";
PreparedStatement pst = conn.prepareStatement(sql);
pst.setString(1, kdkader.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        tabel();
        kosong();
        autonumberKader();
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menghapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
                              
    // Kolom tabel
    Object[] kolom = {"Kode Kader", "Nama Kader", "Tanggal", "Jenis Kelamin", "Telepon", "Alamat", "Jabatan"};
    DefaultTableModel data = new DefaultTableModel(null, kolom);
    tabel.setModel(data);

    // Query pencarian
    try {
        String sql = "SELECT * FROM tb_kader WHERE "
                   + "nama_kader LIKE '%" + cari.getText() + "%' "
                   + "OR jabatan LIKE '%" + cari.getText() + "%' "
                   + "ORDER BY kode_kader ASC";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            String[] row = {
                rs.getString("kode_kader"),
                rs.getString("nama_kader"),
                rs.getString("tanggal_bergabung"),
                rs.getString("jenis_kelamin"),
                rs.getString("no_telepon"),
                rs.getString("alamat"),
                rs.getString("jabatan")
            };
            data.addRow(row);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_cariKeyPressed

    private void jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jabatanActionPerformed

 
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DataKader().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Keluar;
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jabatan;
    private java.awt.TextField kdkader;
    private javax.swing.JComboBox<String> kelamin;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.TextField nmkader;
    private java.awt.TextField notelp;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tgl;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        nmkader.setText("");
    notelp.setText("");
    kdkader.setText("");
    tgl.setDate(null); // Jika pakai JDateChooser
    kelamin.setSelectedIndex(0); // Reset combo box ke item pertama
    jabatan.setSelectedIndex(0); // Sama juga
    // Jika ada JTable dan ingin kosongkan selection:
    // tabelKader.clearSelection();

    // Jika ada pengaturan tombol:
    btnSimpan.setEnabled(true);
    btnUbah.setEnabled(false);
    btnHapus.setEnabled(false);
}

}

