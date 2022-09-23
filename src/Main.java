import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        new LoginFrame();
    }
}



class AllComboBOx extends JComboBox {
    public AllComboBOx (String[] info,int x, int y, int width, int height){
        this.setBounds(x,y ,width,height);
        for(int i=0;i<info.length;i++){
            this.addItem(info[i]);
        }
    }
}

class AllButton extends JButton {
    public AllButton(String btnName, int x, int y, int width, int height) {
        this.setText(btnName);
        this.setBounds(x,y,width,height);
    }
}
class AllLabel extends JLabel {
    public AllLabel(String text,int x, int y, int width, int height) {
        this.setBounds(x,y ,width,height);
        this.setText(text);
    }
}

class AllTextField extends JTextField {
    public AllTextField( int x, int y, int width, int height) {
        this.setBounds(x,y,width,height);
    }

    public AllTextField(String text, int x, int y, int width, int height) {
        this(x, y, width, height);
        this.setText(text);
    }

    public AllTextField(String text,boolean isEnable, int x, int y, int width, int height) {
        this(text, x, y, width, height);
        this.setEnabled(isEnable);
    }
}


class UserInformation{
    String firstName;
    String lastName;
    String email;
    String password;
    String gender;
    String birthday;
    String creatingTime;
    public UserInformation(String firstName, String lastName, String email, String password, String gender, String birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public UserInformation(String firstName, String lastName, String email, String password, String gender, String birthday, String createdTime){
        this(firstName, lastName, email, password, gender, birthday);
        this.creatingTime = createdTime;
    }
}