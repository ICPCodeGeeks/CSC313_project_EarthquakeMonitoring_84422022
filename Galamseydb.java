package earthquakemonitoring;
/**
 *
 * @author Richard Anatsui and Kobby Koranteng and Aileen Akpalu
 *@version 1.0.5
 */
import java.sql.*;
import java.util.*;

/**
 *
 * @author Richard
 */
public class Galamseydb {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Galamseydb gdb = new Galamseydb();
        Scanner scan = new Scanner(System.in);
        Galamsey g1 = new Galamsey("Yellow", 2, 2018, 15.23456, -30.67890);
//        System.out.println(gdb.maxAvgObserv());
//        System.out.println(gdb.getAllObservatory());
//        System.out.println(gdb.getAllGalamsey());
//        System.out.println(gdb.observatoryIdCount());
//        System.out.println(gdb.getNumberOfObservatory());
        System.out.println(gdb.maxAvgObserv());
        System.out.println(gdb.maxGalamsey());


    }


    Connection con;
    Statement st;
    ResultSet rs;
    private int gIDCount = 1;
    private int oIDCount = 1;


    /**
     * This method connects to the database
     * @return
     */
    public Galamseydb() {
        String url = "jdbc:mysql://localhost:3306/galamseydb"; //url for localhost
        String uname = "root";   //username for localhost
        String pass = "Aileenlisa18";   //password for localhost
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);//creates object for Connection interface
            st = con.createStatement();
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method gets a single record from the galamsey table
     *
     * @param id
     * @return String galamseyData
     */
    public String getGalamsey(int id) {
        try {
            String query = "select * from galamsey where GID=" + id;
            rs = st.executeQuery(query);//executes the query
            rs.next();
            String galamseyData= rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                    Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                    Integer.parseInt(rs.getString("year_started"));//assigns data fetched from database

            return galamseyData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method gets all records from the galamsey table
     *
     * @return String galamseyData
     */
    public String getAllGalamsey() {
        try {
            String query = "select * from galamsey";
            rs = st.executeQuery(query);//executes the query
            String galamseyData = "";//assigns data fetched from database
            while (rs.next()) {// shifts pointer to next row and returns true if there
                //is a next row
                galamseyData += rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                        Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                        Integer.parseInt(rs.getString("year_started")) + "\n";
            }

            return galamseyData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method gets all records from the galamsey table
     *
     * @param col_val
     * @return String galamseyData
     */
    public String getAllGalamsey(int col_val) {
        try {
            String query = "select * from galamsey where col_val>" + col_val;
            rs = st.executeQuery(query);//executes the query
            String galamseyData = "";//assigns data fetched from database
            while (rs.next()) {// shifts pointer to next row and returns true if there
                //is a next row
                galamseyData += rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                        Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                        Integer.parseInt(rs.getString("year_started")) + "\n";
            }

            return galamseyData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method gets all records from the galamsey table greater than a given color value
     *
     * @param col_val
     * @return String galamseyData
     */
    public String greaterGalamsey(int col_val) {
        try {
            String query = "select * from galamsey where col_val >" + col_val;
            rs = st.executeQuery(query);//executes the query
            String galamseyData = "";//assigns data fetched from database
            while (rs.next()) {// shifts pointer to next row and returns true if there
                //is a next row
                galamseyData +=  rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                        Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                        Integer.parseInt(rs.getString("year_started")) + "\n";
            }

            return galamseyData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method gets a single record from the observatory table
     *
     * @param id
     * @return observatoryData
     */
    public String getObservatory(int id) {
        try {
            String query = "select * from observatory where OID=" + id;
             rs = st.executeQuery(query);//executes the query
            rs.next();
            String observatoryData= rs.getString("OID")+":"+ rs.getString("obs_name")+":"+rs.getString("country_name")+":"+
                    Integer.parseInt(rs.getString("year_started"))+":"+Double.parseDouble(rs.getString("area_covered"));
//            String observatoryData = rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3)
//                    + ":" + rs.getDouble(4) + ":" + rs.getInt(5);//assigns data fetched from database

            return observatoryData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method gets a list of GIDs asscoiated with an OID from the galamsey_observatory table
     *
     * @param id
     * @return observatoryData
     */
    public List<Integer> getIDGalam_Observ(int id) {
        try {
            String query = "select * from galamsey_observatory where OID=" + id;
             rs = st.executeQuery(query);//executes the query
            List<Integer> GId = new ArrayList<>();
            while (rs.next()) {
                int observatoryData = rs.getInt(1);//assigns data fetched from database
                GId.add(observatoryData);
            }
            return GId;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method gets all galamsey records associated with an observatory from the galamsey_observatory table
     *
     * @param id
     * @return List<Galamsey> GalamseyData
     */
    public List<Galamsey> getGalam_Observ(int id) {
        try {
            String query = "select * from galamsey_observatory where OID=" + id;
             rs = st.executeQuery(query);//executes the query
            List<Integer> GId = new ArrayList<>();
            List<Galamsey> GalamseyData = new ArrayList<>();
            int galam_observData;

            while (rs.next()) {
                galam_observData = rs.getInt(1);//assigns data fetched from database
                //System.out.println(galam_observData);
                GId.add(galam_observData);

            }
            System.out.println(GId.size());
            Galamsey g2;
            for (int i = 0; i < GId.size(); i++) {


                String text = getGalamsey(GId.get(i));
                String[] gWords = text.split(":");
                System.out.println(Arrays.toString(gWords));
                GalamseyData.add(g2 = new Galamsey(gWords[1], Integer.parseInt(gWords[2]), Integer.parseInt(gWords[5]), Double.parseDouble(gWords[3]), Double.parseDouble(gWords[4])));
                System.out.println(g2.GalamseyDetails());
                //System.out.println(GalamseyData.size());
            }
            return GalamseyData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method returns the average galamsey color value associated
     * with a particular observatory
     *
     * @param id
     * @return double avg
     * @throws SQLException
     */
    public double getAvgObserv(int id) throws SQLException {
        try {
            String query = "select GID from galamsey_observatory where OID=" + id;
            rs = st.executeQuery(query);//executes the query
            List<Integer> GId = new ArrayList<>();
            int count = 0;
            double avg;
            while (rs.next()) {
                GId.add(rs.getInt(1));

            }
            for (int i = 0; i < GId.size(); i++) {
                String text = getGalamsey(GId.get(i));
                String[] gWords = text.split(":");
                count += Integer.parseInt(gWords[2]);

            }
            avg = count / 3;
            return avg;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1.0;
    }

    /**
     * This method returns the name of the observatory with max average galamsey color value
     *
     * @return String gWords[1]
     */
    public String maxAvgObserv() {
        try {
            String query = "select * from observatory";
             rs = st.executeQuery(query);//executes the query
            List<Double> averages = new ArrayList<>();
            int observData;

            while (rs.next()) {
                observData = rs.getInt(1);//assigns data fetched from database

                averages.add(getAvgObserv(observData));


            }
            double max = 0;
            int index = 0;
            for (int i = 0; i < averages.size(); i++) {
                max = Math.max(averages.get(i), max);

                if (max == averages.get(i))
                    index = i;

            }
            String text = getObservatory(index + 1);
            String[] gWords = text.split(":");
            return gWords[1];


        } catch (Exception e) {
            System.out.println(e);
        }
        return "Reddddd";

    }

    /**
     * This method gets all the record from the observatory table
     *
     * @return String observatoryData
     */
    public String getAllObservatory() {
        String observatoryData = "";
        try {
            String query = "select * from observatory";
             rs = st.executeQuery(query);//executes the query
            while (rs.next()) {// shifts pointer to next row and returns true if there
                //is a next row
                observatoryData += rs.getString("OID")+":"+ rs.getString("obs_name")+":"+rs.getString("country_name")+":"+
                        Integer.parseInt(rs.getString("year_started"))+":"
                        +Double.parseDouble(rs.getString("area_covered")) + "\n";
            }
            st.close();
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
        return observatoryData;
    }

    /**
     * This method gets all the records from the galamsey_observatory table
     *
     * @return String galam_observData
     */
    public String getAllGalam_Observ() {
        try {
            String query = "select * from galamsey_observatory";
             rs = st.executeQuery(query);//executes the query
            String galam_observData = "";//assigns data fetched from database
            while (rs.next()) {// shifts pointer to next row and returns true if there
                //is a next row
                galam_observData += rs.getInt(1) + ":" + rs.getInt(2) + "\n";
            }

            return galam_observData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * This method inserts a single record from the galamsey table
     *
     * @param gam
     */
    public void addGalamsey(Galamsey gam){

        String query = "insert into galamsey(veg_col,col_val,latitude,longitude,year_started) values(?,?,?,?,?)";
        PreparedStatement pst;
        try{
            pst= con.prepareStatement(query);
            pst.setString(1, gam.getVegetation_color()); //takes number of question mark and value
            System.out.println(gam.getVegetation_color());
            pst.setInt(2, gam.getColor_value()); //takes number of question mark and value
            System.out.println(gam.getColor_value());
            pst.setDouble(3, gam.getLatitude()); //takes number of question mark and value
            System.out.println(gam.getLatitude());
            pst.setDouble(4, gam.getLongitude()); //takes number of question mark and value
            System.out.println(gam.getLongitude());
            pst.setInt(5, gam.getYear()); //takes number of question mark and value
            System.out.println(gam.getYear());
            int count=pst.executeUpdate();// returns a int of the number of rows affected
            //  gIDCount++;
            System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println("Error: "+e);
        }



    }


    /**
     * This method returns the id for a galamsey record
     *
     * @return int gIDCount
     */
    public int galamseyIdCount() {
        return gIDCount;
    }

    /**
     * This method inserts a single record into the observatory table
     *
     * @param obs
     */
    public void addObservatory(Observatory obs) {
        String query = "insert into observatory(obs_name,country_name,year_started,area_covered) values(?,?,?,?)";
        try{
            PreparedStatement pst= con.prepareStatement(query);
            // pst.setInt(1,oIDCount); //takes number of question mark and value
            pst.setString(1, obs.getObsName()); //takes number of question mark and value
            pst.setString(2, obs.getCountryName()); //takes number of question mark and value
            pst.setInt(3, obs.getYear()); //takes number of question mark and value
            pst.setDouble(4, obs.getAreaCovered()); //takes number of question mark and value
            int count=pst.executeUpdate();// returns a int of the number of rows affected

            System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    /**
     * This method inserts a single record into the galamsey_observatory table
     *
     * @param GID
     * @param OID
     * @throws SQLException
     */
    public void addGalam_Observ(int GID, int OID) throws SQLException {
        String query = "insert into galamsey_observatory values(?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, GID); //takes number of question mark and value
            pst.setInt(2, OID); //takes number of question mark and value
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            System.out.println(count + " row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method deletes a single record from the galamsey table
     *
     * @param id
     * @throws SQLException
     */
    public void deleteGalamsey(int id) throws SQLException {
        try {
            String query = "delete from galamsey where GID=" + id;
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount--;
            System.out.println(count + " row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method deletes a single record from the observatory table
     *
     * @param id
     * @throws SQLException
     */
    public void deleteObservatory(int id) throws SQLException {
        try {
            String query = "delete from observatory where OID=" + id;
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount--;
            System.out.println(count + "row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method deletes records from the galamsey_observatory table
     *
     * @param id
     * @throws SQLException
     */
    public void deleteGalam_Observ(int id) throws SQLException {
        try {
            String query = "delete from galamsey_observatory where OID=" + id;
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount--;
            System.out.println(count + " row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method returns the id for a observatory record
     *
     * @return int oIDCount
     */
    public int observatoryIdCount() {
        return oIDCount;
    }

    /**
     * This method updates a single record in the galamsey table
     *
     * @param id
     * @param columnName
     * @param newValue
     * @throws SQLException
     */
    public void updateGalamsey(int id, String columnName, String newValue) throws SQLException {
        try {
            String query = "update galamsey set " + columnName + " = '" + newValue + "' where GID=" + id;
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount--;
            System.out.println(count + " row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method updates a single record in the observatory table
     *
     * @param id
     * @param columnName
     * @param newValue
     * @throws SQLException
     */
    public void updateObservatory(int id, String columnName, String newValue) throws SQLException {
        try {
            String query = "update observatory set " + columnName + " = '" + newValue + "' where OID=" + id;
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount--;
            System.out.println(count + " row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method updates a single record in the observatory table
     *
     * @param id
     * @param columnName
     * @param newValue
     * @throws SQLException
     */
    public void updateGalam_Observ(int id, String columnName, String newValue) throws SQLException {
        try {
            String query = "update galamsey_observatory set " + columnName + " = '" + newValue + "' where OID=" + id;
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();// returns a int of the number of rows affected
            gIDCount--;
            System.out.println(count + " row/s affected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method returns the maximum number of occurrences of a color value
     *
     * @return int maxData
     * @throws SQLException
     */
    public int maxGalamsey() throws SQLException {
        try {
            String query1 = "select count(col_val) from galamsey where col_val=1";
           rs = st.executeQuery(query1);// returns a int of the number of rows affected
            //int count = 0;
            rs.next();
            int firstOne = rs.getInt(1);
            String query2 = "select count(col_val) from galamsey where col_val=2";
            rs = st.executeQuery(query2);// returns a int of the number of rows affected
            //int count = 0;
            rs.next();
            int secOne = rs.getInt(1);
            String query3 = "select count(col_val) from galamsey where col_val=3";
            rs = st.executeQuery(query3);// returns a int of the number of rows affected
            //int count = 0;
            rs.next();
            int thirdOne = rs.getInt(1);
            int maxData = Math.max(Math.max(firstOne, secOne), thirdOne);
            if (maxData == firstOne)
                maxData = 1;
            else if (maxData == secOne)
                maxData = 2;
            else
                maxData = 3;
            return maxData;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    /**
     * This method returns the average of the color values
     *
     * @return double avgData
     * @throws SQLException
     */
    public double averageGalamsey() throws SQLException {
        try {
            String query = "select avg(col_val) from galamsey";
             rs = st.executeQuery(query);// returns a int of the number of rows affected
            //int count = 0;
            rs.next();
            double avgData = rs.getDouble(1);
            //System.out.println(count+ " row/s affected");
            return avgData;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1.0;
    }

    public int getObservatoryId(String name, int Year) throws SQLException {
        try {
            String query = "Select * from Observatory where obs_name ='" + name + "' and year_started=" + Year;
             rs = st.executeQuery(query);
            int Galam = 0;
            while (rs.next()) {
                Galam += rs.getInt(1);
            }
            return Galam;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public int getGalamseyyId() throws SQLException {
        try {
            String query = "Select * from galamsey where GID=(select max(GID) from galamsey)";
            rs = st.executeQuery(query);
            int Galam = 0;
            while (rs.next()) {
                Galam += rs.getInt(1);
            }
            return Galam;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    /**
     * This method returns the number of observatory records
     *
     * @return int oIDCount
     */
    public int getNumberOfObservatory() throws SQLException {
        String query = "Select Count(*) from Observatory";
        rs = st.executeQuery(query);

        rs.next();
        int Count = rs.getInt(1);
        return Count;

    }

    /**
     * This method returns the number of galamsey record
     *
     * @return int gIDCount
     */
    public int getNumberofGalamsey() throws SQLException {
        String query = "Select count(*) from galamsey";
        rs = st.executeQuery(query);
        rs.next();
        int Count = rs.getInt(1);
        return Count;


    }
    public ArrayList<String[]> getAllObservatory1(){
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String query = "select * from observatory";
            rs = st.executeQuery(query);//executes the query
            while (rs.next()) {// shifts pointer to next row and returns true if there
                String[] res = new String[getNumberOfObservatory()];

            }

            String[] res = {rs.getString("OID"), rs.getString("obs_name"), rs.getString("country_name"),
                    rs.getString("year_started"),rs.getString("area_covered")};
            list.add(res);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    public ArrayList<String[]> getAllGal1() {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String query = "select * from galamsey";
            rs = st.executeQuery(query);//executes the query
            while (rs.next()) {// shifts pointer to next row and returns true if there
                String[] res = {rs.getString("GID"), rs.getString("veg_col"), rs.getString("col_val"),
                        rs.getString("latitude"),rs.getString("longitude"),
                        rs.getString("year_started")};
                list.add(res);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(list.toString());
        return list;
    }


}
