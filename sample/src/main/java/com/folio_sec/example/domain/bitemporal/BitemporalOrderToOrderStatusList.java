package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class BitemporalOrderToOrderStatusList extends BitemporalOrderToOrderStatusListAbstract
{
	public BitemporalOrderToOrderStatusList()
	{
		super();
	}

	public BitemporalOrderToOrderStatusList(int initialSize)
	{
		super(initialSize);
	}

	public BitemporalOrderToOrderStatusList(Collection c)
	{
		super(c);
	}

	public BitemporalOrderToOrderStatusList(Operation operation)
	{
		super(operation);
	}
}
