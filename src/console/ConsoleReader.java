package console;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);


    public static String readString() {
        return scanner.next();
    }
    public static int readInt(){
        return scanner.nextInt();
    }
}