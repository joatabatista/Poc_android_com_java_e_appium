package br.com.yaman.poc;

import java.net.MalformedURLException;

public class Run {
	public static void main(String[] args) throws Exception {
		Cadastro cadastro = new Cadastro();
		Login login = new Login();
		
		login.Login("C:/Users/joata.magalhaes/Downloads/Joata/apk/KMDEVANTAGENS_HOMOLOG.apk");
		cadastro.Cadastro("C:/Users/joata.magalhaes/Downloads/Joata/apk/KMDEVANTAGENS_HOMOLOG.apk");
	}
}
