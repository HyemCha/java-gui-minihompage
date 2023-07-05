package minihomepage.view;

import minihomepage.view.structure.Categories;
import minihomepage.view.structure.ViewProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewMain extends JFrame {
    public Categories tabbedPane;
    public ViewProfile viewProfile;

    public ViewMain() {
        initWindow();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("ERROR : LookAndFeel setting failed");
        }
        initComponents();
        addComponents();
    }

    public void initWindow() {
        setTitle("MiniHomePage");
        setBounds(500, 300, 800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void initComponents() {
        viewProfile = new ViewProfile();
        tabbedPane = new Categories();
    }

    public void addComponents() {
        add(viewProfile, BorderLayout.WEST);
        add(tabbedPane);
    }

    public void addActionListener(ActionListener listener) {
        viewProfile.addActionListener(listener);
    }
}
