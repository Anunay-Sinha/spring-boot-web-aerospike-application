/**
 * 
 */
package aerospike.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author Peter Milne
 * @author Jean Mercier
 *
 */
@Controller
public class IndexController {
 
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
