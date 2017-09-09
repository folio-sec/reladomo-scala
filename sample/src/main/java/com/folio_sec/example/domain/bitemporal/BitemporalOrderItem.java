package com.folio_sec.example.domain.bitemporal;
import java.sql.Timestamp;
public class BitemporalOrderItem extends BitemporalOrderItemAbstract
{
	public BitemporalOrderItem(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public BitemporalOrderItem(Timestamp businessDate)
	{
		super(businessDate);
	}
}
