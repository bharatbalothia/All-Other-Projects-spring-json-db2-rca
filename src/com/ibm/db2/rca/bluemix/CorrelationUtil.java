package com.ibm.db2.rca.bluemix;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class CorrelationUtil 
{
	public static void main(String [] args)
	{
		
		double toExamine [] = {3d,2d,3d,4d,6d,8d,20d,40d,100d,45d};
		
		double target [] = {1d,2d,3d,4d,5d,7d,20d,4d,2d,45d};
		
		PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation();
		
		double corrVal = pearsonsCorrelation.correlation(toExamine, target);
		
		System.out.println("Correlation Value : " + corrVal);
		
/*		double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
		
		RealMatrix m = MatrixUtils.createRealMatrix(matrixData);
		
		PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation(m);
		
		double corrVal = pearsonsCorrelation.getCorrelationPValues().getEntry(0, 1);
		
		System.out.println("Correlation Value : " + corrVal);*/
		
/*		for (int i=0; i<pv.getData().length;i++)
		{
			double arr [] = pv.getData()[i];
			System.out.println(arr.length); 
		}*/
	}
}
