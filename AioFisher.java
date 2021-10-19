package com.company;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.Npc;

import java.util.ArrayList;
@ScriptManifest(author = "Blade", category = Category.FISHING, description = "Fishes stuff", name = "AioFisher", servers = { "2006Scape" }, version = 1)

public class AioFisher extends Script {

    public ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private static final int[] FISH_ID = {336,332};
    public static final int[] FISHS_ID = {317,316,315};
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

        if(Players.getMyPlayer().getAnimation() != 622 &&!Inventory.isFull()){
            Npcs.getNearest(328,329);
           // SceneObjects.getNearest(315,316);
            Players.getMyPlayer().interact(Menu.ACTION_CLICK_BUTTON);
            Time.sleep(60000);

        }else{
            if(Players.getMyPlayer().getAnimation() == 621)
                Time.sleep(75000);
        }

        //tree.interact(Menu.);
        //Wait for the Player to chop the Tree
        Time.sleep(() -> Players.getMyPlayer().getAnimation() == -1, 3000);
    }
}
    private boolean FISHS_ID() {
        for (Npc FISHS_ID : Npcs.getNearest(328, 329)) {
            if (Players.getMyPlayer().getAnimation() != 622 && !Players.getMyPlayer().isInCombat() && !Inventory.isFull()) {
                FISHS_ID.interact(0);
                Time.sleep(60000);
            }

        }
        return true;
    }

            //Check if the Object is around.
          //  if (FISHS_ID != null) {
                //Return the Tree Object.
            //    return FISHS_ID();
            //}



private static class Drop implements Strategy {


    @Override
    public boolean activate() {

        if(Inventory.isFull() &Inventory.containts(FISH_ID));{

        }
        return true;

    }

    @Override
    public void execute() {
        // Loop through all Inventory Items and Drop the once with Log ID.
        for (Item fish : Inventory.getItems(FISH_ID)) {
            //Check if Log Exists
            if (fish != null) {
                Inventory.getItems(FISH_ID);//Drop the Log.

                fish.drop();

                //Using a Static Sleep here for Tutorial sake, You can use a Dynamic one.
                Time.sleep(1000);
            }
        }
    }
}
    private static class Banking implements Strategy{

        @Override
        public boolean activate() {
           if(Inventory.isFull()&&Players.getMyPlayer().getAnimation()!=621);
            return false;
        }

        @Override
        public void execute() {
            Bank.getBanker().interact(0);
                if(Bank.open()){
                    Bank.depositAllExcept(304);
                    Bank.close();
                }

            }
        }


}


