package minihomepage.view.home;

import minihomepage.controller.HomeController;
import minihomepage.model.dao.Diary;
import minihomepage.model.dao.GuestBook;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeMain extends JPanel {
    public HomeTable table;
    JPanel image;
    public HomeMain() {
        setLayout(new BorderLayout());
//        setPreferredSize(new Dimension(600, 500));

        image = new HomeImage();
        add(image, BorderLayout.NORTH);

        table = new HomeTable();
        add(table, BorderLayout.SOUTH);
    }

    public void initHome(List<Diary> diaryList, List<GuestBook> guestBookList) {
        table.initComponents(diaryList, guestBookList);
    }

    public void addListener(HomeController listener) {
        table.addListener(listener);
    }
}
