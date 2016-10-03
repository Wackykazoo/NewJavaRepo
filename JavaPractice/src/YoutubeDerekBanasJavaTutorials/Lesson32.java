package YoutubeDerekBanasJavaTutorials;

import java.io.*;

public class Lesson32 {
    public static void main(String[] args){
        Customer[] customers = getCustomers();
        PrintWriter customerOutput = createFile("C:\\Coding\\Working\\JavaPractice\\lib\\customers.txt");

        for(Customer customer: customers){
            createCustomers(customer, customerOutput);
        }
        customerOutput.close();

        getFileInformation();
    }

    private static class Customer{
        public String firstName, lastName;
        public int customerAge;

        public Customer(String firstName, String lastName, int customerAge){
            this.firstName = firstName;
            this.lastName = lastName;
            this.customerAge = customerAge;
        }
    }

    private static Customer[] getCustomers(){
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("John", "Smith", 21);
        customers[1] = new Customer("Sally", "Smith", 22);
        customers[2] = new Customer("Paul", "Smith", 25);
        customers[3] = new Customer("Tom", "Smith", 35);
        customers[4] = new Customer("Mark", "Smith", 55);
        return customers;
    }

    private static PrintWriter createFile(String fileName){
        try{
            File listOfNames = new File(fileName);
            PrintWriter infoToWrite = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(listOfNames)));
            return infoToWrite;
        }catch(IOException e){
            System.out.println("An I/O error occurred");
            System.exit(0);
        }
        return null;
    }

    private static void createCustomers(Customer customer, PrintWriter printWriter){
        String customerInformation = customer.firstName + " " + customer.lastName + " ";
        customerInformation += Integer.toString(customer.customerAge);
        printWriter.println(customerInformation);
    }

    private static void getFileInformation(){
        System.out.println("Information written to file \n");
        File listOfNames = new File("C:\\Coding\\Working\\JavaPractice\\lib\\customers.txt");

        try{
            BufferedReader getInformation = new BufferedReader(
                    new FileReader(listOfNames));

            String customerInformation = getInformation.readLine();

            while (customerInformation != null){
                //System.out.println(customerInformation);
                String[] individualCustomerData = customerInformation.split(" "); //can be seperated by , as well, replace space with a comma
                int customerAge = Integer.parseInt(individualCustomerData[2]);
                System.out.println("Customer " + individualCustomerData[0] + " is " + customerAge);
                customerInformation = getInformation.readLine();
            }
        }catch(FileNotFoundException e){
            System.out.println("Couldn't find file");
            System.exit(0);
        }catch (IOException e){
            System.out.println("An I/O error occured");
            System.exit(0);
        }
    }
}
