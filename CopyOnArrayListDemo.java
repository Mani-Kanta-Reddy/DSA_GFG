import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListDemo extends Thread {
    public static CopyOnWriteArrayList<Integer> intList = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        CopyOnArrayListDemo myThread = new CopyOnArrayListDemo();
        intList.add(1);
        intList.add(2);
        intList.add(55);
        intList.add(4);
        myThread.start();
        Iterator<Integer> listItr = intList.listIterator();
        while(listItr.hasNext()) {
            System.out.println(listItr.next());
            Thread.sleep(300);
        }
        myThread.join();
        System.out.println(intList);
    }
    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch(InterruptedException e) {

        }
        intList.add(5);
        intList.remove(Integer.valueOf("2"));
    }
}
