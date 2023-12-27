package christmas.customer;


import java.util.HashMap;
import java.util.List;


public class Customer {

    Integer visitDay;

    List<HashMap<String, Integer>> orderMenu;


    public Integer getVisitDay() {
        return visitDay;
    }


    public void setVisitDay(Integer visitDay) {
        this.visitDay = visitDay;
    }


    public List<HashMap<String, Integer>> getOrderMenu() {
        return orderMenu;
    }


    public void setOrderMenu(List<HashMap<String, Integer>> orderMenu) {
        this.orderMenu = orderMenu;
    }
}
