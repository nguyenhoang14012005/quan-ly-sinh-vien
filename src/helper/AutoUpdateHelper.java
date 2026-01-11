
package helper;
import javax.swing.JComponent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class AutoUpdateHelper {

    // Hàm nhận vào panel (component) và hành động (action) cần chạy khi panel hiện lên
    public static void addAutoRefresh(JComponent component, Runnable action) {
        component.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // Khi Panel hiện lên -> Chạy hành động
                try {
                    action.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {}

            @Override
            public void ancestorMoved(AncestorEvent event) {}
        });
    }
}