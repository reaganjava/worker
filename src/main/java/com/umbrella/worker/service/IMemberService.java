package com.umbrella.worker.service;

import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.result.ResultDO;

public interface IMemberService {

	public ResultDO register(MembersDO membersDO);
	
	public ResultDO login(MembersQuery membersQuery);
	
	public ResultDO modifi(MembersDO membersDO);
	
	public ResultDO remove(Integer memberId);
	
	public ResultDO get(Integer memberId);
	
	public ResultDO list(MembersDO membersDO);
	
}
