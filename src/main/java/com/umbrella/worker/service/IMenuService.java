package com.umbrella.worker.service;

import com.umbrella.worker.dto.MenuDO;
import com.umbrella.worker.query.MenuQuery;
import com.umbrella.worker.result.ResultDO;

public interface IMenuService {

	public ResultDO create(MenuDO menuDO);

	public ResultDO modifi(MenuDO menuDO);

	public ResultDO remove(int menuId);

	public ResultDO get(int menuId);

	public ResultDO list(MenuQuery menuQuery);

}
