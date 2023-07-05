package minihomepage.view.diary;

import minihomepage.controller.DiaryController;
import minihomepage.model.dao.Diary;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

// 1. 날짜와 나머지 데이터를 따로 가져와 표시
// 2. 어색하지만 다같이 표시

public class DiaryDatas extends JScrollPane{
    public DefaultListModel getModel() {
        return model;
    }

    public void setModel(DefaultListModel model) {
        this.model = model;
    }

    public DefaultListModel model;
    public JList list;
    private Map<Diary, ImageIcon> imageMap;
    public DiaryDatas() {

    }

    void initComponents(Vector<String> diaryTitle, Vector<Diary> diaryList) {
        imageMap = createImageMap(diaryList);
        System.out.println("LOG::DiaryDatas-32::" + imageMap.size());
        list = new JList<>();
        model = new DefaultListModel<>();
//        for (String t : diaryTitle) {
//            model.addElement(t);
//        }

        for (Diary d : diaryList) {
            model.addElement(d);
        }

        list.setModel(model);
        list.setCellRenderer(new ImageRenderer(imageMap));

        setPreferredSize(new Dimension(500, 400));
        getViewport().add(list);
    }

    private Map<Diary, ImageIcon> createImageMap(Vector<Diary> diaryList) {
        Map<Diary, ImageIcon> map = new HashMap<>();
        try {
            for (Diary diary : diaryList) {
                map.put(diary, new ImageIcon(diary.getImgUrl()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }

    public void addListener(DiaryController listener) {
        list.addMouseListener(listener);
    }

    public void resetDiary() {

    }
}
