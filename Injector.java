import Controller.NoteListCommand;
import Controller.UIController;
import Controller.UINoteListController;
import Controller.UIStatisticsController;
import Model.Database;
import Model.NoteList;
import Model.NoteModel;

import java.util.ArrayList;

public class Injector {
    public UIController diary;
    public void init(){
        Database base = new Database();
        UIStatisticsController uiStatisticsController = new UIStatisticsController();
        diary = new UIController(base);
        diary.showAuthorizationScreen();
        diary.showEditNoteScreen();
        uiStatisticsController.showColleguesStatScreen();
    }
}
