/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Melvrick Goh
 */
public class SystemUserDAO {
    private String realAddress;
    private File usersFile;
    private List userList;
    
    public SystemUserDAO (String dataAddress){
        realAddress = dataAddress;
        usersFile = new File(realAddress);
        userList = new ArrayList();
        readUserListFile();
    }
    
    public List getUserList(){
        return userList;
    }
    
    public User addUser(User user){
        userList.add(user);
        appendToFile(user);
        return user;
    }
    
    public void readUserListFile(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(usersFile));
            String line;
            
            //Read every user entry in file
            while (((line = reader.readLine())!= null)){
                String[] elements = line.split("\\|");
                String username = elements[0];
                String password = elements[1];
                String email = elements[2];
                String firstName = elements[3];
                String lastName = elements[4];
                String dob = elements[5];
                String address = elements[6];
                
                String[] date = dob.split("/");
                int day = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);
                int[] dateOfBirth = {day,month,year};
                
                User user = new User(firstName,lastName,username,password,dateOfBirth,address,email);
                userList.add(user);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (reader!=null){
                try { reader.close(); } catch (Exception e) {}
            }
        }
    }
    
    private void appendToFile(User user){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(usersFile,true));
            writer.print(user.getUsername());
            writer.print("|"+user.getPassword());
            writer.print("|"+user.getEmail());
            writer.print("|"+user.getFirstName());
            writer.print("|"+user.getLastName()+"|");
            int[] date = user.getDateOfBirth();
            for(int i=0;i<date.length;i++){
                if (i!=date.length-1){
                    writer.print(date[i]+"/");
                }else{
                    writer.print(date[i]);
                }
            }
            writer.println("|"+user.getAddress());
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (writer!=null){
                try{
                    writer.close();
                }catch(Exception e){}
            }
        }
    }
}
