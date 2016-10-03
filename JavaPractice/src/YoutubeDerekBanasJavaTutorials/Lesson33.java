package YoutubeDerekBanasJavaTutorials;

import java.io.*;

public class Lesson33 {
    public static void main(String[] args){
        Customer[] customers = getCustomers();
        DataOutputStream customerOutput = createFile("C:\\Coding\\Working\\JavaPractice\\lib\\customers.txt");

        for(Customer person : customers){
            createCustomers(person, customerOutput);
        }

        try{
            customerOutput.close();
        }catch(IOException e){
            System.out.println("An I/O error occurred");
            System.exit(0);
        }

        getFileInformation();
    }

    private static void getFileInformation(){
        System.out.println("Information written to file");

        File listOfNames = new File("C:\\Coding\\Working\\JavaPractice\\lib\\customers.txt");
        boolean eof = false;

        try{
            DataInputStream getInformation = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(listOfNames)));

            while(!eof){
                String customerName = getInformation.readUTF();
                int customerAge = getInformation.readInt();
                double customerDebt = getInformation.readDouble();
                boolean oweMoney = getInformation.readBoolean();
                char customerSex = getInformation.readChar();
                //ORDER IS SUPER IMPORTANT

                System.out.println(customerName);
                System.out.println(customerAge);
                System.out.println(customerDebt);
                System.out.println(oweMoney);
                System.out.println(customerSex);
            }
        }catch(EOFException e){
            eof = true;
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }catch(IOException e){
            System.out.println("An I/O exception occurred");
            System.exit(0);
        }
    }

    private static void createCustomers(Customer customer, DataOutputStream customerOutputStream){
        try{
            customerOutputStream.writeUTF(customer.customerName);
            customerOutputStream.writeInt(customer.customerAge);
            customerOutputStream.writeDouble(customer.customerDebt);
            customerOutputStream.writeBoolean(customer.oweMoney);
            customerOutputStream.writeChar(customer.customerSex);
            //also possible, writeByte, writeFloat, writeLong, writeShort
            //ORDER IS SUPER IMPORTANT!!!!

        }catch(IOException e){
            System.out.println("An I/O exception occured");
            System.exit(0);
        }
    }

    private static DataOutputStream createFile(String fileName){
        try{
            File listOfNames = new File(fileName);
            DataOutputStream informationToWrite = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(listOfNames)));

            //FileOutputStream(listOfNames, true) >> appends new data to file
            //FileOutputStream(listOfNames, false) >> creates file again, deleting the old file if it existed

            return informationToWrite;

        }catch(IOException e){
            System.out.println("I/O Error");
            System.exit(0);
        }
        return null;
    }

    private static Customer[] getCustomers(){
        Customer[] customers = new Customer[5];

        customers[0] = new Customer("John Smith", 21, 12.25, true, 'M');
        customers[1] = new Customer("Paul Main", 30, 25.75, false, 'M');
        customers[2] = new Customer("Sue Wee", 24, 2500251, true, 'F');
        customers[3] = new Customer("Sally Rains", 65, 65555, true, 'F');
        customers[4] = new Customer("Bobs Afag", 16, 12.25, false, 'M');

        return customers;
    }

    private static class Customer{
        public String customerName;
        public int customerAge;
        public double customerDebt;
        public boolean oweMoney;
        public char customerSex;

        public Customer(String name, int age, double debt, boolean oweMoney, char sex){
            this.customerName = name;
            this.customerAge = age;
            this.customerDebt = debt;
            this.oweMoney = oweMoney;
            this.customerSex = sex;
        }
    }
}
