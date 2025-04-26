package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private Map<String, Location> locations;
    private Map<String, NPC> npcs;
    private List<Event> events;
    private Location currentLocation;

    public World() {
        locations = new HashMap<>();
        npcs = new HashMap<>();
        events = new ArrayList<>();
        initWorld();
        initEvents();
    }

    private void initWorld() {
        Location home = new Location("Home", "Your Home.");
        Location shop = new Location("Shop", "This is Shop. You can buy items here.");
        Location park = new Location("Park", "Good place to relax.");

        locations.put("home", home);
        locations.put("shop", shop);
        locations.put("park", park);

        home.addAction(new Action("Sleep", "Sleep for 8h", 0, 8 * 60));
        shop.addAction(new Action("Buy food", "Buy food for 20 coins", 10, 3));

        NPC helper = new NPC("helper", "This is a NPC. He will guide you and provide help trough your adventures.");
        NPC cashier = new NPC("Cashier", "shop cashier.");
        npcs.put("cashier", cashier);

        home.addNPC(helper);
        shop.addNPC(cashier);

        currentLocation = home;
    }

    private void initEvents() {
        events.add(new RobberyEvent());
    }

    public void checkEvents(Player player, TimeManager time) {
        for (Event event : events) {
            if (event.timeTrigger(time)) {
                event.trigger(player);
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

    public List<NPC> getCurrentNPCs(int currentHour) {
        List<NPC> presentNPCs = new ArrayList<>();

        for (NPC npc : npcs.values()) {
            if (npc.getCurrentLocation(currentHour).equals(currentLocation.getName().toLowerCase())) {
                presentNPCs.add(npc);
            }
        }
        return presentNPCs;
    }

    public String interactWithNPC(String npcName, String interactionType, int currentHour) {
        NPC npc = npcs.get(npcName.toLowerCase());
        if (npc != null && getCurrentNPCs(currentHour).contains(npc)) {
            return npc.interact(interactionType);
        }
        return "This person is not here!";
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public List<Location> getAllLocations() {
        return new ArrayList<>(locations.values());
    }


}
