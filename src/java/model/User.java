/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Melvrick Goh
 */
public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int[] dateOfBirth;
    private String address;
    private ArrayList<Circle> circles;
    
    //1st time registration of user
    public User(String firstName, String lastName, String username, String password, int[] dateOfBirth, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.circles = new ArrayList<Circle>();
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int[] dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }
    
    public void addCircles(Circle circle){
        circles.add(circle);
    }
    
    public void removeCircle(Circle circle){
        for (Circle c:circles){
            if (c.getCircleName().equals(circle.getCircleName())){
                circles.remove(c);
                break;
            }
        }
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}