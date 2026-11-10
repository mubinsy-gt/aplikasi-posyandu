package Menu;
import Connect.Connect;
import Menu.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormUtama extends javax.swing.JFrame {
Connection connect = (Connection)Connect.getConnection();
 Connection conn;
    Statement stm;
    ResultSet rs;
    
    public FormUtama() {
        initComponents();
        setLocationRelativeTo(null);
    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnDataAnak = new javax.swing.JButton();
        btnDataIbu = new javax.swing.JButton();
        btnDataKader = new javax.swing.JButton();
        btnDataGizi = new javax.swing.JButton();
        btnimunisasi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jButton10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton10.setText("LAP. DATA BALITA");
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Menu");
        setResizable(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(620, 550));

        jPanel1.setPreferredSize(new java.awt.Dimension(620, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Gabriola", 1, 27)); // NOI18N
        jLabel6.setText("REPORT");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        btnLogout.setText("KELUAR");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel5.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 250, 50));

        jPanel3.setOpaque(false);

        btnDataAnak.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDataAnak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bayi.png"))); // NOI18N
        btnDataAnak.setText("DATA BALITA");
        btnDataAnak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataAnakActionPerformed(evt);
            }
        });

        btnDataIbu.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDataIbu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mom_1.png"))); // NOI18N
        btnDataIbu.setText("DATA IBU HAMIL");
        btnDataIbu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataIbu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataIbuActionPerformed(evt);
            }
        });

        btnDataKader.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDataKader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/penimbangan.png"))); // NOI18N
        btnDataKader.setText("DATA KADER");
        btnDataKader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataKader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKaderActionPerformed(evt);
            }
        });

        btnDataGizi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDataGizi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gizi_1.png"))); // NOI18N
        btnDataGizi.setText("GIZI");
        btnDataGizi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataGizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataGiziActionPerformed(evt);
            }
        });

        btnimunisasi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnimunisasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gizi_1.png"))); // NOI18N
        btnimunisasi.setText("DATA IMUNISASI");
        btnimunisasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnimunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimunisasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDataAnak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataIbu, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(btnDataGizi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDataKader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnimunisasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDataAnak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataIbu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataKader, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDataGizi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnimunisasi)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 170, 290, 360));

        jPanel4.setOpaque(false);

        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton7.setText("LAP. DATA BALITA");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton8.setText("LAP. DATA IBU HAMIL");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton9.setText("LAP. KESEHATAN");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton11.setText("LAP. PEMBERIAN GIZI");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton12.setText("LAP. KADER");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/file2.png"))); // NOI18N
        jButton14.setText("LAP. CATATAN IMUNISASI");
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 460, 320));

        jPanel6.setOpaque(false);

        jButton13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bayi.png"))); // NOI18N
        jButton13.setText("PEMERIKSAAN KESEHATAN");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gizi_1.png"))); // NOI18N
        jButton15.setText("PEMBERIAN GIZI");
        jButton15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gizi_1.png"))); // NOI18N
        jButton16.setText("PENCATATAN IMUNISASI");
        jButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 290, 320));

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 27)); // NOI18N
        jLabel3.setText("MASTER DATA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Gabriola", 1, 27)); // NOI18N
        jLabel8.setText("TRANSAKSI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(620, 550));
        jLabel1.setMinimumSize(new java.awt.Dimension(620, 550));
        jLabel1.setPreferredSize(new java.awt.Dimension(620, 550));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 560));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 27)); // NOI18N
        jLabel7.setText("LAPORAN");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
    String ObjButton[] = {"YES","NO"};
        int pilihan = JOptionPane.showOptionDialog(null,"Apakah Anda yakin ingi keluar?","Message", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null,ObjButton,ObjButton[1]);
        if(pilihan == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
                                   
    try {
        // Pilihan laporan
        String[] options = {"Gizi Balita", "Gizi Ibu"};
        String selectedOption = (String) JOptionPane.showInputDialog(
                this,
                "Pilih jenis laporan yang ingin dicetak:",
                "Cetak Laporan Pemeriksaan",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        // Jika user batal (null), keluar
        if (selectedOption == null) {
            return;
        }

        // Tentukan path report yang dipilih
        String reportPath = "";
        if (selectedOption.equals("Gizi Balita")) {
            reportPath = "src/report/laporan_gizi_balita.jasper";
        } else if (selectedOption.equals("Gizi Ibu")) {
            reportPath = "src/report/laporan_gizi_ibu.jasper";
        }
          Locale.setDefault(new Locale("in", "ID"));

        // Parameter (bisa ditambah jika diperlukan)
        Map<String, Object> param = new HashMap<>();
        param.put("PETUGAS", "Nama Petugas Posyandu");

        // Koneksi database
        Connection conn = Connect.getConnection();

        // Isi report
        JasperPrint print = JasperFillManager.fillReport(reportPath, param, conn);

        // Tampilkan report
        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal membuka laporan: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 try {
      Locale.setDefault(new Locale("in", "ID"));
        // Path ke file .jasper
        String reportPath = "src/report/laporanbalita.jasper";
        
        // Parameter (sesuai param PETUGAS di .jrxml)
        Map<String, Object> param = new HashMap<>();
        param.put("PETUGAS", "Nama Petugas Posyandu");

        // Koneksi database
        Connection conn = Connect.getConnection();

        // Isi report
        JasperPrint print = JasperFillManager.fillReport(reportPath, param, conn);

        // Tampilkan report
        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal membuka laporan: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
 try {
      Locale.setDefault(new Locale("in", "ID"));
    // Path ke file .jasper
    String reportPath = "src/report/laporanibuhamil.jasper";
    
    // Parameter (jika ada parameter PETUGAS di .jrxml, atau bisa kosong)
    Map<String, Object> param = new HashMap<>();
    param.put("PETUGAS", "Nama Petugas Posyandu"); // Bisa diisi sesuai kebutuhan

    // Koneksi database
    Connection conn = Connect.getConnection();

    // Isi report
    JasperPrint print = JasperFillManager.fillReport(reportPath, param, conn);

    // Tampilkan report
    JasperViewer.viewReport(print, false);

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Gagal membuka laporan: " + e.getMessage());
}

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
                                      
    try {
        // Pilihan laporan
        String[] options = {"Pemeriksaan Balita", "Pemeriksaan Ibu"};
        String selectedOption = (String) JOptionPane.showInputDialog(
                this,
                "Pilih jenis laporan yang ingin dicetak:",
                "Cetak Laporan Pemeriksaan",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        // Jika user batal (null), keluar
        if (selectedOption == null) {
            return;
        }

        // Tentukan path report yang dipilih
        String reportPath = "";
        if (selectedOption.equals("Pemeriksaan Balita")) {
            reportPath = "src/report/laporan_pemeriksaan_balita.jasper";
        } else if (selectedOption.equals("Pemeriksaan Ibu")) {
            reportPath = "src/report/laporan_pemeriksaan_ibu.jasper";
        }
         Locale.setDefault(new Locale("in", "ID"));

        // Parameter (bisa ditambah jika diperlukan)
        Map<String, Object> param = new HashMap<>();
        param.put("PETUGAS", "Nama Petugas Posyandu");

        // Koneksi database
        Connection conn = Connect.getConnection();

        // Isi report
        JasperPrint print = JasperFillManager.fillReport(reportPath, param, conn);

        // Tampilkan report
        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal membuka laporan: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
         this.setVisible(false);
        new pemeriksaan().setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.setVisible(false);
        new PemberianGizi().setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void btnDataGiziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataGiziActionPerformed
        this.setVisible(false);
        new gizi().setVisible(true);
    }//GEN-LAST:event_btnDataGiziActionPerformed

    private void btnDataKaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKaderActionPerformed
        this.setVisible(false);
        new DataKader().setVisible(true);
    }//GEN-LAST:event_btnDataKaderActionPerformed

    private void btnDataIbuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataIbuActionPerformed
        this.setVisible(false);
        new ibu().setVisible(true);
    }//GEN-LAST:event_btnDataIbuActionPerformed

    private void btnDataAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataAnakActionPerformed
        this.setVisible(false);
        new FormBalita().setVisible(true);
    }//GEN-LAST:event_btnDataAnakActionPerformed

    private void btnimunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimunisasiActionPerformed
       this.setVisible(false);
        new DataImunsasi().setVisible(true);
    }//GEN-LAST:event_btnimunisasiActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
      this.setVisible(false);
        new PencatatanImunisasi().setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
   try {
      Locale.setDefault(new Locale("in", "ID"));
        // Path ke file .jasper
        String reportPath = "src/report/laporankader.jasper";
        
        // Parameter (sesuai param PETUGAS di .jrxml)
        Map<String, Object> param = new HashMap<>();
        param.put("PETUGAS", "Nama Petugas Posyandu");

        // Koneksi database
        Connection conn = Connect.getConnection();

        // Isi report
        JasperPrint print = JasperFillManager.fillReport(reportPath, param, conn);

        // Tampilkan report
        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal membuka laporan: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       try {
      Locale.setDefault(new Locale("in", "ID"));
        // Path ke file .jasper
        String reportPath = "src/report/laporan_imunisasi.jasper";
        
        // Parameter (sesuai param PETUGAS di .jrxml)
        Map<String, Object> param = new HashMap<>();
        param.put("PETUGAS", "Nama Petugas Posyandu");

        // Koneksi database
        Connection conn = Connect.getConnection();

        // Isi report
        JasperPrint print = JasperFillManager.fillReport(reportPath, param, conn);

        // Tampilkan report
        JasperViewer.viewReport(print, false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal membuka laporan: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataAnak;
    private javax.swing.JButton btnDataGizi;
    private javax.swing.JButton btnDataIbu;
    private javax.swing.JButton btnDataKader;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnimunisasi;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
