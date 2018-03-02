<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<div class="navbar-wrapper">
      <div class="container">

        <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${ctx}/login"><i class="glyphicon glyphicon-thumbs-up"></i>LinShiqin</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#"><i class="glyphicon glyphicon-home"></i>Home</a></li>
            <li><a href="#about"><i class="glyphicon glyphicon-film"></i>About</a></li>
            <li><a href="#contact"><i class="glyphicon glyphicon-earphone"></i>Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-list"></i> <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="${ctx}/ditu"><i class="glyphicon glyphicon-map-marker"></i>Your location</a></li>
                <li><a href="${ctx}/table/yearbaobiao?oneYear=2016"><i class="glyphicon glyphicon-credit-card"></i>My money</a></li> 
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">api connection</li>
                <li><a href="${ctx}/blog"><i class="glyphicon glyphicon-book"></i>Hot WeChat</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        <!--   <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Default</a></li>
            <li><a href="../navbar-static-top/">Static top</a></li>
            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
          </ul> -->
        </div><!--/.nav-collapse -->
      </div>
    </nav>


      </div>
    </div>