package model;

public class Product {
    public Product(Long productId) {
        this.productId = productId;
    }

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
