package td1.view;

import td1.model.creature.Creature;
import td1.model.enclosure.AbstractEnclosure;
import td1.model.enclosure.Aquarium;
import td1.model.enclosure.Aviary;
import td1.model.fantasticZoo.FantasticZoo;

public class ZooView {
    private static ZooView instance;
    public static ZooView getInstance(){
        if (instance == null){
            instance = new ZooView();
        }
        return instance;
    }
    public void showOneEnclosure(AbstractEnclosure<?> enclosure, int enclosureNumber){
        String topAndBottomSide = "";
        switch ((String) enclosure.getType()){
            case "Runner" -> topAndBottomSide = "--------------- ";
            case "Swimmer" -> topAndBottomSide = "~~~~~~~~~~~~~~ ";
            case "Flyer" -> topAndBottomSide = "ooooooooooooooo ";
        }
        String text = "" + topAndBottomSide;
        String blankLine = "|           |\n";
        if(enclosureNumber>=10){
            String numberLine = "|     "+enclosureNumber+"    |\n";
        }
        String numberLine = "|     "+enclosureNumber+"     |\n";
        text+= blankLine + blankLine + numberLine + blankLine + blankLine + topAndBottomSide;
        System.out.println(text);
    }
    public void showAllEnclosure(FantasticZoo zoo){
        int sizeOfListEnclosure = zoo.getEnclosureList().size();
        int numberOfEnclosure = 1;
        String stringUpDown = "";
        String stringSide = "";
        String stringMid = "";
        for (AbstractEnclosure<?> enclosure : zoo.getEnclosureList()){
            stringSide += "|             | ";
            if (numberOfEnclosure<10){
                stringMid += "|      "+numberOfEnclosure+"      | ";
            }
            else{
                stringMid += "|     "+numberOfEnclosure+"      | ";
            }
            if (enclosure.getClass() == Aquarium.class){
                stringUpDown += "~~~~~~~~~~~~~~~ ";
            }
            else if (enclosure.getClass() == Aviary.class){
                stringUpDown += "ooooooooooooooo ";
            }
            else{
                stringUpDown += "--------------- ";
            }
            if (numberOfEnclosure%5 == 0 || numberOfEnclosure == sizeOfListEnclosure){
                System.out.println(stringUpDown);
                System.out.println(stringSide);
                System.out.println(stringMid);
                System.out.println(stringSide);
                System.out.println(stringUpDown);
                stringUpDown = "";
                stringMid = "";
                stringSide = "";
            }
            ++numberOfEnclosure;
        }
    }

    public void showAllCreatures(FantasticZoo zoo) {
        for (AbstractEnclosure<?> abstractEnclosure : zoo.getEnclosureList()){
            for (Creature creature : abstractEnclosure.getCreatureList()){
                creature.shortToString();
            }
        }
    }
    public void showNumberTotalOfCreature(FantasticZoo zoo){
        int count = 0;
        for (AbstractEnclosure<?> abstractEnclosure : zoo.getEnclosureList()) {
            count += abstractEnclosure.getCreatureList().size();
        }
        System.out.println("There is a total die " + count + " in the zooFantastic");
    }
}
