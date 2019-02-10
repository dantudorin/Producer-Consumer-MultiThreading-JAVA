import java.util.ArrayList;

public class Consumer implements Runnable {

    private ArrayList<Integer> arrayList;
    private String threadName;

    public Consumer(ArrayList<Integer> arrayList, String threadName){

        this.arrayList = arrayList;
        this.threadName = threadName;

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        while(true){

            synchronized (arrayList){

                while(arrayList.isEmpty()){
                    try {
                        arrayList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int variable = arrayList.get(0);
                System.out.println("Value extracted: " + variable + "by " + this.threadName);
                arrayList.remove(0);

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
