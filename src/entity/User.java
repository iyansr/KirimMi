package entity;

public class User {
    private final int id;
    private final String nama;
    private final String email;

    public User(int id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

}
