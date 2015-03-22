import java.io.*;
import java.util.*;

public class Tree {
	static String rootnode = null;
	public static Node buildTree(ArrayList<Record> records, Node root, LearningSet learningSet) {
		int bestAttribute = -1;
		double bestGain = 0;
		root.setEntropy(Entropy.calculateEntropy(root.getData()));
		
		if(root.getEntropy() == 0) {
			return root;
		}
		
		for(int i = 0; i <= Driver.NUM_ATTRS - 2; i++) {
			if(!Driver.isAttributeUsed(i)) {
				double entropy = 0;
				ArrayList<Double> entropies = new ArrayList<Double>();
				ArrayList<Integer> setSizes = new ArrayList<Integer>();
				
				for(int j = 0; j < Driver.NUM_ATTRS - 2; j++) {
					ArrayList<Record> subset = subset(root, i, j);
					setSizes.add(subset.size());
					
					if(subset.size() != 0) {
						entropy = Entropy.calculateEntropy(subset);
						entropies.add(entropy);
					}
				}
				
				double gain = Entropy.calculateGain(root.getEntropy(), entropies, setSizes, root.getData().size());
				
				if(gain > bestGain) {
					bestAttribute = i;
					bestGain = gain;
				}
			}
		}
		if(bestAttribute != -1) {
			int setSize = Driver.setSize(Driver.attrMap.get(bestAttribute));
			root.setTestAttribute(new DiscreteAttribute(Driver.attrMap.get(bestAttribute), 0));
			root.children = new Node[setSize];
			root.setUsed(true);
			Driver.usedAttributes.add(bestAttribute);
			if (rootnode == null){
				rootnode = root.getTestAttribute().getName();
			}
			
			for (int j = 0; j< setSize; j++) {
				root.children[j] = new Node();
				root.children[j].setParent(root);
				root.children[j].setData(subset(root, bestAttribute, j));
				root.children[j].setLeaf(Driver.getLeafNames(bestAttribute, j));
				root.children[j].getTestAttribute().setName(Driver.getLeafNames(bestAttribute, j));
				root.children[j].getTestAttribute().setValue(j);
			}

			for (int j = 0; j < setSize; j++) {
				buildTree(root.children[j].getData(), root.children[j], learningSet);
				if (!rootnode.equals(root.children[j].getTestAttribute().getName())){
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
	
	public static ArrayList<Record> subset(Node root, int attr, int value) {
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
	
	public void pruneTree() {
		
	}
}

