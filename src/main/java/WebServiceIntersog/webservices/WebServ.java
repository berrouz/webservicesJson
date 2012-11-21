package WebServiceIntersog.webservices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: shevchik
 * Date: 21.11.12
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/test")
public class WebServ {

    public int getBook(){
        return 10;
    }
}
