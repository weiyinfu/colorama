package weiyinfu.colorama;

import java.lang.reflect.Field;

public class colorama {
final static String CSI = "\033[",
        OSC = "\033]",
        BEL = "\007";

private static String codeToChars(String code) {
    return CSI + code + "m";
}

public static String setTitle(String title) {
    return OSC + "2;" + title + BEL;
}

public static String clearScreen(Integer mode) {
    if (mode == null) mode = 2;
    return CSI + mode + "J";
}

public static String clearLine(Integer mode) {
    if (mode == null) mode = 2;
    return CSI + mode + "K";
}

static private void wrapWithAnsiColor(Object obj) {
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field field : fields) {
        try {
            field.set(obj, codeToChars(field.get(obj).toString()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

public static class AnsiCursor {
    String up(int n) {
        return CSI + n + "A";
    }

    String down(int n) {
        return CSI + n + "B";
    }

    String forward(int n) {
        return CSI + n + "C";
    }

    String back(int n) {
        return CSI + n + "D";
    }

    String pos(int x, int y) {
        return CSI + y + ";" + x + "H";
    }
}

public static class AnsiFore {
    public String BLACK = "30",
            RED = "31",
            GREEN = "32",
            YELLOW = "33",
            BLUE = "34",
            MAGENTA = "35",
            CYAN = "36",
            WHITE = "37",
            RESET = "39";
    //These are fairly well supported, but not part of the standard.
    public String LIGHTBLACK_EX = "90",
            LIGHTRED_EX = "91",
            LIGHTGREEN_EX = "92",
            LIGHTYELLOW_EX = "93",
            LIGHTBLUE_EX = "94",
            LIGHTMAGENTA_EX = "95",
            LIGHTCYAN_EX = "96",
            LIGHTWHITE_EX = "97";

    AnsiFore() {
        wrapWithAnsiColor(this);
    }
}

public static class AnsiBack {
    public String BLACK = "40",
            RED = "41",
            GREEN = "42",
            YELLOW = "43",
            BLUE = "44",
            MAGENTA = "45",
            CYAN = "46",
            WHITE = "47",
            RESET = "49";

    //These are fairly well supported, but not part of the standard.
    public String LIGHTBLACK_EX = "100",
            LIGHTRED_EX = "101",
            LIGHTGREEN_EX = "102",
            LIGHTYELLOW_EX = "103",
            LIGHTBLUE_EX = "104",
            LIGHTMAGENTA_EX = "105",
            LIGHTCYAN_EX = "106",
            LIGHTWHITE_EX = "107";

    AnsiBack() {
        wrapWithAnsiColor(this);
    }
}

public static class AnsiStyle {
    public String BRIGHT = "1",
            DIM = "2",
            NORMAL = "22",
            RESET_ALL = "0";

    AnsiStyle() {
        wrapWithAnsiColor(this);
    }
}

final public static AnsiFore FORE = new AnsiFore();
final public static AnsiBack BACK = new AnsiBack();
final public static AnsiStyle STYLE = new AnsiStyle();
final public static AnsiCursor CURSOR = new AnsiCursor();
}
