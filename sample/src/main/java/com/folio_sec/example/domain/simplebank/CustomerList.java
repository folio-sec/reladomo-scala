package com.folio_sec.example.domain.simplebank;
import com.gs.fw.finder.Operation;
import java.util.*;
public class CustomerList extends CustomerListAbstract
{
	public CustomerList()
	{
		super();
	}

	public CustomerList(int initialSize)
	{
		super(initialSize);
	}

	public CustomerList(Collection c)
	{
		super(c);
	}

	public CustomerList(Operation operation)
	{
		super(operation);
	}
}
