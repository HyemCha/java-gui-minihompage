package minihomepage.view.diary.form;

import minihomepage.controller.DiaryController;
import minihomepage.controller.DiaryDetailController;
import minihomepage.model.dao.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DiaryCreate extends JFrame {
    public final static boolean EDIT = true;
    public JTextField title;
    public JPanel imgAndText;
    public JLabel images;
    public JScrollPane scrollPane;
    public JTextPane textPane;
    public JPanel top, buttons;
    public JButton file, save, cancel;
    public JFileChooser fileChooser;
    private DiaryController controller;

    public DiaryCreate(User user) {
//        System.out.println("LOG::" + this.getClass().getSimpleName() + "-25::" + user.getId() + "/cnt:" + cnt);
        initComponents();
    }

    public DiaryCreate(DiaryDetailController listener) {
        initComponents();
//        file.setEnabled(false);
        addListener(listener);
    }

    public void initComponents() {
        fileChooser = new JFileChooser();

        setVisible(true);
        setLayout(new BorderLayout());
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setTitle(u);

        top = new JPanel();

        title = new JTextField();
        add(title, BorderLayout.NORTH);

        imgAndText = new JPanel(new BorderLayout());
        add(imgAndText);

        images = new JLabel();
        images.setPreferredSize(new Dimension(500, 80));
        imgAndText.add(images, BorderLayout.NORTH);

        textPane = new JTextPane();

        scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        imgAndText.add(scrollPane);

        buttons = new JPanel(new FlowLayout());
        add(buttons, BorderLayout.SOUTH);

        file = new JButton("파일");
        save = new JButton("저장");
        cancel = new JButton("취소");
        buttons.add(file);
        buttons.add(save);
        buttons.add(cancel);
    }

    public void addListener(ActionListener listener) {
        file.addActionListener(listener);
        save.addActionListener(listener);
        cancel.addActionListener(listener);
    }

    public void attachImage(String path) {
        Image img = new ImageIcon(path).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        images.setIcon(new ImageIcon(img));
    }

    public void editImage(String path) {
        Image img = new ImageIcon(path).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        images.setIcon(new ImageIcon(img));
    }

    public void logIn() {

    }

    public void logOut() {

    }
}
