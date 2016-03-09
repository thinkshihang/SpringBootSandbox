package hello;

import errors.ErrorResponse;
import errors.OrderIsInvalidException;
import errors.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ExceptionHandler(OrderIsInvalidException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ErrorResponse handleOrderIsInvalidException(HttpServletResponse response) throws Exception {
        response.sendError(HttpStatus.BAD_GATEWAY.value(), "this is a bad gateway test");
        return new ErrorResponse(11, "test message", "testDeveloprMessage");
    }

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/order")
    public @ResponseBody String getOrder(@RequestParam int id) {
        if (id == 1) {
            return "order found";
        } else if (id == 2) {
            throw new OrderNotFoundException(id, "test");
        } else {
            throw new OrderIsInvalidException();
        }
    }

    @RequestMapping("/emptyResponse")
    public ResponseEntity<String> getEmptyResponse() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}