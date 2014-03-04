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
public class Flavio 
{ 
	public static void main (String[] args)
	{ 
		int k; 
		int contk=0; 
		int pos1=0; 
		int n; 




		n=10;
		k=3;
		Cvector miVec = new Cvector(n); 

		int soldados=n; 

		for (int i=0; i<miVec.getTam();i++) 
		{ 

			miVec.setVector(i,i+1); 
		} 



		while (soldados >1) 
		{ 
			if (miVec.getVector(pos1)!=0) 
			{ 
				contk++; 
			} 

			if (contk==k) 
			{ 

				miVec.setVector(pos1,0); 
				soldados--; 
				contk=0; 

			} 

			pos1++; 


			if(pos1==n) 

				pos1=0 ; 



		} 



		for (int i=0; i<miVec.getTam();i++) 
			System.out.println(miVec.getVector(i));
	} 
} 
