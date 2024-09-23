import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class prefixSum2 extends Application {

    private ObservableList<Integer> arrayElements = FXCollections.observableArrayList();
    private Label prefixSumLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prefix Sum Calculator");

        // UI elements
        TextField inputText = new TextField();
        ListView<Integer> arrayListView = new ListView<>(arrayElements);
        Button addButton = new Button("Add Element");
        Button calculateButton = new Button("Calculate Prefix Sum");
        prefixSumLabel = new Label();
        TextField startRangeText = new TextField();
        startRangeText.setOpacity(0.0);
        TextField endRangeText = new TextField();
        endRangeText.setOpacity(0.0);


        // Event handler for the "Add Element" button
        addButton.setOnAction(e -> {
            try {
                int newValue = Integer.parseInt(inputText.getText().trim());
                arrayElements.add(newValue);
                inputText.clear();
            } catch (NumberFormatException ie) {
                // Handle invalid input
                showAlert("Invalid input", "Please enter a valid integer.");
            }
        });

        Button RangeButton = new Button("Do you want Range Prefix Sum");

        boolean wantRange = false;
         VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        RangeButton.setOnAction(e -> {
            
            //wantRange = true;
            wrange();
            startRangeText.setOpacity(0.7);
            endRangeText.setOpacity(0.7);
            vBox.getChildren().clear();
              vBox.getChildren().addAll(
                    new Label("Enter Array Elements:"),
                    inputText,
                    addButton,
                    arrayListView,
                    RangeButton,
                    new Label("Range Start:"),
                    startRangeText,
                    new Label("Range End:"),
                    endRangeText,
                    calculateButton,
                    prefixSumLabel
                
            );
            dwrange();
            
        }
        );

        // Event handler for the "Calculate Prefix Sum" button
        calculateButton.setOnAction(e -> {
            int prefixSum = 0;
            for (Integer element : arrayElements) {
                prefixSum += element;
            }
            prefixSumLabel.setText("Prefix Sum: " + prefixSum);


             //if()

            // Calculate range prefix sum
            try {
              //  TextField startRangeText = new TextField();
                //TextField endRangeText = new TextField();

                int start = Integer.parseInt(startRangeText.getText().trim());
                int end = Integer.parseInt(endRangeText.getText().trim());

                if (start >= 0 && end < arrayElements.size() && start <= end) {
                    int rangePrefixSum = 0;
                    for (int i = start; i <= end; i++) {
                        rangePrefixSum += arrayElements.get(i);
                    }
                    prefixSumLabel.setText("Prefix Sum (Range " + start + " to " + end + "): " + rangePrefixSum);
                } else {
                    showAlert("Invalid Range", "Please enter valid range indices.");
                }
            } catch (NumberFormatException ex) {
                // Handle invalid input
                showAlert("Invalid input", "Please enter valid range indices.");
            }
        });

        // Layout
       // VBox vBox = new VBox(10);
        //vBox.setPadding(new Insets(10));
        if(wantRange==true) {
            vBox.getChildren().addAll(
                    new Label("Enter Array Elements:"),
                    inputText,
                    addButton,
                    arrayListView,
                    RangeButton,
                    new Label("Range Start:"),
                    startRangeText,
                    new Label("Range End:"),
                    endRangeText,
                    calculateButton,
                    prefixSumLabel
            );

        } else {
                vBox.getChildren().addAll(
                    new Label("Enter Array Elements:"),
                    inputText,
                    addButton,
                    arrayListView,
                    RangeButton,
                    calculateButton,
                    prefixSumLabel
            );

        }

        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void dwrange() {
        wantRange = false;
    }


    private void wrange() {

         wantRange = true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}