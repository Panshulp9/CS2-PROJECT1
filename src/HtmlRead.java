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
            int x = 0;
            while ( (line = reader.readLine()) != null ) {
                    int startIndex = line.indexOf("href=");
                    while (startIndex != -1) {
                        int firstQuote = line.indexOf('"', startIndex);
                        int secondQuote = line.indexOf('"', firstQuote + 1);

                        if (firstQuote != -1 && secondQuote != -1) {
                            String link = line.substring(firstQuote + 1, secondQuote);
                            URL completeURL = new URL (url, link);
                            System.out.println(completeURL); //https://www.geeksforgeeks.org/java/url-class-java-examples/
                            x++;
                        }
                        startIndex = line.indexOf("href=", secondQuote +1);

                    }




            }
            reader.close();
            System.out.println(x);
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

}
