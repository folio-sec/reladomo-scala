package com.folio_sec.example.domain.issue003;
import java.sql.Timestamp;
public class BitemporalChildObject extends BitemporalChildObjectAbstract
{
	public BitemporalChildObject(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public BitemporalChildObject(Timestamp businessDate)
	{
		super(businessDate);
	}
}
