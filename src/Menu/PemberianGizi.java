/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser; // kalau pakai JDateChooser
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class PemberianGizi extends javax.swing.JFrame {

    /**
     * Creates new form PemberianGizi
     */
public PemberianGizi() {
    setContentPane(new BackgroundPanel()); // Tambahkan baris ini DI ATAS initComponents()
    initComponents();
    loadKodePemeriksaanBalita();
    loadKodePemeriksaanIbu();
     loadDataPetugas();
     load_table();
     

tabel.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        int selectedRow = tabel.getSelectedRow();
        if (selectedRow != -1) {
            // Ambil data dari tabel
            String kodePemeriksaan = tabel.getValueAt(selectedRow, 0).toString();
            String namaBalita = tabel.getValueAt(selectedRow, 1).toString();
            String jenisGizi = tabel.getValueAt(selectedRow, 2).toString();
            java.util.Date tanggal = (java.util.Date) tabel.getValueAt(selectedRow, 3);
            String petugasNama = tabel.getValueAt(selectedRow, 4).toString();
            String keterangan = tabel.getValueAt(selectedRow, 5).toString();
            String hargaVal = tabel.getValueAt(selectedRow, 6).toString();
            String qtyVal = tabel.getValueAt(selectedRow, 7).toString();
            String totalVal = tabel.getValueAt(selectedRow, 8).toString();
            String bayarVal = tabel.getValueAt(selectedRow, 9).toString();
            String kembaliVal = tabel.getValueAt(selectedRow, 10).toString();

            // Set ke form input
            kdpemeriksaan.setSelectedItem(kodePemeriksaan);
            nmabalita.setText(namaBalita);
            jnsgizi.setSelectedItem(jenisGizi);
            tgl.setDate(tanggal);
            petugas.setSelectedItem(petugasNama);
            ket.setText(keterangan);
            harga.setText(hargaVal);
            qty.setText(qtyVal);
            total.setText(totalVal);
            bayar.setText(bayarVal);
            kmbalian.setText(kembaliVal);
        }
    }
});


tabel1.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        int selectedRow = tabel1.getSelectedRow();
        if (selectedRow != -1) {
            // Ambil data dari tabel
            String kodePemeriksaan = tabel1.getValueAt(selectedRow, 0).toString();
            String namaIbu = tabel1.getValueAt(selectedRow, 1).toString();
            String trimesterVal = tabel1.getValueAt(selectedRow, 2).toString();
            String jenisGizi = tabel1.getValueAt(selectedRow, 3).toString();
            java.util.Date tanggal = (java.util.Date) tabel1.getValueAt(selectedRow, 4);
            String petugasNama = tabel1.getValueAt(selectedRow, 5).toString();
            String keterangan = tabel1.getValueAt(selectedRow, 6).toString();
            String hargaVal = tabel1.getValueAt(selectedRow, 7).toString();
            String qtyVal = tabel1.getValueAt(selectedRow, 8).toString();
            String totalVal = tabel1.getValueAt(selectedRow, 9).toString();
            String bayarVal = tabel1.getValueAt(selectedRow, 10).toString();
            String kembaliVal = tabel1.getValueAt(selectedRow, 11).toString();

            // Set ke form input
            kdpemeriksaan1.setSelectedItem(kodePemeriksaan);
            nmaibu.setText(namaIbu);
            trimster.setText(trimesterVal);
            jnsgizi.setSelectedItem(jenisGizi);
            tgl1.setDate(tanggal);
            petugas1.setSelectedItem(petugasNama);
            ket1.setText(keterangan);
            harga.setText(hargaVal);
            qty.setText(qtyVal);
            total.setText(totalVal);
            bayar.setText(bayarVal);
            kmbalian.setText(kembaliVal);
        }
    }
});

    kdpemeriksaan.addActionListener((java.awt.event.ActionEvent e) -> {
        Object selected = kdpemeriksaan.getSelectedItem();
        if (selected != null) {
            String id = selected.toString();
            if (!id.isEmpty()) {
                tampilkanDataPemeriksaan(id, "balita");
            }
        }
    });

    kdpemeriksaan1.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Object selected = kdpemeriksaan1.getSelectedItem();
            if (selected != null) {
                String id = selected.toString();
                if (!id.isEmpty()) {
                    tampilkanDataPemeriksaan(id, "ibu");
                }
            }
        }
    });
// Fungsi search saat mengetik
cari.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
        searchBalita(); // Untuk tabel balita
        searchIbu();    // Untuk tabel ibu
    }
});

jnsgizi.addItemListener(e -> {
    if (e.getStateChange() == ItemEvent.SELECTED) {
        updateHarga();
        hitungTotal();
    }
});

qty.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
        hitungTotal();
    }
});

bayar.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
        hitungKembalian();
    }
});

}
private void updateHarga() {
    String jenis = jnsgizi.getSelectedItem().toString();
    switch (jenis) {
        case "Susu Formula":
            harga.setText("15000");
            break;
        case "Gizi Tambahan 50gr":
            harga.setText("5000");
            break;
        case "Gizi Tambahan 100gr":
            harga.setText("10000");
            break;
        case "Vitamin A":
            harga.setText("2000");
            break;
        case "Makanan Pendamping ASI (MP-ASI)":
            harga.setText("10000");
            break;
        case "Bubur Vitamin":
            harga.setText("7000");
            break;
        case "Susu Bubuk Anak":
            harga.setText("12000");
            break;
        case "Tablet Fe (Zat Besi)":
            harga.setText("5000");
            break;
        case "Tablet Kalsium":
            harga.setText("10000");
            break;
        case "Tablet Vitamin A":
            harga.setText("2000");
            break;
        case "Susu Ibu Hamil":
            harga.setText("15000");
            break;
        case "Makanan Tambahan (MPASI Ibu)":
            harga.setText("10000");
            break;
        case "Buah Segar / Jus Vitamin":
            harga.setText("5000");
            break;
        default:
            harga.setText("0");
    }
}

private void hitungTotal() {
    try {
        int h = Integer.parseInt(harga.getText());
        int q = Integer.parseInt(qty.getText());
        int t = h * q;
        total.setText(String.valueOf(t));
        hitungKembalian(); // otomatis update kembalian juga
    } catch (NumberFormatException e) {
        total.setText("0");
    }
}

private void hitungKembalian() {
    try {
        int t = Integer.parseInt(total.getText());
        int b = Integer.parseInt(bayar.getText());
        int k = b - t;
        kmbalian.setText(String.valueOf(k));
    } catch (NumberFormatException e) {
        kmbalian.setText("0");
    }
}

private void searchBalita() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Kode Pemeriksaan");
    model.addColumn("Nama Balita");
    model.addColumn("Jenis Gizi");
    model.addColumn("Tanggal");
    model.addColumn("Petugas");
    model.addColumn("Keterangan");
    model.addColumn("bayar");

    String keyword = cari.getText().trim();

    try {
        String sql = "SELECT * FROM gizi_balita WHERE nama_balita LIKE ?";
        Connection conn = Connect.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("kode_pemeriksaan"),
                rs.getString("nama_balita"),
                rs.getString("jenis_gizi"),
                rs.getDate("tanggal_pemberian"),
                rs.getString("petugas"),
                rs.getString("keterangan"),
                rs.getString("bayar")
            });
        }

        tabel.setModel(model);
        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        System.err.println("Error searchBalita: " + e.getMessage());
    }
}

private void searchIbu() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Kode Pemeriksaan");
    model.addColumn("Nama Ibu");
    model.addColumn("Trimester");
    model.addColumn("Jenis Gizi");
    model.addColumn("Tanggal");
    model.addColumn("Petugas");
    model.addColumn("Keterangan");
    model.addColumn("bayar");

    String keyword = cari.getText().trim();

    try {
        String sql = "SELECT * FROM gizi_ibu WHERE nama_ibu LIKE ?";
        Connection conn = Connect.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + keyword + "%");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("kode_pemeriksaan"),
                rs.getString("nama_ibu"),
                rs.getString("trimester"),
                rs.getString("jenis_gizi"),
                rs.getDate("tanggal_pemberian"),
                rs.getString("petugas"),
                rs.getString("keterangan"),
                rs.getString("bayar")
            });
        }

        tabel1.setModel(model);
        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        System.err.println("Error searchIbu: " + e.getMessage());
    }
}


    
    
private void kosong() {
    // Gizi Balita
    kdpemeriksaan.setSelectedIndex(-1);
    nmabalita.setText("");
    tgl.setDate(null);
    petugas.setSelectedIndex(-1);
    ket.setText("");
    harga.setText("");
    qty.setText("");
    total.setText("");
    bayar.setText("");
    kmbalian.setText("");

    // Gizi Ibu
    kdpemeriksaan1.setSelectedIndex(-1);
    nmaibu.setText("");
    trimster.setText("");
    tgl1.setDate(null);
    petugas1.setSelectedIndex(-1);
    ket1.setText("");
    harga.setText("");
    qty.setText("");
    total.setText("");
    bayar.setText("");
    kmbalian.setText("");

    // Optional: kosongkan cari juga
    cari.setText("");
}


private void load_table() {
    DefaultTableModel modelBalita = new DefaultTableModel();
modelBalita.addColumn("Kode Pemeriksaan");
modelBalita.addColumn("Nama Balita");
modelBalita.addColumn("Jenis Gizi");
modelBalita.addColumn("Tanggal");
modelBalita.addColumn("Petugas");
modelBalita.addColumn("Keterangan");
modelBalita.addColumn("Harga");
modelBalita.addColumn("Qty");
modelBalita.addColumn("Total");
modelBalita.addColumn("Bayar");
modelBalita.addColumn("Kembalian");

try {
    String sql = "SELECT * FROM gizi_balita";
    Connection conn = Connect.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while (rs.next()) {
        modelBalita.addRow(new Object[]{
            rs.getString("kode_pemeriksaan"),
            rs.getString("nama_balita"),
            rs.getString("jenis_gizi"),
            rs.getDate("tanggal_pemberian"),
            rs.getString("petugas"),
            rs.getString("keterangan"),
            rs.getInt("harga"),
            rs.getInt("qty"),
            rs.getInt("total"),
            rs.getInt("bayar"),
            rs.getInt("kembalian")
        });
    }
    tabel.setModel(modelBalita);
} catch (SQLException e) {
    System.err.println("Error load_table balita: " + e);
}

DefaultTableModel modelIbu = new DefaultTableModel();
modelIbu.addColumn("Kode Pemeriksaan");
modelIbu.addColumn("Nama Ibu");
modelIbu.addColumn("Trimester");
modelIbu.addColumn("Jenis Gizi");
modelIbu.addColumn("Tanggal");
modelIbu.addColumn("Petugas");
modelIbu.addColumn("Keterangan");
modelIbu.addColumn("Harga");
modelIbu.addColumn("Qty");
modelIbu.addColumn("Total");
modelIbu.addColumn("Bayar");
modelIbu.addColumn("Kembalian");

try {
    String sql = "SELECT * FROM gizi_ibu";
    Connection conn = Connect.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while (rs.next()) {
        modelIbu.addRow(new Object[]{
            rs.getString("kode_pemeriksaan"),
            rs.getString("nama_ibu"),
            rs.getString("trimester"),
            rs.getString("jenis_gizi"),
            rs.getDate("tanggal_pemberian"),
            rs.getString("petugas"),
            rs.getString("keterangan"),
            rs.getInt("harga"),
            rs.getInt("qty"),
            rs.getInt("total"),
            rs.getInt("bayar"),
            rs.getInt("kembalian")
        });
    }
    tabel1.setModel(modelIbu);
} catch (SQLException e) {
    System.err.println("Error load_table ibu: " + e);
}
}
private void loadKodePemeriksaanBalita() {
    try {
        String sql = "SELECT id FROM pemeriksaan_balita";  // ganti kode_pemeriksaan jadi id
        Connection conn = Connect.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        kdpemeriksaan.removeAllItems(); // clear sebelumnya
        while (rs.next()) {
            kdpemeriksaan.addItem(rs.getString("id"));  // ambil dari kolom id
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal load kode pemeriksaan balita\n" + e.getMessage());
    }
}


private void loadKodePemeriksaanIbu() {
    try {
        String sql = "SELECT id FROM pemeriksaan_ibu";  // ganti kode_pemeriksaan jadi id
        Connection conn = Connect.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        kdpemeriksaan1.removeAllItems(); // clear sebelumnya
        while (rs.next()) {
            kdpemeriksaan1.addItem(rs.getString("id"));  // ambil dari kolom id
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal load kode pemeriksaan ibu\n" + e.getMessage());
    }
}

private void loadDataPetugas() {
    try {
        Connection conn = Connect.getConnection();
        String sql = "SELECT nama_kader FROM tb_kader ORDER BY nama_kader ASC";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        petugas.removeAllItems();
        petugas1.removeAllItems();

        while (rs.next()) {
            String namaKader = rs.getString("nama_kader");
            petugas.addItem(namaKader);
            petugas1.addItem(namaKader);
        }

        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal load data petugas: " + e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kdpemeriksaan = new javax.swing.JComboBox<>();
        tgl = new com.toedter.calendar.JDateChooser();
        petugas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ket = new javax.swing.JTextArea();
        nmabalita = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ket1 = new javax.swing.JTextArea();
        kdpemeriksaan1 = new javax.swing.JComboBox<>();
        trimster = new javax.swing.JTextField();
        tgl1 = new com.toedter.calendar.JDateChooser();
        petugas1 = new javax.swing.JComboBox<>();
        nmaibu = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Keluar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jnsgizi = new javax.swing.JComboBox<>();
        qty = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        bayar = new javax.swing.JTextField();
        kmbalian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("NAMA BALITA");

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("KODE PEMERIKSAAN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("TANGGAL PEMBERIAN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("PETUGAS");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("KETERANGAN TAMBAHAN");

        kdpemeriksaan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kdpemeriksaanItemStateChanged(evt);
            }
        });

        ket.setColumns(20);
        ket.setRows(5);
        jScrollPane1.setViewportView(ket);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kdpemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tgl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(petugas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(nmabalita, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kdpemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nmabalita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("NAMA IBU");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("TRIMESTER");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("KODE PEMERIKSAAN");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("TANGGAL PEMBERIAN");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("PETUGAS");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("KETERANGAN TAMBAHAN");

        ket1.setColumns(20);
        ket1.setRows(5);
        jScrollPane2.setViewportView(ket1);

        kdpemeriksaan1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kdpemeriksaan1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kdpemeriksaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trimster, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(petugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmaibu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(kdpemeriksaan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nmaibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(trimster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(petugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "KODE PEMERIKSAAN", "NAMA IBU", "TRIMESTER", "TANGGAL PEMBERIAN", "PETUGAS", "KET.TAMBAHAN", "JENSI GIZI", "HARGA", "QTY", "TOTAL", "BAYAR", "KEMBALIAN"
            }
        ));
        jScrollPane4.setViewportView(tabel1);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("GIZI IBU");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("TABEL GIZI IBU");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("GIZI BALITA");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("TABEL GIZI BALITA ");

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconView_1.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconSave.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconEdit_1.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconFile_1.png"))); // NOI18N
        btnReset.setText("Batal");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconDelete_1.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("SEARCH");

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

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "KODE PEMERIKSAAN", "NAMA BALITA", "TANGGAL PEMBERIANI", "PETUGAS", "KET.TAMBAHAN", "JENSI GIZI", "HARGA", "QTY", "TOTAL", "BAYAR", "KEMBALIAN"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setOpaque(false);

        jnsgizi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Susu Formula", "Gizi Tambahan 50gr", "Gizi Tambahan 100gr", "Vitamin A", "Makanan Pendamping ASI (MP-ASI)", "Bubur Vitamin", "Susu Bubuk Anak", "Tablet Fe (Zat Besi)", "Tablet Kalsium", "Tablet Vitamin A", "Susu Ibu Hamil", "Makanan Tambahan (MPASI Ibu)", "Buah Segar / Jus Vitamin" }));
        jnsgizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnsgiziActionPerformed(evt);
            }
        });

        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        kmbalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmbalianActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("JENIS GIZI");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("HARGA");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("QTY");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("TOTAL");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setText("BAYAR");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel23.setText("KEMBALIAN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)))
                    .addComponent(jLabel16))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kmbalian, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jnsgizi, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnsgizi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmbalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("PEMBAYARAN GIZI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(Keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel19)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpan)
                        .addComponent(btnUbah)
                        .addComponent(btnReset)
                        .addComponent(btnHapus))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
    load_table();  
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
                                     
    Connection conn = null;
    PreparedStatement pst = null;

    try {
        conn = Connect.getConnection();

        // === SIMPAN DATA GIZI BALITA JIKA DIISI ===
        if (nmabalita.getText() != null && !nmabalita.getText().trim().isEmpty()) {
            Object selectedPemeriksaan = kdpemeriksaan.getSelectedItem();
            Object selectedPetugas = petugas.getSelectedItem();

            if (selectedPemeriksaan == null || selectedPetugas == null || tgl.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Lengkapi data pemeriksaan, petugas, dan tanggal!");
                return;
            }

            int hargaSatuan = Integer.parseInt(harga.getText().trim());
            int jumlah = Integer.parseInt(qty.getText().trim());
            int totalBayar = hargaSatuan * jumlah;
            int uangBayar = Integer.parseInt(bayar.getText().trim());
            int kembalianUang = uangBayar - totalBayar;

            String sqlBalita = "INSERT INTO gizi_balita "
                    + "(kode_pemeriksaan, nama_balita, jenis_gizi, tanggal_pemberian, petugas, keterangan, "
                    + "harga, qty, total, bayar, kembalian) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(sqlBalita);
            pst.setString(1, selectedPemeriksaan.toString());
            pst.setString(2, nmabalita.getText().trim());
            pst.setString(3, jnsgizi.getSelectedItem().toString());
            pst.setDate(4, new java.sql.Date(tgl.getDate().getTime()));
            pst.setString(5, selectedPetugas.toString());
            pst.setString(6, ket.getText() != null ? ket.getText().trim() : "");
            pst.setInt(7, hargaSatuan);
            pst.setInt(8, jumlah);
            pst.setInt(9, totalBayar);
            pst.setInt(10, uangBayar);
            pst.setInt(11, kembalianUang);

            pst.executeUpdate();
            pst.close();
        }

        // === SIMPAN DATA GIZI IBU JIKA DIISI ===
        if (nmaibu.getText() != null && !nmaibu.getText().trim().isEmpty()
                && trimster.getText() != null && !trimster.getText().trim().isEmpty()) {

            Object selectedPemeriksaan1 = kdpemeriksaan1.getSelectedItem();
            Object selectedPetugas1 = petugas1.getSelectedItem();

            if (selectedPemeriksaan1 == null || selectedPetugas1 == null || tgl1.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Lengkapi data pemeriksaan ibu, petugas, dan tanggal!");
                return;
            }

            int hargaIbu = Integer.parseInt(harga.getText().trim());
            int qtyIbu = Integer.parseInt(qty.getText().trim());
            int totalIbu = hargaIbu * qtyIbu;
            int bayarIbu = Integer.parseInt(bayar.getText().trim());
            int kembaliIbu = bayarIbu - totalIbu;

            String sqlIbu = "INSERT INTO gizi_ibu "
                    + "(kode_pemeriksaan, nama_ibu, trimester, jenis_gizi, tanggal_pemberian, petugas, keterangan, "
                    + "harga, qty, total, bayar, kembalian) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(sqlIbu);
            pst.setString(1, selectedPemeriksaan1.toString());
            pst.setString(2, nmaibu.getText().trim());
            pst.setString(3, trimster.getText().trim());
            pst.setString(4, jnsgizi.getSelectedItem().toString());
            pst.setDate(5, new java.sql.Date(tgl1.getDate().getTime()));
            pst.setString(6, selectedPetugas1.toString());
            pst.setString(7, ket1.getText() != null ? ket1.getText().trim() : "");
            pst.setInt(8, hargaIbu);
            pst.setInt(9, qtyIbu);
            pst.setInt(10, totalIbu);
            pst.setInt(11, bayarIbu);
            pst.setInt(12, kembaliIbu);

            pst.executeUpdate();
            pst.close();
        }

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        kosong();      // Reset form
        load_table();  // Refresh tabel

    } catch (HeadlessException | SQLException | NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error saat menutup koneksi: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
                                   
    try {
        Connection conn = Connect.getConnection();
        PreparedStatement pst;

        // ==== Validasi input umum ====
        if (harga.getText().trim().isEmpty() || qty.getText().trim().isEmpty() || bayar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pastikan semua field numerik (harga, qty, bayar) terisi.");
            return;
        }

        // ==== Update data gizi_balita ====
        if (nmabalita.getText() != null && !nmabalita.getText().trim().isEmpty()) {

            if (tgl.getDate() == null || petugas.getSelectedItem() == null || kdpemeriksaan.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Pastikan semua field balita (tanggal, petugas, kode) terisi.");
                return;
            }

            String sqlBalita = "UPDATE gizi_balita SET "
                    + "nama_balita=?, jenis_gizi=?, tanggal_pemberian=?, petugas=?, keterangan=?, "
                    + "harga=?, qty=?, total=?, bayar=?, kembalian=? "
                    + "WHERE kode_pemeriksaan=?";
            pst = conn.prepareStatement(sqlBalita);

            int hargaSatuan = Integer.parseInt(harga.getText().trim());
            int jumlah = Integer.parseInt(qty.getText().trim());
            int totalBayar = hargaSatuan * jumlah;
            int uangBayar = Integer.parseInt(bayar.getText().trim());
            int kembalianUang = uangBayar - totalBayar;

            pst.setString(1, nmabalita.getText().trim());
            pst.setString(2, jnsgizi.getSelectedItem().toString());
            pst.setDate(3, new java.sql.Date(tgl.getDate().getTime()));
            pst.setString(4, petugas.getSelectedItem().toString());
            pst.setString(5, ket.getText() != null ? ket.getText().trim() : "");
            pst.setInt(6, hargaSatuan);
            pst.setInt(7, jumlah);
            pst.setInt(8, totalBayar);
            pst.setInt(9, uangBayar);
            pst.setInt(10, kembalianUang);
            pst.setString(11, kdpemeriksaan.getSelectedItem().toString());

            pst.executeUpdate();
            pst.close();
        }

        // ==== Update data gizi_ibu ====
        if (nmaibu.getText() != null && !nmaibu.getText().trim().isEmpty()) {

            if (tgl1.getDate() == null || petugas1.getSelectedItem() == null || kdpemeriksaan1.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Pastikan semua field ibu (tanggal, petugas, kode) terisi.");
                return;
            }

            String sqlIbu = "UPDATE gizi_ibu SET "
                    + "nama_ibu=?, trimester=?, jenis_gizi=?, tanggal_pemberian=?, petugas=?, keterangan=?, "
                    + "harga=?, qty=?, total=?, bayar=?, kembalian=? "
                    + "WHERE kode_pemeriksaan=?";
            pst = conn.prepareStatement(sqlIbu);

            int hargaIbu = Integer.parseInt(harga.getText().trim());
            int jumlahIbu = Integer.parseInt(qty.getText().trim());
            int totalIbu = hargaIbu * jumlahIbu;
            int uangBayarIbu = Integer.parseInt(bayar.getText().trim());
            int kembalianIbu = uangBayarIbu - totalIbu;

            pst.setString(1, nmaibu.getText().trim());
            pst.setString(2, trimster.getText().trim());
            pst.setString(3, jnsgizi.getSelectedItem().toString());
            pst.setDate(4, new java.sql.Date(tgl1.getDate().getTime()));
            pst.setString(5, petugas1.getSelectedItem().toString());
            pst.setString(6, ket1.getText() != null ? ket1.getText().trim() : "");
            pst.setInt(7, hargaIbu);
            pst.setInt(8, jumlahIbu);
            pst.setInt(9, totalIbu);
            pst.setInt(10, uangBayarIbu);
            pst.setInt(11, kembalianIbu);
            pst.setString(12, kdpemeriksaan1.getSelectedItem().toString());

            pst.executeUpdate();
            pst.close();
        }

        conn.close();

        JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
        load_table(); // refresh tabel
        btnResetActionPerformed(null); // reset form

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Periksa nilai numerik (harga/qty/bayar): " + e.getMessage());
    }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
nmabalita.setText("");
nmaibu.setText("");
ket.setText("");
ket1.setText("");
trimster.setText("");
harga.setText("");
qty.setText("");
total.setText("");
bayar.setText("");
kmbalian.setText("");
tgl.setDate(null);
tgl1.setDate(null);
petugas.setSelectedIndex(-1);
petugas1.setSelectedIndex(-1);
kdpemeriksaan.setSelectedIndex(-1);
kdpemeriksaan1.setSelectedIndex(-1);
jnsgizi.setSelectedIndex(-1);


    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

    try {
        Connection conn = Connect.getConnection();

        // Hapus data dari tabel gizi_balita jika baris di tabel 'tabel' dipilih
        int selectedRowBalita = tabel.getSelectedRow();
        if (selectedRowBalita != -1) {
            String kodeBalita = tabel.getValueAt(selectedRowBalita, 0).toString();
            String sqlBalita = "DELETE FROM gizi_balita WHERE kode_pemeriksaan = ?";
            try (PreparedStatement pstBalita = conn.prepareStatement(sqlBalita)) {
                pstBalita.setString(1, kodeBalita);
                pstBalita.executeUpdate();
            }
        }

        // Hapus data dari tabel gizi_ibu jika baris di tabel 'tabel1' dipilih
        int selectedRowIbu = tabel1.getSelectedRow();
        if (selectedRowIbu != -1) {
            String kodeIbu = tabel1.getValueAt(selectedRowIbu, 0).toString();
            String sqlIbu = "DELETE FROM gizi_ibu WHERE kode_pemeriksaan = ?";
            try (PreparedStatement pstIbu = conn.prepareStatement(sqlIbu)) {
                pstIbu.setString(1, kodeIbu);
                pstIbu.executeUpdate();
            }
        }

        conn.close();

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
        load_table(); // refresh tabel setelah hapus
        btnResetActionPerformed(null); // reset form

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
    }

    }//GEN-LAST:event_btnHapusActionPerformed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        
    }//GEN-LAST:event_cariKeyPressed

    private void KeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarMouseClicked

    }//GEN-LAST:event_KeluarMouseClicked

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        this.dispose();
        new FormUtama().setVisible(true);
    }//GEN-LAST:event_KeluarActionPerformed

    private void kdpemeriksaan1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kdpemeriksaan1ItemStateChanged
                                                                                 
    }//GEN-LAST:event_kdpemeriksaan1ItemStateChanged

    private void kdpemeriksaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kdpemeriksaanItemStateChanged
                                           



    }//GEN-LAST:event_kdpemeriksaanItemStateChanged

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void kmbalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmbalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kmbalianActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void jnsgiziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnsgiziActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnsgiziActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

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
            java.util.logging.Logger.getLogger(PemberianGizi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PemberianGizi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Keluar;
    private javax.swing.JTextField bayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> jnsgizi;
    private javax.swing.JComboBox<String> kdpemeriksaan;
    private javax.swing.JComboBox<String> kdpemeriksaan1;
    private javax.swing.JTextArea ket;
    private javax.swing.JTextArea ket1;
    private javax.swing.JTextField kmbalian;
    private javax.swing.JTextField nmabalita;
    private javax.swing.JTextField nmaibu;
    private javax.swing.JComboBox<String> petugas;
    private javax.swing.JComboBox<String> petugas1;
    private javax.swing.JTextField qty;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel1;
    private com.toedter.calendar.JDateChooser tgl;
    private com.toedter.calendar.JDateChooser tgl1;
    private javax.swing.JTextField total;
    private javax.swing.JTextField trimster;
    // End of variables declaration//GEN-END:variables

private void tampilkanDataPemeriksaan(String id, String tipe) {
    try {
        Connection conn = Connect.getConnection();
        String sql = "";
        if (tipe.equalsIgnoreCase("balita")) {
            sql = "SELECT nama_balita FROM pemeriksaan_balita WHERE id = ?";
        } else if (tipe.equalsIgnoreCase("ibu")) {
            sql = "SELECT nama_ibu FROM pemeriksaan_ibu WHERE id = ?";
        } else {
            JOptionPane.showMessageDialog(this, "Tipe pemeriksaan tidak dikenali!");
            return;
        }
        
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (tipe.equalsIgnoreCase("balita")) {
                nmabalita.setText(rs.getString("nama_balita"));
            } else {
                nmaibu.setText(rs.getString("nama_ibu"));
            }
        }
        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data pemeriksaan: " + e.getMessage());
    }
}
}