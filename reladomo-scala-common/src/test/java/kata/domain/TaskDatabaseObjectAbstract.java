package kata.domain;

import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.Attribute;
import com.gs.fw.common.mithra.behavior.AuditOnlyTransactionalDataContainer;
import com.gs.fw.common.mithra.behavior.TemporalContainer;
import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.cache.*;
import com.gs.fw.common.mithra.connectionmanager.ConnectionManagerWrapper;
import com.gs.fw.common.mithra.connectionmanager.SchemaManager;
import com.gs.fw.common.mithra.connectionmanager.SourcelessConnectionManager;
import com.gs.fw.common.mithra.connectionmanager.TablePartitionManager;
import com.gs.fw.common.mithra.database.MithraAbstractDatedTransactionalDatabaseObject;
import com.gs.fw.common.mithra.databasetype.DatabaseType;
import com.gs.fw.common.mithra.finder.MapperStackImpl;
import com.gs.fw.common.mithra.finder.RelatedFinder;
import com.gs.fw.common.mithra.finder.SqlQuery;
import com.gs.fw.common.mithra.util.MithraConfigurationManager;
import com.gs.fw.common.mithra.util.MithraTimestamp;
import com.gs.fw.common.mithra.util.TimestampPool;

import java.io.IOException;
import java.io.ObjectInput;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public abstract class TaskDatabaseObjectAbstract extends MithraAbstractDatedTransactionalDatabaseObject
implements MithraDatedTransactionalDatabaseObject, MithraDatedTransactionalObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "NAME,STATUS,IN_Z,OUT_Z";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.NAME,t0.STATUS,t0.IN_Z,t0.OUT_Z";
	private static final String PK_WITH_ALIAS = "t0.TASK_ID = ?";
	private static final String PK_INDEX_COLS = "TASK_ID";
	protected TaskDatabaseObjectAbstract()
	{
		super("Task", "kata.domain.TaskFinder",
			5, 5,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			true, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return TaskFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return TaskFinder.getFinderInstance();
	}

	public static TaskData allocateOnHeapData()
	{
		return new TaskData();
	}

	public static TaskData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new TaskData();
		data.zDeserializeFullData(in);
		return data;
	}

	public void deserializeAsOfAttributes(ObjectInput in, Timestamp[] asof) throws IOException, ClassNotFoundException
	{
		asof[0] = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestampWithInfinity(in, kata.util.TimestampProvider.getInfinityDate()), TaskFinder.isFullCache());
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		TaskData data = new TaskData();
		data.zDeserializePrimaryKey(in);
		Timestamp[] asof = new Timestamp[1];
		asof[0] = TimestampPool.getInstance().getOrAddToCache(MithraTimestamp.readTimezoneInsensitiveTimestampWithInfinity(in, kata.util.TimestampProvider.getInfinityDate()), TaskFinder.isFullCache());
		return this.createObject(data, asof);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullDatedTransactionalCache(TaskFinder.getPrimaryKeyAttributes(), TaskFinder.getAsOfAttributes(), this, TaskFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullDatedCache(TaskFinder.getPrimaryKeyAttributes(), TaskFinder.getAsOfAttributes(), this, TaskFinder.getImmutableAttributes());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialDatedTransactionalCache(TaskFinder.getPrimaryKeyAttributes(), TaskFinder.getAsOfAttributes(), this, TaskFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialDatedCache(TaskFinder.getPrimaryKeyAttributes(), TaskFinder.getAsOfAttributes(), this, TaskFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			TaskFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			TaskFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			Task.zConfigFullTx();
		}
		else
		{
			Task.zConfigNonTx();
		}
	}

	public List getSimulatedSequenceInitValues()
	{
		ArrayList simulatedSequenceInitValues = new ArrayList(1);
		Attribute[] primaryKeyAttributes = TaskFinder.getPrimaryKeyAttributes();
		SimulatedSequenceInitValues initValues = null;
		initValues = new SimulatedSequenceInitValues("Task",
			1, 1, 1,
			"kata.util.ObjectSequenceObjectFactory", false, primaryKeyAttributes[0], primaryKeyAttributes[0].getSourceAttributeType());
		simulatedSequenceInitValues.add(initValues);
		return simulatedSequenceInitValues;
	}

	public Object getSourceAttributeValueForSelectedObjectGeneric(SqlQuery query, int queryNumber)
	{
		return null;
	}

	public Object getSourceAttributeValueFromObjectGeneric(MithraDataObject object)
	{
		return null;
	}

	public Object getSourceAttributeValueGeneric(SqlQuery query, MapperStackImpl mapperStack, int queryNumber)
	{
		return null;
	}

	public String getDatabaseIdentifierGenericSource (Object source)
	{
		return connectionManager.getDatabaseIdentifier();
	}

	public DatabaseType getDatabaseTypeGenericSource(Object source)
	{
		return connectionManager.getDatabaseType();
	}

	public TimeZone getDatabaseTimeZoneGenericSource(Object source)
	{
		return getDatabaseTimeZone();
	}

	public Connection getConnectionGenericSource(Object source)
	{
		return connectionManagerWrapper.getConnection();
	}

	public BulkLoader createBulkLoaderGenericSource(Object source) throws BulkLoaderException 
	{
		return connectionManager.createBulkLoader();
	}

	public MithraDataObject inflateDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateTaskData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkTaskData(1, (TaskData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateTaskPkData(rs, dt);
	}

	public String getSchemaGenericSource(Object source)
	{
		if (this.schemaManager != null)
		{
			return this.schemaManager.getSchema(this.getDefaultSchema());
		}

		return this.getDefaultSchema();
	}

	public String getTableNameGenericSource(Object source) throws MithraDatabaseException
	{
		return getTaskTableName();
	}

	public String getTaskTableName() throws MithraDatabaseException
	{
		if (this.tablePartitionManager != null)
		{
			return this.tablePartitionManager.getTableName(this.getDefaultTableName());
		}

		return this.getDefaultTableName();
	}

	public void setPrimaryKeyAttributes(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		TaskData data = (TaskData)dataObj;
		TimeZone conversionTimeZone = null;
		pos = setPrimaryKeyAttributesWithoutOptimistic(stm,pos,dataObj,databaseTimeZone,dt);
		if (TaskFinder.getMithraObjectPortal().getTxParticipationMode().isOptimisticLocking())
		{
			conversionTimeZone = MithraTimestamp.DefaultTimeZone;
			dt.setTimestamp(stm, pos, data.getProcessingDateFrom(), false, conversionTimeZone);
			pos++;
		}
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		TaskData data = (TaskData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getTaskId());
		conversionTimeZone = MithraTimestamp.DefaultTimeZone;
		if (data.getProcessingDateTo().getTime() == TaskFinder.processingDate().getInfinityDate().getTime())
		{
			conversionTimeZone = MithraTimestamp.DefaultTimeZone;
		}

		dt.setTimestamp(stm, pos, data.getProcessingDateTo(), false, conversionTimeZone);
		pos++;
		return pos;
	}

	public String getPrimaryKeyWhereSql()
	{
		if (TaskFinder.getMithraObjectPortal().getTxParticipationMode().isOptimisticLocking())
		{
		}

		return "TASK_ID = ?";
	}

	public String getPrimaryKeyWhereSqlWithNullableAttribute(MithraDataObject dataObj)
	{
		return "";
	}

	public String getPrimaryKeyWhereSqlWithNullableAttributeWithDefaultAlias(MithraDataObject dataObj)
	{
		return "";
	}

	public String getColumnListWithPk(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.TASK_ID,t0.NAME,t0.STATUS,t0.IN_Z,t0.OUT_Z";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*5);
		result.append(databaseAlias).append(".").append("TASK_ID");
		result.append(",").append(databaseAlias).append(".").append("NAME");
		result.append(",").append(databaseAlias).append(".").append("STATUS");
		result.append(",").append(databaseAlias).append(".").append("IN_Z");
		result.append(",").append(databaseAlias).append(".").append("OUT_Z");
		return result.toString();
	}

	public Object getConnectionManager()
	{
		return connectionManager;
	}

	public void setConnectionManager(Object connectionManager, ConnectionManagerWrapper wrapper)
	{
		this.connectionManager = (SourcelessConnectionManager)connectionManager;
		this.connectionManagerWrapper = wrapper;
	}

	public TaskData inflateTaskData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		TaskData data = inflateTaskPkData(rs, dt);
		inflateNonPkTaskData(2, data, rs, dt);
		return data;
	}

	public TaskData inflateTaskPkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		TaskData _data = new TaskData();
		int _pos = 1;
		_data.setTaskId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "taskId");
		return _data;
	}

	public void inflateNonPkTaskData(int _pos, TaskData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			TaskData _data = _datax;
			_data.setName(trimString(_rs.getString(_pos++)));
			_data.setStatus(trimString(_rs.getString(_pos++)));
			Timestamp processingDateFromtimestampValue = _dt.getTimestampFromResultSet(_rs, _pos++, MithraTimestamp.DefaultTimeZone);
			_data.setProcessingDateFrom(processingDateFromtimestampValue);
			Timestamp processingDateTotimestampValue = _dt.getTimestampFromResultSet(_rs, _pos++, MithraTimestamp.DefaultTimeZone);
			if (processingDateTotimestampValue == null)
			{
				throw new MithraBusinessException("attribute ' processingDateTo ' is null in database but is not marked as nullable in mithra xml for primary key / "+_data.zGetPrintablePrimaryKey());
			}

			processingDateTotimestampValue = MithraTimestamp.zFixInfinity(processingDateTotimestampValue, MithraTimestamp.DefaultTimeZone,
				TaskFinder.processingDate().getInfinityDate());
			_data.setProcessingDateTo(processingDateTotimestampValue);
		}
	}

	public DatabaseType getDatabaseType()
	{
		return connectionManager.getDatabaseType();
	}

	public TimeZone getDatabaseTimeZone()
	{
		return connectionManager.getDatabaseTimeZone();
	}

	protected String getSchema()
	{
		return this.getSchemaGenericSource(null);
	}

	public String getFullyQualifiedTableName()
	{
		String schema = this.getSchemaGenericSource(null);
		String tableName = getTaskTableName();
		return this.getDatabaseType().getFullyQualifiedTableName(schema, tableName);
	}

	public void setSchemaManager(Object schemaManager)
	{
		if( schemaManager instanceof SchemaManager )
		{
			this.schemaManager = (SchemaManager) schemaManager;
		}
		else
		{
			throw new IllegalArgumentException( "Schema manager class " + schemaManager.getClass().getName()
			+ " does not implement SchemaManager.class" );
		}
	}

	public void setTablePartitionManager(Object tablePartitionManager)
	{
		if( tablePartitionManager instanceof TablePartitionManager )
		{
			this.tablePartitionManager = (TablePartitionManager) tablePartitionManager;
		}
		else
		{
			throw new IllegalArgumentException( "Table partition manager class " + tablePartitionManager.getClass().getName()
			+ " does not implement TablePartitionManager.class" );
		}
	}

	public String getTableName()
	{
		return this.getDefaultTableName();
	}

	public String getDefaultTableName()
	{
		return "TASK";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		TaskData data = (TaskData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getTaskId());
		if(data.isNameNull())
		{
			throwNullAttribute("name");
		}

		stm.setString(pos++, data.getName());
		if(data.isStatusNull())
		{
			throwNullAttribute("status");
		}

		stm.setString(pos++, data.getStatus());
		if(data.isProcessingDateFromNull())
		{
			throwNullAttribute("processingDateFrom");
		}

		conversionTimeZone = MithraTimestamp.DefaultTimeZone;
		dt.setTimestamp(stm, pos, data.getProcessingDateFrom(), false, conversionTimeZone);
		pos++;
		if(data.isProcessingDateToNull())
		{
			throwNullAttribute("processingDateTo");
		}

		conversionTimeZone = MithraTimestamp.DefaultTimeZone;
		if (data.getProcessingDateTo().getTime() == TaskFinder.processingDate().getInfinityDate().getTime())
		{
			conversionTimeZone = MithraTimestamp.DefaultTimeZone;
		}

		dt.setTimestamp(stm, pos, data.getProcessingDateTo(), false, conversionTimeZone);
		pos++;
	}

	public String getInsertFields()
	{
		return "TASK_ID,NAME,STATUS,IN_Z,OUT_Z";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "AND IN_Z = ?";
	}

	public Timestamp[] getAsOfDates() 
	{
		return new Timestamp[1];
	}

	public MithraDatedObject createObject(MithraDataObject data, Timestamp[] asOfDates)
	{
		Task newObject = new Task(asOfDates[0]
		);
		newObject.zSetFromTaskData((TaskData) data);
		return newObject;
	}

	public TemporalContainer createContainer(MithraTransaction tx)
	{
		return new AuditOnlyTransactionalDataContainer(tx.getPerPortalTemporalContainer(TaskFinder.getMithraObjectPortal(),
			TaskFinder.processingDate())
		);
	}

	public String getAsOfAttributeWhereSql(MithraDataObject data) 
	{
		String result = "";
		result += " AND ";
		result +="OUT_Z = ?";
		return result;
	}

	public int setPrimaryKeyAttributesWithoutDates(PreparedStatement stm, int pos, MithraDataObject dataObject, TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		TaskData data = (TaskData)dataObject;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getTaskId());
		return pos;
	}

	public List getForDateRange(MithraDataObject obj, Timestamp start, Timestamp end) throws MithraDatabaseException
	{
		throw new RuntimeException("not implemented");
	}
}
