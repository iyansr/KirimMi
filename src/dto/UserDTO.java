package dto;

public class UserDTO {
    private final int id;
    private String nama;
    private String email;
    private String hashedPassword;

    public UserDTO(int id, String nama, String email, String hashedPassword) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.hashedPassword = hashedPassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
