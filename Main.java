import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.Image.*;

class ImagePanel extends JComponent 
{
    private Image image;
    
    ImagePanel(){}

    ImagePanel(Image image) 
    {
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

class searchURL extends JFrame implements ActionListener
{
    Image Icon = Toolkit.getDefaultToolkit().createImage("Resources/icon.png");
    Image Background = Toolkit.getDefaultToolkit().createImage("Resources/bg.png");

    JLabel SearchLabel = new JLabel("Enter a Product");
    JTextField SearchField = new JTextField();
    JButton SearchButton = new JButton("Search");

    JTextField AmazonField = new JTextField();
    JButton AmazonBuy = new JButton("Buy");

    JTextField FlipkartField = new JTextField();
    JButton FlipkartBuy = new JButton("Buy");

    JLabel Warning1 = new JLabel("'Buy' link takes some time to open, so don't spam it if nothing's happening!");
    JLabel Warning2 = new JLabel("Issues and suggestions are welcomed! Mail at anshumaansv@gmail.com");

    getURL modURL = new getURL();
    getPrice Price = new getPrice(); 
    getLink Link = new getLink();

    String Keyword;

    searchURL()
    {
        JFrame MainFrame = new JFrame();
        MainFrame.setContentPane(new ImagePanel(Background));
        
        MainFrame.setVisible(true);
	MainFrame.setResizable(false);
        MainFrame.setSize(650, 80);
        MainFrame.setTitle("SearchEZ!");
        MainFrame.setIconImage(Icon);
        MainFrame.setResizable(true);
        MainFrame.setLayout(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SearchLabel.setBounds(30, 10, 120, 25);
        SearchField.setBounds(160, 10, 350, 25);
        SearchButton.setBounds(520, 10, 110, 25);

        MainFrame.add(SearchLabel);
        MainFrame.add(SearchField);
        MainFrame.add(SearchButton);

        AmazonField.setBounds(50, 90, 170, 25);
        AmazonBuy.setBounds(220, 90, 80, 25); 
        
        FlipkartField.setBounds(370, 90, 170, 25);
        FlipkartBuy.setBounds(540, 90, 80, 25);

        Warning1.setBounds(55, 140, 600, 15);
        Warning2.setBounds(65, 160, 600, 15);

        SearchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Keyword = SearchField.getText();

                MainFrame.add(AmazonField);
                MainFrame.add(AmazonBuy);

                MainFrame.add(FlipkartField);
                MainFrame.add(FlipkartBuy);

                if(Price.AmazonPrice(modURL.Amazon(Keyword)) == "Product not found")
                    AmazonField.setText(Price.AmazonPrice(modURL.Amazon(Keyword)));

                else
                    AmazonField.setText("INR "+Price.AmazonPrice(modURL.Amazon(Keyword)));

                if(Price.FlipkartPrice(modURL.Flipkart(Keyword)) == "Product not found")
                    FlipkartField.setText(Price.FlipkartPrice(modURL.Flipkart(Keyword)));

                else
                FlipkartField.setText("INR "+Price.FlipkartPrice(modURL.Flipkart(Keyword)));

                MainFrame.add(Warning1);
                MainFrame.add(Warning2);
                MainFrame.setSize(650, 210);
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
    
    protected void paintComponent(Graphics g) 
    {
        g.drawImage(Background, 0, 0, this);
    }

    public void actionPerformed(ActionEvent e) {}
}

public class Main
{
    public static void main(String[] args)
    {
        searchURL search = new searchURL();
    }
}
