// Syrup — subclass of Medicine (Inheritance requirement)
public class Syrup extends Medicine {

    private int volumeMl;

    public Syrup(int id, String name, int quantity, String expiryDate, int volumeMl) {
        super(id, name, quantity, expiryDate, "Syrup");
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() { return volumeMl; }

    @Override
    public String getExtraInfo() {
        return "Volume: " + volumeMl + "ml";
    }
}
