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
public class Staff extends Employee {
    private String department;
    private float noOfWorkingDay;//so ngay cong
    private EPosition position;//chuc vu    

    public Staff() {
         float allowance = AllowanceCalulator.calculateAllowance(this);
         this.setAllowance(allowance);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getNoOfWorkingDay() {
        return noOfWorkingDay;
    }

    public void setNoOfWorkingDay(float noOfWorkingDay) {
        this.noOfWorkingDay = noOfWorkingDay;
    }

    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition position) {
        this.position = position;       
    }
    //sal=he so luong*730 + phu cap + so ngay cong*30;
    @Override
    public float getSalary() {
        float sal;     
        sal = this.getSalaryRatio()*730 +this.getAllowance()+this.noOfWorkingDay*30;
        return sal;
    }
    
    @Override
    public String toString(){
        return  this.getFullName()+", "+
                this.getDepartment()+", "+
                this.getPosition()+", "+
                this.getSalaryRatio()+", "+
                this.getAllowance()+", "+
                this.getNoOfWorkingDay()+", "+
                this.getSalary();     
              
    }
    
}
