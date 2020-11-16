public class TwoThread extends Thread {
    private Funs funs;


    public TwoThread(Funs funs) {
        this.funs = funs;
    }

    @Override
    public void run() {
        funs.minus();
    }

}
