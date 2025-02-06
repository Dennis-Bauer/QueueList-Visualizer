package de.dennis.qlvisualizer;

import de.dennis.qlvisualizer.Panes.StartScreen;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static de.dennis.qlvisualizer.Utilities.JavaFXConstructorUtilities.*;
import static de.dennis.qlvisualizer.Utilities.JavaUtilities.isStringInt;

public class Main extends Application {

    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;
    public static final String TEXT_FONT = "Arial";
    public static final double FONT_SIZE = (WINDOW_HEIGHT + WINDOW_WIDTH) * 0.015;

    // Debug/Variables
    public static final int MAX_INPUT_LENGTH = 3;
    public static final Color CURRENT_ARROW_COLOR = Color.INDIANRED; // Default: INDIANRED
    public static final Color FIRST_LAST_ARROW_COLOR = Color.BLUE; // Default: BLUE
    public static final Color CONTENT_COLOR_CURRENT = Color.GRAY; // Default: GRAY
    public static final Color CONTENT_COLOR_GOT = Color.WHITE; // Default: WHITE
    public static final Color CONTENT_COLOR_NOTHING = Color.BLACK; // Default: BLACK

    private static Scene primaryScene;

    @Override
    public void start(Stage stage) {

        primaryScene = new Scene(new StartScreen(), WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle("List-Visualizer");
        stage.setScene(primaryScene);
        stage.show();

    }

    private static Queue primaryList;

    public static void createPreList() {
        createListView(2, true);

        for (int i = 0; i < 8; i++)
            primaryList.append(new ListElement((i * 2) + 3));
    }

    public static void createListView(int i, boolean createWithElement) {

        if (createWithElement) primaryList = new Queue(new ListElement(i));
        else primaryList = new Queue();

        // Input Box
        VBox inputBoxPane = new VBox();
        inputBoxPane.setAlignment(Pos.CENTER);

        Label inputBoxHeader = buildLabel("inputBox_Header", "Input", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, Color.BLACK);
        TextField inputBox = buildTextField("inputListWithElement", "int", WINDOW_WIDTH * 0.31, WINDOW_HEIGHT * 0.125);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setMaxWidth(WINDOW_WIDTH * 0.31);
        inputBox.setText("1");

        inputBoxPane.getChildren().addAll(inputBoxHeader, inputBox);

        // Output Label
        Rectangle outPutBackground = buildRectangle("outputLabel_Background", WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Color.WHITE, false, null, 0);
        Label outputLabel = buildLabel("outputLabel", "Output: ___", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, Color.BLACK);

        StackPane outputPane = new StackPane(outPutBackground, outputLabel);

        // Current null Label
        Rectangle currentNullBackground = buildRectangle("currentNullLabel_Background", WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Color.WHITE, false, null, 0);
        Label currentNullLabel = buildLabel("currentNullLabel", "Current: Null", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, Color.DARKRED);

        StackPane currentNullPane = new StackPane(currentNullBackground, currentNullLabel);

        // Buttons
        Button appendButton = createStandardButton("append(Content)");
        Button setContentButton = createStandardButton("setContent(Content)");
        Button insertButton = createStandardButton("insert(Content)");
        Button removeButton = createStandardButton("remove()");
        Button getContentButton = createStandardButton("getContent()");
        Button toFirstButton = createStandardButton("toFirst()");
        Button toLastButton = createStandardButton("toLast()");
        Button nextButton = createStandardButton("next()");
        Button isEmptyButton = createStandardButton("isEmpty()");
        Button hasCurrentAccess = createStandardButton("hasCurrentAccess()");

        // Actions
        getContentButton.setOnMouseClicked(_ -> primaryList.getContentNode());
        removeButton.setOnMouseClicked(_ -> {
            primaryList.remove();
            currentNullPane.setVisible(!primaryList.hasCurrentAccess());
        });
        nextButton.setOnMouseClicked(_ -> {
            primaryList.next();
            currentNullPane.setVisible(!primaryList.hasCurrentAccess());
        });
        toLastButton.setOnMouseClicked(_ -> {
            primaryList.toLast();
            currentNullPane.setVisible(!primaryList.hasCurrentAccess());
        });
        toFirstButton.setOnMouseClicked(_ -> {
            primaryList.toFirst();
            currentNullPane.setVisible(!primaryList.hasCurrentAccess());
        });
        isEmptyButton.setOnMouseClicked(_ -> {
            if (primaryList.isEmpty()) {
                outputLabel.setText("Output: true");
                outputLabel.setTextFill(Color.GREEN);
            } else {
                outputLabel.setText("Output: false");
                outputLabel.setTextFill(Color.RED);
            }
        });
        hasCurrentAccess.setOnMouseClicked(_ -> {
            if (primaryList.hasCurrentAccess()) {
                outputLabel.setText("Output: true");
                outputLabel.setTextFill(Color.GREEN);
            } else {
                outputLabel.setText("Output: false");
                outputLabel.setTextFill(Color.RED);
            }
        });

        // With input
        appendButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.append(new ListElement(Integer.parseInt(inputBox.getText())));
            currentNullPane.setVisible(!primaryList.hasCurrentAccess());
        });
        insertButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.insert(new ListElement(Integer.parseInt(inputBox.getText())));
            currentNullPane.setVisible(!primaryList.hasCurrentAccess());
        });
        setContentButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.setContentFromNode(Integer.parseInt(inputBox.getText()));
        });

        double buttonSpacing = WINDOW_HEIGHT * 0.01;
        HBox buttonPane = new HBox(buttonSpacing,
                new VBox(buttonSpacing,
                        nextButton,
                        toFirstButton,
                        toLastButton,
                        currentNullPane
                ),
                new VBox(buttonSpacing,
                        appendButton,
                        insertButton,
                        removeButton,
                        hasCurrentAccess
                ),
                new VBox(buttonSpacing,
                        setContentButton,
                        getContentButton,
                        isEmptyButton,
                        outputPane
                )
        );

        buttonPane.setAlignment(Pos.CENTER);

        primaryScene.setRoot(new VBox(WINDOW_HEIGHT * 0.02,
                primaryList,
                buttonPane,
                inputBoxPane
        ));
    }

    private static Button createStandardButton(String text) {
        return buildButton("listControlButton", text, WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Font.font(TEXT_FONT, FontWeight.BOLD, FONT_SIZE));
    }


    public static void main(String[] args) {
        launch();
    }
}