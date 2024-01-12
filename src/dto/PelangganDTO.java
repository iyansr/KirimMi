package dto;

public class PelangganDTO {
    private final String nama;
    private final String noHp;
    private final String alamat;
    private final String kota;
    private final String kecamatan;

    public PelangganDTO(String nama, String noHp, String alamat, String kota, String kecamatan) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.kota = kota;
        this.kecamatan = kecamatan;
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
