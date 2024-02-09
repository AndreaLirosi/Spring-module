package develhope.APIMiddleware2.interceptor;

import develhope.APIMiddleware2.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private final List<Month> months;

    public MonthInterceptor() {
        months = new ArrayList<>(Arrays.asList(
                new Month(1, "January", "Gennaio", "Januar"),
                new Month(2, "February", "Febbraio", "Februar"),
                new Month(3, "March", "Marzo", "Marsch"),
                new Month(4, "April", "Aprile", "April"),
                new Month(5, "May", "Maggio", "Mai"),
                new Month(6, "June", "Giugno", "Juni")));
    }

    private Month findMonth(int monthNumber) {

        for (Month m : months) {
            if (m.getMonthNumber() == monthNumber) {
                System.out.println(m.getMonthNumber() + ": " + monthNumber);
                return m;
            }
        }

        return new Month(0, "nope", "nope", "nope");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber = request.getHeader("monthNumber");

        if (monthNumber == null || monthNumber.isEmpty()) {
            response.getWriter().write("Bad Request");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        int month = Integer.parseInt(monthNumber);
        request.setAttribute("Month", findMonth(month));

        return true;
    }

}
