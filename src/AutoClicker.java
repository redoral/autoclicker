import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.*;

public class AutoClicker {
    private Thread t;
    private boolean isRunning;

    // CONSTRUCTOR
    public AutoClicker(boolean isRunning) {
        this.isRunning = isRunning;
    }

    // METHODS
    public void start(){
        t = new Thread(() -> {
            try {
                this.setRunning(true);
                while (true) {
                    Thread.sleep(2000);
                    Robot r = new Robot();
                    int button = InputEvent.BUTTON1_DOWN_MASK;
                    r.mousePress(button);
                    System.out.println("Click");
                    Thread.sleep(100);
                    r.mouseRelease(button);

                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                }
            } catch (Exception e) {
                this.setRunning(false);
                System.out.println("Stopped clicker");
            }
        });

       t.start();
    }

    public void stop() {
        t.interrupt();
        this.setRunning(false);
    }

    // GETTERS AND SETTERS
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
