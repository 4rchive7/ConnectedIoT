package com.OSS.ConnectedIoT;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ProjectManageController implements Initializable{

	@FXML private Button Cancel; // ������Ʈ �������� �����ϰų� ����ϴ� ��ư
	@FXML private Button Choose;
	
	@FXML private TableView<ProjectModel> projects;
	
	private String path = "Projects";
	
	private ObservableList<ProjectModel> projectList = FXCollections.observableArrayList();
	
	// Initialize��, ��ó���� â�� �ҷ����� ����ǰ� �ȴ�. �׷��Ƿ�, ���⼭ ���̺� ��� �͵��� �߰��ؾ��Ѵ�.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
		File file = new File(path);
		File [] fileList = null;
		
		if(!file.exists())
		{
			file.mkdirs();
			System.out.println("Created Directory - Projects Folder");
		}
		else // �̹� Projects ������ �����Ǿ��ִٸ�
		{
			// ���ο��� ���丮���� ���� �����;��Ѵ�
			fileList = file.listFiles();
			
			// ���� ������ ������ ��������� �Ѵ�. ������ ������������ִ�.
			
			for(int i=0;i<fileList.length;i++)
			{
				// ���⼭ ���ϰ� ������ ���������
				
				if(fileList[i].isDirectory()==true)
				{
					String ProjectDate = fileList[i].getName(); // ������Ʈ�� �����ð��� ���������� �����س����� �Ѵ�.
					
					// �� �κ� ���������Ҷ� ���� �� �ؽö���� �ٸ� ����� ���ؼ� ��ȣȭ�ϰų� �� �� �־����� ���� �� ����.
					
					File metaData = new File(path+"//"+ProjectDate+"//ProjectData.data");
					// ������Ʈ ���η� ����.
					
					if(metaData.exists()) // ��Ÿ �����Ͱ� �����Ѵٸ�.
					{
						System.out.println("Load MetaData!");
						try {
							
							Scanner readData = new Scanner(metaData);
							
							String projectName = readData.nextLine(); // ù ��° �� ���� �д´�.
							// ex. ProjectName::������Ʈ���� �� ���� �������� �ۼ��� ���̴�.
						
							String[] projectNameSplit = projectName.split("::");
							
							String AfterProjectName = projectName.substring(projectNameSplit[0].length()+2, projectName.length());
							// projectNameSplit[0]�� ������ �κ��� ������Ʈ ���� �ȴ�.
							
							
							String projectInfo = readData.nextLine();
							String[] projectInfoSplit = projectInfo.split("::");
							
							String AfterProjectInfo = projectInfo.substring(projectInfoSplit[0].length()+2,projectInfo.length()); 
							// �ϴ� ���� �Ľ�. �� ���ķ� ��� �߰��س�����.
							
							
							while(readData.hasNextLine())
							{
								String tempInfo = readData.nextLine();
								//AfterProjectInfo += "\n";
								AfterProjectInfo += tempInfo; // ��� ���س�����.
							}
							
							projectList.add(new ProjectModel(AfterProjectName, AfterProjectInfo, ProjectDate));
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
			projects.setItems(projectList);
		}
		
		
		
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
