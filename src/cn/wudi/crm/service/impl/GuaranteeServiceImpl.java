package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.aop.LogInfo;
import cn.wudi.crm.domain.Guarantee;
import cn.wudi.crm.domain.GuaranteeItem;
import cn.wudi.crm.mapper.GuaranteeItemMapper;
import cn.wudi.crm.mapper.GuaranteeMapper;
import cn.wudi.crm.service.IGuaranteeService;

@LogInfo("保修")
@Service
public class GuaranteeServiceImpl extends BaseServiceImpl<Guarantee> implements IGuaranteeService {

	private GuaranteeMapper guaranteeMapper;

	@Autowired
	private GuaranteeItemMapper guaranteeItemMapper;

	@Autowired
	public GuaranteeServiceImpl(GuaranteeMapper mapper) {
		super(mapper);
		guaranteeMapper = mapper;
	}

	@LogInfo("保修保存")
	@Override
	public void save(Guarantee guarantee) {
		guaranteeMapper.save(guarantee);
		for (GuaranteeItem item : guarantee.getItems()) {
			item.setGuarantee(guarantee);
			guaranteeItemMapper.save(item);
		}
	}

	@LogInfo("修改")
	@Override
	public void update(Guarantee guarantee) {
		guaranteeMapper.update(guarantee);
		for (GuaranteeItem item : guaranteeItemMapper.getListByParent(guarantee.getId())) {
			guaranteeItemMapper.delete(item.getId());
		}
		for (GuaranteeItem item : guarantee.getItems()) {
			item.setGuarantee(guarantee);
			guaranteeItemMapper.save(item);
		}
	}

	@LogInfo("删除")
	@Override
	public void delete(Long id) {
		guaranteeMapper.delete(id);
		for (GuaranteeItem item : guaranteeItemMapper.getListByParent(id)) {
			guaranteeItemMapper.delete(item.getId());
		}
	}

}
