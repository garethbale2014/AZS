package de.rs.test.prototype.mail;

/**
 * Interface defining the application's command IDs.
 * Key bindings can be defined for specific commands.
 * To associate an action with a command, use IAction.setActionDefinitionId(commandId).
 *
 * @see org.eclipse.jface.action.IAction#setActionDefinitionId(String)
 */
public interface ICommandIds {

    public static final String CMD_OPEN = "de.rs.test.prototype.mail.open";
    public static final String CMD_OPEN_MESSAGE = "de.rs.test.prototype.mail.openMessage";
    public static final String CMD_CREATE_AZS = "de.rs.test.prototype.firdaous.create.azs";
    
}
