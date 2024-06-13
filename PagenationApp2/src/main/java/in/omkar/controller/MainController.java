package in.omkar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import in.omkar.dto.InsurancePolicyDTO;
import in.omkar.service.InsurancePolicyService;
import in.omkar.service.InsurancePolicyServiceImpl;
@WebServlet(urlPatterns ="/controller" ,loadOnStartup = 1 )
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InsurancePolicyService policyService = null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		policyService = new InsurancePolicyServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = 0;
		Integer pageSize = 0;
		Long pageCount = 0l;
		String targetPage = null;
		List<InsurancePolicyDTO> listDto = null;
		RequestDispatcher rd = null;
		HttpSession session = null;
		
		
		String value = req.getParameter("s1");
		session = req.getSession(true);
		if(value.equalsIgnoreCase("generateReport")) {
			//get the value of button
			pageSize = Integer.valueOf(req.getParameter("pageSize"));
			pageNo = 1;
			
			if(session != null) {
				session.setAttribute("pageSize", pageSize);
			}
			
		}else {
			//getting the value from hyperLink
			pageNo = Integer.valueOf(req.getParameter("pageNo"));
			if(session != null) {
				pageSize = (Integer)session.getAttribute("pageSize");
					
			}
		}
		
		try {
			 pageCount = policyService.fetchPageCount(pageSize);
			listDto = policyService.fetchPageData(pageSize, pageNo);
			
			req.setAttribute("policiesList", listDto);
			req.setAttribute("pagesCount",pageCount);
			req.setAttribute("pageNo", pageNo);
			targetPage = "./report.jsp"; 
		} catch (HibernateException e) {
			targetPage = "./error.jsp";
			e.printStackTrace();

		} catch (Exception e) {
			targetPage = "./error.jsp";
			e.printStackTrace();
		}
		rd = req.getRequestDispatcher(targetPage);
		rd.forward(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		policyService = null;
	}

}
