package com.umbrella.worker.service;

import com.umbrella.worker.dto.CouponDO;
import com.umbrella.worker.query.CouponQuery;
import com.umbrella.worker.result.ResultDO;

public interface ICouponService {
	
	public ResultDO create(CouponDO couponDO);
	
	public ResultDO modifi(CouponDO couponDO);
	
	public ResultDO remove(int couponId);
	
	public ResultDO get(int couponId);
	
	public ResultDO list(CouponQuery couponQuery);
	
	public ResultDO memberCoupon(Integer couponId);

}