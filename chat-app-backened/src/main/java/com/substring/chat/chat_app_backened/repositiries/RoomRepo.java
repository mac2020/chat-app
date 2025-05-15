package com.substring.chat.chat_app_backened.repositiries;

import com.substring.chat.chat_app_backened.entities.room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepo extends MongoRepository<room, String>{
    // get room using roomid

    room findbyRoomid(String roomId);


}
