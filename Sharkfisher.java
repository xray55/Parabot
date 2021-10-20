package com.company;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.*;

import java.util.ArrayList;

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

    boolean bank;
        @Override
        public boolean activate() {
             // set the local Variable
                if(Players.getMyPlayer().getAnimation() != 618 && !Inventory.isFull()){
                    FISHS_ID = FISHS_ID();
                } else {
                    if(Players.getMyPlayer().getAnimation() == 618 && !Inventory.isFull()){
                        System.out.println("Waiting on Inventory to Fill up!");
                        Time.sleep(25000);
                    } else {
                        if(Players.getMyPlayer().getAnimation()==-1 && Inventory.isFull()){
                            bank = bank();
                        }
                    }
                }
            //Check if we need to chop the tree
            return true;
        }


        private boolean bank() {
            if (Players.getMyPlayer().getAnimation() != 618 && !Players.getMyPlayer().isInCombat() && Inventory.isFull()) {
                path2.traverse();
                path2.getNextTile();
                path2.hasReached();
                Time.sleep(2500);
                for (SceneObject Bank_booth : SceneObjects.getNearest(2213)) {
                       Time.sleep(2500);
                        Bank_booth.interact(1);
                        Time.sleep(2500);
                        Bank.depositAllExcept(312);
                        Time.sleep(2500);
                    Bank.close();
                    Time.sleep(1500);
                }
            }
            return Inventory.isFull();
        }


        @Override
        public void execute() {
            if(Players.getMyPlayer().getAnimation() != 618 &&!Inventory.isFull()){

                Time.sleep(2500);
                path.traverse();
               path.getNextTile();
               path.hasReached();
                Time.sleep(2500);

                Npcs.getNearest(314);
                Time.sleep(2000);
                System.out.println("Scripting starting");
            }else{
                if(Players.getMyPlayer().getAnimation() == 618)
                    System.out.println("On the money");
                Time.sleep(130000);
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



