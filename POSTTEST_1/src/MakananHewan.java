public class MakananHewan extends Produk {
    private String rasa;

    public MakananHewan(String id, String nama, double harga, String rasa) {
        super(id, nama, harga);
        this.rasa = rasa;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Varian rasa: " + rasa + " (Kategori: Makanan)");
    }
}