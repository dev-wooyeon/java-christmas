package christmas.util;

public final class ErrorManager {

    /// Fields
    private static final String PREFIX = "[ERROR] ";
    public static final String INVALID_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String INVALID_DATE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    /// Constructor
    private ErrorManager() {
    }

    /// Method
    public static String getText(String errorMessage) {
        return PREFIX + errorMessage;
    }
}
