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

	@FXML private Button createproject; // ������Ʈ ���� â���� �̵��ϴ� ��ư
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
			// �̰� Stage�� �״�� ��ü�ϴ� ������� �̷������ �ȴ�. ��, ������ main�������� ���ư��� �ȴ�.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CreateProjectPage(ActionEvent event)
	{
		System.out.println("Go to Project Create Scene"); // ������Ʈ ���� â���� �̵��Ѵ�
		
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
			
			// ������ ��ư�� �����ϴ� Stage�� getWindow()�� ���ؼ� ����, �� Stage���� ���� ������� CreateProject.fxml�� �ҷ��� scene�� ������ ����̴�.
			// �ִϸ��̼ǰ� ���� ȭ����ȯ�� �ʿ���⶧����, �̷��� ������ε� �����ϴ�.
			// ����ȭ����, �� ���� �ִϸ��̼��� �ʿ���⶧���� �̷��� �����Ͽ�����, ���Ŀ� �ִϸ��̼����� ���ÿ� Scene���� �׾ƾ��� ���� �����, �׶��� StackPane�� �̿��Ͽ��� �ؾ��Ѵ�
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
