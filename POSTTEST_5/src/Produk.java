public abstract class Produk implements InfoProduk {
    protected String id;
    protected String nama;
    protected double harga;

    public Produk(String id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }

    public void tampilkanData() {
        System.out.print("ID: " + id + " | Nama: " + nama + " | Harga: Rp" + harga);
    }

    public double hitungTotal(int qty) {
        return harga * qty;
    }

    public double hitungTotal(int qty, double diskonPersen) {
        return (harga * qty) * (1 - diskonPersen / 100.0);
    }

    public abstract double hitungOngkir();
    public abstract String getInfoDetail();

    @Override
    public abstract String getKategori();

    @Override
    public abstract String getCiriKhas();
}