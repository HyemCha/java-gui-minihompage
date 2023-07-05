package minihomepage.utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ImageUtil {
    static File f = null;
    static BufferedImage image = null;
    static String imgName, extension;
    static Date date;
    public static String saveImage(String path, String directory){
        setImageName();

        String IMAGE_URL = path;
        try {
            // if you want to get png or jpg ... you can do it
            File url = new File(IMAGE_URL);
            extension = IMAGE_URL.substring(IMAGE_URL.indexOf('.') + 1);
            imgName = "image/minihomepage/" + directory + "/" + directory + imgName + "." + extension;
            BufferedImage image = ImageIO.read(url);

            File file = new File(imgName);
            System.out.println("img path:;" + imgName);
            ImageIO.write(image, extension, new File(imgName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return imgName;
    }

    static void setImageName() {
        date = new Date();
        imgName = Long.toString(date.getYear()) + date.getMonth() + date.getDay() + date.getDate()
                + date.getHours() + date.getMinutes() + date.getSeconds();
    }
}
