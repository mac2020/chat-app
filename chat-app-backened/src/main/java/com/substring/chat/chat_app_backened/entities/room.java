package com.substring.chat.chat_app_backened.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class room {
    @Id
    private String id;  // Mongodb unique identifier just like we have primary key in mysql.
    private String roomid;

    List<Message> messages=new ArrayList<>();

    public List<Message> getMessages() {
        return messages;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }


}
