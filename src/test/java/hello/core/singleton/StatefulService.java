package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드

    // 문제되는 코드
//    public void order(String name, int price){
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제!
//    }

    // stateless 한 코드
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

    public int getPrice() {
        return price;
    }
}
