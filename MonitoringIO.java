package galamseys;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;

public class MonitoringIO {
    private static Hashtable Operations;

    public static int GeneralMenu() {
        Scanner menu = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("WELCOME  TO THE GALAMSEY INFORMATION CENTER" +
                "\nPlease select an option" +
                "\n 1.Enter Observatory Data" +
                "\n 2.Enter Galamsey Data" +
                "\n 3.Monitoring Statistics" +
                "\n 4. Exit");
        int menus = menu.nextInt();
        while (true) {
            if (menus == 1 || menus == 2 || menus == 3 || menus == 4 ) {
                break;
            } else {
                System.out.println("Wrong input....................");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("(\"WELCOME  TO THE GALAMSEY INFORMATION CENTER\" +\n" +
                        "                \"\\nPlease select an option\" +\n" +
                        "                \"\\n 1.Enter Observatory Data\" +\n" +
                        "                \"\\n 2.Enter Galamsey Data\" +\n" +
                        "                \"\\n 3.Monitoring Statistics\" +\n" +
                        "                \"\\n 4. Exit");
                menus = menu.nextInt();

            }
        }
        return menus;
    }


    public static void Enquiry(){
        System.out.println(" You have chosen Observatory Data." +
                "\n Do you have an existing Galamsey Data?");
        Scanner enq= new Scanner(System.in);
        int enquire= enq.nextInt();
        if(enquire==1){

        }
    }


        public static void Observatory_Data() throws FileNotFoundException {
        Observatory new_data = new Observatory();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("You are entering new observatory data. Please answer the following");
        Scanner nam = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Observatory Name:");
        String name = nam.nextLine();
        new_data.setObsName(name);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Country name:");
        String country_name = nam.nextLine();
        new_data.setCountryName(country_name);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Area Covered:");
        double area_covered = nam.nextDouble();
        new_data.setAreaCovered(area_covered);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Year:");
        int year = nam.nextInt();
        new_data.setYear(year);
        Observatory_Files();
    }


    /**
     *
     */
    public static void Galamsey_Data(){
        Galamsey new_data = new Galamsey();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("You are entering new 'galamsey' data. Please answer the following");
        Scanner nam = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Vegetation Color:");
        String veg_color = nam.nextLine();
        new_data.setVegetation_color(veg_color);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Color Value:");
        int color_value = nam.nextInt();
        new_data.setColor_value(color_value);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Position Latitude:");
        double pos_lat = nam.nextDouble();
        new_data.setLatitude(pos_lat);
        System.out.println(" ");
        System.out.println("Position Longitiude: ");
        double pos_long= nam.nextDouble();
        new_data.setLatitude(pos_long);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");System.out.println("Year:");
        int year = nam.nextInt();
        new_data.setYear(year);
        new_data= new Galamsey(veg_color,color_value,pos_lat,pos_long);
        try {
            writingTextToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Operations.put(color_value,new_data);

    }


    public static void Statistics() {
        Scanner menu = new Scanner(System.in);
        System.out.println(" Enter a colour value from 0-3: ");
        int number= menu.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("These are the current Monitoring Statistics"+
                "\n Largest colour value:"+ Monitoring.largests()+
                "\n Average colour value: "+ Monitoring.average());
        System.out.println( "\n Galamsey Events: ");
                Monitoring.Galamsey_List((Hashtable) Operations, number);
    }

    public static void Observatory_File() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try {
            //Note that we are able to append to the file because of the "true" parameter
            printWriter = new PrintWriter(new FileOutputStream("observatory_data.txt", true));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

//prints the headings to the text file
        printWriter.print("Observatory Name" + "    " + "Country Name" + "    " + " Year"+"    " +" Area Covered");
        printWriter.println();

        printWriter.close();

    }


    public static void Observatory_Files() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try {
            //Note that we are able to append to the file because of the "true" parameter
            printWriter = new PrintWriter(new FileOutputStream("observatory_data.txt", true));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

//prints the headings to the text file
        printWriter.print(Observatory.getObsName() + "    " + Observatory.getCountryName() + "    " + Observatory.getYear()+"    " +Observatory.getAreaCovered());
        printWriter.println();

        printWriter.close();

    }
    public static void writingTextToFiles() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try {
            //Note that we are able to append to the file because of the "true" parameter
            printWriter = new PrintWriter(new FileOutputStream("galamsey_data.txt", true));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

//prints the headings to the text file
        printWriter.print("Vegetation Color" + "    " + "Color Value" + "    " + " Position Latitude"+"    " +" Position Longitude"+ "    "+" Year");
        printWriter.println();

        printWriter.close();

    }
    public static void writingTextToFile() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try {
            //Note that we are able to append to the file because of the "true" parameter
            printWriter = new PrintWriter(new FileOutputStream("galamsey_data.txt", true));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

//prints the headings to the text file
        printWriter.print(Galamsey.getVegetation_color() + "    " + Galamsey.getColor_value() + "    " + Galamsey.getPosition()+"    "+Galamsey.getYear());
        printWriter.println();

        printWriter.close();

    }

    public static void Exit(){
        System.out.println("Exiting...........................................................");
    }


    public static int Continue() {
        Scanner con = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Do you want to Continue?" +
                "\n1.Yes" + "\n2. No");
        int cons = con.nextInt();
        while (true) {
            if (cons == 1) {
                break;
            }
            else if (cons == 2) {
                System.out.println("LOGGING OUT.........................................");
                break;
            }
            else {
                System.out.println("Wrong input");
                System.out.println("Do you want to Continue?" +
                        "\n1.Yes" + "\n2. No");
                cons = con.nextInt();
            }
        }
        return cons;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Hashtable<Integer, Galamsey> Operations= new Hashtable<>();

        int cont= Continue();
        int gen=GeneralMenu();
        writingTextToFiles();
        Observatory_File();
        while(cont==1) {
            if (gen == 1) {
                Observatory_Data();

            } else if (gen == 2) {
                Galamsey_Data();

            } else if (gen == 3) {
                Statistics();
            } else {
                Exit();
            }
            cont=Continue();


        }


    }
}
