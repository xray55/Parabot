package com.company;

import org.parabot.core.asm.wrappers.Interface;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.*;

import java.util.ArrayList;

import static org.rev317.min.api.methods.Menu.*;

@ScriptManifest(author = "Blade", category = Category.FISHING, description = "123", name = "Herefishyfishy", servers = { "2006Scape" }, version = 1)
public class Sharkfisher extends Script {
    public ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private static final int[] Shark_ID = {384};
    private static final int[] SharkSpot = {313, 314};
   public  final  Tile[] BankSpot ={new Tile(2596,3420) ,new Tile(2586, 3418)};
   TilePath path2 = new TilePath((BankSpot));
   public final Tile[] Sharkspot1 = { new Tile(2596,3420) , new Tile(2602, 3420)};
    TilePath path = new TilePath(Sharkspot1);
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

            //Check if we need to chop the tree
            return true;
        }


        private SceneObject bank() {
            if (Players.getMyPlayer().getAnimation() != 618 && !Players.getMyPlayer().isInCombat() && Inventory.isFull()) {
                path2.traverse();
                path2.getNextTile();
                path2.hasReached();
                Time.sleep(2500);
                for (SceneObject Bank_booth : SceneObjects.getNearest(2213)) {
                        Bank_booth.interact(1);
                        Bank.depositAllExcept(312);
                    Bank.close();
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
            if(Players.getMyPlayer().getAnimation() != 618 &&!Inventory.isFull()){
                System.out.println("Scripting starting");
                Time.sleep(2500);
                path.traverse();
               path.getNextTile();
               path.hasReached();
                Time.sleep(2500);
            System.out.println("On the money");
                Npcs.getNearest(314);
                Time.sleep(60000);

            }else{
                if(Players.getMyPlayer().getAnimation() == 618)
                    Time.sleep(75000);
            }

            // Players.getMyPlayer().interact(Menu.ACTION_CLICK_BUTTON);
            if(Players.getMyPlayer().getAnimation()!=618 &&Inventory.isFull()){
                bank = bank();
            }


        }

        //tree.interact(Menu.);


        private boolean FISHS_ID() {
            if (Players.getMyPlayer().getAnimation() != 618 && !Players.getMyPlayer().isInCombat() && !Inventory.isFull()) {
                for (Npc FISHS_ID : Npcs.getNearest(SharkSpot)) {
                    path.traverse();
                    path.getNextTile();
                    path.hasReached();
                    FISHS_ID.interact(2);
                    Time.sleep(60000);
                }
            }
            return true;
        }
    }
}



