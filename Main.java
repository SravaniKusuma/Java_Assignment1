//importing for file operations
import java.io.*;
//importing for regular expressions 
import java.util.regex.*;
public class Main {
	
	//recursive method to find files for the  given pattern
	
	public static void searchFiles(File file, Pattern pattern)
	{
		//If the instance is a file,then we check its name with the pattern 
		if(file.isFile())
		{
			//used to interpret the pattern and matches it with file Name
			Matcher m=pattern.matcher(file.getName());
			if(m.find())
			{
				System.out.println("Matching file name : "+file.getName()+"\n"+" The file absolute path is : "+file.getAbsolutePath());
			}
		}
		else
		{
			// If the instance is a directory then we iterate over all files in the sub directory
			File[] files = file.listFiles();
			for(File f :files)
			{
				//searching the files in sub directory recursively
				searchFiles(f,pattern);
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		// to create a new file instance for the given path
		File f = new File("C:\\Users\\K.SRAVANI");
		
		//used to create a pattern , which creates a pattern for .txt files
		Pattern pattern = Pattern.compile(".txt$");
		
		// A method to search files based on the given pattern
		searchFiles(f, pattern);
		
		
		
	}

}
