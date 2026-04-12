public class Aksesoris extends Produk {
    private String material;

    public Aksesoris(String id, String nama, double harga, String material) {
        super(id, nama, harga);
        this.material = material;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Material: " + material + " (Kategori: Aksesoris)");
    }

    @Override
    public double hitungOngkir() {
        return 7000.0;
    }
}