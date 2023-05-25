package com.driver;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class WhatsappService {
    WhatsappRepository whatsappRepository=new WhatsappRepository();
    public String createUser(String name, String mobile) throws Exception {
        boolean flag1=whatsappRepository.getByMobile(mobile);
        if(!flag1){
            throw new Exception("User already exists");
        }
        whatsappRepository.createUser(name,mobile);
        return "SUCCESS";
    }

    public Group createGroup(List<User> users) {
        if(users.size()==2){
            Group group=new Group(users.get(1).getName(),2);
            whatsappRepository.createGroup(users,group);
            return group;
        }
        int p=whatsappRepository.getGroupCount();
        Group group=new Group("Group "+p,users.size());
        whatsappRepository.createGroup(users,group);
        return group;
    }

    public int createMessage(String content) {
        return whatsappRepository.getMessegeCount();
    }

    public int sendMessage(Message message, User sender, Group group) throws Exception {
        Boolean flag2 =whatsappRepository.getGroupById(group);
        if(!flag2){
            throw new Exception("Group does not exist");
        }
        Boolean flag3=whatsappRepository.checkGroupMember(group,sender);
        if(!flag3){
            throw new Exception("You are not allowed to send message");
        }
        return whatsappRepository.sendMessage(group,sender,message);
    }
}
