package com.folio_sec.example.domain.bitemporal;
import java.sql.Timestamp;
public class PositionQuantity extends PositionQuantityAbstract
{
	public PositionQuantity(Timestamp businessDate
	, Timestamp processingDate
	)
	{
		super(businessDate
		,processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public PositionQuantity(Timestamp businessDate)
	{
		super(businessDate);
	}
}
