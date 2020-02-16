package earthquakemonitoring;
//package galamseys;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Richard Anatsui and Aileen Akpalu
 */
public class MonitoringIO {
    private static Hashtable Operations;
    Monitoring mon= new Monitoring();
    Observatory obs =new Observatory();
    Galamsey gam= new Galamsey();

    /**
     *This method provides a menu for the user to either
     * enter galamsey data, observatory data or view 
     * monitoring statistics
     * @return int menu
     */
    public int GeneralMenu() {
        try{
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
        }catch(Exception e){
            System.out.println(e);
        }
        return -1;
        
    }

    

    /**
     *This method lets user enter all necessary observatory data
     * @throws FileNotFoundException
     */
    public void Observatory_Data() throws FileNotFoundException {
        try{
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
        catch(Exception e){
            System.out.println(e);
        }
    }


    /**
     *This method lets user enter all necessary galamsey data
     */
    public void Galamsey_Data(){
        try{
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
        System.out.println(" ");
        System.out.println("Year: ");
        int year = nam.nextInt();
        new_data.setYear(year);
        new_data= new Galamsey(veg_color,color_value,year,pos_lat,pos_long);
        }catch(Exception e){
            System.out.println(e);
        }
        try {
            writingTextToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Operations.put(color_value,new_data);

    }

    /**
     * This method prints the  largest average “galamsey”, largest “galamsey” ever 
     * and all “galamsey” with colour value greater than a given number
     */
    public void Statistics() {
        try{
        Scanner menu = new Scanner(System.in);
        System.out.println(" Enter a colour value from 0-3: ");
        int number= menu.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("These are the current Monitoring Statistics"+
                "\n Largest colour value:"+ mon.largests()+
                "\n Average colour value: "+ mon.average());
        System.out.println( "\n Galamsey Events: ");
                mon.Galamsey_List((Hashtable) Operations, number);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     *This method writes the headings for the observatory data to a text file
     * @throws FileNotFoundException
     */
    public void Observatory_File() throws FileNotFoundException {

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

    /**
     *This method writes the observatory data to a text file
     * @throws FileNotFoundException
     */
    public void Observatory_Files() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try {
            //Note that we are able to append to the file because of the "true" parameter
            printWriter = new PrintWriter(new FileOutputStream("observatory_data.txt", true));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

//prints the headings to the text file
        printWriter.print(obs.getObsName() + "    " + obs.getCountryName() + "    " + obs.getYear()+"    " +obs.getAreaCovered());
        printWriter.println();

        printWriter.close();

    }

    /**
     *This method writes the headings for the galamsey data to a text file
     * @throws FileNotFoundException
     */
    public void writingTextToFiles() throws FileNotFoundException {

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

    /**
     *This method writes the observatory data to a text file
     * @throws FileNotFoundException
     */
    public void writingTextToFile() throws FileNotFoundException {

        PrintWriter printWriter = null;

        try {
            //Note that we are able to append to the file because of the "true" parameter
            printWriter = new PrintWriter(new FileOutputStream("galamsey_data.txt", true));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

//prints the headings to the text file
        printWriter.print(gam.getVegetation_color() + "    " + gam.getColor_value() + "    " + gam.getPosition()+"    "+gam.getYear());
        printWriter.println();

        printWriter.close();

    }

    /**
     *This method prints "Exiting" in the console
     */
    public void Exit(){
        System.out.println("Exiting...........................................................");
    }

    /**
     * This method finds out from the user whether he wants to continue or not
     * and returns an int based on their input
     * @return int cons
     */
    public int Continue() {
        try{
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
        }catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }

    /**
     *This is the main method to test all the above methods
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        try{
        Hashtable<Integer, Galamsey> Operations= new Hashtable<>();
        MonitoringIO monIO= new MonitoringIO();
        int cont= monIO.Continue();
        int gen=monIO.GeneralMenu();
        monIO.writingTextToFiles();
        monIO.Observatory_File();
        while(cont==1) {
            if (gen == 1) {
                monIO.Observatory_Data();

            } else if (gen == 2) {
                monIO.Galamsey_Data();

            } else if (gen == 3) {
                monIO.Statistics();
            } else {
                monIO.Exit();
            }
            cont=monIO.Continue();
            }
        }catch(Exception e){
            System.out.println(e);


        }


    }
}
