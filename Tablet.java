// ============================================================
// INHERITANCE: Tablet extends Medicine.
// Represents solid oral medicines (tablets/capsules).
// Adds: mg strength per tablet.
// ============================================================
public class Tablet extends Medicine {

    private int mgStrength; // milligrams per tablet

    public Tablet(int id, String name, int quantity, String expiryDate, double price, int mgStrength) {
        super(id, name, quantity, expiryDate, price);
        this.mgStrength = mgStrength;
    }

    // Simplified constructor with default strength
    public Tablet(int id, String name, int quantity, String expiryDate, double price) {
        super(id, name, quantity, expiryDate, price);
        this.mgStrength = 500;
    }

    public int getMgStrength() { return mgStrength; }

    @Override
    public String getCategory() { return "Tablet"; }

    @Override
    public String getDosageInfo() {
        return mgStrength + "mg per tablet — take orally with water";
    }
}
