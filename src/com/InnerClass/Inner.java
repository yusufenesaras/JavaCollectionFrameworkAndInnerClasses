package com.InnerClass;

/**
 *
 * @author Yusuf Enes Aras
 *
 **/
public class Inner {
    public static void main(String[] args) {

        //Java da inner classlar neden kullanılır?
        //Javada multiple inheritance yoktur. Bu interfaceler ya da inner classlar ile halledilir
        //Inner classlar ile bir sınıf başka bir sınfın içinde tanımlanabilir
        //Böylece mantıksal bir bütünü oluşturan bir çok sınıf tek bir çatı altında oluşturulur.

        //static olan iç içe geçmiş sınıflar
        //static olmayan iç içe geçmiş
        //*Dahili üye sınıflar
        //*Yerel Sınıflar (Local classes)
        //Isimsiz sınıflar(Anonymous classes)


        Electronic electronic = new Electronic("Hp Pavilion",9870.45);
        Computer computer = new Computer("M2 SSD nvme",16,"Ryzen5");

        Computer.Disk disk = new Computer().new Disk();
        disk.SsdDisk(computer);
        Computer.Ram ram = new Computer().new Ram();
        ram.speed(computer);
        Computer.Processor processor = new Computer().new Processor();
        processor.processorType(computer);

    }

}

class Electronic{ //Base

    String name;
    double price;

    public Electronic(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Electronic(){}

}

class Computer extends Electronic{

    String diskType;
    int ramSpeed;
    String processorType;


    public Computer(String diskType, int ramSpeed, String processorType) {
        this.diskType = diskType;
        this.ramSpeed = ramSpeed;
        this.processorType = processorType;
    }

    public Computer(){} //parametresiz ctor

    public Computer(String diskType, int ramSpeed) {
        this.diskType = diskType;
        this.ramSpeed = ramSpeed;
    }

    public class Disk extends Computer{//Dahili sınıf 1

        protected void SsdDisk(Computer c) {
            System.out.println("Ssd disk(Pc kullanıcıları erişebilir.): " + c.diskType);
        }

        private void Cdisk(Computer c) {//disk sınıfı metodu burada erişilebilir.
            System.out.println("C disk(Pc kullanıcısı erişebilir.): " + c.diskType);
        }
    }
    public class Ram extends Computer{//Dahili sınıf 2
        protected void speed(Computer c) {
            System.out.println(c.ramSpeed+" Gb Ram");
        }
    }
    public class Processor extends Computer{
       protected void processorType(Computer c){
           System.out.println("Islemci: " + c.processorType);
       }
    }
}





