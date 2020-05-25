package java14.records;

public record Student(String name, int age) {

    public Student {
        if (age < 15 || age > 25) {
            throw new IllegalArgumentException("wrong age");
        }
    }
}
