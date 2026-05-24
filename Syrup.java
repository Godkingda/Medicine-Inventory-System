import java.time.LocalDate;

public class Syrup extends Medicine {

    public Syrup(int id, String name, int quantity, String expiryDate) {
        super(id, name, quantity, expiryDate);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Syrup] " + toString());
    }

    @Override
    public boolean isExpired() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(getExpiryDate());
        return expiry.isBefore(today);
    }
}
