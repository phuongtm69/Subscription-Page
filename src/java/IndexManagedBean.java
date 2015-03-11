
import Controllers.ValidationControl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author phuongtm
 */
@ManagedBean
@ViewScoped
public class IndexManagedBean {

    /**
     * Creates a new instance of IndexManagedBean
     */
    public IndexManagedBean() {
    }

    private boolean firstView = true;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccess() {
        if (firstView) {
            firstView = false;
            return "";
        }
        if (email != null && !email.equals("")) {
            if (ValidationControl.isValidEmailAddress(email)) {
                return "<form name=\"login\" method=\"post\" action=\"http://192.168.11.1:5280/\">\n"
                        + "\n"
                        + "<div align=\"center\">\n"
                        + "\n"
                        + "  <input type=\"hidden\" name=\"accept_terms\" value=\"yes\" />   <input type=\"hidden\" name=\"redirect\" value=\"https://facebook.com\">\n"
                        + "\n"
                        + "  <input type=\"hidden\" name=\"mode_login\">\n"
                        + "\n"
                        + "  <input type=\"submit\" value=\"Truy cập\" class=\"large red button style-1\">\n"
                        + "\n"
                        + "</div>";
            } else {
                return "<center>Địa chỉ email không hợp lệ</center>";
            }
        }
        return "<center>Xin vui lòng nhập địa chỉ email</center>";
    }

}
