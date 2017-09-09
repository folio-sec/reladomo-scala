package com.folio_sec.example.domain.bitemporal;
import java.sql.Timestamp;
public class BitemporalOrderItemStatus extends BitemporalOrderItemStatusAbstract
{
	public BitemporalOrderItemStatus(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public BitemporalOrderItemStatus(Timestamp businessDate)
	{
		super(businessDate);
	}
}
