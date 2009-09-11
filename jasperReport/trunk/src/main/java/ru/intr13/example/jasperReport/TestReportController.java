package ru.intr13.example.jasperReport;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Service("TestReportController")
public class TestReportController extends AbstractController {

	protected String getPostfix(HttpServletRequest request) {
		String path = request.getRequestURI();
		String postfix = "";
		if (path.endsWith("html")) {
			postfix = "-html";
		}
		return postfix;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HashMap<Object, Object> model = new HashMap<Object, Object>();
		ArrayList<Object> value = new ArrayList<Object>();
		value.add(new Filler());
		model.put("dataSource", value);
		return new ModelAndView("test" + getPostfix(request), model);

	}

}
