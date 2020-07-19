package map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class MergeMap {

    public static void main(String[] args) {
        Map<SearchKey, Product> productMap = getProductMap();
        Map<SearchKey, Price> priceMap = getPriceMap();

        List<Invoice> invoices = merge(priceMap, productMap);
        invoices.forEach(System.out::println);
    }

    private static List<Invoice> merge(Map<SearchKey, Price> priceMap, Map<SearchKey, Product> productMap) {
        List<Invoice> invoices = new ArrayList<>();

        for (Map.Entry<SearchKey, Product> entry : productMap.entrySet()) {
            SearchKey key = entry.getKey();

            if (priceMap.containsKey(key)) {
                Price price = priceMap.get(key);
                Product product = productMap.get(key);

                Invoice invoice = new Invoice();

                invoice.setId(key.getId());
                invoice.setProductName(product.getProductName());
                invoice.setProductDesc(product.getProductDesc());
                invoice.setPrice(price.getProductPrice());
                invoice.setQuantity(price.getProductQuantity());

                invoices.add(invoice);
            }
        }
        return invoices;
    }

    private static Map<SearchKey, Price> getPriceMap() {
        Map<SearchKey, Price> result = new HashMap<>();

        SearchKey key1 = new SearchKey(101, "Id");
        Price price1 = new Price(101, 50000.0, 1);
        result.put(key1, price1);

        SearchKey key2 = new SearchKey(102, "Id");
        Price price2 = new Price(102, 500.0, 2);
        result.put(key2, price2);

        SearchKey key3 = new SearchKey(103, "Id");
        Price price3 = new Price(103, 1500.0, 1);
        result.put(key3, price3);

        SearchKey key4 = new SearchKey(104, "Id");
        Price price4 = new Price(104, 25000.0, 1);
        result.put(key4, price4);

        return result;
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

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class SearchKey {
        private int id;
        private String idType;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SearchKey searchKey = (SearchKey) o;
            return id == searchKey.id &&
                    Objects.equals(idType, searchKey.idType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, idType);
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Price {
        private int id;
        private Double productPrice;
        private int productQuantity;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Product {
        private int id;
        private String productName;
        private String productDesc;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Invoice {
        private int id;
        private String productName;
        private String productDesc;
        private Double price;
        private int quantity;
    }
}


