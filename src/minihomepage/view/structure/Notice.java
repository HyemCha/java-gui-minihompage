package minihomepage.view.structure;

import javax.swing.*;
import java.awt.*;

public class Notice extends JPanel {
    JLabel label1, label2, label3, label4, label5, label6;
    JScrollPane scroll;
    JTabbedPane tab;
    JPanel panel1, panel2, panel3;
    String s = "<html><body style='margin:0 auto;'>" +
            "<h2>안녕하세요 minihomepage에 오신 것을 환영합니다.</h2>" +
            "사용법에 대해 알려드리겠습니다." +
            "일단 로그인을 하시면 다음과 같은 화면이 뜹니다."
            + "</html>";

    public Notice() {
        initComponents();
    }

    public void initComponents() {
        tab = new JTabbedPane();
        tab.setPreferredSize(new Dimension(500, 450));
        add(tab);

        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel(new BorderLayout());

        tab.addTab("안녕하세요", panel1);
        tab.addTab("구조", panel2);

        label1 = new JLabel();
        label1.setText(s);
        panel1.add(label1, BorderLayout.NORTH);

        label2 = new JLabel();
        Image img = new ImageIcon("image/minihomepage/img.png").getImage().getScaledInstance(380, 300, Image.SCALE_FAST);
        label2.setIcon(new ImageIcon(img));
        panel1.add(label2);

        label3 = new JLabel();
        String e = "<html><body>로그인을 하면 왼쪽에는 프로필이 뜨고<br>" +
                "오른쪽에는 홈, 다이어리, 방명록이 뜹니다.<br>" +
                "다이어리에는 하나의 사진과 함께 자유로은 글을<br>" +
                "남길 수 있고 방명록에는 친구나 가족이 방명록을 <br>" +
                "남길 수 있습니다. 소중한 추억을 이곳에 남겨보아요!<br></body></html>";
        label3.setText(e);
        panel2.add(label3);

    }
}
