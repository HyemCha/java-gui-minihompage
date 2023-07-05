package minihomepage.view.home;

import minihomepage.controller.HomeController;
import minihomepage.model.dao.Diary;
import minihomepage.model.dao.GuestBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;


// 로그아웃 상태일 때: 다이어리 사용범, 방명록 사용법 띄우기
public class HomeTable extends JPanel {
    private JPanel diaryPanel, guestBookPanel;
    private JScrollPane diaryScroll, guestBookScroll;
    public JTable diary, guestBook;
    private JButton diaryMore, guestBookMore;
    Vector<String> diaryVector, guestBookVector;
    public DefaultTableModel diaryModel, guestBookModel;
//    private Vector<String> diaryVector, guestBookVector;
    SimpleDateFormat simpleDateFormat;

    public HomeTable() {
        simpleDateFormat = new SimpleDateFormat("yy년 MM월 dd일 HH:mm");


        setPreferredSize(new Dimension(500, 250));

        diaryPanel = new JPanel(new BorderLayout());
        guestBookPanel = new JPanel(new BorderLayout());

        diaryPanel.setPreferredSize(new Dimension(230, 220));
        guestBookPanel.setPreferredSize(new Dimension(230, 220));

        diaryPanel.setBorder(BorderFactory.createTitledBorder("다이어리"));
        guestBookPanel.setBorder(BorderFactory.createTitledBorder("방명록"));

        add(diaryPanel);
        add(guestBookPanel);

        diary = new JTable(diaryModel);
        guestBook = new JTable(guestBookModel);

        diaryScroll = new JScrollPane(diary);
        guestBookScroll = new JScrollPane(guestBook);

        diaryScroll.setPreferredSize(new Dimension(220, 120));
        guestBookScroll.setPreferredSize(new Dimension(220, 120));
    }

    public void initComponents(List<Diary> diaryList, List<GuestBook> guestBookList) {
        diaryInit(diaryList);
        guestBookInit(guestBookList);

        diaryPanel.add(diaryScroll);
        guestBookPanel.add(guestBookScroll);

        diaryMore = new JButton("다이어리 더보기");
        guestBookMore = new JButton("방명록 더보기");

        diaryPanel.add(diaryMore, BorderLayout.SOUTH);
        guestBookPanel.add(guestBookMore, BorderLayout.SOUTH);
    }

    void diaryInit(List<Diary> diaryList) {
        diaryVector = new Vector<>();
        diaryVector.addElement("제목");
        diaryVector.addElement("날짜");
        diaryModel = new DefaultTableModel(diaryVector, 0) {
            public boolean isCellEditable(int r, int c) {
                return c != 0;
            }
        };

        diary.setModel(diaryModel);

        Vector<String> v;
        for (Diary d : diaryList) {
            v = new Vector<>();
            v.add(d.getTitle());
            v.add(d.getCreateAt() != null ? simpleDateFormat.format(d.getCreateAt()).toString() : null);
            diaryModel.addRow(v);
        }
    }

    void guestBookInit(List<GuestBook> guestBookList) {
        guestBookVector = new Vector<>();
        guestBookVector.addElement("제목");
        guestBookVector.addElement("날짜");
        guestBookModel = new DefaultTableModel(guestBookVector, 0) {
            public boolean isCellEditable(int r, int c) {
                return c != 0;
            }
        };

        guestBook.setModel(guestBookModel);

        Vector<String> v;
        for (GuestBook g : guestBookList) {
            v = new Vector<>();
            v.add(g.getContent());
            v.add(g.getCreateAt() != null ? simpleDateFormat.format(g.getCreateAt()).toString() : null);
            guestBookModel.addRow(v);
        }
    }

    public void addListener(HomeController listener) {
        diaryMore.addActionListener(listener);
        guestBookMore.addActionListener(listener);
    }
}
