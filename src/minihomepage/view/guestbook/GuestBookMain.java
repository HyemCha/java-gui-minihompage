package minihomepage.view.guestbook;

import minihomepage.controller.GuestBookController;
import minihomepage.model.dao.GuestBook;
import minihomepage.model.dao.User;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class GuestBookMain extends JPanel {
    public GuestBookList scroll;
    public GuestBookInput input;
    public GuestBookMain() {
        setLayout(new BorderLayout());

        scroll = new GuestBookList();
        scroll.setPreferredSize(new Dimension(500, 380));
        add(scroll);

        input = new GuestBookInput();
        add(input, BorderLayout.SOUTH);
    }

    public void initGuestBook(Vector<GuestBook> vector) {
        scroll.initComponents(vector);
    }

    public void addActionListener(GuestBookController listener) {
        input.addListener(listener);
        scroll.addMouseListener(listener);
    }

    public void checkUserAndHost(User user, User host) {
//        if (user.getId() != host.getId()) {
//            input.content.setEnabled(true);
//            input.writeBtn.setEnabled(true);
//        }else{
//            input.content.setEnabled(false);
//            input.writeBtn.setEnabled(false);
//        }
    }
}
