import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int i = 100000;
    public static final int n = 100000;
    private static Funs funs;
    private static List<OneThread> incList;
    private static List<TwoThread> decList;

    public static void main(String[] args) {

        long m1 = System.currentTimeMillis();

        funs = new Funs();
        incList = new ArrayList<>();
        decList = new ArrayList<>();

        for (int i = 0; i < Application.i; i++) {
            OneThread threadInc = new OneThread(funs);
            incList.add(threadInc);
            threadInc.start();
            try {
                threadInc.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < n; j++) {
            TwoThread threadDec = new TwoThread(funs);
            decList.add(threadDec);

            threadDec.start();
            try {
                threadDec.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long m2 = System.currentTimeMillis();
        System.out.println(funs.getCount());
        System.out.println(m2-m1);
    }

}
