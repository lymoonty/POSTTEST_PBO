import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produk> listProduk = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU TOKO PERLENGKAPAN HEWAN ---");
            System.out.println("1. Tambah Stok");
            System.out.println("2. Cek Semua Stok");
            System.out.println("3. Edit Data Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            if (!input.hasNextInt()) {
                System.out.println("harus angka!");
                input.next();
                continue;
            }

            int pil = input.nextInt();
            input.nextLine();

            if (pil == 5) {
                System.out.println("Dadahhh!");
                break;
            }

            switch (pil) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanBarang();
                case 3 -> editBarang();
                case 4 -> hapusBarang();
                default -> System.out.println("Pilihan salah, coba lagi.");
            }
        }
    }

    static void tambahBarang() {
        System.out.println("\n--- Input Barang Baru ---");
        System.out.println("1. Makanan");
        System.out.println("2. Aksesoris");
        System.out.print("Jenisnya apa? (1/2): ");
        int tipe = input.nextInt();
        input.nextLine();

        System.out.print("Kode/ID: ");
        String id = input.nextLine();
        System.out.print("Nama Barang: ");
        String nama = input.nextLine();
        System.out.print("Harga: ");
        double harga = input.nextDouble();
        input.nextLine();

        if (tipe == 1) {
            System.out.print("Varian Rasa: ");
            String rasa = input.nextLine();
            listProduk.add(new MakananHewan(id, nama, harga, rasa));
        } else {
            System.out.print("Bahan/Material: ");
            String bahan = input.nextLine();
            listProduk.add(new Aksesoris(id, nama, harga, bahan));
        }
        System.out.println("Data berhasil disimpan!");
    }

    static void tampilkanBarang() {
        if (listProduk.isEmpty()) {
            System.out.println("\nStok masih kosong.");
            return;
        }
        System.out.println("\n--- LIST STOK SAAT INI ---");
        for (Produk p : listProduk) {
            p.tampilkanData();
        }
    }

    static void editBarang() {
        System.out.print("\nMasukkan ID barang yang mau diubah: ");
        String cari = input.nextLine();
        boolean ada = false;

        for (Produk p : listProduk) {
            if (p.getId().equalsIgnoreCase(cari)) {
                System.out.print("Nama baru: ");
                p.setNama(input.nextLine()); // Menggunakan Setter
                System.out.print("Harga baru: ");
                p.setHarga(input.nextDouble()); // Menggunakan Setter
                input.nextLine();

                if (p instanceof MakananHewan) {
                    System.out.print("Rasa baru: ");
                    ((MakananHewan) p).setRasa(input.nextLine());
                } else if (p instanceof Aksesoris) {
                    System.out.print("Material baru: ");
                    ((Aksesoris) p).setMaterial(input.nextLine());
                }

                ada = true;
                System.out.println("Data berhasil diupdate!");
                break;
            }
        }
        if (!ada) System.out.println("ID tidak ditemukan.");
    }

    static void hapusBarang() {
        System.out.print("\nMasukkan ID yang mau dihapus: ");
        String idHapus = input.nextLine();
        if (listProduk.removeIf(p -> p.getId().equalsIgnoreCase(idHapus))) {
            System.out.println("Barang berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus, ID tidak ditemukan.");
        }
    }
}