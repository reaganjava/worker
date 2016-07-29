package com.umbrella.worker.query;

public class SupplierQuery extends BaseQuery {
   
  
    private String name;

  
    private String city;

    
    private String district;

   
    private Integer grade;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
}