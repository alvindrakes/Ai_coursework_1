package g53dsm.satheuristics;

import g53dsm.domains.chesc2014_SAT.SAT;
import sun.util.resources.cldr.aa.CurrencyNames_aa_ER;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SimulatedAnnealing extends SATHeuristic
{

	public SimulatedAnnealing(Random random)
	{
		
		super(random);
	}


	public void applyHeuristic(SAT problem) 
	{


		double coolingFactor = 0.9;

		double cutOffTemp = 0.001;

		int numberOfVariables = problem.getNumberOfVariables();

		double currentFitness = problem.getObjectiveFunctionValue(CURRENT_SOLUTION_INDEX);

		double bestSolution = currentFitness;

		double Temp = 50; // initial temperature

		int i = 0;

		while (Temp > cutOffTemp && i <= numberOfVariables )  // cut off if temp is lower than 0.001 or
																// number of iterations reached
		{

			int variable = random.nextInt(numberOfVariables);


			problem.bitFlip(variable, CURRENT_SOLUTION_INDEX);

			double newFitness = problem.getObjectiveFunctionValue(CURRENT_SOLUTION_INDEX);


			double deltaE = newFitness - currentFitness;

			double probability = 1 / (1 + Math.exp((deltaE/Temp)));   //this is the sigmoid function


			// for minimisation, accept if new fitness is lower than current fitness
			if( newFitness < currentFitness)
			{


					currentFitness = newFitness;

					Temp = Temp * coolingFactor;  // lower temp once solution is accepted

			}
			else if (random.nextDouble() <= probability)  // if the random number is lower than probability,
															// we can still accept the worst solution
				{
					// do nothing because accepted

					currentFitness  = newFitness;


					Temp = Temp * coolingFactor;

				}
				else
				{
					// revert changes
					problem.bitFlip(variable, CURRENT_SOLUTION_INDEX);
				}

			i++;  // keep track the number of iterations

		}

	}
	


	public String getHeuristicName() 
	{

		return "Simulated Annealing";
	}

}
