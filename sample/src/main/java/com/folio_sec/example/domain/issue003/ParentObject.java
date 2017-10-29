package com.folio_sec.example.domain.issue003;
import java.sql.Timestamp;
public class ParentObject extends ParentObjectAbstract
{
	public ParentObject(Timestamp processingDate
	)
	{
		super(processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public ParentObject()
	{
		this(kata.util.TimestampProvider.getInfinityDate());
	}
}
