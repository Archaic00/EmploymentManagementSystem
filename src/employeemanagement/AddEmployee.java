package employeemanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class AddEmployee extends JFrame implements ActionListener {

    // Declaring Date ComboBoxes
    JComboBox<String> cbDay, cbMonth, cbYear;
    JComboBox<String> cbeducation;
    JLabel lblempId;
    RoundedButton addBtn, backBtn;
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(0, 30, 900, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(Color.red);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        tfname = new JTextField();
        tfname.setBounds(170, 150, 150, 30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name :");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        tffname = new JTextField();
        tffname.setBounds(550, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth :");
        labeldob.setBounds(50, 190, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        // Date of Birth dropdowns for day, month, and year
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        cbDay = new JComboBox<>(days);
        cbDay.setBounds(170, 190, 50, 30);
        add(cbDay);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cbMonth = new JComboBox<>(months);
        cbMonth.setBounds(230, 190, 60, 30);
        add(cbMonth);

        String[] years = new String[80];
        for (int i = 0; i < 80; i++) years[i] = String.valueOf(2023 - i);
        cbYear = new JComboBox<>(years);
        cbYear.setBounds(300, 190, 70, 30);
        add(cbYear);

        JLabel labelsalary = new JLabel("Salary :");
        labelsalary.setBounds(400, 190, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        tfsalary = new JTextField();
        tfsalary.setBounds(550, 190, 150, 30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address :");
        labeladdress.setBounds(50, 240, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(170, 240, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone :");
        labelphone.setBounds(400, 230, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        tfphone = new JTextField();
        tfphone.setBounds(550, 230, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(50, 290, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        tfemail = new JTextField();
        tfemail.setBounds(170, 290, 150, 30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education :");
        labeleducation.setBounds(400, 270, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        String courses[] = {"JSC", "SSC", "HSC", "BCS", "MSC", "PSD"};
        cbeducation = new JComboBox<>(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(550, 270, 150, 30);
        add(cbeducation);

        JLabel labelempId = new JLabel("Employee ID :");
        labelempId.setBounds(50, 340, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        lblempId = new JLabel("" + number);
        lblempId.setBounds(170, 340, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        addBtn = new RoundedButton("Add Details");
        addBtn.setBounds(200, 500, 200, 60);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("serif", Font.PLAIN, 20));
        addBtn.addActionListener(this);
        add(addBtn);

        backBtn = new RoundedButton("Back");
        backBtn.setBounds(500, 500, 200, 60);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("serif", Font.PLAIN, 20));
        backBtn.addActionListener(this);
        add(backBtn);

        // Add KeyListeners to each text field to handle Enter key press
        tfname.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tffname.requestFocus(); // Move to next field
                }
            }
        });

        tffname.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cbDay.requestFocus(); // Move to the day combo box
                }
            }
        });

        cbDay.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cbMonth.requestFocus(); // Move to the month combo box
                }
            }
        });

        cbMonth.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cbYear.requestFocus(); // Move to the year combo box
                }
            }
        });

        cbYear.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfsalary.requestFocus(); // Move to the salary field
                }
            }
        });

        tfsalary.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfaddress.requestFocus(); // Move to the address field
                }
            }
        });

        tfaddress.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfphone.requestFocus(); // Move to the phone field
                }
            }
        });

        tfphone.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tfemail.requestFocus(); // Move to the email field
                }
            }
        });

        tfemail.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cbeducation.requestFocus(); // Move to the education combo box
                }
            }
        });

        cbeducation.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addBtn.requestFocus(); // Move to the Add button
                }
            }
        });

        setSize(900, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String empId = lblempId.getText();

            String dob = cbDay.getSelectedItem() + " " + cbMonth.getSelectedItem() + " " + cbYear.getSelectedItem();

            if (!name.isEmpty() && !fname.isEmpty() && !salary.isEmpty() && !address.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !education.isEmpty()) {
                String filePath = "employees.txt";

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    String data = empId + "," + name + "," + fname + "," + dob + "," + salary + "," + address + "," + phone + "," + email + "," + education;
                    writer.write(data);
                    writer.newLine();
                    writer.flush();
                    JOptionPane.showMessageDialog(null, "Data stored successfully!");
                    setVisible(false);
                    new Home();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "An error occurred while storing data.");
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please provide all required info!");
            }
        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
