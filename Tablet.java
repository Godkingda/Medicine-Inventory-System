// Tablet — subclass of Medicine (Inheritance requirement)
public class Tablet extends Medicine {

    private int dosageMg;

    public Tablet(int id, String name, int quantity, String expiryDate, int dosageMg) {
        super(id, name, quantity, expiryDate, "Tablet");
        this.dosageMg = dosageMg;
    }

    public int getDosageMg() { return dosageMg; }

    @Override
    public String getExtraInfo() {
        return "Dosage: " + dosageMg + "mg";
    }
}
