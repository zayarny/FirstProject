import org.junit.jupiter.api.Test;

public class OrderObjectPractice {
    @Test
    public void workingWithOrder() {
        Order firstOrder = new Order();

        firstOrder.setTotalPrice(12.34);
        firstOrder.setAddress("Rigas str. 32");
        firstOrder.setItemCount(9);

        System.out.println("Hello");
        System.out.println("First Order");
        System.out.println(firstOrder.getTotalPrice());
    }

}
