import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Main implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel headingText;
    private JLabel descriptionText;
    private JLabel statusTitleText;
    private JLabel statusValueText;
    private JButton toggleButton;
    private AutoClicker clicker;

    public Main() {
        // AutoClicker
        clicker = new AutoClicker(false);

        // Frame and Panel
        frame = new JFrame();
        panel = new JPanel();

        // Text
        headingText = new JLabel("Red's AutoClicker");
        headingText.setFont(new Font(headingText.getName(), Font.PLAIN, 24));
        headingText.setForeground(Color.white);

        descriptionText = new JLabel("Press the button to start/stop");
        descriptionText.setBorder(BorderFactory.createEmptyBorder(-20, 0,0,0));
        descriptionText.setForeground(Color.lightGray);

        statusTitleText = new JLabel("Status");
        statusTitleText.setForeground(Color.white);
        statusTitleText.setFont(new Font(headingText.getName(), Font.PLAIN, 12));

        statusValueText = new JLabel("Stopped");
        statusValueText.setForeground(Color.red);
        statusValueText.setBorder(BorderFactory.createEmptyBorder(-24, 0, 0 ,0));

        // Toggle auto-clicker button
        toggleButton = new JButton("Turn On");
        toggleButton.setForeground(Color.white);
        toggleButton.setContentAreaFilled(false);
        toggleButton.setFocusPainted(false);
        toggleButton.addActionListener(this);

        // Setup Panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10 ,25));
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(0, 1));
        panel.add(headingText);
        panel.add(descriptionText);
        panel.add(statusTitleText);
        panel.add(statusValueText);
        panel.add(toggleButton);

        // Setup Frame
        frame.add(panel, BorderLayout.BEFORE_FIRST_LINE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setTitle("Red's AutoClicker");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Toggle running state
        if (!clicker.isRunning()) {
            toggleButton.setText("Turn Off");
            statusValueText.setText("Running");
            statusValueText.setForeground(Color.green);
            clicker.start();
        } else {
            toggleButton.setText("Turn On");
            statusValueText.setText("Stopped");
            statusValueText.setForeground(Color.red);
            clicker.stop();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}