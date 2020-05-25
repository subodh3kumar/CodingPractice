package java14.switchexp;

import java.util.Scanner;

public class SwitchExpression {

    private static final String SUNDAY = "SUNDAY";
    private static final String MONDAY = "MONDAY";
    private static final String TUESDAY = "TUESDAY";
    private static final String WEDNESDAY = "WEDNESDAY";
    private static final String THURSDAY = "THURSDAY";
    private static final String FRIDAY = "FRIDAY";
    private static final String SATURDAY = "SATURDAY";

    public int traditionalSwitch(String day) {
        int result = 0;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                result = 6;
                break;
            case TUESDAY:
                result = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                result = 8;
                break;
            case WEDNESDAY:
                result = 9;
                break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
        return result;
    }

    public int newSwitchStatement(String day) {
        int result = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Unexpected value");
        };
        return result;
    }

    public static void newSwitchExprAssignment() {
    }
}

