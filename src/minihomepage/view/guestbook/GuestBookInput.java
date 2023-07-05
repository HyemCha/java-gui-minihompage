package minihomepage.view.guestbook;

import minihomepage.controller.GuestBookController;

import javax.swing.*;
import java.awt.*;

public class GuestBookInput extends JPanel {
    public JTextField name, content;
    public JButton writeBtn;
    public GuestBookInput() {
        setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {
        name = new JTextField();
        name.setColumns(6);
        add(name, BorderLayout.WEST);

        content = new JTextField();
        content.setColumns(26);
        add(content);

        writeBtn = new JButton("방명록 쓰기");
        add(writeBtn, BorderLayout.EAST);
    }

    public void addListener(GuestBookController listener) {
        writeBtn.addActionListener(listener);
    }
}
