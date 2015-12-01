package com.metasocio.authentication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.GooglePojo;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;
import com.metasocio.service.usermanagement.UserService;

@WebServlet("/OAuth")
public class OAuth extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OAuth() {
        super();
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        //System.out.println("entering doGet");
        try {
            // get code
            String code = request.getParameter("code");
            // format parameters to post
            String urlParameters = "code="
                    + code
                    + "&client_id=881126743057-0u1nhaqo1uk2dl0h0e9mpe3f9ptvmsa6.apps.googleusercontent.com"
                    + "&client_secret=Ekf3oFGdinXwa-zBbIs61Ycn"
                    + "&redirect_uri=http://localhost:8080/MetaSocio/OAuth"
                    + "&grant_type=authorization_code";
            
            //post parameters
            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            URLConnection urlConn = url.openConnection();
            urlConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(
                    urlConn.getOutputStream());
            writer.write(urlParameters);
            writer.flush();
            
            //get output in outputString 
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
            	outputString += line;
            }
          
            //System.out.println(outputString);
            
            //get Access Token 
            JsonObject json = (JsonObject)new JsonParser().parse(outputString);
            String access_token = json.get("access_token").getAsString();
           
           //System.out.println(access_token);

            //get User Info 
            url = new URL(
                    "https://www.googleapis.com/oauth2/v1/userinfo?access_token="
                            + access_token);
            urlConn = url.openConnection();
            outputString = "";
            reader = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream()));
           
            while ((line = reader.readLine()) != null) {
                //System.out.println("Hello : "+line);
                outputString += line;
            }
            //System.out.println(outputString);
            
            // Convert JSON response into Pojo class
            GooglePojo userDataObject = new Gson().fromJson(outputString, GooglePojo.class);
            
          /* --------------------------------- if(userDataObject.getHd().equals("metacube.com")) {
            	//System.out.println("************hi");
            	//System.out.println(".............Metacube Employee..........");
            	//System.out.println("**********************************getting session1");
            	
            	 //System.out.println("**********************************getting session2");*/
            boolean isUserExists=false;
            //System.out.println("**********************************getting session");
        	HttpSession session=request.getSession(true);
        	//System.out.println("**********************************after getting session");
            
            //MetaSocioService iService=new MetaSocioService();
        	UserService iUserService=new UserService();
                try {
                	
                	
                	//System.out.println("**********************************going to in exists method");
					isUserExists=iUserService.isEmailExists(userDataObject.getEmail());
					//System.out.println("**********************************come from  exists method");
				} catch (MetaSocioSystemException e) {
					// TODO Auto-generated catch block
					//System.out.println("["+e.getMessage()+"]");
				}
                
                
                if(isUserExists){
                	//System.out.println("*********************************exist");
                //	MetaSocio_Service isService=new MetaSocio_Service();
            		try {
            			//isService.setUserInfo(user);
            			//isService.setUserInfo(user);
            			User user=new User();
            			user.setEmailId(userDataObject.getEmail());
            			user.setName(userDataObject.getName());
            			user.setImageURL(userDataObject.getPicture());
            			session.setAttribute("userObject",user);
            			response.sendRedirect("./HomePage");
            			/*int userId = iService.getIdByEmail(userDataObject.getEmail());
            			//System.out.println("*****************************************userf");
            			List<User> users = iService.getUsersHavingSameDepartment(userId);
            			//System.out.println("*****************************************userf");
            			//System.out.println("***********************************users"+users);
            			//boolean checkFriends = isService.checkFriends(id,friends)
            			request.setAttribute("id",userId);
            			request.setAttribute("email", userDataObject.getEmail());
            			request.setAttribute("usersList", users);
            			//System.out.println("________________________________________home");
            			request.getRequestDispatcher("./view/postmanagement/home.jsp").forward(request, response);*/
            		} catch (Exception e) {
            			// TODO Auto-generated catch block
            			//System.out.println("_______________________________Exception");
            			//System.out.println("["+e.getMessage()+"]");;
            			request.setAttribute("message","["+e.getMessage()+"]");
            			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
            		}
                	
                }
                else{
                	/*request.setAttribute("name", userDataObject.getName());
                	request.setAttribute("email",userDataObject.getEmail());
                	request.setAttribute("picture", userDataObject.getPicture());*/
                	request.setAttribute("userDataObject", userDataObject);
                	request.getRequestDispatcher("./view/usermanagement/profile.jsp").forward(request, response);
                }
            	
            	
        /*    }
            else {
            	//System.out.println("Frzi Employee");
            	String message="Please login with your metacube id";
            	request.setAttribute("message", message);
            	request.getRequestDispatcher("./index.jsp").forward(request, response);
            	
            	
            }*/
            //System.out.println(userDataObject);
            writer.close();
            reader.close();
            
        } catch (MalformedURLException e) {
        	//System.out.println("hi1");
            //System.out.println("["+e.getMessage()+"]");
            
        } catch (ProtocolException e) {
        	//System.out.println("hi2");
        	  //System.out.println("["+e.getMessage()+"]");
        } catch (IOException e) {
        	//System.out.println("hi3");
        	  //System.out.println("["+e.getMessage()+"]");
        }
        //System.out.println("leaving doGet");
    }

}