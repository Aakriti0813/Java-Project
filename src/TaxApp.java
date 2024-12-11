import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField income;
    private JTextField calculateNetIncome;
    private JTextField federalTax;
    private JTextField provincialTax;

    private static List<Person> sessionRecords = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TaxApp frame = new TaxApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TaxApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
        panel.setBounds(24, 23, 934, 111);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Financial Calculator Application");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblNewLabel.setBounds(68, 32, 801, 68);
        panel.add(lblNewLabel);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
        panel_1_1.setBackground(Color.LIGHT_GRAY);
        panel_1_1.setBounds(24, 639, 1328, 111);
        contentPane.add(panel_1_1);

        JPanel Person = new JPanel();
        Person.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
        Person.setBackground(Color.LIGHT_GRAY);
        Person.setBounds(173, 145, 650, 111);
        contentPane.add(Person);
        Person.setLayout(null);

        JLabel nametag = new JLabel("Name");
        nametag.setFont(new Font("Tahoma", Font.BOLD, 25));
        nametag.setBounds(10, 11, 129, 25);
        Person.add(nametag);

        name = new JTextField();
        name.setBounds(315, 17, 224, 20);
        Person.add(name);
        name.setColumns(10);

        JLabel provincetag = new JLabel("Province");
        provincetag.setFont(new Font("Tahoma", Font.BOLD, 25));
        provincetag.setBounds(10, 43, 193, 25);
        Person.add(provincetag);

        JLabel lblNewLabel_6_1 = new JLabel("Income Range");
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_6_1.setBounds(10, 72, 231, 25);
        Person.add(lblNewLabel_6_1);

        JComboBox<String> province = new JComboBox<>();
        province.setModel(new DefaultComboBoxModel<>(new String[] {
            "--Choose your Province--", "QC", "ON", "AB", "BC", "MB", "NB", "NS", "PEI", "SK"
        }));
        province.setBounds(315, 48, 224, 22);
        Person.add(province);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
        panel_3.setBackground(Color.LIGHT_GRAY);
        panel_3.setBounds(24, 432, 934, 118);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_5 = new JLabel("Tax Calculation");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_5.setBounds(24, 27, 267, 37);
        panel_3.add(lblNewLabel_5);

        JButton savePersonToFile = new JButton("Option 1");
        savePersonToFile.setFont(new Font("Tahoma", Font.BOLD, 11));
        savePersonToFile.setBounds(73, 75, 89, 23);
        panel_3.add(savePersonToFile);

        JLabel lblNewLabel_5_1 = new JLabel("Session Records");
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_5_1.setBounds(282, 27, 254, 37);
        panel_3.add(lblNewLabel_5_1);

        JButton displayPersonDetails = new JButton("Option 2");
        displayPersonDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
        displayPersonDetails.setBounds(351, 75, 89, 23);
        panel_3.add(displayPersonDetails);

        JLabel lblNewLabel_5_1_1 = new JLabel("End Program");
        lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_5_1_1.setBounds(741, 27, 172, 37);
        panel_3.add(lblNewLabel_5_1_1);

        JButton btnNewButton_1_1 = new JButton("Exit");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Financial Calculator Application",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1_1.setBounds(790, 75, 89, 23);
        panel_3.add(btnNewButton_1_1);

        JLabel lblNewLabel_5_1_2 = new JLabel("Reset");
        lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_5_1_2.setBounds(580, 27, 107, 37);
        panel_3.add(lblNewLabel_5_1_2);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                province.setSelectedIndex(0);
                income.setText("");
                calculateNetIncome.setText("");
                federalTax.setText("");
                provincialTax.setText("");
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnReset.setBounds(580, 75, 89, 23);
        panel_3.add(btnReset);

        JPanel panel_2_3 = new JPanel();
        panel_2_3.setBounds(24, 267, 934, 154);
        contentPane.add(panel_2_3);
        panel_2_3.setLayout(null);
        panel_2_3.setBorder(new LineBorder(SystemColor.activeCaption, 2, true));
        panel_2_3.setBackground(Color.LIGHT_GRAY);

        JLabel lblNewLabel_6_1_1 = new JLabel("Annual Income");
        lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6_1_1.setBounds(10, 16, 156, 25);
        panel_2_3.add(lblNewLabel_6_1_1);

        JLabel lblNewLabel_3_1_1 = new JLabel("Net Income");
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3_1_1.setBounds(10, 87, 156, 25);
        panel_2_3.add(lblNewLabel_3_1_1);

        JLabel lblNewLabel_1_1 = new JLabel("Federal Tax");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(496, 16, 129, 25);
        panel_2_3.add(lblNewLabel_1_1);

        JLabel lblNewLabel_6_2 = new JLabel("Provincial Tax");
        lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6_2.setBounds(498, 82, 150, 25);
        panel_2_3.add(lblNewLabel_6_2);

        income = new JTextField();
        income.setColumns(10);
        income.setBounds(183, 16, 235, 25);
        panel_2_3.add(income);

        calculateNetIncome = new JTextField();
        calculateNetIncome.setColumns(10);
        calculateNetIncome.setBounds(183, 87, 235, 25);
        panel_2_3.add(calculateNetIncome);

        federalTax = new JTextField();
        federalTax.setColumns(10);
        federalTax.setBounds(668, 17, 224, 25);
        panel_2_3.add(federalTax);

        provincialTax = new JTextField();
        provincialTax.setColumns(10);
        provincialTax.setBounds(668, 83, 224, 25);
        panel_2_3.add(provincialTax);

        // Implement the Tax Calculation button (Option 1)
        savePersonToFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve user input
                    String userName = name.getText();
                    String provinceInput = province.getSelectedItem().toString();
                    double userIncome = Double.parseDouble(income.getText());

                    // Calculate taxes
                    TaxCalculator federalCalculator = new FederalTaxCalculator();
                    TaxCalculator provincialCalculator = new ProvincialTaxCalculator();
                    double federalTaxAmount = federalCalculator.federalTaxes(userIncome);
                    double provincialTaxAmount = provincialCalculator.provincialTaxes(userIncome, provinceInput);
                    double netIncomeAmount = userIncome - federalTaxAmount - provincialTaxAmount;

                    // Display calculated values
                    federalTax.setText(String.format("%.2f", federalTaxAmount));
                    provincialTax.setText(String.format("%.2f", provincialTaxAmount));
                    calculateNetIncome.setText(String.format("%.2f", netIncomeAmount));

                    // Save person to session records
                    Person person = new Person(userName, userIncome, provinceInput);
                    person.setNet_income(netIncomeAmount);
                    sessionRecords.add(person);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid data.");
                }
            }
        });

        // Implement the Session Records button (Option 2)
        displayPersonDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder records = new StringBuilder();
                if (sessionRecords.isEmpty()) {
                    records.append("No session records available.");
                } else {
                    records.append("Session Records:\n\n");
                    for (Person person : sessionRecords) {
                        records.append("Name: ").append(person.getName()).append("\n");
                        records.append("Income: ").append(person.getIncome()).append("\n");
                        records.append("Province: ").append(person.getProvince()).append("\n");
                        records.append("Federal Tax: ").append(person.getFederalTaxes()).append("\n");
                        records.append("Provincial Tax: ").append(person.getProvincialTaxes()).append("\n");
                        records.append("Net Income: ").append(person.getNet_income()).append("\n\n");
                    }
                }
                JOptionPane.showMessageDialog(null, records.toString(), "Session Records", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Implement the Reset button
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                province.setSelectedIndex(0);
                income.setText("");
                calculateNetIncome.setText("");
                federalTax.setText("");
                provincialTax.setText("");
            }
        });
    }
}
