/*
Chao Lin
linc0@sewanee.edu
Project #1
CS 257
Professor Carl
To compile in terminal: 1.go to directory 2.type: javac testClass.java
To run: java testClass
*/

public class testClass{

	public static void main(String[] args){
	
	Polynomial p1,p2,p3,p4,p5,p6;
	double result1;
	double result2;
	double result3; 	

	p1 = new Polynomial(6);
	p1.assign_coef(6,5);
	p1.assign_coef(-3,4);
	p1.assign_coef(1,3);
	p1.assign_coef(7,2);
	p1.assign_coef(3,1);
	p1.assign_coef(17,0);
	result1 = p1.eval(2);
	result2 = p1.eval(-2);
	result3 = p1.eval(0);
	System.out.println("p1 for x=2: " + p1.toString() +"=" + result1);
	System.out.println("p1 for x=-2: " + p1.toString() +"=" + result2);
	System.out.println("p1 for x=0: " + p1.toString() +"=" + result3);
	/*
	p1 eval at 2 shoud equal to 203
	p1 eval at -2 should equal to -209.
	p1 eval at 0 should equal to 17	
	*/
	System.out.println("");

	p2 = new Polynomial(4);
	p2.assign_coef(-12,3);
	p2.assign_coef(4,2);
	p2.assign_coef(9,1);
	p2.assign_coef(10,0);
	result1 = p2.eval(2);
	result2 = p2.eval(-2);
	result3 = p2.eval(0);
	System.out.println("p2 for x=2: " + p2.toString() +"=" + result1);
	System.out.println("p2 for x=-2: " + p2.toString() +"=" + result2);
	System.out.println("p2 for x=0: " + p2.toString() +"=" + result3);
	/*
	p2 eval at 2 should equal to -52.
	p2 eval at -2 should equal to 104.
	p2 eval at 0 should equal to 10.
	*/
	System.out.println("");

	p3 = new Polynomial(3);		
	p3.assign_coef(3,2);
	p3.assign_coef(-22,1);
	p3.assign_coef(88,0);
	result1 = p3.eval(2);
	result2 = p3.eval(-2);
	result3 = p3.eval(0);
	System.out.println("p3 for x=2: " + p3.toString() +"=" + result1);
	System.out.println("p3 for x=-2: " + p3.toString() +"=" + result2);
	System.out.println("p3 for x=0: " + p3.toString() +"=" + result3);
	/*
	p3 eval at 2 should equal to 56.
	p3 eval at -2 should equal to 144.
	p3 eval at 0 should equal to 88.
	*/
	System.out.println("");
	
	//TESTING ADDITION METHOD
	p4 = Polynomial.addition(p1,p2);
	System.out.println("p1+p2= " + p4.toString());
	/*
	p1+p2 should be 6x^5-3x^4-11x^3+11x^2+12x+27
	*/
	System.out.println("");
	
	//TESTING SUBTRACTION METHOD
	p5 = Polynomial.subtraction(p1,p2);
	System.out.println("p1-p2= " + p5.toString());
	/*
	p1-p2 should be 6x^5-3x^4+13x^3+3x^2-6x+7
	*/
	System.out.println("");
	
	//TESTING MULTIPLICATION METHOD
	p6 = Polynomial.multiplication(p1,p2);
	System.out.println("p1*p2= " + p6.toString());
	/*
	p1*p2 should be -72x^8+60x^7+30x^6-47x^5-29x^4-119x^3+165x^2+183x+170
	*/
	
	}

}
