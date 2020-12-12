package Controller;

import Model.Database;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class UIController extends JFrame {
    public Database database;

    public UIController(Database database) {
        this.database = database;
    }

    public void showAuthorizationScreen() {
        JFrame frame = new JFrame("Authorization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Diary");
        JLabel label2 = new JLabel("Login to your Account");
        JLabel label3 = new JLabel("Don't have an account?");

        label1.setFont(new Font("Serif", Font.PLAIN, 30));
        label2.setFont(new Font("Serif", Font.PLAIN, 16));
        label3.setFont(new Font("Serif", Font.PLAIN, 12));

        label1.setBounds(100,50, 100,50);
        label2.setBounds(30,100, 150,50);
        label3.setBounds(30,400, 120,30);

        TextField textFieldEmail = new TextField();
        textFieldEmail.setBounds(30, 160, 200 ,30);
        textFieldEmail.setText("Email");
        TextField textFieldPassword = new TextField();
        textFieldPassword.setBounds(30, 200, 200 ,30);
        textFieldPassword.setText("Password");

        Button signIn = new Button("Sign in");
        signIn.setBounds(30, 250, 200 ,40);
        Button signUp = new Button("Sign up");
        signUp.setBounds(150, 400, 50 ,30);

        signIn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onEntryButton();
                frame.setVisible(false);
            }
        });

        signUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showRegistrationScreen();
                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(textFieldEmail);
        frame.add(textFieldPassword);
        frame.add(signIn);
        frame.add(signUp);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showRegistrationScreen() {
        JFrame frame = new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Diary");
        JLabel label2 = new JLabel("Create to your Account");

        label1.setFont(new Font("Serif", Font.PLAIN, 30));
        label2.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(100,50, 100,50);
        label2.setBounds(30,100, 150,50);

        TextField textFieldEmail = new TextField();
        textFieldEmail.setBounds(30, 160, 200 ,30);
        textFieldEmail.setText("Email");
        TextField textFieldPassword = new TextField();
        textFieldPassword.setBounds(30, 200, 200 ,30);
        textFieldPassword.setText("Password");
        TextField textFieldConfirmPassword = new TextField();
        textFieldConfirmPassword.setBounds(30, 240, 200 ,30);
        textFieldConfirmPassword.setText("Confirm Password");

        Button signUp = new Button("Sign up");
        signUp.setBounds(30, 280, 200 ,40);
        Button back = new Button("Back");
        back.setBounds(150, 400, 50 ,30);

        signUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onRegistrationButton();
                frame.setVisible(false);
            }
        });

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showAuthorizationScreen();
                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(label2);
        frame.add(textFieldEmail);
        frame.add(textFieldPassword);
        frame.add(textFieldConfirmPassword);
        frame.add(signUp);
        frame.add(back);

        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showNoteListScreen() {
        JFrame frame = new JFrame("Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("My Notes");
        JLabel label2 = new JLabel("Executed");
        JLabel label3 = new JLabel("Compleated");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));
        label2.setFont(new Font("Serif", Font.PLAIN, 16));
        label3.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);
        label2.setBounds(120,80, 100,30);
        label3.setBounds(120,250, 100,30);

        JList listExecuted = new JList();
        listExecuted.setLayoutOrientation(JList.VERTICAL);
        listExecuted.setBounds(50,120, 200,120);
        listExecuted.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listExecuted.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JList listCompleated = new JList();
        listCompleated.setLayoutOrientation(JList.VERTICAL);
        listCompleated.setBounds(50,290, 200,120);
        listCompleated.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listCompleated.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listExecuted.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2 ) {
                    int selectedIndexListExecuted = listExecuted.locationToIndex(e.getPoint());
                    onEditNoteButton();
                }
            }
        });

        listCompleated.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2 ) {
                    int selectedIndexListCompleated = listCompleated.locationToIndex(e.getPoint());
                    onEditNoteButton();
                }
            }
        });

        Button menu = new Button("=");
        menu.setBounds(10, 10, 20 ,20);
        Button addNote = new Button("+");
        addNote.setBounds(260, 10, 20 ,20);

        menu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onMenuButton();
                frame.setVisible(false);
            }
        });

        addNote.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onAddNoteButton();
                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(listExecuted);
        frame.add(listCompleated);
        frame.add(menu);
        frame.add(addNote);

        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showMenuScreen() {
        JFrame frame = new JFrame("Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Choose Note List");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);

        Button myNotes = new Button("My Notes");
        myNotes.setBounds(50, 50, 200 ,30);
        Button important = new Button("Important");
        important.setBounds(50, 100, 200 ,30);
        Button calendar = new Button("Calendar of entries");
        calendar.setBounds(50, 150, 200 ,30);
        Button listOfCollegues = new Button("List of collegues");
        listOfCollegues.setBounds(50, 200, 200 ,30);
        Button listOfRequests = new Button("List of requests");
        listOfRequests.setBounds(50, 250, 200 ,30);

        myNotes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showNoteListScreen();
                frame.setVisible(false);
            }
        });

        important.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        calendar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        listOfCollegues.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showCollegueScreen();
                frame.setVisible(false);
            }
        });
        listOfRequests.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showRequestsScreen();
                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(myNotes);
        frame.add(important);
        frame.add(calendar);
        frame.add(listOfCollegues);
        frame.add(listOfRequests);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showCollegueScreen() {
        JFrame frame = new JFrame("Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("List of collegues");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);

        JList list = new JList();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBounds(50,120, 200,120);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2 ) {
                    int selectedIndexListExecuted = list.locationToIndex(e.getPoint());

                }
            }
        });


        Button menu = new Button("=");
        menu.setBounds(10, 10, 20 ,20);
        Button add = new Button("+");
        add.setBounds(260, 10, 20 ,20);

        menu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onMenuButton();
                frame.setVisible(false);
            }
        });

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onAddNewCollegueButton();
                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(list);
        frame.add(menu);
        frame.add(add);

        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showAddNoteScreen() {
        Frame frame = new JFrame("Preview");
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Add Note");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);

        TextField textFieldName = new TextField();
        textFieldName.setBounds(30, 100, 200 ,30);
        textFieldName.setText("Name");
        TextField textFieldDate = new TextField();
        textFieldDate.setBounds(30, 150, 200 ,30);
        textFieldDate.setText("Date");
        TextField textFieldNote = new TextField();
        textFieldNote.setBounds(30, 200, 200 ,80);
        textFieldNote.setText("Note");

        JList list = new JList();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBounds(30,300, 200,60);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2 ) {
                    int selectedIndexListExecuted = list.locationToIndex(e.getPoint());

                }
            }
        });

        Button cancel = new Button("Cancel");
        cancel.setBounds(10, 10, 40 ,20);
        Button save = new Button("Save");
        save.setBounds(240, 10, 40 ,20);

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                showNoteListScreen();
            }
        });

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                showNoteListScreen();
                onSaveNoteButton();
            }
        });

        frame.add(label1);
        frame.add(textFieldName);
        frame.add(textFieldDate);
        frame.add(textFieldNote);
        frame.add(cancel);
        frame.add(save);
        frame.add(list);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showEditNoteScreen() {
        Frame frame = new JFrame("Preview");
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Edit Note");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);

        TextField textFieldName = new TextField();
        textFieldName.setBounds(30, 100, 200 ,30);
        textFieldName.setText("Name");
        TextField textFieldDate = new TextField();
        textFieldDate.setBounds(30, 150, 200 ,30);
        textFieldDate.setText("Date");
        TextField textFieldNote = new TextField();
        textFieldNote.setBounds(30, 200, 200 ,80);
        textFieldNote.setText("Note");

        JList list = new JList();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBounds(30,300, 200,60);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2 ) {
                    int selectedIndexListExecuted = list.locationToIndex(e.getPoint());

                }
            }
        });

        Button cancel = new Button("Cancel");
        cancel.setBounds(10, 10, 40 ,20);
        Button save = new Button("Save");
        save.setBounds(240, 10, 40 ,20);
        Button delete = new Button("del");
        delete.setBounds(120, 370, 40 ,20);

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                showNoteListScreen();
            }
        });

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                showNoteListScreen();
                onSaveNoteButton();
            }
        });
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                showNoteListScreen();
                onSaveNoteButton();
            }
        });


        frame.add(label1);
        frame.add(textFieldName);
        frame.add(textFieldDate);
        frame.add(textFieldNote);
        frame.add(cancel);
        frame.add(save);
        frame.add(delete);
        frame.add(list);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showAddNewCollegueScreen() {
        JFrame frame = new JFrame("Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Add Collegue");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);

        TextField textFieldEmail = new TextField();
        textFieldEmail.setBounds(30, 100, 200 ,30);
        textFieldEmail.setText("Email");

        Button cancel = new Button("Cancel");
        cancel.setBounds(10, 10, 40 ,20);
        Button add = new Button("+");
        add.setBounds(260, 100, 20 ,20);

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showCollegueScreen();
                frame.setVisible(false);
            }
        });

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        frame.add(label1);
        frame.add(textFieldEmail);
        frame.add(cancel);
        frame.add(add);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showRequestsScreen() {
        JFrame frame = new JFrame("Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("List of requests");

        label1.setFont(new Font("Serif", Font.PLAIN, 16));

        label1.setBounds(120,10, 100,30);

        JList list = new JList();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBounds(50,120, 200,120);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 2 ) {
                    int selectedIndexListExecuted = list.locationToIndex(e.getPoint());

                }
            }
        });


        Button menu = new Button("=");
        menu.setBounds(10, 10, 20 ,20);
        Button accept = new Button("+");
        accept.setBounds(10, 130, 20 ,20);
        Button notAccept = new Button("-");
        notAccept.setBounds(260, 130, 20 ,20);

        menu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onMenuButton();
                frame.setVisible(false);
            }
        });

        accept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        notAccept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        frame.add(label1);
        frame.add(list);
        frame.add(menu);
        frame.add(accept);
        frame.add(notAccept);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void onEntryButton() {
        showNoteListScreen();
    }
    public void onRegistrationButton() {
        showNoteListScreen();
    }
    public void onAddNoteButton() {
        showAddNoteScreen();
    }
    public void onEditNoteButton() {
        showEditNoteScreen();
    }
    public void onAddNewCollegueButton() {
        showAddNewCollegueScreen();
    }
    public void onAddNewCollegueToNoteButton() {

    }
    public void onSaveNoteButton() {

    }
    public void onMenuButton() {
        showMenuScreen();
    }
}
