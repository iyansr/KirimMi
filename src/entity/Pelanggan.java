package entity;

public class Pelanggan {
    private final int id;
    private String nama;
    private String noHp;
    private String alamat;
    private String kota;
    private String kecamatan;

    public Pelanggan(int id, String nama, String noHp, String alamat, String kota, String kecamatan) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.kota = kota;
        this.kecamatan = kecamatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKota() {
        return kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }
}
