class Main{ 
    public void processInvoice(String rawData) {
        String[] data = rawData.split(",");

        String invoiceNum = data[0];
        String itemName = data[1];

        double price = Double.parseDouble(data[2]);
        int quantity = Integer.parseInt(data[3]);
          


        double totalCost = price * quantity;

        System.out.println("Invoice: " + invoiceNum);
        System.out.println("Item: " + itemName);
        System.out.println("Price: Rs " + price);
        System.out.println("Quantity: " + quantity);
       


        System.out.println("Total Cost: Rs " + totalCost);
    }
}

public class InvoiceParser {
    public static void main(String[] args) {
        Main parser = new Main();
        String rawLine = "INV_2026,Laptop,1200.50,2";

        parser.processInvoice(rawLine);
    }
}
