package combat;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.*;

import javax.crypto.spec.IvParameterSpec;
import java.util.ArrayList;

@ScriptManifest(author = "Blade", category = Category.COMBAT, description = "Kills Chicken", name = "Chicken Killer", servers = { "2006Scape" }, version = 1)
public class Chickenkiller extends Script {
    public ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private final int[] Feather_ID = {314,315};
    private final int[] Bone = {526, 527};
    private final int[] Shark = {343};
    public final Tile[] BankSpot = {new Tile(2596, 3420), new Tile(2586, 3418)};
    TilePath path2 = new TilePath((BankSpot));
    public final Tile[] Sharkspot1 = {new Tile(2596, 3420), new Tile(2602, 3420)};
    TilePath path = new TilePath(Sharkspot1);

    @Override
    public boolean onExecute() {
        strategies.add(new Attack());
        // strategies.add(new Eat());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {

    }

    private class Attack implements Strategy {

        boolean Chickens;
        boolean Feather;

        @Override
        public boolean activate() {
            if(Players.getMyPlayer().getAnimation() != 451){
                Feather = Feather();
                Time.sleep(1000);
                } else {
                    if(Players.getMyPlayer().isInCombat()){
                        Time.sleep(2500);
                    } else {
                        if(!Players.getMyPlayer().isInCombat() && Players.getMyPlayer().getAnimation()== -1){
                            Chickens = Chickens();
                        }
                    }
                } return Feather() && Chickens();
            }


        private boolean Chickens() {
            for (Npc Chickens : Npcs.getNearest(41, 42)) {
                if (Chickens != null && Players.getMyPlayer().getAnimation() != -412 && Chickens.distanceTo() <= 1) {
                    Chickens.interact(Npcs.Option.ATTACK);
                    Time.sleep(8000);
                }
            }
            return !Players.getMyPlayer().isInCombat() && Players.getMyPlayer().getAnimation() == -1;
        }

        private boolean Feather() {
            //int Feather =314;
            for (GroundItem Feather : GroundItems.getNearest(Feather_ID)) {
                if(Feather != null){
                    Feather.take();
                    Time.sleep(1500);
                }

                for (GroundItem Bones : GroundItems.getNearest(Bone)) {
                    if (Bones != null && !Inventory.isFull()) {
                        Bones.take();
                        Time.sleep(1500);
                    }
                    for (Item Bones1 : Inventory.getItems(Bone)) {
                        if (Bones1 != null) { //checks to see if bone is in inventory and makes sure the inventory is full before burying
                            Bones1.interact(Items.Option.SECOND); // burys bone
                            Time.sleep(1500);
                        }
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override
        public void execute() {

        }

        private class Eat implements Strategy {
            boolean bank;

            @Override
            public boolean activate() {

                return false;//Players.getMyPlayer().getHealth()<=50;
            }

            @Override
            public void execute() {
                if (Players.getMyPlayer().getHealth() <= 50) {
                    for (Item Shark : Inventory.getItems(Shark)) {
                        if (Shark != null && Players.getMyPlayer().getHealth() <= 50) {
                            Shark.interact(Items.Option.CONSUME);
                        } else {
                            if (Shark == null) {
                                // bank=bank();
                            }
                        }
                    }
                }
            }
            //  private boolean bank() {
            //      if (!Players.getMyPlayer().isInCombat() && !Inventory.containts(Shark)) {
            //     path.traverse();
            //    Time.sleep(1250);
            //   path.getNextTile();
            //  Time.sleep(1250);
            //  path.hasReached();
            //  Time.sleep(1250);
            // for (SceneObject Bank_booth : SceneObjects.getNearest(2213)) {
            //    Time.sleep(1250);
            //   if(Bank_booth !=null && Players.getMyPlayer().distanceTo() < 4 )
            //      Bank_booth.interact(1);
            //  Time.sleep(1250);
            //  Bank.withdraw(384,28,1500);
            // Bank.close();
            //  if(Players.getMyPlayer().getAnimation() == -1 && Inventory.isFull() && Inventory.containts(Shark)){
            //      return true;
            //   } else {
            //       if (!Inventory.containts(Shark)){
            //         return bank;
            //      }
            //    }

            //   }
            //     }
            //   return false;
        }
    }
}
