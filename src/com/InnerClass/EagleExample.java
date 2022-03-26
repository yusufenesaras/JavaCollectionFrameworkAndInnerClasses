package com.InnerClass;

public class EagleExample {

    public static void main(String[] args){
        Eagle eagle = new Eagle();
        eagle.fly();
        eagle.landed();
    }

}

class Animal
{
    static abstract class Bird
    {
        public abstract void fly();
        public abstract void landed();
    }
    public void hunt()
    {
        System.out.println("Animal hanting...");
    }
}

class Eagle extends Animal.Bird {


    public Eagle() {}

    @Override
    public void fly() {
        System.out.println("Eagle flying");
    }

    @Override
    public void landed() {
        System.out.println("Eagle landing");
    }
}
