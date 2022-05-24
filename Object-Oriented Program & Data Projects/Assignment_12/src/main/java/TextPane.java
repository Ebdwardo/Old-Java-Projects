//         Name: Eduardo Teodosio Campuzano
//      Description: This textpane serves as the template for everything that will happen in the gui
// here is where the timeline is created and how we interact with it and it makes sure that the text in the
// 2 textpanes do not go outside the boundaries

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TextPane extends Pane {
    private double x1;
    private double y1;
    private double stepX;
    private double stepY;
    private String string1;
    private Color currentColor;

    //create the keyframe and add it to the timeline
    //link the text handler to the timeline so the animation plays as intended

    KeyFrame kf = new KeyFrame(Duration.millis(1000), new TextHandler());
    private Timeline timeline1 = new Timeline(kf);

    //Constructor for the textpane that defines the necessary instance variables
    public TextPane(Color color, String initialString) {
        currentColor = color;
        string1 = initialString;
        this.setStyle("-fx-background-color: #" + "000000");
        x1 = 0;
        y1 = 0;
        stepX = 30;
        stepY = 30;
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.setRate(1);
        timeline1.play();
    }

    // resumes the timeline after it has been stopped
    public void resume() {
        timeline1.play();
    }

    // stops the animation
    public void suspend() {
        timeline1.stop();
    }

    // changes the current color variable which changes the color of the text displayed
    public void changeColor(Color color) {
        currentColor = color;
    }

    // changes the string being displayed
    public void changeString(String string) {
        string1 = string;
    }

    // clears the text in the gui
    public void clear() {
        this.getChildren().clear();
    }

    // speeds up or slows down the rate at which the text is being displayed on screen
    public void setRate(double rate1) {
        timeline1.setRate(rate1);
    }

    // helper method to add the text to the pane that in use in the text handler class
    public void textToPane(Text text) {
        this.getChildren().add(text);
    }

    private class TextHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            //update the position of the new text to be added and add it to the pane
            x1 += stepX;
            y1 += stepY;
            Text addedText = new Text(x1, y1, string1);
            addedText.setFill(currentColor);
            textToPane(addedText);

            // These if statement makes sure the text stays in the bounds we want it too
            if (x1 + stepX < 0 || x1 + stepX > getWidth() - string1.length() * 7) {
                stepX *= -1;
            }

            if (y1 + stepY < 0 || y1 + stepY > getHeight()) {
                stepY *= -1;
            }
        }
    }
}


