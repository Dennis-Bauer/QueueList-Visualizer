package de.dennis.qlvisualizer.Panes;

import de.dennis.qlvisualizer.Main;
import de.dennis.qlvisualizer.Utilities.ArrowObjekt;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import static de.dennis.qlvisualizer.Utilities.JavaFXConstructorUtilities.buildLabel;
import static de.dennis.qlvisualizer.Utilities.JavaFXConstructorUtilities.buildRectangle;

public class ElementObjekt extends HBox {

    private final String CONTENT_ADDON = "'";

    private final Label contentLabel;

    // Programm Arrows
    private final VBox posArrow;
    private final Label posArrowLabel = buildLabel("posArrow_label", "First", Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 0.7), TextAlignment.CENTER, Color.BLUE);

    // Content Arrow
    private final ArrowObjekt contentArrowObj;

    public ElementObjekt(int content) {

        // Content
        Rectangle backgroundRectangle = buildRectangle("graphicObject_Background", Main.WINDOW_WIDTH * 0.08, Main.WINDOW_WIDTH * 0.08, Color.BLACK, true, Color.WHITE, 2);
        contentLabel = buildLabel("graphicObject_Text", (CONTENT_ADDON + content + CONTENT_ADDON), Font.font(Main.TEXT_FONT, FontPosture.REGULAR, Main.FONT_SIZE), TextAlignment.CENTER, Main.CONTENT_COLOR_NOTHING);

        // Content
        StackPane contentRectanglePane = new StackPane(backgroundRectangle, contentLabel);

        //Pos Arrow
        ArrowObjekt posArrowObj = new ArrowObjekt("posArrow", new Point2D(0, 0), Main.WINDOW_HEIGHT * 0.045, Main.WINDOW_WIDTH * 0.01, Main.WINDOW_HEIGHT * 0.03, Main.WINDOW_WIDTH * 0.025, Main.FIRST_LAST_ARROW_COLOR);
        posArrowObj.setRotate(180);

        posArrow = new VBox(-0.5, posArrowLabel, posArrowObj);
        posArrow.setAlignment(Pos.CENTER);

        // Content Arrow
        contentArrowObj = new ArrowObjekt("contentArrow", new Point2D(0, 0), Main.WINDOW_HEIGHT * 0.025, Main.WINDOW_WIDTH * 0.005, Main.WINDOW_HEIGHT * 0.015, Main.WINDOW_WIDTH * 0.0125, Color.BLACK);
        contentArrowObj.setRotate(90);

        getChildren().addAll(new VBox(posArrow, contentRectanglePane), contentArrowObj);
        setSpacing(-0.1);

        HBox.setMargin(contentArrowObj, new Insets(Main.WINDOW_HEIGHT * 0.10, 0, 0, 0));

        setPosArrowVisible(true);
    }

    public void setPosArrowVisible(boolean isVisible) {
        posArrow.setVisible(isVisible);

        if (isVisible) contentLabel.setTextFill(Main.CONTENT_COLOR_CURRENT);
        else contentLabel.setTextFill(Main.CONTENT_COLOR_NOTHING);

        if (!isVisible) contentArrowObj.setVisible(true);
    }

    public void setPosArrowToFirst() {
        posArrowLabel.setText("First");
        contentArrowObj.setVisible(true);
    }

    public void setPosArrowToLast() {
        posArrowLabel.setText("Last");
        contentArrowObj.setVisible(false);
    }

    public void setPosArrowToBoth() {
        posArrowLabel.setText("First & Last");
        contentArrowObj.setVisible(false);
    }

    public void showContent() {
        contentLabel.setTextFill(Main.CONTENT_COLOR_GOT);
    }

    public void resetShow() {
        contentLabel.setTextFill(Main.CONTENT_COLOR_CURRENT);
    }

}
