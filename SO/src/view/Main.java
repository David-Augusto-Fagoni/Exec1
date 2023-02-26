package view;

import controller.RedesController;

public class Main {

	public static void main (String[] args)
	{
		RedesController Rede = new RedesController();
		String os = Rede.Os();
		System.out.println(os);
	}
}
