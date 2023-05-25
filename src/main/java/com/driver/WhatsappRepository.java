package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private HashMap<String,User> userHashMap;
    private HashMap<Group, List<User>> groupUserMap;
    private HashMap<Group, List<Message>> groupMessageMap;
    private HashMap<Message, User> senderMap;
    private HashMap<Group, User> adminMap;
    private HashSet<String> userMobile;
    private int customGroupCount;
    private int messageId;

    public WhatsappRepository(){
        
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<>();
        this.customGroupCount = 0;
        this.messageId = 0;
    }

    public void createUser(String name, String mobile) {
        User user=new User(name,mobile);
        userHashMap.put(mobile,user);
        userMobile.add(mobile);
    }

    public boolean getByMobile(String mobile) {
        return userMobile.contains(mobile);
    }

    public void createGroup(List<User> users, Group group) {
        groupUserMap.put(group,users);
    }

    public int getGroupCount() {
        this.customGroupCount++;
        return customGroupCount;
    }

    public int getMessegeCount() {
        this.messageId++;
        return messageId;
    }

    public Boolean getGroupById(Group group) {
        return groupUserMap.containsKey(group);
    }

    public Boolean checkGroupMember(Group group, User sender) {
        return groupUserMap.get(group).contains(sender);
    }

    public int sendMessage(Group group, User sender, Message message) {

        return 3;
    }
}
