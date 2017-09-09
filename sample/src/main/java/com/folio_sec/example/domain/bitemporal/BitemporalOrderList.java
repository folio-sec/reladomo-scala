package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class BitemporalOrderList extends BitemporalOrderListAbstract
{
	public BitemporalOrderList()
	{
		super();
	}

	public BitemporalOrderList(int initialSize)
	{
		super(initialSize);
	}

	public BitemporalOrderList(Collection c)
	{
		super(c);
	}

	public BitemporalOrderList(Operation operation)
	{
		super(operation);
	}
}
