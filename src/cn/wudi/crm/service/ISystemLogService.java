package cn.wudi.crm.service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.SystemLog;

@LogInfo("系统菜单")
public interface ISystemLogService extends IBaseService<SystemLog> {

}
