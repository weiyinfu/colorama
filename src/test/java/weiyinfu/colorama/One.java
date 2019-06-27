package weiyinfu.colorama;

class One {
public static void main(String[] args) {
    System.out.println(colorama.FORE.RED + "hello");
    System.out.println(colorama.FORE.YELLOW + "hello");
    System.out.println(colorama.FORE.GREEN + "hello");
    System.out.println(colorama.FORE.BLUE + "hello");
    System.out.println("hello");
    System.out.println(colorama.FORE.MAGENTA + "hello" + colorama.STYLE.RESET_ALL);
    System.out.println("hello");
}
}