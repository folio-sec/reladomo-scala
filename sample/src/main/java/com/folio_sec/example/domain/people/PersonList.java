package com.folio_sec.example.domain.people;
import com.gs.fw.finder.Operation;
import java.util.*;
public class PersonList extends PersonListAbstract
{
	public PersonList()
	{
		super();
	}

	public PersonList(int initialSize)
	{
		super(initialSize);
	}

	public PersonList(Collection c)
	{
		super(c);
	}

	public PersonList(Operation operation)
	{
		super(operation);
	}
}
