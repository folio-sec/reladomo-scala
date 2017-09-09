package kata.domain;

import com.gs.fw.finder.Operation;

import java.util.Collection;

public class ObjectSequenceList extends ObjectSequenceListAbstract
{
	public ObjectSequenceList()
	{
		super();
	}

	public ObjectSequenceList(int initialSize)
	{
		super(initialSize);
	}

	public ObjectSequenceList(Collection c)
	{
		super(c);
	}

	public ObjectSequenceList(Operation operation)
	{
		super(operation);
	}
}
