package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class PositionQuantityList extends PositionQuantityListAbstract
{
	public PositionQuantityList()
	{
		super();
	}

	public PositionQuantityList(int initialSize)
	{
		super(initialSize);
	}

	public PositionQuantityList(Collection c)
	{
		super(c);
	}

	public PositionQuantityList(Operation operation)
	{
		super(operation);
	}
}
