package cn.wudi.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.GuaranteeItem;
import cn.wudi.crm.mapper.GuaranteeItemMapper;
import cn.wudi.crm.service.IGuaranteeItemService;

@LogInfo("保修详细")
@Service
public class GuaranteeItemServiceImpl extends BaseServiceImpl<GuaranteeItem> implements IGuaranteeItemService {

	private GuaranteeItemMapper guaranteeItemMapper;
	
	@Autowired
	public GuaranteeItemServiceImpl(GuaranteeItemMapper mapper) {
		super(mapper);
		guaranteeItemMapper = mapper;
	}

	@LogInfo("依据保修获取详细")
	@Override
	public List<GuaranteeItem> getListByParent(Long id) {
		return guaranteeItemMapper.getListByParent(id);
	}

}
