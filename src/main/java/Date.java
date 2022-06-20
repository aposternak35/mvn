import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@WebServlet("/case")
public class Date extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter=resp.getWriter();
        String command =req.getParameter("command");
        switch (command){
            case "date":LocalDate date = LocalDate.now();
                printWriter.write("Date: "+date);
                break;
            case "time":LocalTime time = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                printWriter.write("Time: "+time.format(formatter));
                break;
            default:
                printWriter.write("Commands not entered");
                break;
        }
        printWriter.close();
    }
}
