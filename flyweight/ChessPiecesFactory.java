package flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessPiecesFactory {
    private static final Map<ChessType, ChessPiece> CHESS_MAP = new HashMap<>();

    static {
        CHESS_MAP.put(ChessType.WHITE, new WhiteChessPiece());
        CHESS_MAP.put(ChessType.BLACK, new BlackChessPiece());
    }

    public static ChessPiece getChessPiece(ChessType type) {
        return CHESS_MAP.get(type);
    }
}
