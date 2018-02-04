
public class Triangle {

	private double coteAB;
	private double coteAC;
	private double coteBC;

	/**
	 * Le constuctor de la classe Triangle sans parametre
	 */
	public Triangle(){
		
	}

	/**
	 * Le constructor de la classe Triangle quand il y a 3 parametre. Le constructor va appeler le methode setCotes
	 * @param coteAB
	 * @param coteAC
	 * @param coteBC
	 */
	
	public Triangle(double coteAB, double coteAC, double coteBC){
		setCotes(coteAB, coteAC, coteBC);
	}	
	
	/**
	 * le constructor va recevoir 3 parametres e il va verifier si les cotes sont un triangle
	 * @param coteAB
	 * @param coteAC
	 * @param coteBC
	 */
	public void setCotes (double coteAB, double coteAC, double coteBC) {
		if (coteAB < coteBC + coteAC && coteBC < coteAB + coteAC && coteAC < coteBC + coteAB 

		    && coteAB !=0 && coteBC != 0 && coteAC != 0 ) {
 			this.coteAB = coteAB;
			this.coteAC = coteAC;
			this.coteBC = coteBC;
		} else {
			this.coteAB = 1;
			this.coteAC = 1;
			this.coteBC = 1;
		}	
	}

	/**
	 * le methode va retouner le angle A du triangle
	 * @return
	 */
	public  double getAngleA() {
		return Math.toDegrees(Math.acos((((coteAB*coteAB) + (coteAC * coteAC) - (coteBC * coteBC)) / (2 * coteAB * coteAC)))) ;
	}

	/**
	 * le methode va retouner le angle B du triangle
	 * @return
	 */
	public double getAngleB() {
		return Math.toDegrees(Math.acos((((coteAB*coteAB) + (coteBC * coteBC) - (coteAC * coteAC)) / (2 * coteAB * coteBC)))) ;
	}

	/**
	 * le methode va retouner le angle C du triangle
	 * @return
	 */
	public double getAngleC() {
		return Math.toDegrees(Math.acos(((coteBC*coteBC) + (coteAC * coteAC) - (coteAB * coteAB)) / (2 * coteBC * coteAC))) ;
	}

	/**
	 * le methode va retouner laire  du triangle
	 * @return
	 */
	public double getAire() {
		double p =  getPerimetre()/2;
		double s = Math.sqrt(p*(p-coteAB)*(p-coteAC)*(p-coteBC));
		return s;
	}

	/**
	 * le methode va retouner le cote AB  du triangle
	 * @return
	 */
	public double getCoteAB() {
		return coteAB;
	}

	/**
	 * le methode va retouner le cote BC  du triangle
	 * @return
	 */
	public double getCoteBC() {
		return coteBC;
	}

	/**
	 * le methode va retouner le cote AC  du triangle
	 * @return
	 */
	public double getCoteAC() {
		return coteAC;
 	}

	/**
	 * le methode va retouner le perimetre du triangle
	 * @return
	 */
	public double getPerimetre() {
		return coteAB + coteAC + coteBC;
	}
	
	/**
	 * le methode va retouner si les cotes de les traingles sont les memes
	 * @return
	 */

	public boolean estEgal(Triangle triangle) {
		if (getPerimetre() == triangle.getPerimetre()) {
			if(estEgalCote(triangle.coteAB, this) && estEgalCote(triangle.coteBC, this)
					       && estEgalCote(triangle.coteAC, this)){
				if(estEgalCote(this.coteAB, triangle) && estEgalCote(this.coteBC, triangle)
					       && estEgalCote(this.coteAC, triangle)){
					return true;
				}
			}
		}
		return false;
 	}
	
	/**
	 * le methode va retouner si le cote du triangle est egal a un des cotes du triangle 
	 * @return
	 */
	private boolean estEgalCote(double coteTriangle, Triangle triangle) {
		if(coteTriangle == triangle.coteAB || coteTriangle == triangle.coteBC || coteTriangle == triangle.coteAC) {
			return true;
		}
		return false;
 	}
	
	/**
	 * le methode va retouner si les angles de les triangles sont les memes
	 * @return
	 */
	public boolean estSemblables(Triangle triangle) {
		double triangleA [] = new double [3];
		triangleA[0] = triangle.getAngleA();
		triangleA[1] = triangle.getAngleB();
		triangleA[2] = triangle.getAngleC();
		
		double triangleB [] = new double [3];
		triangleB[0] = getAngleA();
		triangleB[1] = getAngleB();
		triangleB[2] = getAngleC();
		
		if (description() == triangle.description()) {
			if(estEgalAngle(triangleA, triangleB) && estEgalAngle(triangleB, triangleA) ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * le methode va retouner si le angle du triangle est egal a un des angles du triangle 
	 * @return
	 */
	
	private boolean estEgalAngle(double [] triangleA, double [] triangleB) {
		int valeur = 0;
		for (int i = 0; i < triangleA.length; i++) {
			for (int j = 0; j < triangleA.length; j++) {
				if (triangleA[i] == triangleB[j]) {
					valeur++;
					break;
				}
			}
		}
		if (valeur == 3) {
			return true;
		}
		return false;
 	}
	
	/**
	 * le methode va retouner le type du triangle
	 * @return
	 */
	public String description() {
		String type;
		double angleA = getAngleA();
		double angleB = getAngleB();
		double angleC = getAngleC();
		
		if(angleA == angleB && angleB == angleC && angleA == angleC) {
			type = "Equilatéral";
		}else if (angleA == angleB || angleB == angleC || angleA == angleC) {
			if (angleA == 90 || angleB == 90 || angleC == 90) {
				type = "Isosceles retangle";
			}else {
				type = "Isosceles";
			}
		}else if (angleA == 90 || angleB == 90 || angleC == 90) {
			type = " Scalene retangle";
		}else {
			type = " Scalene";
		}
		return type;
	}
	
	
//Bonus
	




}