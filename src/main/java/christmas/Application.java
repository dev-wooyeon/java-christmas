package christmas;


import christmas.app.Main;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Main main = new Main(new OutputView(), new InputView());
        main.enter();
    }
}
