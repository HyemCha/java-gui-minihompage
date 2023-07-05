package minihomepage.view.diary;

import minihomepage.controller.DiaryController;
import minihomepage.model.dao.Diary;
import minihomepage.model.dao.User;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class DiaryMain extends JPanel {
    public DiaryTable datas;
    public DiaryDatas dataTest;
    public DiaryButtons buttons;
    public DiaryMain() {
        setLayout(new BorderLayout());

        dataTest = new DiaryDatas();
        add(dataTest);

        buttons = new DiaryButtons();
        add(buttons, BorderLayout.SOUTH);
    }

    public void initDiaryDatas(Vector<String> title, Vector<Diary> diaryList) {
        dataTest.initComponents(title, diaryList);
    }

    public void addListener(DiaryController listener) {
        dataTest.addListener(listener);
        buttons.addListener(listener);
    }

    public void logIn(User user, User host) {
        if(user.getId() == host.getId()) {
            buttons.addBtn.setEnabled(true);
        }else{
            buttons.addBtn.setEnabled(false);
        }
    }

    public void logOut(){

    }
}
