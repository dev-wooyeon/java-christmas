package christmas.constant;

import java.util.Arrays;
import java.util.List;

import static christmas.constant.Product.*;

public enum Menu {
    에피타이저(List.of(양송이수프, 타파스, 시저샐러드)),
    메인(List.of(티본스테이크, 비비큐립, 해산물파스타, 크리스마스파스타)),
    음료(List.of(제로콜라, 레드와인, 샴페인)),
    디저트(List.of(아이스크림, 초코케이크));

    private final List<Product> products;

    Menu(List<Product> products) {
        this.products = products;
    }

    public static Menu findMenuTypeProduct(Product product) {
        return Arrays.stream(Menu.values())
                .filter(e -> e.findMatchedType(e.products, product.getName()))
                .findAny()
                .orElse(null);
    }

    private boolean findMatchedType(List<Product> products, String productName) {
        return products.stream()
                .anyMatch(e -> e.getName().equals(productName));
    }
}
