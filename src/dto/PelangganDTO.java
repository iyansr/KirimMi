package dto;

public class PelangganDTO {
    private final int id;
    private final String nama;
    private final String noHp;
    private final String alamat;
    private final String kota;
    private final String kecamatan;

    public PelangganDTO(int id, String nama, String noHp, String alamat, String kota, String kecamatan) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.kota = kota;
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
