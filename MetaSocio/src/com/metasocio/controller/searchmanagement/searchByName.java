package com.metasocio.controller.searchmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.searchmanagement.SearchService;

/*********************************************************************************
 * @author Since : 02 December, 2015 
 * Description : Servlet implementation class SearchByName extending HttpServlet,
 *  Managing search by name
 **********************************************************************************/

@WebServlet("/searchByName")
public class searchByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#HttpServlet()
	 */
    public searchByName() {
        super();
        // TODO Auto-generated constructor stub
    }

    /********************************************************************************
	 * This method gets User list of search result from database and convert that
	 *  list into JSON Array then send this array to java script file.
	 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *****************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyToSearch = request.getParameter("search"); //get parameter from search text box 
		System.out.println(keyToSearch);
		String finalSearch = "";
		
		if (!((keyToSearch.trim()).equals(""))) {
			List<User> resultantUsers = new ArrayList<User>();//Array list of Users declaration 
			SearchService iSearchService = new SearchService();//Creating object of SearchService
			try {//Retrieving search result by calling method retrieveSearchResult existing in SearchService class
				resultantUsers = iSearchService.retrieveUsersByKey(keyToSearch);
			} catch (MetaSocioSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("object" +resultantUsers);
			
			for (User user : resultantUsers ) {
				System.out.println("Name:::::::::::::::::::::::::::::"+user.getName()+"imageURL"+user.getImageURL());
				String un = user.getName()  + user.getImageURL();
				finalSearch +=  un+"<br>" ;
			}
			//converting list of Users into JSONArray
			 JSONArray searchResultJsonObject=JSONArray.fromObject(resultantUsers);
			 System.out.println("hi my data is "+ searchResultJsonObject);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(new Gson().toJson(searchResultJsonObject));
			System.out.println("In search by name"+searchResultJsonObject);
		/*	response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(finalSearch);
		*/	
			System.out.println("----------------hi-------------------");
		} else{
			response.getWriter().write("");
		    System.out.println("------------hello--------");
	}
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
