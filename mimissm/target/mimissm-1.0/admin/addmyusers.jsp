<%--
  Created by IntelliJ IDEA.
  User: cdmin
  Date: 2024/2/24
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
  function fileChange(){//注意：此处不能使用jQuery中的change事件，因此仅触发一次，因此使用标签的：onchange属性
    alert("change");
    $.ajaxFileUpload({
      <%--url: "${pageContext.request.contextPath}/prod/ajaxImg.action",--%>
      url: '/prod/ajaxImg.action',//用于文件上传的服务器端请求地址
      secureuri: false,//一般设置为false
      fileElementId: 'pimage',//文件上传控件的id属性  <input type="file" id="pimage" name="pimage" />
      dataType: 'json',//返回值类型 一般设置为json
      success: function(obj) //服务器成功响应处理函数
      {
        alert(obj);
        $("#imgDiv").empty();  //清空原有数据
        //创建img 标签对象
        var imgObj = $("<img>");
        //给img标签对象追加属性
        imgObj.attr("src","/image_big/"+obj.imgurl);
        imgObj.attr("width","100px");
        imgObj.attr("height","100px");
        //将图片img标签追加到imgDiv末尾
        $("#imgDiv").append(imgObj);
        //将图片的名称（从服务端返回的JSON中取得）赋值给文件本框
        //$("#imgName").html(data.imgName);
      },
      error: function (e)//服务器响应失败处理函数
      {
        alert(e.message);
      }
    });
  }
</script>
<body>
<!--取出上一个页面上带来的page的值-->

<div id="addAll">
  <div id="nav">
    <p>用户管理>新增用户</p>
  </div>

  <div id="table">
    <form action="${pageContext.request.contextPath}/prod/save.action" enctype="multipart/form-data"
          method="post" id="myform">
      <table>
        <tr>
          <td class="one">用户名称</td>
          <td><input type="text" name="uname" class="two"></td>
        </tr>
        <!--错误提示-->
        <tr class="three">
          <td class="four"></td>
          <td><span id="unameerr"></span></td>
        </tr>
        <tr>
          <td class="one">密码</td>
          <td><input type="text" name="upass" class="two"></td>
        </tr>
        <!--错误提示-->
        <tr class="three">
          <td class="four"></td>
          <td><span id="upasserr"></span></td>
        </tr>
        <tr>
          <td class="one">用户状态</td>
          <td><input type="number" name="ustatus" class="two"></td>
        </tr>
        <!--错误提示-->
        <tr class="three">
          <td class="four"></td>
          <td><span id="ustatuserr"></span></td>
        </tr>
        <tr>
          <td class="one">用户等级</td>
          <td><input type="number" name="ulevel" class="two"></td>
        </tr>
        <!--错误提示-->
        <tr class="three">
          <td class="four"></td>
          <td><span id="ulevelerr"></span></td>
        </tr>

        <tr>
          <td class="one">积分</td>
          <td><input type="number" name="score" class="two"></td>
        </tr>
        <!--错误提示-->
        <tr class="three">
          <td class="four"></td>
          <td><span id="scoreerr"></span></td>
        </tr>

        <tr>
          <td>
            <input type="submit" value="提交" class="btn btn-success">
          </td>
          <td>
            <input type="reset" value="取消" class="btn btn-default" onclick="myclose(${param.page})">
            <script type="text/javascript">
              function myclose(ispage) {
                window.location="${pageContext.request.contextPath}/prod/split.action?page="+ispage;
              }
            </script>
          </td>
        </tr>
      </table>
    </form>
  </div>
</div>

</body>

</html>
