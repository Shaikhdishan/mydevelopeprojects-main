import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class arrayUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Colorful Boxes with Input");

        // Create a FlowPane to hold the controls and boxes
        FlowPane root = new FlowPane();
        root.setHgap(10);

        // Create a TextField for user input of array size
        TextField sizeInputField = new TextField();
        sizeInputField.setPromptText("Enter the array size");

        // Create a Button to submit the array size
        Button submitButton = new Button("Submit");

        // Create a Label for instructions
        Label instructionLabel = new Label("Enter the array size:");

        // Create an HBox to hold the size input field and submit button
        HBox sizeInputBox = new HBox(instructionLabel, sizeInputField, submitButton);
        sizeInputBox.setSpacing(10);

        // Add the size input box to the root pane
        root.getChildren().add(sizeInputBox);

        // Event handler for size input
        submitButton.setOnAction(e -> {
            int arraySize = Integer.parseInt(sizeInputField.getText());

            // Create an array to store user-entered integers
            int[] userArray = new int[arraySize];

            // Create a VBox to hold the colorful boxes
            FlowPane boxPane = new FlowPane();
            boxPane.setHgap(10);
            boxPane.setVgap(10);

            // Create and display square yellow-colored boxes with user-entered integers
            for (int i = 0; i < arraySize; i++) {
                Rectangle box = new Rectangle(100, 100);
                box.setFill(Color.YELLOW);

                TextField elementInputField = new TextField();
                elementInputField.setPromptText("Enter an integer");

                final int index = i; // Capture the value of i in a final variable
                elementInputField.setOnAction(event -> {
                    int inputValue = Integer.parseInt(elementInputField.getText());
                    userArray[index] = inputValue;
                });

                boxPane.getChildren().addAll(box, elementInputField);
            }

            // Create a Button to calculate the sum
            Button calculateButton = new Button("Calculate Sum");
            calculateButton.setOnAction(event -> {
                int sum = 0;
                
                for (int i =0; i<=userArray.length; i++ ) {
                    sum += userArray[i];
                }

                // Display the sum below the boxes
                Label sumLabel = new Label("Sum of Array Elements: " + sum);
                root.getChildren().add(sumLabel);
            });

            // Add the boxes and calculate button to the root pane
            root.getChildren().addAll(boxPane, calculateButton);
        });

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
