package learnjava.medium.comparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        int i = p2.score - p1.score;
        if (i != 0) {
            return i;
        }
        return p1.name.compareTo(p2.name);
    }
}
