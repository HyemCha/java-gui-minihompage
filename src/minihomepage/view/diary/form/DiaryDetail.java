package minihomepage.view.diary.form;

import minihomepage.controller.DiaryDetailController;
import minihomepage.model.dao.Diary;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class DiaryDetail extends JFrame {
    public JLabel titleLabel, textLabel, imgLabel;
    public JPanel buttons, contents;
    public JButton edit, cancel;
    double width, height;
    public Diary diary;
    SimpleDateFormat simpleDateFormat;
    public DiaryDetail(Diary diary) throws HeadlessException {
        this.diary = diary;
        setVisible(true);
        setLayout(new BorderLayout());
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        setTitle(diary.getTitle());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분");

        contents = new JPanel(new BorderLayout());
        add(contents);

        titleLabel = new JLabel(
                "<html><h1 style='margin:0 10px;'>" + diary.getTitle() + "</h1><div style='margin:10px;'>" + simpleDateFormat.format(diary.getCreateAt()) + "</div><hr style='width:650px;'></html>");
        titleLabel.setPreferredSize(new Dimension(450, 100));
        contents.add(titleLabel, BorderLayout.NORTH);

        textLabel = new JLabel("<html><h2 style='margin:10px;'>" + diary.getContent() + "</h2></html>");
        if(diary.getImgUrl() != null) {
            contents.add(textLabel, BorderLayout.SOUTH);

            Image img = new ImageIcon(diary.getImgUrl()).getImage();
            width = 300;
            height = (int) (img.getHeight(null) * (width / img.getWidth(null)));
            System.out.println("width height::" + width + "/" + height);
            img = img.getScaledInstance((int) width, (int) height, Image.SCALE_SMOOTH);
            imgLabel = new JLabel(new ImageIcon(img));
            contents.add(imgLabel);
        }
        else {
            contents.add(textLabel);
        }

        buttons = new JPanel();
        add(buttons, BorderLayout.SOUTH);

        edit = new JButton("수정");
        cancel = new JButton("삭제");
        buttons.add(edit);
        buttons.add(cancel);

    }

    public void addListener(DiaryDetailController listener) {
        edit.addActionListener(listener);
        cancel.addActionListener(listener);
    }
}
