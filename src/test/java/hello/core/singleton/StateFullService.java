package hello.core.singleton;

public class StateFullService {
    private int price; // 상태를 유지하는 필드
    public void order(String name, int price){
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price; // 상태를 지정
    }

//
//     stateless
//    public int order(String name, int price){
//        System.out.println("name = " + name);
//        System.out.println("price = " + price);
//        return price;
//    }

    public int getPrice(){
        return price;
    }
}
