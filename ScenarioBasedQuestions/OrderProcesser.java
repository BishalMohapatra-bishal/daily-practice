package ScenarioBasedQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.jar.Attributes.Name;

class InvalidOrderDataException extends Exception {
    public InvalidOrderDataException(String message) {
        super(message);
    }
}

public class OrderProcesser {
    
    public static Map<String, Double> processOrders(List<String> rawOrders) {
        Map<String, Double> aggregatedTotals = new HashMap<>();

        for (String rawLine : rawOrders) {
            try {
                OrderLine item = parseLine(rawLine);

                double lineCost = item.quantity * item.unitPrice;
                aggregatedTotals.put(item.itemId, aggregatedTotals.getOrDefault(item.itemId, 0.0) + lineCost);
            } catch (InvalidOrderDataException e) {
                System.out.println("[SKIPPED INVALID ENTRY] " + e.getMessage() + " | Raw: \"" + rawLine + "\"");
            }
        }

        return aggregatedTotals;
    }

    private static OrderLine parseLine(String line) throws InvalidOrderDataException {
        if (line == null || line.trim().isEmpty()) {
            throw new InvalidOrderDataException("Empty or null line");
        }

        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new InvalidOrderDataException("Malformed row (expected 4 fields)");
        }

        String itemId = parts[0].trim();
        String itemName = parts[1].trim();

        if (itemId.isEmpty() || itemName.isEmpty()) {
            throw new InvalidOrderDataException("Missing Item ID or Name");
        }

        try {
            int quantity = Integer.parseInt(parts[2].trim());
            double unitPrice = Double.parseDouble(parts[3].trim());

            if (quantity <= 0 || unitPrice < 0) {
                throw new InvalidOrderDataException("Quantity must be positive and price cannot be negative");
            }

            return new OrderLine(itemId, itemName, quantity, unitPrice);
        } catch (NumberFormatException e) {
            throw new InvalidOrderDataException("Invalid number format for quantity or price");
        }
    }

    private static class OrderLine {
        String itemId;
        String itemName;
        int quantity;
        double unitPrice;

        OrderLine(String itemId, String itemName, int quantity, double unitPrice) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }
    }

    public static void main(String[] args) {
        List<String> rawInput = new ArrayList<>();
        rawInput.add("P101, Wireless Mouse, 2, 25.00");
        rawInput.add("P102, Mechanical Keyboard, 1, 80.00");
        rawInput.add("P101, Wireless Mouse, 1, 25.00");
        rawInput.add("P103, Gaming Monitor, -1, 200.00");
        rawInput.add("P104, USB Cable, abc, 10.00");
        rawInput.add("P102, Mechanical Keyboard, 2, 80.00");

        System.out.println("--- Processing Raw Orders ---");
        Map<String, Double> summary =processOrders(rawInput);

        System.out.println("\n--- Final Aggregated Summary ---");
        double grandTotal = 0.0;
        for (Map.Entry<String, Double> entry : summary.entrySet()) {
            System.out.println("Item ID: " + entry.getKey() + " | Total Revenue: $" + entry.getValue());
            grandTotal += entry.getValue();
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Grand Total: $" + grandTotal);

      }
}
