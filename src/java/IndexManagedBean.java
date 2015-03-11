
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    private String email;

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccess() {
        if (name == null || email == null || name.equals("") || email.equals("")) {
            return "Please enter username and password";
        } else if(email.contains("@")) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt"));
                writer.write("Name: " + name + " | Email: " + email);
                writer.close();
            } catch (Exception e) {
            }
            return "<form name=\"login\" method=\"post\" action=\"http://192.168.11.1:5280/\">\n"
                    + "\n"
                    + "<div align=\"center\">\n"
                    + "\n"
                    + "  <input type=\"hidden\" name=\"accept_terms\" value=\"yes\" />   <input type=\"hidden\" name=\"redirect\" value=\"https://facebook.com\">\n"
                    + "\n"
                    + "  <input type=\"hidden\" name=\"mode_login\">\n"
                    + "\n"
                    + "  <input type=\"submit\" value=\"Click here to continue\">\n"
                    + "\n"
                    + "</div>";
        }
        return "INVALID";
    }

}
