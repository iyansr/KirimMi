package dto;

public class KurirDTO {
    private final String nama;
    private final String jenisKendaraan;
    private final String platNomor;
    private final String noHp;

    public KurirDTO(String nama, String jenisKendaraan, String platNomor, String noHp) {
        this.nama = nama;
        this.jenisKendaraan = jenisKendaraan;
        this.platNomor = platNomor;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getNoHp() {
        return noHp;
    }
}
