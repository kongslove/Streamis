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

import java.util

import org.apache.linkis.protocol.utils.TaskUtils
import com.webank.wedatasphere.streamis.jobmanager.launcher.entity.vo.{ConfigKeyVO, ConfigRelationVO}
import com.webank.wedatasphere.streamis.jobmanager.launcher.linkis.entity.LaunchJob
import com.webank.wedatasphere.streamis.jobmanager.manager.transform.ConfigTransform

import scala.collection.convert.WrapAsScala._


class ResourceConfigTransform extends ConfigTransform {

  override protected def transform(config: ConfigKeyVO, job: LaunchJob): LaunchJob =
    transformConfig(config.getResourceConfig, job)

  protected def transformConfig(getConfig: => util.List[ConfigRelationVO], job: LaunchJob): LaunchJob = {
    val startupMap = new util.HashMap[String, Any]
    val configSeq = getConfig
    if(configSeq != null) configSeq.foreach { vo =>
      startupMap.put(vo.getKey, vo.getValue)
    }
    val params = if(job.getParams == null) new util.HashMap[String, Any] else job.getParams
    if(!startupMap.isEmpty) TaskUtils.addStartupMap(params, startupMap)
    LaunchJob.builder().setLaunchJob(job).setParams(params).build()
  }

}
