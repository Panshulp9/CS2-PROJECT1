import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {
        Scanner yourLink = new Scanner(System.in);
        String answer = "yes";

        while (answer.equalsIgnoreCase("yes")) {
            System.out.println("What link would you like to do? (ONLY URL)"); //put in your link
            String chosenLink = yourLink.nextLine();

            Scanner newfilter = new Scanner(System.in);
            System.out.println("What word would you like to filter by?"); //asks for the filter you want
            String filter = yourLink.nextLine();
            try {
                System.out.println();
                System.out.print("hello \n");
                URL url = new URL(chosenLink);

                URLConnection urlc = url.openConnection();

                urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");


                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(urlc.getInputStream())
                );


                String line;
                int x = 0;
                System.out.println(reader);
                while ((line = reader.readLine()) != null) {
                    int startIndex = line.indexOf("href="); //reads the href which has the link rather than https
                    while (startIndex != -1) {
                        int firstQuote = line.indexOf('"', startIndex); //reads the quotation at the beginning of the other links
                        int secondQuote = line.indexOf('"', firstQuote + 1); //reads the last quotation and goes to the index of first quote
                        if (firstQuote != -1 && secondQuote != -1) { //completes all the incomplete URLs
                            String link = line.substring(firstQuote + 1, secondQuote);
                            URL completeURL = new URL(url, link); //https://www.geeksforgeeks.org/java/url-class-java-examples/
                            if (completeURL.toString().contains(filter)) {  //https://www.geeksforgeeks.org/java/string-tostring-method-in-java/
                                System.out.println(completeURL); //checks for all the links with the word you want
                            }
                            x++; //counts the amount of links printed
                        }
                        startIndex = line.indexOf("href=", secondQuote + 1);

                    }

                }
                reader.close();
                System.out.println(x);
            } catch (Exception ex) {
                System.out.println(ex);
            }

            System.out.println("Would you like to enter another URL? (yes/no)"); //asks if you want another
            answer = yourLink.nextLine();

        }
    }

}
