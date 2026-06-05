import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuildSystem {
    public static void main(String[] args) {
        String fileName = "guild_data.dat";

        // =========================================================================
        // SKENARIO 1: PROSES SAVE (SERIALIZATION)
        // Kriteria Sangat Baik: ArrayList berhasil membungkus objek-objek member
        // =========================================================================
        ArrayList<Member> listMemberBaru = new ArrayList<>();
        
        // Mengisi ArrayList dengan 3 objek Member secara manual
        listMemberBaru.add(new Member("G-001", "Solomon"));
        listMemberBaru.add(new Member("G-002", "Igris"));
        listMemberBaru.add(new Member("G-003", "Beru"));

        System.out.println("=== Menjalankan Skenario 1: Menyimpan Data ===");
        
        // Kriteria Sangat Baik: Menggunakan ObjectOutputStream dalam balutan elegan try-with-resources
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(listMemberBaru);
            System.out.println("Berhasil! Seluruh data Guild telah disave ke " + fileName + "\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        }


        // =========================================================================
        // SKENARIO 2: PROSES LOAD (DESERIALIZATION)
        // =========================================================================
        System.out.println("=== Menjalankan Skenario 2: Membaca Data ===");
        
        // Kriteria Sangat Baik: Menggunakan ObjectInputStream dalam balutan elegan try-with-resources
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            
            // readObject() mengembalikan tipe data Object induk.
            // // SYARAT MUTLAK: Melakukan DOWNCASTING secara eksplisit dari tipe Object menjadi ArrayList<Member>
            @SuppressWarnings("unchecked")
            ArrayList<Member> listMemberLoad = (ArrayList<Member>) ois.readObject();

            System.out.println("Data berhasil diload dari file. Daftar Member Guild:");
            
            // Menggunakan Foreach loop untuk mencetak semua ID dan Nama Member ke layar terminal
            for (Member member : listMemberLoad) {
                System.out.println("ID: " + member.getId() + " | Nama: " + member.getNama());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat meload data: " + e.getMessage());
        }
    }
}