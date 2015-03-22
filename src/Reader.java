import java.io.*;
import java.util.*;

public class Reader {
	static String[][] assign = {{"XB","0"},{"XC","1"},{"XD","2"},{"XE","3"},{"XF","4"},{"XG","5"},{"XH","6"},{"XI","7"},
								{"XJ","8"},{"XK","9"},{"XL","10"},{"XM","11"},{"XN","12"},{"XO","13"},{"XP","14"},{"XQ","15"},
								{"XR","16"},{"XS","17"},{"XT","18"},{"XU","19"}};

    @SuppressWarnings("resource")
	public static ArrayList<Record> buildRecords(String set) {
		BufferedReader reader = null;
		DataInputStream dis = null;
		ArrayList<Record> records = new ArrayList<Record>();

        try { 
           String filedirectory = new File("").getAbsolutePath();
           String PATH_TO_DATA_FILE = set;
           String filelocation = filedirectory + "\\" + PATH_TO_DATA_FILE;
           File f = new File(filelocation);
           FileInputStream fis = new FileInputStream(f); 
           reader = new BufferedReader(new InputStreamReader(fis));
           
           // read the first record of the file
           String line;
           Record r = null;
           ArrayList<DiscreteAttribute> attributes;
           int i = 0;
           while ((line = reader.readLine()) != null) {
        	  if (i == 0){
        		  i = 1;
        	  } else {
              StringTokenizer st = new StringTokenizer(line, ",");
              attributes = new ArrayList<DiscreteAttribute>();
              r = new Record();
              
              if(Driver.NUM_ATTRS != st.countTokens()) {
            	  throw new Exception("Unknown number of attributes!");
              }
              	
			  String XB = st.nextToken();
			  String XC = st.nextToken();
			  String XD = st.nextToken();
			  String XE = st.nextToken();
			  String XF = st.nextToken();
			  String XG = st.nextToken();
			  String XH = st.nextToken();
			  String XI = st.nextToken();
			  String XJ = st.nextToken();
			  String XK = st.nextToken();
			  String XL = st.nextToken();
			  String XM = st.nextToken();
			  String XN = st.nextToken();
			  String XO = st.nextToken();
			  String XP = st.nextToken();
			  String XQ = st.nextToken();
			  String XR = st.nextToken();
			  String XS = st.nextToken();
			  String XT = st.nextToken();
			  String XU = st.nextToken();
			  String Class = st.nextToken();
			  
			  			  
			  if(XB.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XB", DiscreteAttribute.No));
			  }
			  else if(XB.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XB", DiscreteAttribute.Yes));
			  }
			  if(XC.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XC", DiscreteAttribute.No));
			  }
			  else if(XC.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XC", DiscreteAttribute.Yes));
			  }
			  if(XD.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XD", DiscreteAttribute.No));
			  }
			  else if(XD.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XD", DiscreteAttribute.Yes));
			  }
			  if(XE.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XE", DiscreteAttribute.No));
			  }
			  else if(XE.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XE", DiscreteAttribute.Yes));
			  }
			  if(XF.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XF", DiscreteAttribute.No));
			  }
			  else if(XF.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XF", DiscreteAttribute.Yes));
			  }
			  if(XG.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XG", DiscreteAttribute.No));
			  }
			  else if(XG.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XG", DiscreteAttribute.Yes));
			  }
			  if(XH.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XH", DiscreteAttribute.No));
			  }
			  else if(XH.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XH", DiscreteAttribute.Yes));
			  }
			  if(XI.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XI", DiscreteAttribute.No));
			  }
			  else if(XI.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XI", DiscreteAttribute.Yes));
			  }
			  if(XJ.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XJ", DiscreteAttribute.No));
			  }
			  else if(XJ.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XJ", DiscreteAttribute.Yes));
			  }
			  if(XK.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XK", DiscreteAttribute.No));
			  }
			  else if(XK.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XK", DiscreteAttribute.Yes));
			  }
			  if(XL.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XL", DiscreteAttribute.No));
			  }
			  else if(XL.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XL", DiscreteAttribute.Yes));
			  }
			  if(XM.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XM", DiscreteAttribute.No));
			  }
			  else if(XM.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XM", DiscreteAttribute.Yes));
			  }
			  if(XN.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XN", DiscreteAttribute.No));
			  }
			  else if(XN.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XN", DiscreteAttribute.Yes));
			  }
			  if(XO.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XO", DiscreteAttribute.No));
			  }
			  else if(XO.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XO", DiscreteAttribute.Yes));
			  }
			  if(XP.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XP", DiscreteAttribute.No));
			  }
			  else if(XP.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XP", DiscreteAttribute.Yes));
			  }
			  if(XQ.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XQ", DiscreteAttribute.No));
			  }
			  else if(XQ.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XQ", DiscreteAttribute.Yes));
			  }
			  if(XR.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XR", DiscreteAttribute.No));
			  }
			  else if(XR.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XR", DiscreteAttribute.Yes));
			  }
			  if(XS.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XS", DiscreteAttribute.No));
			  }
			  else if(XS.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XS", DiscreteAttribute.Yes));
			  }
			  if(XT.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XT", DiscreteAttribute.No));
			  }
			  else if(XT.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XT", DiscreteAttribute.Yes));
			  }
			  if(XU.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("XU", DiscreteAttribute.No));
			  }
			  else if(XU.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("XU", DiscreteAttribute.Yes));
			  }
			  if(Class.equalsIgnoreCase("0")) {
				  attributes.add(new DiscreteAttribute("Class", DiscreteAttribute.No));
			  }
			  else if(Class.equalsIgnoreCase("1")) {
				  attributes.add(new DiscreteAttribute("Class", DiscreteAttribute.Yes));
			  }
			    		    
			  r.setAttributes(attributes);
			  records.add(r);
           	 }
           }

        } 
        catch (IOException e) { 
           System.out.println("Uh oh, got an IOException error: " + e.getMessage()); 
        } 
        catch (Exception e) {
            System.out.println("Uh oh, got an Exception error: " + e.getMessage()); 
        }
        finally { 
           if (dis != null) {
              try {
                 dis.close();
              } catch (IOException ioe) {
                 System.out.println("IOException error trying to close the file: " + ioe.getMessage()); 
              }
           }
        }
		return records;
	}
}
