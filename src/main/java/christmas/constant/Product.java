package christmas.constant;

import java.util.Arrays;

public enum Product {
    양송이수프("양송이수프", 6_000L),
    타파스("타파스", 5_500L),
    시저샐러드("시저샐러드", 8_000L),
    티본스테이크("티본스테이크", 55_000L),
    비비큐립("바비큐립", 54_000L),
    해산물파스타("해산물파스타", 35_000L),
    크리스마스파스타("크리스마스파스타", 25_000L),
    초코케이크("초코케이크", 15_000L),
    아이스크림("아이스크림", 5_000L),
    제로콜라("제로콜라", 3_000L),
    레드와인("레드와인", 60_000L),
    샴페인("샴페인", 25_000L);

    private final String name;
    private final Long price;

    Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public static Product findProductByName(String name) {
        return Arrays.stream(values())
                .filter(e -> e.name.equals(name))
                .findAny()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
