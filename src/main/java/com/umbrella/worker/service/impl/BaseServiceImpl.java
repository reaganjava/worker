package com.umbrella.worker.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.umbrella.worker.dto.AdminDO;
import com.umbrella.worker.dto.CertificoreDO;
import com.umbrella.worker.dto.CommentDO;
import com.umbrella.worker.dto.ContactDO;
import com.umbrella.worker.dto.CouponDO;
import com.umbrella.worker.dto.MemberCouponDO;
import com.umbrella.worker.dto.MemberDetailDO;
import com.umbrella.worker.dto.MembersDO;
import com.umbrella.worker.dto.MenuDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.OrderDetailDO;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.dto.StaffDO;
import com.umbrella.worker.dto.SupplierDO;
import com.umbrella.worker.dto.TransactionDO;
import com.umbrella.worker.entity.WAdmin;
import com.umbrella.worker.entity.WCertificore;
import com.umbrella.worker.entity.WComment;
import com.umbrella.worker.entity.WContact;
import com.umbrella.worker.entity.WCoupon;
import com.umbrella.worker.entity.WMemberCoupon;
import com.umbrella.worker.entity.WMemberDetail;
import com.umbrella.worker.entity.WMembers;
import com.umbrella.worker.entity.WMenu;
import com.umbrella.worker.entity.WOrder;
import com.umbrella.worker.entity.WOrderDetail;
import com.umbrella.worker.entity.WPayrecord;
import com.umbrella.worker.entity.WStaff;
import com.umbrella.worker.entity.WSupplier;
import com.umbrella.worker.entity.WTransaction;
import com.umbrella.worker.util.BeanUtilsExtends;

public class BaseServiceImpl {

	protected  AdminDO getAdminDO(WAdmin obj) {
		if(obj == null) return null;
		AdminDO dst = new AdminDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected  List<AdminDO> getAdminDOList(List<WAdmin> list) {
		List<AdminDO> resultList = new ArrayList<AdminDO>();
		if(list.size() > 0) {
			for(WAdmin admin : list) {
				AdminDO adminDO = this.getAdminDO(admin);
				if(adminDO != null) {
					resultList.add(adminDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected CommentDO getCommentDO(WComment obj) {
		if(obj == null) return null;
		CommentDO dst = new CommentDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<CommentDO> getCommentDOList(List<WComment> list) {
		List<CommentDO> resultList = new ArrayList<CommentDO>();
		if(list.size() > 0) {
			for(WComment comment : list) {
				CommentDO commentDO = this.getCommentDO(comment);
				if(commentDO != null) {
					resultList.add(commentDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected ContactDO getContactDO(WContact obj) {
		if(obj == null) return null;
		ContactDO dst = new ContactDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<ContactDO> getContactDOList(List<WContact> list) {
		List<ContactDO> resultList = new ArrayList<ContactDO>();
		if(list.size() > 0) {
			for(WContact contact : list) {
				ContactDO contactDO = this.getContactDO(contact);
				if(contactDO != null) {
					resultList.add(contactDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected CouponDO getCouponDO(WCoupon obj) {
		if(obj == null) return null;
		CouponDO dst = new CouponDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<CouponDO> getCouponDOList(List<WCoupon> list) {
		List<CouponDO> resultList = new ArrayList<CouponDO>();
		if(list.size() > 0) {
			for(WCoupon coupon : list) {
				CouponDO couponDO = this.getCouponDO(coupon);
				if(couponDO != null) {
					resultList.add(couponDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected MemberDetailDO getMemberDetailDO(WMemberDetail obj) {
		if(obj == null) return null;
		MemberDetailDO dst = new MemberDetailDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected MemberCouponDO getMemberCouponDO(WMemberCoupon obj) {
		if(obj == null) return null;
		MemberCouponDO dst = new MemberCouponDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<MemberCouponDO> getMemberCouponDOList(List<WMemberCoupon> list) {
		List<MemberCouponDO> resultList = new ArrayList<MemberCouponDO>();
		if(list.size() > 0) {
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
	
	protected MembersDO getMemberDO(WMembers obj) {
		if(obj == null) return null;
		MembersDO dst = new MembersDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<MembersDO> getMemberDOList(List<WMembers> list) {
		List<MembersDO> resultList = new ArrayList<MembersDO>();
		if(list.size() > 0) {
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
	
	protected MenuDO getMenuDO(WMenu obj) {
		if(obj == null) return null;
		MenuDO dst = new MenuDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<MenuDO> getMenuDOList(List<WMenu> list) {
		List<MenuDO> resultList = new ArrayList<MenuDO>();
		if(list.size() > 0) {
			for(WMenu menu : list) {
				MenuDO menuDO = this.getMenuDO(menu);
				if(menuDO != null) {
					resultList.add(menuDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected OrderDO getOrderDO(WOrder obj) {
		if(obj == null) return null;
		OrderDO dst = new OrderDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<OrderDO> getOrderDOList(List<WOrder> list) {
		List<OrderDO> resultList = new ArrayList<OrderDO>();
		if(list.size() > 0) {
			for(WOrder order : list) {
				OrderDO OrderDO = this.getOrderDO(order);
				if(OrderDO != null) {
					resultList.add(OrderDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected OrderDetailDO getOrderDetailDO(WOrderDetail obj) {
		if(obj == null) return null;
		OrderDetailDO dst = new OrderDetailDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected PayrecordDO getPayrecordDO(WPayrecord obj) {
		if(obj == null) return null;
		PayrecordDO dst = new PayrecordDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<PayrecordDO> getPayrecordDOList(List<WPayrecord> list) {
		List<PayrecordDO> resultList = new ArrayList<PayrecordDO>();
		if(list.size() > 0) {
			for(WPayrecord payrecord : list) {
				PayrecordDO payrecordDO = this.getPayrecordDO(payrecord);
				if(payrecordDO != null) {
					resultList.add(payrecordDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected CertificoreDO getCertificoreDO(WCertificore obj) {
		if(obj == null) return null;
		CertificoreDO dst = new CertificoreDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<CertificoreDO> getCertificoreDOList(List<WCertificore> list) {
		List<CertificoreDO> resultList = new ArrayList<CertificoreDO>();
		if(list.size() > 0) {
			for(WCertificore certificore : list) {
				CertificoreDO certificoreDO = this.getCertificoreDO(certificore);
				if(certificoreDO != null) {
					resultList.add(certificoreDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected StaffDO getStaffDO(WStaff obj) {
		if(obj == null) return null;
		StaffDO dst = new StaffDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<StaffDO> getStaffDOList(List<WStaff> list) {
		List<StaffDO> resultList = new ArrayList<StaffDO>();
		if(list.size() > 0) {
			for(WStaff staff : list) {
				StaffDO staffDO = this.getStaffDO(staff);
				if(staffDO != null) {
					resultList.add(staffDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected SupplierDO getSupplierDO(WSupplier obj) {
		if(obj == null) return null;
		SupplierDO dst = new SupplierDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<SupplierDO> getSupplierDOList(List<WSupplier> list) {
		List<SupplierDO> resultList = new ArrayList<SupplierDO>();
		if(list.size() > 0) {
			for(WSupplier supplier : list) {
				SupplierDO supplierDO = this.getSupplierDO(supplier);
				if(supplierDO != null) {
					resultList.add(supplierDO);
				} else {
					return null;
				}
			}
		} else {
			return null;
		}
		return resultList;
	}
	
	protected TransactionDO getTransactionDO(WTransaction obj) {
		if(obj == null) return null;
		TransactionDO dst = new TransactionDO();
		return BeanUtilsExtends.copyProperties(dst, obj) ? dst : null;
	}
	
	protected List<TransactionDO> getTransactionDOList(List<WTransaction> list) {
		List<TransactionDO> resultList = new ArrayList<TransactionDO>();
		if(list.size() > 0) {
			for(WTransaction transaction : list) {
				TransactionDO transactionDO = this.getTransactionDO(transaction);
				if(transactionDO != null) {
					resultList.add(transactionDO);
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
