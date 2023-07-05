package minihomepage.view.structure;

import minihomepage.controller.ProfileController;
import minihomepage.view.diary.DiaryMain;
import minihomepage.view.guestbook.GuestBookMain;
import minihomepage.view.home.HomeMain;

import javax.swing.*;

public class Categories extends JTabbedPane{
    public HomeMain home;
    public DiaryMain diary;
    public GuestBookMain guestBook;
    public Notice notice;

    public Categories() {
        setTabPlacement(JTabbedPane.RIGHT);

        home = new HomeMain();
        diary = new DiaryMain();
        guestBook = new GuestBookMain();

        notice = new Notice();
        addTab("공지사항", null, notice, "notice");
    }

    public void logIn() {
        removeAll();
        addTab("🏠홈", null, home, "Home");
        addTab("다이어리", null, diary, "Diary");
        addTab("방명록", null, guestBook, "Guest Book");
    }

    public void logOut() {
        removeAll();
        addTab("공지사항", null, notice, "notice");
    }

    public void addListener(ProfileController controller) {
        home.addListener(controller.homeController);
        diary.addListener(controller.diaryController);
        guestBook.addActionListener(controller.guestBookController);
    }
}
