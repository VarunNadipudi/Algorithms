import java.util.*;

class SumOfSubsets
{
	public static int numWeights;
	public static int requiredWeight;
	public  int[] answer = new int[numWeights+1];
	public  static int[] weights;
	
	public SumOfSubsets(int numW, int reqW)
	{
		numWeights = numW;
		requiredWeight = reqW;
	}
	

	public void SS(int Sum, int k, int RemainingWeights)
	{
		answer[k] = 1;
		
		if((Sum + weights[k]) == requiredWeight)
		{
			for(int i=0; i<k+1 ; i++)
			System.out.print("" + answer[i]);
			System.out.println();
		
		}
		else if(Sum + weights[k] + weights[k+1] <= requiredWeight)
			{
				SS(Sum+weights[k], k+1, RemainingWeights-weights[k]);
			}
			
		//bounding conditions
		if(((Sum + (RemainingWeights - weights[k])) >= requiredWeight) && ((Sum + weights[k+1]) <= requiredWeight))		//building right branch
		{																												//dont worry k value is perfectly fine
			answer[k] = 0;																								//after the ctrl returns here k vlue is same as the left branch
			SS(Sum, k+1, RemainingWeights-weights[k]);
		}
		
	}
	
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\n Enter the number of weights in the list : ");
		numWeights = input.nextInt();
		weights = new int[numWeights + 1];
		 		
		System.out.print("\n Enter the Required Weight : ");
		requiredWeight = input.nextInt();
		
		System.out.println("\n Enter the Weights ");
		int totalWeights =0;
		
		for(int i=0; i<numWeights; i++)
		{
			weights[i] = input.nextInt();
			totalWeights = totalWeights + weights[i];
		}
		
		SumOfSubsets obj = new SumOfSubsets(numWeights,requiredWeight);
		obj.SS(0,0,totalWeights);
	}
	


}
