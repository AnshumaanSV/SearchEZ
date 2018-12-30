import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.Image.*;
import java.net.*;

class searchURL extends Frame implements WindowListener, ActionListener 
{
    Label searchLabel = new Label("Enter a product");
    TextField searchField = new TextField(50);
    Button searchButton = new Button("Search");

    Label AmazonLabel = new Label("Amazon*");
    Label FlipkartLabel = new Label("Flipkart ");

    TextField AmazonField = new TextField(60);
    TextField FlipkartField = new TextField(60);

    Button AmazonBuy = new Button("Buy");
    Button FlipkartBuy = new Button("Buy");

    Label Warning1 = new Label("'Buy' link takes some time to open, so don't spam it if nothing's happening!");
    Label Warning2 = new Label("Even though this works fine for most products, you may experience some problem in a few cases");

    Image Background = Toolkit.getDefaultToolkit().createImage("Resources/bg.jpg");
    Image Icon = Toolkit.getDefaultToolkit().getImage("Resources/icon.png");    
    
    getURL modURL = new getURL();
    getPrice Price = new getPrice(); 
    getLink Link = new getLink();
    
    String Keyword;
    
    searchURL()
    {
        setLayout(new FlowLayout());                          //Frame
        setTitle("SearchEZ!");                                //Naming the frame
        setSize(640, 200);                                    //Setting frame size
        setIconImage(Icon);                                   //Setting frame icon
        addWindowListener(this);                              //Window listener to close the window
        setResizable(false);                                  //Frame cannot be resized
        setVisible(true);                                     //Letting the frame display
        searchField.setEditable(true);                        //Lets the user to type in TextField

        add(searchLabel);                                     //Adding the Search components to frame
        add(searchField);
        add(searchButton);

        add(AmazonLabel);                                     //Adding Amazon elements to the frame
        add(AmazonField);
        add(AmazonBuy);

        add(FlipkartLabel);                                   //Adding FLipkart elements to the frame
        add(FlipkartField);
        add(FlipkartBuy);

        add(Warning1);
        add(Warning2);

        searchButton.addActionListener(new ActionListener()   //Search button setup
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Keyword = searchField.getText();

                AmazonField.setText(Price.AmazonPrice(modURL.Amazon(Keyword)));
    
                FlipkartField.setText(Price.FlipkartPrice(modURL.Flipkart(Keyword)));
            }
        });

        AmazonBuy.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Link.AmazonLink(modURL.Amazon(Keyword))).toURI());
                } 
                catch (Exception E) {}
            }
        });

        FlipkartBuy.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(Link.FlipkartLink(modURL.Flipkart(Keyword))).toURI());
                } 
                catch (Exception E) {}
            }
        });
    }

    public void paint(Graphics g)                             //Painting backgrounf image
    {
        super.paint(g);
        g.drawImage(Background, 0, 0, this);
    }

    public void windowClosing(WindowEvent e)                  //Setting up the close button
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {}             //All functions are needed to be overriden for debugging
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
