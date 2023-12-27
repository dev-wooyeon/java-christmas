package christmas.domain;


import christmas.customer.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class EventPlaner {

    /// Fields
    private static final String EMPTY_SPACE = " ";
    private static final String REMOVE = "";

    /// Constructor
    EventPlaner() {

        // 고객 등장 두둥
        Customer customer = new Customer();

        // 인사박고 예상 방문 날짜 캐내기!
        welcome(customer);

        // 주문멘트하고 주문하는 메뉴 받아오기!
        orderMenu(customer);

        // 혜택 미리 보기 보여주기!
        new Pos(customer);

    }

    /// Method
    private void welcome(Customer customer) {

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        inputVisitDay(customer);
    }

    private void inputVisitDay(Customer customer) {

        String orderday = readLine();

        customer.setVisitDay(Integer.parseInt(orderday));
    }


    private void orderMenu(Customer customer) {

        System.out.print("주문하실 메뉴와 개수를 알려 주세요. ");
        System.out.println("(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        inputOrderMenu(customer);
    }


    private void inputOrderMenu(Customer customer) {

        String orderMenu = readLine();

        String[] splitOrderMenus = orderMenu.split(",");

        List<HashMap<String, Integer>> orderMeneList = new ArrayList<>();

        for (String splitOrderMenu : splitOrderMenus) {
            String[] order = splitOrderMenu.split("-");
            String menu = order[0];
            Integer count = Integer.parseInt(order[1]);

            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put(menu, count);
            orderMeneList.add(hashMap);
        }

        customer.setOrderMenu(orderMeneList);
    }

    private String removeEmptySpace(String input) {
        return input.replace(EMPTY_SPACE, REMOVE);
    }

}
