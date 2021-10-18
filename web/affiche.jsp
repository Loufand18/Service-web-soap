<%-- 
    Document   : affiche
    Created on : 20 nov. 2020, 20:23:32
    Author     : fallou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills">
      <li class="nav-item">
        <a class="nav-link " href="index.jsp">Accueil</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#">Infos</a>
      </li>
      
    </ul>
  </div>
     <Center>      
    <div class=" rounded" >
         
             <div class="card text-center" style="width: 18rem;">
        <div class="card-body bg-primary">
             <% 
            String continent = (String) request.getAttribute("continent");
             %>
          <h6 class="card-title text-light"><% out.println( continent ); %></h6>
          
       </div>
     </div>
     </center> 
  <div class="card-body badge-light">
    
      <p class="card-title">
      
          
          
           <div class="card d-inline-flex p-2 bd-highlight" style="width: 560px;
                ">
               <ul class="list-group list-group-flush">
                   <% 
            String attribut = (String) request.getAttribute("test");
            String date = (String) request.getAttribute("date");
           String cas_contact=( String) request.getAttribute("cas_contact");
           String cas_importe=( String) request.getAttribute("cas_importe");
            String deces=( String) request.getAttribute("deces");
            String total=( String) request.getAttribute("total");
            String total_guerris=( String) request.getAttribute("total_guerris");
             String courbe=( String) request.getAttribute("courbe");
            %>
              <li class="list-group-item "> <h6 class="text-primary"><% out.println( attribut ); %></h6></li>
              <li class="list-group-item">Date premiere contamination: <h6 class="text-primary"><% out.println( date ); %></h5> 
                     
              </li>
              <li class="list-group-item">Nombre contaminations pour le jour precedent
                  
                      <span>Cas Contacts:<h6 class="text-primary"><% out.println( cas_contact ); %></h6> </span>
                       <span>Cas Importes:<h6 class="text-primary"><% out.println( cas_importe ); %></h6></span>
                  
              </li>
              <li class="list-group-item">Nombre Deces pour le jour prececedent:<h6 class="text-primary"><% out.println( deces ); %></h6> 
              </li>
              <li class="list-group-item">Total contamines depuis debut pandemie:<h6 class="text-primary"><% out.println( total ); %></h6></li>
               <li class="list-group-item">Total guerris:<h6 class="text-primary"><% out.println( total_guerris ); %></h6></li>
              </ul>
</div>
            
            
    </p>
    
  </div>

<div class="card">
  <div class="card-body">
    <img src="image/<% out.println(courbe); %>" class="card-img-bottom" alt="...">
  </div>
 
</div>        
    </body>
</html>
