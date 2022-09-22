import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginFrame extends JFrame {
    boolean isMatched = false;
    public LoginFrame(){


        AllButton loginBtn = new AllButton("Login",130,340,140, 40);
        this.add(loginBtn);

        AllButton signupBtn = new AllButton("Sign up now", 280, 320, 100, 20);
        this.add(signupBtn);

        this.add(new AllLabel("Login Form", 50, 50, 250, 30));

        this.add(new AllLabel("Your Email: ",50, 220, 100, 50));
        AllTextField emailText = new AllTextField(130, 220, 300, 50);
        this.add(emailText);

        this.add(new AllLabel("Password: ",50, 270, 100, 50));
        JPasswordField passwordText = new JPasswordField();
        this.add(passwordText);
        passwordText.setBounds(130, 270, 300, 50);

        this.add(new AllLabel("Have no account?",135, 320, 250,20));
        this.add(new AllLabel(" ",135, 320, 250,20));


        this.setSize(480, 650);
        this.setLocationRelativeTo(null);
        this.setTitle("Todo Application");
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpFrame signUpFrame = new SignUpFrame();
                signUpFrame.show();
                dispose();
            }
        });


        ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!emailText.getText().equals("") &&
                        !String.valueOf(passwordText.getPassword()).equals(""))
                {
                    try{
                        File file  = new File("userInfo.txt");
                        Scanner fileReader = new Scanner(file);

                        while(fileReader.hasNext())
                        {
                            usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next()));
                        }

                        for(UserInformation user : usersInfo){
                            System.out.println(user.email + " " + user.password);
                            if(user.email.equals(emailText.getText()) && user.password.equals(String.valueOf(passwordText.getPassword()))){
                                isMatched = true;
                                JOptionPane.showMessageDialog(null, "Login successful!");
                                new ProfileFrame();
                                dispose();
                                break;
                            }

                        }

                        if(!isMatched){
                            JOptionPane.showMessageDialog(null, "Email or Password is not matched!");
                        }
                    }catch (Exception err){
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
    public UserInformation(String firstName, String lastName, String email, String password, String gender, String birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }
}

