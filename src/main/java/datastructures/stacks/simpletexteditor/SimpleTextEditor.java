package datastructures.stacks.simpletexteditor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
            int n = Integer.parseInt(scanner.nextLine());

            OperationExecutor operationExecutor = new OperationExecutor("");
            while (n-- > 0) {
                String query = scanner.nextLine();
                String[] array = query.split("\\s+");

                int code = -1;
                try {
                    code = Integer.parseInt(array[0]);
                } catch (NumberFormatException ex) {
                    // ignore;
                }
                OperationType operation = OperationType.getOperationType(code);

                switch (operation) {
                    case APPEND:
                        String stringToAppend = array[1];
                        operationExecutor.executeOperation(new AppendOperation(stringToAppend));
                        break;
                    case DELETE:
                        int count = Integer.parseInt(array[1]);
                        operationExecutor.executeOperation(new DeleteOperation(count));
                        break;
                    case PRINT:
                        int index = Integer.parseInt(array[1]);
                        operationExecutor.executeOperation(new PrintOperation(index));
                        break;
                    case UNDO:
                        operationExecutor.executeUndo();
                        break;
                    default:
                        System.out.println("Unknown operation!");
                }
            }
        }
    }
}
