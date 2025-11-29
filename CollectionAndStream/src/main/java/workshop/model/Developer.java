package workshop.model;

import java.util.Map;

public record Developer(String name, int age) {

    public Developer(Map.Entry<String, Integer> entry) {
        this(entry.getKey(), entry.getValue());
    }
}
