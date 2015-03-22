import java.util.ArrayList;

public class VarianceTree {
	static String vrootnode = null;
	public static VarianceNode buildVarianceTree(ArrayList<Record> records, VarianceNode root, LearningSet learningSet) {
		int bestAttribute = -1;
		double bestGain = 0;
		root.setEntropy(VarianceEntropy.calculateEntropy(root.getData()));
		
		if(root.getVarianceEntropy() == 0) {
			return root;
		}
		
		for(int i = 0; i <= Driver.NUM_ATTRS - 2; i++) {
			if(!Driver.isVarianceAttributeUsed(i)) {
				double entropy = 0;
				ArrayList<Double> entropies = new ArrayList<Double>();
				ArrayList<Integer> setSizes = new ArrayList<Integer>();
				
				for(int j = 0; j < Driver.NUM_ATTRS - 2; j++) {
					ArrayList<Record> subset = subset(root, i, j);
					setSizes.add(subset.size());
					
					if(subset.size() != 0) {
						entropy = VarianceEntropy.calculateEntropy(subset);
						entropies.add(entropy);
					}
				}
				
				double gain = VarianceEntropy.calculateGain(root.getVarianceEntropy(), entropies, setSizes, root.getData().size());
				
				if(gain > bestGain) {
					bestAttribute = i;
					bestGain = gain;
				}
			}
		}
		if(bestAttribute != -1) {
			int setSize = Driver.setSize(Driver.attrMap.get(bestAttribute));
			root.setTestAttribute(new DiscreteAttribute(Driver.attrMap.get(bestAttribute), 0));
			root.children = new VarianceNode[setSize];
			root.setUsed(true);
			Driver.usedAttribute.add(bestAttribute);
			if ( vrootnode == null){
				vrootnode = root.getTestAttribute().getName();
			}
			
			for (int j = 0; j< setSize; j++) {
				root.children[j] = new VarianceNode();
				root.children[j].setParent(root);
				root.children[j].setData(subset(root, bestAttribute, j));
				root.children[j].setLeaf(Driver.getLeafNames(bestAttribute, j));
				root.children[j].getTestAttribute().setName(Driver.getLeafNames(bestAttribute, j));
				root.children[j].getTestAttribute().setValue(j);
			}

			for (int j = 0; j < setSize; j++) {
				buildVarianceTree(root.children[j].getData(), root.children[j], learningSet);
				if (!vrootnode.equals(root.children[j].getTestAttribute().getName())){
					for (int y = 0; y <= 3; y++){
						if(Reader.assign[y][0].equals(root.children[j].getTestAttribute().getName())){
							if(Driver.isAttributeUsed(Integer.valueOf(Reader.assign[y][1]))){
								Driver.usedAttributes.remove(Integer.valueOf(Reader.assign[y][1]));
							}
						}
					}
				}
			}

			root.setData(null);
		}
		else {
			return root;
		}
		
		return root;
	}

	public static ArrayList<Record> subset(VarianceNode root, int attr, int value) {
		ArrayList<Record> subset = new ArrayList<Record>();
		
		for(int i = 0; i < root.getData().size(); i++) {
			Record record = root.getData().get(i);
			
			if(record.getAttributes().get(attr).getValue() == value) {
				subset.add(record);
			}
		}
		return subset;
	}
	
	public double calculateSurrogates(ArrayList<Record> records) {
		return 0;
		
	}
}
