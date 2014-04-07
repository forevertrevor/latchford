/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.forevertrevor.mediaserver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pgsmith
 */
public class MediaServerServlet extends HttpServlet {
   
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
 
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        Set<String> paths =  req.getServletContext().getResourcePaths("/video");
        StringBuilder sb = new StringBuilder();
        Iterator iterator = paths.iterator();
        
        while(iterator.hasNext()){
            sb.append(iterator.next());
            sb.append(",\n");
        }
       sb.replace(sb.length()-2,sb.length(),"");  
       res.getWriter().print(sb.toString());
       
                
    }
    
}
