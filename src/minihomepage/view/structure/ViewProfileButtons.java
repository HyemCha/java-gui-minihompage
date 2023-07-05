package minihomepage.view.structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewProfileButtons extends JPanel {
    private JButton logIn, logOut, signUp, lookAround;
    public ProfileLogin profileLogin;
    public ViewProfileButtons() {
        setLayout(new GridLayout(0, 1));
        initComponents();
        addComponents();
        logedOut();
    }

    void initComponents(){
        logIn = new JButton("로그인");
        logIn.setBackground(new Color(230, 231, 255));
        logOut = new JButton("로그아웃");
        signUp = new JButton("회원가입");
        lookAround = new JButton("구경하기");
        profileLogin = new ProfileLogin();
    }

    void addComponents() {
        add(profileLogin);
        add(logIn);
        add(signUp);
        add(logOut);
//        add(lookAround);
    }

    public void logedOut() {
        profileLogin.logOut();
//        profileLogin.setVisible(true);
        logIn.setVisible(true);
        signUp.setVisible(true);

        logOut.setVisible(false);
        lookAround.setVisible(false);
    }

    public void logedIn() {

        logOut.setVisible(true);
        lookAround.setVisible(true);

        profileLogin.setVisible(false);
        logIn.setVisible(false);
        signUp.setVisible(false);
    }

    public void addActionListener(ActionListener listener) {
        logIn.addActionListener(listener);
        signUp.addActionListener(listener);
        logOut.addActionListener(listener);
        lookAround.addActionListener(listener);
    }
}
