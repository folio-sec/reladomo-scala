package kata.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class TaskList extends TaskListAbstract
{
	public TaskList()
	{
		super();
	}

	public TaskList(int initialSize)
	{
		super(initialSize);
	}

	public TaskList(Collection c)
	{
		super(c);
	}

	public TaskList(Operation operation)
	{
		super(operation);
	}
}
