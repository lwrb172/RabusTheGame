package org.example.gameManagement;

import org.example.actions.*;
import org.example.entities.Player;
import org.example.events.Event;
import org.example.events.RobberyEvent;
import org.example.frames.Frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private final Map<String, Location> locations;
    private final List<Event> events;
    private Location currentLocation;
    private final Frame frame;

    public World(Frame frame) {
        locations = new HashMap<>();
        events = new ArrayList<>();
        this.frame = frame;
        initWorld();
        initEvents();
    }

    private void initWorld() {
        Location mainRoom = new Location("Main Room", "Your home.");
        Location kitchen = new Location("Kitchen", "Place where you can eat.");
        Location bathroom = new Location("Bathroom", "Place where you can wash yourself.");
        Location shop = new Location("Shop", "This is Shop. You can buy items here.");
        Location park = new Location("Park", "Good place to relax.");

        locations.put("main room", mainRoom);
        locations.put("kitchen", kitchen);
        locations.put("bathroom", bathroom);
        locations.put("shop", shop);
        locations.put("park", park);

        mainRoom.addAction(new SleepAction());
        mainRoom.addAction(new ChooseJob());
        mainRoom.addAction(new WorkAction());
        shop.addAction(new BuyFoodAction());
        shop.addAction(new BuyFurnitureAction(frame));
        kitchen.addAction(new EatAction());
        bathroom.addAction(new WashAction());
        park.addAction(new PlayPetAction(frame));

        currentLocation = mainRoom;
    }

    private void initEvents() {
        events.add(new RobberyEvent(frame));
    }

    public void checkEvents(Player player, TimeManager time) {
        for (Event event : events) {
            if (event.timeTrigger(time)) {
                if (currentLocation.getName().equals("Main Room") && !(player.getGameOver())) {
                    event.trigger(player);
                }
            }
        }
    }

    public boolean moveToLocation(String locationName) {
        Location newLocation = locations.get(locationName.toLowerCase());
        if (newLocation != null) {
            currentLocation = newLocation;
            return true;
        }
        return false;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public List<Location> getAllLocations() {
        return new ArrayList<>(locations.values());
    }
}
