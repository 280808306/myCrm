package cn.wudi.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wudi.crm.domain.CutomerTransfer;
import cn.wudi.crm.mapper.CutomerTransferMapper;
import cn.wudi.crm.service.ICutomerTransferService;
@Service
public class CutomerTransferServiceImpl extends BaseServiceImpl<CutomerTransfer> implements ICutomerTransferService{
	private CutomerTransferMapper cutomerTransferMapper;
	@Autowired
	public CutomerTransferServiceImpl(CutomerTransferMapper cutomerTransferMapper) {
		super(cutomerTransferMapper);
		this.cutomerTransferMapper=cutomerTransferMapper;
	}
}
