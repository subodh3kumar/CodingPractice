package workshop;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TransformMapKey {

    public static void main(String[] args) {
        Map<SearchKey, Product> productMap = getProductMap();
        System.out.println("Map before key transformation");
        productMap.forEach((k, v) -> System.out.println("Key: " + k.toString() + ", Value: " + v.toString()));
        System.out.println("\nMap after key transformation");
        Map<Integer, Product> newProductMap = transform(productMap);
        newProductMap.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v.toString()));
    }

    private static Map<Integer, Product> transform(Map<SearchKey, Product> productMap) {
        return productMap.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey().id(), Map.Entry::getValue));
    }

    private static Map<SearchKey, Product> getProductMap() {
        Map<SearchKey, Product> result = new HashMap<>();

        SearchKey key1 = new SearchKey(101, "Id");
        Product product1 = new Product(101, "Computer", "HP Computer");
        result.put(key1, product1);

        SearchKey key2 = new SearchKey(102, "Id");
        Product product2 = new Product(102, "Book", "Computer Book");
        result.put(key2, product2);

        SearchKey key3 = new SearchKey(103, "Id");
        Product product3 = new Product(103, "Fan", "Ceiling fan");
        result.put(key3, product3);

        SearchKey key4 = new SearchKey(104, "Id");
        Product product4 = new Product(104, "Table", "Wooden table");
        result.put(key4, product4);

        return result;
    }

    private record SearchKey(int id, String idType) {
    }

    private record Price(int id, Double productPrice, int productQuantity) {
    }

    private record Product(int id, String productName, String productDesc) {
    }
}
