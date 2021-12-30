package exercise.crawlfpt;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlFptShop {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://fptshop.com.vn/apple/iphone");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));

            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

//            content = content.replaceAll("\\n+", "");
            System.out.println(content);
            Pattern pattern = Pattern.compile("class=\"product__name\">(.*?)</a>");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
