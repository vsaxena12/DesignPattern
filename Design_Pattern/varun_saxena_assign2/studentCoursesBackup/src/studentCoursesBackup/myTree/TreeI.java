package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;

public interface TreeI
{
	Node find(int index);
	void insertNode(Node newNode);
	String printNodes();
}
