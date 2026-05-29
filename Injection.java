// Injection — subclass of Medicine (Inheritance requirement)
public class Injection extends Medicine {

    private String route; // e.g., "IV", "IM", "SC"

    public Injection(int id, String name, int quantity, String expiryDate, String route) {
        super(id, name, quantity, expiryDate, "Injection");
        this.route = route;
    }

    public String getRoute() { return route; }

    @Override
    public String getExtraInfo() {
        return "Route: " + route;
    }
}
