package view;

import controller.RedesController;  
import javax.swing.JOptionPane;

public class Main {

	public static void main (String[] args)
	{
		RedesController Rede = new RedesController();
		String os = Rede.Os();
		
	
		int J=0;
		while (J!= 3)
		{
			J = Integer.parseInt(JOptionPane.showInputDialog("1- Chamar por IP \n2- Chamar por ping\n3- Sair "));
		
			switch(J)
			{
				case 1 -> Rede.ip(os);
				case 2 -> Rede.ping(os);
				case 3 -> JOptionPane.showMessageDialog(null, "Saindo");
				default -> JOptionPane.showMessageDialog(null, "numero invalido");
			}
		}
		
	}
}
