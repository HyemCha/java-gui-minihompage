package minihomepage.view.diary;

import minihomepage.model.dao.Diary;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ImageRenderer extends DefaultListCellRenderer {
    private Map<Diary, ImageIcon> imageMap;

    public ImageRenderer(Map<Diary, ImageIcon> imageMap) {
        this.imageMap = imageMap;
    }

    Font font = new Font("helvetica", Font.ITALIC, 24);

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Diary diary = (Diary) value;

        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, diary.getTitle(), index, isSelected, cellHasFocus
        );

        // 보여줄 이미지
        ImageIcon imgIcon = imageMap.get(value);
        if (imageMap.get(value).getImage() != null) {
            Image img = imageMap.get(value).getImage().getScaledInstance(80, 80, Image.SCALE_FAST);
            imgIcon = new ImageIcon(img);
        }

        label.setIcon(imgIcon);
        // text 위치
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setFont(font);
        return label;
    }
}
