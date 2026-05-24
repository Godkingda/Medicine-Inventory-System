public class Hospital {

    private String name;
    private String location;

    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void displayDetails() {
        System.out.println("Hospital: " + name + " | Location: " + location);
    }
}
