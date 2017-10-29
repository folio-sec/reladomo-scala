package com.folio_sec.example.domain.issue003;
import com.gs.fw.finder.Operation;
import java.util.*;
public class BitemporalChildObjectList extends BitemporalChildObjectListAbstract
{
	public BitemporalChildObjectList()
	{
		super();
	}

	public BitemporalChildObjectList(int initialSize)
	{
		super(initialSize);
	}

	public BitemporalChildObjectList(Collection c)
	{
		super(c);
	}

	public BitemporalChildObjectList(Operation operation)
	{
		super(operation);
	}
}
