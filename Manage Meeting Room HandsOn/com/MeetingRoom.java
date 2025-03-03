package com;
import java.util.*;

class MeetingRoom {
    String id;
    String name;
    int size;
    EnumSet<RoomFeature> features;

    MeetingRoom(String id, String name, int size, EnumSet<RoomFeature> features) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.features = features;
    }
}
