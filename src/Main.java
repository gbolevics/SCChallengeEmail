import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Main {

    public static String webPage, inputLine, inputString;
    public static BufferedReader in, inWebBuff;
    public static int lineCounter, beginOfName, endOfName;

    public static void main(String[] args) throws IOException {

        //Asking user for ID
        System.out.print("Enter ID: ");
        in = new BufferedReader(new InputStreamReader(System.in));
        inputString = in.readLine();

        //Generating URL
        webPage = "https://www.ecs.soton.ac.uk/people/" + inputString;
        URL myURL = new URL(webPage);

        //Reading from URL
        inWebBuff = new BufferedReader(new InputStreamReader(myURL.openStream()));
        while ((inputLine = inWebBuff.readLine()) != null){
            lineCounter++;

            //Finding the line using lineCounter
            if (lineCounter == 85){

                //Cleaning up the string
                beginOfName = inputLine.indexOf("property=\"name\"") + 16;
                endOfName = inputLine.indexOf("</h1>");
                System.out.println(inputLine.substring(beginOfName, endOfName));
            }
        }

        //Closing the stream
        inWebBuff.close();
    }
}
