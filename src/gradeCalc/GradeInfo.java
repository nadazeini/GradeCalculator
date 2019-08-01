package gradeCalc;

public class GradeInfo {
	private Double earned;
	private Double totalPossible;
	private Double percentage;
	public GradeInfo(Double gradeInput, Double totalInput, Double percentageInput) {
		
		this.earned=gradeInput;
		this.totalPossible= totalInput;
		this.percentage = percentageInput;
		
		
	}
	public Double getEarned() {
		return earned;
		
	}
	public Double getTotalPossible() {
		return totalPossible;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setEarned() {
		this.earned=earned;
	}
	public void setTotalPossible() {
		this.totalPossible=totalPossible;
	}
	public void setPercentage() {
		this.percentage=percentage;
	}
	public String toString() {
		return "Earned" + getEarned() +" over "+  getTotalPossible() + "Percentage: "+getPercentage();
	}
}
