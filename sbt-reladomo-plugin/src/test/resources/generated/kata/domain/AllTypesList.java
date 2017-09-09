package kata.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
public class AllTypesList extends AllTypesListAbstract
{
	public AllTypesList()
	{
		super();
	}

	public AllTypesList(int initialSize)
	{
		super(initialSize);
	}

	public AllTypesList(Collection c)
	{
		super(c);
	}

	public AllTypesList(Operation operation)
	{
		super(operation);
	}
}
