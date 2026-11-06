import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu");

            URLConnection urlc = url.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                    int startIndex = line.indexOf("href=");
                    while (startIndex != -1) {
                        int firstQuote = line.indexOf('"', startIndex);
                        int secondQuote = line.indexOf('"', firstQuote + 1);

                        if (firstQuote != -1 && secondQuote != -1) {
                            String link = line.substring(firstQuote + 1, secondQuote);
                            System.out.println(link);
                        }
                        startIndex = line.indexOf("href=", secondQuote +1);
                       // String[] firstSplit = line.split("\"");
                     //   int num1 = line.indexOf(firstSplit[0]);
                       // String[] secondSplit = firstSplit[1].split("\"");
                       // int num2 = line.indexOf(secondSplit[0]);
                       // String fullLink = line.substring(num1, num2);
                       // System.out.println(fullLink);

                    }



            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
