import java.time.LocalDate;

public class Injection extends Medicine {

    public Injection(int id, String name, int quantity, String expiryDate) {
        super(id, name, quantity, expiryDate);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Injection] " + toString());
    }

    @Override
    public boolean isExpired() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(getExpiryDate());
        return expiry.isBefore(today);
    }
}
