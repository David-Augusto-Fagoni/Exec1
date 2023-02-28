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
	
	public void ip(String os)
	{

		if(os.contains("Linux"))
		{
			String Processo = "ifconfig";
			try {
				Process p =	Runtime.getRuntime().exec(Processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null)
				{
					String [] VtIp = linha.split(" netmask");
					String [] VtNome = linha.split(" mtu ");
					
					linha = buffer.readLine();
					int Ip = VtIp.length;
					int Nome = VtNome.length;
					if (Nome == 2)
					{
						System.out.print(VtNome[0]);
						System.out.println(VtNome[1]);
					}
					if (Ip > 1)
						
					{
						
						System.out.println(VtIp[0]);
					}
				}
			}
			catch (IOException e) 
			{
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
	
	public void ping(String os)
	{
		if(os.contains("Linux"))
		{
			String Processo = "ping -c 10 www.google.com.br";
			try 
			{
				Process p =	Runtime.getRuntime().exec(Processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null)
				{
					String [] VtMed = linha.split("/");	
					String [] VtMsg = linha.split("=");
					linha = buffer.readLine();
					int Med = VtMed.length;
					int Msg = VtMsg.length;
					if (Msg == 3)
					{
						System.out.println(linha);
					}
					if (Med > 2)
					{
						System.out.println(VtMed[1]+" = "+VtMed[5]+"ms");
					}

				}
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			String Processo = "PING -4 -n 10 www.google.com.br";
			
			try 
			{
				Process p =	Runtime.getRuntime().exec(Processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null)
				{
					String [] VtMed = linha.split("s, ");
					String [] VtResp = linha.split("Resposta ");
					linha = buffer.readLine();
					int Med = VtMed.length;
					int Resp = VtResp.length;
					if (Resp > 1)
					{
						System.out.println("Resposta "+VtResp[1]);
					}
					if (Med > 2)
					{
						System.out.println(VtMed[2]);
					}
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
				
