package ecommerce;

public class BinarySearch {

    public static Product searchById(Product[] sortedProducts, int targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedProducts[mid].productId == targetId) {
                return sortedProducts[mid];
            }

            if (sortedProducts[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
