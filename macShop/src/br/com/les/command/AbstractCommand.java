package br.com.les.command;


import br.com.les.facade.Fachada;
import br.com.les.facade.IFachada;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
}
