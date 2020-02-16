package earthquakemonitoring;
/**
 *
 * @author Richard Anatsui
 */
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Richard
 */
public class Galamseydb {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String [] args)throws Exception{
                
        Galamseydb gdb = new Galamseydb();
        Scanner scan= new Scanner(System.in);
        gdb.connect();
        Galamsey g1= new Galamsey("Yellow",2,2018,15.23456,-30.67890);
        System.out.println(gdb.maxGalamsey());
        //System.out.println(g1.GalamseyDetails());
        //Galamsey g1 = new Galamsey();
        
        
    }
    Connection con= null;
    private int gIDCount=1;
    private int oIDCount=1;
    Galamsey gam = new Galamsey();
    Observatory obs= new Observatory();

    /**
     * This method connects to the database
     */
    public void connect(){
        String url = "jdbc:mysql://localhost:3306/galamseydb"; //url for localhost
        String uname= "root";   //username for localhost
        String pass= "ashimedua123";   //password for localhost
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url, uname,pass);//creates object for Connection interface
            System.out.println("Connected");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    /**
     *This method gets a single record from the galamsey table
     * @param id
     * @return String galamseyData
     */
    public String getGalamsey(int id){
        try{
            String query= "select * from galamsey where GID="+id;


            Statement st = con.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);//executes the query
            rs.next();
            String galamseyData= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getInt(3)
            +":"+ rs.getDouble(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6);//assigns data fetched from database
            st.close();
            con.close();
            return galamseyData;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     *This method gets all records from the galamsey table
     * @return String galamseyData
     */
    public String getAllGalamsey(){
        try{
            String query= "select * from galamsey";


            Statement st = con.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);//executes the query
            String galamseyData="";//assigns data fetched from database
            while(rs.next()){// shifts pointer to next row and returns true if there
                             //is a next row
                galamseyData+= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getInt(3)
                +":"+ rs.getDouble(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6)+"\n";
            }
            st.close();
            con.close();
            return galamseyData;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     *This method gets a single record from the observatory table
     * @param id
     * @return observatoryData
     */
    public String getObservatory(int id){
        try{
            String query= "select * from galamsey where OID="+id;


            Statement st = con.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);//executes the query
            rs.next();
            String observatoryData= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getString(3)
            +":"+ rs.getInt(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6);//assigns data fetched from database
            st.close();
            con.close();
            return observatoryData;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     *This method gets all the record from the observatory table
     * @return String observatoryData
     */
    public String getAllObservatory(){
        try{
            String query= "select * from observatory";


            Statement st = con.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);//executes the query
            String observatoryData="";//assigns data fetched from database
            while(rs.next()){// shifts pointer to next row and returns true if there
                             //is a next row
                observatoryData+= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getString(3)
                +":"+ rs.getInt(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6)+"\n";
            }
            st.close();
            con.close();
            return observatoryData;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     *This method inserts a single record from the galamsey table
     * @param gam
     */
    public void addGalamsey(Galamsey gam){
        
        String query = "insert into galamsey values(?,?,?,?,?,?)";
        PreparedStatement pst;
        try{
            pst= con.prepareStatement(query);
            pst.setInt(1,gIDCount); //takes number of question mark and value
            System.out.println(gIDCount);
            pst.setString(2, gam.getVegetation_color()); //takes number of question mark and value
            System.out.println(gam.getVegetation_color());
            pst.setInt(3, gam.getColor_value()); //takes number of question mark and value
            System.out.println(gam.getColor_value());
            pst.setDouble(4, gam.getLatitude()); //takes number of question mark and value
            System.out.println(gam.getLatitude());
            pst.setDouble(5, gam.getLongitude()); //takes number of question mark and value
            System.out.println(gam.getLongitude());
            pst.setInt(6, gam.getYear()); //takes number of question mark and value
            System.out.println(gam.getYear());
            int count=pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount++;
            System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
    
    /**
     *This method returns the id for a galamsey record
     * @return int gIDCount
     */
    public int galamseyIdCount(){
        return gIDCount;
    }

    /**
     *This method inserts a single record from the observatory table
     * @param gam
     * @throws SQLException
     */
    public void addObsevatory(Galamsey gam) throws SQLException{
        String query = "insert into observatory values(?,?,?,?,?,?)";
        try{
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,oIDCount); //takes number of question mark and value
        pst.setString(2, obs.getObsName()); //takes number of question mark and value
        pst.setString(3, obs.getCountryName()); //takes number of question mark and value
        pst.setInt(4, obs.getYear()); //takes number of question mark and value
        pst.setDouble(5, obs.getAreaCovered()); //takes number of question mark and value
        pst.setInt(6, gIDCount); //takes number of question mark and value
        int count=pst.executeUpdate();// returns a int of the number of rows affected
        oIDCount++;
        System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    /**
     *This method deletes a single record from the galamsey table
     * @param id
     * @throws SQLException
     */
    public void deleteGalamsey(int id) throws SQLException{
        try{
        String query = "delete from galamsey where GID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();// returns a int of the number of rows affected
        gIDCount--;
        System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println(e);
        }

    }

    /**
     *This method deletes a single record from the observatory table
     * @param id
     * @throws SQLException
     */
    public void deleteObservatory(int id) throws SQLException{
        try{
        String query = "delete from observatory where OID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();// returns a int of the number of rows affected
        gIDCount--;
        System.out.println(count+ "row/s affected");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

    /**
     *This method returns the id for a observatory record
     * @return int oIDCount
     */
    public int observatoryIdCount(){
        return oIDCount;
    }
    
    /**
     *This method updates a single record in the galamsey table
     * @param id
     * @param columnName
     * @param newValue
     * @throws SQLException
     */
    public void updateGalamsey(int id,String columnName, String newValue) throws SQLException{
        try{
        String query = "update galamsey set "+ columnName+" = '"+newValue +"' where GID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();// returns a int of the number of rows affected
        gIDCount--;
        System.out.println(count+ " row/s affected");
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    /**
     *This method updates a single record in the observatory table
     * @param id
     * @param columnName
     * @param newValue
     * @throws SQLException
     */
    public void updateObservatory(int id,String columnName, String newValue) throws SQLException{
        try{
        String query = "update observatory set "+ columnName+" = '"+newValue +"' where OID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();// returns a int of the number of rows affected
        gIDCount--;
        System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     *This method returns the maximum number of occurrences of a color value
     * @param num
     * @return int maxData
     * @throws SQLException
     */
    public int maxGalamsey() throws SQLException{
        try{
        String query1 = "select count(col_val) from galamsey where col_val=1";
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query1);// returns a int of the number of rows affected
        //int count = 0;
        rs.next();
        int firstOne= rs.getInt(1);
        String query2 = "select count(col_val) from galamsey where col_val=2";
        st= con.createStatement();
        rs=st.executeQuery(query2);// returns a int of the number of rows affected
        //int count = 0;
        rs.next();
        int secOne= rs.getInt(1);
        String query3 = "select count(col_val) from galamsey where col_val=3";
        st= con.createStatement();
        rs=st.executeQuery(query1);// returns a int of the number of rows affected
        //int count = 0;
        rs.next();
        int thirdOne= rs.getInt(1);
        int maxData= Math.max(Math.max(firstOne, secOne), thirdOne);
        if(maxData==firstOne)
            maxData=1;
        else if(maxData ==secOne)
            maxData=2;
        else
            maxData=3;
        return maxData;
        }catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }
    
    /**
     * This method returns the average of the color values
     * @return double avgData
     * @throws SQLException
     */
    public double averageGalamsey() throws SQLException{
        try{
        String query = "select avg(col_val) from galamsey";
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);// returns a int of the number of rows affected
        //int count = 0;
        rs.next();
        double avgData= rs.getDouble(1);
        //System.out.println(count+ " row/s affected");
        return avgData;
        }catch(Exception e){
            System.out.println(e);
        }
        return -1.0;
    }
   
}


