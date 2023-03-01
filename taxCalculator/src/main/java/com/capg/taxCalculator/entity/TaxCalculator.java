package com.capg.taxCalculator.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxCalculator")
public class TaxCalculator {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String email;
	private String financialYear;
	private int age;
	private double incomeSalary;
	private double incomeInterest;
	private double incomeRental;
	private double incomeDigital;
	private double incomeOther;
	private double allowences;
	private double interstHomeLoan;
	private double interestLoan;
	private double deduction80C;
	private double deduction80D;
	private double deduction80E;
	private double deduction80CCD;
	private double deduction80TTA;
	private double deduction80G;
	private double deduction80EEA;
	private double netTax;
	
	public TaxCalculator(Long id, String email, String financialYear, int age, double incomeSalary,
			double incomeInterest, double incomeRental, double incomeDigital, double incomeOther, double allowences,
			double interstHomeLoan, double interestLoan, double deduction80c, double deduction80d, double deduction80e,
			double deduction80ccd, double deduction80tta, double deduction80g, double deduction80eea, double netTax) {
		super();
		Id = id;
		this.email = email;
		this.financialYear = financialYear;
		this.age = age;
		this.incomeSalary = incomeSalary;
		this.incomeInterest = incomeInterest;
		this.incomeRental = incomeRental;
		this.incomeDigital = incomeDigital;
		this.incomeOther = incomeOther;
		this.allowences = allowences;
		this.interstHomeLoan = interstHomeLoan;
		this.interestLoan = interestLoan;
		deduction80C = deduction80c;
		deduction80D = deduction80d;
		deduction80E = deduction80e;
		deduction80CCD = deduction80ccd;
		deduction80TTA = deduction80tta;
		deduction80G = deduction80g;
		deduction80EEA = deduction80eea;
		this.netTax = netTax;
	}

	public TaxCalculator() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getIncomeSalary() {
		return incomeSalary;
	}

	public void setIncomeSalary(double incomeSalary) {
		this.incomeSalary = incomeSalary;
	}

	public double getIncomeInterest() {
		return incomeInterest;
	}

	public void setIncomeInterest(double incomeInterest) {
		this.incomeInterest = incomeInterest;
	}

	public double getIncomeRental() {
		return incomeRental;
	}

	public void setIncomeRental(double incomeRental) {
		this.incomeRental = incomeRental;
	}

	public double getIncomeDigital() {
		return incomeDigital;
	}

	public void setIncomeDigital(double incomeDigital) {
		this.incomeDigital = incomeDigital;
	}

	public double getIncomeOther() {
		return incomeOther;
	}

	public void setIncomeOther(double incomeOther) {
		this.incomeOther = incomeOther;
	}

	public double getAllowences() {
		return allowences;
	}

	public void setAllowences(double allowences) {
		this.allowences = allowences;
	}

	public double getInterstHomeLoan() {
		return interstHomeLoan;
	}

	public void setInterstHomeLoan(double interstHomeLoan) {
		this.interstHomeLoan = interstHomeLoan;
	}

	public double getInterestLoan() {
		return interestLoan;
	}

	public void setInterestLoan(double interestLoan) {
		this.interestLoan = interestLoan;
	}

	public double getDeduction80C() {
		return deduction80C;
	}

	public void setDeduction80C(double deduction80c) {
		deduction80C = deduction80c;
	}

	public double getDeduction80D() {
		return deduction80D;
	}

	public void setDeduction80D(double deduction80d) {
		deduction80D = deduction80d;
	}

	public double getDeduction80E() {
		return deduction80E;
	}

	public void setDeduction80E(double deduction80e) {
		deduction80E = deduction80e;
	}

	public double getDeduction80CCD() {
		return deduction80CCD;
	}

	public void setDeduction80CCD(double deduction80ccd) {
		deduction80CCD = deduction80ccd;
	}

	public double getDeduction80TTA() {
		return deduction80TTA;
	}

	public void setDeduction80TTA(double deduction80tta) {
		deduction80TTA = deduction80tta;
	}

	public double getDeduction80G() {
		return deduction80G;
	}

	public void setDeduction80G(double deduction80g) {
		deduction80G = deduction80g;
	}

	public double getDeduction80EEA() {
		return deduction80EEA;
	}

	public void setDeduction80EEA(double deduction80eea) {
		deduction80EEA = deduction80eea;
	}

	public double getNetTax() {
		return netTax;
	}

	public void setNetTax(double netTax) {
		this.netTax = netTax;
	}

	@Override
	public String toString() {
		return "TaxCalculator [Id=" + Id + ", email=" + email + ", financialYear=" + financialYear + ", age=" + age
				+ ", incomeSalary=" + incomeSalary + ", incomeInterest=" + incomeInterest + ", incomeRental="
				+ incomeRental + ", incomeDigital=" + incomeDigital + ", incomeOther=" + incomeOther + ", allowences="
				+ allowences + ", interstHomeLoan=" + interstHomeLoan + ", interestLoan=" + interestLoan
				+ ", deduction80C=" + deduction80C + ", deduction80D=" + deduction80D + ", deduction80E=" + deduction80E
				+ ", deduction80CCD=" + deduction80CCD + ", deduction80TTA=" + deduction80TTA + ", deduction80G="
				+ deduction80G + ", deduction80EEA=" + deduction80EEA + ", netTax=" + netTax + "]";
	}
	
}
	