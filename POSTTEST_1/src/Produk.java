public class Produk {
    protected String id;
    protected String nama;
    protected double harga;

    public Produk(String id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public String getId() { return id; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }

    public void tampilkanData() {
        System.out.print("ID: " + id + " | Nama: " + nama + " | Harga: Rp" + harga);
    }
}