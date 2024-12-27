import javax.swing.*;
import java.awt.*;

public class BouncingBallApp extends JFrame implements Runnable {
    private int x = 100;
    private int y = 100;
    private int diameter = 30;
    private int xSpeed = 10;
    private int ySpeed = 10;

    public BouncingBallApp() {
        this.setTitle("Bouncing Ball");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        Thread animationThread = new Thread(this);
        animationThread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Clear previous frame
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter); // Draw ball
    }

    @Override
    public void run() {
        while (true) {
            x += xSpeed; y += ySpeed;
            if (x <= 0 || x + diameter >= getWidth()) {
                xSpeed = -xSpeed; // Reverse
            }
            if (y <= 0 || y + diameter >= getHeight()) {
                ySpeed = -ySpeed; // Reverse
            }

            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
