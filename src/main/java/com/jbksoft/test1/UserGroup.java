package com.jbksoft.test1;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    ArrayList<User> userList=new ArrayList<User>();
    UserGroup group;
    String serviceName;

    static List<String> isVisited = new ArrayList<String>(); // s1

    List<UserGroup> serviceDups = null; // this=s2; <s1>

    public UserGroup(String serviceName) {
        this.serviceName = serviceName;
    }

    public void addUser(User user){ // contract

       if(!isVisited.contains(serviceName)) {
            isVisited.add(serviceName);


            if (group != null) {
                 group.addUser(user);
                isVisited.clear();
            }


            userList.add(user);
        }
    }

    public void print(){
        for(int i=0;i<userList.size();i++){
            System.out.println(userList.get(i));
        }
    }


    public void register(UserGroup g){
      this.group=g;

    }

}