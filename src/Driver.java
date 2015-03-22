import java.util.*;

public class Driver {
	public static int NUM_ATTRS = 21;
	public static ArrayList<String> attrMap;
	public static ArrayList<Integer> usedAttributes = new ArrayList<Integer>();
	public static ArrayList<Integer> usedAttribute  = new ArrayList<Integer>();

	public static void main(String[] args) {
		InputIterator();		
	}
	
	public static Double traverseTree(Record r, Node root) {
		if(root.children == null){
			return root.getTestAttribute().getValue();
		}
		double nodeValue = 0;
		for(int i = 0; i < r.getAttributes().size(); i++) {
				if(r.getAttributes().get(i).getName().equalsIgnoreCase(root.getTestAttribute().getName())) {
		      		nodeValue = r.getAttributes().get(i).getValue();
		      		break;
		   		}
			}
		for(int i = 0; i < root.getChildren().length; i++) 
		{
			if(nodeValue == root.children[i].getTestAttribute().getValue()) {
				traverseTree(r, root.children[i]);
			}
		}

		return root.getTestAttribute().getValue();
	}
	
		static String rootnode = "";
		static String vrootnode = "";
		static char c = 'X';		
		static String s = "";
		
	// Method to display the decision tree constructed from the information gain method
		public static void DisplayTree(Node root){
			
			if(root.children == null){
				System.out.print((int)root.getTestAttribute().getValue());
				if (c == 'X'){
					System.out.println("");
					c = 'Y';
				}				
			} else {
				for(int i = 0; i < root.getChildren().length; i++) 
				{
				  if (rootnode == "" || rootnode == root.getTestAttribute().getName()){
					c = 'X';
					System.out.print(root.getTestAttribute().getName()+ " = " + root.children[i].getLeaf() + " : ");
					rootnode = root.getTestAttribute().getName();
				} else {
						if (c != 'Y'){
							System.out.println("");
						}
					
						c = 'X';					
						s = "| " + s;
						
						System.out.print(s +root.getTestAttribute().getName()+ " = "+ root.children[i].getLeaf() + " : ");
					}
				  
					DisplayTree(root.children[i]);
					
					if (s.length()-2 >= 0){
						s = s.substring(0, s.length()-2);	
					}					
				}
			}
		}	
		
		// Method to display the decision tree constructed from the variance impurity gain method
				public static void DisplayTree(VarianceNode varianceroot){
					
					if(varianceroot.children == null){
						System.out.print((int)varianceroot.getTestAttribute().getValue());
						if (c == 'X'){
							System.out.println("");
							c = 'Y';
						}				
					} else {
						for(int i = 0; i < varianceroot.getChildren().length; i++) 
						{
						  if (vrootnode == "" || vrootnode == varianceroot.getTestAttribute().getName()){
							c = 'X';
							System.out.print(varianceroot.getTestAttribute().getName()+ " = " + varianceroot.children[i].getLeaf() + " : ");
							vrootnode = varianceroot.getTestAttribute().getName();
						} else {
								if (c != 'Y'){
									System.out.println("");
								}
							
								c = 'X';					
								s = "| " + s;
								
								System.out.print(s +varianceroot.getTestAttribute().getName()+ " = "+ varianceroot.children[i].getLeaf() + " : ");
							}
						  
							DisplayTree(varianceroot.children[i]);
							
							if (s.length()-2 >= 0){
								s = s.substring(0, s.length()-2);	
							}					
						}
					}
				}	
	
	
	public static boolean isAttributeUsed(int attribute) {
		if(usedAttributes.contains(attribute)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isVarianceAttributeUsed(int attribute) {
		if(usedAttribute.contains(attribute)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public static void InputIterator(){
		populateAttrMap();
		
		Boolean bool = false, boo = false;
		int i = 0;
		String answer = null;
		
		ArrayList<Record> records;
		ArrayList<Record> record_validation;
		ArrayList<Record> record_testset;
		
		LearningSet learningSet = new LearningSet();
		
		Node root = new Node();		
		VarianceNode varianceroot = new VarianceNode();
		
		System.out.println("Enter the input:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		StringTokenizer stringtokenizer = new StringTokenizer(string, " ");
		String set;
		
		while(stringtokenizer.hasMoreTokens()){
			i++;
			set = stringtokenizer.nextToken();
			if (i == 6){
				answer = set;
				continue;
			}
			try{
				Integer.parseInt(set);
				continue;
			} catch (Exception e){
				if (bool == false){
					// read in all our data
					records = Reader.buildRecords(set);
					
					bool = true;
					
					for(Record record : records) {
						root.getData().add(record);
					}
					
					for(Record record : records) {
						varianceroot.getData().add(record);
					}
					
					Tree.buildTree(records, root, learningSet);
					
					VarianceTree.buildVarianceTree(records, varianceroot, learningSet);
					
				} else{
					if (boo == false){
						record_validation = Reader.buildRecords(set);
						boo = true;
					} else {
						record_testset = Reader.buildRecords(set);
					}
				}
			}			
		}
				
		if (answer.equalsIgnoreCase("yes")){
			System.out.println("");
			System.out.println("The Information Gain Heuristic is as under:\t");
			System.out.println("");
			DisplayTree(root);
			System.out.println("");
			
			System.out.println("The Variance Impurity Heuristic is as under:\t");
			System.out.println("");
			DisplayTree(varianceroot);
			System.out.println("");
		}	
		
	}
	
	public static int setSize(String set) {
		if(set.equalsIgnoreCase("XB")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XC")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XD")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XE")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XF")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XG")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XH")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XI")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XJ")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XK")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XL")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XM")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XN")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XO")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XP")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XQ")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XR")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XS")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XT")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("XU")) {
			return 2;
		}
		else if(set.equalsIgnoreCase("Class")) {
			return 2;
		}
		return 0;
	}
	
	public static String getLeafNames(int attributeNum, int valueNum) {
		if(attributeNum == 0) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}			
		}
		else if(attributeNum == 1) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 2) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 3) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 4) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 5) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 6) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 7) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 8) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 9) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 10) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 11) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 12) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 13) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 14) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 15) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 16) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 17) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 18) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		else if(attributeNum == 19) {
			if(valueNum == 0) {
				return "0";
			}
			else if(valueNum == 1) {
				return "1";
			}
		}
		
		return null;
	}
	
	public static void populateAttrMap() {
		attrMap = new ArrayList<String>();
		attrMap.add("XB");
		attrMap.add("XC");
		attrMap.add("XD");
		attrMap.add("XE");
		attrMap.add("XF");
		attrMap.add("XG");
		attrMap.add("XH");
		attrMap.add("XI");
		attrMap.add("XJ");
		attrMap.add("XK");
		attrMap.add("XL");
		attrMap.add("XM");
		attrMap.add("XN");
		attrMap.add("XO");
		attrMap.add("XP");
		attrMap.add("XQ");
		attrMap.add("XR");
		attrMap.add("XS");
		attrMap.add("XT");
		attrMap.add("XU");
		attrMap.add("Class");
	}
}
