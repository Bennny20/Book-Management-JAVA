package dao;

import dto.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import ultis.DBUItis;

public class ListBook {
    DBUItis db= new DBUItis();
    Vector<Book> listBook= new Vector<Book>();
    
    public Vector<Book> getListBook(){
        return listBook;
    }
    
    public DefaultTableModel tableBook() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel dataModel = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM LISTBOOK";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int NumOfCol = rsmd.getColumnCount();

                Vector ColumnName = new Vector();
                for (int i = 1; i <= NumOfCol; i++) {
                    ColumnName.add(rsmd.getColumnName(i));
                }

                Vector myList = new Vector();
                while (rs.next()) {
                    Vector data = new Vector();
                    for (int i = 1; i <= NumOfCol; i++) {
                        data.add(rs.getString(i));
                    }
                    listBook.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
                    myList.add(data);
                }

                dataModel = new DefaultTableModel(myList, ColumnName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dataModel;
    }

    public static void setColumnOrder(int[] indices, TableColumnModel columnModel) {
        TableColumn column[] = new TableColumn[indices.length];

        for (int i = 0; i < column.length; i++) {
            column[i] = columnModel.getColumn(indices[i]);
        }

        while (columnModel.getColumnCount() > 0) {
            columnModel.removeColumn(columnModel.getColumn(0));
        }

        for (int i = 0; i < column.length; i++) {
            columnModel.addColumn(column[i]);
        }
    }

    public static void setTitleOder(String[] header, JTable table) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(header[i]);
        }
    }
    
    public DefaultTableModel tableBookAscending() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel dataModel = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM LISTBOOK ORDER BY bookName ASC;";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int NumOfCol = rsmd.getColumnCount();

                Vector ColumnName = new Vector();
                for (int i = 1; i <= NumOfCol; i++) {
                    ColumnName.add(rsmd.getColumnName(i));
                }

                Vector myList = new Vector();
                while (rs.next()) {
                    Vector data = new Vector();
                    for (int i = 1; i <= NumOfCol; i++) {
                        data.add(rs.getString(i));
                    }
                    listBook.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
                    myList.add(data);
                }

                dataModel = new DefaultTableModel(myList, ColumnName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dataModel;
    }
    
    public DefaultTableModel tableBookDescending() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel dataModel = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM LISTBOOK ORDER BY bookName DESC;";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int NumOfCol = rsmd.getColumnCount();

                Vector ColumnName = new Vector();
                for (int i = 1; i <= NumOfCol; i++) {
                    ColumnName.add(rsmd.getColumnName(i));
                }

                Vector myList = new Vector();
                while (rs.next()) {
                    Vector data = new Vector();
                    for (int i = 1; i <= NumOfCol; i++) {
                        data.add(rs.getString(i));
                    }
                    listBook.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
                    myList.add(data);
                }

                dataModel = new DefaultTableModel(myList, ColumnName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dataModel;
    }
    
    public DefaultTableModel tableBookSearchByName(String bookName) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel dataModel = null;

        try {
            con = DBUItis.openConnection();
            if (con != null) {
                String sql = "SELECT * FROM LISTBOOK WHERE CHARINDEX(N'"+bookName+"', bookName)>0;";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int NumOfCol = rsmd.getColumnCount();

                Vector ColumnName = new Vector();
                for (int i = 1; i <= NumOfCol; i++) {
                    ColumnName.add(rsmd.getColumnName(i));
                }

                Vector myList = new Vector();
                while (rs.next()) {
                    Vector data = new Vector();
                    for (int i = 1; i <= NumOfCol; i++) {
                        data.add(rs.getString(i));
                    }
                    listBook.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
                    myList.add(data);
                }

                dataModel = new DefaultTableModel(myList, ColumnName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dataModel;
    }
    
    public boolean addBook(Book book) throws SQLException{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBUItis.openConnection();
            if(con != null){
                String sql= "Insert LISTBOOK Values(?,?,?,?,?,?)";
                
                ps= con.prepareStatement(sql);
                ps.setString(1, book.getBookID());
                ps.setString(2, book.getBookName());
                ps.setString(3, book.getAuthor());
                ps.setString(4, book.getPublisher());
                ps.setInt(5, book.getPublishedYear());
                ps.setBoolean(6, book.isForRent());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
        JOptionPane.showMessageDialog(null, "Add Successful!");
        return true;
    }
    
    public boolean UpdateBook(Book book) throws SQLException{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBUItis.openConnection();
            if(con != null){
                String sql= "UPDATE LISTBOOK SET bookName=?, author=?, publisher=?, publishedYear=?, forRent=? WHERE bookID=?";
                ps= con.prepareStatement(sql);
                
                ps= con.prepareStatement(sql);
                ps.setString(1, book.getBookName());
                ps.setString(2, book.getAuthor());
                ps.setString(3, book.getPublisher());
                ps.setInt(4, book.getPublishedYear());
                ps.setBoolean(5, book.isForRent());
                ps.setString(6, book.getBookID());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
        JOptionPane.showMessageDialog(null, "Update Successful!");
        return true;
    }
    
    public boolean deleteBook(Book book) throws SQLException{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBUItis.openConnection();
            if(con != null){
                String sql= "DELETE FROM LISTBOOK WHERE bookID=?";
                ps= con.prepareStatement(sql);
                ps.setString(1, book.getBookID());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
        JOptionPane.showMessageDialog(null, "Delete Successful!");
        return true;
    }
}
