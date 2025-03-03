package com;
import java.util.*;

class RoomScheduler {
    Map<String, MeetingRoom> rooms = new HashMap<>();

    void addMeetingRoom(MeetingRoom room) {
        rooms.put(room.id, room);
        System.out.println("Room added: " + room.name + ", ID: " + room.id);
    }

    void bookRoom(String id, EnumSet<RoomFeature> needed) {
        MeetingRoom room = rooms.get(id);
        if (room != null && room.features.containsAll(needed)) {
            System.out.println("Room " + id + " booked successfully.");
        } else {
            System.out.println("Room " + id + " does not meet the requirements.");
        }
    }

    void listAvailableRooms(EnumSet<RoomFeature> needed) {
        List<String> available = new ArrayList<>();
        for (MeetingRoom room : rooms.values()) {
            if (room.features.containsAll(needed)) {
                available.add(room.name);
            }
        }
        System.out.println("Available rooms with " + needed + ": " + available);
    }
}
