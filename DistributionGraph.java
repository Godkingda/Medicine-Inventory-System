import java.util.ArrayList;
import java.util.HashMap;

public class DistributionGraph {

    private HashMap<String, ArrayList<String>> graph = new HashMap<>();

    public void addLocation(String location) {
        if (!graph.containsKey(location)) {
            graph.put(location, new ArrayList<>());
        }
    }

    public void addRoute(String from, String to) {

        addLocation(from);
        addLocation(to);

        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public void displayNetwork() {

        if (graph.isEmpty()) {
            System.out.println("No distribution routes added yet.");
            return;
        }

        System.out.println("\nMedicine Distribution Network:");

        for (String location : graph.keySet()) {

            System.out.print(location + " -> ");

            for (String connected : graph.get(location)) {
                System.out.print(connected + " ");
            }

            System.out.println();
        }
    }
}