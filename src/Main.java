import java.util.Scanner;

// Superclass
class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }
}

// Subclass
class Transaksi extends Barang {
    private int jumlahBeli;

    public Transaksi(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungTotal() {
        return getHargaBarang() * jumlahBeli;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = Double.parseDouble(scanner.nextLine());

            if (hargaBarang <= 0) {
                throw new IllegalArgumentException("Harga barang harus lebih dari 0!");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = Integer.parseInt(scanner.nextLine());

            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
            }

            // Membuat objek Transaksi
            Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan hasil
            System.out.println("\n--- Detail Transaksi ---");
            System.out.println("No Faktur: " + noFaktur);
            System.out.println("Kode Barang: " + transaksi.getKodeBarang());
            System.out.println("Nama Barang: " + transaksi.getNamaBarang());
            System.out.println("Harga Barang: Rp" + transaksi.getHargaBarang());
            System.out.println("Jumlah Beli: " + jumlahBeli);
            System.out.println("Total: Rp" + transaksi.hitungTotal());
        } catch (NumberFormatException e) {
            System.out.println("Error: Input harus berupa angka untuk harga barang atau jumlah beli!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");
        } finally {
            scanner.close();
        }
    }
}
