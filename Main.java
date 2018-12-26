import java.awt.*;
import java.awt.event.*;

class searchURL extends Frame implements WindowListener, ActionListener
{
    Label searchLabel = new Label("Enter a product");
    TextField searchField = new TextField(50);
    Button searchButton = new Button("Search");

    Label AmazonLabel = new Label("Amazon");
    TextField AmazonField = new TextField(70);
    Label FlipkartLabel = new Label("Flipkart ");
    TextField FilpkartField = new TextField(70);
    Label EbayLabel = new Label("Ebay     ");
    TextField EbayField = new TextField(70);

    searchURL()
    {
        setLayout(new FlowLayout());                          //Frame
        add(searchLabel);                                     //Adding the components to frame
        add(searchField);
        add(searchButton);

        add(AmazonLabel); add(AmazonField);
        add(FlipkartLabel); add(FilpkartField);
        add(EbayLabel); add(EbayField);

        setTitle("SearchEZ!");                                //Naming the fram and setting its size
        setSize(640, 200);        

        searchField.setEditable(true);                        //Lets the user to type in TextField
        searchButton.addActionListener(this);

        addWindowListener(this);                              //Window listener to close the window

        setVisible(true);                                     //Letting the frame display
    }

    //Hard coded methods to create the url of the search product
    String input;

    public String Amazon()
    {
        //Input spaces to be replaced with "+" and placed after url
        String url = "https://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=";
        String result = input.replace(" ", "+");
        
        return url+result;
    }

    public String Flipkart()
    {
        //Input spaces to be replaced with "%20" and placed after url1 and before url2
        String url1 = "https://www.flipkart.com/search?q=";
        String url2 = "&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
        String result = input.replace(" ","%20");

        return url1+result+url2;
    }

    public String Ebay()
    {
        //Input spaces to be replaced with "+" and placed after url1 and before url2
        String url1 = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=";
        String url2 = "&_sacat=0";
        String result = input.replace(" ", "+");

        return url1+result+url2;
    }

    public void actionPerformed(ActionEvent e)
    {
        input = searchField.getText();

        AmazonField.setText(Amazon());
        FilpkartField.setText(Flipkart());
        EbayField.setText(Ebay());
    }

    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    public void windowOpened(WindowEvent evt) {}
    public void windowClosed(WindowEvent evt) {}
    public void windowDeactivated(WindowEvent evt) {}
    public void windowActivated(WindowEvent evt) {}
    public void windowDeiconified(WindowEvent evt) {}
    public void windowIconified(WindowEvent evt) {}
}

public class Main
{
    public static void main(String[] args) 
    {
        searchURL search = new searchURL();
    }
}
