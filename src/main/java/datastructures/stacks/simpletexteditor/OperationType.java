package datastructures.stacks.simpletexteditor;

public enum OperationType {
    APPEND,
    DELETE,
    PRINT,
    UNDO,
    UNKNOWN;

    public static OperationType getOperationType(int code) {
        switch (code) {
            case 1: return APPEND;
            case 2: return DELETE;
            case 3: return PRINT;
            case 4: return UNDO;
            default: return UNKNOWN;
        }
    }
}
