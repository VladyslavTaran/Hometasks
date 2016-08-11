package week6.myHashTable;

/**
 * Created by Vladislav on 10.08.2016.
 */
public class KeyClass {
    String strField;
    int intField;
    float fltField;

    public KeyClass(String strField, int intField, float fltField) {
        this.strField = strField;
        this.intField = intField;
        this.fltField = fltField;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        KeyClass keyClass = (KeyClass) o;

        if (intField != keyClass.intField) return false;
        if (Float.compare(keyClass.fltField, fltField) != 0) return false;
        return strField != null ? strField.equals(keyClass.strField) : keyClass.strField == null;

    }

    @Override
    public int hashCode() {
        int result = strField != null ? strField.length() * 31 + strField.length() : 0;
        result = 31 * result + intField;
        result = 31 * result + (fltField != +0.0f ? Float.floatToIntBits(fltField) : 0);
        return result;
    }
}
