package earthquakemonitoring;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Aileen Akpalu
 * @Kobby Koranteng
 * @Kelvin Akakpo
 *@version 1.0.2
 */
public class MonitoringIO {
    static Galamseydb gd=new Galamseydb();
    static Monitoring m= new Monitoring();

    /**
     * This method prints a menu that gives a user options to choose from
     * @return
     */
    public static int GeneralMenu() {
        Scanner menu = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("WELCOME  TO THE GALAMSEY INFORMATION CENTER" +
                "\nPlease select an option" +
                "\n 1.Enter Observatory Data" +
                "\n 2.Enter Galamsey Data" +
                "\n 3.Monitoring Statistics" +
                "\n 4.Details"+
                "\n 5. Exit");
        int menus = menu.nextInt();
        while (true) {
            if (menus == 1 || menus == 2 || menus == 3 || menus==4) {
                break;
            }
            else if(menus==5){
                System.out.println("Exiting.......................");
            } else{
                System.out.println("Wrong input....................");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("WELCOME  TO THE GALAMSEY INFORMATION CENTER" +
                        "\nPlease select an option" +
                        "\n 1.Enter Observatory Data" +
                        "\n 2.Enter Galamsey Data" +
                        "\n 3.Monitoring Statistics" +
                        "\n 4.Details"+
                        "\n 5. Exit");
                menus = menu.nextInt();

            }
        }
        return menus;
    }


    /**
     * This methods aks for a user to input neew observatory data
     */
    public static void Observatory_Data()  {
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
        gd.addObservatory(new_data);



    }




    /**
     *This method asks for a user to input new data
     */
    public static void Galamsey_Data() {
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
        gd.addGalamsey(new_data);

    }

    /**
     * This method prints the current statistics of observatory
     * @throws SQLException
     */
    public static void Statistics() throws SQLException {
        Scanner menu = new Scanner(System.in);
        System.out.println(" Enter a colour value from 0-3: ");
        int number= menu.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("These are the current Monitoring Statistics"+
                "\n Largest colour value:"+ m.largests());
        System.out.println("\n Average colour value: "+ m.average());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println( "\n Galamsey Events: "+"\n"+ m.Galamsey_List(number));

    }

    /**
     * This method returns a menu that allows for an input
     * @return
     */
    public static int Details(){
    Scanner menu = new Scanner(System.in);
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("DETAILS" +
            "\nPlease select an option" +
            "\n 1.All Observatory Details" +
            "\n 2.All Galamsey Details" +
            "\n 3.Single Observatory Detail" +
            "\n 4. Single Galamsey Detail"
            );
    int menus = menu.nextInt();
    while (true) {
        if (menus == 1 || menus == 2 || menus == 3||menus==4 ) {
            break;

        } else{
            System.out.println("Wrong input....................");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("DETAILS" +
                    "\nPlease select an option" +
                    "\n 1.All Observatory Details" +
                    "\n 2.All Galamsey Details" +
                    "\n 3.Single Observatory Detail" +
                    "\n 4. Single Galamsey Detail");
            menus = menu.nextInt();

        }
    }
    return menus;
}

    /**
     * This method prints a single observatory record
     */
    public static void All_ObsDet(){
        Scanner re= new Scanner(System.in);
        System.out.println("Enter the ID of an Observatory: ");
        int rd= re.nextInt();
        gd.getGalamsey(rd);
}

    /**
     * This method prints the record of one galamsey event
     */
    public static void All_GalDet(){
        Scanner re= new Scanner(System.in);
        System.out.println("Enter the ID of an Galamsey event: ");
        int rd= re.nextInt();
        gd.getObservatory(rd);
    }

    /**
     * This prints all the observatory records
     */
    public static void All_dets(){
        gd.getAllObservatory1();
    }

    /**
     * This method prints all galamsey records
     */
    public static void All_gal(){
        gd.getAllGal1();
    }


    /**
     * This method ends the program
     */
    public static void Exit(){
        System.out.println("Exiting...........................................................");
    }

    /**
     * This asks for an input and goes back to the Main menu if 1 and exits if 2
     * @return
     */
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

    /**
     * This is the main method that runs
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {


        int cont= Continue();
        while(cont==1) {
            int gen=GeneralMenu();
            if (gen == 1) {
                Observatory_Data();

            } else if (gen == 2) {
                Galamsey_Data();

            } else if (gen == 3) {
                Statistics();
            } else if(gen== 4) {
                int d= Details();
                if(d==1){
                    All_dets();
                }
                else if(d==2){
                    All_gal();
                }
                else if(d==3){
                    All_ObsDet();
                }
                else{
                    All_GalDet();
                }
            }
            else{
                Exit();
            }
            cont=Continue();


        }

    }
}
