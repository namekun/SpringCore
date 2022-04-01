package hello.core.singleton;

public class SingletonService {

    // static 영역에 객체를 한개만 생성
    private static final SingletonService instance = new SingletonService();

    // public 으로 열어서 객체 인스턴스가 필요하면 해당 메서드를 통해 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자를 통해서 외부에서 new 키워드를 사용한 객체생성을 막음.
    private SingletonService() {
    }

    private void logic(){
        System.out.println("call singleton instance");
    }
}
