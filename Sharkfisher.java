package com.company;

import org.parabot.core.asm.wrappers.Interface;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

import java.util.ArrayList;

import static org.rev317.min.api.methods.Menu.*;

@ScriptManifest(author = "Blade", category = Category.FISHING, description = "123", name = "Herefishyfishy", servers = { "2006Scape" }, version = 1)
public class Sharkfisher extends Script {
    public ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private static final int[] Shark_ID = {384};
    private static final int[] SharkSpot = {313, 314};

    @Override
    public boolean onExecute() {
        strategies.add(new Fishing());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {
        System.out.println("Script Stopped");
    }

    private class Fishing implements Strategy {

        // local variable to store the tree.
        boolean FISHS_ID;
   
    SceneObject bank;
        @Override
        public boolean activate() {
            FISHS_ID = FISHS_ID(); // set the local Variable
        bank = bank();
            //Check if we need to chop the tree
            return true;
        }

        private SceneObject bank() {
            for (SceneObject Bank_booth : SceneObjects.getNearest(2213)) {
                Bank_booth.interact(502);
                if (Players.getMyPlayer().getAnimation() != 618 && !Players.getMyPlayer().isInCombat() && Inventory.isFull()) {
                    Walking.getNearestTileTo(new Tile(2586, 3418));
                    Bank_booth.interact(502);
                    Bank.depositAllExcept(312);
                    Time.sleep(1500);
                    if (Inventory.containts(312) && !Inventory.containts(384)) {
                        Walking.getNearestTileTo(new Tile(2602, 3420));
                        Time.sleep(10000);
                    }

                }
            }
            return bank;
        }


        @Override
        public void execute() {
            System.out.println("Scripting starting");
            if(Players.getMyPlayer().getAnimation() != 622 &&!Inventory.isFull()){
                Walking.getNearestTileTo(new Tile(2602, 3420));
            System.out.println("On the money");
                Npcs.getNearest(314);

                // SceneObjects.getNearest(315,316);

                Time.sleep(60000);

            }else{
                if(Players.getMyPlayer().getAnimation() == 618)
                    Time.sleep(75000);
            }
            // Players.getMyPlayer().interact(Menu.ACTION_CLICK_BUTTON);


        }

        //tree.interact(Menu.);


        private boolean FISHS_ID() {
            for (Npc FISHS_ID : Npcs.getNearest(SharkSpot)) {
                if (Players.getMyPlayer().getAnimation() != 618 && !Players.getMyPlayer().isInCombat() && !Inventory.isFull()) {
                    Walking.getNearestTileTo(new Tile(2602, 3420));
                    FISHS_ID.interact(2);
                    Time.sleep(60000);
                }
            }
            return true;
        }
    }
}



