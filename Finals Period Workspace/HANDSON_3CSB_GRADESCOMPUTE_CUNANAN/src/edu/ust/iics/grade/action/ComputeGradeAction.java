package edu.ust.iics.grade.action;

public class ComputeGradeAction {
	private double midterm;
	private double prefinal;
	private double finalGrade;
	private double deg;
	private String remarks;
	private String message;

	public double getMidterm() {
		return midterm;
	}

	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}

	public double getPrefinal() {
		return prefinal;
	}

	public void setPrefinal(double prefinal) {
		this.prefinal = prefinal;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() {
		if (midterm < 0 || prefinal < 0 || midterm > 100 || prefinal > 100) {
			return "error";
		} else {
			setMidterm(midterm);
			setPrefinal(prefinal);
			finalGrade = (midterm * 0.5) + (prefinal * 0.5);
			setFinalGrade(finalGrade);

			System.out.println("Midterm raw score: " + getMidterm());
			System.out.println("Pre-final raw score: " + getPrefinal());

			if (finalGrade <= 59) {
				setDeg(5.00);
				setRemarks("Failed");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
						+ ". Sorry, you have failed the subject. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 60) || (finalGrade <= 64.99)) {
				setDeg(3.00);
				setRemarks("Passed");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 65) || (finalGrade <= 69.99)) {
				setDeg(2.75);
				setRemarks("Fair");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 70) || (finalGrade <= 72.99)) {
				setDeg(2.50);
				setRemarks("Fair");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 73) || (finalGrade <= 77.99)) {
				setDeg(2.25);
				setRemarks("Good");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 78) || (finalGrade <= 81.99)) {
				setDeg(2.00);
				setRemarks("Good");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 82) || (finalGrade <= 86.99)) {
				setDeg(1.75);
				setRemarks("Good");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 87) || (finalGrade <= 90.99)) {
				setDeg(1.50);
				setRemarks("Very Good");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 91) || (finalGrade <= 93.99)) {
				setDeg(1.25);
				setRemarks("Very Good");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			} else if ((finalGrade == 60) || (finalGrade <= 100)) {
				setDeg(1.00);
				setRemarks("Excellent");
				setMessage("Your term grade is " + getFinalGrade() + ". Equivalent grade is " + getDeg()
				+ ". Congratulations you passed. Remarks is " + getRemarks() + ".");
			}

			return "success";
		}
	}


}
