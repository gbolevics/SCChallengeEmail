import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Anagram {

    public static String webPage, outputLine, inputString;
    public static BufferedReader in, inWebBuff;
    public static int lineCounter, beginOfName, endOfName, numberOfAnagrams;

    public static void main(String[] args) throws IOException {

        //Asking user for the word
        System.out.print("Type in the word: ");
        in = new BufferedReader(new InputStreamReader(System.in));
        inputString = in.readLine();

        //Generating URL
        webPage = "https://new.wordsmith.org/anagram/anagram.cgi?anagram=" + inputString + "&t=500&a=n";
        URL myURL = new URL(webPage);

        //Reading from URL
        inWebBuff = new BufferedReader(new InputStreamReader(myURL.openStream()));
        while ((outputLine = inWebBuff.readLine()) != null){

            //lineCounter is used to see the position in source code.
            lineCounter++;

            //"if" to find how many anagrams were generated
            if (lineCounter == 108){
                beginOfName = outputLine.indexOf("<b>") + 3;
                endOfName = outputLine.indexOf(" ");
                numberOfAnagrams = Integer.parseInt(outputLine.substring(beginOfName, endOfName));

            }

            //"if" to display all anagrams
            if (lineCounter >= 109 && lineCounter <= 108 + numberOfAnagrams){
                //Remove all tags and display anagram
                if (lineCounter == 109){
                    System.out.println(outputLine.substring(8, outputLine.length()- 4));
                }else{
                    System.out.println(outputLine.substring(0, outputLine.indexOf("<br>")));
                }

            }

        }
        //Closing the stream
        inWebBuff.close();
    }
}
