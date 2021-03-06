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
package com.yea.achieve.shiro.act;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yea.achieve.shiro.service.ShiroService;
import com.yea.core.base.act.AbstractAct;


/**
 * 
 * @author yiyongfei
 * 
 */
@Component("shiroAct")
public class ShiroAct extends AbstractAct<Object> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ShiroService shiroService;
    
    @Override
    protected Object perform(Object[] messages) throws Exception {
    	return shiroService.executeSQL((String)messages[0], (Object[])messages[1]);
    }
    
}
