package studentCoursesBackup.myTree;
import studentCoursesBackup.util.FileProcessor;

import java.io.IOException;

public class TreeBuilder
{

	private TreeI nodeOrig;
	private TreeI clone1;
	private TreeI clone2;
	private String strLine;
	
	public TreeBuilder(String inputFile, String deleteFile) throws Exception
	{
		nodeOrig = new Tree();
		clone1 = new Tree();
		clone2 = new Tree();

		FileProcessor input = new FileProcessor(inputFile);
		FileProcessor delete = new FileProcessor(deleteFile);
		try{
			strLine = input.readLine();
			while(strLine!=null){
				if(!validFormat(strLine)){
					System.out.println("Wrong File");
				}
				else{
					int tempI = getBNumber(strLine);
					populateTree(tempI);
					strLine = input.readLine();
				}
			}
		
			strLine ="";
			strLine = delete.readLine();
			while(strLine!=null){
				if(!validFormat(strLine)){
					System.out.println("Wrong File");
				}
				else{
					int tempI = getBNumber(strLine);
					trimTrees(tempI);
					strLine = delete.readLine();
				}
			}
		}
		finally{}
	}

	public TreeI getTree(int flag)
	{
		TreeI interfaceTree = new Tree();
		if(flag==0)
		{
			interfaceTree = nodeOrig;
		}
		else if(flag==1)
		{
			interfaceTree = clone1;
		}
		else if(flag==2)
		{
			interfaceTree = clone2;
		}
		return interfaceTree;
	}

	private int getBNumber(String sIn){
		return intConvert(sIn.substring(0,3));
	}

	private int intConvert(String sIn)
	{
		int n = 0;
		int i = 0;

		while(i<sIn.length())
		{
			n = n*10+sIn.charAt(i)-'0';
			i++;
		}
		return n;
	}

	private String findCourse(String sIn)
	{
		return String.valueOf(sIn.charAt(sIn.length()-1));
	}

	private boolean validCourse(String sIn)
	{
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i=0;
		while(i<alphabets.length())
		{
			String temp = String.valueOf(alphabets.charAt(i));
			if(temp.equals(sIn))
			{
				return true;
			}
			i++;
		}
		return false;
	}

	private boolean validFormat(String sIn){
		if(sIn.length() > 5)
		{
			return false;
		}
		if(sIn.trim().length()==0)
		{
			return false;
		}

		String sub = sIn.substring(0,3);
		String list ="0123456789";
		int count =0;
		for(int i=0;i<sub.length();i++)
		{
			for(int j=0;j<list.length();j++)
			{
				if(sub.charAt(i)==list.charAt(j))
				{
					count++;
				}
			}
		}
		return count >= 3;
	}

	private void populateTree(int nodeIndex)
	{
		Node masterN = nodeOrig.find(nodeIndex);
		String tempCourse = findCourse(strLine);
		if(validCourse(tempCourse))
		{
			if(masterN==null)
			{
				Node  mNode = new Node(nodeIndex);
				mNode.insertCourse(tempCourse);
				Node backupNode1=null;
				Node backupNode2=null;
				if(mNode instanceof Cloneable)
				{
					backupNode1 = mNode.nodeClone();
					backupNode2 = mNode.nodeClone();
					mNode.registerObserver(backupNode1);
					mNode.registerObserver(backupNode2);
				}
				nodeOrig.insertNode(mNode);
				clone1.insertNode(backupNode1);
				clone2.insertNode(backupNode2);
			}
			else
			{
				masterN.insertCourse(tempCourse);
				Node backupNodes = clone1.find(nodeIndex);
				backupNodes.insertCourse(tempCourse);
				backupNodes = clone2.find(nodeIndex);
				backupNodes.insertCourse(tempCourse);
			}
		}
	}

	private void trimTrees(int nodeIndex) throws Exception
	{
		Node masterN = nodeOrig.find(nodeIndex);
		String courseDelete = findCourse(strLine);
		if(masterN!=null && validCourse(courseDelete))
		{
			masterN.deleteCourse(courseDelete);
			masterN.notifyAllObservers(SubjectI.NOTIFYENUM.DELETE,courseDelete);
		}
	}
}