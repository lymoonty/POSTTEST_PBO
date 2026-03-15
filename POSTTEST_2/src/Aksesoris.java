public class Aksesoris extends Produk {
    private String material;

    public Aksesoris(String id, String nama, double harga, String material) {
        super(id, nama, harga);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Material: " + material + " (Kategori: Aksesoris)");
    }
}