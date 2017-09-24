package com.OSS.ConnectedIoT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectIOManager {

	private String path = "Projects";
	
	private ArrayList<Project> returnList = new ArrayList<Project>();
	
	
	
	public ArrayList<Project> LoadProjectData()
	{
		returnList = new ArrayList<Project>();
		
		
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
							
							
							String projectAddition = readData.nextLine();
							
							String[] projectAdditionSplit = projectAddition.split("::");
							String AfterProjectAddition = projectAddition.substring(projectAdditionSplit[0].length()+2, projectAddition.length());
								
							
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
							
							returnList.add(new Project(AfterProjectName,AfterProjectInfo,AfterProjectAddition));
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
			
			
		}
		
		// ���⼭ ArrayList�� return�Ѵ�. �̶�, size == 0 �̸� 1���� �����������.
		return returnList;
		
	}
}
