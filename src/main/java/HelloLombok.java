import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(123);
        helloLombok.setName("asdf");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
