package com.umbrella.worker.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StaffDO extends BaseDO {
    
	private Integer id;

    private Integer wSSupplierId;
    
    private String supplierName;

    private Integer wSAttacId;

    private String wStaffName;

    private Integer wStaffGender;

    private String wSIdcard;

    private Integer wSAge;

    private Integer wSWokerYear;

    private Integer wSGrade;
    //1.清洁阿姨 2.保姆 3.月嫂 4.育儿嫂 5.陪护
    private Integer wSType;

    private Integer wSScore;

    private String wSAddress;

    private String wSTelephone;

    private String wSPlace;

    private String wSItems;

    private String wSTerget;

    private Integer wSWorkCount;

    private String wSDesc;

    private BigDecimal wSPriceFirst;

    private BigDecimal wSPriceSecond;

    private BigDecimal wSPriceThrid;

    private Integer wSRestDay;

    private String wSNation;

    private Integer wSIsMarri;

    private String wSAttribute;

    private String wSEdu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getwSSupplierId() {
		return wSSupplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setwSSupplierId(Integer wSSupplierId) {
		this.wSSupplierId = wSSupplierId;
	}

	public Integer getwSAttacId() {
		return wSAttacId;
	}

	public void setwSAttacId(Integer wSAttacId) {
		this.wSAttacId = wSAttacId;
	}

	public String getwStaffName() {
		return wStaffName;
	}

	public void setwStaffName(String wStaffName) {
		this.wStaffName = wStaffName;
	}

	public Integer getwStaffGender() {
		return wStaffGender;
	}

	public void setwStaffGender(Integer wStaffGender) {
		this.wStaffGender = wStaffGender;
	}

	public String getwSIdcard() {
		return wSIdcard;
	}

	public void setwSIdcard(String wSIdcard) {
		this.wSIdcard = wSIdcard;
	}

	public Integer getwSAge() {
		return wSAge;
	}

	public void setwSAge(Integer wSAge) {
		this.wSAge = wSAge;
	}

	public Integer getwSWokerYear() {
		return wSWokerYear;
	}

	public void setwSWokerYear(Integer wSWokerYear) {
		this.wSWokerYear = wSWokerYear;
	}

	public Integer getwSGrade() {
		return wSGrade;
	}

	public void setwSGrade(Integer wSGrade) {
		this.wSGrade = wSGrade;
	}

	public Integer getwSType() {
		return wSType;
	}

	public void setwSType(Integer wSType) {
		this.wSType = wSType;
	}

	public Integer getwSScore() {
		return wSScore;
	}

	public void setwSScore(Integer wSScore) {
		this.wSScore = wSScore;
	}

	public String getwSAddress() {
		return wSAddress;
	}

	public void setwSAddress(String wSAddress) {
		this.wSAddress = wSAddress;
	}

	public String getwSTelephone() {
		return wSTelephone;
	}

	public void setwSTelephone(String wSTelephone) {
		this.wSTelephone = wSTelephone;
	}

	public String getwSPlace() {
		return wSPlace;
	}

	public void setwSPlace(String wSPlace) {
		this.wSPlace = wSPlace;
	}

	public String getwSItems() {
		return wSItems;
	}

	public void setwSItems(String wSItems) {
		this.wSItems = wSItems;
	}

	public String getwSTerget() {
		return wSTerget;
	}

	public void setwSTerget(String wSTerget) {
		this.wSTerget = wSTerget;
	}

	public Integer getwSWorkCount() {
		return wSWorkCount;
	}

	public void setwSWorkCount(Integer wSWorkCount) {
		this.wSWorkCount = wSWorkCount;
	}

	public String getwSDesc() {
		return wSDesc;
	}

	public void setwSDesc(String wSDesc) {
		this.wSDesc = wSDesc;
	}

	public BigDecimal getwSPriceFirst() {
		return wSPriceFirst;
	}

	public void setwSPriceFirst(BigDecimal wSPriceFirst) {
		this.wSPriceFirst = wSPriceFirst;
	}

	public BigDecimal getwSPriceSecond() {
		return wSPriceSecond;
	}

	public void setwSPriceSecond(BigDecimal wSPriceSecond) {
		this.wSPriceSecond = wSPriceSecond;
	}

	public BigDecimal getwSPriceThrid() {
		return wSPriceThrid;
	}

	public void setwSPriceThrid(BigDecimal wSPriceThrid) {
		this.wSPriceThrid = wSPriceThrid;
	}

	public Integer getwSRestDay() {
		return wSRestDay;
	}

	public void setwSRestDay(Integer wSRestDay) {
		this.wSRestDay = wSRestDay;
	}

	public String getwSNation() {
		return wSNation;
	}

	public void setwSNation(String wSNation) {
		this.wSNation = wSNation;
	}

	public Integer getwSIsMarri() {
		return wSIsMarri;
	}

	public void setwSIsMarri(Integer wSIsMarri) {
		this.wSIsMarri = wSIsMarri;
	}

	public String getwSAttribute() {
		return wSAttribute;
	}

	public void setwSAttribute(String wSAttribute) {
		this.wSAttribute = wSAttribute;
	}

	public String getwSEdu() {
		return wSEdu;
	}

	public void setwSEdu(String wSEdu) {
		this.wSEdu = wSEdu;
	}

}