import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CircuitApp
{
	public static void main(String args[]) throws IOException
	{
		String filename = null;
		if(args.length < 1)
		{
			System.out.println("u must provide input file such as <java CircuitApp data.txt>");
			System.exit(0);
		}
		else filename = args[0];
		
		System.out.printf("Reading filename: %s",filename);
		ArrayList<Resistance[]> list = readResistanceFile(filename);

		
		System.out.println("\nSaving good designs to good.txt");
		System.out.println("The following are bad designs:");
		
		 File file = new File("good.txt");
         PrintWriter writer = new PrintWriter(file);
		for(int i=0;i<list.size();i++)
		{
			Resistance[] r = list.get(i);// get resistance list
			double value = ((r[0].getValue()+r[1].getValue())*r[3].getValue()*r[5].getValue())/((r[2].getValue()+r[3].getValue())*r[0].getValue()*r[4].getValue());
			if(value != 7.5)
			{
			System.out.printf("%.2f %.2f %.2f %.2f %.2f %.2f",r[0].getValue(),r[1].getValue(),r[2].getValue(),r[3].getValue(),r[4].getValue(),
					r[5].getValue());
			System.out.println();
			}
			else
			{
				writer.printf("%.2f %.2f %.2f %.2f %.2f %.2f",r[0].getValue(),r[1].getValue(),r[2].getValue(),r[3].getValue(),r[4].getValue(),
						r[5].getValue());				
			}
			
		}
		writer.close();
		
	}

	public static ArrayList<Resistance[]> readResistanceFile(String file)
	{
		ArrayList<Resistance[]> resistanceList = new ArrayList<Resistance[]>();
		
		  try {
	            FileReader fin = new FileReader(file);
	            Scanner input = new Scanner(fin);
	            int i = 0;
	            Resistance[] r = new Resistance[6];// store resistor values
	            while (input.hasNext()) 
	            {
	            	if(input.hasNextDouble())// check if double
	            	{
	            		r[i]= new Resistance(input.nextDouble());// read value
	            		i++;
	            	}
	            	else if(input.hasNextInt())// check if integer
	            	{
	            		r[i]= new Resistance(input.nextInt());// read value
	            		i++;
	            	}
	            	if(i == 6)
            		{
            			resistanceList.add(r);// save array to list
            			r = new Resistance[6];// reset array to save next line 
            			i = 0;
            		}
	            }
	            input.close();
	            fin.close();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		return resistanceList;
	}
	
}
