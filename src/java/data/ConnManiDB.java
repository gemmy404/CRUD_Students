package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnManiDB {
    final private String user = "root";
    final private String password = "";
    final private String url = "jdbc:mysql://localhost/javamysql";
    
    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
    
    public int insert(Student s, Connection c) {
        int status = 0;
        String sql = "INSERT INTO studentinfo (FName, LName, Email, Password, Gender, Country) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getFname());
            ps.setString(2, s.getLname());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPass()); 
            ps.setString(5, s.getGender());
            ps.setString(6, s.getCountry());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return status;
    }
    
        public int update(Student s, Connection c) {
        int status = 0;
        String sql = "UPDATE studentinfo SET FName = ?, LName = ?, Email = ?, Password = ?, Gender = ?, Country = ? WHERE ID = ?";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getFname());
            ps.setString(2, s.getLname());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPass());
            ps.setString(5, s.getGender());
            ps.setString(6, s.getCountry());
             ps.setInt(7, s.getId());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return status;
    }
        
        public int delete(Student s, Connection c) {
            int status = 0;
            String sql = "DELETE FROM studentinfo WHERE ID = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, s.getId());
                status = ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return status;
        }

        
        public Student getRecord(int id, Connection c) {
            Student s = null;
            String sql = "SELECT * FROM studentinfo WHERE ID = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        s = new Student();
                        s.setId(rs.getInt("ID"));
                        s.setFname(rs.getString("FName"));
                        s.setLname(rs.getString("LName"));
                        s.setEmail(rs.getString("Email"));
                        s.setPass(rs.getString("Password"));
                        s.setGender(rs.getString("Gender"));
                        s.setCountry(rs.getString("Country"));
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return s;
        }

        
        public List<Student> getTable(Connection c) {
            List<Student> list = new ArrayList<>();
            String sql = "SELECT * FROM studentinfo";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Student s = new Student();
                        s.setId(rs.getInt("ID"));
                        s.setFname(rs.getString("FName"));
                        s.setLname(rs.getString("LName"));
                        s.setEmail(rs.getString("Email"));
                        s.setPass(rs.getString("Password"));
                        s.setGender(rs.getString("Gender"));
                        s.setCountry(rs.getString("Country"));
                        list.add(s);
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return list;
        }
}
