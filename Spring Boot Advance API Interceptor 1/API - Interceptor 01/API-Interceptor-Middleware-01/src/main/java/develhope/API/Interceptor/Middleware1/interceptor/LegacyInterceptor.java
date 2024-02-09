package develhope.API.Interceptor.Middleware1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LegacyInterceptor implements HandlerInterceptor {

    @Override // questa funzione riceve una request sottoforma di request HTTP, una risposta che verrà inviata al client e l'oggetto che gestirà il tutto( solitamente il controller)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //andiamo a settare la risposta HTTP che ricevera il client
        response.setStatus(HttpStatus.GONE.value());
        //scriviamo un messaggio di testo che verrà visualizzato a schermo
        response.getWriter().write("This endpoint is deprecated.");
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
