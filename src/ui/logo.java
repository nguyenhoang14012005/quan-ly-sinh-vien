
package ui;
import java.awt.Image;
import java.net.URL;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class logo {
    private static final String LOGO_PATH = "/icons/logo.png";
    
    public static Image getLogo(){
        URL url = logo.class.getResource(LOGO_PATH);
        if(url != null){
            return Toolkit.getDefaultToolkit().getImage(url);
        }else{
            System.err.println("Lỗi: Không tìm thấy file ảnh tại "+ LOGO_PATH);
            return null;
        }
    }
    public static void setupIcon(JFrame frame){
        Image icon = getLogo();
        if(icon != null){
            frame.setIconImage(icon);
        }
    }
}
