import gui.ava.html.image.generator.HtmlImageGenerator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlToImage {

    public static void main(String[] args) throws MalformedURLException {
        ImageModule imageModule = new ImageModule();
        File file = imageModule.getHtmlFile();

        System.out.println(file);

        BufferedImage ire;

        String path="D:\\img\\tmp1.png";

        String path2="D:\\img\\tmp2.png";

        ire = ImageModule.create(file.toURI().toURL(), 800, 800);


        try{

            ImageIO.write(ire, "PNG", new File(path));

        }catch(IOException e){

            e.printStackTrace();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
