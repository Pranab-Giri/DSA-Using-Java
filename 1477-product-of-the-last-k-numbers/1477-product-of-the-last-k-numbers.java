import java.util.*;

class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1); // Initialize with 1 to handle multiplication
    }

    public void add(int num) {
        if (num == 0) {
            // Reset the prefix product list since any product including 0 is 0
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        } else {
            // Multiply the last prefix product by the new number
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k >= size) {
            return 0; // If k is larger than the available numbers, the product must be 0
        }
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
