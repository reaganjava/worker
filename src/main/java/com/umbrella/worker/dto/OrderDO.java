package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class OrderDO extends BaseDO {
   
    private Integer id;
    
    private Integer wOMembersId;
    

    private MembersDO membersDO;
    

    private SupplierDO supplierDO;
    
    
    private OrderDetailDO orderDetailDO;
    
    
    private OrderTaskDO orderTaskDO;

   
    private String wOOrderNo;
    
    
    private String wOServiceName;

   
    private Integer wOPayType;

   
    private BigDecimal wOFee;

    
    private Integer wOIsEnd;

   
    private Integer wOIsConfim;

   
    private Integer wOIsPay;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getwOMembersId() {
		return wOMembersId;
	}


	public void setwOMembersId(Integer wOMembersId) {
		this.wOMembersId = wOMembersId;
	}


	public MembersDO getMembersDO() {
		return membersDO;
	}


	public void setMembersDO(MembersDO membersDO) {
		this.membersDO = membersDO;
	}


	public String getwOServiceName() {
		return wOServiceName;
	}


	public void setwOServiceName(String wOServiceName) {
		this.wOServiceName = wOServiceName;
	}


	public SupplierDO getSupplierDO() {
		return supplierDO;
	}


	public void setSupplierDO(SupplierDO supplierDO) {
		this.supplierDO = supplierDO;
	}


	public OrderDetailDO getOrderDetailDO() {
		return orderDetailDO;
	}


	public void setOrderDetailDO(OrderDetailDO orderDetailDO) {
		this.orderDetailDO = orderDetailDO;
	}


	public OrderTaskDO getOrderTaskDO() {
		return orderTaskDO;
	}


	public void setOrderTaskDO(OrderTaskDO orderTaskDO) {
		this.orderTaskDO = orderTaskDO;
	}


	public String getwOOrderNo() {
		return wOOrderNo;
	}


	public void setwOOrderNo(String wOOrderNo) {
		this.wOOrderNo = wOOrderNo;
	}


	public Integer getwOPayType() {
		return wOPayType;
	}


	public void setwOPayType(Integer wOPayType) {
		this.wOPayType = wOPayType;
	}


	public BigDecimal getwOFee() {
		return wOFee;
	}


	public void setwOFee(BigDecimal wOFee) {
		this.wOFee = wOFee;
	}


	public Integer getwOIsEnd() {
		return wOIsEnd;
	}


	public void setwOIsEnd(Integer wOIsEnd) {
		this.wOIsEnd = wOIsEnd;
	}


	public Integer getwOIsConfim() {
		return wOIsConfim;
	}


	public void setwOIsConfim(Integer wOIsConfim) {
		this.wOIsConfim = wOIsConfim;
	}


	public Integer getwOIsPay() {
		return wOIsPay;
	}


	public void setwOIsPay(Integer wOIsPay) {
		this.wOIsPay = wOIsPay;
	}

   
   
}