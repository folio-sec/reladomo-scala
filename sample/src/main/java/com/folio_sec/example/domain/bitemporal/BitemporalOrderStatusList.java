package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class BitemporalOrderStatusList extends BitemporalOrderStatusListAbstract
{
	public BitemporalOrderStatusList()
	{
		super();
	}

	public BitemporalOrderStatusList(int initialSize)
	{
		super(initialSize);
	}

	public BitemporalOrderStatusList(Collection c)
	{
		super(c);
	}

	public BitemporalOrderStatusList(Operation operation)
	{
		super(operation);
	}
}
