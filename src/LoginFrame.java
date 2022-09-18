import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class LoginFrame extends JFrame {

    public LoginFrame(){
        this.setSize(480, 650);
        this.setLocationRelativeTo(null);
        this.setTitle("Todo Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        this.add(new AllLabel("Login Form", 50, 50, 250, 30));

        this.add(new AllLabel("Your Email: ",50, 220, 100, 50));
        AllTextField emailText = new AllTextField(130, 220, 300, 50);
        this.add(emailText);

        this.add(new AllLabel("Password: ",50, 270, 100, 50));
        JPasswordField passwordText = new JPasswordField();
        this.add(passwordText);
        passwordText.setBounds(130, 270, 300, 50);

        this.add(new AllLabel("Have no account?",135, 320, 250,20));
        AllButton signupBtn = new AllButton("Sign up now", 280, 320, 100, 20);
        this.add(signupBtn);

        AllButton loginBtn = new AllButton("Login",130,340,140, 40);
        this.add(loginBtn);

        this.setBackground(Color.white);



        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!emailText.getText().equals("") &&
                        !String.valueOf(passwordText.getPassword()).equals(""))
                {
                    try{
                        File file  = new File("userInfo.txt");
                        Scanner fileReader = new Scanner(file);
                        boolean flag = true;
//                        boolean isMatched = false;
                        boolean isEmailMatched = false;
                        boolean isPasswordMatched = false;
                        String line;
                        while(fileReader.hasNextLine() && flag)
                        {
                            try{
                                line = fileReader.next();
                            }catch (Exception err){continue;}

//                            if(line.equals(emailText.getText()) &&
//                                    line.equals(String.valueOf(passwordText.getPassword()))){
//                                isMatched = true;
//                            }
                            if(line.equals(emailText.getText())){
                                isEmailMatched = true;
                                System.out.println("Email matched");
                            }

                            if(line.equals(String.valueOf(passwordText.getPassword()))){
                                isPasswordMatched = true;
                                System.out.println("Password matched");
                            }

                            if(isEmailMatched && isPasswordMatched){
                                System.out.println("Login Successful");
                                flag = false;
                            }

                        }

                        if(!isEmailMatched){
                            JOptionPane.showMessageDialog(null, "Email is not valid");
                        }
                        if(!isPasswordMatched){
                            JOptionPane.showMessageDialog(null, "Password is not valid");
                        }








                        /*
                        while(fileReader.hasNextLine() && flag){
                            try{
                                line = fileReader.next();
                            }catch(Exception err){continue;}

                            if(line.equals(emailText.getText())){

                                System.out.println("email matched");
                                if(line.equals(String.valueOf(passwordText.getPassword()))){
                                    System.out.println("password matched");
                                }else{
//                                    flag = false;
                                    JOptionPane.showMessageDialog(null, "Incorrect password.");
                                }
                                if(line.equals(emailText.getText()) && line.equals(String.valueOf(passwordText.getPassword()))){
                                    flag = false;
                                }
                            }else{
//                                flag = false;
                                JOptionPane.showMessageDialog(null,"There is no user with this email.Please signup first.");
                            }
                        }
                        */

                    }catch (Exception err){
                        System.out.println("Exception occurred");
                        System.out.println(e);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter your email and password.");
                }
            }
        });

    }

}


class UserInformation{
    String firstName;
    String lastName;
    String email;
    String password;
    String gender;
    String birthday;

    public UserInformation(String firstName, String lastName, String email, String password, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

}

