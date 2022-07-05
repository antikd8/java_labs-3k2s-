<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%! public void GetDirectory(String a_Path, Vector a_files, Vector a_folders) {
    File l_Directory = new File(a_Path);
    File[] l_files = l_Directory.listFiles();

    for (int c = 0; c < l_files.length; c++) {
        if (l_files[c].isDirectory()) {
            a_folders.add(l_files[c].getName());
        } else {
            a_files.add(l_files[c].getName());
        }
    }


}
%>

<%
    Vector l_Files = new Vector(), l_Folders = new Vector();
    String docdir = getServletContext().getInitParameter("globaldoc-dir");//localdoc-dir

    GetDirectory(docdir, l_Files, l_Folders);

    String str = "";
    //generate files as XML
    out.println("<div>");

    for (int a = 0; a < l_Files.size(); a++) {
        str += "/lab13/Sss?wf=" + l_Files.elementAt(a).toString();
        out.println("<a href='" + str + "'>" + l_Files.elementAt(a).toString() + "</a<br><br>");
        str = "";
    }
    out.println("</div>");
    out.println("<br><br><a href='/lab13/jsp/uploadFile1.html'> Zadanie2 </a>");
%>