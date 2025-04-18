package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername, tfpassword; // Declaring the text fields

    // Constructor
    Login() {
        // Setting the background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Showing text for username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        // Text input field for username
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        // Showing text for password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        // Text input field for password
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        // Showing button for login
        JButton login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Scale the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Adding the scaled image to the label
        image.setBounds(350, 0, 200, 200);
        add(image);

        // Showing the login screen
        setSize(600, 300);
        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        // Calculate the x and y coordinates to center the frame
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight - getHeight()) / 2;
        setLocation(x, y);
        setVisible(true);

        // Add KeyListener to handle Enter key presses for text fields
        tfusername.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfpassword.requestFocus(); // Move focus to the password field
                }
            }
        });

        tfpassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick(); // Simulate button click when Enter is pressed
                }
            }
        });
    }

    // On click action for the button
    public void actionPerformed(ActionEvent ae) {
        try {
            // Extracting the username and password from the fields
            String username = tfusername.getText();
            String password = tfpassword.getText();

            // Checking the username and password against a hardcoded string
            if (username.equals("Sakir1027") && password.equals("@Sakir1027")) {
                setVisible(false); // Set the visibility of the current frame to false
                new Home(); // Create a new instance of the Home frame
            } else {
                // Show an invalid message
                JOptionPane.showMessageDialog(null, "Invalid Username or Password....!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login(); // Create an instance of the Login class
    }
}
