package org.example;
public class Calculator{
    public int add(int a,int b){
        return a+b;
    }
    public boolean isPositive(int number){
        return number>0;
    }
    public String getGreeting(String name){
        if(name==null){
            return null;
        }
        return "Hello, "+ name;
    }


}