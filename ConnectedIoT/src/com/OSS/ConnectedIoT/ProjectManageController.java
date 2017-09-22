package com.OSS.ConnectedIoT;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProjectManageController implements Initializable{

	@FXML private Button Cancel; // ������Ʈ �������� �����ϰų� ����ϴ� ��ư
	@FXML private Button Choose;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				GoBackToMain(event);
			}
			
		});
		
		Choose.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		
			
		});
		
		
		
	}
	
	
	// ��� ��ư�� ������ ��, ������ Main Scene�� �����ش�.
		public void GoBackToMain(ActionEvent event)
		{
			System.out.println("Close Create Stage");
			
			Stage primaryStage = (Stage) Cancel.getScene().getWindow();
			primaryStage.setResizable(false);
			
			primaryStage.setTitle("Connected IoT - Main Page");
			
			Parent createScene;
			try {
				createScene = FXMLLoader.load(getClass().getResource("ConnectedIoT.fxml"));
				Scene scene = new Scene(createScene);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
				primaryStage.setScene(scene);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
