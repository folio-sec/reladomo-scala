package kata.domain;
import java.util.*;
import com.gs.fw.common.mithra.MithraList;
import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.list.*;
import com.gs.fw.common.mithra.list.merge.TopLevelMergeOptions;
import com.gs.fw.finder.OrderBy;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.util.*;
import com.gs.fw.common.mithra.notification.*;
import com.gs.fw.common.mithra.notification.listener.*;
import com.gs.fw.common.mithra.list.cursor.Cursor;
import com.gs.fw.common.mithra.bulkloader.*;
/**
* This file was automatically generated using Mithra 17.0.2. Please do not modify it.
* Add custom logic to its subclass instead.
*/
// Generated from templates/transactional/ListAbstract.jsp
public class TaskListAbstract extends DelegatingList<Task> implements MithraDatedTransactionalList<Task>
{
	public TaskListAbstract()
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this);
	}

	public TaskListAbstract(int initialSize)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, initialSize);
	}

	public TaskListAbstract(Collection c)
	{
		super();
		this.setDelegated(AbstractTransactionalNonOperationBasedList.DEFAULT);
		AbstractTransactionalNonOperationBasedList.DEFAULT.init(this, c);
	}

	public TaskListAbstract(com.gs.fw.finder.Operation operation)
	{
		super(operation);
		this.setDelegated(AbstractTransactionalOperationBasedList.DEFAULT);
	}

	public Task[] elements()
	{
		Task[] result = new Task[size()];
		this.getDelegated().toArray(this, result);
		return result;
	}

	public TaskList intersection(TaskList another)
	{
		return (TaskList)super.intersection(another);
	}

	public Task getTaskAt(int index)
	{
		return (Task)this.get(index);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return TaskFinder.getMithraObjectPortal();
	}

	public TaskList getNonPersistentCopy()
	{
		TaskList result = new TaskList();
		zCopyNonPersistentInto(result);
		return result;
	}

	public TaskList asAdhoc()
	{
		return (TaskList) super.asAdhoc();
	}

	public MithraDatedTransactionalList getNonPersistentGenericCopy()
	{
		return this.getNonPersistentCopy();
	}

	/**
	* Return a view of this list that implements GS Collections MutableList API.
	* Since the returned list will be operation-based, it is effectively read-only,
	* so mutating methods will throw a RuntimeException.
	* (Implemented by a light-weight adapter, not a copy)
	*/
	public com.gs.collections.api.list.MutableList<Task> asGscList()
	{
		return com.gs.collections.impl.list.mutable.ListAdapter.adapt(this);
	}

	public TaskList merge(MithraTransactionalList<Task> incoming, TopLevelMergeOptions<Task> mergeOptions)
	{
		return (TaskList) super.merge(incoming, mergeOptions);
	}

	public TaskList getDetachedCopy()
	{
		TaskList result = new TaskList();
		zDetachInto(result);
		return result;
	}

	public void zMakeDetached(Operation op, Object previousDetachedList)
	{
		super.zMakeDetached(op, previousDetachedList);
	}

	protected void generateAndSetPrimaryKeys()
	{
	}

	public void setName(String newValue)
	{
		zSetString(TaskFinder.name(), newValue);
	}

	public void setProcessingDateFrom(Timestamp newValue)
	{
		zSetTimestamp(TaskFinder.processingDateFrom(), newValue);
	}

	public void setProcessingDateTo(Timestamp newValue)
	{
		zSetTimestamp(TaskFinder.processingDateTo(), newValue);
	}

	public void setStatus(String newValue)
	{
		zSetString(TaskFinder.status(), newValue);
	}

	public void setTaskId(int newValue)
	{
		zSetInteger(TaskFinder.taskId(), newValue);
	}

	public void purgeAll()
	{
		super.purgeAll();
	}

	public void terminateAll()
	{
		super.terminateAll();
	}
}
