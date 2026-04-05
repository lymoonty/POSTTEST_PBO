public class MakananKucing extends MakananHewan {
    private String jenis;

    public MakananKucing(String id, String nama, double harga, String rasa, String jenis) {
        super(id, nama, harga, rasa);
        this.jenis = jenis;
    }

    public void setJenis(String jenis) { this.jenis = jenis; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Jenis: " + jenis + " (Kategori: Makanan Kucing)");
    }
}