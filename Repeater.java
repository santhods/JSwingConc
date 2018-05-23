import javax.swing.*;

public class Repeater extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
            while (!isCancelled()) {
                System.out.println("Repeater is running");
                Thread.sleep(1000);
            }
            return null;
    }

    @Override
    protected void done() {
        System.out.println("Repeater is stopped");
        this.cancel(false);
    }
}
