package christmas.domain;


import christmas.constant.Badge;
import christmas.constant.Product;
import christmas.customer.Customer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Pos {

    /// Fields

    /// Constructor
    Pos(Customer customer) {
        DiscountCalculator(customer);
    }

    /// Method
    public void DiscountCalculator(Customer customer) {
        System.out.println("<주문 메뉴>");

        // 상품별 합계
        long productTotalSum = 0;
        // 전체 합계
        long totalSum = 0;
        for (HashMap<String, Integer> orderMenu : customer.getOrderMenu()) {
            Set set = orderMenu.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String menu = it.next();
                Integer count = orderMenu.get(menu);
                System.out.println(menu + " " + count + "개");

                Long price = Product.findProductByName(menu.toString()).getPrice();

                productTotalSum = price.longValue() * count;
                totalSum += productTotalSum;
            }
        }

        System.out.println();
        System.out.println("<할인 전 총 주문 금액>");
        System.out.println(totalSum + "원");

        boolean isChampagne = false;
        if (totalSum > 120000) {
            isChampagne = true;
        }

        System.out.println();
        System.out.println("<증정 메뉴>");
        if (isChampagne) {
            System.out.println("샴페인 1개");
        } else {
            System.out.println("없음");
        }

        System.out.println();
        System.out.println("<혜택 내역>");

        int xmasDdayDiscountAmount = (customer.getVisitDay() * 100) * -1;
        // todo. 평일(일 ~ 목) 할인 = 디저트 메뉴 1개당 2023원 할인
        // todo. 주말(금 ~ 토) 할인 = 메인 2023원 할인
        // 별이 있는 날에는 총 주문 금액에서 1000원 할인
        int specialDayDiscountAmount = -1000;

        int totalDiscountAmount = xmasDdayDiscountAmount + specialDayDiscountAmount;

        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(totalDiscountAmount+"원");

        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalSum - totalDiscountAmount+"원");

        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        int checkBadge = totalDiscountAmount * -1;
        if (checkBadge > Badge.SANTA.getGoalPrice()) {
            System.out.println(Badge.SANTA.getBadgeName());
        } else if (checkBadge > Badge.TREE.getGoalPrice()) {
            System.out.println(Badge.TREE.getBadgeName());
        } else if(checkBadge > Badge.STAR.getGoalPrice()) {
            System.out.println(Badge.STAR.getBadgeName());
        } else {
            System.out.println("없음");
        }


    }

}
