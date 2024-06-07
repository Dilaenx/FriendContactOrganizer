import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addSuccessfully {

    public  void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customer Management System");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JLabel label = new JLabel("Contact Added Successfully...");
            label.setHorizontalAlignment(JLabel.CENTER);
            frame.add("Center", label);

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose(); // Close the window
                }
            });
            timer.setRepeats(false);

            timer.start();

            frame.setLocationRelativeTo(null); // Center the frame

            frame.setVisible(true);
        });
    }
}
