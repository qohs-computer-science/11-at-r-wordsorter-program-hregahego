import java.io.File;
import java.util.Scanner;
public class WordSorter 
{
	public static void divider() {
        System.out.println("=====================================================================");
    }
	public static void main(String[] args) 
	{
		WordsStorage words = new WordsStorage();
		Scanner input = new Scanner(System.in);
		Scanner in;
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	
		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			words.addWord(word);
		}
		boolean loop = true;
        while (loop) {
            System.out.println("Select an option using this format: {#} - {any additional information}");
            System.out.println("1: Print out all words starting with a specific letter");
            System.out.println("2: Print out all words");
            System.out.println("3: Print out the total number of unique words");
            System.out.println("4: Search and determine if a word is in the article");
            System.out.println("5: Remove a word from the data structure");
            System.out.println("6: Exit");
            divider();
            char option;
            String data = "none";
            String userinput = input.nextLine();
            option = userinput.charAt(0);
            if (userinput.length() > 1) {
                data = userinput.substring(userinput.indexOf("-") + 1).toLowerCase();
            }
            
            switch (option) {
                case '1':
                    if (!data.equals("none")) words.print(data.charAt(0));
                    break;
                case '2':
                    words.print();
                    break;
                case '3':
                    System.out.println(words.numWords());
                    break;
                case '4':
                    if (words.search(data)) {
                        System.out.println("Word found in the article");
                    } else {
                        System.out.println("Word NOT found in the article");
                    }
                    break;
                case '5':
                    words.deleteWord(data);
                    break;
                case '6':
                    loop = false;
                    break;
            }
            divider();
        }
        input.close();
		in.close();
		
	}
}