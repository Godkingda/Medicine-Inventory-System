import java.time.LocalDate;

public class Tablet extends Medicine {

    public Tablet(int id, String name, int quantity, String expiryDate) {
        super(id, name, quantity, expiryDate);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Tablet] " + toString());
    }

    @Override
    public boolean isExpired() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(getExpiryDate());
        return expiry.isBefore(today);
    }
}
