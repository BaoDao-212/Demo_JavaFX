package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.controlsfx.control.HiddenSidesPane;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CanvasController implements Initializable {

	@FXML
	private HiddenSidesPane hiddenPane;
	@FXML
	private AnchorPane anchorRoot;

	@FXML
	private JFXToggleButton M0Button, M1Button, M2Button, M3Button, M4Button;

	@FXML
	private Pane viewer;
	@FXML
	private JFXNodesList nodesList;
	@FXML
	private Group canvasGroup;
	@FXML
	private Pane border;
	@FXML
	private JFXNodesList nodeList;
	@FXML
	private JFXSlider slider = new JFXSlider();
	 Delta boardDrag;
	    Delta childDrag;
	    Node draggedChild;

	List<Label> distances = new ArrayList<Label>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		hiddenPane.setContent(canvasGroup);
		slider = new JFXSlider(-100, 300, 0);
		slider.setPrefWidth(155);
		slider.setPrefHeight(10);
		slider.setSnapToTicks(true);
		slider.setMinorTickCount(100);
		slider.setStyle("-fx-background-color: linear-gradient(to right, white,  #3b5998);");
		// slider.setBlendMode(BlendMode.MULTIPLY);
		slider.setCursor(Cursor.CLOSED_HAND);
		nodesList.addAnimatedNode(slider);
		nodesList.setSpacing(-10D);
		nodesList.setRotate(200D);
		slider.toFront();
		nodesList.toFront();

		Color c1 = Color.web("rgba(0,0,255,0.5)");
		Color c2 = Color.web("rgba(255,0,0,0.5)");
		Rectangle m1 = new Rectangle();
		m1.setTranslateX(200 + 2 * 20);
		m1.setTranslateY(200);
		m1.setWidth(200);
		m1.setHeight(300);
		m1.setFill(c2);
		m1.setStroke(Color.BLACK);
		m1.setStrokeWidth(2);
		Label l1 = new Label("10.8490-7.0460");
		l1.setTextFill(c2);
		l1.setLayoutX(218);
		l1.setLayoutY(185);

		Rectangle m2 = new Rectangle();
		m2.setTranslateX(200 + 120);
		m2.setTranslateY(200 + 40);
		m2.setWidth(200);
		m2.setHeight(300);
		m2.setFill(c1);
		m2.setStroke(Color.BLACK);
		m2.setStrokeWidth(2);
		M0Button.setSelected(true);
		M1Button.setSelected(true);
		canvasGroup.getChildren().addAll(m1, m2);

		M0Button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (M0Button.isSelected()) {
					canvasGroup.getChildren().add(m1);
				} else {
					canvasGroup.getChildren().remove(m1);
				}
			}
		});
		
		M1Button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (M1Button.isSelected()) {
					canvasGroup.getChildren().add(m2);
				} else {
					canvasGroup.getChildren().remove(m2);
				}
			}
		});
      // zoom
//		anchorRoot.setOnScroll(new EventHandler<ScrollEvent>() {
//			@Override
//			public void handle(ScrollEvent event) {
//				double scrollY = event.getDeltaY();
//				hiddenPane.setScaleX(hiddenPane.getScaleX() + scrollY / 300);
//				hiddenPane.setScaleY(hiddenPane.getScaleY() + scrollY / 300);
//			}
//		});
		// drag
//		canvasGroup.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                boardDrag = new Delta(event.getX(), event.getY());
//            }
//        });
//		canvasGroup.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                hiddenPane.setTranslateX(hiddenPane.getTranslateX() + event.getX() - boardDrag.x);
//                hiddenPane.setTranslateY(hiddenPane.getTranslateY() + event.getY() - boardDrag.y);
//                boardDrag.x = event.getX();
//                boardDrag.y = event.getY();
//            }
//        });
		// drag
		
//		anchorRoot.setOnKeyPressed(new EventHandler<KeyEvent>() {
//			@Override
//			public void handle(KeyEvent event) {
//			if(event.getCode()==KeyCode.UP)	 {
//				hiddenPane.setTranslateY(hiddenPane.getTranslateY() -30);
//			}
//			
//			if(event.getCode()==KeyCode.DOWN) {
//				hiddenPane.setTranslateY(hiddenPane.getTranslateY() +30);
//			}
//			if(event.getCode()==KeyCode.RIGHT)	 {
//				hiddenPane.setTranslateX(hiddenPane.getTranslateX() +30);
//			}
//			
//			if(event.getCode()==KeyCode.LEFT) {
//				hiddenPane.setTranslateX(hiddenPane.getTranslateX() -30);
//			}
//				
//			}
//		});
	}
    

    @FXML
	public void HandleScroll(ScrollEvent event) {
		double scrollY = event.getDeltaY();
		hiddenPane.setScaleX(hiddenPane.getScaleX() + scrollY / 300);
		hiddenPane.setScaleY(hiddenPane.getScaleY() + scrollY / 300);
	}
	@FXML
	  public void MouseDrag(MouseEvent event) {
        hiddenPane.setTranslateX(hiddenPane.getTranslateX() + event.getX() - boardDrag.x);
        hiddenPane.setTranslateY(hiddenPane.getTranslateY() + event.getY() - boardDrag.y);
        boardDrag.x = event.getX();
        boardDrag.y = event.getY();
    }
	@FXML
	 public void MousePress(MouseEvent event) {
        boardDrag = new Delta(event.getX(), event.getY());
    }
	@FXML
	public void KeyCode(KeyEvent event) {
		if(event.getCode()==KeyCode.UP)	 {
			hiddenPane.setTranslateY(hiddenPane.getTranslateY() -30);
		}
		
		if(event.getCode()==KeyCode.DOWN) {
			hiddenPane.setTranslateY(hiddenPane.getTranslateY() +30);
		}
		if(event.getCode()==KeyCode.RIGHT)	 {
			hiddenPane.setTranslateX(hiddenPane.getTranslateX() +30);
		}
		
		if(event.getCode()==KeyCode.LEFT) {
			hiddenPane.setTranslateX(hiddenPane.getTranslateX() -30);
		}
	}

	@FXML
	public void M0Handle(ActionEvent event) {
	}

	@FXML
	public void M1Handle(ActionEvent event) {

	}

	@FXML
	public void M2Handle(ActionEvent event) {

	}

	@FXML
	public void M3Handle(ActionEvent event) {

	}

	@FXML
	public void M4Handle(ActionEvent event) {

	}

}