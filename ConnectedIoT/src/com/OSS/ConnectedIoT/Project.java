package com.OSS.ConnectedIoT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

// ������Ʈ ������ �����Ǵ� ConnectedIoT Ư����, ������Ʈ�� ������ �־���Ѵ�.
public class Project { 

	private String projectName = null; // ������Ʈ �̸�
	private String projectInfo = null; // ������Ʈ ����
	private String createDate = null; // ������Ʈ ������
	
	private String projectAddition = "";
	// ��Ÿ ��� �󸶵��� �߰��� �� �ִ�
	
	private ArrayList<Node> myNodes = null; // ������ ���� ArrayList�� �ʿ��ϴ�
	
	Project()
	{
		myNodes = new ArrayList<Node>(); // ArrayList�� �ʱ�ȭ�ϰ� �����ϵ��� �Ѵ�.		
	}
	
	Project(String projectName, String projectInfo)
	{
		this.projectInfo = projectInfo;
		this.projectName = projectName;
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat current = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");
		// ���� �ð��� ���ؼ� ���ڿ��� �����ϴ� �κ�
		this.createDate = current.format(cal.getTime());
		
		myNodes = new ArrayList<Node>();
		
		// ����ٰ� ������ �߰��ؾ��Ѵ�.
	}
	
	Project(String projectName, String projectInfo, String projectAddition)
	{
		this.projectInfo = projectInfo;
		this.projectName = projectName;
		this.projectAddition = projectAddition;
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat current = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");
		// ���� �ð��� ���ؼ� ���ڿ��� �����ϴ� �κ�
		this.createDate = current.format(cal.getTime());
		
		myNodes = new ArrayList<Node>();
		
		// ����ٰ� ������ �߰��ؾ��Ѵ�.
	}
	
	public String getProjectName()
	{
		return this.projectName;
	}
	
	public String getProejctInfo()
	{
		return this.projectInfo;
	}
	
	public String getCreateDate()
	{
		return this.createDate;
	}
	
	public String getProjectAddition()
	{
		return this.projectAddition;
	}
	
}
