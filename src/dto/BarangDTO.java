package dto;

public class BarangDTO {
    private final int id;
    private final String nama;
    private final double berat;
    private final int idPenerima;
    private final int idPengirim;
    private final String status;
    private final String deskripsi;

    public BarangDTO(int id, String nama, double berat, int idPenerima, int idPengirim, String status, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.berat = berat;
        this.idPenerima = idPenerima;
        this.idPengirim = idPengirim;
        this.status = status;
        this.deskripsi = deskripsi;
    }

    //Getter
    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }

    public double getBerat() {
        return berat;
    }

    public int getIdPenerima() {
        return idPenerima;
    }

    public int getIdPengirim() {
        return idPengirim;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }
}
