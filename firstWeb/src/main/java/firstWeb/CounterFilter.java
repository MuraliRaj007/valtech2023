package firstWeb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class CounterFilter implements Filter {

	@Override
	public void destroy() {
		
		System.out.println("Destroy of Counter Filter...");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Do filter of Counter Filter");
		Map<String, Integer> counters=(Map<String, Integer>) request.getServletContext().getAttribute("counters");
		HttpServletRequest req=(HttpServletRequest) request;
		String uri=req.getRequestURI();
		counters.put(uri, counters.containsKey(uri) ? counters.get(uri)+1 : 1);
		printCounters(counters);
		long t1=System.nanoTime();
		chain.doFilter(request, response);
		long t2=System.nanoTime();
		int t = (int) (t2-t1);
		System.out.println(t);
		
	}

	private void printCounters(Map<String, Integer> counters) {

		for(String s:counters.keySet()) {
			System.out.println("Uri = "+s+" Counter = "+counters.get(s));
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("Init of Counter Filter...");
		Map<String, Integer> counters=new HashMap<String, Integer>();
		filterConfig.getServletContext().setAttribute("counters", counters);
	}

}
