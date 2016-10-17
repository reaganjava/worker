package com.umbrella.worker.service;

import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.query.OrderQuery;
import com.umbrella.worker.result.ResultDO;

public interface IOrderService {
	
	public ResultDO create(OrderDO orderDO);
	
	public ResultDO modifi(OrderDO orderDO);
	
	public ResultDO assigned(OrderDO orderDO);
	
	public ResultDO updateStatus(OrderDO orderDO);
	
	public ResultDO remove(int orderId);
	
	public ResultDO list(OrderQuery orderQuery);
	
	public ResultDO confirm(int orderId);
	
	public ResultDO get(int orderId);
	
	public ResultDO modifiDetail(OrderDetailDO orderDetailDO);

	public ResultDO rush(OrderDO orderDO);
	
	public ResultDO watiList();
}
