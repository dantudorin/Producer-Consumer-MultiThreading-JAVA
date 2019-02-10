import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Integer> arrayList = new ArrayList<>();

        Producer producer1 = new Producer((ArrayList<Integer>) arrayList);
        Producer producer2 = new Producer((ArrayList<Integer>) arrayList);
        Consumer consumer1 = new Consumer((ArrayList<Integer>) arrayList, "Consumer1");
        Consumer consumer2 = new Consumer((ArrayList<Integer>) arrayList,"Consumer2");
        Consumer consumer3 = new Consumer((ArrayList<Integer>) arrayList,"Consumer3");
        Consumer consumer4 = new Consumer((ArrayList<Integer>) arrayList,"Consumer4");



    }

}
