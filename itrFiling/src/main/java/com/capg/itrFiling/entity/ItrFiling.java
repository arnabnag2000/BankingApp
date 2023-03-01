package com.capg.itrFiling.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itrFiling")
public class ItrFiling {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String email;
	private String certificateNumber;
	private String lastUpdatedOn;
	
	private String employerName ;
	private String employerAdress ;
	private String employeeName;
	private String employeeAddress;
	
	private String employerPAN ;
	private String employerTAN ;
	private String employeePAN ;
	
	private String assessmentYear ;
	private String periodFrom;
	private String periodTo;
	
	private String Quarter[];
	private String reciptNo[];
	private double amountPaid[];
	private double taxDeducted[];
	private double taxDeposited[];
	public ItrFiling() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItrFiling(Long id, String email, String certificateNumber, String lastUpdatedOn, String employerName,
			String employerAdress, String employeeName, String employeeAddress, String employerPAN, String employerTAN,
			String employeePAN, String assessmentYear, String periodFrom, String periodTo, String[] quarter,
			String[] reciptNo, double[] amountPaid, double[] taxDeducted, double[] taxDeposited) {
		super();
		Id = id;
		this.email = email;
		this.certificateNumber = certificateNumber;
		this.lastUpdatedOn = lastUpdatedOn;
		this.employerName = employerName;
		this.employerAdress = employerAdress;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employerPAN = employerPAN;
		this.employerTAN = employerTAN;
		this.employeePAN = employeePAN;
		this.assessmentYear = assessmentYear;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
		Quarter = quarter;
		this.reciptNo = reciptNo;
		this.amountPaid = amountPaid;
		this.taxDeducted = taxDeducted;
		this.taxDeposited = taxDeposited;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployerAdress() {
		return employerAdress;
	}
	public void setEmployerAdress(String employerAdress) {
		this.employerAdress = employerAdress;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployerPAN() {
		return employerPAN;
	}
	public void setEmployerPAN(String employerPAN) {
		this.employerPAN = employerPAN;
	}
	public String getEmployerTAN() {
		return employerTAN;
	}
	public void setEmployerTAN(String employerTAN) {
		this.employerTAN = employerTAN;
	}
	public String getEmployeePAN() {
		return employeePAN;
	}
	public void setEmployeePAN(String employeePAN) {
		this.employeePAN = employeePAN;
	}
	public String getAssessmentYear() {
		return assessmentYear;
	}
	public void setAssessmentYear(String assessmentYear) {
		this.assessmentYear = assessmentYear;
	}
	public String getPeriodFrom() {
		return periodFrom;
	}
	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}
	public String getPeriodTo() {
		return periodTo;
	}
	public void setPeriodTo(String periodTo) {
		this.periodTo = periodTo;
	}
	public String[] getQuarter() {
		return Quarter;
	}
	public void setQuarter(String[] quarter) {
		Quarter = quarter;
	}
	public String[] getReciptNo() {
		return reciptNo;
	}
	public void setReciptNo(String[] reciptNo) {
		this.reciptNo = reciptNo;
	}
	public double[] getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double[] amountPaid) {
		this.amountPaid = amountPaid;
	}
	public double[] getTaxDeducted() {
		return taxDeducted;
	}
	public void setTaxDeducted(double[] taxDeducted) {
		this.taxDeducted = taxDeducted;
	}
	public double[] getTaxDeposited() {
		return taxDeposited;
	}
	public void setTaxDeposited(double[] taxDeposited) {
		this.taxDeposited = taxDeposited;
	}
	@Override
	public String toString() {
		return "ItrFiling [Id=" + Id + ", email=" + email + ", certificateNumber=" + certificateNumber
				+ ", lastUpdatedOn=" + lastUpdatedOn + ", employerName=" + employerName + ", employerAdress="
				+ employerAdress + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress
				+ ", employerPAN=" + employerPAN + ", employerTAN=" + employerTAN + ", employeePAN=" + employeePAN
				+ ", assessmentYear=" + assessmentYear + ", periodFrom=" + periodFrom + ", periodTo=" + periodTo
				+ ", Quarter=" + Arrays.toString(Quarter) + ", reciptNo=" + Arrays.toString(reciptNo) + ", amountPaid="
				+ Arrays.toString(amountPaid) + ", taxDeducted=" + Arrays.toString(taxDeducted) + ", taxDeposited="
				+ Arrays.toString(taxDeposited) + "]";
	}
	
	
	
}