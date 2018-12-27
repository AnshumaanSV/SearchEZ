package sites;

public class getURL
{
    public String Amazon(String Keyword) 
    {
        String url = "https://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=";
        String result = Keyword.replace(" ", "+");

        return url + result;
    }

    public String Flipkart(String Keyword) 
    {
        String url1 = "https://www.flipkart.com/search?q=";
        String url2 = "&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
        String result = Keyword.replace(" ", "%20");

        return url1 + result + url2;
    }

    public String Ebay(String Keyword) 
    {
        String url1 = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=";
        String url2 = "&_sacat=0";
        String result = Keyword.replace(" ", "+");

        return url1 + result + url2;
    }

    public String Shopclues(String Keyword)
    {
        String url1 = "https://www.shopclues.com/search?q=";
        String url2 = "&sc_z=3333&z=1&count=10";
        String result = Keyword.replace(" ", "%20");

        return url1 + result + url2;
    }

    public String Snapdeal(String Keyword)
    {
        String url1 = "https://www.snapdeal.com/search?keyword=";
        String url2 = "&santizedKeyword=&catId=&categoryId=0&suggested=false&vertical=&noOfResults=20&searchState=&clickSrc=go_header&lastKeyword=&prodCatId=&changeBackToAll=false&foundInAll=false&categoryIdSearched=&cityPageUrl=&categoryUrl=&url=&utmContent=&dealDetail=&sort=rlvncy";
        String result = Keyword.replace(" ", "%20");

        return url1 + result + url2;
    }
}
