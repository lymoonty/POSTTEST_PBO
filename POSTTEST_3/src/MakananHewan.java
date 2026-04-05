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
        System.out.print(" | Varian rasa: " + rasa);
    }
}