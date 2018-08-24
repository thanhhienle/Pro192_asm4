/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.entity;

//enumerate degree level of a teacher
public enum EDegree {    
    BACHELOR, MASTER, DOCTOR;
	
	//xac dinh Trinh do theo du lieu nhap la 1, 2 hoac 3
	public static EDegree setDeg(int a) {
		EDegree b = null;
		switch (a) {
		case 1:
			b = EDegree.BACHELOR;
			break;
		case 2:
			b = EDegree.MASTER;
			break;
		case 3:
			b = EDegree.DOCTOR;
			break;
		}
		return b;
	}
	
	public static EDegree setDeg(String a) {
		EDegree b = null;
		switch (a) {
		case "BACHELOR":
			b = EDegree.BACHELOR;
			break;
		case "MASTER":
			b = EDegree.MASTER;
			break;
		case "DOCTOR":
			b = EDegree.DOCTOR;
			break;
		}
		return b;
	}
}
