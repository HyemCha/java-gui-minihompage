package minihomepage.view.diary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class DiaryTable extends JScrollPane{
    private DefaultTableModel model;
    private JTable table;
    private Vector<String> vector;
    public DiaryTable() {
        initComponents();
        addTableHeader();
        getViewport().add(table);
        addDataTest();
    }
    public void initComponents() {
        vector = new Vector<>();
    }

    public void addTableHeader() {
        vector.addElement("aaa");
        vector.addElement("bbb");
        model = new DefaultTableModel(vector, 0){
            public boolean isCellEditable(int r, int c) {
                return c != 0;
            }
        };

        table = new JTable(model);
    }

    public void addDataTest() {
        Vector<String> v = new Vector<>();
        v.add("1");
        v.add("1");
        model.addRow(v);
    }
}
