import javax.swing.JFrame;
import javax.swing.JLabel;

public class MarqueeStringApp extends JFrame implements Runnable {
    private Thread th;
    private JLabel jLabel;
    private int start = 0;

    public MarqueeStringApp() {
        jLabel = new JLabel();
        this.setTitle("Banner Application");
        jLabel.setText("Welcome to Java");
        this.add(jLabel);
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        do {
            try {
                jLabel.setBounds(start, 50, 100, 40);
                start = (start + 10) % this.getWidth();
                Thread.sleep(70);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
