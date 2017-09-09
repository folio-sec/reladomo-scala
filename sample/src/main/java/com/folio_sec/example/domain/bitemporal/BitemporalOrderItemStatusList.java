package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class BitemporalOrderItemStatusList extends BitemporalOrderItemStatusListAbstract
{
	public BitemporalOrderItemStatusList()
	{
		super();
	}

	public BitemporalOrderItemStatusList(int initialSize)
	{
		super(initialSize);
	}

	public BitemporalOrderItemStatusList(Collection c)
	{
		super(c);
	}

	public BitemporalOrderItemStatusList(Operation operation)
	{
		super(operation);
	}
}
