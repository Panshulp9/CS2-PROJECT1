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
                int containsLink = 0;
                if (line.contains("http")) {

                    int startIndex = line.indexOf("http");
                    String newSubstring = line.substring(startIndex - 4, startIndex);
                    String[] firstSplit = line.split(newSubstring);
                    System.out.println(firstSplit[1]);
                    String[] secondSplit = firstSplit[1].split("'");
                    System.out.println(secondSplit[0]);

                }
                // System.out.println(line);



            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
