import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Shop {
    private ConcurrentHashMap<String, Integer> products;
    private final AtomicInteger salesAmount;
    private String topProduct;


    public Shop() {
        products = new ConcurrentHashMap<>();
        topProduct = "";
        products.put(topProduct, 0);
        salesAmount = new AtomicInteger(0);
    }

    public void put(String product) {
        if (products.contains(product)) {
            products.replace(product, products.get(product), products.get(product) + 1);
        }
        products.putIfAbsent(product, 1);
        topProduct = products.get(topProduct) > products.get(product) ? topProduct : product;
        salesAmount.incrementAndGet();
    }

    public void printProducts() {
        StringBuilder builder = new StringBuilder();
        for (String product : products.keySet()) {
            builder.append(product);
            builder.append("; ");
        }
        System.out.println(builder.substring(2));
    }

    public AtomicInteger getSalesAmount() {
        return salesAmount;
    }

    public String getTopProduct() {
        return topProduct;
    }
}
