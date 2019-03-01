import java.util.Arrays;
import java.util.Objects;

public class PersonalData {
    private int prop1;
    private int prop2;
    private int[] ar1;
    private String str1;
    private String[] strArray;

    public PersonalData(int prop1, int prop2, int[] ar1, String str1, String[] strArray) {
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.ar1 = ar1;
        this.str1 = str1;
        this.strArray = strArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalData myObj = (PersonalData) o;
        return prop1 == myObj.prop1 &&
                prop2 == myObj.prop2 &&
                Arrays.equals(ar1, myObj.ar1) &&
                str1.equals(myObj.str1) &&
                Arrays.equals(strArray, myObj.strArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(prop1, prop2, str1);
        result = 31 * result + Arrays.hashCode(ar1);
        result = 31 * result + Arrays.hashCode(strArray);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "prop1=" + prop1 +
                ", prop2=" + prop2 +
                ", ar1=" + Arrays.toString(ar1) +
                '}';
    }
}
