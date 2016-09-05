package com.umbrella.worker.service.impl;

import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.GetWeixinOAuth;
import com.umbrella.worker.util.StringUtil;



import com.umbrella.worker.dao.WContactMapper;
import com.umbrella.worker.dao.WMemberCouponMapper;
import com.umbrella.worker.dao.WMemberDetailMapper;
import com.umbrella.worker.dao.WMembersMapper;
import com.umbrella.worker.dao.WOrderMapper;
import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.MemberCouponDO;
import com.umbrella.worker.dto.MemberDetailDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.entity.WContact;
import com.umbrella.worker.entity.WContactExample;
import com.umbrella.worker.entity.WMemberCoupon;
import com.umbrella.worker.entity.WMemberCouponExample;
import com.umbrella.worker.entity.WMemberDetail;
import com.umbrella.worker.entity.WMembers;
import com.umbrella.worker.entity.WMembersExample;
import com.umbrella.worker.entity.WOrderExample;
import com.umbrella.worker.query.MembersQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;

@Service("memberService")
public class MemberServiceImpl  extends BaseServiceImpl implements IMemberService {
	
	private static Logger logger = Logger.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private WMembersMapper membersMapper;
	
	@Autowired
	private WMemberDetailMapper memberDetailMapper;
	
	@Autowired
	private WMemberCouponMapper memberCouponMapper;
	
	@Autowired
	private WContactMapper contactMapper;
	
	@Autowired
	private WOrderMapper orderMapper;

	@Override
	public ResultDO create(MembersDO membersDO) {
		
		WMembers members = new WMembers();
		
		ResultSupport result = BeanUtilsExtends.copy(members, membersDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		members.setwMRegTime(Calendar.getInstance().getTime());
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
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		recordNum = -1;
		
		WMemberDetail memberDetail = new WMemberDetail();
		
		memberDetail.setId(members.getId());
		memberDetail.setCreateAuthor(members.getCreateAuthor());
		memberDetail.setCreateTime(members.getCreateTime());
		memberDetail.setModifiAuthor(members.getModifiAuthor());
		memberDetail.setModifiTime(members.getModifiTime());
		memberDetail.setDatalevel(1);
		
		try {
			recordNum = memberDetailMapper.insertSelective(memberDetail);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:catalogs][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum < 1) {
			result.setSuccess(false);
			return result;
		}
		
		result.setModel(ResultDO.FIRST_MODEL_KEY, members.getId());
		
		return result;
	}

	@Override
	public ResultDO validate(MembersDO membersDO) {
		
		ResultSupport result = new ResultSupport();
		
		WMembersExample example = new WMembersExample();
		
		example.createCriteria()
			.andWMMobileEqualTo(membersDO.getwMMobile())
			.andWMPasswordEqualTo(membersDO.getwMPassword())
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
			membersDO = getMemberDO(list.get(0));
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
	public ResultDO isMobileReg(MembersQuery membersQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WMembersExample example = new WMembersExample();
		WMembersExample.Criteria c = example.createCriteria();
		
		if(StringUtil.isNotEmpty(membersQuery.getMobile())) {
			c.andWMMobileEqualTo(membersQuery.getMobile());
		}
		
		int recordNum = -1;
		try {
			recordNum = membersMapper.countByExample(example);
		} catch (Exception e) {
            result.setSuccess(false);
            result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
            result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
            logger.error("[obj:member][opt:login][msg:"+e.getMessage()+"]");
            return result;
		}
		
		if(recordNum > 0) {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@Override
	public ResultDO modifiPwd(MembersDO membersDO) {
		
		ResultSupport result = new ResultSupport();
		
		WMembersExample example = new WMembersExample();
		System.out.println(membersDO.getId() + ":" + membersDO.getOldPassword());
		example.createCriteria()
			.andIdEqualTo(membersDO.getId())
			.andWMPasswordEqualTo(membersDO.getOldPassword());
		List<WMembers> list = null;
		try {
			list = membersMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:members][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		System.out.println(list.size());
		if(list.size() < 1) {
			result.setSuccess(false);
			return result;
		}
		WMembers members = new WMembers();
		
		result = BeanUtilsExtends.copy(members, membersDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		members.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		
		try {
			recordNum = membersMapper.updateByExampleSelective(members, example);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:members][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		System.out.println(recordNum);
		if (recordNum < 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(MemberDetailDO memberDetailDO) {
		
		WMemberDetail memberDetail = new WMemberDetail();

		ResultSupport result = BeanUtilsExtends.copy(memberDetail, memberDetailDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		memberDetail.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = memberDetailMapper.updateByPrimaryKey(memberDetail);
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
			return result;
		}
		
		recordNum = -1;
		WMemberDetail memberDetail = new WMemberDetail();
		
		memberDetail.setId(memberId);
		memberDetail.setDatalevel(-1);
		
		try {
			recordNum = memberDetailMapper.updateByPrimaryKeySelective(memberDetail);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:member][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if (recordNum != 1) {
			result.setSuccess(false);
			return result;
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
		
		MembersDO membersDO = getMemberDO(members);
		
		if(membersDO == null) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		WMemberDetail memberDetail = null;
		try {
			memberDetail = memberDetailMapper.selectByPrimaryKey(memberId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		MemberDetailDO memberDetailDO = getMemberDetailDO(memberDetail);
		
		if(memberDetailDO == null) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		membersDO.setMemberDetailDO(memberDetailDO);
		
		WMemberCouponExample example = new WMemberCouponExample();
		example.createCriteria().andWMcMemberIdEqualTo(memberId);
		
		List<MemberCouponDO> memberCouponDOList = null;
		try {
			List<WMemberCoupon> list = memberCouponMapper.selectByExample(example);
			memberCouponDOList = getMemberCouponDOList(list);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:memberCoupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if(memberCouponDOList != null) {
			membersDO.setCouponsCount(memberCouponDOList.size());
			membersDO.setMemberCoupons(memberCouponDOList);
		} else {
			membersDO.setCouponsCount(0);
		}
		
		
		WContactExample wcex = new WContactExample();
		wcex.createCriteria().andWCMembersIdEqualTo(memberId);
		
		List<ContactDO> contactDOList = null;
		try {
			List<WContact> list = contactMapper.selectByExample(wcex);
			contactDOList = getContactDOList(list);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:memberCoupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		if(contactDOList != null) {
			membersDO.setContacts(contactDOList);
		} 
		
		WOrderExample woex = new WOrderExample();
		WOrderExample.Criteria c = woex.createCriteria();
		
		
		c.andWOMembersIdEqualTo(memberId);
		int count;
		try {
			count = orderMapper.countByExample(woex);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        e.printStackTrace();
	        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		membersDO.setOrderCount(count);
		result.setModel(ResultSupport.FIRST_MODEL_KEY, membersDO);
		
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
			example.setOrderByClause(" CREATE_TIME DESC");
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
	
	public ResultDO userOAuth(String userCode) {
		ResultSupport result = new ResultSupport();
		
		String oauth2_url = Constant.WEIXIN_OAUTH2_URL;
		oauth2_url = oauth2_url.replace("{APPID}", Constant.APP_ID)
				  .replace("{SECRET}", Constant.APP_SECRET)
				  .replace("{CODE}", userCode);
		System.out.println(oauth2_url);
		//第一次请求 获取access_token 和 openid
		String oppid = null;
		try {
			oppid = new GetWeixinOAuth().doGet(oauth2_url);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		JSONObject oppidObj = JSONObject.fromObject(oppid);
		String access_token = (String) oppidObj.get("access_token");
		String openid = (String) oppidObj.get("openid");
		String requestUrl2 = "https://api.weixin.qq.com/sns/userinfo?access_token=" 
				+ access_token + "&openid=" + openid + "&lang=zh_CN";
		String userInfoStr = null;
		try {
			userInfoStr = new GetWeixinOAuth().doGet(requestUrl2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject wxUserInfo = JSONObject.fromObject(userInfoStr);
		
		System.out.println("====================" + openid);
		if(oppid != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, openid);
		} else {
			result.setSuccess(false);
		}
		return result;
	}
	
	

}
