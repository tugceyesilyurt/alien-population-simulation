/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author u
 */
public class project3Alien {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of compAlien population: ");
        int size = sc.nextInt();
        System.out.println("Simulating compAlien species...");
        System.out.println("____________________________________");
        String[] population = new String[size];
        for(int i = 0; i < size; i++) {
            population[i] = createAlien();
            System.out.println("ID:" + (i+1) + ", " + findGender(population[i]) + ", Health: " + calculateHealth(population[i]));
        }
        System.out.println("____________________________________");
        System.out.println("compAlien population is generated!");
        System.out.println("Choose an option:");
        System.out.println("(1) Mate two compAliens");
        System.out.println("(2) Randomly mate a set of compAliens");
        System.out.println("(3) Show statistics");
        System.out.println("(4) Number of limbs");
        System.out.println("(5) Power of sensing");
        int option = sc.nextInt();
        switch (option){
            case 1:
                System.out.println("Mating Two compAliens");
                System.out.println("____________________________________");
                System.out.println("Enter ID of first compAlien: ");
                int id1 = sc.nextInt();
                System.out.println("Enter ID of second compAlien: ");
                int id2 = sc.nextInt();
                int chance = (int)Math.round(reproductionResult(population[id1-1], population[id2-1]) * 100);
                if (chance >= 50) {
                    System.out.println("compAlien " + id1 + "(" + findGender(population[id1-1]).charAt(0) + ") and "
                            + id2 + "(" + findGender(population[id2-1]).charAt(0) + ") Mate: Offspring chance " + chance + "%. They have 1 offspring :)");
                }
                else if(chance > 0) {
                    System.out.println("compAlien " + id1 + "(" + findGender(population[id1-1]).charAt(0) + ") and "
                            + id2 + "(" + findGender(population[id2-1]).charAt(0) + ") Mate: Offspring chance " + chance + "%. No offspring.");
                }
                else {
                    System.out.println("compAlien " + id1 + "(" + findGender(population[id1-1]).charAt(0) + ") and "
                            + id2 + "(" + findGender(population[id2-1]).charAt(0) + ") Mate: no mate");
                }
                break;
            case 2:
                System.out.println("Simulating Random compAlien Reproduction");
                System.out.println("____________________________________");
                System.out.println("Enter the number of compAlien pairs to reproduce: ");
                int pairs = sc.nextInt();
                Random rd = new Random();
                int index1, index2;
                for(int i = 0; i < pairs; i++) {
                    index1 = rd.nextInt(population.length);
                    index2 = rd.nextInt(population.length);
                    int chance2 = (int)Math.round(reproductionResult(population[index1], population[index2]) * 100);
                    if (chance2 >= 50) {
                        System.out.println("Alien" + (index1 + 1) + "(" + findGender(population[index1]).charAt(0) + ") and "
                                + (index2+1) + "(" + findGender(population[index2]).charAt(0) + ") mate: Offspring chance " + chance2 + "%. Result: 1 Offspring");
                    }
                    else if(chance2 > 0) {
                        System.out.println("Alien" + (index1 + 1) + "(" + findGender(population[index1]).charAt(0) + ") and "
                                + (index2+1) + "(" + findGender(population[index2]).charAt(0) + ") mate: Offspring chance " + chance2 + "%. Result: No Offspring");
                    }
                    else {
                        System.out.println("Alien" + (index1 + 1) + "(" + findGender(population[index1]).charAt(0) + ") and "
                                + (index2+1) + "(" + findGender(population[index2]).charAt(0) + ") mate: no mate.");
                    }
                }
                break;
            case 3:
                System.out.println("compAlien Population Statistics");
                System.out.println("____________________________________");
                int females = 0, males = 0;
                for (int i = 0; i < population.length; i++) {
                    if(findGender(population[i]).equals("Female"))
                        females++;
                    else males++;
                }
                int femaleResult = Math.round(((float)females/population.length)*100);
                int maleResult = Math.round(((float)males/population.length)*100);
                System.out.println("FEMALE population = " + femaleResult + "%");
                System.out.println("MALE population = " + maleResult + "%");
                System.out.println("Enter a health threshold between 0 and 42: ");
                int health = sc.nextInt();
                int count = 0;
                for (int i = 0; i < population.length; i++) {
                    if(calculateHealth(population[i]) >= health)
                        count++;
                }
               
                int result = Math.round((float)count/population.length)*100;
                System.out.println(result + "% of compAlien population have a health of " + health + " or higher");
                break;
                
            case 4:
                System.out.println("....Calculating the number of limbs.....");
                
                for (int i = 0; i < population.length; i++) {
                    if(findGender(population[i]).equals("Male")&&( calculateHealth(population[i]) >= 50)){
                    System.out.println("These alien has 4 arm,2 leg and 1 tail");
                    }
                    else if(findGender(population[i]).equals("Male")&&( calculateHealth(population[i]) >= 90)){
                      System.out.println("These alien has 6 arm, 4 leg and 2 tail"); 
                    }
                      else if(findGender(population[i]).equals("Male")){
                           System.out.println("These alien has 3 arm, 3 leg and 2 tail");    
                              }
                    
                    else{
                       System.out.println("The "+i +".alien have 2 arm and 2 leg");  
                        }
                    
                }
                break;
                
            case 5:
                System.out.println("....Calculating the power of sensing.......");
                for (int i = 0; i < population.length; i++) {
                    if(findGender(population[i]).equals("Female")){
                    System.out.println("The " +(i+1) +" .alien has very high power of sensing and can hear sounds far away");
                    }
                    else {
                      System.out.println("The "+(i+1) +". alien's sense of power is at a normal level"); 
                    }
                }
                 break;
                 
            default:
              System.out.println("There is no such option, please write one of the available"); 
               
        
    }
    }  
    private static String createAlien() {
        String compAlien = "";
        String[] letters = {"C", "S", "E"};
        int number = 0;
        Random random = new Random();
        for (int i = 0; i < 128; i++) {
            number = random.nextInt(3);
            compAlien = compAlien.concat(letters[number]);
        }
        return compAlien;
    }
    private static int calculateHealth(String compAlien) {
        int health = 0; 
        for (int i = 0; i < compAlien.length()-2; i++) {
            if(compAlien.substring(i, i+3).equals("CSE")) {
                health++;
            }
        }
        return health;
    }
    private static String findGender(String compAlien) {
        if(compAlien.charAt(compAlien.length()-1) == 'S') {
            return "Male";
        }
        else return "Female";
    }
    private static double reproductionResult(String alien1, String alien2) {
        double result = 0;
        if(findGender(alien1).equals(findGender(alien2))) {
            return 0;
        }
        else {
            int division = Math.floorDiv(alien1.length(),3)+(Math.floorDiv(alien2.length(),3))-1;
            result = (calculateHealth(alien1) + calculateHealth(alien2)) / (float)division ;
        }
        return result;
    }
}



