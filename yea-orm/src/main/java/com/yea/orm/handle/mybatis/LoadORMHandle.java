/**
 * Copyright 2017 伊永飞
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yea.orm.handle.mybatis;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;

import com.yea.core.cache.annotation.AnnotationConstants;
import com.yea.core.cache.annotation.Cache;
import com.yea.orm.handle.AbstractORMHandle;
import com.yea.orm.handle.ORMConstants;
import com.yea.orm.handle.ORMHandle;
import com.yea.orm.handle.ORMHandleFactory;
import com.yea.orm.handle.dto.ORMParams;

/**
 * 查询一条符合条件的数据操作
 * 
 * @author yiyongfei
 *
 */
public class LoadORMHandle<T> extends AbstractORMHandle<T> {
    
	public LoadORMHandle() {
		super(ORMConstants.ORM_LEVEL.M_LOAD.getCode());
	}

	@Cache(AnnotationConstants.CommandType.GET)
	@Override
	protected T execute(SqlSessionTemplate sessionTemplate, ORMParams dto) throws Exception{
		// TODO Auto-generated method stub
		if(dto.getParam() == null){
			throw new SQLException("执行Load时，请提供主键对象!");
		}
		return sessionTemplate.selectOne(dto.getSqlid(), dto.getParam());
	}

	@Override
	public void setNextHandle() {
		// TODO Auto-generated method stub
		ORMHandle<T> nextHandle = ORMHandleFactory.getInstance(ORMConstants.ORM_LEVEL.M_QUERY);
		this.setNextHandle(nextHandle);
	}
}
