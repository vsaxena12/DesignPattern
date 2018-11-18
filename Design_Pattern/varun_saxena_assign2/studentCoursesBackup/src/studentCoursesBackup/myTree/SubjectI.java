package studentCoursesBackup.myTree;
//Interface for Subject
public interface SubjectI {

	enum NOTIFYENUM{
		INSERT,
		DELETE
	}
	void registerObserver(ObserverI obs)throws Exception;
	void removeObserver(ObserverI obs)throws Exception;
	void notifyAllObservers(SubjectI.NOTIFYENUM oper, String str)throws Exception;
}
