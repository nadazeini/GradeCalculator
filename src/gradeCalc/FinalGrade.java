package gradeCalc;

import java.text.DecimalFormat;
import java.util.*;

public class FinalGrade {
     private GradeInfo gradeInfo;
     private static ArrayList<GradeInfo> allGrades;
	public FinalGrade(GradeInfo gradeInfo) {
	this.gradeInfo=gradeInfo;
	
	
	}
	public FinalGrade(ArrayList allGrades) {
		this.allGrades=allGrades;
		
	}
	public ArrayList getAllGrade() {
		return allGrades;
		
	}
	public void setAllGrades(ArrayList allGrades) {
		this.allGrades=allGrades;
	}
	
	/*public Double calcGrade(GradeInfo gradeInfo) {
		
		//make arraylist of all added grades
		
		
		Double applyCoef = (gradeInfo.getPercentage()*overHundred)/100;
		
		double scale = Math.pow(10, 2);
	    return Math.round(applyCoef * scale) / scale;

		
		
		
		
	}*/
	public Double calcFinalGrade() {
		ArrayList<Double> numerator = new ArrayList<>();
		ArrayList<Double> denominator = new ArrayList<>();
		double sum = 0;
		double coef =0;
		double overHundred ;
		for(int i =0;i<allGrades.size();i++) {
			
			overHundred= (allGrades.get(i).getEarned()*100)/(allGrades.get(i).getTotalPossible());
			
			sum+=(overHundred*allGrades.get(i).getPercentage());
		
			coef+=allGrades.get(i).getPercentage();
			
			
			
		}
		double scale = Math.pow(10, 2);
	    return Math.round((sum/coef) * scale) / scale;
	
		//for(int i =0;i<toCalcFinal.size();i++) {
			
			//		 sum+=toCalcFinal.get(i);
		//		
		//}
		//return (double) (sum/toCalcFinal.size());
		
	}
	public String toString() {
		
		return Double.toString(calcFinalGrade());
	}

}
