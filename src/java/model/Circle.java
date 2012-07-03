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
public class Circle {
    private ArrayList<User> circleFriends;
    private String circleName;
    private String username;

    public Circle(String circleName, String username) {
        this.circleName = circleName;
        this.username = username;
        circleFriends = new ArrayList<User>();
    }

    public ArrayList<User> getCircleFriends() {
        return circleFriends;
    }

    public void setCircleFriends(ArrayList<User> circleFriends) {
        this.circleFriends = circleFriends;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getUsername() {
        return username;
    }
    
    public void addFriend(User user){
        circleFriends.add(user);
    }
    
    public void removeFriend(User user){
        for (User u: circleFriends){
            if (u.getUsername().equals(user.getUsername())){
                circleFriends.remove(u);
                break;
            }
        }
    }
}
