package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController 
{

	public RedesController() 
	{
		super();
	}
	public String Os()
	{
		String os = System.getProperty("os.name");
		return os;
	}
	
	public static void ip(String os)
	{

		if(os.contains("Linux"))
		{
			String Processo = "IFCONFIG";
			try {
				Process p =	Runtime.getRuntime().exec(Processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null)
				{
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			String Processo = "IPCONFIG";
			try 
			{
				Process p =	Runtime.getRuntime().exec(Processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null)
				{
					String [] VtIp = linha.split("IPv4.");
					String [] VtNm = linha.split("Adaptador");
					int ip = VtIp.length;
					int Nm = VtNm.length;
					if (ip == 2 || Nm ==2)
					{
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}

			} 
			catch (IOException e) 
			{
			String MsgErro = e.getMessage();
				if(MsgErro.contains("740"))
				{
					StringBuffer buffer = new StringBuffer();
					buffer.append("cmd /c ");
					buffer.append(Processo);
				}
			}
			
			
		}
		
	}
	
	public static void ping()
	{
		
	}
	
	
	
	

	
}
