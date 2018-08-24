/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.entity;

import pro192xa3.business.AllowanceCalulator;

/**
 *
 * @author hp
 */
public class Teacher extends Employee {

    private String faculty;//khoa
    private EDegree degree;//trinh do
    private int teachingHours;//so tiet day

    public Teacher() {
        float allowance = AllowanceCalulator.calculateAllowance((this));
        this.setAllowance(allowance);
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public EDegree getDegree() {
        return degree;
    }

    public void setDegree(EDegree degree) {
        this.degree = degree;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }
    //sal=he so luong*730 + phu cap + so tiet day*45.
    @Override
    public float getSalary() {
        float sal;
        sal = this.getSalaryRatio() * 730 + this.getAllowance() + this.teachingHours * 45;
        return sal;
    }
    @Override
    public String toString(){
        return  this.getFullName()+", "+
                this.getFaculty()+", "+
                this.getDegree()+", "+
                this.getSalaryRatio()+", "+
                this.getAllowance()+", "+
                this.getTeachingHours()+", "+
                this.getSalary();                
    }

}
