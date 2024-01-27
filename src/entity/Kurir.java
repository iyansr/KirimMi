package entity;

public class Kurir {
    private final int id;
    private String nama;
    private String jenisKendaraan;
    private String platNo;
    private String noHp;

    public Kurir(int id, String nama, String jenisKendaraan, String platNo, String noHp) {
        this.id = id;
        this.nama = nama;
        this.jenisKendaraan = jenisKendaraan;
        this.platNo = platNo;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    @Override
    public String toString() {
        return this.nama;
    }
}
