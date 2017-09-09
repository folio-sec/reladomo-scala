/*
 * Copyright 2017 FOLIO Co.,Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.folio_sec.reladomo.generator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "MithraObject")
public class MithraObject {

    private String packageName;
    private String className;
    private String defaultTable;
    private SourceAttribute sourceAttribute;
    private List<AsOfAttribute> asOfAttributes = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();
    private List<Relationship> relationships = new ArrayList<>();

    @XmlElement(name = "PackageName")
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @XmlElement(name = "ClassName")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @XmlElement(name = "DefaultTable")
    public String getDefaultTable() {
        return defaultTable;
    }

    public void setDefaultTable(String defaultTable) {
        this.defaultTable = defaultTable;
    }

    @XmlElement(name = "SourceAttribute")
    public SourceAttribute getSourceAttribute() {
        return sourceAttribute;
    }

    public void setSourceAttribute(SourceAttribute sourceAttribute) {
        this.sourceAttribute = sourceAttribute;
    }

    @XmlElement(name = "AsOfAttribute")
    public List<AsOfAttribute> getAsOfAttributes() {
        return asOfAttributes;
    }

    public void setAsOfAttributes(List<AsOfAttribute> asOfAttributes) {
        this.asOfAttributes = asOfAttributes;
    }

    @XmlElement(name = "Attribute")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @XmlElement(name = "Relationship")
    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public static class SourceAttribute {
        private String name;
        private String javaType;

        @XmlAttribute
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getJavaType() {
            return javaType;
        }

        public void setJavaType(String javaType) {
            this.javaType = javaType;
        }
    }

    public static class AsOfAttribute {
        private String name;
        private String fromColumnName;
        private String toColumnName;
        private boolean toIsInclusive;
        private String infinityDate;
        private boolean isProcessingDate;
        private String defaultIfNotSpecified;

        @XmlAttribute
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getFromColumnName() {
            return fromColumnName;
        }

        public void setFromColumnName(String fromColumnName) {
            this.fromColumnName = fromColumnName;
        }

        @XmlAttribute
        public String getToColumnName() {
            return toColumnName;
        }

        public void setToColumnName(String toColumnName) {
            this.toColumnName = toColumnName;
        }

        @XmlAttribute
        public boolean isToIsInclusive() {
            return toIsInclusive;
        }

        public void setToIsInclusive(boolean toIsInclusive) {
            this.toIsInclusive = toIsInclusive;
        }

        @XmlAttribute
        public String getInfinityDate() {
            return infinityDate;
        }

        public void setInfinityDate(String infinityDate) {
            this.infinityDate = infinityDate;
        }

        @XmlAttribute
        public boolean isProcessingDate() {
            return isProcessingDate;
        }

        public void setProcessingDate(boolean processingDate) {
            isProcessingDate = processingDate;
        }

        @XmlAttribute
        public String getDefaultIfNotSpecified() {
            return defaultIfNotSpecified;
        }

        public void setDefaultIfNotSpecified(String defaultIfNotSpecified) {
            this.defaultIfNotSpecified = defaultIfNotSpecified;
        }
    }

    public static class Attribute {
        private String name;
        private String javaType;
        private String columnName;
        private boolean primaryKey;
        private String primaryKeyGeneratorStrategy;
        private boolean nullable;
        private String maxLength;

        @XmlAttribute
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getJavaType() {
            return javaType;
        }

        public void setJavaType(String javaType) {
            this.javaType = javaType;
        }

        @XmlAttribute
        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        @XmlAttribute
        public boolean isPrimaryKey() {
            return primaryKey;
        }

        public void setPrimaryKey(boolean primaryKey) {
            this.primaryKey = primaryKey;
        }

        @XmlAttribute
        public String getPrimaryKeyGeneratorStrategy() {
            return primaryKeyGeneratorStrategy;
        }

        public void setPrimaryKeyGeneratorStrategy(String primaryKeyGeneratorStrategy) {
            this.primaryKeyGeneratorStrategy = primaryKeyGeneratorStrategy;
        }

        @XmlAttribute
        public boolean isNullable() {
            return nullable;
        }

        public void setNullable(boolean nullable) {
            this.nullable = nullable;
        }

        @XmlAttribute
        public String getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(String maxLength) {
            this.maxLength = maxLength;
        }
    }

    public static class Relationship {
        private String name;
        private String relatedObject;
        private String cardinality;
        private String reverseRelationshipName;
        private boolean relatedIsDependent;
        private String clause;
        private String parameters;
        private String returnType;

        @XmlAttribute
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getRelatedObject() {
            return relatedObject;
        }

        public void setRelatedObject(String relatedObject) {
            this.relatedObject = relatedObject;
        }

        @XmlAttribute
        public String getCardinality() {
            return cardinality;
        }

        public void setCardinality(String cardinality) {
            this.cardinality = cardinality;
        }

        @XmlAttribute
        public String getReverseRelationshipName() {
            return reverseRelationshipName;
        }

        public void setReverseRelationshipName(String reverseRelationshipName) {
            this.reverseRelationshipName = reverseRelationshipName;
        }

        @XmlAttribute
        public boolean isRelatedIsDependent() {
            return relatedIsDependent;
        }

        public void setRelatedIsDependent(boolean relatedIsDependent) {
            this.relatedIsDependent = relatedIsDependent;
        }

        @XmlValue
        public String getClause() {
            return clause;
        }

        public void setClause(String clause) {
            this.clause = clause;
        }

        @XmlAttribute
        public String getParameters() {
            return parameters;
        }

        public void setParameters(String parameters) {
            this.parameters = parameters;
        }

        @XmlAttribute
        public String getReturnType() {
            return returnType;
        }

        public void setReturnType(String returnType) {
            this.returnType = returnType;
        }
    }
}
