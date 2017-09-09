package kata.domain;

import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.cache.*;
import com.gs.fw.common.mithra.connectionmanager.ConnectionManagerWrapper;
import com.gs.fw.common.mithra.connectionmanager.SchemaManager;
import com.gs.fw.common.mithra.connectionmanager.SourcelessConnectionManager;
import com.gs.fw.common.mithra.connectionmanager.TablePartitionManager;
import com.gs.fw.common.mithra.database.MithraAbstractTransactionalDatabaseObject;
import com.gs.fw.common.mithra.databasetype.DatabaseType;
import com.gs.fw.common.mithra.finder.MapperStackImpl;
import com.gs.fw.common.mithra.finder.RelatedFinder;
import com.gs.fw.common.mithra.finder.SqlQuery;
import com.gs.fw.common.mithra.util.MithraConfigurationManager;

import java.io.IOException;
import java.io.ObjectInput;
import java.sql.*;
import java.util.List;
import java.util.TimeZone;

/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public abstract class ObjectSequenceDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "NEXT_VALUE";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.NEXT_VALUE";
	private static final String PK_WITH_ALIAS = "t0.SEQUENCE_NAME = ?";
	private static final String PK_INDEX_COLS = "SEQUENCE_NAME";
	protected ObjectSequenceDatabaseObjectAbstract()
	{
		super("ObjectSequence", "kata.domain.ObjectSequenceFinder",
			2, 2,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return ObjectSequenceFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return ObjectSequenceFinder.getFinderInstance();
	}

	public static ObjectSequenceData allocateOnHeapData()
	{
		return new ObjectSequenceData();
	}

	public static ObjectSequenceData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new ObjectSequenceData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		ObjectSequenceData data = new ObjectSequenceData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(ObjectSequenceFinder.getPrimaryKeyAttributes(), this, ObjectSequenceFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(ObjectSequenceFinder.getPrimaryKeyAttributes(), this, ObjectSequenceFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(ObjectSequenceFinder.getPrimaryKeyAttributes(), this, ObjectSequenceFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(ObjectSequenceFinder.getPrimaryKeyAttributes(), this, ObjectSequenceFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			ObjectSequenceFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			ObjectSequenceFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			ObjectSequence.zConfigFullTx();
		}
		else
		{
			ObjectSequence.zConfigNonTx();
		}
	}

	public List getSimulatedSequenceInitValues()
	{
		return null;
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
		return inflateObjectSequenceData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkObjectSequenceData(1, (ObjectSequenceData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateObjectSequencePkData(rs, dt);
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
		return getObjectSequenceTableName();
	}

	public String getObjectSequenceTableName() throws MithraDatabaseException
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
		ObjectSequenceData data = (ObjectSequenceData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setString(pos++, data.getSimulatedSequenceName());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "SEQUENCE_NAME = ?";
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
			return "t0.SEQUENCE_NAME,t0.NEXT_VALUE";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*2);
		result.append(databaseAlias).append(".").append("SEQUENCE_NAME");
		result.append(",").append(databaseAlias).append(".").append("NEXT_VALUE");
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

	public ObjectSequenceData inflateObjectSequenceData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		ObjectSequenceData data = inflateObjectSequencePkData(rs, dt);
		inflateNonPkObjectSequenceData(2, data, rs, dt);
		return data;
	}

	public ObjectSequenceData inflateObjectSequencePkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		ObjectSequenceData _data = new ObjectSequenceData();
		int _pos = 1;
		_data.setSimulatedSequenceName(trimString(_rs.getString(_pos++)));
		return _data;
	}

	public void inflateNonPkObjectSequenceData(int _pos, ObjectSequenceData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			ObjectSequenceData _data = _datax;
			_data.setNextValue(_rs.getLong(_pos++));
			if (_rs.wasNull())
			{
				_data.setNextValueNull();
			}
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
		return "OBJECT_SEQUENCE";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		ObjectSequenceData data = (ObjectSequenceData)dataObj;
		TimeZone conversionTimeZone = null;
		if(data.isSimulatedSequenceNameNull())
		{
			throwNullAttribute("simulatedSequenceName");
		}

		stm.setString(pos++, data.getSimulatedSequenceName());
		if (data.isNextValueNull())
		{
			stm.setNull(pos++, Types.BIGINT);
		}
		else
		{
			stm.setLong(pos++, data.getNextValue());
		}
	}

	public String getInsertFields()
	{
		return "SEQUENCE_NAME,NEXT_VALUE";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		ObjectSequence newObject = new ObjectSequence();
		newObject.zSetFromObjectSequenceData((ObjectSequenceData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.SEQUENCE_NAME";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*2);
		result.append(databaseAlias);
		result.append(".");
		result.append("SEQUENCE_NAME");
		return result.toString();
	}
}
