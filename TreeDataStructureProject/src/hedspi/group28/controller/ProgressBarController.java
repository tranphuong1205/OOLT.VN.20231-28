package hedspi.group28.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

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
	}
	
	
}
