package studentCoursesBackup.myTree;

import java.util.ArrayList;
public class Node implements ObserverI, SubjectI, Cloneable
{
	private int bNumber;
	private ArrayList<String> courses;
	private ArrayList<ObserverI> observers;
	private Node left;
	private Node right;

	public Node(int studentBNumber){
		bNumber = studentBNumber;
		courses = new ArrayList<String>();
		observers = new ArrayList<ObserverI>();
		left = null;
		right = null;
	}

	public int getNode()
	{
		return this.bNumber;
	}

	public Node nodeClone()
	{
		Node tmpNode = new Node(this.getNode());
		tmpNode.courses = this.courses;
		tmpNode.observers = this.observers;
		tmpNode.left = this.left;
		tmpNode.right = this.right;

		return tmpNode;
	}

	public void insertCourse(String course)
	{
		if(!courses.contains(course))
		{
			courses.add(course);
		}
	}

	public void deleteCourse(String course)
	{
		if(courses.contains(course))
		{
			int courseIndex = courses.indexOf(course);
			courses.remove(courseIndex);
		}
	}

	public ArrayList<String> getAllCourses()
	{
		return courses;
	}

	public void setLeft(Node node)
	{
		left = node;
	}

	public void setRight(Node node)
	{
		right = node;
	}

	public Node getLeft()
	{
		return this.left;
	}

	public Node getRight()
	{
		return this.right;
	}

	@Override
	public void update(ObserverI.UPDATEENUM oper, ObserverI obs, String str)
	{
		Node temp = (Node) obs;
		temp.deleteCourse(str);
	}

	@Override
	public void registerObserver(ObserverI obs)
	{
		observers.add(obs);
	}

	@Override
	public void removeObserver(ObserverI obs)
	{
		if(observers.contains(obs))
		{
			observers.remove(obs);
		}
	}

	public ObserverI.UPDATEENUM SubToObs(SubjectI.NOTIFYENUM oper)
	{
		return ObserverI.UPDATEENUM.values()[oper.ordinal()];
	}

	@Override
	public void notifyAllObservers(SubjectI.NOTIFYENUM oper, String str)
	{
		ObserverI.UPDATEENUM val = SubToObs(oper);
		if(!observers.isEmpty())
		{
			for(ObserverI tmp : observers)
			{
				update(val,tmp,str);
			}
		}
	}

}