//         Name: Eduardo Teodosio Campuzano
//  Description: ReviewPane displays a list of available clubs
//  from which a user can select and compute their total number of members.

import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;    //**Need to import
import javafx.event.EventHandler;    //**Need to import

import java.util.ArrayList;


//import all other necessary javafx classes here
//----

public class SelectPane extends BorderPane {
    // I created a check box array list that stores the checkboxes at the same time that the clubs are stored so I can have the proper indexes later
    private ArrayList<Club> clubList;
    private ArrayList<CheckBox> checklist = new ArrayList<>();
    private VBox vbox;
    private int numberSelected;
    private Label clubPrompt;
    private Label selectedClubs;
    private CheckBox boxes;

    //constructor
    public SelectPane(ArrayList<Club> list) {
        //initialize instance variables
        this.clubList = list;

        //set up the layout
        //----
        clubPrompt = new Label("Select some clubs");
        selectedClubs = new Label("The total number of members for the selected club(s): ");

        //create an empty pane where you can add check boxes later
        //----
        vbox = new VBox();


        //SelectPane is a BorderPane - add the components here
        //---
        this.setCenter(vbox);
        vbox.getChildren().addAll(clubPrompt);
        this.setBottom(selectedClubs);


    } //end of constructor

    //This method uses the newly added parameter Club object
    //to create a CheckBox and add it to a pane created in the constructor
    //Such check box needs to be linked to its handler class
    public void updateClubList(Club newClub) {
        //-------
        boxes = new CheckBox(newClub.toString());
        vbox.getChildren().add(boxes);
        checklist.add(boxes);
        boxes.setOnAction(new SelectionHandler());

    }

    //create a SelectionHandler class
    private class SelectionHandler implements EventHandler<ActionEvent> {
        //Override the abstract method handle()
        public void handle(ActionEvent event) {
            //When any radio button is selected or unselected
            //the total number of members of selected clubs should be updated
            //and displayed using a label.

            //I have a for loop set to run whenever the checkbox is selected and unselected to count all the boxes that are selected and get the right value from the list and update
            numberSelected = 0;
            for (int i = 0; i < clubList.size(); i++) {
                if (checklist.get(i).isSelected()) {
                    numberSelected += clubList.get(i).getNumberOfMembers();
                }
            }

            selectedClubs.setText("The total number of members for the selected club(s): " + numberSelected);


        }
    } //end of SelectHandler class
} //end of SelectPane class
