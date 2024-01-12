CREATE TABLE `barang` (
   `id` int(16) NOT NULL AUTO_INCREMENT,
   `berat` decimal NOT NULL,
   `nama` varchar(50) NOT NULL,
   `id_penerima` int(16) NOT NULL,
   `id_pengirim` int(16) NOT NULL,
   `status` varchar(128) NOT NULL,
   `deskripsi` varchar(100) NOT NULL,
   PRIMARY KEY(`id`)
);

CREATE TABLE `user` (
   `id` int(16) NOT NULL AUTO_INCREMENT,
   `nama` varchar(255) NOT NULL,
   `email` varchar(255) NOT NULL,
   `hashed_password` text NOT NULL,
   `created_at` datetime(6) NOT NULL,
   PRIMARY KEY(`id`)
);

CREATE TABLE `pengiriman` (
   `id` int(16) NOT NULL AUTO_INCREMENT,
   `id_barang` int(16) NOT NULL,
   `id_kurir` int(16) NOT NULL,
   `total` int(10) NOT NULL,
   `kode` varchar(128) NOT NULL UNIQUE,
   `id_admin` int(16) NOT NULL,
   `tanggal` datetime NOT NULL,
   PRIMARY KEY(`id`)
);

CREATE TABLE `kurir` (
   `id` int(16) NOT NULL AUTO_INCREMENT,
   `nama` varchar(100) NOT NULL,
   `jenis_kendaraan` varchar(50) NOT NULL,
   `plat_no` varchar(20) NOT NULL,
   `no_hp` varchar(15) NOT NULL,
   PRIMARY KEY(`id`)
);

CREATE TABLE `pelanggan` (
   `id` int(16) NOT NULL AUTO_INCREMENT,
   `nama` varchar(50) NOT NULL,
   `no_hp` varchar(20) NOT NULL,
   `alamat` text NOT NULL,
   `kota` varchar(50) NOT NULL,
   `kecamatan` varchar(50) NOT NULL,
   `maps_url` text,
   PRIMARY KEY(`id`)
);

CREATE TABLE `tracking` (
   `id` int(16) NOT NULL AUTO_INCREMENT,
   `id_pengiriman` int(16) NOT NULL,
   `deskripsi` varchar(200) NOT NULL,
   `tanggal` date NOT NULL,
   PRIMARY KEY(`id`)
);

ALTER TABLE
   pengiriman
ADD
   FOREIGN KEY (`id_admin`) REFERENCES user(`id`);

ALTER TABLE
   pengiriman
ADD
   FOREIGN KEY (`id_barang`) REFERENCES barang(`id`);

ALTER TABLE
   pengiriman
ADD
   FOREIGN KEY (`id_kurir`) REFERENCES kurir(`id`);

ALTER TABLE
   tracking
ADD
   FOREIGN KEY (`id_pengiriman`) REFERENCES pengiriman(`id`);

ALTER TABLE
   barang
ADD
   FOREIGN KEY (`id_penerima`) REFERENCES pelanggan(`id`);

ALTER TABLE
   barang
ADD
   FOREIGN KEY (`id_pengirim`) REFERENCES pelanggan(`id`);