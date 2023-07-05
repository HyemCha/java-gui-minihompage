package minihomepage.view.home;

import javax.swing.*;
import java.awt.*;

public class HomeImage extends JPanel {
    private Image image;

    public HomeImage() {
        image = new ImageIcon("image/minihomepage/back1.jpg").getImage();
        setSize(new Dimension(image.getWidth(null), image.getHeight(null)));
        setPreferredSize(new Dimension(400, 190));
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // 그려지는 이미지 사이즈 조정 가능
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
