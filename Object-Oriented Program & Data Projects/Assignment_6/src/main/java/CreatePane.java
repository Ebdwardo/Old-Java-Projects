//         Name: Eduardo Teodosio Campuzano
//  Description: CreatePane generates a pane where a user can enter
//  a club information and create a list of available clubs.

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.event.ActionEvent;    //**Need to import
import javafx.event.EventHandler;    //**Need to import
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//import all other necessary javafx classes here
//----

public class CreatePane extends HBox {
    ArrayList<Club> clubList;

    //The relationship between CreatePane and SelectPane is Aggregation
    private SelectPane selectPane;
    private TextArea clubInfo;
    private TextField enterTitle;
    private TextField enterMembers;
    private TextField enterUni;
    private Label title;
    private Label members;
    private Label university;
    private Button createClub;
    private Label errorMessage;

    //constructor
    public CreatePane(ArrayList<Club> list, SelectPane sePane) {
        this.clubList = list;
        this.selectPane = sePane;


        //initialize each instance variable (textfields, labels, textarea, button, etc.)
        //and set up the layout
        //----
        title = new Label("Title");
        members = new Label("Number of Members");
        university = new Label("University");
        createClub = new Button("Create a Club");
        enterTitle = new TextField();
        enterMembers = new TextField();
        enterUni = new TextField();
        clubInfo = new TextArea("No Club");
        errorMessage = new Label("");
        errorMessage.setTextFill(Color.RED);
        VBox left = new VBox();


        //create a GridPane hold those labels & text fields.
        //you can choose to use .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        //----
        GridPane enterClub = new GridPane();

        enterClub.add(title, 0, 0);
        enterClub.add(enterTitle, 1, 0);

        enterClub.add(members, 0, 1);
        enterClub.add(enterMembers, 1, 1);

        enterClub.add(university, 0, 2);
        enterClub.add(enterUni, 1, 2);


        //You might need to create a sub pane to hold the button
        //----
        HBox buttonHolder = new HBox(createClub);


        //Set up the layout for the left half of the CreatePane.
        //----
        left.getChildren().addAll(errorMessage, enterClub, buttonHolder);
        this.getChildren().addAll(left);
        left.setPadding(new Insets(16));
        enterClub.setPadding(new Insets(0, 20, 0, 20));
        buttonHolder.setAlignment(Pos.CENTER);
        enterClub.setHgap(8);
        enterClub.setVgap(3);
        buttonHolder.setPadding(new Insets(6, 0, 0, 0));
        HBox.setHgrow(clubInfo, Priority.ALWAYS);

        //the right half of the CreatePane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space

        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        //----
        this.getChildren().addAll(clubInfo);

        //register/link source object with event handler
        //----
        createClub.setOnAction(new ButtonHandler());

    } //end of constructor

    //Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create" is pushed or not,
    //When the event occurs, it get a club's Title, its number of members, and its university
    //information from the relevant text fields, then create a new club and add it inside
    //the clubList. Meanwhile it will display the club's information inside the text area.
    //using the toString method of the Club class.
    //It also does error checking in case any of the textfields are empty,
    //or a non-numeric value was entered for its number of members
    private class ButtonHandler implements EventHandler<ActionEvent> {
        //Override the abstract method handle()
        public void handle(ActionEvent event) {
            //declare any necessary local variables here
            //---
            Club newClub = new Club();

            //when a text field is empty and the button is pushed
            if (enterMembers.getText().equals("") || enterTitle.getText().equals("") || enterUni.getText().equals("")) {
                //handle the case here
                errorMessage.setText("Please fill all fields");
            } else {
                //when a non-numeric value was entered for its number of members
                //and the button is pushed
                //you will need to use try & catch block to catch
                //the NumberFormatException
                //----
                if (!enterMembers.getText().equals("")) {
                    try {
                        Integer.parseInt(enterMembers.getText());
                    } catch (NumberFormatException e) {
                        errorMessage.setText("Please enter an integer for a number of members");
                    }
                }


                //When a club of an existing club name in the list
                //was attempted to be added, do not add it to the list
                //and display a message "Club not added - duplicate"
                boolean hasBeenAdded = false;
                for (int i = 0; i < clubList.size(); i++) {
                    if ((clubList.get(i).getClubName()).equals(enterTitle.getText())) {
                        errorMessage.setText("Club not added - duplicate");
                        hasBeenAdded = true;
                    }
                }

                //at the end, don't forget to update the new arrayList
                //information on the SelectPanel
                //----

                if (!hasBeenAdded) {
                    newClub.setClubName(enterTitle.getText());
                    newClub.setNumberOfMembers(Integer.parseInt(enterMembers.getText()));
                    newClub.setUniversity(enterUni.getText());
                    clubList.add(newClub);
                    errorMessage.setText("Club Added");
                    clubInfo.clear();
                    clubInfo.appendText(newClub.toString());
                    selectPane.updateClubList(newClub);
                }


            }

        } //end of handle() method
    } //end of ButtonHandler class

}
