package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class BitemporalOrderItemList extends BitemporalOrderItemListAbstract
{
	public BitemporalOrderItemList()
	{
		super();
	}

	public BitemporalOrderItemList(int initialSize)
	{
		super(initialSize);
	}

	public BitemporalOrderItemList(Collection c)
	{
		super(c);
	}

	public BitemporalOrderItemList(Operation operation)
	{
		super(operation);
	}
}
