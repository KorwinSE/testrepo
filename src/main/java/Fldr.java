import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by u3257 on 23.03.2017.
 */
@WebServlet(name = "Fldr")
public class Fldr extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String output;

        /*Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                String command = "sh runfiletodatabase.sh";
                output[0] = executeCommand(command,response);
            }
        });*/

        String command = "sh runfiletodatabase.sh";
        output = executeCommand(command);


        response.resetBuffer();
        response.getWriter().write("<HTML>" +
                "<head><title>Tas Web File Loader</title></head>" +
                "<body>Обновить загрузчик?<br>" +
                "<form action=\"\" method=\"get\"  onsubmit='clear_pre()'>" +
                "<input type=\"submit\" value=\"Да\">" +
                "</form>"+
                "<pre id='some_pre'>" + output + "</pre>" +
                "</body>" +
                "</HTML>");
    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return output.toString();

    }
}
