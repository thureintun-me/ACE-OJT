package demo;

public class Person implements PersonInterface {
	
	private String firstName;
	private String lastName;
	private int cashSaving;
	private int retirementFund;
	
	
	public Person(String firstName, String lastName, int cashSaving, int retirementFund) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cashSaving = cashSaving;
		this.retirementFund = retirementFund;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getCashSaving() {
		return cashSaving;
	}


	public void setCashSaving(int cashSaving) {
		this.cashSaving = cashSaving;
	}


	public int getRetirementFund() {
		return retirementFund;
	}


	public void setRetirementFund(int retirementFund) {
		this.retirementFund = retirementFund;
	}


	@Override
	public int computeTotalWealth() {
		System.out.println(cashSaving+retirementFund);
		return cashSaving+retirementFund;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return firstName+lastName;
	}
	
	
	
	

}
