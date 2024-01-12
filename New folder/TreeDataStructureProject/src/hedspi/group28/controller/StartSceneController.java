package hedspi.group28.controller;
import java.io.IOException;

import hedspi.group28.controller.tree.AVLController;
import hedspi.group28.controller.tree.BBSTController;
import hedspi.group28.controller.tree.BSTController;
import hedspi.group28.controller.tree.GenController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.animation.FadeTransition;

import javafx.util.Duration;

public class StartSceneController {

	@FXML private Button Start;
    @FXML private Button Genid;
    @FXML private Button BSTid;
    @FXML private Button AVLid;
    @FXML private Button BBSTid;
    @FXML private Button About;
  
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/MainScene.fxml"));
    
    @FXML
    public void initialize() {
        Start.setOnAction(e -> handleStart());
        Genid.setOnAction(e -> handleGen());
        BSTid.setOnAction(e -> handleBST());
        AVLid.setOnAction(e -> handleAVL());
        BBSTid.setOnAction(e -> handleBBST());
        About.setOnAction(e -> handleAbout());
    }
    @FXML
    public void handleStart() {
        boolean allVisible = Genid.isVisible() && BSTid.isVisible() && AVLid.isVisible() && BBSTid.isVisible();
        if (allVisible) {
            fadeOutButtons();
        } else {
            fadeInButtons();
        }
    }

    public void handleGen() {
    	loader.setController(new GenController());
    	openMainScene();
    }
    
    public void handleBST() {
    	loader.setController(new BSTController());
    	openMainScene();
    }
    
    public void handleAVL() {
    	loader.setController(new AVLController());
    	openMainScene();
    }
    
    public void handleBBST() {
    	loader.setController(new BBSTController());
    	openMainScene();
    }
    
    public void openMainScene() {
        try {
            Stage currentStage = (Stage) Start.getScene().getWindow();
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            ExitManager.setExitHandler(stage); // Thiết lập xử lý thoát cho cửa sổ mới

            stage.show();
            currentStage.close(); // Đóng scene cũ
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private FadeTransition createFadeTransition(double fromValue, double toValue, double durationSeconds) {
        FadeTransition transition = new FadeTransition(Duration.seconds(durationSeconds));
        transition.setFromValue(fromValue);
        transition.setToValue(toValue);
        return transition;
    }

    private void fadeInButtons() {
        fadeInTransitionForButton(Genid);
        fadeInTransitionForButton(BSTid);
        fadeInTransitionForButton(AVLid);
        fadeInTransitionForButton(BBSTid);
    }

    private void fadeInTransitionForButton(Button button) {
        button.setVisible(true);
        FadeTransition fadeInTransition = createFadeTransition(0, 1, 0.5);
        fadeInTransition.setNode(button);
        fadeInTransition.play();
    }


    private void fadeOutButtons() {
        fadeOutTransitionForButton(Genid);
        fadeOutTransitionForButton(BSTid);
        fadeOutTransitionForButton(AVLid);
        fadeOutTransitionForButton(BBSTid);
    }

    private void fadeOutTransitionForButton(Button button) {
        FadeTransition fadeOutTransition = createFadeTransition(1, 0, 0.5);
        fadeOutTransition.setNode(button);
        fadeOutTransition.setOnFinished(event -> button.setVisible(false));
        fadeOutTransition.play();
    }
  
    @FXML
    private void handleAbout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/group28/view/about.fxml"));
            Parent root = loader.load();
            Stage aboutStage = new Stage();
            aboutStage.setScene(new Scene(root));
            aboutStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
