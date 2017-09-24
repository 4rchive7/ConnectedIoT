package com.OSS.ConnectedIoT;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProjectManageController implements Initializable{

	@FXML private Button Cancel; // ������Ʈ �������� �����ϰų� ����ϴ� ��ư
	@FXML private Button Choose;
	
	@FXML private TableView<ProjectModel> projects;
	
	private String path = "Projects";
	
	private ObservableList<ProjectModel> projectModelList = FXCollections.observableArrayList();
	
	private ArrayList<Project> projectList = null;
	
	private ProjectIOManager projectIO = new ProjectIOManager();
	
	// Initialize��, ��ó���� â�� �ҷ����� ����ǰ� �ȴ�. �׷��Ƿ�, ���⼭ ���̺� ��� �͵��� �߰��ؾ��Ѵ�.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		TableColumn tcName = projects.getColumns().get(0);
		TableColumn tcInfo = projects.getColumns().get(1);
		TableColumn tcDate = projects.getColumns().get(2);
		TableColumn tcAddition = projects.getColumns().get(3);
		
		tcName.setCellValueFactory(new PropertyValueFactory("projectName"));
		tcInfo.setCellValueFactory(new PropertyValueFactory("projectInfo"));
		tcDate.setCellValueFactory(new PropertyValueFactory("projectDate"));
		tcAddition.setCellValueFactory(new PropertyValueFactory("projectAddition"));
			
		
		// �̺κ��� ��Ī�ϴ� �κ��̴�.
		
		LoadProject();
		
		
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
	
	
	// �����͸� �ε��ϴ� �޼ҵ�
	// 1. Ư�� �������� �������� ������ Ȯ���Ѵ�
	// 2. �׸��� �ű⼭ �������� üũ�ϰ�, �ű⼭ �������� �ȴ�.
	public void LoadProject()
	{
		projectList = projectIO.LoadProjectData(); 
		
		for(int i=0;i<projectList.size();i++)
		{
			projectModelList.add(new ProjectModel(projectList.get(i)));
		}
		projects.setItems(projectModelList);
		
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
