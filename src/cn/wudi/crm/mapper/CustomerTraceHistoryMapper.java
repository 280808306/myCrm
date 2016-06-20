package cn.wudi.crm.mapper;

import java.util.List;

import cn.wudi.crm.domain.CustomerTraceHistory;
import cn.wudi.crm.query.CustomerTraceHistoryQuery;

public interface CustomerTraceHistoryMapper extends BaseMapper<CustomerTraceHistory>{

	List<CustomerTraceHistory> queryList(CustomerTraceHistoryQuery query);
	void deleteCustomerTraceHistory(Long id);
}
