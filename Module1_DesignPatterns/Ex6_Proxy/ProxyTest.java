package proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Image photo = new ProxyImage("vacation_photo.jpg");

        System.out.println("First display call:");
        photo.display();   // loads from server

        System.out.println("\nSecond display call:");
        photo.display();   // served from cache

        System.out.println("\nThird display call:");
        photo.display();   // served from cache again
    }
}
