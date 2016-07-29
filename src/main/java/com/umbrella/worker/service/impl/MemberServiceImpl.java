package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.dao.WMembersMapper;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.entity.WMembers;
import com.umbrella.worker.entity.WMembersExample;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;

public class MemberServiceImpl implements IMemberService {
	
	private static Logger logger = Logger.getLogger(MemberServiceImpl.class);
	
	private WMembersMapper membersMapper;

	@Override
	public ResultDO register(MembersDO membersDO) {
		
		WMembers members = new WMembers();
		
		ResultSupport result = BeanUtilsExtends.copy(membersDO, members);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		members.setwMRegisterTime(Calendar.getInstance().getTime());
		members.setDatalevel(1);
		members.setStatus(1);
		members.setCreateTime(Calendar.getInstance().getTime());
		members.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = membersMapper.insertSelective(members);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:catalogs][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, members.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO login(MembersQuery membersQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WMembersExample example = new WMembersExample();
		
		example.createCriteria()
			.andWMMobileEqualTo(membersQuery.getMobile())
			.andWMPasswordEqualTo(membersQuery.getPassword())
			.andDatalevelNotEqualTo(-1);
		List<WMembers> list = null;
		try {
			list = membersMapper.selectByExample(example);
		} catch (Exception e) {
            result.setSuccess(false);
            result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
            result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
            logger.error("[obj:member][opt:login][msg:"+e.getMessage()+"]");
            return result;
		}
		
		if(list != null && list.isEmpty()) {
			if(list.size() == 1) {
				MembersDO membersDO = getMemberDO(list.get(0));
				if(membersDO != null) {
					result.setModel(ResultSupport.FIRST_MODEL_KEY, membersDO);
				} else {
					result.setSuccess(false);
					result.setErrorCode(ResultDO.MEMBER_LOGIN_FAILED);
		            result.setErrorMsg(ResultDO.MEMBER_LOGIN_FAILED_MSG);
					return result;
				}
			} else {
				result.setSuccess(false);
				result.setErrorCode(ResultDO.MEMBER_LOGIN_FAILED);
	            result.setErrorMsg(ResultDO.MEMBER_LOGIN_FAILED_MSG);
				return result;
			}
		} else {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.MEMBER_LOGIN_FAILED);
            result.setErrorMsg(ResultDO.MEMBER_LOGIN_FAILED_MSG);
			return result;
		}
		return result;
	}

	@Override
	public ResultDO modifi(MembersDO membersDO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDO remove(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDO get(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDO list(MembersDO membersDO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private MembersDO getMemberDO(WMembers obj) {
		if(obj == null) return null;
		MembersDO dst = new MembersDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<MembersDO> getMemberDOList(List<WMembers> list) {
		List<MembersDO> resultList = new ArrayList<MembersDO>();
		if(list != null && list.isEmpty()) {
			for(WMembers members : list) {
				MembersDO memberDO = this.getMemberDO(members);
				if(memberDO != null) {
					resultList.add(memberDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}

}
