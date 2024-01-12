package entity;

public class Barang {
    private final int id;
    private String nama;
    private double berat;
    private String penerima;
    private String pengirim;
    private String status;
    private String deskripsi;

    public Barang(int id, String nama, double berat, String penerima, String pengirim, String status, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.berat = berat;
        this.penerima = penerima;
        this.pengirim = pengirim;
        this.status = status;
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
