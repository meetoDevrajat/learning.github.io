<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import= "java.util.*" %>
    <%@ page import = "com.login.model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<% List<Product> list = (ArrayList<Product>)session.getAttribute("productdetails"); %>
 <div class="table-responsive">          
  <table class="table table-striped">
    <thead>
      <tr>
       
      	 <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Rating</th>
        <th>Brand</th>
         <th>Add Product</th>
          <th>Remove</th>
           <th>View</th>
      </tr>
    </thead>
		<%for(Product p :list)
		{
			
			out.print("<tr><td>"+p.getName()+"</td><td>"+p.getCategory()+"</td><td>"+p.getPrice()+"</td><td>"+p.getRating()+"</td><td>"+p.getBrand()+"</td><td><a href=new>Add Product</a></td><td><a href=del?id="+p.getProductId()+">Remove Product</a></td><td><a href=view?id="+p.getProductId()+">View Description</a></td></tr>");
		}
		
		%>
  </table>
  </div>

	

</body>
</html>