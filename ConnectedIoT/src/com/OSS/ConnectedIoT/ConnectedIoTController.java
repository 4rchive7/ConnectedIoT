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
	}
	
	
	public void CreateProjectPage(ActionEvent event)
	{
		System.out.println("Go to Project Create Scene"); // ������Ʈ ���� â���� �̵��Ѵ�
		
		try {
			Parent createScene =  FXMLLoader.load(getClass().getResource("CreateProject.fxml"));
			Scene scene = new Scene(createScene);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = (Stage) createproject.getScene().getWindow();
			primaryStage.setScene(scene);
			
			// ������ ��ư�� �����ϴ� Stage�� getWindow()�� ���ؼ� ����, �� Stage���� ���� ������� CreateProject.fxml�� �ҷ��� scene�� ������ ����̴�.
			// �ִϸ��̼ǰ� ���� ȭ����ȯ�� �ʿ���⶧����, �̷��� ������ε� �����ϴ�.
			// ����ȭ����, �� ���� �ִϸ��̼��� �ʿ���⶧���� �̷��� �����Ͽ�����, ���Ŀ� �ִϸ��̼����� ���ÿ� Scene���� �׾ƾ��� ���� �����, �׶��� StackPane�� �̿��Ͽ��� �ؾ��Ѵ�
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
