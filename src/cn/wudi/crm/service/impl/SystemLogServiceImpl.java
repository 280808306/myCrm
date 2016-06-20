package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.SystemLog;
import cn.wudi.crm.mapper.SystemLogMapper;
import cn.wudi.crm.service.ISystemLogService;

@LogInfo("系统日志")
@Service
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog> implements ISystemLogService {

	private SystemLogMapper systemLogMapper;
	
	@Autowired
	public SystemLogServiceImpl(SystemLogMapper systemLogMapper) {
		super(systemLogMapper);
		this.systemLogMapper = systemLogMapper;
	}
}
