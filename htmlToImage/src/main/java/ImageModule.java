import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;



import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

@Getter
@Setter
@Slf4j
public class ImageModule {

    private File htmlFile;

    ImageModule (){
        URL url = this.getClass().getClassLoader().getResource("html/css1.html");
        try {
            this.htmlFile = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("serial")
    static class Kit extends HTMLEditorKit {

        public Document createDefaultDocument() {
            HTMLDocument doc = (HTMLDocument) super.createDefaultDocument();
            doc.setTokenThreshold(Integer.MAX_VALUE);
            doc.setAsynchronousLoadPriority(-1);
            return doc;

        }

    }


    public static BufferedImage create(URL src, int width, int height){
        log.info(src.toString());
        BufferedImage image = null;
        JEditorPane pane = new JEditorPane();
        Kit kit = new Kit();
        pane.setEditorKit(kit);
        pane.setEditable(false);
        pane.setMargin(new Insets(0,20,0,20));
        pane.setContentType("text/html; charset=UTF-8");

        try{
            pane.setPage(src);
            // HTML 내용을 콘솔창 출력.
            log.info(pane.getText());
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            Container c = new Container();
            SwingUtilities.paintComponent(g, pane, c, 0, 0, width, height);
            g.dispose();

        }catch (Exception e) {

            System.out.println(e);

        }

        return image;


    }

}
