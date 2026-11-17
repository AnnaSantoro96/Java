package JavaBase.Generics.NumericStorage;

public class NumericStorage <T extends Number>{
    private T number;

    public NumericStorage(T number){
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
}
