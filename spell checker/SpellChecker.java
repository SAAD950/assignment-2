import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SpellChecker 
{

	final String regularExpression = "[(\\)./\\, \\: \\? \"\" \\d ]+";
	
	public String[] readDictionary(String filename)
	{
		ArrayList<String> dicList = new ArrayList<String>();
		try {
	            FileReader fin = new FileReader(filename);
	            Scanner input = new Scanner(fin);
	         
	            while (input.hasNext()) 
	            {
	            	dicList.add(input.nextLine());// read words from dictionary and add into list
	            }
	            input.close();
	            fin.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return  dicList.toArray(new String[dicList.size()]);
	}
   /**
    * This method takes in a filename and spells check it	
    * @param filename an input file stream (i.e. bonk.txt)	
    * @return ArrayList<String> list of words not found in dictionary 
    */
    public ArrayList<String> spell(String filename) 
    {
    	ArrayList<String> userFile = new ArrayList<String>();
    	ArrayList<String> unmatchedList = new ArrayList<String>();
	
		try {
            FileReader fin = new FileReader(filename);
            Scanner scanner = new Scanner(fin);
            while (scanner.hasNext()) 
            {
            	String[] tokens = tokenizer(scanner.nextLine());
            	for(String token: tokens)
            	{
            		if(token!=null && token!="\n" && token != "\t")
            			userFile.add(token);
            	}
            
            }
            scanner.close();
            fin.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

		String[] dic = readDictionary("dictionary.txt");//read dictionary words
		for(int i=0;i<dic.length;i++)
		{
			if(!inDictionary(userFile.get(i),dic))// if word not matched in dictionary
			{
				unmatchedList.add(userFile.get(i));// add word to unmatchedlist
			}
		}
		System.out.println(unmatchedList.toString());
		return unmatchedList;// return unmatched words 
    }

   /**
    * This method takes the list of words not found in the dictionary	
    * and prints a list of non-duplicate words
    * @param ArrayList<String> List of words not found in dictionary	
    */
    public void printNonDuplicates(ArrayList<String> list ) 
    {

  	  System.out.println("###########################");
  	  System.out.println("Display Non-Duplicate Words");
    	
  	  HashSet<String> hs=new HashSet<>(list);
  	  
    	for(String word:hs)
    	{
    		System.out.println(word);
    	}
    }
   
    public String[] tokenizer(String str)
    {
    	return str.split(regularExpression);
    }
    
    /**
    * This method returns true if a word in input file stream	
    * (i.e. bonk.txt) is in the dictionary, false otherwise.	
    * @param word a string that contains a word to be checked	
    * @return the boolean status of the word (i.e. true or false)	
    */
    public boolean inDictionary(String word, String[] dictionary) 
    {
    	for(int i=0;i<dictionary.length;i++)
    	{
    		if(word.equalsIgnoreCase(dictionary[i]))
    			return true;
    	}

    	return false;
    }

    public static void main(String[] args) 
    {
    	String filename = null;
		if(args.length < 1)
		{
			System.out.println("please provide input file such as < java SpellChecker bonk.txt>");
			System.exit(0);
		}
		else 
		{
			filename = args[0];
      // Prompt the user to enter a file to be spell checked
      SpellChecker sc = new SpellChecker();
	  sc.printNonDuplicates(sc.spell(filename));
		}
    }
}