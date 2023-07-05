package minihomepage.controller;

import minihomepage.model.ModelMain;
import minihomepage.model.dao.Diary;
import minihomepage.model.dao.User;
import minihomepage.view.diary.DiaryMain;
import minihomepage.view.diary.form.DiaryCreate;
import minihomepage.view.diary.form.DiaryDetail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class DiaryController implements ActionListener, MouseListener {
    ModelMain model;
    public ResultSet rs = null;
    public User user, host;
    private Diary diary;
    public DiaryDetail diaryDetail;
    private Vector<Diary> diaryList;
    private Vector<String> diaryTitle = new Vector<>();
    public DiaryMain diaryMain;
    String cmd;
    private DiaryCreate createForm;
    private DiarySubController diarySubController;
    private DiaryDetailController diaryDetailController;
    SimpleDateFormat simpleDateFormat;



    public DiaryController(ProfileController profileController) {
        this.model = profileController.model;
        this.diaryMain = profileController.view.tabbedPane.diary;
        this.user = profileController.user;
        this.host = profileController.host;

        simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
    }

    public void setDiary() {
        diaryList = new Vector<>();
        rs = model.selectDiary(user.getId(), false);
        System.out.println("LOG::" + this.getClass().getSimpleName() + "-44::" + user.getId());
        try {
            while (rs.next()) {
                diary = new Diary();
                diary.setId(rs.getInt(1));
                diary.setUserId(rs.getInt(2));
                diary.setTitle(rs.getString(3));
                diary.setContent(rs.getString(4));
                diary.setImgUrl(rs.getString(5));
                diary.setCreateAt((rs.getTimestamp(6)));

                diaryTitle.add(diary.getTitle());
                diaryList.addElement(diary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        diaryMain.initDiaryDatas(diaryTitle, diaryList);
    }

    public void resetDiary() {
        diaryMain.dataTest.list.setVisibleRowCount(0);
        setDiary();
        diaryMain.dataTest.addListener(this);
    }


    int cnt = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();

        switch (cmd) {
            case "글쓰기": {
                if(cnt == 0){
                    cnt++;
                    System.out.println("LOG::DiaryController-65::" + cmd + "/" + cnt);
                    createForm = new DiaryCreate(user);
                    diarySubController = new DiarySubController(this, createForm, diaryDetail);
                    createForm.addListener(diarySubController);
                    break;
                }else{
                    cnt = 0;
                }
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        diaryMain.dataTest.
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
            System.out.println("LOG::DiaryController-86::" + (diaryMain.dataTest.list.getSelectedValue()));
            diaryDetail = new DiaryDetail((Diary) diaryMain.dataTest.list.getSelectedValue());
            diaryDetailController = new DiaryDetailController(this);
            diaryDetail.addListener(diaryDetailController);
        }
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

    public void logIn(User user) {
        this.user = user;
        setDiary();
    }

    public void logOut(User user) {
        this.user = user;
        diaryMain.dataTest.list.setVisibleRowCount(0);
        diaryMain.dataTest.model.clear();
    }
}
