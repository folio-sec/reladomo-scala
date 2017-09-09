package kata.domain;
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
import java.util.*;
import java.sql.*;
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.update.AttributeUpdateWrapper;
import com.gs.fw.common.mithra.bulkloader.BulkLoader;
import com.gs.fw.common.mithra.bulkloader.BulkLoaderException;
import com.gs.fw.common.mithra.cache.*;
import com.gs.fw.common.mithra.cache.offheap.*;
import com.gs.fw.common.mithra.connectionmanager.*;
import com.gs.fw.common.mithra.database.*;
import com.gs.fw.common.mithra.databasetype.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.finder.orderby.OrderBy;
import com.gs.fw.common.mithra.finder.integer.IntegerResultSetParser;
import com.gs.fw.common.mithra.querycache.CachedQuery;
import com.gs.fw.common.mithra.remote.RemoteMithraService;
import com.gs.fw.common.mithra.transaction.BatchUpdateOperation;
import com.gs.fw.common.mithra.transaction.UpdateOperation;
/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public abstract class AllTypesDatabaseObjectAbstract extends MithraAbstractTransactionalDatabaseObject implements MithraTransactionalDatabaseObject, MithraObjectFactory
{
	private SourcelessConnectionManager connectionManager;
	private SchemaManager schemaManager;
	private TablePartitionManager tablePartitionManager;
	private static final String COL_LIST_WITHOUT_PK = "BOOL_COL,BYTE_COL,SHORT_COL,CHAR_COL,INT_COL,LONG_COL,FLOAT_COL,DOUBLE_COL,DATE_COL,TIMESTAMP_COL,STRING_COL,BYTE_ARRAY_COL,NULL_BYTE_COL,NULL_SHORT_COL,NULL_CHAR_COL,NULL_INT_COL,NULL_LONG_COL,NULL_FLOAT_COL,NULL_DOUBLE_COL,NULL_DATE_COL,NULL_TIMESTAMP_COL,NULL_STRING_COL,NULL_BYTE_ARRAY_COL";
	private static final String COL_LIST_WITHOUT_PK_WITH_ALIAS = "t0.BOOL_COL,t0.BYTE_COL,t0.SHORT_COL,t0.CHAR_COL,t0.INT_COL,t0.LONG_COL,t0.FLOAT_COL,t0.DOUBLE_COL,t0.DATE_COL,t0.TIMESTAMP_COL,t0.STRING_COL,t0.BYTE_ARRAY_COL,t0.NULL_BYTE_COL,t0.NULL_SHORT_COL,t0.NULL_CHAR_COL,t0.NULL_INT_COL,t0.NULL_LONG_COL,t0.NULL_FLOAT_COL,t0.NULL_DOUBLE_COL,t0.NULL_DATE_COL,t0.NULL_TIMESTAMP_COL,t0.NULL_STRING_COL,t0.NULL_BYTE_ARRAY_COL";
	private static final String PK_WITH_ALIAS = "t0.ID = ?";
	private static final String PK_INDEX_COLS = "ID";
	protected AllTypesDatabaseObjectAbstract()
	{
		super("AllTypes", "kata.domain.AllTypesFinder",
			24, 24,
			COL_LIST_WITHOUT_PK, COL_LIST_WITHOUT_PK_WITH_ALIAS,
			false, false, false,
			PK_WITH_ALIAS,
			PK_INDEX_COLS);
	}

	public MithraObjectPortal getMithraObjectPortal()
	{
		return AllTypesFinder.getMithraObjectPortal();
	}

	public RelatedFinder getFinder()
	{
		return AllTypesFinder.getFinderInstance();
	}

	public static AllTypesData allocateOnHeapData()
	{
		return new AllTypesData();
	}

	public static AllTypesData allocateOffHeapData()
	{
		throw new RuntimeException("no off heap implementation");
	}

	public MithraDataObject deserializeFullData(ObjectInput in) throws IOException, ClassNotFoundException
	{
		MithraDataObject data = new AllTypesData();
		data.zDeserializeFullData(in);
		return data;
	}

	public MithraObject deserializeForRefresh(ObjectInput in) throws IOException, ClassNotFoundException
	{
		AllTypesData data = new AllTypesData();
		data.zDeserializePrimaryKey(in);
		return this.createObject(data);
	}

	public Cache instantiateFullCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new FullNonDatedTransactionalCache(AllTypesFinder.getPrimaryKeyAttributes(), this, AllTypesFinder.getImmutableAttributes());
		}
		else
		{
			result = new FullNonDatedCache(AllTypesFinder.getPrimaryKeyAttributes(), this, AllTypesFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter());
		}

		initPortal(result, config);
		return result;
	}

	public Cache instantiatePartialCache(MithraConfigurationManager.Config config)
	{
		Cache result;
		if (config.isParticipatingInTx())
		{
			result = new PartialNonDatedTransactionalCache(AllTypesFinder.getPrimaryKeyAttributes(), this, AllTypesFinder.getImmutableAttributes(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}
		else
		{
			result = new PartialNonDatedCache(AllTypesFinder.getPrimaryKeyAttributes(), this, AllTypesFinder.getImmutableAttributes(), new NonTransactionalUnderlyingObjectGetter(), config.getCacheTimeToLive(), config.getRelationshipCacheTimeToLive());
		}

		initPortal(result, config);
		return result;
	}

	private void initPortal(Cache cache, MithraConfigurationManager.Config config)
	{
		if (config.isThreeTierClient())
		{
			AllTypesFinder.initializeClientPortal(this, cache, config);
		}
		else
		{
			AllTypesFinder.initializePortal(this, cache, config);
		}

		if (config.isParticipatingInTx())
		{
			AllTypes.zConfigFullTx();
		}
		else
		{
			AllTypes.zConfigNonTx();
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
		return inflateAllTypesData(rs, dt);
	}

	public void inflateNonPkDataGenericSource(MithraDataObject data, ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		inflateNonPkAllTypesData(1, (AllTypesData) data, rs, dt);
	}

	public MithraDataObject inflatePkDataGenericSource(ResultSet rs, Object source, DatabaseType dt)
	throws SQLException 
	{
		return inflateAllTypesPkData(rs, dt);
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
		return getAllTypesTableName();
	}

	public String getAllTypesTableName() throws MithraDatabaseException
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
		AllTypesData data = (AllTypesData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getId());
	}

	public int setPrimaryKeyAttributesWithoutOptimistic(PreparedStatement stm, int pos, MithraDataObject dataObj,
		TimeZone databaseTimeZone, DatabaseType dt) throws SQLException
	{
		this.setPrimaryKeyAttributes(stm, pos, dataObj, databaseTimeZone, dt);
		return -1;
	}

	public String getPrimaryKeyWhereSql()
	{
		return "ID = ?";
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
			return "t0.ID,t0.BOOL_COL,t0.BYTE_COL,t0.SHORT_COL,t0.CHAR_COL,t0.INT_COL,t0.LONG_COL,t0.FLOAT_COL,t0.DOUBLE_COL,t0.DATE_COL,t0.TIMESTAMP_COL,t0.STRING_COL,t0.BYTE_ARRAY_COL,t0.NULL_BYTE_COL,t0.NULL_SHORT_COL,t0.NULL_CHAR_COL,t0.NULL_INT_COL,t0.NULL_LONG_COL,t0.NULL_FLOAT_COL,t0.NULL_DOUBLE_COL,t0.NULL_DATE_COL,t0.NULL_TIMESTAMP_COL,t0.NULL_STRING_COL,t0.NULL_BYTE_ARRAY_COL";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*24);
		result.append(databaseAlias).append(".").append("ID");
		result.append(",").append(databaseAlias).append(".").append("BOOL_COL");
		result.append(",").append(databaseAlias).append(".").append("BYTE_COL");
		result.append(",").append(databaseAlias).append(".").append("SHORT_COL");
		result.append(",").append(databaseAlias).append(".").append("CHAR_COL");
		result.append(",").append(databaseAlias).append(".").append("INT_COL");
		result.append(",").append(databaseAlias).append(".").append("LONG_COL");
		result.append(",").append(databaseAlias).append(".").append("FLOAT_COL");
		result.append(",").append(databaseAlias).append(".").append("DOUBLE_COL");
		result.append(",").append(databaseAlias).append(".").append("DATE_COL");
		result.append(",").append(databaseAlias).append(".").append("TIMESTAMP_COL");
		result.append(",").append(databaseAlias).append(".").append("STRING_COL");
		result.append(",").append(databaseAlias).append(".").append("BYTE_ARRAY_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_BYTE_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_SHORT_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_CHAR_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_INT_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_LONG_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_FLOAT_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_DOUBLE_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_DATE_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_TIMESTAMP_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_STRING_COL");
		result.append(",").append(databaseAlias).append(".").append("NULL_BYTE_ARRAY_COL");
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

	public AllTypesData inflateAllTypesData(ResultSet rs, DatabaseType dt)
	throws SQLException
	{
		AllTypesData data = inflateAllTypesPkData(rs, dt);
		inflateNonPkAllTypesData(2, data, rs, dt);
		return data;
	}

	public AllTypesData inflateAllTypesPkData(ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		AllTypesData _data = new AllTypesData();
		int _pos = 1;
		_data.setId(_rs.getInt(_pos++));
		checkNullPrimitive(_rs, _data, "id");
		return _data;
	}

	public void inflateNonPkAllTypesData(int _pos, AllTypesData _datax, ResultSet _rs, DatabaseType _dt)
	throws SQLException
	{
		{
			AllTypesData _data = _datax;
			_data.setBooleanValue(_rs.getBoolean(_pos++));
			checkNullPrimitive(_rs, _data, "booleanValue");
			_data.setByteValue(_rs.getByte(_pos++));
			checkNullPrimitive(_rs, _data, "byteValue");
			_data.setShortValue(_rs.getShort(_pos++));
			checkNullPrimitive(_rs, _data, "shortValue");
			String charValueCharValue = _rs.getString(_pos++);
			boolean charValueCharValueisNull = charValueCharValue == null || charValueCharValue.length() < 1;
			if(!charValueCharValueisNull)
			{
				if(charValueCharValue.length() > 1)
				{
					throw new SQLException("attribute defined as char, but is more than one character long in database");
				}
				else if(charValueCharValue.length() == 1)
				{
					_data.setCharValue(charValueCharValue.charAt(0));
				}
			}
			else
			{
				throw new MithraBusinessException("attribute ' charValue ' is null in database but is not marked as nullable in mithra xml for primary key / "+_data.zGetPrintablePrimaryKey());
			}

			_data.setIntValue(_rs.getInt(_pos++));
			checkNullPrimitive(_rs, _data, "intValue");
			_data.setLongValue(_rs.getLong(_pos++));
			checkNullPrimitive(_rs, _data, "longValue");
			_data.setFloatValue(_rs.getFloat(_pos++));
			checkNullPrimitive(_rs, _data, "floatValue");
			_data.setDoubleValue(_rs.getDouble(_pos++));
			checkNullPrimitive(_rs, _data, "doubleValue");
			_data.setDateValue(_rs.getDate(_pos++));
			checkNullPrimitive(_rs, _data, "dateValue");
			Timestamp timestampValuetimestampValue = _dt.getTimestampFromResultSet(_rs, _pos++, MithraTimestamp.DefaultTimeZone);
			_data.setTimestampValue(timestampValuetimestampValue);
			_data.setStringValue(trimString(_rs.getString(_pos++)));
			_data.setByteArrayValue(_rs.getBytes(_pos++));
			checkNullPrimitive(_rs, _data, "byteArrayValue");
			_data.setNullableByteValue(_rs.getByte(_pos++));
			if (_rs.wasNull())
			{
				_data.setNullableByteValueNull();
			}

			_data.setNullableShortValue(_rs.getShort(_pos++));
			if (_rs.wasNull())
			{
				_data.setNullableShortValueNull();
			}

			String nullableCharValueCharValue = _rs.getString(_pos++);
			boolean nullableCharValueCharValueisNull = nullableCharValueCharValue == null || nullableCharValueCharValue.length() < 1;
			if(!nullableCharValueCharValueisNull)
			{
				if(nullableCharValueCharValue.length() > 1)
				{
					throw new SQLException("attribute defined as char, but is more than one character long in database");
				}
				else if(nullableCharValueCharValue.length() == 1)
				{
					_data.setNullableCharValue(nullableCharValueCharValue.charAt(0));
				}
			}
			else
			{
				_data.setNullableCharValueNull();
			}

			_data.setNullableIntValue(_rs.getInt(_pos++));
			if (_rs.wasNull())
			{
				_data.setNullableIntValueNull();
			}

			_data.setNullableLongValue(_rs.getLong(_pos++));
			if (_rs.wasNull())
			{
				_data.setNullableLongValueNull();
			}

			_data.setNullableFloatValue(_rs.getFloat(_pos++));
			if (_rs.wasNull())
			{
				_data.setNullableFloatValueNull();
			}

			_data.setNullableDoubleValue(_rs.getDouble(_pos++));
			if (_rs.wasNull())
			{
				_data.setNullableDoubleValueNull();
			}

			_data.setNullableDateValue(_rs.getDate(_pos++));
			Timestamp nullableTimestampValuetimestampValue = _dt.getTimestampFromResultSet(_rs, _pos++, MithraTimestamp.DefaultTimeZone);
			_data.setNullableTimestampValue(nullableTimestampValuetimestampValue);
			_data.setNullableStringValue(trimString(_rs.getString(_pos++)));
			_data.setNullableByteArrayValue(_rs.getBytes(_pos++));
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
		return "ALL_TYPES";
	}

	public void setInsertAttributes(PreparedStatement stm, MithraDataObject dataObj,
		TimeZone databaseTimeZone, int pos, DatabaseType dt) throws SQLException
	{
		AllTypesData data = (AllTypesData)dataObj;
		TimeZone conversionTimeZone = null;
		stm.setInt(pos++, data.getId());
		stm.setBoolean(pos++, data.isBooleanValue());
		stm.setByte(pos++, data.getByteValue());
		stm.setShort(pos++, data.getShortValue());
		stm.setString(pos++, String.valueOf(data.getCharValue()));
		stm.setInt(pos++, data.getIntValue());
		stm.setLong(pos++, data.getLongValue());
		stm.setFloat(pos++, data.getFloatValue());
		stm.setDouble(pos++, data.getDoubleValue());
		if(data.isDateValueNull())
		{
			throwNullAttribute("dateValue");
		}

		stm.setDate(pos++, data.getDateValue());
		if(data.isTimestampValueNull())
		{
			throwNullAttribute("timestampValue");
		}

		conversionTimeZone = MithraTimestamp.DefaultTimeZone;
		dt.setTimestamp(stm, pos, data.getTimestampValue(), false, conversionTimeZone);
		pos++;
		if(data.isStringValueNull())
		{
			throwNullAttribute("stringValue");
		}

		stm.setString(pos++, data.getStringValue());
		if(data.isByteArrayValueNull())
		{
			throwNullAttribute("byteArrayValue");
		}

		stm.setBytes(pos++, data.getByteArrayValue());
		if (data.isNullableByteValueNull())
		{
			stm.setNull(pos++, java.sql.Types.TINYINT);
		}
		else
		{
			stm.setByte(pos++, data.getNullableByteValue());
		}

		if (data.isNullableShortValueNull())
		{
			stm.setNull(pos++, java.sql.Types.SMALLINT);
		}
		else
		{
			stm.setShort(pos++, data.getNullableShortValue());
		}

		if (data.isNullableCharValueNull())
		{
			stm.setNull(pos++, java.sql.Types.CHAR);
		}
		else
		{
			stm.setString(pos++, String.valueOf(data.getNullableCharValue()));
		}

		if (data.isNullableIntValueNull())
		{
			stm.setNull(pos++, java.sql.Types.INTEGER);
		}
		else
		{
			stm.setInt(pos++, data.getNullableIntValue());
		}

		if (data.isNullableLongValueNull())
		{
			stm.setNull(pos++, java.sql.Types.BIGINT);
		}
		else
		{
			stm.setLong(pos++, data.getNullableLongValue());
		}

		if (data.isNullableFloatValueNull())
		{
			stm.setNull(pos++, java.sql.Types.FLOAT);
		}
		else
		{
			stm.setFloat(pos++, data.getNullableFloatValue());
		}

		if (data.isNullableDoubleValueNull())
		{
			stm.setNull(pos++, java.sql.Types.DOUBLE);
		}
		else
		{
			stm.setDouble(pos++, data.getNullableDoubleValue());
		}

		if (data.isNullableDateValueNull())
		{
			stm.setNull(pos++, java.sql.Types.DATE);
		}
		else
		{
			stm.setDate(pos++, data.getNullableDateValue());
		}

		if (data.isNullableTimestampValueNull())
		{
			stm.setNull(pos++, java.sql.Types.TIMESTAMP);
		}
		else
		{
			conversionTimeZone = MithraTimestamp.DefaultTimeZone;
			dt.setTimestamp(stm, pos, data.getNullableTimestampValue(), false, conversionTimeZone);
			pos++;
		}

		if (data.isNullableStringValueNull())
		{
			stm.setNull(pos++, java.sql.Types.VARCHAR);
		}
		else
		{
			stm.setString(pos++, data.getNullableStringValue());
		}

		if (data.isNullableByteArrayValueNull())
		{
			stm.setNull(pos++, java.sql.Types.VARBINARY);
		}
		else
		{
			stm.setBytes(pos++, data.getNullableByteArrayValue());
		}
	}

	public String getInsertFields()
	{
		return "ID,BOOL_COL,BYTE_COL,SHORT_COL,CHAR_COL,INT_COL,LONG_COL,FLOAT_COL,DOUBLE_COL,DATE_COL,TIMESTAMP_COL,STRING_COL,BYTE_ARRAY_COL,NULL_BYTE_COL,NULL_SHORT_COL,NULL_CHAR_COL,NULL_INT_COL,NULL_LONG_COL,NULL_FLOAT_COL,NULL_DOUBLE_COL,NULL_DATE_COL,NULL_TIMESTAMP_COL,NULL_STRING_COL,NULL_BYTE_ARRAY_COL";
	}

	public String getInsertQuestionMarks()
	{
		return "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
	}

	public String getOptimisticLockingWhereSql()
	{
		return "";
	}

	public MithraObject createObject(MithraDataObject newData)
	{
		AllTypes newObject = new AllTypes();
		newObject.zSetFromAllTypesData((AllTypesData) newData);
		return newObject;
	}

	public String getPkColumnList(String databaseAlias)
	{
		if (databaseAlias.equals(SqlQuery.DEFAULT_DATABASE_ALIAS))
		{
			return "t0.ID";
		}

		StringBuffer result = new StringBuffer((databaseAlias.length()+15)*24);
		result.append(databaseAlias);
		result.append(".");
		result.append("ID");
		return result.toString();
	}
}
