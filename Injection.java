// ============================================================
// INHERITANCE: Injection extends Medicine.
// Represents injectable medicines (IV, IM, subcutaneous).
// Adds: injection route (e.g. "IV", "IM").
// ============================================================
public class Injection extends Medicine {

    private String route; // IV, IM, Subcutaneous

    public Injection(int id, String name, int quantity, String expiryDate, double price, String route) {
        super(id, name, quantity, expiryDate, price);
        this.route = route;
    }

    public Injection(int id, String name, int quantity, String expiryDate, double price) {
        super(id, name, quantity, expiryDate, price);
        this.route = "IV";
    }

    public String getRoute() { return route; }

    @Override
    public String getCategory() { return "Injection"; }

    @Override
    public String getDosageInfo() {
        return "Administer via " + route + " — for clinical use only";
    }
}
