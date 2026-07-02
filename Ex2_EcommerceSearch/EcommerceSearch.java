package ecommerce;

public class EcommerceSearch {

    public static void main(String[] args) {

        Product[] products = {
            new Product(5, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(8, "Headphones", "Electronics"),
            new Product(1, "T-Shirt", "Clothing"),
            new Product(4, "Watch", "Accessories"),
            new Product(3, "Backpack", "Bags"),
            new Product(7, "Phone", "Electronics"),
            new Product(6, "Sunglasses", "Accessories")
        };

        System.out.println("=== Linear Search ===");
        System.out.println("Searching for 'Headphones' by name...");
        Product found = LinearSearch.searchByName(products, "Headphones");
        System.out.println(found != null ? "Found: " + found : "Not found");

        System.out.println("Searching for product with ID 4...");
        Product foundById = LinearSearch.searchById(products, 4);
        System.out.println(foundById != null ? "Found: " + foundById : "Not found");

        Product[] sortedProducts = {
            new Product(1, "T-Shirt", "Clothing"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Backpack", "Bags"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Laptop", "Electronics"),
            new Product(6, "Sunglasses", "Accessories"),
            new Product(7, "Phone", "Electronics"),
            new Product(8, "Headphones", "Electronics")
        };

        System.out.println("\n=== Binary Search (sorted by ID) ===");
        System.out.println("Searching for product with ID 7...");
        Product binaryResult = BinarySearch.searchById(sortedProducts, 7);
        System.out.println(binaryResult != null ? "Found: " + binaryResult : "Not found");

        System.out.println("Searching for product with ID 10...");
        Product missing = BinarySearch.searchById(sortedProducts, 10);
        System.out.println(missing != null ? "Found: " + missing : "Not found");

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Linear Search  -> Best: O(1) | Average: O(n) | Worst: O(n)");
        System.out.println("Binary Search  -> Best: O(1) | Average: O(log n) | Worst: O(log n)");
        System.out.println("Binary search is better for large product catalogs.");
        System.out.println("But array must be sorted. For unsorted/dynamic data, use linear search.");
    }
}
