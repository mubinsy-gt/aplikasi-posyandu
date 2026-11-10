-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2025 at 09:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posyandu`
--

-- --------------------------------------------------------

--
-- Table structure for table `gizi_balita`
--

CREATE TABLE `gizi_balita` (
  `id` int(11) NOT NULL,
  `kode_pemeriksaan` varchar(20) DEFAULT NULL,
  `nama_balita` varchar(50) DEFAULT NULL,
  `tanggal_pemberian` date DEFAULT NULL,
  `petugas` varchar(50) DEFAULT NULL,
  `keterangan` text DEFAULT NULL,
  `jenis_gizi` varchar(50) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `bayar` int(11) DEFAULT NULL,
  `kembalian` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gizi_balita`
--

INSERT INTO `gizi_balita` (`id`, `kode_pemeriksaan`, `nama_balita`, `tanggal_pemberian`, `petugas`, `keterangan`, `jenis_gizi`, `harga`, `qty`, `total`, `bayar`, `kembalian`) VALUES
(15, '1', 'bita', '2025-06-25', 'Siti Aminah', 'sehari sekali', 'Vitamin A', 2000, 2, 4000, 10000, 6000),
(18, '7', 'genzi', '2025-07-01', 'tia', 'diminum', 'Vitamin A', 2000, 2, 4000, 5000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `gizi_ibu`
--

CREATE TABLE `gizi_ibu` (
  `id` int(11) NOT NULL,
  `kode_pemeriksaan` varchar(20) DEFAULT NULL,
  `nama_ibu` varchar(50) DEFAULT NULL,
  `trimester` varchar(20) DEFAULT NULL,
  `tanggal_pemberian` date DEFAULT NULL,
  `petugas` varchar(50) DEFAULT NULL,
  `keterangan` text DEFAULT NULL,
  `jenis_gizi` varchar(50) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `bayar` int(11) DEFAULT NULL,
  `kembalian` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gizi_ibu`
--

INSERT INTO `gizi_ibu` (`id`, `kode_pemeriksaan`, `nama_ibu`, `trimester`, `tanggal_pemberian`, `petugas`, `keterangan`, `jenis_gizi`, `harga`, `qty`, `total`, `bayar`, `kembalian`) VALUES
(10, '1', 'angel', '21', '2025-06-12', 'ibnu', 'adasd', 'Tablet Tambah Darah(Fe)', 5000, 2, 10000, 12222, 2222),
(13, '5', 'gita', '2', '2025-07-01', 'tia', 'sakit', 'Tablet Tambah Darah(Fe)', 5000, 2, 10000, 20000, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan_balita`
--

CREATE TABLE `pemeriksaan_balita` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nama_balita` varchar(100) NOT NULL,
  `berat_badan` varchar(10) DEFAULT NULL,
  `tinggi_badan` varchar(10) DEFAULT NULL,
  `suhu_tubuh` float DEFAULT NULL,
  `keluhan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemeriksaan_balita`
--

INSERT INTO `pemeriksaan_balita` (`id`, `tanggal`, `nama_balita`, `berat_badan`, `tinggi_badan`, `suhu_tubuh`, `keluhan`) VALUES
(1, '2025-06-13', 'bita', '35', '121', 45, 'panas'),
(2, '2025-06-06', 'jarulllah', '1', '21', 21, 'sakit'),
(3, '2025-06-25', 'pian', '10', '10', 40, 'sakit'),
(4, '2025-06-25', 'pian', '10', '10', 40, 'sakit'),
(7, '2025-07-01', 'genzi', '43', '21', 34, 'demam');

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan_ibu`
--

CREATE TABLE `pemeriksaan_ibu` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nama_ibu` varchar(100) NOT NULL,
  `berat_badan` varchar(10) DEFAULT NULL,
  `tekanan_darah` varchar(10) DEFAULT NULL,
  `suhu_tubuh` varchar(10) DEFAULT NULL,
  `keluhan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemeriksaan_ibu`
--

INSERT INTO `pemeriksaan_ibu` (`id`, `tanggal`, `nama_ibu`, `berat_badan`, `tekanan_darah`, `suhu_tubuh`, `keluhan`) VALUES
(1, '2025-06-19', 'angel', '23', '21', '15', 'mual'),
(2, '2025-06-12', 'ayu', '200', '212', '21', 'sakit'),
(5, '2025-07-01', 'gita', '123', '43', '53', 'kurang vitamin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_balita`
--

CREATE TABLE `tb_balita` (
  `no_registrasi` varchar(10) NOT NULL DEFAULT '',
  `nama_balita` varchar(25) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `umur` int(50) DEFAULT NULL,
  `jenis_kelamin` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tb_balita`
--

INSERT INTO `tb_balita` (`no_registrasi`, `nama_balita`, `tgl`, `umur`, `jenis_kelamin`) VALUES
('B0002', 'bita', '2021-08-05', 1, 'LAKI - LAKI'),
('B0003', 'udinssss', '2025-05-03', 23, 'LAKI - LAKI'),
('B0004', 'bintang', '2025-05-03', 23, 'LAKI - LAKI'),
('B0007', 'arul', '2025-05-16', 12, 'LAKI - LAKI'),
('B0008', 'pian', '2025-05-01', 234, 'LAKI - LAKI'),
('B0011', 'genzi', '2025-07-09', 10, 'LAKI - LAKI');

-- --------------------------------------------------------

--
-- Table structure for table `tb_gizi`
--

CREATE TABLE `tb_gizi` (
  `kode_pemeriksaan` varchar(50) NOT NULL,
  `kode_ibu` varchar(50) NOT NULL,
  `nama_ibu` varchar(50) NOT NULL,
  `no_registrasi` varchar(50) NOT NULL,
  `nama_balita` varchar(50) NOT NULL,
  `status_gizi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_gizi`
--

INSERT INTO `tb_gizi` (`kode_pemeriksaan`, `kode_ibu`, `nama_ibu`, `no_registrasi`, `nama_balita`, `status_gizi`) VALUES
('G0001', 'I0001', 'angel', 'B0002', 'bita', 'kurang'),
('G0002', 'I0002', 'jsfkjs', 'B0003', 'udinssss', 'baik'),
('G0004', 'I0004', 'angelica', 'B0004', 'bintang', 'buruk'),
('G0006', 'I0006', 'fatimah', 'B0010', 'bintang', 'kurang gizi'),
('G0007', 'I0007', 'gita', 'B0011', 'genzi', 'kurang vitamin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_ibu`
--

CREATE TABLE `tb_ibu` (
  `kode_ibu` varchar(20) NOT NULL DEFAULT '',
  `nama_ibu` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `umur` int(2) NOT NULL,
  `no_tlp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tb_ibu`
--

INSERT INTO `tb_ibu` (`kode_ibu`, `nama_ibu`, `tanggal_lahir`, `alamat`, `umur`, `no_tlp`) VALUES
('I0001', 'angel', '2025-05-06', 'bekasi', 12, '214324'),
('I0002', 'farah', '2025-05-08', 'ahfbjeaf', 34, '1234324'),
('I0004', 'angelica', '2025-06-12', 'bekasi', 25, '2937492784'),
('I0007', 'gita', '2021-07-22', 'bekasi', 35, '67657676');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kader`
--

CREATE TABLE `tb_kader` (
  `kode_kader` varchar(10) NOT NULL,
  `nama_kader` varchar(100) DEFAULT NULL,
  `tanggal_bergabung` date DEFAULT NULL,
  `jenis_kelamin` enum('Laki - Laki','Perempuan') DEFAULT NULL,
  `no_telepon` varchar(15) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `jabatan` enum('Ketua','Wakil Ketua','Sekretaris','Bendahara','Anggota') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_kader`
--

INSERT INTO `tb_kader` (`kode_kader`, `nama_kader`, `tanggal_bergabung`, `jenis_kelamin`, `no_telepon`, `alamat`, `jabatan`) VALUES
('KD001', 'Siti Aminah', '2021-01-10', 'Perempuan', '081234567890', 'Jl. Mawar No. 1', 'Ketua'),
('KD002', 'ibnu', '2025-06-07', 'Laki - Laki', '0882344443', 'bekasi', 'Wakil Ketua'),
('KD003', 'Fardan', '2025-06-24', 'Laki - Laki', '082199634206', 'Bekasi', 'Ketua'),
('KD006', 'tia', '2025-07-01', 'Perempuan', '65465', 'jakarta', 'Wakil Ketua');

-- --------------------------------------------------------

--
-- Table structure for table `tb_login`
--

CREATE TABLE `tb_login` (
  `id` int(5) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `level` varchar(20) DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tb_login`
--

INSERT INTO `tb_login` (`id`, `username`, `password`, `level`) VALUES
(1, 'admin', 'admin123', 'admin'),
(2, 'seketaris', 'seketaris', 'seketaris');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gizi_balita`
--
ALTER TABLE `gizi_balita`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gizi_ibu`
--
ALTER TABLE `gizi_ibu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pemeriksaan_balita`
--
ALTER TABLE `pemeriksaan_balita`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pemeriksaan_ibu`
--
ALTER TABLE `pemeriksaan_ibu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_balita`
--
ALTER TABLE `tb_balita`
  ADD PRIMARY KEY (`no_registrasi`);

--
-- Indexes for table `tb_gizi`
--
ALTER TABLE `tb_gizi`
  ADD PRIMARY KEY (`kode_pemeriksaan`),
  ADD UNIQUE KEY `no_regis` (`no_registrasi`),
  ADD KEY `kode_kegiatan` (`kode_ibu`) USING BTREE;

--
-- Indexes for table `tb_ibu`
--
ALTER TABLE `tb_ibu`
  ADD PRIMARY KEY (`kode_ibu`);

--
-- Indexes for table `tb_kader`
--
ALTER TABLE `tb_kader`
  ADD PRIMARY KEY (`kode_kader`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gizi_balita`
--
ALTER TABLE `gizi_balita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `gizi_ibu`
--
ALTER TABLE `gizi_ibu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `pemeriksaan_balita`
--
ALTER TABLE `pemeriksaan_balita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pemeriksaan_ibu`
--
ALTER TABLE `pemeriksaan_ibu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_login`
--
ALTER TABLE `tb_login`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
