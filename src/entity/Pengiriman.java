package entity;

public class Pengiriman {
    private final int id;
    private String idBarang;
    private String namaPengirim;
    private String alamatPengirim;
    private String noHpPengirim;
    private String namaPenerima;
    private String alamatPenerima;
    private String noHpPenerima;
    private String idKurir;
    private int total;
    private String kode;
    private String idAdmin;
    private String date;

    public Pengiriman(int id,
                      String idBarang,
                      String namaPengirim,
                      String alamatPengirim,
                      String noHpPengirim,
                      String namaPenerima,
                      String alamatPenerima,
                      String noHpPenerima,
                      String idKurir,
                      int total,
                      String kode,
                      String idAdmin,
                      String date) {
        this.id = id;
        this.idBarang = idBarang;
        this.namaPengirim = namaPengirim;
        this.alamatPengirim = alamatPengirim;
        this.noHpPengirim = noHpPengirim;
        this.namaPenerima = namaPenerima;
        this.alamatPenerima = alamatPenerima;
        this.noHpPenerima = noHpPenerima;
        this.idKurir = idKurir;
        this.total = total;
        this.kode = kode;
        this.idAdmin = idAdmin;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public String getAlamatPengirim() {
        return alamatPengirim;
    }

    public void setAlamatPengirim(String alamatPengirim) {
        this.alamatPengirim = alamatPengirim;
    }

    public String getNoHpPengirim() {
        return noHpPengirim;
    }

    public void setNoHpPengirim(String noHpPengirim) {
        this.noHpPengirim = noHpPengirim;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getAlamatPenerima() {
        return alamatPenerima;
    }

    public void setAlamatPenerima(String alamatPenerima) {
        this.alamatPenerima = alamatPenerima;
    }

    public String getNoHpPenerima() {
        return noHpPenerima;
    }

    public void setNoHpPenerima(String noHpPenerima) {
        this.noHpPenerima = noHpPenerima;
    }

    public String getIdKurir() {
        return idKurir;
    }

    public void setIdKurir(String idKurir) {
        this.idKurir = idKurir;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
