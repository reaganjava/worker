package com.umbrella.worker.service;

import com.umbrella.worker.dto.MemberDetailDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.result.ResultDO;

public interface IMemberService {

	public ResultDO create(MembersDO membersDO);
	
	public ResultDO validate(MembersDO membersDO);
	
	public ResultDO modifi(MemberDetailDO memberDetailDO);
	
	public ResultDO remove(Integer memberId);
	
	public ResultDO get(Integer memberId);
	
	public ResultDO list(MembersQuery membersQuery);

	public ResultDO modifiPwd(MembersDO membersDO);

	public ResultDO isMobileReg(MembersQuery membersQuery);
	
}
