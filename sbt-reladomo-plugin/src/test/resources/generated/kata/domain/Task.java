package kata.domain;
import java.sql.Timestamp;
public class Task extends TaskAbstract
{
	public Task(Timestamp processingDate
	)
	{
		super(processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public Task()
	{
		this(kata.util.TimestampProvider.getInfinityDate());
	}
}
