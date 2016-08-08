package com.umbrella.worker.service;

import com.umbrella.worker.dto.AdminDO;
import com.umbrella.worker.query.AdminQuery;
import com.umbrella.worker.result.ResultDO;

public interface IAdminService {

	public ResultDO create(AdminDO adminDO);

	public ResultDO modifi(AdminDO adminDO);

	public ResultDO remove(int adminId);

	public ResultDO get(int adminId);

	public ResultDO list(AdminQuery adminQuery);

	public ResultDO validate(AdminDO adminDO);

}
