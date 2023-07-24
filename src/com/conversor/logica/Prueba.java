package com.conversor.logica;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Prueba {
	public static void main(String args[]) throws IOException {
		
		Connection.Response respuesta;
		
		
		respuesta = Jsoup.connect("https://www.google.com/finance/quote/MXN-ARS").timeout(10000).execute();
		if(respuesta.statusCode() == 200) {
			Document doc = Jsoup.connect("https://www.google.com/finance/quote/MXN-ARS").get();
			Elements valor = doc.getElementsByClass("YMlKec fxKbKc");
			System.out.println(valor.text());
			
		}
		Divisa mxn = new Divisa(1.0f, "MXN");
		Divisa usd = new Divisa(1.0f/16.75f, "USD");
		Divisa ars = new Divisa(1.0f/0.063f, "ARS");
		float cantidad = 16.0f;
	
		System.out.println(cantidad + usd.getNombreUnidad() + " : " + mxn.convertir(usd, cantidad) + " MXN");
		System.out.println(cantidad + mxn.getNombreUnidad() + " : " + usd.convertir(mxn, cantidad) + " USD");
		System.out.println(cantidad + usd.getNombreUnidad() + " : " + ars.convertir(usd, cantidad) + " ARS");
		System.out.println(ars.mostrarConversion(usd, cantidad));
		System.out.println(usd.mostrarConversion(ars, cantidad));
		
		System.out.println(respuesta.statusCode());
		
	}
	
}
