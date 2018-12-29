import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getPrice
{
    public String AmazonPrice(String url)
    {
        String Price = "Product not found";
        try
        {
            Document AmazonDoc = Jsoup.connect(url).get();
            Elements AmazonTemp = AmazonDoc.select("span.a-size-base.a-color-price.s-price.a-text-bold");

            for(Element priceList:AmazonTemp)
            {
                Price = priceList.getElementsByTag("span").first().text().toString();
                Price = Price.replace(",","");
                break;
            }
        }
        catch(Exception E){}

        return Price;
    }

    public String FlipkartPrice(String url)
    {
        String Price = "Product not found";
        try
        {
            Document FlipkartDoc = Jsoup.connect(url).get();
            Elements FlipkartTemp = FlipkartDoc.select("div._1uv9Cb");

            for(Element priceList:FlipkartTemp)
            {
                Price = priceList.getElementsByTag("div").get(1).text().toString();
                Price = Price.replace("₹","");
                Price = Price.replace(",","");
                break;
            }
        }
        catch(Exception E){}

        if(Price == null)
            Price = "Product not found";
        return Price;
    }
}
