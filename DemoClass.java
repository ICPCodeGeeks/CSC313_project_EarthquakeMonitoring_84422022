
//package earthquakemonitoring.EarthquakeMonitoring;

/**
 *
 * @author Richard
 */
import java.sql.*;
public class DemoClass {
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
        
        StudentDAO dao= new StudentDAO();
        //Student s1 = dao.getStudent(4);
        Student s2 = new Student();
        s2.rollno= 14;
        s2.sname= "Archie";
        dao.connect();
        dao.addStudent(s2);
        //System.out.println(s1.sname);
        
    }
    
   
}
class StudentDAO{
    Connection con= null;
    public void connect(){
        String url = "jdbc:mysql://localhost:3306/practicedb";
        String uname= "root";
        String pass= "ashimedua123";
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, uname,pass);//creates object for Connection interface
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
        public Student getStudent(int rollno){
            try{
                String query= "select fname from students where student_id="+rollno;
            Student s = new Student();
            s.rollno= rollno;
            
            
            Statement st = con.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name= rs.getString(1);
            s.sname=name;
            return s;
            }
            catch(Exception e){
                System.out.println(e);
            }
            return null;
        }
        public void addStudent(Student s) throws SQLException{
            String query = "insert into Student(student_id,fname) values(?,?)";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setInt(1,s.rollno);
            pst.setString(2, s.sname);
            pst.executeUpdate();
        }
}

class Student{
    int rollno;
    String sname;
}
