package minihomepage.model;

import minihomepage.model.dao.Diary;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Home {
    private Connection con;
    private List<Diary> diaryList;

    public Home(Connection con) {
        this.con = con;
    }

    public List<Diary> selectDiaryPreview() {
        diaryList = new ArrayList<>();


        return diaryList;
    }
}
