package hedspi.group28.controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ProgressBarController {
	
	@FXML private ImageView PauseButton;
	@FXML private ImageView NextButton;
	@FXML private ImageView PrevButton;
	

	public void initialize() {
	    PauseButton.setOnMouseClicked(event -> {
	        // Xử lý khi ImageView PauseButton được nhấn
	        System.out.println("PauseButton clicked!");
	        // Thêm code xử lý dừng hoặc tạm dừng ở đây
	    });
	    NextButton.setOnMouseClicked(event -> {
	        // Xử lý khi ImageView PauseButton được nhấn
	        System.out.println("PauseButton clicked!");
	        // Thêm code xử lý dừng hoặc tạm dừng ở đây
	    });
	    PrevButton.setOnMouseClicked(event -> {
	        // Xử lý khi ImageView PauseButton được nhấn
	        System.out.println("PauseButton clicked!");
	        // Thêm code xử lý dừng hoặc tạm dừng ở đây
	    });
	    
	    addClickAnimation(PauseButton);
	    addClickAnimation(NextButton);
	    addClickAnimation(PrevButton);
	}
	
	private void addClickAnimation(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), imageView);
            scaleTransition.setToX(1.2); // Scale to 1.2 times in X-axis
            scaleTransition.setToY(1.5); // Scale to 1.2 times in Y-axis
            scaleTransition.setAutoReverse(true);
            scaleTransition.setCycleCount(2);
            scaleTransition.play();
            
            // Add additional actions here when the ImageView is clicked
        });
    }
}
