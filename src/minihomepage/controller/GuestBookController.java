package minihomepage.controller;

import minihomepage.model.ModelMain;
import minihomepage.model.dao.GuestBook;
import minihomepage.model.dao.User;
import minihomepage.view.guestbook.GuestBookMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GuestBookController implements ActionListener, MouseListener {
    public User user, host;
    public ResultSet rs = null;
    ModelMain model;
    private Vector<GuestBook> guestBookList;
    private GuestBook guestBook;
    public GuestBookMain guestBookMain;
    String cmd;
    String content;

    public GuestBookController(ProfileController profileController) {
        this.model = profileController.model;
        this.guestBookMain = profileController.view.tabbedPane.guestBook;
        this.user = profileController.user;
        this.host = profileController.host;
    }

    public void logIn(User user) {
        this.user = user;
        setGuestBook();
    }

    public void logOut(User user) {
        this.user = user;
        guestBookMain.scroll.model.setRowCount(0);
    }

    public void setGuestBook() {
        guestBookList = new Vector<>();
        System.out.println("LOG::" + this.getClass().getSimpleName() + "-49::" + user.getId());
        rs = model.selectGuestBook(user.getId(), false);
        try {
            while (rs.next()) {
                guestBook = new GuestBook();
//                guestBook.setId(rs.getInt(1));
                guestBook.setHostNickname(rs.getString(6));
                guestBook.setContent(rs.getString(3));
                guestBook.setCreateAt(rs.getTimestamp(4));
//                guestBook.setHostId(rs.getInt(6));

                guestBookList.add(guestBook);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        guestBookMain.initGuestBook(guestBookList);
    }

    public void resetGusetBook() {
        guestBookMain.scroll.model.setRowCount(0);
        setGuestBook();
        guestBookMain.input.name.setText("");
        guestBookMain.input.content.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();
        switch (cmd) {
            case "방명록 쓰기":{
                GuestBook guestBookDao = new GuestBook();
                guestBookDao.setUserId(user.getId());
                guestBookDao.setHostNickname(guestBookMain.input.name.getText());
                guestBookDao.setContent(guestBookMain.input.content.getText());
                content = guestBookMain.input.content.getText();
                System.out.println("LOG::GuestBookController-62::" + content);

                model.insertGuestBook(guestBookDao);
                resetGusetBook();
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
