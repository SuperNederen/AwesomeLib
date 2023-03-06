package org.supernederen.awesomelib.library.command;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * CommandResult is a class that is used to return the result of a sub command execution.
 * It contains the sub command that was executed and the result of the execution.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author PandaPeter
 * @since 1.2.0
 */
public class CommandResult {

    public enum Result {
        NO_SUB_COMMAND_FOUND,
        NO_PERMISSION,
        WRONG_USAGE,
        SUCCESS,
    }

    private final SubCommand command;
    private final Result result;

    private CommandResult(SubCommand command, Result result) {
        this.command = command;
        this.result = result;
    }

    /**
     * Returns the command that was executed.
     *
     * @return The command that was executed.
     */
    public SubCommand getCommand() {
        return this.command;
    }

    /**
     * Returns the result of the command execution.
     *
     * @return The result of the command execution.
     */
    public Result getResult() {
        return this.result;
    }

    /**
     * Returns a CommandResult with the result {@link Result#NO_SUB_COMMAND_FOUND}.
     *
     * @return The CommandResult.
     */
    @Contract(value = " -> new", pure = true)
    public static @NotNull CommandResult noSubCommandFound() {
        return new CommandResult(null, Result.NO_SUB_COMMAND_FOUND);
    }

    /**
     * Returns a CommandResult with the result {@link Result#NO_PERMISSION}.
     *
     * @param command The command that was executed.
     * @return The CommandResult.
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull CommandResult noPermission(SubCommand command) {
        return new CommandResult(command, Result.NO_PERMISSION);
    }

    /**
     * Returns a CommandResult with the result {@link Result#WRONG_USAGE}.
     *
     * @param command The command that was executed.
     * @return The CommandResult.
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull CommandResult wrongUsage(SubCommand command) {
        return new CommandResult(command, Result.WRONG_USAGE);
    }

    /**
     * Returns a CommandResult with the result {@link Result#SUCCESS}.
     *
     * @param command The command that was executed.
     * @return The CommandResult.
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull CommandResult success(SubCommand command) {
        return new CommandResult(command, Result.SUCCESS);
    }
}

