/*
 * Copyright 2021 WeBank
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.streamis.jobmanager.manager.transform.impl

import com.webank.wedatasphere.streamis.jobmanager.launcher.entity.vo.ConfigKeyVO
import com.webank.wedatasphere.streamis.jobmanager.launcher.linkis.entity.LaunchJob

import scala.collection.convert.WrapAsScala._


class ExtraConfigTransform extends ResourceConfigTransform {

  override protected def transform(config: ConfigKeyVO, job: LaunchJob): LaunchJob = transformConfig(config.getParameterConfig, job)

}
