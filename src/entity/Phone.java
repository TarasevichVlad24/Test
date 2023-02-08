package entity;

public class Phone {
    private final String phones;

    public Phone(String phones){
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phones='" + phones + '\'' +
                '}';
    }
}
