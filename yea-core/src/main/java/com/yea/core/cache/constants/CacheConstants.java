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
package com.yea.core.cache.constants;

public class CacheConstants {
	
	public enum PutMode {
		UN_LIMIT("UX"),   //无限制
		EXIST("XX"),      //只有Key值存在时才允许覆盖
		NOT_EXIST("NX");  //只有Key值不存在时才允许覆盖
		private String value;
        private PutMode(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
		
	}
}
