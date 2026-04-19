public class MakananHewan extends Produk {
    protected String rasa;

    public MakananHewan(String id, String nama, double harga, String rasa) {
        super(id, nama, harga);
        this.rasa = rasa;
    }

    public void setRasa(String rasa) { this.rasa = rasa; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Varian rasa: " + rasa + " (Kategori: Makanan)");
    }

    @Override
    public double hitungOngkir() { return 5000.0; }

    @Override
    public String getInfoDetail() { return "Kategori: Makanan | Varian: " + rasa; }

    @Override
    public String getKategori() { return "Makanan Hewan"; }

    @Override
    public String getCiriKhas() { return "Berdasarkan Rasa: " + rasa; }
}