package com.company;

import java.util.Scanner;

public class ComputeWage {

    Compute inte;

    ComputeWage(Compute inte){

       this.inte = inte;
    }

    private int hours;
    private String name;
    private double gtotal;


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }


    public void Acceptdata(){

        boolean inputValid=false;

        Scanner key = new Scanner(System.in);

        System.out.println("Enter the name ");

        this.name = key.nextLine();

        while(!inputValid){
            System.out.println("Enter the hours ");
            String input = key.next();

            try {
                hours = Integer.parseInt(input);
                inputValid=true;

            } catch (NumberFormatException e){
                System.out.println("You didn't enter a valid number.");
            }

        }


    }


    public double Computewage(){
        if(this.hours > 40){
            this.gtotal = (40 * 15) + (16.5 * (this.hours-40));
        } else {
            this.gtotal = this.hours * 15;
        }

        this.gtotal = inte.calculate(this.gtotal);

        return  this.gtotal;
    }

    public void display(){
        System.out.println("The total wage of " + this.name + " is " + this.gtotal);

    }


}
