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
import com.gs.fw.common.mithra.*;
import com.gs.fw.common.mithra.attribute.*;
import com.gs.fw.common.mithra.attribute.calculator.procedure.ObjectProcedure;
import com.gs.fw.common.mithra.behavior.txparticipation.*;
import com.gs.fw.common.mithra.cache.Cache;
import com.gs.fw.common.mithra.cache.bean.*;
import com.gs.fw.common.mithra.extractor.*;
import com.gs.fw.common.mithra.finder.*;
import com.gs.fw.common.mithra.finder.booleanop.*;
import com.gs.fw.common.mithra.finder.integer.*;
import com.gs.fw.common.mithra.finder.longop.*;
import com.gs.fw.common.mithra.finder.orderby.OrderBy;
import com.gs.fw.common.mithra.finder.string.*;
import com.gs.fw.common.mithra.extractor.NormalAndListValueSelector;
import com.gs.fw.common.mithra.list.NulledRelation;
import com.gs.fw.common.mithra.querycache.CachedQuery;
import com.gs.fw.common.mithra.querycache.QueryCache;
import com.gs.fw.common.mithra.portal.*;
import com.gs.fw.common.mithra.remote.*;
import com.gs.fw.common.mithra.transaction.MithraObjectPersister;
import com.gs.fw.common.mithra.util.TimestampPool;
import com.gs.collections.impl.map.mutable.UnifiedMap;
import java.io.Serializable;
/**
* This file was automatically generated using Mithra 16.5.1. Please do not modify it.
* Add custom logic to its subclass instead.
*/
public class AllTypesFinder
{
	private static final String IMPL_CLASS_NAME_WITH_SLASHES = "kata/domain/AllTypes";
	private static final String BUSINESS_CLASS_NAME_WITH_DOTS = "kata.domain.AllTypes";
	private static final FinderMethodMap finderMethodMap;
	private static boolean isFullCache;
	private static boolean isOffHeap;
	private static volatile MithraObjectPortal objectPortal = new UninitializedPortal("kata.domain.AllTypes");
	private static final AllTypesSingleFinder<AllTypes, Object, AllTypes> finder = new AllTypesSingleFinder<AllTypes, Object, AllTypes>();
	private static ConstantStringSet[] constantStringSets = new ConstantStringSet[0];
	private static ConstantIntSet[] constantIntSets = new ConstantIntSet[0];
	private static ConstantShortSet[] constantShortSets = new ConstantShortSet[0];
	static
	{
		finderMethodMap = new FinderMethodMap(AllTypesFinder.AllTypesRelatedFinder.class);
		finderMethodMap.addNormalAttributeName("id");
		finderMethodMap.addNormalAttributeName("booleanValue");
		finderMethodMap.addNormalAttributeName("byteValue");
		finderMethodMap.addNormalAttributeName("shortValue");
		finderMethodMap.addNormalAttributeName("charValue");
		finderMethodMap.addNormalAttributeName("intValue");
		finderMethodMap.addNormalAttributeName("longValue");
		finderMethodMap.addNormalAttributeName("floatValue");
		finderMethodMap.addNormalAttributeName("doubleValue");
		finderMethodMap.addNormalAttributeName("dateValue");
		finderMethodMap.addNormalAttributeName("timestampValue");
		finderMethodMap.addNormalAttributeName("stringValue");
		finderMethodMap.addNormalAttributeName("byteArrayValue");
		finderMethodMap.addNormalAttributeName("nullableByteValue");
		finderMethodMap.addNormalAttributeName("nullableShortValue");
		finderMethodMap.addNormalAttributeName("nullableCharValue");
		finderMethodMap.addNormalAttributeName("nullableIntValue");
		finderMethodMap.addNormalAttributeName("nullableLongValue");
		finderMethodMap.addNormalAttributeName("nullableFloatValue");
		finderMethodMap.addNormalAttributeName("nullableDoubleValue");
		finderMethodMap.addNormalAttributeName("nullableDateValue");
		finderMethodMap.addNormalAttributeName("nullableTimestampValue");
		finderMethodMap.addNormalAttributeName("nullableStringValue");
		finderMethodMap.addNormalAttributeName("nullableByteArrayValue");
	}

	private static final Map<String, Object> byteValueProperties = new UnifiedMap<String, Object>();
	static
	{
		byteValueProperties.put("classificationType", "wholeNumber");
	}

	private static final Map<String, Object> shortValueProperties = new UnifiedMap<String, Object>();
	static
	{
		shortValueProperties.put("classificationType", "wholeNumber");
	}

	private static final Map<String, Object> intValueProperties = new UnifiedMap<String, Object>();
	static
	{
		intValueProperties.put("classificationType", "wholeNumber");
	}

	private static final Map<String, Object> longValueProperties = new UnifiedMap<String, Object>();
	static
	{
		longValueProperties.put("classificationType", "wholeNumber");
	}

	private static final Map<String, Object> floatValueProperties = new UnifiedMap<String, Object>();
	static
	{
		floatValueProperties.put("classificationType", "floatingPointNumber");
	}

	private static final Map<String, Object> doubleValueProperties = new UnifiedMap<String, Object>();
	static
	{
		doubleValueProperties.put("classificationType", "floatingPointNumber");
	}

	public static Attribute[] allPersistentAttributes()
	{
		return finder.getPersistentAttributes();
	}

	public static List<RelatedFinder> allRelatedFinders()
	{
		return finder.getRelationshipFinders();
	}

	public static List<RelatedFinder> allDependentRelatedFinders()
	{
		return finder.getDependentRelationshipFinders();
	}

	public static ConstantStringSet zGetConstantStringSet(int index)
	{
		return constantStringSets[index];
	}

	public static ConstantIntSet zGetConstantIntSet(int index)
	{
		return constantIntSets[index];
	}

	public static ConstantShortSet zGetConstantShortSet(int index)
	{
		return constantShortSets[index];
	}

	public static SourceAttributeType getSourceAttributeType()
	{
		return null;
	}

	public static AllTypes findOne(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, false);
	}

	public static AllTypes findOneBypassCache(com.gs.fw.finder.Operation operation)
	{
		return findOne(operation, true);
	}

	public static AllTypesList findMany(com.gs.fw.finder.Operation operation)
	{
		return (AllTypesList) finder.findMany(operation);
	}

	public static AllTypesList findManyBypassCache(com.gs.fw.finder.Operation operation)
	{
		return (AllTypesList) finder.findManyBypassCache(operation);
	}

	private static AllTypes findOne(com.gs.fw.finder.Operation operation, boolean bypassCache)
	{
		List found = getMithraObjectPortal().find((Operation) operation, bypassCache);
		return (AllTypes) FinderUtils.findOne(found);
	}

	public static AllTypes findByPrimaryKey(int id)
	{
		return finder.findByPrimaryKey(id);
	}

	private static final RelationshipHashStrategy forPrimaryKey = new PrimaryKeyRhs();
	private static final class PrimaryKeyRhs implements RelationshipHashStrategy
	{
		public boolean equalsForRelationship(Object _srcObject, Object _srcData, Object _targetData, Timestamp _asOfDate0, Timestamp _asOfDate1)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			AllTypesData _castedTargetData = (AllTypesData) _targetData;
			if (_bean.getI1AsInteger() == _castedTargetData.getId())
			{
				return true;
			}

			return false;
		}

		public int computeHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getI1AsInteger());
		}

		public int computeOffHeapHashCodeFromRelated(Object _srcObject, Object _srcData)
		{
			I3O3L3 _bean = (I3O3L3) _srcData;
			return HashUtil.hash(_bean.getI1AsInteger());
		}
	}

	public static AllTypes zFindOneForRelationship(Operation operation)
	{
		List found = getMithraObjectPortal().findAsCachedQuery(operation, null, false, true, 0).getResult();
		return (AllTypes) FinderUtils.findOne(found);
	}

	public static MithraObjectPortal getMithraObjectPortal()
	{
		return objectPortal.getInitializedPortal();
	}

	public static void clearQueryCache()
	{
		objectPortal.clearQueryCache();
	}

	public static void reloadCache()
	{
		objectPortal.reloadCache();
	}

	public static class AllTypesRelatedFinder<ParentOwnerType, ReturnType, ReturnListType extends List, OwnerType> extends AbstractRelatedFinder<AllTypes, ParentOwnerType, ReturnType, ReturnListType, OwnerType>
	{
		private List<RelatedFinder> relationshipFinders;
		private List<RelatedFinder> dependentRelationshipFinders;
		private IntegerAttribute<ParentOwnerType> id;
		private BooleanAttribute<ParentOwnerType> booleanValue;
		private ByteAttribute<ParentOwnerType> byteValue;
		private ShortAttribute<ParentOwnerType> shortValue;
		private CharAttribute<ParentOwnerType> charValue;
		private IntegerAttribute<ParentOwnerType> intValue;
		private LongAttribute<ParentOwnerType> longValue;
		private FloatAttribute<ParentOwnerType> floatValue;
		private DoubleAttribute<ParentOwnerType> doubleValue;
		private DateAttribute<ParentOwnerType> dateValue;
		private TimestampAttribute<ParentOwnerType> timestampValue;
		private StringAttribute<ParentOwnerType> stringValue;
		private ByteArrayAttribute<ParentOwnerType> byteArrayValue;
		private ByteAttribute<ParentOwnerType> nullableByteValue;
		private ShortAttribute<ParentOwnerType> nullableShortValue;
		private CharAttribute<ParentOwnerType> nullableCharValue;
		private IntegerAttribute<ParentOwnerType> nullableIntValue;
		private LongAttribute<ParentOwnerType> nullableLongValue;
		private FloatAttribute<ParentOwnerType> nullableFloatValue;
		private DoubleAttribute<ParentOwnerType> nullableDoubleValue;
		private DateAttribute<ParentOwnerType> nullableDateValue;
		private TimestampAttribute<ParentOwnerType> nullableTimestampValue;
		private StringAttribute<ParentOwnerType> nullableStringValue;
		private ByteArrayAttribute<ParentOwnerType> nullableByteArrayValue;
		public AllTypesRelatedFinder()
		{
			super();
		}

		public AllTypesRelatedFinder(Mapper mapper)
		{
			super(mapper);
		}

		public String getFinderClassName()
		{
			return "kata.domain.AllTypesFinder";
		}

		public RelatedFinder getRelationshipFinderByName(String relationshipName)
		{
			return AllTypesFinder.finderMethodMap.getRelationshipFinderByName(relationshipName, this);
		}

		public Attribute getAttributeByName(String attributeName)
		{
			return AllTypesFinder.finderMethodMap.getAttributeByName(attributeName, this);
		}

		public com.gs.collections.api.block.function.Function getAttributeOrRelationshipSelector(String attributeName)
		{
			return AllTypesFinder.finderMethodMap.getAttributeOrRelationshipSelectorFunction(attributeName, this);
		}

		public Attribute[] getPersistentAttributes()
		{
			Attribute[] attributes = new Attribute[24];
			attributes[0] = this.id();
			attributes[1] = this.booleanValue();
			attributes[2] = this.byteValue();
			attributes[3] = this.shortValue();
			attributes[4] = this.charValue();
			attributes[5] = this.intValue();
			attributes[6] = this.longValue();
			attributes[7] = this.floatValue();
			attributes[8] = this.doubleValue();
			attributes[9] = this.dateValue();
			attributes[10] = this.timestampValue();
			attributes[11] = this.stringValue();
			attributes[12] = this.byteArrayValue();
			attributes[13] = this.nullableByteValue();
			attributes[14] = this.nullableShortValue();
			attributes[15] = this.nullableCharValue();
			attributes[16] = this.nullableIntValue();
			attributes[17] = this.nullableLongValue();
			attributes[18] = this.nullableFloatValue();
			attributes[19] = this.nullableDoubleValue();
			attributes[20] = this.nullableDateValue();
			attributes[21] = this.nullableTimestampValue();
			attributes[22] = this.nullableStringValue();
			attributes[23] = this.nullableByteArrayValue();
			return attributes;
		}

		public List<RelatedFinder> getRelationshipFinders()
		{
			if (relationshipFinders == null)
			{
				List<RelatedFinder> relatedFinders = new ArrayList<RelatedFinder>(0);
				relationshipFinders = Collections.unmodifiableList(relatedFinders);
			}

			return relationshipFinders;
		}

		public List<RelatedFinder> getDependentRelationshipFinders()
		{
			if (dependentRelationshipFinders == null)
			{
				List<RelatedFinder> dependentRelatedFinders = new ArrayList<RelatedFinder>(0);
				dependentRelationshipFinders = Collections.unmodifiableList(dependentRelatedFinders);
			}

			return dependentRelationshipFinders;
		}

		public AllTypes findOne(com.gs.fw.finder.Operation operation)
		{
			return AllTypesFinder.findOne(operation, false);
		}

		public AllTypes findOneBypassCache(com.gs.fw.finder.Operation operation)
		{
			return AllTypesFinder.findOne(operation, true);
		}

		public MithraList<? extends AllTypes> findMany(com.gs.fw.finder.Operation operation)
		{
			return new AllTypesList((Operation) operation);
		}

		public MithraList<? extends AllTypes> findManyBypassCache(com.gs.fw.finder.Operation operation)
		{
			AllTypesList result = (AllTypesList) this.findMany(operation);
			result.setBypassCache(true);
			return result;
		}

		public MithraList<? extends AllTypes> constructEmptyList()
		{
			return new AllTypesList();
		}

		public int getSerialVersionId()
		{
			return -1892107763;
		}

		public boolean isPure()
		{
			return false;
		}

		public boolean isTemporary()
		{
			return false;
		}

		public int getHierarchyDepth()
		{
			return 0;
		}

		public IntegerAttribute<ParentOwnerType> id()
		{
			IntegerAttribute<ParentOwnerType> result = this.id;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("ID","","id",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(AllTypesFinder.id(), this.mapper, this.zGetValueSelector());
				this.id = result;
			}

			return result;
		}

		public BooleanAttribute<ParentOwnerType> booleanValue()
		{
			BooleanAttribute<ParentOwnerType> result = this.booleanValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnBooleanAttribute.generate("BOOL_COL","","booleanValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1, false) :
					new MappedBooleanAttribute(AllTypesFinder.booleanValue(), this.mapper, this.zGetValueSelector());
				this.booleanValue = result;
			}

			return result;
		}

		public ByteAttribute<ParentOwnerType> byteValue()
		{
			ByteAttribute<ParentOwnerType> result = this.byteValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnByteAttribute.generate("BYTE_COL","","byteValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,byteValueProperties,true,false,-1,-1,-1, false) :
					new MappedByteAttribute(AllTypesFinder.byteValue(), this.mapper, this.zGetValueSelector());
				this.byteValue = result;
			}

			return result;
		}

		public ShortAttribute<ParentOwnerType> shortValue()
		{
			ShortAttribute<ParentOwnerType> result = this.shortValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnShortAttribute.generate("SHORT_COL","","shortValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,shortValueProperties,true,false,-1,-1,-1, false) :
					new MappedShortAttribute(AllTypesFinder.shortValue(), this.mapper, this.zGetValueSelector());
				this.shortValue = result;
			}

			return result;
		}

		public CharAttribute<ParentOwnerType> charValue()
		{
			CharAttribute<ParentOwnerType> result = this.charValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnCharAttribute.generate("CHAR_COL","","charValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1, false) :
					new MappedCharAttribute(AllTypesFinder.charValue(), this.mapper, this.zGetValueSelector());
				this.charValue = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> intValue()
		{
			IntegerAttribute<ParentOwnerType> result = this.intValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("INT_COL","","intValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,intValueProperties,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(AllTypesFinder.intValue(), this.mapper, this.zGetValueSelector());
				this.intValue = result;
			}

			return result;
		}

		public LongAttribute<ParentOwnerType> longValue()
		{
			LongAttribute<ParentOwnerType> result = this.longValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnLongAttribute.generate("LONG_COL","","longValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,longValueProperties,true,false,false,-1,-1,-1,false, false) :
					new MappedLongAttribute(AllTypesFinder.longValue(), this.mapper, this.zGetValueSelector());
				this.longValue = result;
			}

			return result;
		}

		public FloatAttribute<ParentOwnerType> floatValue()
		{
			FloatAttribute<ParentOwnerType> result = this.floatValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnFloatAttribute.generate("FLOAT_COL","","floatValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,floatValueProperties,true,false,-1,-1,-1, false) :
					new MappedFloatAttribute(AllTypesFinder.floatValue(), this.mapper, this.zGetValueSelector());
				this.floatValue = result;
			}

			return result;
		}

		public DoubleAttribute<ParentOwnerType> doubleValue()
		{
			DoubleAttribute<ParentOwnerType> result = this.doubleValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDoubleAttribute.generate("DOUBLE_COL","","doubleValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,doubleValueProperties,true,false,-1,-1,-1, false) :
					new MappedDoubleAttribute(AllTypesFinder.doubleValue(), this.mapper, this.zGetValueSelector());
				this.doubleValue = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> dateValue()
		{
			DateAttribute<ParentOwnerType> result = this.dateValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("DATE_COL","","dateValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(AllTypesFinder.dateValue(), this.mapper, this.zGetValueSelector());
				this.dateValue = result;
			}

			return result;
		}

		public TimestampAttribute<ParentOwnerType> timestampValue()
		{
			TimestampAttribute<ParentOwnerType> result = this.timestampValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnTimestampAttribute.generate("TIMESTAMP_COL","","timestampValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,TimestampAttribute.CONVERT_NONE,false,false,null, (byte) 0, false) :
					new MappedTimestampAttribute(AllTypesFinder.timestampValue(), this.mapper, this.zGetValueSelector());
				this.timestampValue = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> stringValue()
		{
			StringAttribute<ParentOwnerType> result = this.stringValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("STRING_COL","","stringValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,50,true, false) :
					new MappedStringAttribute(AllTypesFinder.stringValue(), this.mapper, this.zGetValueSelector());
				this.stringValue = result;
			}

			return result;
		}

		public ByteArrayAttribute<ParentOwnerType> byteArrayValue()
		{
			ByteArrayAttribute<ParentOwnerType> result = this.byteArrayValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnByteArrayAttribute.generate("BYTE_ARRAY_COL","","byteArrayValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,false,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE, false) :
					new MappedByteArrayAttribute(AllTypesFinder.byteArrayValue(), this.mapper, this.zGetValueSelector());
				this.byteArrayValue = result;
			}

			return result;
		}

		public ByteAttribute<ParentOwnerType> nullableByteValue()
		{
			ByteAttribute<ParentOwnerType> result = this.nullableByteValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnByteAttribute.generate("NULL_BYTE_COL","","nullableByteValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1, false) :
					new MappedByteAttribute(AllTypesFinder.nullableByteValue(), this.mapper, this.zGetValueSelector());
				this.nullableByteValue = result;
			}

			return result;
		}

		public ShortAttribute<ParentOwnerType> nullableShortValue()
		{
			ShortAttribute<ParentOwnerType> result = this.nullableShortValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnShortAttribute.generate("NULL_SHORT_COL","","nullableShortValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1, false) :
					new MappedShortAttribute(AllTypesFinder.nullableShortValue(), this.mapper, this.zGetValueSelector());
				this.nullableShortValue = result;
			}

			return result;
		}

		public CharAttribute<ParentOwnerType> nullableCharValue()
		{
			CharAttribute<ParentOwnerType> result = this.nullableCharValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnCharAttribute.generate("NULL_CHAR_COL","","nullableCharValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1, false) :
					new MappedCharAttribute(AllTypesFinder.nullableCharValue(), this.mapper, this.zGetValueSelector());
				this.nullableCharValue = result;
			}

			return result;
		}

		public IntegerAttribute<ParentOwnerType> nullableIntValue()
		{
			IntegerAttribute<ParentOwnerType> result = this.nullableIntValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnIntegerAttribute.generate("NULL_INT_COL","","nullableIntValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedIntegerAttribute(AllTypesFinder.nullableIntValue(), this.mapper, this.zGetValueSelector());
				this.nullableIntValue = result;
			}

			return result;
		}

		public LongAttribute<ParentOwnerType> nullableLongValue()
		{
			LongAttribute<ParentOwnerType> result = this.nullableLongValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnLongAttribute.generate("NULL_LONG_COL","","nullableLongValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,false,-1,-1,-1,false, false) :
					new MappedLongAttribute(AllTypesFinder.nullableLongValue(), this.mapper, this.zGetValueSelector());
				this.nullableLongValue = result;
			}

			return result;
		}

		public FloatAttribute<ParentOwnerType> nullableFloatValue()
		{
			FloatAttribute<ParentOwnerType> result = this.nullableFloatValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnFloatAttribute.generate("NULL_FLOAT_COL","","nullableFloatValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1, false) :
					new MappedFloatAttribute(AllTypesFinder.nullableFloatValue(), this.mapper, this.zGetValueSelector());
				this.nullableFloatValue = result;
			}

			return result;
		}

		public DoubleAttribute<ParentOwnerType> nullableDoubleValue()
		{
			DoubleAttribute<ParentOwnerType> result = this.nullableDoubleValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDoubleAttribute.generate("NULL_DOUBLE_COL","","nullableDoubleValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1, false) :
					new MappedDoubleAttribute(AllTypesFinder.nullableDoubleValue(), this.mapper, this.zGetValueSelector());
				this.nullableDoubleValue = result;
			}

			return result;
		}

		public DateAttribute<ParentOwnerType> nullableDateValue()
		{
			DateAttribute<ParentOwnerType> result = this.nullableDateValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnDateAttribute.generate("NULL_DATE_COL","","nullableDateValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,false, false) :
					new MappedDateAttribute(AllTypesFinder.nullableDateValue(), this.mapper, this.zGetValueSelector());
				this.nullableDateValue = result;
			}

			return result;
		}

		public TimestampAttribute<ParentOwnerType> nullableTimestampValue()
		{
			TimestampAttribute<ParentOwnerType> result = this.nullableTimestampValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnTimestampAttribute.generate("NULL_TIMESTAMP_COL","","nullableTimestampValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,TimestampAttribute.CONVERT_NONE,false,false,null, (byte) 0, false) :
					new MappedTimestampAttribute(AllTypesFinder.nullableTimestampValue(), this.mapper, this.zGetValueSelector());
				this.nullableTimestampValue = result;
			}

			return result;
		}

		public StringAttribute<ParentOwnerType> nullableStringValue()
		{
			StringAttribute<ParentOwnerType> result = this.nullableStringValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnStringAttribute.generate("NULL_STRING_COL","","nullableStringValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,50,true, false) :
					new MappedStringAttribute(AllTypesFinder.nullableStringValue(), this.mapper, this.zGetValueSelector());
				this.nullableStringValue = result;
			}

			return result;
		}

		public ByteArrayAttribute<ParentOwnerType> nullableByteArrayValue()
		{
			ByteArrayAttribute<ParentOwnerType> result = this.nullableByteArrayValue;
			if (result == null)
			{
				result = mapper == null ? SingleColumnByteArrayAttribute.generate("NULL_BYTE_ARRAY_COL","","nullableByteArrayValue",BUSINESS_CLASS_NAME_WITH_DOTS,IMPL_CLASS_NAME_WITH_SLASHES,true,false,this,null,true,false,-1,-1,-1,Integer.MAX_VALUE, false) :
					new MappedByteArrayAttribute(AllTypesFinder.nullableByteArrayValue(), this.mapper, this.zGetValueSelector());
				this.nullableByteArrayValue = result;
			}

			return result;
		}

		public Attribute getSourceAttribute()
		{
			return null;
		}

		private Mapper combineWithMapperIfExists(Mapper newMapper)
		{
			if (this.mapper != null)
			{
				return new LinkedMapper(this.mapper, newMapper);
			}

			return newMapper;
		}

		public Attribute[] getPrimaryKeyAttributes()
		{
			return AllTypesFinder.getPrimaryKeyAttributes();
		}

		public VersionAttribute getVersionAttribute()
		{
			return null;
		}

		public MithraObjectPortal getMithraObjectPortal()
		{
			return AllTypesFinder.getMithraObjectPortal();
		}
	}

	public static class AllTypesCollectionFinder<ParentOwnerType, ReturnType extends List, OwnerType> extends AllTypesRelatedFinder<ParentOwnerType, ReturnType, AllTypesList, OwnerType>
	{
		public AllTypesCollectionFinder(Mapper mapper)
		{
			super(mapper);
		}
	}

	public static abstract class AllTypesCollectionFinderForRelatedClasses<ParentOwnerType, ReturnType extends List, OwnerType>
	extends AllTypesCollectionFinder<ParentOwnerType, ReturnType, OwnerType>
	implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public AllTypesCollectionFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	public static class AllTypesSingleFinder<ParentOwnerType, ReturnType, OwnerType> extends AllTypesRelatedFinder<ParentOwnerType, ReturnType, AllTypesList, OwnerType>
	implements ToOneFinder
	{
		public AllTypesSingleFinder(Mapper mapper)
		{
			super(mapper);
		}

		public AllTypesSingleFinder()
		{
			super(null);
		}

		public Operation eq(AllTypes other)
		{
			return this.id().eq(other.getId())
			;
		}
		// this implementation uses private API. Do NOT copy to application code. Application code must use normal operations for lookups.
		public AllTypes findByPrimaryKey(int id)
		{
			AllTypes _result = null;
			Operation _op = null;
			Object _related = null;
			{
				I3O3L3 _bean = I3O3L3.POOL.getOrConstruct();
				_bean.setI1AsInteger(id);
				MithraObjectPortal _portal = this.getMithraObjectPortal();
				_related = _portal.getAsOneFromCacheForFind(_bean, _bean, forPrimaryKey, null, null);
				_bean.release();
			}

			if (!(_related instanceof NulledRelation)) _result = (AllTypes) _related;
			if (_related == null)
			{
				_op = this.id().eq(id);
			}

			if (_op != null)
			{
				_result = this.findOne(_op);
			}

			return _result;
		}
	}

	public static abstract class AllTypesSingleFinderForRelatedClasses<ParentOwnerType, ReturnType, OwnerType> extends AllTypesSingleFinder<ParentOwnerType, ReturnType, OwnerType> implements DeepRelationshipAttribute<ParentOwnerType, ReturnType>
	{
		public AllTypesSingleFinderForRelatedClasses(Mapper mapper)
		{
			super(mapper);
		}

		protected NormalAndListValueSelector zGetValueSelector()
		{
			return this;
		}
	}

	/** maps to ALL_TYPES.ID **/
	public static IntegerAttribute<AllTypes> id()
	{
		return finder.id();
	}

	/** maps to ALL_TYPES.BOOL_COL **/
	public static BooleanAttribute<AllTypes> booleanValue()
	{
		return finder.booleanValue();
	}

	/** maps to ALL_TYPES.BYTE_COL **/
	public static ByteAttribute<AllTypes> byteValue()
	{
		return finder.byteValue();
	}

	/** maps to ALL_TYPES.SHORT_COL **/
	public static ShortAttribute<AllTypes> shortValue()
	{
		return finder.shortValue();
	}

	/** maps to ALL_TYPES.CHAR_COL **/
	public static CharAttribute<AllTypes> charValue()
	{
		return finder.charValue();
	}

	/** maps to ALL_TYPES.INT_COL **/
	public static IntegerAttribute<AllTypes> intValue()
	{
		return finder.intValue();
	}

	/** maps to ALL_TYPES.LONG_COL **/
	public static LongAttribute<AllTypes> longValue()
	{
		return finder.longValue();
	}

	/** maps to ALL_TYPES.FLOAT_COL **/
	public static FloatAttribute<AllTypes> floatValue()
	{
		return finder.floatValue();
	}

	/** maps to ALL_TYPES.DOUBLE_COL **/
	public static DoubleAttribute<AllTypes> doubleValue()
	{
		return finder.doubleValue();
	}

	/** maps to ALL_TYPES.DATE_COL **/
	public static DateAttribute<AllTypes> dateValue()
	{
		return finder.dateValue();
	}

	/** maps to ALL_TYPES.TIMESTAMP_COL **/
	public static TimestampAttribute<AllTypes> timestampValue()
	{
		return finder.timestampValue();
	}

	/** maps to ALL_TYPES.STRING_COL **/
	public static StringAttribute<AllTypes> stringValue()
	{
		return finder.stringValue();
	}

	/** maps to ALL_TYPES.BYTE_ARRAY_COL **/
	public static ByteArrayAttribute<AllTypes> byteArrayValue()
	{
		return finder.byteArrayValue();
	}

	/** maps to ALL_TYPES.NULL_BYTE_COL **/
	public static ByteAttribute<AllTypes> nullableByteValue()
	{
		return finder.nullableByteValue();
	}

	/** maps to ALL_TYPES.NULL_SHORT_COL **/
	public static ShortAttribute<AllTypes> nullableShortValue()
	{
		return finder.nullableShortValue();
	}

	/** maps to ALL_TYPES.NULL_CHAR_COL **/
	public static CharAttribute<AllTypes> nullableCharValue()
	{
		return finder.nullableCharValue();
	}

	/** maps to ALL_TYPES.NULL_INT_COL **/
	public static IntegerAttribute<AllTypes> nullableIntValue()
	{
		return finder.nullableIntValue();
	}

	/** maps to ALL_TYPES.NULL_LONG_COL **/
	public static LongAttribute<AllTypes> nullableLongValue()
	{
		return finder.nullableLongValue();
	}

	/** maps to ALL_TYPES.NULL_FLOAT_COL **/
	public static FloatAttribute<AllTypes> nullableFloatValue()
	{
		return finder.nullableFloatValue();
	}

	/** maps to ALL_TYPES.NULL_DOUBLE_COL **/
	public static DoubleAttribute<AllTypes> nullableDoubleValue()
	{
		return finder.nullableDoubleValue();
	}

	/** maps to ALL_TYPES.NULL_DATE_COL **/
	public static DateAttribute<AllTypes> nullableDateValue()
	{
		return finder.nullableDateValue();
	}

	/** maps to ALL_TYPES.NULL_TIMESTAMP_COL **/
	public static TimestampAttribute<AllTypes> nullableTimestampValue()
	{
		return finder.nullableTimestampValue();
	}

	/** maps to ALL_TYPES.NULL_STRING_COL **/
	public static StringAttribute<AllTypes> nullableStringValue()
	{
		return finder.nullableStringValue();
	}

	/** maps to ALL_TYPES.NULL_BYTE_ARRAY_COL **/
	public static ByteArrayAttribute<AllTypes> nullableByteArrayValue()
	{
		return finder.nullableByteArrayValue();
	}

	public static Operation eq(AllTypes other)
	{
		return finder.eq(other);
	}

	public static Operation all()
	{
		return new All(id());
	}

	public static AllTypesSingleFinder<AllTypes, Object, AllTypes> getFinderInstance()
	{
		return finder;
	}

	public static Attribute[] getPrimaryKeyAttributes()
	{
		return new Attribute[] 
		{
			id()
		}

		;
	}

	public static Attribute[] getImmutableAttributes()
	{
		return new Attribute[] 
		{
			id()
			, id()
		}

		;
	}

	public static AsOfAttribute[] getAsOfAttributes()
	{
		return null;
	}

	protected static void initializeIndicies(Cache cache)
	{
	}

	protected static void initializePortal(MithraObjectDeserializer objectFactory, Cache cache,
		MithraConfigurationManager.Config config)
	{
		initializeIndicies(cache);
		isFullCache = cache.isFullCache();
		isOffHeap = cache.isOffHeap();
		MithraObjectPortal portal;
		if (config.isParticipatingInTx())
		{
			portal = new MithraTransactionalPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(), null,
				null, null, 0,
				(MithraObjectPersister) objectFactory);
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(), null,
				null, null, 0,
				(MithraObjectPersister) objectFactory);
		}

		portal.setIndependent(true);
		config.initializePortal(portal);
		objectPortal.destroy();
		objectPortal = portal;
	}

	protected static void initializeClientPortal(MithraObjectDeserializer objectFactory, Cache cache,
		MithraConfigurationManager.Config config)
	{
		initializeIndicies(cache);
		isFullCache = cache.isFullCache();
		isOffHeap = cache.isOffHeap();
		MithraObjectPortal portal;
		if (config.isParticipatingInTx())
		{
			portal = new MithraTransactionalPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), false));
		}
		else
		{
			portal = new MithraReadOnlyPortal(objectFactory, cache, getFinderInstance(),
				config.getRelationshipCacheSize(), config.getMinQueriesToKeep(),
				null, null,
				null, 0,
				new RemoteMithraObjectPersister(config.getRemoteMithraService(), getFinderInstance(), false));
		}

		portal.setIndependent(true);
		config.initializePortal(portal);
		objectPortal.destroy();
		objectPortal = portal;
	}

	public static boolean isFullCache()
	{
		return isFullCache;
	}

	public static boolean isOffHeap()
	{
		return isOffHeap;
	}

	public static Attribute getAttributeByName(String attributeName)
	{
		return finder.getAttributeByName(attributeName);
	}

	public static com.gs.collections.api.block.function.Function getAttributeOrRelationshipSelector(String attributeName)
	{
		return finder.getAttributeOrRelationshipSelector(attributeName);
	}

	public static RelatedFinder getRelatedFinderByName(String relationshipName)
	{
		return finder.getRelationshipFinderByName(relationshipName);
	}

	public static DoubleAttribute[] zGetDoubleAttributes()
	{
		DoubleAttribute[] result = new DoubleAttribute[2];
		result[0] = doubleValue();
		result[1] = nullableDoubleValue();
		return result;
	}

	public static BigDecimalAttribute[] zGetBigDecimalAttributes()
	{
		BigDecimalAttribute[] result = new BigDecimalAttribute[0];
		return result;
	}

	public static void zResetPortal()
	{
		objectPortal.destroy();
		objectPortal = new UninitializedPortal("kata.domain.AllTypes");
		isFullCache = false;
		isOffHeap = false;
	}

	public static void setTransactionModeFullTransactionParticipation(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, FullTransactionalParticipationMode.getInstance());
	}

	public static void setTransactionModeReadCacheUpdateCausesRefreshAndLock(MithraTransaction tx)
	{
		tx.setTxParticipationMode(objectPortal, ReadCacheUpdateCausesRefreshAndLockTxParticipationMode.getInstance());
	}

	public static void registerForNotification(MithraApplicationClassLevelNotificationListener listener)
	{
		getMithraObjectPortal().registerForApplicationClassLevelNotification(listener);
	}
}
