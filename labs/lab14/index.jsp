<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
  </head>
  <body>
  <div>
    <h1>Index webDAV</h1>
    <div>
      <br/>
      <span>Другов Антон Дмитриевич</span>
      <br/><br/>

      <a href="Aaa?action=mkcol">Create folder "NewFolder"</a>
      <br/><br/>
      <!--<a href="Aaa?action=upload">Upload file "test.docx"</a> Загрузить на яндекс диск -->
      <br>
      <form class="pure-form pure-form-stacked" method="post" action="/lab14/Aaa"
      enctype="multipart/form-data">
        <fieldset>
            <legend>File:</legend>
            <input type="file" name="myfile">
            <button type="submit" class="pure-button pure-button-primary">Upload file</button>
        </fieldset>
      </form>

      <br/><br/>
      <a href="Aaa?action=download">Download file "Bears.jpg"</a> <!-- Скачать с яндекс диска -->
      <br/><br/>
      <a href="Aaa?action=copy">Copy file "Bears.jpg" </a>
      <br/><br/>
      <a href="Aaa?action=deleteFile">Delete file "Bears.jpg"</a>
      <br/><br/>
      <a href="Aaa?action=deleteFolder">Delete folder "NewFolder"</a>
      <br/><br/>
     

    </div>
  </div>
  </body>
</html>
