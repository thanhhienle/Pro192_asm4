/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.entity;

//enumerate position of a staff
public enum EPosition {
    HEAD,VICE_HEAD,STAFF;
	
	//xac dinh Chuc vu theo du lieu nhap la 1, 2 hoac 3
	public static EPosition setPos(int a) {
		// TODO Auto-generated method stub
		EPosition b = null;
		switch (a) {
		case 1:
			b = EPosition.HEAD;
			break;
		case 2:
			b = EPosition.VICE_HEAD;
			break;
		case 3:
			b =  EPosition.STAFF;
			break;
		}
		return b;
	}
	
	public static EPosition setPos(String a) {
		EPosition b = null;
		switch (a) {
		case "HEAD":
			b = EPosition.HEAD;
			break;
		case "VICE_HEAD":
			b = EPosition.VICE_HEAD;
			break;
		case "STAFF":
			b =  EPosition.STAFF;
			break;
		}
		return b;
	}
}
