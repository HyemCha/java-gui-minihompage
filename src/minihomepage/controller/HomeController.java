package minihomepage.controller;

import minihomepage.model.ModelMain;
import minihomepage.model.dao.Diary;
import minihomepage.model.dao.GuestBook;
import minihomepage.model.dao.User;
import minihomepage.view.home.HomeMain;
import minihomepage.view.structure.Categories;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeController implements ActionListener, MouseListener {
    public User user;
    public ResultSet diaryRs, guestBookRs = null;
    public Map<String, ResultSet> map;
    public List<Diary> diaryList;
    public List<GuestBook> guestBookList;
    public Diary diary;
    public GuestBook guestBook;
    ModelMain model;
    public HomeMain homeMain;
    public Categories categories;
    String cmd;
    SimpleDateFormat simpleDateFormat;

    public HomeController(ProfileController profileController) {
        this.model = profileController.model;
        this.user = profileController.user;
        this.categories = profileController.view.tabbedPane;
        this.homeMain = profileController.view.tabbedPane.home;

        simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
    }

    public void logIn(User user) {
        this.user = user;
        setHome();
    }
    public void logOut(User user) {
        this.user = user;
        homeMain.table.diaryModel.setRowCount(0);
        homeMain.table.guestBookModel.setRowCount(0);
    }

    public void setHome() {
        map = model.selectHome(user.getId());
        diaryRs = map.get("diary");
        guestBookRs = map.get("guestBook");

        diaryList = new ArrayList<>();
        try {
            while (diaryRs.next()) {
                diary = new Diary();
                diary.setUserId(diaryRs.getInt(2));
                diary.setTitle(diaryRs.getString(3));
                diary.setImgUrl(diaryRs.getString(4));
                diary.setCreateAt(diaryRs.getTimestamp(6));

                diaryList.add(diary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        guestBookList = new ArrayList<>();
        try {
            while (guestBookRs.next()) {
                guestBook = new GuestBook();
                guestBook.setUserId(guestBookRs.getInt(2));
                guestBook.setContent(guestBookRs.getString(3));
                guestBook.setCreateAt(guestBookRs.getTimestamp(4));

                guestBookList.add(guestBook);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        homeMain.initHome(diaryList, guestBookList);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();
        System.out.println("LOG::HomeController-79::" + cmd);
        switch (cmd) {
            case "다이어리 더보기" -> {
                categories.setSelectedIndex(1);
            }
            case "방명록 더보기" -> {
                categories.setSelectedIndex(2);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("LOG::HomeController-83::" + e.getSource());
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
