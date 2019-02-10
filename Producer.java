import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Producer implements Runnable {

    private ArrayList<Integer> arrayList;


    public Producer(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        while(true){

            synchronized (arrayList){

                while(arrayList.size() > 100){
                    try{
                        arrayList.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                int var = random.nextInt();
                System.out.println("Value produced: " + var);
                arrayList.add(var);

                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                arrayList.notifyAll();
            }
        }

    }
}
