import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.Image.*;
import java.net.*;
import sites.getURL;

class searchURL extends Frame implements WindowListener, ActionListener 
{
    Label searchLabel = new Label(" Enter a product");
    TextField searchField = new TextField(50);
    Button searchButton = new Button("Search");

    Button AmazonButton = new Button("Amazon");
    Button FlipkartButton = new Button("Flipkart");
    Button ShopcluesButton = new Button("Shopclues");
    Button SnapdealButton = new Button("Snapdeal");
    Button OpenallButton = new Button("Open All");

    Image Background = Toolkit.getDefaultToolkit().createImage("Resources/bg.jpg");
    Image Icon = Toolkit.getDefaultToolkit().getImage("Resources/icon.png");    
    getURL modURL = new getURL(); 
    String Keyword;
    
    searchURL()
    {
        setLayout(new FlowLayout());                          //Frame
        setTitle("SearchEZ!");                                //Naming the fram and setting its size
        setSize(640, 100);  
        setIconImage(Icon);
        addWindowListener(this);                              //Window listener to close the window
        setResizable(false);
        setVisible(true);                                     //Letting the frame display

        add(searchLabel);                                     //Adding the Search components to frame
        add(searchField);
        add(searchButton);

        add(AmazonButton);                                    //Adding the website buttons to frame
        add(FlipkartButton);
        add(ShopcluesButton);
        add(SnapdealButton);
        add(OpenallButton);

        searchField.setEditable(true);                        //Lets the user to type in TextField
        
        searchButton.addActionListener(new ActionListener()   //Search button setup
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Keyword = searchField.getText();
            }
        });

        AmazonButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(modURL.Amazon(Keyword)).toURI());
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
                    Desktop.getDesktop().browse(new URL(modURL.Flipkart(Keyword)).toURI());
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
                    Desktop.getDesktop().browse(new URL(modURL.Shopclues(Keyword)).toURI());
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
                    Desktop.getDesktop().browse(new URL(modURL.Snapdeal(Keyword)).toURI());
                } 
                catch (Exception E) {}
            }
        });

        OpenallButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    Desktop.getDesktop().browse(new URL(modURL.Amazon(Keyword)).toURI());
                    Desktop.getDesktop().browse(new URL(modURL.Flipkart(Keyword)).toURI());
                    Desktop.getDesktop().browse(new URL(modURL.Shopclues(Keyword)).toURI());
                    Desktop.getDesktop().browse(new URL(modURL.Snapdeal(Keyword)).toURI());
                } 
                catch (Exception E) {}
            }
        });
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(Background, 0, 0, this);
    }

    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {}            //All functions are needed to be overriden for debugging
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
