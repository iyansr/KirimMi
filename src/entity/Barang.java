package entity;

public class Barang {
    private String nama;
    private double berat;
    private int idPenerima;
    private int idPengirim;
    private String status;
    private String deskripsi;

    public Barang(String nama, double berat, int idPenerima, int idPengirim, String status, String deskripsi) {
        this.nama = nama;
        this.berat = berat;
        this.idPenerima = idPenerima;
        this.idPengirim = idPengirim;
        this.status = status;
        this.deskripsi = deskripsi;
    }


    //Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setIdPenerima(int idPenerima) {
        this.idPenerima = idPenerima;
    }

    public void setIdPengirim(int idPengirim) {
        this.idPengirim = idPengirim;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Getter
    public String getNama() {
        return nama;
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
