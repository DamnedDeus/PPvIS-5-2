package Model;

import java.util.ArrayList;
import java.util.Date;

public class Note {
    public String name;
    public Date date;
    public String note;
    public boolean important = false;
    public boolean completed = false;
    public User User;
    public ArrayList<String> listOfColleguesID = new ArrayList<>();
    public ArrayList<NoteModel> Note = new ArrayList<>();
}
