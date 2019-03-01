import java.util.Objects;

public class Person {
    private int dd;
    private int mm;
    private int yy;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return dd == person.dd &&
                mm == person.mm &&
                yy == person.yy &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
//        return 1;
        return Objects.hash(mm);
//        return Objects.hash(dd, mm, yy, name);
    }

    public Person(int dd, int mm, int yy, String name) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
        this.name = name;
    }
}
