package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.StringUtil;
import com.umbrella.worker.dao.WMemberCouponMapper;
import com.umbrella.worker.dao.WMembersMapper;
import com.umbrella.worker.dto.MemberCouponDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.entity.WMemberCoupon;
import com.umbrella.worker.entity.WMemberCouponExample;
import com.umbrella.worker.entity.WMembers;
import com.umbrella.worker.entity.WMembersExample;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;

public class MemberServiceImpl implements IMemberService {
	
	private static Logger logger = Logger.getLogger(MemberServiceImpl.class);
	
	private WMembersMapper membersMapper;
	
	private WMemberCouponMapper memberCouponMapper;

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
		
		return result;
	}

	@Override
	public ResultDO modifi(MembersDO membersDO) {
		WMembers members = new WMembers();

		ResultSupport result = BeanUtilsExtends.copy(members, membersDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		members.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = membersMapper.updateByPrimaryKey(members);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:members][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(Integer memberId) {
		
		ResultSupport result = new ResultSupport();
		
		WMembers members = new WMembers();
		
		if(StringUtil.isGreatOne(memberId)) {
			members.setId(memberId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		members.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = membersMapper.updateByPrimaryKeySelective(members);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:member][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(Integer memberId) {
		
		ResultSupport result = new ResultSupport();
		
		WMembers members = null;
		if(!StringUtil.isGreatOne(memberId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			members = membersMapper.selectByPrimaryKey(memberId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		WMemberCouponExample example = new WMemberCouponExample();
		example.createCriteria().andWMcMemberIdEqualTo(memberId);
		try {
			memberCouponMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:memberCoupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		MembersDO membersDO = getMemberDO(members);
		if(membersDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, membersDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(MembersQuery membersQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WMembersExample example = new WMembersExample();
		WMembersExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isNotEmpty(membersQuery.getMobile())) {
			c.andWMMobileEqualTo(membersQuery.getMobile());
		}
		if(StringUtil.isGreatOne(membersQuery.getStart())) { 
			//c.andStatusEqualTo(membersQuery.getStart());
		}
		
		if(StringUtil.isNotEmpty(membersQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + membersQuery.getOrderByClause() + " " + membersQuery.getSort());
		} else {
			example.setOrderByClause(" W_M_REGISTER_TIME DESC");
		}
		
		if(membersQuery.isPage()) {
			long count = 0;
			try {
				count = membersMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = membersQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * membersQuery.getPageRows())
					+ "," + membersQuery.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WMembers> list = null;
		
		try {
			list = membersMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<MembersDO> memberList = getMemberDOList(list);
		
		if(memberList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, memberList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
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
	
	private MemberCouponDO getMemberCouponDO(WMemberCoupon obj) {
		if(obj == null) return null;
		MemberCouponDO dst = new MemberCouponDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	private List<MemberCouponDO> getMemberCouponDOList(List<WMemberCoupon> list) {
		List<MemberCouponDO> resultList = new ArrayList<MemberCouponDO>();
		if(list != null && list.isEmpty()) {
			for(WMemberCoupon memberCoupon : list) {
				MemberCouponDO memberCouponDO = this.getMemberCouponDO(memberCoupon);
				if(memberCouponDO != null) {
					resultList.add(memberCouponDO);
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
