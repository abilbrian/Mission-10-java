import java.io.Serializable;

// Kriteria Sangat Baik: Class wajib implements Serializable agar objek bisa di-save ke file biner
public class Member implements Serializable {
    // Menambahkan serialVersionUID untuk memastikan versi object konsisten saat proses I/O
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nama;

    // Constructor untuk set id dan nama member
    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter untuk mengakses atribut ID
    public String getId() {
        return id;
    }

    // Getter untuk mengakses atribut Nama
    public String getNama() {
        return nama;
    }
}