package com.OSS.ConnectedIoT;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

// ������Ʈ ������ �ϴ� â���� �̺�Ʈó���� ����� Controller

public class ProjectCreateController implements Initializable{

	@FXML private Button testButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		testButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("ddddd");
			}
			
			
		});
		
	}
	

}
