<%--
    Document   : index
    Created on : 20 nov. 2020, 20:18:21
    Author     : fallou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.mysql.jdbc.Connection,javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" >
        <title>JSP Page</title>
    </head>
    <body>
       
        <div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills">
      <li class="nav-item">
        <a class="nav-link active" href="#">Acceuil</a>
      </li>
     
      
    </ul>
  </div>
  <div class="card-body bg-light">
      <h5 class="card-title">Les donnees du COVID-19 dans le monde</h5>
      <nav class="navbar navbar-light bg-primary">
  <a class="text-light">Ajouter un pays</a>
  <form class="form-inline" method="POST" action="Controller">
      <input class="form-control mr-sm-2" type="search" name="pays" placeholder="pays" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</nav>
 <div class="row">
     
    
    <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Nombres de cas confirmes</h5>
        <p class="card-text">58 425 681</p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Nombres de deces</h5>
        <p class="card-text">1,385,218</p>

      </div>
    </div>
  </div>
  
</div>
    <p class="card-text">
        <div class="card mb-12">
    
    
         
  <div class="row no-gutters">
   
    <div class="col-md-4">
      <div class="card-body">
          <img src="image/oms.jpg" class="card-img" style="height: 170px" alt="...">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">La maladie à coronavirus 2019 (COVID-19) est une ‎maladie infectieuse due à un coronavirus découvert ‎récemment. ‎
La majorité des personnes atteintes de la COVID-19 ‎ne ressentiront que des symptômes bénins ou ‎modérés et guériront sans traitement particulier. ‎</p>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        <img src="image/virus.jpg" style="height: 170px" class="card-img" alt="...">
      </div>
    </div>
       <div class="col-md-8">
      <img src="image/covid.jpg" class="card-img" alt="...">
    </div>
  </div>
</div>
    
    </p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
        
        
        
        
    
    </body>
</html>
