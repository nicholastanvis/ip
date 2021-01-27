import java.util.Arrays;

public class Parser {
    public static Command parse(String[] input) {
        String command = input[0];
        String[] args = Arrays.copyOfRange(input, 1, input.length);

        if (command.equals("bye")) {
            return new Command(CommandType.TERMINATE);
        } else if (command.equals("list")) {
            return new Command(CommandType.LIST_TASKS);
        } else if (command.equals("done")) {
            return new Command(CommandType.COMPLETE_TASK, args[0]);
        } else if (command.equals("find")) {
            String xs = String.join(" ", args);
            return new Command(CommandType.FIND_TASKS, xs);
        } else if (command.equals("todo")) {
            String xs = String.join(" ", args);
            return new Command(CommandType.ADD_TODO, xs);
        } else if (command.equals("deadline")) {
            String xs = String.join(" ", args);
            args = xs.split(" /by ");
            return new Command(CommandType.ADD_DEADLINE, args[0], args[1]);
        } else if (command.equals("event")) {
            String xs = String.join(" ", args);
            args = xs.split(" /at ");
            return new Command(CommandType.ADD_EVENT, args[0], args[1]);
        } else if (command.equals("delete")) {
            return new Command(CommandType.DELETE_TASK, args[0]);
        } else {
            return new Command(CommandType.UNKNOWN);
        }
    }
}