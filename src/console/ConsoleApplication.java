package console;

import service.UserService;
import storage.JDBCUserStorage;

import static console.ConsoleReader.readInt;
import static console.ConsoleReader.readString;
import static console.ConsoleWriter.write;

public class ConsoleApplication {
    UserService userService = new UserService();
    JDBCUserStorage jdbcUserStorage = new JDBCUserStorage();

    public void run() {
        while (true) {
            write("Hello User enter operation");
            write("1 - createUser, 2 - findUser, 3 - deleteUser, 4 - Exit");
            switch (readInt()) {
                case 1:
                    create();
                    continue;
                case 2:
                    write("1 - byFirstName, 2 - bySecondName,\n 3 - byEmail, 4 - byPhone,\n 5 - deleteAll, 6 - Back");
                    switch (readInt()) {
                        case 1:
                            write("Enter firstName for search");
                            write(jdbcUserStorage.findByFirstName(readString()).toString());
                            continue;
                        case 2:
                            write("Enter secondName for search");
                            write(jdbcUserStorage.findBySecondName(readString()).toString());
                            continue;
                        case 3:
                            write("Enter email for search");
                            write(jdbcUserStorage.findByEmail(readString()).toString());
                            continue;
                        case 4:
                            write("Enter phone for search");
                            write(jdbcUserStorage.findByPhone(readString()).toString());
                            continue;
                        case 5:
                            write(jdbcUserStorage.findAll().toString());
                            continue;
                        case 6:
                            break;
                    }
                    continue;
                case 3:
                    write("1 - ByFirstName, 2 - BySecondName,\n 3 - ByEmail, 4 - ByPhone,\n 5 - deleteAll, 6- Back");
                    switch (readInt()) {
                        case 1:
                            write("enter FirstName");
                            jdbcUserStorage.deleteByFirstName(readString());
                            write("User delete!!!");
                            continue;
                        case 2:
                            write("enter SecondName");
                            jdbcUserStorage.deleteBySecondName(readString());
                            write("User delete!!!");
                            continue;
                        case 3:
                            write("enter email");
                            jdbcUserStorage.deleteByEmail(readString());
                            write("User delete!!!");
                            continue;
                        case 4:
                            write("enter Phone");
                            jdbcUserStorage.deleteByPhone(readString());
                            write("User delete!!!");
                            continue;
                        case 5:
                            jdbcUserStorage.deleteAll();
                            write("All Users DELETE!!!");
                            continue;
                        case 6:
                            break;
                    }
                    continue;
                case 4:
                    return;
            }
        }
    }

    public void create() {
        write("Enter firstName");
        String firstName = readString();
        write("Enter SecondName");
        String secondName = readString();
        write("Enter email");
        String email = readString();
        write("Enter phone");
        String phone = readString();
        userService.create(firstName, secondName, email, phone);
    }
}
