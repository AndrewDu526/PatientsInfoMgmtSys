package com.diy.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpLoadServet
 */
@WebServlet("/upLoadServet")
public class UpLoadServet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadServet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if(isMultipart)
        {
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            try {
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> it = items.iterator();
                while(it.hasNext())
                {
                    FileItem item = it.next();
                    String itemname = item.getFieldName();
                    int sno=-1;
                    String sname=null;

                    if(item.isFormField())
                    {
                        if(itemname.equals("sno"))
                        {
                            sno=Integer.parseInt(item.getString("utf-8"));
                        }else if(itemname.equals("sname"))
                        {
                            sname=item.getString("utf-8");
                            sname=item.getName();
                        }else
                        {
                            System.out.println("其他字段");
                        }
                    }else
                    {
                        String filename=item.getName();
                        //String path=request.getSession().getServletContext().getRealPath("upload");
                        String path="C:\\JavaStudy\\idea_workingSpace\\JavaWeb_last\\src\\main\\webapp\\models";
                        File file=new File(path,filename);
                        item.write(file);
                        request.setAttribute("news", filename+"上传成功,谢谢分享");
                        request.getRequestDispatcher("print.jsp").forward(request, response);
                        //System.out.println(filename+"上传成功!!!");
                        return;
                    }

                }
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}