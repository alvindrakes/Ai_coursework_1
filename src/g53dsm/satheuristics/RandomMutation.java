package g53dsm.satheuristics;

import g53dsm.domains.chesc2014_SAT.SAT;

import java.util.Random;

public class RandomMutation extends SATHeuristic
{



	public RandomMutation(Random random) 
	{
		
		super(random);
	}


	public void applyHeuristic(SAT problem) 
	{
		int numberOfVariables = problem.getNumberOfVariables();

		for(int i = 0; i < numberOfVariables; i++)
		{
			int variable = random.nextInt(numberOfVariables);  // get a random number


			//calculate the current fitness
			double currentFitness = problem.getObjectiveFunctionValue(CURRENT_SOLUTION_INDEX);

			problem.bitFlip(variable, CURRENT_SOLUTION_INDEX);

			// calculate the new fitness
			double newFitness = problem.getObjectiveFunctionValue(CURRENT_SOLUTION_INDEX);


			// For minimisation, if the new fitness is lower than current fitness, accept the bitflip
			if (newFitness <= currentFitness)
			{
				// do nothing because accepted

				currentFitness = newFitness;
			}

			if (newFitness > currentFitness)
			{
				// revert changes
				problem.bitFlip(variable, CURRENT_SOLUTION_INDEX);
			}
		}
	}
	


	public String getHeuristicName() 
	{

		return "Random Mutation";
	}

}
