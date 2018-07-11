import g53dsm.statistics.BoxPlot;
import g53dsm.domains.chesc2014_SAT.SAT;
import g53dsm.satheuristics.SATHeuristic;
import g53dsm.statistics.BoxPlot;
import g53dsm.statistics.LineGraph;

public class useless {
	public static void main(String [] args) {
			
		final String BOXPLOT_TITLE = "Performance comparison of neuroevolution";
		double[][] input = {{0.2223,  0.2777, 0.1750, 0.2297, 0.2278, 0.2823, 0.2260, 0.2789,  0.2720,  0.2340},
							{0.2128, 0.2379, 0.2792, 0.2206, 0.2888, 0.2434, 0.3240, 0.1667, 0.2957, 0.2778},
							{0.2529, 0.2783, 0.2973, 0.2025, 0.2393, 0.1713, 0.2794, 0.2222, 0.2502, 0.2487},
							{0, 0.2229,  0.3082, 0, 0, 0,  0.3215, 0, 0, 0.0778}};






		double[][] data  = new double [input[0].length][input.length];
		for (int i=0 ; i<input.length; i++) {
			for(int j=0 ; j < input[0].length; j++) {
				data[j][i] = input[i][j];
			}
		}
		final String[] names = {"Original","Crossover changed to 2-point","New trimming mechanic", "Mutated Simulated Annealing"};
		System.out.println("data:"+ data.length +"\n names:"+ names[1]);
		new BoxPlot(BOXPLOT_TITLE, false).createPlot(data, names);
	}
}
