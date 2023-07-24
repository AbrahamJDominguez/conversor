package com.conversor.conexion;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class scrapping {
	
	public scrapping(String divisa) throws IOException, conexionException, scrappingException {
		Connection.Response respuesta;
		
		
		respuesta = Jsoup.connect("https://www.google.com/finance/quote/MXN-"+ divisa ).timeout(10000).execute();
		if(respuesta.statusCode() == 200) {
			Document doc = Jsoup.connect("https://www.google.com/finance/quote/MXN-"+ divisa).get();
			
			try {
			Elements valor = doc.getElementsByClass("YMlKec fxKbKc");
			System.out.println(Float.parseFloat(valor.text()));}
			catch(Exception e) {
				throw new scrappingException("Error al recuperar datos");
			}
			
		} else {
			throw new conexionException("Error al establecer conexion");
		}
	
	}

}
