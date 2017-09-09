package com.folio_sec.example.domain.bitemporal;
import com.gs.fw.finder.Operation;
import java.util.*;
public class ProductList extends ProductListAbstract
{
	public ProductList()
	{
		super();
	}

	public ProductList(int initialSize)
	{
		super(initialSize);
	}

	public ProductList(Collection c)
	{
		super(c);
	}

	public ProductList(Operation operation)
	{
		super(operation);
	}
}
