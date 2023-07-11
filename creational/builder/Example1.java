package creational.builder;

class Product {
    private String property1;
    private int property2;
    private boolean property3;

    private Product() {
    }

    public String getProperty1() {
        return property1;
    }

    public int getProperty2() {
        return property2;
    }

    public boolean isProperty3() {
        return property3;
    }

    static class Builder {
        private String property1;
        private int property2;
        private boolean property3;

        public Builder setProperty1(String property1) {
            this.property1 = property1;
            return this;
        }

        public Builder setProperty2(int property2) {
            this.property2 = property2;
            return this;
        }

        public Builder setProperty3(boolean property3) {
            this.property3 = property3;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.property1 = this.property1;
            product.property2 = this.property2;
            product.property3 = this.property3;
            return product;
        }
    }

}

public class Example1 {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .setProperty1("value1")
                .setProperty2(10)
                .setProperty3(true)
                .build();

        System.out.println("Property1: " + product.getProperty1());
        System.out.println("Property2: " + product.getProperty2());
        System.out.println("Property3: " + product.isProperty3());
    }
}
