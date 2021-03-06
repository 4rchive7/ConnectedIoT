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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConnectedIoTController implements Initializable{

	@FXML private Button createproject; // 프로젝트 생성 창으로 이동하는 버튼
	@FXML private Button manageproject;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		createproject.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				CreateProjectPage(event); 
			}
			
		});
		
		manageproject.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ManageProjectPage(event);
			}
			
		});
	}
	
	
	public void ManageProjectPage(ActionEvent event)
	{
		System.out.println("Go to Project Manage Scene");
		
		Stage primaryStage = (Stage) manageproject.getScene().getWindow();
		primaryStage.setResizable(false);
		try {
			primaryStage.setTitle("Connected IoT - Project Manage Page");
			Parent manageScene = FXMLLoader.load(getClass().getResource("ProjectManage.fxml"));
			Scene scene = new Scene(manageScene);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			// 이건 Stage를 그대로 대체하는 방식으로 이루어지게 된다. 즉, 이전의 main페이지는 날아가게 된다.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CreateProjectPage(ActionEvent event)
	{
		System.out.println("Go to Project Create Scene"); // 프로젝트 생성 창으로 이동한다
		
		Stage primaryStage = (Stage) manageproject.getScene().getWindow();
		primaryStage.setResizable(false);
		
		try {
			//Stage createStage = new Stage();
			//createStage.setResizable(false);
			//createStage.setTitle("Connected IoT - Project Create Page");
			primaryStage.setTitle("Connected IoT - Project Create Page");
			
			Parent createScene =  FXMLLoader.load(getClass().getResource("CreateProject.fxml"));
			Scene scene = new Scene(createScene);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Stage primaryStage = (Stage) createproject.getScene().getWindow();
			primaryStage.setScene(scene);
			
			//createStage.setScene(scene);
			//createStage.show();
			
			// 기존에 버튼이 존해하던 Stage를 getWindow()를 통해서 얻어내고, 그 Stage위에 새로 만들었던 CreateProject.fxml을 불러온 scene를 덮어씌우는 방법이다.
			// 애니메이션과 같은 화면전환이 필요없기때문에, 이러한 방법으로도 가능하다.
			// 메인화면은, 그 외의 애니메이션이 필요없기때문에 이렇게 구현하였으나, 추후에 애니메이션으로 스택에 Scene들을 쌓아야할 일이 생기면, 그때는 StackPane을 이용하여서 해야한다
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
