//         Name: Eduardo Teodosio Campuzano
//  Description: PaneWithRectangles class creates a pane where we can use
//               mouse key to drag on grids and there will be some color following
//               the mouse. We can also use combo boxes to change its colors and stroke widths

//import any classes necessary here
//----

import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class PaneWithRectangles extends BorderPane {
    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> backColorCombo;
    private ComboBox<String> widthCombo;

    private Color primaryColor, secondaryColor, backgroundColor;
    private double selectWidth;

    private Rectangle[][] rectArray;


    public PaneWithRectangles() {
        primaryColor = Color.BLACK;
        secondaryColor = Color.GRAY;
        backgroundColor = Color.WHITE;
        selectWidth = 1.0;

        //Instantiate and initialize labels, combo boxes
        Label primColor = new Label("PrimaryColor");
        primaryColorCombo = new ComboBox<>();
        primaryColorCombo.getItems().addAll("Black", "Blue", "Red", "Green");
        primaryColorCombo.setValue("Black");

        Label secondColor = new Label("BackgroundColor");
        backColorCombo = new ComboBox<>();
        backColorCombo.getItems().addAll("White", "Yellow", "Orange");
        backColorCombo.setValue("White");

        Label stroke = new Label("StrokeWidth");
        widthCombo = new ComboBox<>();
        widthCombo.getItems().addAll("1", "3", "5", "7");
        widthCombo.setValue("1");


        //Instantiate and initialize the two dimensional array rectArray
        //to contain 7 columns and 7 rows (49 rectangles total)
        //It is recommended to use nested loops
        rectArray = new Rectangle[7][7];
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 7; row++) {
                rectArray[col][row] = new Rectangle();
                rectArray[col][row].setWidth(470 / 7);
                rectArray[col][row].setHeight(390 / 7);
                rectArray[col][row].setStroke(Color.BLACK);
                rectArray[col][row].setStrokeWidth(1.0);
                rectArray[col][row].setFill(Color.WHITE);
                rectArray[col][row].setId(String.format("%d %d", col, row));

            }
        }


        //grid is a GridPane containing 49 rectangles.
        GridPane grid = new GridPane();
        grid.setVgap(1.0);
        grid.setHgap(1.0);
        //---- add 49 rectangles to the grid pane, it is recommended to use nested loops
        //----
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                grid.add(rectArray[i][j], i, j);
            }
        }
        //----

        //leftPane is a VBox, it should contain labels and combo boxes
        VBox leftPane = new VBox(primColor, primaryColorCombo, secondColor, backColorCombo, stroke, widthCombo);
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 0));


        //add the left pane to the left of the pane
        //and the grid pane contains rectangles at the center
        this.setLeft(leftPane);
        this.setCenter(grid);

        MouseHandler han = new MouseHandler();
        //register/link the source nodes with its handler objects
        for (Rectangle[] arr : this.rectArray)
            for (Rectangle rect : arr) {
                rect.setOnDragDetected(han);
                rect.setOnMouseDragOver(han);
            }
        //----
        primaryColorCombo.setOnAction(new PrimColorHandler());
        //----
        backColorCombo.setOnAction(new BackColorHandler());
        //----
        widthCombo.setOnAction(new WidthHandler());

    }


    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            //handle MouseEvent here
            //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
            //to check whether the mouse key is dragged
            //write your own codes here
            //----
            Rectangle rect = (Rectangle) event.getSource();
            if (event.getEventType() == MouseEvent.DRAG_DETECTED) rect.startFullDrag();

            for (int i = 0; i < rectArray.length; i++) {
                for (int j = 0; j < rectArray[i].length; j++) {
                    rectArray[i][j].setFill(backgroundColor);
                }
            }
            for (int i = 0; i < rectArray.length; i++) {
                for (int j = 0; j < rectArray[i].length; j++) {
                    if (rectArray[i][j] == event.getSource()) {
                        rectArray[i][j].setFill(primaryColor);
                        if (i > 0) rectArray[i - 1][j].setFill(secondaryColor);
                        if (i < rectArray.length - 1) rectArray[i + 1][j].setFill(secondaryColor);
                        if (j > 0) rectArray[i][j - 1].setFill(secondaryColor);
                        if (j < rectArray[i].length - 1) rectArray[i][j + 1].setFill(secondaryColor);
                    }
                }
            }

        }//end handle()

    }//end MouseHandler

    //A handler class used to handle primary and secondary colors
    private class PrimColorHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            //write your own codes here
            //----
            String colors = primaryColorCombo.getValue();

            switch (colors) {
                case "Black":
                    primaryColor = Color.BLACK;
                    secondaryColor = Color.GRAY;
                    break;

                case "Blue":
                    primaryColor = Color.BLUE;
                    secondaryColor = Color.POWDERBLUE;
                    break;
                case "Red":
                    primaryColor = Color.RED;
                    secondaryColor = Color.PINK;
                    break;
                case "Green":
                    primaryColor = Color.GREEN;
                    secondaryColor = Color.LIGHTGREEN;
                    break;
            }
        }
    }//end PrimColorHandler

    //A handler class used to handle background color
    private class BackColorHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            //write your own codes here
            //----
            String background = backColorCombo.getValue();
            switch (background) {
                case "Yellow":
                    backgroundColor = Color.YELLOW;
                    for (int i = 0; i < rectArray.length; i++) {
                        for (int j = 0; j < rectArray[i].length; j++) {
                            rectArray[i][j].setFill(backgroundColor);
                        }
                    }
                    break;
                case "White":
                    backgroundColor = Color.WHITE;
                    for (int i = 0; i < rectArray.length; i++) {
                        for (int j = 0; j < rectArray[i].length; j++) {
                            rectArray[i][j].setFill(backgroundColor);
                        }
                    }
                    break;
                case "Orange":
                    backgroundColor = Color.ORANGE;
                    for (int i = 0; i < rectArray.length; i++) {
                        for (int j = 0; j < rectArray[i].length; j++) {
                            rectArray[i][j].setFill(backgroundColor);
                        }
                    }
                    break;
            }
        }
    }//end BackColorHandler

    //A handler class used to handle stroke width
    private class WidthHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            //write your own codes here
            //----
            String width = widthCombo.getValue();
            selectWidth = Double.parseDouble(width);
            double constantWidth = 470 / 7;
            double constantHeight = 390 / 7;
            for (int i = 0; i < rectArray.length; i++) {
                for (int j = 0; j < rectArray[i].length; j++) {
                    rectArray[i][j].setStrokeWidth(selectWidth);
                    rectArray[i][j].setHeight(constantHeight - (selectWidth - 1));
                    rectArray[i][j].setWidth(constantWidth - (selectWidth - 1));
                }
            }
        }
    }//end WidthHandler
} //end of PaneWithRectangles