import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       new SignUpFrame();
   //     new LoginFrame();
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
