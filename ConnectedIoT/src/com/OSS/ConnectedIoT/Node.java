package com.OSS.ConnectedIoT;

// ������ ������Ʈ�� �߰��ϰ� �Ǵ� ������ ��� Ŭ����. IoT����̽� �� ���� ������ �ʿ��ϴ�.
public class Node {

	
	private String NodeName; // Node�� �̸��� �����Ѵ�.
	private String ProtocolType; // ����ϴ� ���������� Ÿ���� �����Ѵ�.
	private String NodeInfo; // ��忡 ���� ����
	private String NodeLocation; // ��� ��ġ ���.. �̰� String�� �ƴ϶� �ٸ��ɷ� ��ü�ϴ°��� ���� ���� �ְڴ�.
	private String NodeAddress; // ����� IP�ּҳ�, http�ּ� ���� �㵵�� �Ѵ�.
	
	
	// �׿� ��͵��� �ʿ����� ��� �ܰ������� �߰��� �������� �Ѵ�.
	
	Node(String name, String protocol, String info, String address)
	{
		this.NodeAddress = address;
		this.ProtocolType = protocol;
		this.NodeInfo = info;
		this.NodeName = name;
		this.NodeLocation = "";
	}

	public String getNodeName()
	{
		return this.NodeName;
	}
	
	public String getProejctInfo()
	{
		return this.NodeInfo;
	}
	
	public String getCreateAddress()
	{
		return this.NodeAddress;
	}
	
	public String getNodeProtocol()
	{
		return this.ProtocolType;
	}
}
