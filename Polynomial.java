/*
Chao Lin
linc0@sewanee.edu
Project #1
CS 257
Professor Carl
To compile in terminal: 1.go to directory 2.type: javac Polynomial.java
*/

public class Polynomial implements Cloneable{

	//Invariant of the Polynomial Class
	//	 1. the array coef contains all of the coefficients inputed 
	//		and each index corresponds to the power of each coefficient
	protected double[] coef; 
	protected int polyDegree;

	/**
	*Polynomial: determines the size of the polynomial
	*@param terms
	*	the size of the array coef
	*@precondition
	*	term > 0
	*@postcondition
	*	array coef has the size of term.
	**/
	public Polynomial(int terms) {
		coef = new double[terms];
		polyDegree = terms-1;
	}

	/**
	*assign_coef: assign a value to a specific index
	*@param new_coefficient, k
	*	new_coefficient is the value assigned and k is the index of array where the value is in.
	*@precondition 
	*	k >= 0 and largest k is one less than array length
	*@postcondition
	*	the array coef has a value in some or all of its' indices. 
	*@throw: ArrayIndexOutOfBoundsException
	*	indicates the k value is too large
	**/ 
	public void assign_coef(double new_coefficient, int k){
		coef[k]=new_coefficient;
		if(k>=coef.length) throw new ArrayIndexOutOfBoundsException ("index " + k + " is too large");
	}

	/**
	*eval: evaluate the polynomial
	*@param x
	*	x value for the polynomial
	*@return
	* 	result of the polynomial for a given x
	**/
	public double eval(double x){
		double result=0;
		for(int i=0; i<coef.length; i++){
			result += coef[i]*((int)Math.pow(x,i));
		}
		return result; 
	}

	/**
	*addition: add two polynomials 
	*@param p1,p2
	*	two polynomials that will be added
	*@return
	*	a new polynomial with new set of coefficients added from p1 and p2.
	**/
	public static Polynomial addition(Polynomial p1, Polynomial p2){
		int iteration;
		Polynomial p3;
		if(p1.degree() >= p2.degree()){
			iteration=p2.degree();
			p3 = new Polynomial(p1.degree()+1); 
			for(int n=0; n<=iteration; n++){
				if(n<=p1.degree()){
					for(int j=iteration; j<=p1.degree(); j++){
						p3.assign_coef(p1.coef[j], j);
					}
				}
			p3.assign_coef((p1.coef[n]+p2.coef[n]),n);
			}
		}else{
			iteration=p1.degree();
			p3 = new Polynomial(p2.degree()+1); 
			for(int n=0; n<=iteration; n++){
				if(n<=p2.degree()){
					for(int j=iteration; j<=p2.degree(); j++){
						p3.assign_coef(p2.coef[j], j);
					}
				}
			p3.assign_coef((p1.coef[n]+p2.coef[n]),n);
			}
		}
		
		return p3;
	}

	/**
	*subtraction: subtract two polynomials
	*@param p1,p2
	*	two polynomials that will be subtracted
	*@return
	*	a new polynomial with new set of coefficients subtracted from p1 and p2
	**/
	public static Polynomial subtraction(Polynomial p1, Polynomial p2){
		int iteration;
		Polynomial p3;
		if(p1.degree() >= p2.degree()){
			iteration = p2.degree();
			p3 = new Polynomial(p1.degree()+1);
			for(int n=0; n<=iteration; n++){
				if(n<=p1.degree()){
					for(int j=iteration; j<=p1.degree(); j++){
						p3.assign_coef(p1.coef[j], j);
					}
				}
			p3.assign_coef((p1.coef[n]-p2.coef[n]),n);
			}
		}else{
			iteration = p1.degree();
			p3 = new Polynomial(p2.degree()+1);
			for(int n=0; n<=iteration; n++){
				if(n<=p2.degree()){
					for(int j=iteration; j<=p2.degree(); j++){
						p3.assign_coef(p2.coef[j], j);
					}
				}
			p3.assign_coef((p1.coef[n]-p2.coef[n]),n);
			}
		}
		return p3;
	}

	/**
	*multiplication: multiply two polynomials
	*@param p1,p2
	*	two polynomials that will be multiplied
	*@return
	*	a new polynomial with new set of coefficients multiplied from p1 and p2
	**/
	public static Polynomial multiplication(Polynomial p1, Polynomial p2){
		int totalDegree=p1.degree()+p2.degree()+1;
		Polynomial pfinal = new Polynomial(totalDegree);

		for(int i=0; i<=p1.degree();i++){
			for(int j=0; j<=p2.degree();j++){
				pfinal.coef[i+j] += p1.coef[i]*p2.coef[j];
			}
		}
		return pfinal;
	}
	

	/**
	*coefficient: finding the cofficient of a given exponent
	*@param k
	*	an interger value that speciifies the index of the coefficient
	*@return
	*	coefficient in index k of the array
	**/
	public double coefficient(int k){
		return coef[k];
	}

	/**
	*degree: obtaining the highest degree of the polynomial
	*@return 
	*	the degree of the coefficeint, -1 if all coefficients are 0.
	**/
	public int degree(){
		int count = 0;
		for(int n=0; n<coef.length; n++){
			if(coef[n]==0){
				count++;
			}
		}
		if(count==coef.length-1){
			return -1;
		}
		else{
			return polyDegree;
		}
	}

	/**
	*clear: set all coefficients to 0
	*@return
	*	all coefficients are set to 0
	**/
	public void clear(){
		for(int q=0; q<coef.length; q++){
			coef[q]=0;
		}
	}

	/**
	*clone: copies one polynomial to another
	*@return
	*	a copy of the polynomial
	*@throw: RuntimException
	*	indicates that the class does not implement Cloneable
	**/
	public Polynomial clone(){
		Polynomial poly2;
		try{
			poly2=(Polynomial)super.clone();
		}
		catch(CloneNotSupportedException e){
			throw new RuntimeException("this class doe not implement Cloneable");
		}
		return poly2;
	}

	/**
	*euqlas: compare one polynomial to another for equality
	*@param p
	*	a polynomial that is compared
	*@return
	* 	true if two polynomial are equivalent, false otherwise
	**/
	public boolean equals(Polynomial p){
		for(int t=0; t<coef.length; t++){
			if(this.coef[t]==p.coef[t]){
				return true;
			}
		}
		return false;
	}

	/**
	*toString: generate string representation of the polynomial
	*@return
	*	string representation of the polynomial
	**/
	public String toString(){
		String body = "x^";
		String polyRep = "";
		for(int a=polyDegree; a>0; a--){
			if(coef[a]!=0){
				polyRep += (coef[a] + body + a + "+" );
				if(a==1){
					polyRep += coef[0];
				}
			}
		}
		return polyRep;
	}
		
}
