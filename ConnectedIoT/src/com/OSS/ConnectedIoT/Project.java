package com.OSS.ConnectedIoT;

import java.util.ArrayList;

// ������Ʈ ������ �����Ǵ� ConnectedIoT Ư����, ������Ʈ�� ������ �־���Ѵ�.
public class Project { 

	private String projectName = null; // ������Ʈ �̸�
	private String projectInfo = null; // ������Ʈ ����
	private String createData = null; // ������Ʈ ������
	 
	// ��Ÿ ��� �󸶵��� �߰��� �� �ִ�
	
	private ArrayList<Node> myNodes = null; // ������ ���� ArrayList�� �ʿ��ϴ�
	
	Project()
	{
		myNodes = new ArrayList<Node>(); // ArrayList�� �ʱ�ȭ�ϰ� �����ϵ��� �Ѵ�.		
	}
	
}
