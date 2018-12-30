import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getLink
{
    public String AmazonLink(String url)
    {
        String result = null;

        try 
        {
            Document AmazonDoc = Jsoup.connect(url).get();
            Elements AmazonTemp = AmazonDoc.select("div.a-row.a-spacing-none");

            for(Element Link:AmazonTemp)
            {   
                result = Link.getElementsByTag("a").first().attr("href").toString();
                break;
            }
        } 
        catch (Exception e) {}
        
        if(result.charAt(0) == '/')
            result = "https://www.amazon.in"+result;

        return result;
    }
    public String FlipkartLink(String url)
    {
        String result = null;

        try 
        {
            Document FlipkartDoc = Jsoup.connect(url).get();
            Elements FlipkartTemp = FlipkartDoc.select("div._1UoZlX");

            for(Element Link:FlipkartTemp)
            {   
                result = "https://www.flipkart.com"+Link.getElementsByTag("a").first().attr("href").toString();
                break;
            }
        } 
        catch (Exception e) {}

        if(result == null)
        {
            try 
            {
                Document FlipkartDoc = Jsoup.connect(url).get();
                Elements FlipkartTemp = FlipkartDoc.select("div._3liAhj._1R0K0g");

                for(Element Link:FlipkartTemp)
                {   
                    result = "https://www.flipkart.com"+Link.getElementsByTag("a").first().attr("href").toString();
                    break;
                }
            } 
        catch (Exception e) {}
        }

        return result;
    }
}
