package br.gov.bnb.s095.lib.javatopython.lmconfig;

import junit.framework.TestCase;

public abstract class AutoDeployTest extends TestCase{
	
	public static final String FILE_NAME = "C:\\Projetos\\Arquitetura\\Jython\\S095-LMParser\\test\\s095-lista-materiais-teste.xml";
	
	public abstract void testExecutar();

}
