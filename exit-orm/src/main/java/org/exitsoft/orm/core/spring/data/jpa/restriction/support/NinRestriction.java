/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exitsoft.orm.core.spring.data.jpa.restriction.support;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.exitsoft.orm.core.RestrictionNames;
import org.exitsoft.orm.core.spring.data.jpa.restriction.PredicateMultipleValueSupport;

/**
 * 不包含约束 (from object o where o.value not in (?,?,?,?,?))RestrictionName:NIN
 * <p>
 * 表达式:NIN属性类型_属性名称[_OR_属性名称...]
 * </p>
 * 
 * @author vincent
 *
 */
public class NinRestriction extends PredicateMultipleValueSupport{
	
	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.PredicateBuilder#getRestrictionName()
	 */
	public String getRestrictionName() {
		
		return RestrictionNames.NIN;
	}

	/*
	 * (non-Javadoc)
	 * @see org.exitsoft.orm.core.spring.data.jpa.restriction.PredicateMultipleValueSupport#buildRestriction(javax.persistence.criteria.Path, java.lang.Object[], javax.persistence.criteria.CriteriaBuilder)
	 */
	public Predicate buildRestriction(Path<?> expression, Object[] values,CriteriaBuilder builder) {

		return builder.not(expression.in(values));
	}




}

