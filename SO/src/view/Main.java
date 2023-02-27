package view;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {

	public static void main (String[] args)
	{
		RedesController Rede = new RedesController();
		String os = Rede.Os();
	
		int J;
		J = Integer.parseInt(JOptionPane.showInputDialog("1- Chamar por IP \n2- Chamar por ping "));
		
		switch(J)
		{
			case 1 -> Rede.ip(os);
			case 2 -> Rede.ping();
			default -> JOptionPane.showMessageDialog(null, "numero invalido");
		}
		
	}
}
