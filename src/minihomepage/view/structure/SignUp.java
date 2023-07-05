package minihomepage.view.structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
    public JPanel inputs;
    public JLabel email, nickname, pwd, profile, introduce;
    public JTextField emailTF, nicknameTF, pwdTF, introduceTF;
    public JButton profileBtn, saveBtn;

    public SignUp(ActionListener listener) {
        setTitle("회원가입");
        setVisible(true);
        setBounds(0, 0, 300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        inputs = new JPanel(new GridLayout(0, 2));
        add(inputs);
        inputs.setPreferredSize(new Dimension(400, 00));

        email = new JLabel("이메일:");
        nickname = new JLabel("닉네임:");
        pwd = new JLabel("비밀번호:");
        profile = new JLabel("");
        introduce = new JLabel("소개:");

        emailTF = new JTextField();
        nicknameTF = new JTextField();
        pwdTF = new JTextField();
        introduceTF = new JTextField();

        inputs.add(email);
        inputs.add(emailTF);
        inputs.add(nickname);
        inputs.add(nicknameTF);
        inputs.add(pwd);
        inputs.add(pwdTF);
        inputs.add(introduce);
        inputs.add(introduceTF);

        profileBtn = new JButton("프로필");
        inputs.add(profileBtn);
        inputs.add(profile);

        saveBtn = new JButton("확인");
        add(saveBtn, BorderLayout.SOUTH);

        addListener(listener);
    }

    public void addListener(ActionListener listener) {
        profileBtn.addActionListener(listener);
        saveBtn.addActionListener(listener);
    }

}
