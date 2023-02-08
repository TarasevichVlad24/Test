import console.ConsoleApplication;
import storage.JDBCUserStorage;

public class Main {
    public static void main(String[] args) {
        JDBCUserStorage jdbcUserStorage = new JDBCUserStorage();
        ConsoleApplication consoleApplication = new ConsoleApplication();
        consoleApplication.run();


    }
}