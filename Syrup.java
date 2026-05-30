// ============================================================
// INHERITANCE: Syrup extends Medicine.
// Represents liquid oral medicines.
// Adds: volume in ml and dose per spoon.
// ============================================================
public class Syrup extends Medicine {

    private int    volumeMl;      // total volume in bottle (ml)
    private String dosePerSpoon;  // e.g. "5ml per dose"

    public Syrup(int id, String name, int quantity, String expiryDate, double price, int volumeMl, String dosePerSpoon) {
        super(id, name, quantity, expiryDate, price);
        this.volumeMl     = volumeMl;
        this.dosePerSpoon = dosePerSpoon;
    }

    public Syrup(int id, String name, int quantity, String expiryDate, double price) {
        super(id, name, quantity, expiryDate, price);
        this.volumeMl     = 100;
        this.dosePerSpoon = "5ml per dose";
    }

    public int    getVolumeMl()     { return volumeMl; }
    public String getDosePerSpoon() { return dosePerSpoon; }

    @Override
    public String getCategory() { return "Syrup"; }

    @Override
    public String getDosageInfo() {
        return volumeMl + "ml bottle — " + dosePerSpoon + " — shake before use";
    }
}
