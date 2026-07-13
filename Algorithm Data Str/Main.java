import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id)
                return p;
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id)
                return products[mid];
            else if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Laptop", "Electronics"),
                new Product(101, "Phone", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Watch", "Accessories"),
                new Product(104, "Bag", "Travel")
        };

        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, 102);
        if (result1 != null)
            result1.display();
        else
            System.out.println("Product Not Found");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\nBinary Search:");
        Product result2 = binarySearch(products, 102);
        if (result2 != null)
            result2.display();
        else
            System.out.println("Product Not Found");

        System.out.println("\nAnalysis");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Binary Search is faster for sorted data.");
    }
}