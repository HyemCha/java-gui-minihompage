package minihomepage;

import minihomepage.model.ModelMain;
import minihomepage.model.dao.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class First extends JFrame {
    ResultSet rs = null;
    ModelMain data;
    List<JLabel> userBtns = new ArrayList<>();
    User user;
    JLabel btn;
    public DefaultTableModel model;
    public JTable table;
    public JScrollPane scroll;
    public JPanel panel;
    private Vector<String> vector;
    private Vector<User> userVector;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        new First(new ModelMain());
            }
        });
    }
    public First(ModelMain data) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        System.out.println("this"+ this.getClass().getSimpleName());
        setLayout(new BorderLayout());
        setBounds(0, 0, 800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });

        this.data = data;
        this.initComponents();
        this.selectUsers();
        this.init();
    }

    void initComponents() {
//        data = new ModelMain();
        user = new User();
        table = new JTable();
        scroll = new JScrollPane();
        panel = new JPanel();

        add(panel);
    }

    public void init() {
        vector = new Vector<>();
        vector.addElement("닉네임");
        vector.addElement("소개");
        model = new DefaultTableModel(vector, 0){
            public boolean isCellEditable(int r, int c) {
                return c != 0;
            }
        };

        table.setModel(model);
        Vector<String> v;
        for (User u : userVector) {
            v = new Vector<>();
            System.out.println("user:" + u.getNickname());
            v.add(u.getNickname());
            v.add(u.getIntroduce());
            model.addRow(v);
        }
        scroll.getViewport().add(table);
        panel.add(scroll);
    }

    public void selectUsers() {
        userVector = new Vector<>();
        rs = data.selectUser();
        System.out.println("어ㅏ리너ㅏ");
        try {
            while (!rs.next()) {
                System.out.println("user:" + rs.getString(3));
                user = new User();
                System.out.println(rs.getString(3));
                user.setNickname(rs.getString(3));
                user.setIntroduce(rs.getString(6));
                userVector.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            System.out.println("dd" + rs);
        }
    }
}
