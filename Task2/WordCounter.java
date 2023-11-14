import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("WORD COUNTER");
        System.out.println("--------------------------------");
        String text;
        int op;
        int cntWords=0;
        do
        {
            op=0;
            System.out.println("Select Anyone :\npress 1 to Enter Text Manually\npress 2 to enter a File Name\n3 to Exit");
            System.out.println("--------------------------------");
            int option =scanner.nextInt();
            switch(option)
            {
                case 1:
                {
                    scanner.nextLine();
                    System.out.println("Enter your text here:");
                    text=scanner.nextLine();
                    cntWords=textReader(text);
                    break;
                }
                case 2:
                {
                    System.out.print("Enter the file name: ");
                    String fileName = scanner.nextLine();

                    try {
                        // Read the contents of the file
                        String fileContents = readFileContents(fileName);

                        // Display the contents on the console
                        System.out.println("File Contents:\n" + fileContents);
                    } catch (IOException e) {
                        System.out.println("Error reading the file: " + e.getMessage());
                    } finally {
                        scanner.close();
                    }
                    break;
                }
                case 3:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("You may have selected wrong option...");
                    op=1;
                }
            }

        }while(op==1);
        
        // Get the file name from the user
        System.out.println("Total Number of Words:"+cntWords);
       
    }

    private static String readFileContents(String fileName) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }

        return contentBuilder.toString();
    }
    private static int textReader(String dummy)
    {
        if (dummy.isEmpty())
        {
            System.out.println("Empty String!!..cant read values!!");
            return 0;
        }
        Integer cnt=0;
        HashSet<String> unique = new HashSet<>();
        TreeMap <String,Integer> tm=new TreeMap<String,Integer>();
        
        String words[] = dummy.split("\\W+"); //splits based on space and punctuation
        
        for(int i=0;i<words.length;i++)
        {
            unique.add(words[i]);
        }
        ArrayList<String> list = new ArrayList<String>(unique); 
        Arrays.sort(words);
            for(int j=0;j<words.length;j++)
            {
                if(list.contains(words[j]))
                {
                    cnt++;
                }
                tm.put(list.get(j),cnt);
                cnt=0;
            }
            
        for(String key:tm.keySet())
        {
            System.out.println(key+" : "+tm.get(key));
        }
        return cnt;
    }
}
