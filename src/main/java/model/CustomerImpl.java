package model;

import props.Customer;
import props.User;
import utils.DB;
import utils.Util;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomerImpl implements ICustomer{
    DB db=new DB();
    ServiceImpl service=new ServiceImpl();
    List<Customer> ls = new ArrayList<>();
    List<Customer> lsSearch = new ArrayList<>();
    public CustomerImpl(){
        ls = service.serviceCustomerList();
        lsSearch = ls;
    }
    @Override
    public int customerInsert(Customer customer) {
        ls=lsSearch;
        int status=0;
        try{
            String sql="INSERT INTO customer values(null,?,?,?,?,?)";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1,customer.getName());
            pre.setString(2,customer.getSurname());
            pre.setString(3,customer.getEmail());
            pre.setString(4,customer.getPhone());
            pre.setString(5,customer.getAddress());
            status = pre.executeUpdate();
        }catch (Exception e){
            System.out.println("customerUpdate Error : "+e);
            if(e.toString().contains("UNIQUE") && e.toString().contains("email"))
                status = -1;
            else if (e.toString().contains("UNIQUE") && e.toString().contains("phone"))
                status = -2;
        }
        finally {
            db.close();
        }
        return status;
    }

    @Override
    public int customerUpdate(Customer customer) {
        ls=lsSearch;
        int status = 0;
        try{
            String sql=" UPDATE customer SET name= ?,surname = ?,email = ?, phone =?, address =? where cid=?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1,customer.getName());
            pre.setString(2,customer.getSurname());
            pre.setString(3,customer.getEmail());
            pre.setString(4,customer.getPhone());
            pre.setString(5,customer.getAddress());
            pre.setInt(6,customer.getCid());
            status = pre.executeUpdate();
        }catch (Exception e){
            System.out.println("customerUpdate Error : "+e);
        }
        finally {
            db.close();
        }
        return status;
    }

    @Override
    public int customerDelete(int cid) {
        int status=0;
        try{
            String sql="DELETE FROM customer WHERE cid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,cid);
            status = pre.executeUpdate();
        }catch (Exception e){
            System.out.println("customerDelete Error : "+e);
        }
        finally {
            db.close();
        }
        return status;
    }

    @Override
    public List<Customer> customerList() {
        List<Customer> ls0=new ArrayList<>();
        try{
            String sql="SELECT * FROM customer";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs= pre.executeQuery();
            while (rs.next()){//rs.next() son elemana kadar bakar.
                int cid=rs.getInt("cid");
                String name=rs.getString("name");
                String surname=rs.getString("surname");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                String address=rs.getString("address");
                Customer c=new Customer(cid,name,surname,email,phone,address);
                ls0.add(c);
            }
            //rs yi bu local alanda bir kere tüketebilir.
        }catch (Exception e){
            System.out.println("customerList Error : "+e);
        }
        finally {
            db.close();
        }
        return ls0;
    }

    @Override
    public DefaultTableModel customerTable() {
        ls=lsSearch;
        //en başta bir column isimleri oluşturulması gerekiyor.
        DefaultTableModel md = new DefaultTableModel();
        md.addColumn("cid");
        md.addColumn("Name");
        md.addColumn("Surname");
        md.addColumn("Email");
        md.addColumn("Phone");
        md.addColumn("Address");

        //1.ilkönce ne istendiğine gore konum al
        //List<Customer> ls = serviceCustomerList(); //burasını constructora atalım conn azalatmaka için
        /*if (data != null && !data.equals("")) {//arama sonuclarını gonder
            List<Customer> subLs = new ArrayList<>();
            for (Customer item : ls) {
                if (item.getName().toLowerCase(Locale.ROOT).contains(data)
                        || item.getSurname().toLowerCase(Locale.ROOT).contains(data)
                        || item.getEmail().toLowerCase(Locale.ROOT).contains(data)
                        || item.getPhone().toLowerCase(Locale.ROOT).contains(data)
                        || item.getAddress().toLowerCase(Locale.ROOT).contains(data)) {
                    subLs.add(item);
                }
            }
            ls = subLs;
        }*/
        for (Customer item : ls) {
            Object[] row = {item.getCid(), item.getName(), item.getSurname(), item.getEmail(), item.getPhone(), item.getAddress()};
            md.addRow(row);
        }
        return md;
    }
}
