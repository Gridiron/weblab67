package tag;
//import model.entity.Request;
import model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class RequestTableTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        Locale loc = (Locale) getJspContext().getAttribute("userLocale", PageContext.SESSION_SCOPE);
        ResourceBundle bundle = ResourceBundle.getBundle("locale", loc, this.getClass().getClassLoader());

        User user = (User) getJspContext().getAttribute("user", PageContext.SESSION_SCOPE);
        String header = "<table border=\"1\" cellpadding=\"5\" cellspacing=\"1\" style=\"border-collapse: collapse\">\n" +
                "    <tr>\n" +
                "        <th>" + bundle.getString("table.id") + "</th>\n" +
                "        <th>" + bundle.getString("table.type") + "</th>\n" +
                "        <th>" + bundle.getString("table.descr") + "</th>\n" +
                "        <th>" + bundle.getString("table.deadline") + "</th>\n" +
                "        <th>" + bundle.getString("table.status") + "</th>\n" +

                (user.getUser_type() == 1 ? "        <th>" + bundle.getString("table.delete") + "</th>\n" : "") +

                "    </tr>\n" +
                "\n";
        StringBuilder tableBody = new StringBuilder();

        tableBody.append("</table>");
        try {
            JspWriter out = this.getJspContext().getOut();
            out.write(header + tableBody.toString());
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
    }
}
