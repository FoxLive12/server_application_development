public class OneThread extends Thread {

    private Funs funs;

    public OneThread(Funs funs) {
        this.funs = funs;
    }

    @Override
    public void run() {
        funs.plus();
    }

}
