package minihomepage.controller;

import minihomepage.model.ModelMain;
import minihomepage.model.dao.Diary;
import minihomepage.utility.ImageUtil;
import minihomepage.view.diary.form.DiaryCreate;
import minihomepage.view.diary.form.DiaryDetail;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiaryDetailController implements ActionListener {
    private DiaryDetail diaryDetail;
    private ModelMain model;
    private DiaryController diaryController;
    private Diary diary;
    private DiaryCreate updateDiary;
    private JFileChooser fileChooser;

    String cmd, img;

    public DiaryDetailController(DiaryController diaryController) {
        this.diaryController = diaryController;
        this.model = diaryController.model;
        this.diaryDetail = diaryController.diaryDetail;
        this.diary = diaryController.diaryDetail.diary;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();
        switch (cmd) {

            case "파일": {
                fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("images", ImageIO.getReaderFileSuffixes());
                fileChooser.addChoosableFileFilter(filter);
                if (fileChooser.showOpenDialog(updateDiary) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("LOG::" + this.getClass().getSimpleName() + "-22::" + fileChooser.getSelectedFile());
                    img = ImageUtil.saveImage(path, "diary");
                    updateDiary.attachImage(img);
                    System.out.println("cmd::87:" + cmd);
                }
                break;
            }

            case "수정" : {
                updateDiary = new DiaryCreate(this);
                updateDiary.title.setText(diary.getTitle());
                updateDiary.attachImage(diary.getImgUrl());
                updateDiary.textPane.setText(diary.getContent());
                diaryDetail.dispose();
                break;
            }

            case "삭제" : {
                System.out.println("cmd::48:" + cmd);
                diaryDetail.dispose();
                int id = diaryDetail.diary.getId();
                System.out.println("LOG::" + this.getClass().getSimpleName() + "-76::" + id);
                model.deleteDiary(id);
                diaryController.resetDiary();
                break;
            }

            case "저장" : {
                diary.setTitle(updateDiary.title.getText());
                diary.setContent(updateDiary.textPane.getText());
                diary.setImgUrl(img);
                model.updateDiary(diary);
                diaryController.resetDiary();
                updateDiary.dispose();
                DiaryDetail detail = new DiaryDetail(diary);
                detail.addListener(this);
                break;
            }

            case "취소" : {
                updateDiary.dispose();
                System.out.println("cmd::54:" + cmd);
                break;
            }
        }
    }
}
