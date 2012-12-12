package com;

import java.util.ArrayList;

public class GeneraDetalle {

	
	public ArrayList listaDetalle(int numero){
		GaleriaInicioPerfectoTO galeriaInicioPerfectoTO = null;
		ArrayList lista = new ArrayList();
		for(int i=0;i<numero;i++){
			galeriaInicioPerfectoTO = new GaleriaInicioPerfectoTO();
			galeriaInicioPerfectoTO.setVchNombreConsultora("bailey jay:"+i);
			lista.add(galeriaInicioPerfectoTO);
			


		}
		return lista;
	}
}
