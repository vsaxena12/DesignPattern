package studentCoursesBackup.myTree;
//Interface for Observer
public interface ObserverI
{
	enum UPDATEENUM{
		INSERT,
		DELETE
	}
	void update(ObserverI.UPDATEENUM oper,
				ObserverI obs, String course)throws Exception;
}
