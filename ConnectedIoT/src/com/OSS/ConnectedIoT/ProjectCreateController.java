package com.OSS.ConnectedIoT;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// ������Ʈ ������ �ϴ� â���� �̺�Ʈó���� ����� Controller

public class ProjectCreateController implements Initializable{

	@FXML private Button Create;
	@FXML private Button CancelCreate;
	
	@FXML private TextField projectName;
	@FXML private TextArea projectInfo;
	
	@FXML private ComboBox protocolBox;
	
	
	private String[] protocolList = {"TCP","UDP","COAP","MQTT"};
	
	ObservableList<String> options = FXCollections.observableArrayList(
	
			protocolList
	);
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		SetProtocolBox();
		
		Create.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				AddProject(event);
			}
	
		});
		
		
		CancelCreate.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				GoBackToMain(event);
			}
			
		});

		
		
	}

	// Protocol ComboBox�� �����Ѵ�.
	public void SetProtocolBox()
	{
		protocolBox.setItems(options);
	}
	
	
	// ��� ��ư�� ������ ��, ������ Main Scene�� �����ش�.
	public void GoBackToMain(ActionEvent event)
	{
		System.out.println("Close Create Stage");
		
		Stage primaryStage = (Stage) projectName.getScene().getWindow();
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
		
	
	public void AddProject(ActionEvent event)
	{
		System.out.println("Create Project");
		//���⼭ �ϴ� ��ȿ�� �˻縦 �ؾ��Ѵ�
		
		if(checkProject())
		{
			Project thisProject = new Project(projectName.getText(),projectInfo.getText());
			
			GoBackToMain(event);
		}
		else
		{
			System.out.println("���� �߰�"); 
			// ���� �޼��� ���� �˾����� ����� �Ѵ�. � ���������� �Բ�.
		}
	
		
	}
	
	public boolean checkProject()
	{
		// �Ѱ��� ������ �˻��س����鼭 return false�� �Ѵ�.
		if(checkProjectName() == false)
			return false; 
		
		return true;
	}
	
	public boolean checkProjectName()
	{
		String name = projectName.getText();
		
		if(name == null)
			return false;
		if("".equals(name))
			return false;
		
		return true;
	}
	
	public boolean checkProjectInfo()
	{
		String info = projectInfo.getText();
		
		if(info == null)
			return false;
			
		return true;
	}
	
		
}
