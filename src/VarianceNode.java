import java.util.ArrayList;

public class VarianceNode {
	private VarianceNode parent;
	public VarianceNode[] children;
	private ArrayList<Record> data;
	private double varianceentropy;
	private boolean isUsed;
	private DiscreteAttribute testAttribute;
	private String leaf;

	public VarianceNode() {
		this.data = new ArrayList<Record>();
		setEntropy(0.0);
		setParent(null);
		setChildren(null);
		setUsed(false);
		setTestAttribute(new DiscreteAttribute("", 0));
	}

	public void setParent(VarianceNode parent) {
		this.parent = parent;
	}

	public VarianceNode getParent() {
		return parent;
	}
	
	public void setLeaf(String leaf){
		this.leaf = leaf;
	}
	
	public String getLeaf(){
		return leaf;
	}
	public void setData(ArrayList<Record> data) {
		this.data = data;
	}

	public ArrayList<Record> getData() {
		return data;
	}

	public void setEntropy(double entropy) {
		varianceentropy = entropy;
	}

	public double getVarianceEntropy() {
		return varianceentropy;
	}

	public void setChildren(VarianceNode[] children) {
		this.children = children;
	}

	public VarianceNode[] getChildren() {
		return children;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setTestAttribute(DiscreteAttribute testAttribute) {
		this.testAttribute = testAttribute;
	}

	public DiscreteAttribute getTestAttribute() {
		return testAttribute;
	}
}
