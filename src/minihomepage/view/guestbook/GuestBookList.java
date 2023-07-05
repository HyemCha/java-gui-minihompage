package minihomepage.view.guestbook;

import minihomepage.model.dao.GuestBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class GuestBookList extends JScrollPane {
    public DefaultTableModel model;
    public JTable table;
    private Vector<String> vector;
    SimpleDateFormat simpleDateFormat;

    public GuestBookList() {
        table = new JTable();

        simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh:mm");
    }

    public void initComponents(Vector<GuestBook> guestBookList) {
        vector = new Vector<>();
        vector.addElement("닉네임");
        vector.addElement("내용");
        vector.addElement("날짜");
        model = new DefaultTableModel(vector, 0){
            public boolean isCellEditable(int r, int c) {
                return c != 0;
            }
        };

        table.setModel(model);
        getViewport().add(table);
        Vector<String> v;
        for (GuestBook g : guestBookList) {
            v = new Vector<>();
            System.out.println("vv" + g.getHostNickname());
            v.add(g.getHostNickname());
            v.add(g.getContent());
            v.add(simpleDateFormat.format(g.getCreateAt()));
            model.addRow(v);
        }
    }

    public void addMouseListener(MouseListener listener) {
        table.addMouseListener(listener);
    }
}
