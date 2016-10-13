package com.umbrella.worker.service;

import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.query.ContactQuery;
import com.umbrella.worker.result.ResultDO;

public interface IContactService {
	
	public ResultDO create(ContactDO contactDO);
	
	public ResultDO modifi(ContactDO contactDO);
	
	public ResultDO setDefault(ContactDO contactDO);
	
	public ResultDO remove(int contactId);
	
	public ResultDO get(int contactId);
	
	public ResultDO list(ContactQuery contactQuery);

}
