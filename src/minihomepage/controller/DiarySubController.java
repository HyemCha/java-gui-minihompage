package minihomepage.controller;

import minihomepage.model.ModelMain;
import minihomepage.model.dao.Diary;
import minihomepage.model.dao.User;
import minihomepage.utility.ImageUtil;
import minihomepage.view.diary.form.DiaryCreate;
import minihomepage.view.diary.form.DiaryDetail;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiarySubController implements ActionListener {
    private User userDao;
    private Diary diaryDao;
    private JFileChooser fileChooser;
    private ModelMain model;
    private DiaryCreate diaryCreate;
    private DiaryDetail diaryDetail;
    private DiaryController diaryController;
    String cmd, img;

    public DiarySubController(DiaryController diaryController, DiaryCreate diaryCreate, DiaryDetail diaryDetail) {
        this.diaryController = diaryController;
        this.model = diaryController.model;
        this.diaryCreate = diaryCreate;
        this.userDao = diaryController.user;
        this.diaryDetail = diaryDetail;

        diaryDao = new Diary();
        diaryDao.setUserId(userDao.getId());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();
        System.out.println("LOG야ㅑ야야야양야ㅑ::" + this.getClass().getSimpleName() + "-41::" + cmd);
        switch (cmd) {
            case "저장": {
                System.out.println("LOG::" + this.getClass().getSimpleName() + "-44::" + userDao.getId());
                diaryDao.setUserId(userDao.getId());
                diaryDao.setTitle(diaryCreate.title.getText());
                diaryDao.setContent(diaryCreate.textPane.getText());
                diaryDao.setImgUrl(img);
                System.out.println("LOG::" + this.getClass().getSimpleName() + "-50::" + diaryDao.getTitle() + diaryDao.getContent());
                model.saveDiary(diaryDao);

                System.out.println("cmd::48:" + cmd);
                diaryController.resetDiary();
                diaryCreate.dispose();
                break;
            }

            case "취소": {
                diaryCreate.dispose();
                System.out.println("cmd::54:" + cmd);
                break;
            }

            case "파일": {
                fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("images", ImageIO.getReaderFileSuffixes());
                fileChooser.addChoosableFileFilter(filter);
                if (fileChooser.showOpenDialog(diaryCreate) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("LOG::" + this.getClass().getSimpleName() + "-22::" + fileChooser.getSelectedFile());
                    img = ImageUtil.saveImage(path, "diary");
                    diaryCreate.attachImage(img);
//                    Image imgg = icon.getImage();
                    System.out.println("cmd::87:" + cmd);
                }
                break;
            }
            default:
                System.out.println("djfkjskdl");

        }
    }
}


