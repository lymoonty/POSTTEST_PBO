import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produk> listProduk = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU TOKO PERLENGKAPAN HEWAN ---");
            System.out.println("1. Tambah Stok ");
            System.out.println("2. Cek Semua Stok ");
            System.out.println("3. Edit Data Produk ");
            System.out.println("4. Hapus Produk ");
            System.out.println("5. Simulasi Kasir  ");
            System.out.println("6. Keluar ");
            System.out.print("Pilih menu (1-6):  ");

            if (!input.hasNextInt()) {
                System.out.println("Input harus angka! ");
                input.next();
                continue;
            }

            int pil = input.nextInt();
            input.nextLine();

            if (pil == 6) {
                System.out.println("dadahhh! ");
                break;
            }

            switch (pil) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanBarang();
                case 3 -> editBarang();
                case 4 -> hapusBarang();
                case 5 -> simulasiKasir();
                default -> System.out.println("Pilihanmu salah, coba lagi. ");
            }
        }
    }

    static void tambahBarang() {
        System.out.println("\n--- Input Barang Baru ---");
        System.out.println("1. Makanan Umum ");
        System.out.println("2. Makanan Kucing (Multilevel) ");
        System.out.println("3. Aksesoris ");
        System.out.print("Jenisnya apa? (1/2/3):  ");
        int tipe = input.nextInt();
        input.nextLine();

        System.out.print("Kode/ID:  ");
        String id = input.nextLine();
        System.out.print("Nama Barang:  ");
        String nama = input.nextLine();
        System.out.print("Harga:  ");
        double harga = input.nextDouble();
        input.nextLine();

        if (tipe == 1) {
            System.out.print("Varian Rasa:  ");
            String rasa = input.nextLine();
            listProduk.add(new MakananHewan(id, nama, harga, rasa));
        } else if (tipe == 2) {
            System.out.print("Varian Rasa:  ");
            String rasa = input.nextLine();
            System.out.print("Jenis (Basah/Kering):  ");
            String jns = input.nextLine();
            listProduk.add(new MakananKucing(id, nama, harga, rasa, jns));
        } else {
            System.out.print("Bahan/Material:  ");
            String bahan = input.nextLine();
            listProduk.add(new Aksesoris(id, nama, harga, bahan));
        }
        System.out.println("Data berhasil disimpan! ");
    }

    static void tampilkanBarang() {
        if (listProduk.isEmpty()) {
            System.out.println("\nStok masih kosong. ");
            return;
        }
        System.out.println("\n--- LIST STOK SAAT INI ---");
        for (Produk p : listProduk) {
            p.tampilkanData();
        }
    }

    static void editBarang() {
        System.out.print("\nMasukkan ID barang yang mau diubah:  ");
        String cari = input.nextLine();
        boolean ada = false;

        for (Produk p : listProduk) {
            if (p.getId().equalsIgnoreCase(cari)) {
                System.out.print("Nama baru:  ");
                p.setNama(input.nextLine());
                System.out.print("Harga baru:  ");
                p.setHarga(input.nextDouble());
                input.nextLine();

                if (p instanceof MakananKucing mk) {
                    System.out.print("Rasa baru:  ");
                    mk.setRasa(input.nextLine());
                    System.out.print("Jenis baru (Basah/Kering):  ");
                    mk.setJenis(input.nextLine());
                } else if (p instanceof MakananHewan mh) {
                    System.out.print("Rasa baru:  ");
                    mh.setRasa(input.nextLine());
                } else if (p instanceof Aksesoris ak) {
                    System.out.print("Material baru:  ");
                    ak.setMaterial(input.nextLine());
                }

                ada = true;
                System.out.println("Data berhasil diupdate! ");
                break;
            }
        }
        if (!ada) System.out.println("ID tidak ditemukan. ");
    }

    static void hapusBarang() {
        System.out.print("\nMasukkan ID yang mau dihapus:  ");
        String idHapus = input.nextLine();
        if (listProduk.removeIf(p -> p.getId().equalsIgnoreCase(idHapus))) {
            System.out.println("Barang berhasil dihapus. ");
        } else {
            System.out.println("Gagal menghapus, ID tidak ditemukan. ");
        }
    }

    static void simulasiKasir() {
        if (listProduk.isEmpty()) {
            System.out.println("\nStok kosong, tidak bisa belanja. ");
            return;
        }

        System.out.print("\n Masukkan ID barang yang ingin dibeli: ");
        String cari = input.nextLine();
        Produk found = null;

        for (Produk p : listProduk) {
            if (p.getId().equalsIgnoreCase(cari)) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println(" ID tidak ditemukan di stok.");
            return;
        }

        System.out.print(" Masukkan jumlah beli (qty): ");
        int qty = input.nextInt();
        input.nextLine();

        double subtotal;
        String statusDiskon = "Tidak ada diskon";

        if (qty >= 3) {
            subtotal = found.hitungTotal(qty, 15.0);
            statusDiskon = "Dapat Diskon 15% (Beli >= 3 pcs)";
        } else {
            subtotal = found.hitungTotal(qty);
        }

        double ongkir = found.hitungOngkir();
        double grandTotal = subtotal + ongkir;

        System.out.println("\n --- STRUK BELANJA ---");
        System.out.println("Produk   : " + found.getNama());
        System.out.println("Harga Satuan: Rp" + found.getHarga());
        System.out.println("Jumlah   : " + qty + " pcs");
        System.out.println("Status   : " + statusDiskon);
        System.out.println("Subtotal : Rp" + subtotal);
        System.out.println("Ongkir   : Rp" + ongkir + " (" + found.getInfoDetail() + ")");
        System.out.println("TOTAL BAYAR: Rp" + grandTotal);
        System.out.println("TOTAL BAYAR jika tidak memakai jasa kirim : Rp" + subtotal);
        System.out.println("------------------------------------------------------------");
    }
}