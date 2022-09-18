import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class SignUpFrame extends JFrame {
    String[] genders = {"Male", "Female"};
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] days = {"01", "02", "03","04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25","26", "27", "28", "29", "30", "31"};
    String[] years = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015","2016","2017","2018","2019","2020","2021","2022" };
    public SignUpFrame() {
        this.setSize(480, 650);
        this.setLocationRelativeTo(null);
        this.setTitle("Todo Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
//        this.dispose();

        this.add(new AllLabel("Sign up Form", 20, 5, 250, 30));

        this.add(new AllLabel("First Name: ", 50, 120, 100, 50));
        AllTextField firstNameText = new AllTextField(130, 120, 300, 50);
        this.add(firstNameText);


        this.add(new AllLabel("Last Name: ", 50, 170, 100, 50));
        AllTextField lastNameText = new AllTextField(130, 170, 300, 50);
        this.add(lastNameText);

        this.add(new AllLabel("Your Email: ",50, 220, 100, 50));
        AllTextField emailText = new AllTextField(130, 220, 300, 50);
        this.add(emailText);

        this.add(new AllLabel("re-enter Email: ",30, 270, 100, 50));
        AllTextField reEmailText = new AllTextField(130, 270, 300, 50);
        this.add(reEmailText);

        this.add(new AllLabel("New Password: ",30, 320, 100, 50));
        JPasswordField newPasswordText = new JPasswordField();
        this.add(newPasswordText);
        newPasswordText.setBounds(130, 320, 300, 50);

        this.add(new AllLabel("Gender: ",80, 370, 150, 50));
        AllComboBOx genderBox = new AllComboBOx(genders,130, 370, 120, 50);
        this.add(genderBox);
        AllTextField genderText = new AllTextField("  select sex",false,130, 370, 100, 50);
        this.add(genderText);

        this.add(new AllLabel("Birthday: ",65, 420, 100, 50));
        AllComboBOx monthBox = new AllComboBOx(months,130, 420, 90, 50);
        this.add(monthBox);
        AllTextField birthMonthText = new AllTextField(" month",false,130, 420, 90, 50);
        this.add(birthMonthText);

        AllComboBOx dayBox =new AllComboBOx(days,225, 420, 75, 50);
        this.add(dayBox);
        AllTextField birthdayText = new AllTextField(" day",false,225, 420, 75, 50);
        this.add(birthdayText);

        AllComboBOx yearBox = new AllComboBOx(years,305, 420, 85, 50);
        this.add(yearBox);
        AllTextField birthYearText = new AllTextField(" year",false,305, 420, 85, 50);
        this.add(birthYearText);

        this.add(new AllLabel("Already have account?",135, 470, 250,20));
        AllButton loginBtn = new AllButton("login now", 280, 470, 100, 20);
        this.add(loginBtn);

        AllButton signupBtn = new AllButton("Sign up",130,500,140, 40);
        this.add(signupBtn);


        this.setBackground(Color.white);


        genderBox.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               genderText.setText(genderBox.getSelectedItem().toString());
           }
        });


        dayBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                birthdayText.setText(dayBox.getSelectedItem().toString());
            }
        });

        monthBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                birthMonthText.setText(monthBox.getSelectedItem().toString());
            }
        });

        yearBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                birthYearText.setText(yearBox.getSelectedItem().toString());
            }
        });


        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!firstNameText.getText().equals("") &&
                        !lastNameText.getText().equals("") &&
                        !emailText.getText().equals("") &&
                        !reEmailText.getText().equals("") &&
                        !String.valueOf(newPasswordText.getPassword()).equals("") &&

                        !genderText.getText().equals("  select sex") &&
                        !birthdayText.getText().equals(" day") &&
                        !birthMonthText.getText().equals(" month") &&
                        !birthYearText.getText().equals(" year")
                ){
                    try {
                        FileWriter writer = new FileWriter("userInfo.txt", true);
                        writer.write(firstNameText.getText() + " " + lastNameText.getText() + "\n");
                        writer.write(emailText.getText() + " " + newPasswordText.getText() + "\n");
                        writer.write(genderText.getText() + " " + birthdayText.getText() + "/" + birthMonthText.getText() + "/" + birthYearText.getText() + "\n");
                        writer.close();
                        JOptionPane.showMessageDialog(null,"Information saved successfully!");

                    } catch (Exception err) {
                        System.out.println(err);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill up all information.");
                }
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                this.dispose();

            }


        });

    }
}
