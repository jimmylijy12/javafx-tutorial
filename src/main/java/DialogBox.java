import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a dialog box containing a message and a display picture.
 */
public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    public DialogBox(String message, Image image) {
        text = new Label(message);
        displayPicture = new ImageView(image);

        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        setAlignment(Pos.TOP_RIGHT);

        getChildren().addAll(text, displayPicture);
    }

    /**
     * Flips the dialog box so that the display picture appears on the left.
     */
    private void flip() {
        setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        FXCollections.reverse(children);
        getChildren().setAll(children);
    }

    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }

    public static DialogBox getDukeDialog(String message, Image image) {
        DialogBox dialogBox = new DialogBox(message, image);
        dialogBox.flip();
        return dialogBox;
    }
}
