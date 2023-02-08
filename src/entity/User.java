package entity;


import java.util.List;

public class User {

    private final String firstName;
    private final String secondName;
    private final String email;
    private final List<Phone> phones;


    public User(String firstName, String secondName, String email, List<Phone> phones) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phones = phones;

    }

    public List<Phone> getPhones() {
        return phones;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones  +
                '}'+ "\n";
    }
}
