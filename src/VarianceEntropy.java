import java.util.ArrayList;

public class VarianceEntropy {
	public static double calculateEntropy(ArrayList<Record> data) {
		double entropy = 1;
		
		if(data.size() == 0) {
			// nothing to do
			return 0;
		}
		
		for(int i = 0; i < Driver.setSize("Class"); i++) {
			int count = 0;
			for(int j = 0; j < data.size(); j++) {
				Record record = data.get(j);
				
				if(record.getAttributes().get(20).getValue() == i) {
					count++;
				}
			}
				
			double probability = count / (double)data.size();
			if(count >= 0) {
				entropy *= probability;
			}
		}
		
		return entropy;
	}
	
	public static double calculateGain(double rootEntropy, ArrayList<Double> subEntropies, ArrayList<Integer> setSizes, int data) {
		double gain = rootEntropy; 
		
		for(int i = 0; i < subEntropies.size(); i++) {
			gain += -((setSizes.get(i) / (double)data) * subEntropies.get(i));
		}
		
		return gain;
	}
}
