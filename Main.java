import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.Image.*;
import java.net.*;

import javax.imageio.ImageIO;

class searchURL extends Frame implements WindowListener, ActionListener 
{
    Label searchLabel = new Label(" Enter a product");
    TextField searchField = new TextField(50);
    Button searchButton = new Button("Search");

    Button AmazonButton = new Button("Amazon");
    Button FlipkartButton = new Button("Flipkart");
    Button EbayButton = new Button("Ebay");
    Button ShopcluesButton = new Button("Shopclues");
    Button SnapdealButton = new Button("Snapdeal");

    Image Background = Toolkit.getDefaultToolkit().createImage("Resources/BG.jpg");

    searchURL()
    {
        setLayout(new FlowLayout());                          //Frame

        add(searchLabel);                                     //Adding the components to frame
        add(searchField);
        add(searchButton);

        add(AmazonButton);
        add(FlipkartButton);
        add(EbayButton);
        add(ShopcluesButton);
        add(SnapdealButton);

        setTitle("SearchEZ!");                                //Naming the fram and setting its size
        setSize(640, 100);        

        searchField.setEditable(true);                        //Lets the user to type in TextField
        
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                input = searchField.getText();
            }
        });

        AmazonButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Amazon()).toURI());
                } 
                catch (Exception E) {}
            }
        });

        FlipkartButton.addActionListener(new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Flipkart()).toURI());
                } 
                catch (Exception E) {}
            }
        });

        EbayButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Ebay()).toURI());
                } 
                catch (Exception E) {}
            }
        });

        ShopcluesButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Shopclues()).toURI());
                } 
                catch (Exception E) {}
            }
        });

        SnapdealButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Snapdeal()).toURI());
                } 
                catch (Exception E) {}
            }
        });

        addWindowListener(this);                              //Window listener to close the window

        setResizable(false);
        setVisible(true);                                     //Letting the frame display
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(Background, 0, 0, this);
    }

    // Hard coded methods to create the url of the search product
    String input;

    public String Amazon() 
    {
        String url = "https://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=";
        String result = input.replace(" ", "+");

        return url + result;
    }

    public String Flipkart() 
    {
        String url1 = "https://www.flipkart.com/search?q=";
        String url2 = "&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
        String result = input.replace(" ", "%20");

        return url1 + result + url2;
    }

    public String Ebay() 
    {
        String url1 = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=";
        String url2 = "&_sacat=0";
        String result = input.replace(" ", "+");

        return url1 + result + url2;
    }

    public String Shopclues()
    {
        String url1 = "https://www.shopclues.com/search?q=";
        String url2 = "&sc_z=3333&z=1&count=10";
        String result = input.replace(" ", "%20");

        return url1 + result + url2;
    }

    public String Snapdeal()
    {
        String url1 = "https://www.snapdeal.com/search?keyword=";
        String url2 = "&santizedKeyword=&catId=&categoryId=0&suggested=false&vertical=&noOfResults=20&searchState=&clickSrc=go_header&lastKeyword=&prodCatId=&changeBackToAll=false&foundInAll=false&categoryIdSearched=&cityPageUrl=&categoryUrl=&url=&utmContent=&dealDetail=&sort=rlvncy";
        String result = input.replace(" ", "%20");

        return url1 + result + url2;
    }

    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
}

public class Main 
{  
     public static void main(String[] args) 
    {
        searchURL search = new searchURL();
    }
}