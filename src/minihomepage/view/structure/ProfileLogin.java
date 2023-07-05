package minihomepage.view.structure;

import javax.swing.*;
import java.awt.*;

public class ProfileLogin extends JPanel {
    public JLabel idL, pwL;
    public JTextField id;
    public JPasswordField pwd;
    public ProfileLogin() {
        setLayout(new GridLayout(0, 2));
        idL = new JLabel("ID : ");
        id = new JTextField();
        pwL = new JLabel("PASSWORD : ");
        pwd = new JPasswordField();

        add(idL);
        add(id);
        add(pwL);
        add(pwd);
    }

    public void logOut() {
        setVisible(true);
        id.setText("");
        pwd.setText("");

    }

    public String getId() {
        return id.getText().toString();
    }

    public void setId(String t) {
        id.setText(t);
    }

    public String getPwd() {
        return pwd.getText();
    }

    public void setPwd(String t) {
        pwd.setText(t);
    }
}
