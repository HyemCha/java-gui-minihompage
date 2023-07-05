package minihomepage.view.diary;

import minihomepage.controller.DiaryController;

import javax.swing.*;
import java.awt.*;

public class DiaryButtons extends JPanel {
    public JButton addBtn;
    public DiaryButtons() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        initComponents();
        addComponents();
    }

    void initComponents() {
        addBtn = new JButton("글쓰기");
    }

    void addComponents() {
        add(addBtn);
    }

    void addListener(DiaryController listener) {
        addBtn.addActionListener(listener);
    }
}
