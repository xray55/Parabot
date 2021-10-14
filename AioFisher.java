package com.company;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Item;

import java.util.ArrayList;
@ScriptManifest(author = "Blade", category = Category.FISHING, description = "Fishes stuff", name = "AioFisher", servers = { "2006Scape" }, version = 1)

public class AioFisher extends Script {

    public ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private static final int[] FISH_ID = {317,318};
    private static final int[] FISHS_ID = {317,316,315};
    @Override
    public boolean onExecute() {
        strategies.add(new Fishing());
        strategies.add(new Drop());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {

    }
private class Fishing implements Strategy {

    boolean FISHS_ID; // local variable to store the tree.

    @Override
    public boolean activate() {
        FISHS_ID = FISHS_ID(); // set the local Variable
        //Check if we need to chop the tree
        return !Inventory.isFull() && Players.getMyPlayer().getAnimation() == -1; //&& FISHS_ID != null;
    }
    @Override
    public void execute() {
        //Chop the tree

        if(Players.getMyPlayer().getAnimation() != 621){
            Npcs.getNearest(315,316,317);

           // SceneObjects.getNearest(315,316);
            Players.getMyPlayer().interact(Menu.ACTION_CLICK_BUTTON);
            Time.sleep(15000);

        }else{
            if(Players.getMyPlayer().getAnimation() == 621)
                Time.sleep(5000);
        }

        //tree.interact(Menu.);
        //Wait for the Player to chop the Tree
        Time.sleep(() -> Players.getMyPlayer().getAnimation() == -1, 3000);
    }
}
    private boolean FISHS_ID() {
        if(Players.getMyPlayer().getAnimation()!= 621 && !Players.getMyPlayer().isInCombat()){
            Npcs.getClosest(FISHS_ID);
            Players.getMyPlayer().interact(317);
            Time.sleep(15000);
        }

         if(FISHS_ID == null) {
            ;
        }
            //Check if the Object is around.
          //  if (FISHS_ID != null) {
                //Return the Tree Object.
            //    return FISHS_ID();
            //}
        return FISHS_ID();
    }
private static class Drop implements Strategy {


    @Override
    public boolean activate() {

        return true;
    }

    @Override
    public void execute() {
        // Loop through all Inventory Items and Drop the once with Log ID.
        for (Item fish : Inventory.getItems(FISH_ID)) {
            //Check if Log Exists
            if (fish != null) {
                //Drop the Log.
                fish.drop();
                //Using a Static Sleep here for Tutorial sake, You can use a Dynamic one.
                Time.sleep(1000);
            }
        }
    }
}

}

