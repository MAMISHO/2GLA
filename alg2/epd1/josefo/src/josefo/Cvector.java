/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package josefo;

/**
 *
 * @author MAMISHO
 */
public class Cvector 
{ 
	private int []vector; 
	private int tam; 

	public Cvector() 
	{ 
		vector=new int[10]; 
		setTam(10); 
	} 

	public Cvector(int n) 
	{ 
		vector=new int[n]; 
		setTam(n); 
	} 

	public void setTam(int n) 
	{ 
		tam=n; 
	} 

	public int getTam() 
	{ 
		return tam; 
	} 

	public void setVector(int pos,int valor) 
	{ 
		if (pos<getTam()) 
		{ 
			vector[pos]=valor; 
		} 
	} 

	public int getVector(int pos) 
	{ 
		return vector[pos]; 
	} 
}
