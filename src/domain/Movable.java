package domain;

import java.util.ArrayList;

public interface Movable {
    ArrayList<Square> getPotentialMoves(Square s);
}
