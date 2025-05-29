package com.substring.chat.chat_app_backened.controllers;

import com.substring.chat.chat_app_backened.entities.Message;
import com.substring.chat.chat_app_backened.entities.room;
import com.substring.chat.chat_app_backened.repositiries.RoomRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    // create room
private RoomRepo roomrepo;
public RoomController(RoomRepo roomrepo) {
    this.roomrepo = roomrepo;
}
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
        if (roomrepo.findByRoomid(roomId) != null) {
            // room is already there
            return ResponseEntity.badRequest().body("room already exist");
        }

        // create new room
        room r = new room();
        r.setRoomid(roomId);
        room savedroom = roomrepo.save(r);
        return ResponseEntity.status(HttpStatus.CREATED).body(r);
    }



    // get room : trying to join room
    @GetMapping("/{roomId}")
        public ResponseEntity<?> joinRoom(
                @PathVariable String roomId
    )    {

        room r= roomrepo.findByRoomid(roomId);

        if(r==null) {
            return ResponseEntity.badRequest()
                    .body("room not found");
        }
            return ResponseEntity.ok(r);

    }
    // firstly we will check whether room exist or not



    // get messages of room

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getmessages(
            @PathVariable String roomId,
            @RequestParam(value="Page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "Size", defaultValue ="20", required=false ) int size
    ) {

        room r = roomrepo.findByRoomid(roomId);
        if (r == null) {
            return ResponseEntity.badRequest().build()
                    ;
        }

        List<Message> messages=r.getMessages();
        return ResponseEntity.ok(messages);



    }




}
