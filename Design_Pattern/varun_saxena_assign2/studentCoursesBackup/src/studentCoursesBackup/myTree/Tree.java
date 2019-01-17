package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.Stack;
//BST Code
public class Tree implements TreeI
{
	private Node root;

	public Tree()
	{
		root = null;
	}

	public Node find(int index)
	{
		Node current = root;
		if(root==null)
		{
			return null;
		}
		while(current.getNode()!=index)
		{
			if(index<current.getNode())
			{
				current = current.getLeft();
			}
			else
				{
				current = current.getRight();
			}
			if(current==null)
			{
				return null;
			}
		}
		return current;
	}

	public void insertNode(Node newNode)
	{
		int index = newNode.getNode();
		if(find(index)==null)
		{
			if(root == null)
			{
				root = newNode;
			}
			else
				{
				Node current = root;
				Node parent;
				while(true)
				{
					parent = current;
					if(index<current.getNode())
					{
						current = current.getLeft();
						if(current == null)
						{
							parent.setLeft(newNode);
							break;
						}
					}
					else
						{
						current = current.getRight();
						if(current == null)
						{
							parent.setRight(newNode);
							break;
						}
					}
				}
			}
		}
	}

	public String printNodes()
	{
		StringBuilder output= new StringBuilder();
		try
		{
			if(root == null)
			{
				System.out.println("tree is empty");
			}
			Stack<Node> temp = new Stack<Node>();
			Node current = root;
			while(!temp.isEmpty() || current !=null)
			{
				if(current !=null)
				{
					temp.push((Node) current);
					current = current.getLeft();
				}
				else
					{
					Node tempNode = temp.pop();
					ArrayList<String> courseList = tempNode.getAllCourses();
					int tempNodeIndex = tempNode.getNode();
					String fillerText = "";
					//added padded zeros to maintain number format
					if(tempNodeIndex<10)
					{
						fillerText +="00";
					}
					else if(tempNodeIndex<100)
					{
						fillerText +="0";
					}

					output.append(fillerText).append(tempNodeIndex).append(": ");
					if(!courseList.isEmpty())
					{
						for(int i=0;i<courseList.size()-1;i++)
						{
							output.append(courseList.get(i)).append(", ");
						}
						output.append(courseList.get(courseList.size() - 1));
					}
					output.append("\n");
					current = tempNode.getRight();
				}
			}
		}
		catch(Exception e){
			System.out.println("Error ");
		}
		finally{}
		return output.toString();
	}

}
