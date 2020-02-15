package earthquakemonitoring;
/**
 *
 * @author Richard Anatsui
 */
import java.sql.*;

public class Galamseydb {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String [] args)throws Exception{
        /*String url = "jdbc:mysql://localhost:3306/practicedb";
        String uname= "root";
        String pass= "ashimedua123";
        //String query1= "select * from students";
        int studentID= 7;
        String fname= "Ali";
        String lname= "Baba";
        String query2= "insert into students values(?,?,?,'1978-07-08','ali.baba@ashesi.edu.gh','0560330125','Male')";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url,uname,pass);
        PreparedStatement st = con.prepareStatement(query2);
        //ResultSet rs =st.executeQuery(query1);//executes the query 
        st.setInt(1,studentID);//takes number of question mark and value
        st.setString(2, fname);// takes number of question mark and value
        st.setString(3, lname);//takes number of question mark and value
        int count=st.executeUpdate();// returns a int of the number of rows affected
        String userData=""; //assigns data fetched from database
        System.out.println(count+ "row/s affected");
        /*while(rs.next()){// shifts pointer to next row and returns true if there
            //is a next row
        userData= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getString(3)
                +":"+ rs.getString(4)+":"+ rs.getString(5)+":"+ rs.getString(6)
                +":"+ rs.getString(7);
        
        System.out.println(userData);
        }
        
       
        
        
        st.close();
        con.close();
        */
        
        //MonitoringDAO dao= new MonitoringDAO();
        //Student s1 = dao.getStudent(4);
        //Galamsey g1 = new Galamsey();
        
        //dao.connect();
        //dao.addGalamsey(g1);
        //System.out.println(s1.sname);
        
    }
    Connection con= null;
    private int gIDCount;
    private int oIDCount;
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
            Connection con= DriverManager.getConnection(url, uname,pass);//creates object for Connection interface
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
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String galamseyData= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getInt(3)
            +":"+ rs.getDouble(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6);
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
            ResultSet rs = st.executeQuery(query);
            String galamseyData="";
            while(rs.next()){// shifts pointer to next row and returns true if there
                             //is a next row
                galamseyData+= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getInt(3)
                +":"+ rs.getDouble(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6)+"\n";
            }
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
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String observatoryData= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getString(3)
            +":"+ rs.getInt(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6);
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
            ResultSet rs = st.executeQuery(query);
            String observatoryData="";
            while(rs.next()){// shifts pointer to next row and returns true if there
                             //is a next row
                observatoryData+= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getString(3)
                +":"+ rs.getInt(4)+":"+ rs.getDouble(5)+":"+ rs.getInt(6)+"\n";
            }
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
     * @throws SQLException
     */
    public void addGalamsey(Galamsey gam) throws SQLException{
        String query = "insert into galamasey values(?,?,?,?,?,?)";
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,gIDCount); //takes number of question mark and value
        pst.setString(2, gam.getVegetation_color()); //takes number of question mark and value
        pst.setInt(3, gam.getColor_value()); //takes number of question mark and value
        pst.setDouble(4, gam.getLatitude()); //takes number of question mark and value
        pst.setDouble(5, gam.getLongitude()); //takes number of question mark and value
        pst.setInt(6, gam.getYear()); //takes number of question mark and value
        int count=pst.executeUpdate();
        gIDCount++;
        System.out.println(count+ "row/s affected");

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
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,oIDCount); //takes number of question mark and value
        pst.setString(2, obs.getObsName()); //takes number of question mark and value
        pst.setString(3, obs.getCountryName()); //takes number of question mark and value
        pst.setInt(4, obs.getYear()); //takes number of question mark and value
        pst.setDouble(5, obs.getAreaCovered()); //takes number of question mark and value
        pst.setInt(6, gIDCount); //takes number of question mark and value
        int count=pst.executeUpdate();
        oIDCount++;
        System.out.println(count+ "row/s affected");

    }

    /**
     *This method deletes a single record from the galamsey table
     * @param id
     * @throws SQLException
     */
    public void deleteGalamsey(int id) throws SQLException{
        String query = "delete from galamsey where GID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();
        gIDCount--;
        System.out.println(count+ "row/s affected");

    }

    /**
     *This method deletes a single record from the observatory table
     * @param id
     * @throws SQLException
     */
    public void deleteObservatory(int id) throws SQLException{
        String query = "delete from observatory where OID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();
        gIDCount--;
        System.out.println(count+ "row/s affected");

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
        String query = "update galamsey set "+ columnName+" = '"+newValue +"' where GID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();
        gIDCount--;
        System.out.println(count+ "row/s affected");

    }

    /**
     *This method updates a single record in the observatory table
     * @param id
     * @param columnName
     * @param newValue
     * @throws SQLException
     */
    public void updateObservatory(int id,String columnName, String newValue) throws SQLException{
        String query = "update observatory set "+ columnName+" = '"+newValue +"' where OID="+id;
        PreparedStatement pst= con.prepareStatement(query);
        int count=pst.executeUpdate();
        gIDCount--;
        System.out.println(count+ "row/s affected");

    }
    
   
}


